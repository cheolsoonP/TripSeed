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
      <v-btn 
        fab color="primary"
        v-bind="attrs" v-on="on"
      >
        <v-icon>mdi-chevron-left</v-icon>
      </v-btn>
    </template>
    <template v-slot:next="{ on, attrs }">
      <v-btn 
        fab color="primary"
        v-bind="attrs" v-on="on"
      >
        <v-icon>mdi-chevron-right</v-icon>
      </v-btn>
    </template>

    <v-carousel-item
      v-for="(slide, i) in slides"
      :key="i"
      src="@/assets/home_background.png"
    >
      <v-sheet height="100%" color="transparent">
        <v-col align="center" justify="center" class="pt-16">
          <h3>나에 의한 나를 위한</h3>
          <h1>나만의 여행 계획</h1>
        </v-col>
        <v-col align="center" justify="center">
          <span v-html="slide.content" class="text-h6"></span>
        </v-col>
        <v-col align="center" justify="center">
          <v-btn large elevation="0" color="primary"> 바로가기 </v-btn>
        </v-col>
      </v-sheet>
    </v-carousel-item>
  </v-carousel>
</template>

<script>
export default {
  name: "HomeBanner",
  data() {
    return {
      slides: [
        {
          src: "@/src/assets/home_background.png",
          color: "indigo",
          content:
            "지금 바로 나만의 여행 계획을 세워보세요<br>친구를 초대해 일정을 공유할 수 있어요",
        },
        {
          src: "https://cdn.vuetifyjs.com/images/carousel/sky.jpg",
          color: "warning",
          content: "친구를 초대해 일정을 공유할 수 있어요",
        },
      ],
    };
  },
};
</script>

<style>
</style>