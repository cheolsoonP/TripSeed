<template>
  <v-card
    height="400"
    width="256"
    class="mx-auto"
  >
    <v-navigation-drawer permanent>
      <v-list
        dense
        nav
      >
        <v-list-item>
          <h6>다가오는 여행</h6>
        </v-list-item>
        <v-list-item>
          <h6>나의 여행</h6>
        </v-list-item>
        <v-list-item
          v-for="plan in plans"
          :key="plan.planId"
          link
        >
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex"

const planStore = "planStore";

export default {
    name: "PlanSideBar",
    data () {
      return {

      }
  },
  computed: {
    ...mapState(planStore, [""]),
  },
  methods: {
    ...mapActions(planStore, [""]),
  }
}
</script>

<style>

</style>