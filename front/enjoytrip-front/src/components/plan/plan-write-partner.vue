<template>
  <v-container>
    <v-row class="pa-3">
      <v-col cols="4" v-if="tempPlan.thumnail !== null">
        <v-img :src="tempPlan.thumnail" max-height="300" max-width="300" contain></v-img>
      </v-col>
      <v-col cols="12">
        <v-btn elevation="0" color="primary" class="my-8" @click="addPlan" width="100%">
          <v-icon>mdi-plus</v-icon>
          <span class="pl-1">여행 생성하기</span>
        </v-btn>
        <v-card-title class="py-3"> 동행자를 추가하세요 </v-card-title>
        <v-flex>
          <v-item-group>
            <v-item v-for="(partner, index) in tempPlan.partners" :key="index">
              <v-chip
                class="ma-2"
                close
                color="green"
                outlined
                @click:close="deletePartner(partner.userId)"
              >
                {{ partner.userNickname }}
              </v-chip>
            </v-item>
          </v-item-group>
        </v-flex>

        <v-list-item class="mt-4">
          <v-row>
            <v-col cols="4">
              <v-select :items="category" label="검색 조건" v-model="searchCategory"></v-select>
            </v-col>
            <v-spacer />
            <v-col cols="4">
              <v-text-field
                v-model="searchKeyword"
                label="키워드"
                outlined
                clearable
              ></v-text-field>
            </v-col>
            <v-col cols="3"> <v-btn @click="searchUser">검색</v-btn> </v-col>
          </v-row>
        </v-list-item>
        <v-list-item> <v-divider /> </v-list-item>
        <v-subheader class="align-center">사용자 목록</v-subheader>
        <div v-for="(user, index) in users" :key="index">
          <v-list-item class="ma-n3 pa-n3">
            <v-list-item-avatar>
              <v-img :alt="`${user.userId} avatar`" :src="user.userProfile"></v-img>
            </v-list-item-avatar>
            <v-list-item-content>
              <span>{{ user.userId }} </span>
            </v-list-item-content>
            <v-list-item-content>
              <span>{{ user.userNickname }}</span>
            </v-list-item-content>

            <v-list-item-action>
              <v-btn elevation="0" color="primary" class="mr-5" @click="addPartner(user)">
                <v-icon>mdi-plus</v-icon>
                <span class="pl-1">초대하기</span>
              </v-btn>
            </v-list-item-action>
          </v-list-item>
          <v-list-item class="ma-n2 pa-n2"> <v-divider /> </v-list-item>
        </div>
        <v-card-text class="py-0 m-2"> ! 동행은 나중에도 추가할 수 있습니다. </v-card-text>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex";
import { searchUserApi } from "@/api/user";
import { postPlanApi, postPlanPartner } from "@/api/plan";

const planStore = "planStore";
const userStore = "userStore";

export default {
  name: "PlanWritePartner",
  data() {
    return {
      searchKeyword: "",
      searchCategory: "",
      category: ["아이디", "닉네임"],
      users: [
        {
          userId: "",
          userNickname: "",
          userProfile: "",
        },
      ],
    };
  },
  computed: {
    ...mapState(userStore, ["userId"]),
    ...mapState(planStore, ["tempPlan"]),
  },
  methods: {
    ...mapActions(planStore, ["addPatnerAction", "deletePartnerAction"]),
    searchUser() {
      if (this.searchCategory === "") {
        alert("검색 조건을 선택해주세요.");
        return;
      }
      let param = {};
      if (this.searchCategory === "아이디") {
        param = { userId: this.searchKeyword };
      } else {
        param = { userNickname: this.searchKeyword };
      }
      searchUserApi(
        param,
        (data) => {
          this.users = data.data;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    addPartner(partnerInfo) {
      this.addPatnerAction(partnerInfo);
    },
    deletePartner(partnerId) {
      this.deletePartnerAction(partnerId);
    },
    addPlan() {
      let body = {
        userId: this.userId,
        planTitle: this.tempPlan.title,
        startDate: this.tempPlan.dates[0],
        endDate: this.tempPlan.dates[1],
        file: this.tempPlan.file,
        image: null,
      };
      postPlanApi(
        body,
        (data) => {
          // edit,
          let planId = data.data;
          // 추가할 파트너가 있다면 추가하기
          if (this.tempPlan.partners.length !== 0) {
            let temp = {
              partners: this.tempPlan.partners,
              planId: planId,
            };

            postPlanPartner(
              temp,
              () => {
                this.$router.push(`/plan/edit/${planId}`);
              },
              (error) => {
                console.log(error);
              }
            );
          } else {
            // 추가할 파트너 없으면 바로 이동
            this.$router.push(`/plan/edit/${planId}`);
          }
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>
