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
          <div v-if="upcomingPlans.length <= 0"></div>
          <v-container v-else id="coming-plan">
            <h2>다가오는 여행이 {{ upcomingPlans.length - 1 }}개 있어요!</h2>
            <v-window show-arrows>
              <template v-slot:prev="{ on, attrs }">
                <v-btn fab v-bind="attrs" v-on="on">
                  <v-icon>mdi-chevron-left</v-icon>
                </v-btn>
              </template>
              <template v-slot:next="{ on, attrs }">
                <v-btn fab v-bind="attrs" v-on="on">
                  <v-icon>mdi-chevron-right</v-icon>
                </v-btn>
              </template>
              <v-window-item v-for="n in upcomingPlans.length - 1" :key="`card-${n}`">
                <v-col class="pa-0">
                  <plan-list-item :planInfo="upcomingPlans[n]" :isSmall="true" />
                </v-col>
              </v-window-item>
            </v-window>
          </v-container>

          <v-container>
            <h1>나의 여행</h1>
            <v-container class="pa-0 my-4" id="my-current">
              <h2>{{ currentPlans.length }}개의 여행 계획</h2>
              <v-window show-arrows>
                <template v-slot:prev="{ on, attrs }">
                  <v-btn fab v-bind="attrs" v-on="on">
                    <v-icon>mdi-chevron-left</v-icon>
                  </v-btn>
                </template>
                <template v-slot:next="{ on, attrs }">
                  <v-btn fab v-bind="attrs" v-on="on">
                    <v-icon>mdi-chevron-right</v-icon>
                  </v-btn>
                </template>
                <v-window-item v-for="n in Math.ceil(currentPlans.length / 2)" :key="`card-${n}`">
                  <v-row>
                    <v-col cols="6" class="pa-0">
                      <plan-list-item :planInfo="currentPlans[(n - 1) * 2]" :isSmall="true" />
                    </v-col>
                    <v-col cols="6" class="pa-0" v-if="currentPlans[(n - 1) * 2 + 1]">
                      <plan-list-item :planInfo="currentPlans[(n - 1) * 2 + 1]" :isSmall="true" />
                    </v-col>
                    <v-col
                      cols="6"
                      v-else-if="
                        n === Math.ceil(currentPlans.length / 2) && currentPlans.length % 2 === 1
                      "
                    >
                    </v-col>
                  </v-row>
                </v-window-item>
              </v-window>
            </v-container>

            <v-container class="pa-0 pt-2 my-4" id="my-past">
              <h2>{{ pastPlans.length }}개의 지난 일정</h2>
              <v-window show-arrows>
                <template v-slot:prev="{ on, attrs }">
                  <v-btn fab v-bind="attrs" v-on="on">
                    <v-icon>mdi-chevron-left</v-icon>
                  </v-btn>
                </template>
                <template v-slot:next="{ on, attrs }">
                  <v-btn fab v-bind="attrs" v-on="on">
                    <v-icon>mdi-chevron-right</v-icon>
                  </v-btn>
                </template>
                <v-window-item v-for="n in Math.ceil(pastPlans.length / 2)" :key="`card-${n}`">
                  <v-row>
                    <v-col cols="6" class="pa-0">
                      <plan-list-item :planInfo="pastPlans[(n - 1) * 2]" :isSmall="true" />
                    </v-col>
                    <v-col cols="6" class="pa-0" v-if="pastPlans[(n - 1) * 2 + 1]">
                      <plan-list-item :planInfo="pastPlans[(n - 1) * 2 + 1]" :isSmall="true" />
                    </v-col>
                    <v-col
                      cols="6"
                      v-else-if="
                        n === Math.ceil(pastPlans.length / 2) && pastPlans.length % 2 === 1
                      "
                    >
                    </v-col>
                  </v-row>
                </v-window-item>
              </v-window>
            </v-container>
          </v-container>
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
    upcomingPlans() {
      let oneWeekFromNow = new Date();
      oneWeekFromNow.setDate(oneWeekFromNow.getDate() + 7);
      return this.plans.filter(
        (plan) =>
          new Date(plan.startDate) > new Date() && new Date(plan.startDate) <= oneWeekFromNow
      );
    },
    pastPlans() {
      return this.plans.filter((plan) => new Date(plan.endDate) < new Date());
    },
    currentPlans() {
      return this.plans.filter((plan) => new Date(plan.endDate) >= new Date());
    },
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
