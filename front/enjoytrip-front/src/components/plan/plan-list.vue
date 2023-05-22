<template>
  <v-container>
    <div>
      <header-bar
        title = "나만의 여행 계획"
        content = "나만의 여행 계획을 세워보세요.<br/>친구를 초대해 일정을 공유할 수 있어요."
        url="/plan/write"
        btn_icon="mdi-plus"
        btn_text="일정 생성"
        :imgsrc="headerImage"
      />
    </div>
    <v-row>
    
      <v-col cols="3"><plan-side-bar/></v-col>
      <v-col cols="9">
        <v-list>
          <v-list-item v-for="planInfo, index in plans" :key="index">
            <plan-list-item :planInfo="planInfo"/>
          </v-list-item>
        </v-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex"
import PlanSideBar from "@/components/bar/plan-side-bar.vue"
import PlanListItem from "@/components/plan/plan-list-item"
import HeaderBar from "@/components/bar/header-bar.vue";
const planStore = "planStore";
const userStore = "userStore";

export default {
  components: { PlanSideBar, PlanListItem, HeaderBar },
  data() {
    return {
      headerImage: process.env.VUE_APP_BUCKET_BASE_URL + "HeaderBarImg.png",

    }
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
  }
}
</script>

<style>

</style>