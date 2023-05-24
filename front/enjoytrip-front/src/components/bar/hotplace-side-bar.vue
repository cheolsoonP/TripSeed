<template>
  <v-card height="600" width="200" class="card">
    <v-navigation-drawer permanent>
      <v-list-item>
        <v-list-item-content>
          <v-select
            dark
            background-color="primary"
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
const attractionStore = "attractionStore";

export default {
  name: "HotplaceSideBar",
  data() {
    return {
      sidoCode: null,
      sidoName: null,
      gugunCode: null,
      gugunName: null,
      searchWord: null,
    };
  },
  created() {
    this.initHotplaceSidoGugunAction();
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns"]),
  },
  methods: {
    ...mapActions(regionStore, [
      "getGugun",
      "changeHotplaceSidoAction",
      "changeHotplaceGugunAction",
      "initHotplaceSidoGugunAction",
    ]),
    ...mapActions(attractionStore, ["getHotplaceListAction"]),

    onChangeSido(sidoCode) {
      this.sidoCode = sidoCode;
      this.getGugun(sidoCode);
      let param = {
        sidoCode: sidoCode,
      };
      this.changeHotplaceSidoAction(sidoCode);
      this.getHotplaceListAction(param);
    },
    onClickGugun(gugun) {
      this.gugunCode = gugun.gugunCode;
      let param = {
        sidoCode: this.sidoCode,
        gugunCode: this.gugunCode,
      };
      this.changeHotplaceGugunAction(gugun);
      this.getHotplaceListAction(param);
    },
  },
};
</script>

<style>
.card {
  display: block;
}
</style>
