<template>
  <v-card
    height="400"
    width="256"
    class="mx-auto"
  >
    <v-navigation-drawer permanent>
      <v-list-item>
        <v-list-item-content>
          <v-text-field
            dark
            background-color="primary"
            label="검색"
            solo
            v-model="searchWord"
          ></v-text-field>
          <v-select
            dark
            background-color="primary"
            v-model="sidoCode"
            :items="sidos"
            label="시도 선택"
            solo
            @change="getGugun"
          ></v-select>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>

      <v-list
        dense
        nav
      >
        <v-list-item
          v-for="gugun in guguns"
          :key="gugun.gugunCode"
          link
        >
          {{ gugun.gugunName }}
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex"

const regionStore = "regionStore";

export default {
    name: "SideBar",
    data () {
      return {
        sidoCode: null,
        sidoName:null,
        gugunCode: null,
        gugunName:null,
        searchWord:null,
      }
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns"]),
  },
  methods: {
    ...mapActions(regionStore, ["getGugun"]),
  }
}
</script>

<style>

</style>