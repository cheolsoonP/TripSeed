<template>
  <v-container class="mt-16">
    <v-row justify="center" class="my-8">
      <h2>아직 고민 중이라면</h2>
    </v-row>

    <v-row>
      <v-col cols="12" md="6" v-for="(card, i) in cards" :key="i">
        <v-card elevation="0" outlined class="ma-2 d-flex">
          <v-card-text>
            <v-row>
              <v-col cols="4" md="12">
                <v-img height="200px" contain src="@/assets/home_img.png" />
              </v-col>
              <v-col cols="8" md="12">
                <v-card-title>{{ card.title }}</v-card-title>
                <v-card-subtitle>{{ card.subtitle }}</v-card-subtitle>
                <v-card-actions class="py-0">
                  <v-btn color="primary" text> 바로가기 </v-btn>
                </v-card-actions>
              </v-col>
            </v-row>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "HomeContent",
  data() {
    return {
      cards: [
        { title: "핫 플레이스", subtitle: "나만 빼고 다 가는 곳" },
        {
          title: "여행 꿀팁 공유",
          subtitle: "지역을 선택하고 관련 정보를 확인",
        },
      ],
    };
  },
};
</script>

<style>
</style>