<template>
  <div>
    <v-row>
      <v-col cols="6">
        <v-menu
          v-model="startMenu"
          :close-on-content-click="false"
          :return-value.sync="tempPlan.startDate"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="tempPlan.startDate"
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
        </v-menu>
      </v-col>
    </v-row>

    <v-tabs show-arrows height="100%" hide-slider>
      <v-tab v-for="n in steps" :key="n" class="px-2">
        <v-card outlined>
          <v-card-title> {{ n }} 일차 </v-card-title>
          <v-card-subtitle> {{ getStepDate(n) }} </v-card-subtitle>
        </v-card>
      </v-tab>

      <v-tab-item v-for="n in steps" :key="n">
        <v-row style="backgroud-color: pink">
          <div>안녕</div>
        </v-row>
      </v-tab-item>
    </v-tabs>
  </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';

const planStore = "planStore";

export default {
  name: "PlanEditRoute",
  data() {
    return {
      steps: 1,
      startMenu: false,
      newStartDate: "",
      newEndDate: "",
    };
  },
  watch: {
    startDate: {
      handler() {
        this.updateSteps();
      },
      immediate: true,
    },
    endDate: {
      handler() {
        this.updateSteps();
      },
      immediate: true,
    },
  },
  methods: {
    ...mapActions(planStore, ["updateDateAction"]),

    updateSteps() {
      const start = new Date(this.tempPlan.startDate);
      const end = new Date(this.tempPlan.endDate);
      const diffTime = Math.abs(end - start);
      const diffDays = Math.ceil(diffTime / (1000 * 60 * 60 * 24));
      this.steps = diffDays + 1;
    },
    getStepDate(n) {
      const start = new Date(this.tempPlan.startDate);
      start.setDate(start.getDate() + (n - 1));
      const year = start.getFullYear().toString().slice(-2);
      const month = (start.getMonth() + 1).toString().padStart(2, "0");
      const day = start.getDate().toString().padStart(2, "0");
      return `${year}-${month}-${day}`;
    },
    updateDate() {
      this.tempPlan.startDate = this.newStartDate;
      this.startMenu = false;
      let body = {
        startDate : this.newStartDate,
        endData: this.newEndDate,
      }
      console.log(body)
      this.updateDateAction(body);

    },
  },
  computed:{
    ...mapState(planStore, ["tempPlan"])
  }
};
</script>

<style>
/* Style code */
</style>
