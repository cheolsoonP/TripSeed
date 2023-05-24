<template>
  <div style="height: 100%">
    <v-col class="d-flex px-0">
      <v-col>
        <v-select
          dark
          background-color="primary"
          v-model="sidoCode"
          :items="sidos"
          label="시 • 도"
          solo
          hide-details
          @change="selectSido"
        ></v-select>
      </v-col>
      <v-col>
        <v-select
          dark
          background-color="primary"
          v-model="gugunCode"
          item-text="gugunName"
          item-value="gugunCode"
          :items="guguns"
          label="군 • 구"
          solo
          hide-details
        ></v-select>
      </v-col>
    </v-col>
    <v-col class="py-0">
      <v-text-field
        dark
        background-color="primary"
        label="검색"
        solo
        v-model="searchWord"
      ></v-text-field>
    </v-col>
    <div style="max-height: 300px; overflow-y;">
      <div v-for="(attraction, i) in attractions" :key="i">
        <v-row v-if="i <= attractionCount">
          <v-list-item>
            <v-list-item-avatar>
              <v-icon v-if="attraction.firstImage2 === ''">mdi-heart</v-icon>
              <v-img v-else :src="attraction.firstImage2" />
            </v-list-item-avatar>

            <v-list-item-content>
              <v-list-item-title>{{ attraction.title }}</v-list-item-title>

              <v-list-item-subtitle>{{attraction.addr1}}</v-list-item-subtitle>
            </v-list-item-content>
          </v-list-item>
        </v-row>
      </div>
    </div>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const regionStore = "regionStore";
const attractionStore = "attractionStore";

export default {
  name: "PlanEditSearch",
  data() {
    return {
      sidoCode: null,
      sidoName: null,
      gugunCode: null,
      gugunName: null,
      searchWord: null,
      dialog: false,
    };
  },
  created() {
    this.getSido();
    this.initAttractionListAction();
    // this.getAttractionListAction(); // 데이터가 커서 시간 많이 소요
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns"]),
    ...mapState(attractionStore, ["attractions", "attractionCount"]),
    // ...mapGetters(attractionStore, ["getAttractionItems", "filteredAttractions"]),
    attractions() {
      return this.$store.getters["attractionStore/filteredAttractions"](
        this.gugunCode
      );
    },
  },
  methods: {
    ...mapActions(regionStore, ["getSido", "getGugun"]),
    ...mapActions(attractionStore, [
      "getAttractionListAction",
      "initAttractionListAction",
    ]),

    selectSido() {
      let param = {
        sidoCode: this.sidoCode,
      };
      this.getGugun(this.sidoCode);
      this.getAttractionListAction(param);
      // this.attractions += this.getAttractionItems(0, 10);
    },
    selectGugun() {},
  },
};
</script>
