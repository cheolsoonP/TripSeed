<template>
  <div>
    <v-row>
      <v-col cols="6">
        <!-- <v-menu
          v-model="startMenu"
          :close-on-content-click="false"
          :return-value.sync="plan.startDate"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="plan.startDate"
              label="시작일"
              prepend-icon="mdi-calendar"
              readonly
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker v-model="newStartDate" no-title scrollable>
            <v-spacer></v-spacer>
            <v-btn text color="primary" @click="startMenu = false">
              Cancel
            </v-btn>
            <v-btn text color="primary" @click="updateDate"> OK </v-btn>
          </v-date-picker>
        </v-menu> -->
      </v-col>
    </v-row>

    <v-tabs show-arrows height="100%" hide-slider>
      <v-tab v-for="(date, i) in dates" :key="i" class="px-2">
        <v-card outlined>
          <v-card-title> {{ i + 1 }} 일차 </v-card-title>
          <v-card-subtitle> {{ date }} </v-card-subtitle>
        </v-card>
      </v-tab>

      <v-tab-item v-for="(date, i) in dates" :key="i">
        <v-row style="backgroud-color: pink">
          <v-col cols="12" md="4">
            <v-list dense nav height="50vh">
              <v-list-item v-for="(route, index) in routes" :key="index">
                <div v-if="date === route.visitDate">
                  {{ route.title }}
                </div>
              </v-list-item>
            </v-list>
          </v-col>
        </v-row>
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
import { getPlanDetailApi, getRouteApi } from "@/api/plan.js";

export default {
  name: "PlanEditRoute",
  data() {
    return {
      plan: {},
      routes: [],
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
      },
      (error) => {
        console.log(error);
      }
    );
    getRouteApi(
      planId,
      ({ data }) => {
        console.log(data);
        this.routes = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
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
  },
};
</script>

<style>
/* Style code */
</style>
