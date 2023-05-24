<template>
  <div>
    <header-bar
      title="여행 꿀팁 공유"
      content="여행지별 추천 명소나 맛집 정보를 공유하세요!<br/>함께하면 재미가 두배"
      url="/board/write"
      btn_icon="mdi-plus"
      btn_text="글쓰기"
      :imgsrc="headerImage"
    />
    <v-container>
      <v-row>
        <v-col cols="3"><board-side-bar /></v-col>
        <v-col cols="9">
          <v-list>
            <v-list-item v-for="(post, index) in posts" :key="index">
              <board-list-item :post="post" />
            </v-list-item>
          </v-list>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import HeaderBar from "@/components/bar/header-bar.vue";
import BoardSideBar from "@/components/bar/board-side-bar.vue";
import BoardListItem from "@/components/board/board-list-item.vue";
import { mapActions, mapState } from "vuex";

const regionStore = "regionStore";
const boardStore = "boardStore";

export default {
  components: { HeaderBar, BoardSideBar, BoardListItem },
  data() {
    return {
      headerImage: process.env.VUE_APP_BUCKET_BASE_URL + "HeaderBarImg.png",
    };
  },

  computed: {
    ...mapState(regionStore, ["sidos"]),
    ...mapState(boardStore, ["posts"]),
  },
  created() {
    this.getSido();
    this.getPostList();
    console.log(this.posts);
  },
  methods: {
    ...mapActions(regionStore, ["getSido"]),
    ...mapActions(boardStore, ["getPostList"]),
  },
};
</script>

<style></style>
