<template>
  <div>
    <v-row class="ma-2">
      <v-col class="align-center">
        <v-btn width="80%" color="primary" @click="updateRoutes">수정완료</v-btn>
      </v-col>
    </v-row>

    <v-tabs show-arrows height="100%">
      <v-tab v-for="(date, i) in dates" :key="i" class="px-2" @click="selectTab(date)">
        <v-card outlined>
          <v-card-title> {{ i + 1 }} 일차 </v-card-title>
          <v-card-subtitle> {{ date }} </v-card-subtitle>
        </v-card>
      </v-tab>

      <v-tab-item v-for="(date, i) in dates" :key="i">
        <v-list dense nav height="60vh" style="overflow-x: hidden; overflow-y: auto">
          <div v-for="(route, index) in sortOrderRoutes" :key="index">
            <v-list-item v-if="date === route.visitDate">
              <plan-edit-route-item :attraction="route" />
            </v-list-item>
          </div>
        </v-list>
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
import { getPlanDetailApi, updateRouteApi } from "@/api/plan.js";
import { mapState, mapActions, mapGetters } from "vuex";
import PlanEditRouteItem from "./plan-edit-route-item.vue";
const planStore = "planStore";

export default {
  name: "PlanEditRoute",
  components: { PlanEditRouteItem },
  data() {
    return {
      plan: {},
      dates: [],
      startMenu: false,
      planId: "",
    };
  },
  created() {
    this.planId = this.$route.params.planId;

    getPlanDetailApi(
      this.planId,
      ({ data }) => {
        console.log(data);
        this.plan = data;
        this.initPlanEditRouteAction(this.plan.startDate);
        this.makeDates();

        this.getRouteAction(
          this.planId,
          ({ data }) => {
            console.log(data);
          },
          () => {}
        );
      },
      (error) => {
        console.log(error);
      }
    );
  },
  computed: {
    ...mapState(planStore, ["activeTabDate", "routes"]),
    ...mapGetters(planStore, ["sortOrderRoutes"]),
  },
  methods: {
    ...mapActions(planStore, [
      "initPlanEditRouteAction",
      "getRouteAction",
      "setActiveTabDateAction",
    ]),

    makeDates() {
      const startDate = new Date(this.plan.startDate);
      const endDate = new Date(this.plan.endDate);
      const dates = [];
      let currentDate = startDate;
      while (currentDate <= endDate) {
        const year = currentDate.getFullYear().toString();
        const month = (currentDate.getMonth() + 1).toString().padStart(2, "0");
        const day = currentDate.getDate().toString().padStart(2, "0");
        dates.push(`${year}-${month}-${day}`);
        currentDate.setDate(currentDate.getDate() + 1);
      }
      this.dates = dates;
    },
    selectTab(date) {
      this.setActiveTabDateAction(date);
    },
    updateRoutes() {
      let body = {
        planId: this.planId,
        routes: this.sortOrderRoutes,
      };
      updateRouteApi(
        body,
        () => {
          alert("여행 계획 생성 완료!");
          this.$router.push("/plan");
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style>
/* Style code */
</style>
