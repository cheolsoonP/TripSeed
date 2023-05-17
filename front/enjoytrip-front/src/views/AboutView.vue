<template>
  <div class="about">
    <side-bar></side-bar>
  </div>
</template>
<script>
import sideBar from "@/components/bar/side-bar.vue"
import { mapActions, mapState } from "vuex"

const regionStore = "regionStore";

export default {
    name: 'AboutView',
  components: { sideBar },
  data() {
    return {

    };
  },
  computed: {
    ...mapState(regionStore, ["sidos"]),
  },
  created() {
    this.getSido();
  },
  methods: {
    ...mapActions(regionStore, ["getSido"]),
    }
  }
</script>