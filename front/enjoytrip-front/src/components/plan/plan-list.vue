<template>
  <v-container>
    <v-row>
      <!-- <v-col cols="3"><plan-side-bar/></v-col> -->
      <v-col cols="9">
        <v-list>
          <v-list-item v-for="planInfo, index in plans" :key="index">
            <plan-list-item :planInfo="planInfo"/>
          </v-list-item>
        </v-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
// import PlanSideBar from "@/components/bar/plan-side-bar"
import { mapActions, mapState } from "vuex"
import PlanListItem from "@/components/plan/plan-list-item"
const planStore = "planStore";
const userStore = "userStore";

export default {
  components: { PlanListItem },
  data() {
    return {

    }
  },
  computed: {
    ...mapState(userStore, ["userId"]),
    ...mapState(planStore, ["plans"]),
  },
  created() {
    this.getPlanListAction(this.userId);
  },
  methods: {
    ...mapActions(planStore, ["getPlanListAction"]),
  }
}
</script>

<style>

</style>