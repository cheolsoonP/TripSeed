<template>
  <v-menu offset-y v-if="loginStatus">
    <template v-slot:activator="{ on }">
      <v-btn text v-on="on">
        {{ username }}
      </v-btn>
    </template>
    <v-list>
      <v-list-item @click="goToPage('user/info')">마이페이지</v-list-item>
      <v-list-item @click="goToPage('user/logout')">로그아웃</v-list-item>
    </v-list>
  </v-menu>

  <v-menu offset-y v-else>
    <template v-slot:activator="{ on }">
      <v-btn text v-on="on">로그인/회원가입</v-btn>
    </template>
    <v-list>
      <v-list-item @click="goToPage('/user/login')">로그인</v-list-item>
      <v-list-item @click="goToPage('/user/join')">회원가입</v-list-item>
    </v-list>
  </v-menu>
</template>

<script>
export default {
  name: "NavBarUserItem",
  data() {
    return {
      loginStatus: false,
      username: "갓길재",
    };
  },
};
</script>

<style>
</style>
