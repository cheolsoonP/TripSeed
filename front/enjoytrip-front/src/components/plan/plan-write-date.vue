<template>
  <v-container>
    <v-row justify="center">
      <v-col cols="12" md="6">
        <v-menu
          v-model="startMenu"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="tempPlan.dates[0]"
              label="시작일"
              prepend-icon="mdi-calendar"
              v-bind="attrs"
              v-on="on"
              hide-details
            ></v-text-field>
          </template>
          <v-date-picker v-model="tempPlan.dates[0]" @input="startMenu = false"></v-date-picker>
        </v-menu>
      </v-col>
      <v-col cols="12" md="6">
        <v-menu
          v-model="endMenu"
          :close-on-content-click="false"
          :nudge-right="40"
          transition="scale-transition"
          offset-y
          min-width="auto"
        >
          <template v-slot:activator="{ on, attrs }">
            <v-text-field
              v-model="tempPlan.dates[1]"
              label="종료일"
              prepend-icon="mdi-calendar"
              v-bind="attrs"
              v-on="on"
              hide-details
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="tempPlan.dates[1]"
            @input="startMenu = false"
            :min="tempPlan.dates[0]"
          ></v-date-picker>
        </v-menu>
      </v-col>
    </v-row>
    <v-row>
      <v-col cols="12">
        <v-date-picker
          v-model="tempPlan.dates"
          range
          show-adjacent-months
          full-width
          no-title
          locale="ko"
          @change="onChangeDate"
        ></v-date-picker>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapActions, mapState } from "vuex";

const planStore = "planStore";

let today = new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
  .toISOString()
  .substr(0, 10);

export default {
  name: "PlanWriteDate",
  computed: {
    ...mapState(planStore, ["tempPlan"]),
  },
  data: () => ({
    dates: [today, today],
    startMenu: false,
    endMenu: false,
  }),
  methods: {
    ...mapActions(planStore, ["updateDateAction"]),
    onChangeDate(e) {
      let dates = [];
      if (e[0] < e[1]) dates = [e[0], e[1]];
      else dates = [e[1], e[0]];
      this.updateDateAction(dates);
    },
  },
};
</script>
