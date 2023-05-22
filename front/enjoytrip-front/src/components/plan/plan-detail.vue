<template>
  <v-container>
    <v-row class="my-5">
      <!-- 왼쪽 -->
      <v-col cols="12" md="8">
        <v-row class="text-h3 justify-center">{{ plan.planTitle }}</v-row>
        <v-row>
          <v-col cols="3">
            <v-list-item class="text-h6 justify-start"> <span>시작</span></v-list-item>
            <v-list-item class="justify-start">
              <v-chip color="primary" outlined large>{{ plan.startDate }}</v-chip>
              <!-- <span class="rounded-pill primary mx-2 pa-3 date">{{ plan.startDate }}</span> -->
            </v-list-item>
          </v-col>
          <v-col cols="3">
            <v-list-item class="text-h6 justify-start"> <span>종료</span></v-list-item>
            <v-list-item class="justify-start">
              <v-chip color="primary" outlined large>{{ plan.endDate }}</v-chip>
            </v-list-item>
          </v-col>
          <v-col cols="4">
            <v-btn elevation="0" color="primary">
              <v-icon>mdi-plus</v-icon>
              <span class="pl-1">동행 초대하기</span>
            </v-btn>
          </v-col>
        </v-row>
        <!-- 카카오 맵 -->
        <v-row class="justify-center">
          <plan-detail-map :routes="routes"></plan-detail-map>
        </v-row>
      </v-col>
      <!-- 오른쪽 -->
      <v-col cols="12" md="4">
        <v-list dense nav height="50vh">
          <v-list-item v-for="(route, index) in routes" :key="index">
            <route-item :route="route"></route-item>
          </v-list-item>
        </v-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { getPlanDetailApi, getRouteApi } from "@/api/plan.js";
import routeItem from "@/components/plan/route-item.vue";
import PlanDetailMap from "./plan-detail-map.vue";
export default {
  name: "PlanDetail",
  components: { routeItem, PlanDetailMap },
  data() {
    return {
      plan: {},
      routes: [
        {
          addr: "",
          attractionId: "",
          image: "",
          latitude: "",
          longitude: "",
          memo: "",
          title: "",
          visitOrder: "",
        },
      ],
    };
  },
  created() {
    let planId = this.$route.params.planId;
    getPlanDetailApi(
      planId,
      ({ data }) => {
        console.log(data);
        this.plan = data;
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
};
</script>

<style></style>
