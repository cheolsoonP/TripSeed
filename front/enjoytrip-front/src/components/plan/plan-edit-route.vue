<template>
  <div>
    <v-row>
      <v-col cols="6"> </v-col>
    </v-row>

    <v-tabs show-arrows height="100%">
      <v-tab v-for="(date, i) in dates" :key="i" class="px-2" @click="selectTab(date)">
        <v-card outlined>
          <v-card-title> {{ i + 1 }} 일차 </v-card-title>
          <v-card-subtitle> {{ date }} </v-card-subtitle>
        </v-card>
      </v-tab>

      <v-tab-item v-for="(date, i) in dates" :key="i">
        <v-list dense nav height="50vh">
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
import { getPlanDetailApi } from "@/api/plan.js";
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
    };
  },
  created() {
    let planId = this.$route.params.planId;
    getPlanDetailApi(
      planId,
      ({ data }) => {
        console.log(data);
        this.plan = data;
        this.makeDates();
        this.initPlanEditRouteAction(this.plan.startDate);
      },
      (error) => {
        console.log(error);
      }
    );
    this.getRouteAction(planId);
  },
  computed: {
    ...mapState(planStore, ["activeTabDate"]),
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
  },
};
</script>

<style>
/* Style code */
</style>
