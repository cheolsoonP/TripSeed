<template>
  <div>
    <v-card class="mx-auto" max-width="80%">
      <v-toolbar color="primary" dark>
        <h2>사용자 검색</h2>
      </v-toolbar>
      <v-list subheader>
        <v-list-item class="my-5">
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
              <v-btn elevation="0" color="primary" class="mr-5" @click="addFollow(user.userId)">
                <v-icon>mdi-plus</v-icon>
                <span class="pl-1">팔로우</span>
              </v-btn>
            </v-list-item-action>
          </v-list-item>
          <v-list-item class="ma-n2 pa-n2"> <v-divider /> </v-list-item>
        </div>
      </v-list>
    </v-card>
  </div>
</template>

<script>
import { searchUserApi, addFollowUserApi } from "@/api/user";
import { mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "UserSearch",
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
  },
  methods: {
    searchUser() {
      let param = {};
      if (this.searchCategory === "아이디") {
        param = { userId: this.searchKeyword };
      } else {
        param = { userNickname: this.searchKeyword };
      }
      searchUserApi(
        param,
        (data) => {
          console.log(data);
          this.users = data.data;
        },
        (error) => {
          console.log(error);
        }
      );
    },
    addFollow(followingUserId) {
      let body = {
        userId: this.userId,
        followingUserId: followingUserId,
      };

      console.log(body);

      addFollowUserApi(
        body,
        () => {
          alert(`${followingUserId}님에게 팔로우 신청하였습니다.`);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style></style>
