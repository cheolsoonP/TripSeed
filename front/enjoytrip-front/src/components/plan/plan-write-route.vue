<template>
  <div>
    <v-row>
      <v-col cols="4" style="background-color: pink;">
        1
      </v-col>
      <v-col cols="5" class="pa-0">
        <plan-route-map />
      </v-col>
      <v-col cols="3" style="background-color: orange;">
        3
      </v-col>
    </v-row>
  </div>
</template>

<script>
import PlanRouteMap from './plan-route-map.vue';
export default {
  name: 'PlanWriteRoute',
  components : {
    PlanRouteMap,
  }
}
</script>
