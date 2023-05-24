<template>
  <v-container>
    <v-row>
      <!-- left -->
      <v-col cols="6" class="pa-0">
        <v-col>
          <div style="height: 30vh; min-width: 300px; min-height: 250px">
            <plan-edit-map />
          </div>
        </v-col>
        <v-col class="pa-0">
          <div>
            <plan-edit-search />
          </div>
        </v-col>
      </v-col>

      <!-- right -->
      <v-col cols="6" class="px-0">
        <plan-edit-route />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import PlanEditMap from "@/components/plan/plan-edit-map.vue";
import PlanEditSearch from "@/components/plan/plan-edit-search.vue";
import PlanEditRoute from "@/components/plan/plan-edit-route.vue";

export default {
  name: "PlanEdit",
  components: { PlanEditMap, PlanEditSearch, PlanEditRoute },
};
</script>

<style></style>
