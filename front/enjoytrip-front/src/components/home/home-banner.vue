<template>
  <v-carousel
    cycle
    light
    height="45vh"
    delimiter-icon="mdi-minus"
    hide-delimiter-background
    show-arrows-on-hover
  >
    <template v-slot:prev="{ on, attrs }">
      <v-btn fab color="primary" v-bind="attrs" v-on="on">
        <v-icon>mdi-chevron-left</v-icon>
      </v-btn>
    </template>
    <template v-slot:next="{ on, attrs }">
      <v-btn fab color="primary" v-bind="attrs" v-on="on">
        <v-icon>mdi-chevron-right</v-icon>
      </v-btn>
    </template>

    <div v-if="this.isLogin">
      <v-carousel-item v-for="(slide, i) in slides" :key="i" :src="slide.src">
        <v-sheet height="100%" color="transparent">
          <v-col align="center" justify="center" class="pt-16">
            <h3 style="color: #66d49f">나에 의한 나를 위한</h3>
            <h1>나만의 여행 계획</h1>
          </v-col>
          <v-col align="center" justify="center">
            <span v-html="slide.content" class="text-h6"></span>
          </v-col>
          <v-col align="center" justify="center">
            <v-btn large elevation="0" color="primary" :to="slide.url">
              바로가기
            </v-btn>
          </v-col>
        </v-sheet>
      </v-carousel-item>
    </div>
    <div v-else>
      <v-carousel-item
        v-for="(slide, i) in guestSlides"
        :key="i"
        :src="slide.src"
      >
        <v-sheet height="100%" color="transparent">
          <v-col align="center" justify="center" class="pt-16">
            <span v-html="slide.title"></span>
          </v-col>
          <v-col align="center" justify="center">
            <span v-html="slide.content" class="text-h6"></span>
          </v-col>
          <div v-if="i === 0">
            <v-col align="center" justify="center">
              <v-btn large elevation="0" color="primary" :to="slide.url">
                로그인 후 이용
              </v-btn>
            </v-col>
          </div>
        </v-sheet>
      </v-carousel-item>
    </div>
  </v-carousel>
</template>

<script>
import { mapState } from "vuex";

const userStore = "userStore";
export default {
  name: "HomeBanner",
  data() {
    return {
      slides: [
        {
          src: require("@/assets/home_background1.png"),
          color: "indigo",
          content:
            "이전에 계획을 세운 적 있나요?<br>지금 바로 나만의 여행 계획을 확인하세요",
          url: "/plan/list",
        },
        {
          src: require("@/assets/home_background2.png"),
          color: "warning",
          content:
            "지금 바로 나만의 여행 계획을 세워보세요<br>친구를 초대해 일정을 공유할 수 있어요",
          url: "/plan/write",
        },
      ],
      guestSlides: [
        {
          src: require("@/assets/home_background1.png"),
          color: "indigo",
          title: "<h3>나에 의한 나를 위한</h3><h1>나만의 여행 계획</h1>",
          content:
            "지금 바로 나만의 여행 계획을 세워보세요<br>친구를 초대해 일정을 공유할 수 있어요",
          url: "/login",
        },
        {
          src: require("@/assets/home_banner.png"),
          color: "",
          title: "",
          content: "",
          url: "",
        },
      ],
    };
  },
  computed: {
    ...mapState(userStore, ["isLogin"]),
  },
};
</script>

<style>
</style>