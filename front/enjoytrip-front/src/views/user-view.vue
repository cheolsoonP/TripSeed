<template>
  <div class="plan my-10 py-5">
    <v-row>
      <v-col cols="3"><mypage-side-bar></mypage-side-bar></v-col>
      <v-col cols="9"> <router-view></router-view> </v-col>
    </v-row>
  </div>
</template>

<script>
import MypageSideBar from "@/components/bar/mypage-side-bar.vue";
export default {
  name: "UserView",
  components: { MypageSideBar },
};
</script>

<style></style>
