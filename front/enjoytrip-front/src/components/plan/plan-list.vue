<template>
  <v-container>
    <div>
      <header-bar
        title="나만의 여행 계획"
        content="나만의 여행 계획을 세워보세요.<br/>친구를 초대해 일정을 공유할 수 있어요."
        url="/plan/write"
        btn_icon="mdi-plus"
        btn_text="일정 생성"
        :imgsrc="headerImage"
      />
    </div>
    <v-row>
      <v-col cols="3"><plan-side-bar /></v-col>
      <v-col cols="9">
        <v-list>
          <div>
            <v-list-item-title>다가오는 여행</v-list-item-title>
            <plan-list-item :planInfo="plans[0]" :isSmall="false" />
          </div>
          <v-row>
            <v-col cols="3"><v-list-item-title>나의 여행</v-list-item-title></v-col>
            <v-spacer></v-spacer>
            <v-col cols="1">
              <v-btn text>
                <v-icon>mdi-plus</v-icon>
                <span class="pl-1">더보기</span>
              </v-btn>
            </v-col>
          </v-row>
          <v-row class="d-flex-row">
            <v-col cols="6"><plan-list-item :planInfo="plans[1]" :isSmall="true" /></v-col>
            <v-col cols="6"><plan-list-item :planInfo="plans[2]" :isSmall="true" /></v-col>
          </v-row>
        </v-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex";
import PlanSideBar from "@/components/bar/plan-side-bar.vue";
import PlanListItem from "@/components/plan/plan-list-item";
import HeaderBar from "@/components/bar/header-bar.vue";
const planStore = "planStore";
const userStore = "userStore";

export default {
  components: { PlanSideBar, PlanListItem, HeaderBar },
  data() {
    return {
      headerImage: process.env.VUE_APP_BUCKET_BASE_URL + "HeaderBarImg.png",
    };
  },
  computed: {
    ...mapState(userStore, ["userId"]),
    ...mapState(planStore, ["plans"]),
  },
  created() {
    this.getPlanListAction(this.userId);
    console.log(this.plans);
  },
  methods: {
    ...mapActions(planStore, ["getPlanListAction"]),
  },
};
</script>

<style></style>
