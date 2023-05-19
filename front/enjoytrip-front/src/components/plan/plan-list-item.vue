<template>
  <div>
    <v-card>
      <v-list>
        <v-list-item>
          {{ planInfo.planId }}
        </v-list-item>
        <v-list-item>
          {{ planInfo.planTitle }}
        </v-list-item>
        <v-list-item>
          {{ planInfo.startDate }}
        </v-list-item>
        <v-list-item>
          {{ planInfo.endDate }}
        </v-list-item>
      </v-list>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "PlanListItem",
  props: ["planInfo"]
  ,
}
</script>

<style>

</style>