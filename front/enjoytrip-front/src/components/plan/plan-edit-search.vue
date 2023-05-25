<template>
  <div style="height: 100%">
    <v-col class="d-flex px-0 pt-0">
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
    <v-row class="pl-3">
      <v-col class="py-0" cols="9">
        <v-text-field
          dark
          background-color="primary"
          label="검색"
          solo
          v-model.lazy="searchWord"
          hide-details=""
          @keydown.enter="searchAttractions"
        ></v-text-field>
      </v-col>
      <v-col>
        <v-btn color="primary" @click="sortPopular">인기순</v-btn>
      </v-col>
    </v-row>

    <v-container style="max-height: 320px; overflow-x: hidden; overflow-y: auto" class="mt-4">
      <v-row v-for="(attraction, i) in attractions.slice(0, attractionCount)" :key="i">
        <v-card width="100%" elevation="0">
          <v-list-item>
            <v-col>
              <v-row align="center" style="min-width: 250px">
                <v-col cols="auto" class="pa-0">
                  <v-list-item-avatar>
                    <v-icon v-if="attraction.firstImage2 === ''" color="primary">mdi-sprout</v-icon>
                    <v-img v-else :src="attraction.firstImage2" />
                  </v-list-item-avatar>
                </v-col>
                <v-col class="pa-0">
                  <v-list-item-content>
                    <v-list-item-title>{{ attraction.title }}</v-list-item-title>

                    <v-list-item-subtitle>
                      <v-dialog v-model="dialog" width="500">
                        <template v-slot:activator="{ on, attrs }">
                          <v-btn text v-bind="attrs" v-on="on" class="pa-0">
                            {{ attraction.addr1 }}
                          </v-btn>
                        </template>

                        <v-card>
                          <v-card-title class="text-h5 grey lighten-2">
                            {{ attraction.title }}
                          </v-card-title>

                          <v-card-text>
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
                            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim
                            veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea
                            commodo consequat. Duis aute irure dolor in reprehenderit in voluptate
                            velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
                            occaecat cupidatat non proident, sunt in culpa qui officia deserunt
                            mollit anim id est laborum.
                          </v-card-text>
                        </v-card>
                      </v-dialog>
                    </v-list-item-subtitle>
                  </v-list-item-content>
                </v-col>
              </v-row>
            </v-col>
            <v-col cols="auto">
              <v-btn fab small elevation="0" color="primary" @click="addToRoute(attraction)">
                <v-icon>mdi-plus</v-icon>
              </v-btn>
            </v-col>
          </v-list-item>
        </v-card>
      </v-row>

      <v-row justify="center">
        <v-btn text @click="loadMore" v-if="attractionCount < attractions.length"> 더보기 </v-btn>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const regionStore = "regionStore";
const attractionStore = "attractionStore";
const planStore = "planStore";

export default {
  name: "PlanEditSearch",
  data() {
    return {
      sidoCode: null,
      sidoName: null,
      gugunCode: null,
      gugunName: null,
      searchWord: null,
      attractionCount: 10, // 추가
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
    ...mapState(attractionStore, ["attractions"]),
    ...mapState(planStore, ["routes", "activeTabDate"]),

    attractions() {
      if (this.searchWord) {
        return this.$store.getters["attractionStore/filteredAttractions"](this.gugunCode).filter(
          (attraction) => attraction.title.includes(this.searchWord)
        );
      } else {
        return this.$store.getters["attractionStore/filteredAttractions"](this.gugunCode);
      }
    },
  },
  methods: {
    ...mapActions(regionStore, ["getSido", "getGugun"]),
    ...mapActions(attractionStore, [
      "getAttractionListAction",
      "initAttractionListAction",
      "sortAttractionPopularAction",
    ]),
    ...mapActions(planStore, ["addAttractionToRouteAction"]),

    selectSido() {
      let param = {
        sidoCode: this.sidoCode,
        keyword: this.searchWord,
      };
      this.getGugun(this.sidoCode);
      this.getAttractionListAction(param);
    },
    selectGugun() {},
    loadMore() {
      this.attractionCount += 10;
    },
    searchAttractions() {
      let param = {
        keyWord: this.searchWord,
      };
      this.getAttractionListAction(param);
    },
    addToRoute(attraction) {
      console.log(attraction);
      let route = {
        planId: this.$route.params.planId,
        ...attraction,
        visitDate: this.activeTabDate,
        visitOrder: this.routes.length + 1,
      };
      this.addAttractionToRouteAction(route);
    },
    sortPopular() {
      this.sortAttractionPopularAction();
    },
  },
};
</script>
