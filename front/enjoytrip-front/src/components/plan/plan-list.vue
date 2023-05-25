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
          <v-container>
            <h1>다가오는 여행</h1>
            <div v-if="upcomingPlans.length <= 0">
              <h5>없음</h5>
            </div>
            <v-row v-else>
              <h5>{{ upcomingPlans.length - 1 }}</h5>
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
                <v-window-item
                  v-for="n in upcomingPlans.length - 1"
                  :key="`card-${n}`"
                >
                  <v-col>
                    <plan-list-item
                      :planInfo="upcomingPlans[n]"
                      :isSmall="true"
                    />
                  </v-col>
                </v-window-item>
              </v-window>
            </v-row>
          </v-container>

          <v-container>
            <h1>여행 계획</h1>
            <h5>{{ currentPlans.length }}</h5>
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
              <v-window-item
                v-for="n in Math.ceil(currentPlans.length / 2)"
                :key="`card-${n}`"
              >
                <v-row>
                  <v-col cols="6">
                    <plan-list-item
                      :planInfo="currentPlans[(n - 1) * 2]"
                      :isSmall="true"
                    />
                  </v-col>
                  <v-col cols="6" v-if="currentPlans[(n - 1) * 2 + 1]">
                    <plan-list-item
                      :planInfo="currentPlans[(n - 1) * 2 + 1]"
                      :isSmall="true"
                    />
                  </v-col>
                  <v-col
                    cols="6"
                    v-else-if="
                      n === Math.ceil(currentPlans.length / 2) &&
                      currentPlans.length % 2 === 1
                    "
                  >
                  </v-col>
                </v-row>
              </v-window-item>
            </v-window>
          </v-container>

          <v-container>
            <h1>지난 여행 일정</h1>
            <h5>{{ pastPlans.length }}</h5>
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
              <v-window-item
                v-for="n in Math.ceil(pastPlans.length / 2)"
                :key="`card-${n}`"
              >
                <v-row>
                  <v-col cols="6">
                    <plan-list-item
                      :planInfo="pastPlans[(n - 1) * 2]"
                      :isSmall="true"
                    />
                  </v-col>
                  <v-col cols="6" v-if="pastPlans[(n - 1) * 2 + 1]">
                    <plan-list-item
                      :planInfo="pastPlans[(n - 1) * 2 + 1]"
                      :isSmall="true"
                    />
                  </v-col>
                  <v-col
                    cols="6"
                    v-else-if="
                      n === Math.ceil(pastPlans.length / 2) &&
                      pastPlans.length % 2 === 1
                    "
                  >
                  </v-col>
                </v-row>
              </v-window-item>
            </v-window>
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
          new Date(plan.startDate) > new Date() &&
          new Date(plan.startDate) <= oneWeekFromNow
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
