<template>
  <v-container>
    <v-row>
      <!-- 왼쪽 -->
      <v-col cols="12" md="6">
        <v-row>{{ plan.planTitle }}</v-row>
        <v-row>
          <v-col>
            <v-list-item>시작</v-list-item>
            <v-list-item>{{ plan.startDate }}</v-list-item>
          </v-col>
          <v-col>
            <v-list-item>종료</v-list-item>
            <v-list-item>{{ plan.endDate }}</v-list-item>
          </v-col>
        </v-row>
        <v-row>
          <v-btn>동행 초대하기</v-btn>
        </v-row>
        <v-row> 지도 </v-row>
      </v-col>
      <!-- 오른쪽 -->
      <v-col cols="12" md="6">
        <v-list-item v-for="(route, index) in routes" :key="index">
          <route-item :route="route"></route-item>
        </v-list-item>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { getPlanDetailApi, getRouteApi } from "@/api/plan.js";
import routeItem from "@/components/plan/route-item.vue";
export default {
  name: "PlanDetail",
  components: { routeItem },
  data() {
    return {
      plan: {},
      routes: [],
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
