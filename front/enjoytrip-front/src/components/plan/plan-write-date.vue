<template>
  <v-container>
    <v-row>
      <v-col cols="12" sm="6">
        <v-date-picker v-model="dates" range></v-date-picker>
      </v-col>
      <v-col cols="12" sm="6">
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
              v-model="dates[0]"
              label="시작일"
              prepend-icon="mdi-calendar"
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="dates[0]"
            @input="startMenu = false"
          ></v-date-picker>
        </v-menu>
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
              v-model="dates[1]"
              label="종료일"
              prepend-icon="mdi-calendar"
              v-bind="attrs"
              v-on="on"
            ></v-text-field>
          </template>
          <v-date-picker
            v-model="dates[1]"
            @input="startMenu = false"
            :min="dates[0]"
          ></v-date-picker>
        </v-menu>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
let today = new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
  .toISOString()
  .substr(0, 10);

export default {
  name: "PlanWriteDate",
  data: () => ({
    dates: [today, today],
    startMenu: false,
    endMenu: false,
  }),
};
</script>
