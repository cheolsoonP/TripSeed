<template>
  <v-row class="ml-3 mt-1 pl-5" align="center" style="min-width: 250px">
    <v-col cols="auto" class="pa-0">
      <v-list-item-avatar>
        <v-icon v-if="attraction.firstImage2 === ''" color="primary">mdi-sprout</v-icon>
        <v-img v-else :src="attraction.firstImage2" />
      </v-list-item-avatar>
    </v-col>
    <v-col class="pa-0" cols="8">
      <v-list-item-content>
        <v-list-item-title>{{ attraction.title }}</v-list-item-title>
        <v-list-item-subtitle>
          {{ attraction.addr1 }}
        </v-list-item-subtitle>
      </v-list-item-content>
    </v-col>
    <!-- <v-spacer /> -->
    <v-col cols="2" class="my-3">
      <v-row>
        <v-btn outlined icon tile elevation="0" color="primary" @click="orderUp">
          <v-icon>mdi-menu-up</v-icon>
        </v-btn>
      </v-row>
      <v-row>
        <v-btn outlined icon tile elevation="0" color="primary" @click="deleteRoute">
          <v-icon>mdi-minus</v-icon>
        </v-btn>
      </v-row>
      <v-row>
        <v-btn outlined icon tile elevation="0" color="primary" @click="orderDown">
          <v-icon>mdi-menu-down</v-icon>
        </v-btn>
      </v-row>
    </v-col>
  </v-row>
</template>

<script>
import { mapActions } from "vuex";

const planStore = "planStore";

export default {
  name: "PlanEditRouteItem",
  data() {
    return {};
  },
  props: {
    attraction: Object,
  },
  methods: {
    ...mapActions(planStore, ["deleteRouteAction", "orderUpAction", "orderDownAction"]),
    deleteRoute() {
      this.deleteRouteAction(this.attraction);
    },
    orderUp() {
      this.orderUpAction(this.attraction);
    },
    orderDown() {
      this.orderDownAction(this.attraction);
    },
  },
};
</script>

<style></style>
