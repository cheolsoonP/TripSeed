<template>
  <div class="plan">
    <v-row>
      <v-col><mypage-side-bar></mypage-side-bar></v-col>
      <v-col> <router-view></router-view> </v-col>
    </v-row>
  </div>
</template>

<script>
export default {
  name: "UserView",
};
</script>

<style></style>
