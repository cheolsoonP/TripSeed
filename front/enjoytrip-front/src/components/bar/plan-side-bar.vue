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
        <div>
          <v-list-item class="text-h5">
            <v-btn 
              text
              @click="$vuetify.goTo(target, options)"
            >
              다가오는 여행
            </v-btn>
          </v-list-item>
        </div>
        <div>
          <v-list-item class="text-h5">
            <v-btn text>나의 여행</v-btn>
          </v-list-item>
          <v-list-item>
            <v-btn text>여행 계획</v-btn>
          </v-list-item>          
          <v-list-item>
            <v-btn text>지난 여행</v-btn>
          </v-list-item>          
        </div>
        <v-divider></v-divider>
        <div>
          <v-list-item class="text-h5">
            <span>참여한 여행</span>
          </v-list-item>
          <v-list-item>여행 계획</v-list-item>          
          <v-list-item>지난 여행</v-list-item>          
        </div>
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
    target () {
    /* 
      target can be pixel offset from the top 
      or css selector, or an element reference.
    */
    const value = this[this.type]
      if (!isNaN(value)) return Number(value)
      else return value
    },
    options () {
      return {
        duration: this.duration,
        offset: this.offset,
        easing: this.easing,
      }
    },
  },
  methods: {
    ...mapActions(planStore, [""]),
  }
}
</script>

<style>

</style>