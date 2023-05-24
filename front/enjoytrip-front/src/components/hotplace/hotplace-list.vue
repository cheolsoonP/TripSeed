<template>
  <div>
    <header-bar
      title="핫 플레이스"
      content="지역별 지금 핫한 관광지를 확인할 수 있어요.<br/>가장 핫한 여행지를 한눈에!"
      :imgsrc="headerImage"
    />
    <v-container>
      <v-row>
        <v-col cols="3"><hotplace-side-bar /></v-col>
        <v-col cols="9">
          <div class="ma-2">
            <span class="text-h6 mr-2" v-if="hotplaceSido !== null">{{ hotplaceSido.text }}</span>
            <span class="text-h6" v-if="hotplaceGugun !== null">{{ hotplaceGugun.gugunName }}</span>
          </div>
          <div class="d-flex flex-wrap">
            <hotplace-list-item
              class="mx-auto"
              :attraction="attraction"
              v-for="(attraction, index) in attractions.slice(0, attractionCount)"
              :key="index"
            />
          </div>
          <v-row class="justify-center my-5">
            <v-btn text @click="loadMore" v-if="attractionCount < attractions.length">
              더보기...
            </v-btn>
          </v-row>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import HeaderBar from "@/components/bar/header-bar.vue";
import HotplaceSideBar from "../bar/hotplace-side-bar.vue";
import HotplaceListItem from "@/components/hotplace/hotplace-list-item.vue";
import { mapActions, mapState } from "vuex";

const regionStore = "regionStore";
const attractionStore = "attractionStore";

export default {
  components: { HeaderBar, HotplaceSideBar, HotplaceListItem },
  data() {
    return {
      attractionCount: 9,
      headerImage: process.env.VUE_APP_BUCKET_BASE_URL + "HeaderBarImg.png",
    };
  },

  computed: {
    ...mapState(regionStore, ["sidos", "guguns", "hotplaceSido", "hotplaceGugun"]),
    ...mapState(attractionStore, ["attractions"]),
  },
  created() {
    this.getSido();
    this.getHotplaceListAction();
  },
  methods: {
    ...mapActions(regionStore, ["getSido"]),
    ...mapActions(attractionStore, ["getHotplaceListAction"]),
    loadMore() {
      this.attractionCount += 9;
    },
  },
};
</script>

<style></style>
