<template>
  <v-container>
    <v-row class="my-5">
      <!-- 왼쪽 -->
      <v-col cols="12" md="6">
        <v-row class="text-h3 justify-center">{{ plan.planTitle }}</v-row>
        <v-row>
          <v-col cols="8" class="d-flex justify-center align-center">
            <v-col cols="auto">
              <v-list-item class="text-h6 justify-center"> <span>시작일</span></v-list-item>
              <v-list-item>
                <v-chip color="primary" outlined large>
                  <div class="px-2">{{ plan.startDate }}</div>
                </v-chip>
                <!-- <span class="rounded-pill primary mx-2 pa-3 date">{{ plan.startDate }}</span> -->
              </v-list-item>
            </v-col>
            <v-col cols="auto">
              <v-list-item class="text-h6 justify-center"> <span>종료일</span></v-list-item>
              <v-list-item>
                <v-chip color="primary" outlined large>
                  <div class="px-2">{{ plan.endDate }}</div>
                </v-chip>
              </v-list-item>
            </v-col>
          </v-col>
          <v-col cols="4" class="justify-center">
            <v-row class="pa-2 mt-2 d-flex justify-center">
              <v-btn elevation="0" color="primary" rounded large>
                <v-icon class="pr-1">mdi-account-plus</v-icon>
                <span class="px-1">동행 초대</span>
              </v-btn>
            </v-row>
            <v-row class="pa-2 mt-2 d-flex justify-center">
              <v-btn elevation="0" color="primary" rounded large :to="'/plan/edit/' + plan.planId">
                <v-icon class="pr-1">mdi-pencil</v-icon>
                <span class="px-1">수정하기</span>
              </v-btn>
            </v-row>
          </v-col>
        </v-row>

        <!-- 카카오 맵 -->
        <v-row class="justify-center">
          <plan-detail-map :routes="routes"></plan-detail-map>
        </v-row>
      </v-col>

      <!-- 오른쪽 -->
      <v-col cols="12" md="6">
        <v-container>
          <v-tabs show-arrows height="100%">
            <v-tab class="pa-0">
              <v-card elevation="0">
                <div class="px-2">
                  <v-card-title> 전체 일정 </v-card-title>
                </div>
              </v-card>
            </v-tab>
            <v-tab v-for="(group, visitDate, d) in groupByDate" :key="d" class="pa-0">
              <v-card elevation="0">
                <div class="px-2">
                  <v-card-title class="flex justify-center"> {{ d + 1 }} 일차 </v-card-title>
                  <v-card-subtitle class="flex justify-center">
                    {{ visitDate }}
                  </v-card-subtitle>
                </div>
              </v-card>
            </v-tab>

            <v-tab-item class="mt-4">
              <v-container class="py-0" style="height: 760px; overflow-y: auto">
                <v-timeline align-top>
                  <template v-for="(group, visitDate, d) in groupByDate">
                    <v-timeline-item v-for="(route, i) in group" :key="i" :color="colors[d % 10]">
                      <route-item :route="route"></route-item>
                    </v-timeline-item>
                  </template>
                </v-timeline>
              </v-container>
            </v-tab-item>
            <v-tab-item v-for="(group, visitDate, d) in groupByDate" :key="d" class="mt-4">
              <v-container class="py-0" style="height: 760px; overflow-y: auto">
                <v-timeline align-top>
                  <v-timeline-item v-for="(route, i) in group" :key="i" :color="colors[d % 10]">
                    <route-item :route="route"></route-item>
                  </v-timeline-item>
                </v-timeline>
              </v-container>
            </v-tab-item>
          </v-tabs>
        </v-container>
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
      colors: [
        "light-green lighten-2",
        "teal lighten-3",
        "lime lighten-2",
        "light-blue lighten-2",
        "green lighten-2",
        "indigo lighten-",
        "deep-purple lighten-3",
        "blue lighten-2",
        "cyan lighten-2",
        "amber lighten-2",
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
  computed: {
    groupByDate() {
      let group = {};

      this.routes.forEach((route) => {
        console.log(route);
        const visitDate = route.visitDate;
        if (!group[visitDate]) {
          group[visitDate] = [];
        }
        group[visitDate].push(route);
      });
      console.log(group);
      return group;
    },
  },
};
</script>

<style></style>
