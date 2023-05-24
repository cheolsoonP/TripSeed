<template>
  <v-card height="600" width="256" class="card">
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
            @change="onChangeSido"
          ></v-select>
        </v-list-item-content>
      </v-list-item>
      <v-divider></v-divider>

      <v-list dense nav>
        <v-list-item v-for="gugun in guguns" :key="gugun.gugunCode" @click="onClickGugun(gugun)">
          {{ gugun.gugunName }}
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
import { mapActions, mapState } from "vuex";

const regionStore = "regionStore";
const boardStore = "boardStore";

export default {
  name: "SideBar",
  data() {
    return {
      sidoCode: null,
      sidoName: null,
      gugunCode: null,
      gugunName: null,
      searchWord: null,
    };
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns"]),
  },
  methods: {
    ...mapActions(regionStore, ["getGugun"]),
    ...mapActions(boardStore, ["getPostList"]),
    onChangeSido(sidoCode) {
      this.sidoCode = sidoCode;
      this.getGugun(sidoCode);
      let param = {
        sidoCode: sidoCode,
      };
      this.getPostList(param);
    },
    onClickGugun(gugun) {
      this.gugunCode = gugun.gugunCode;
      let param = {
        sidoCode: this.sidoCode,
        gugunCode: this.gugunCode,
      };
      this.getPostList(param);
    },
  },
};
</script>

<style>
.card {
  display: block;
  /* position: fixed; */
}
</style>
