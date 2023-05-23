<template>
  <div class="d-none d-flex">
    <v-menu open-on-hover offset-y v-if="this.isLogin">
      <template v-slot:activator="{ on }">
        <v-btn block text max-width="200px" v-on="on">
          <v-avatar color="teal" size="36">
            <v-icon dark> mdi-account-circle </v-icon>
          </v-avatar>
          <span> &nbsp; {{ userNickname }} 님</span>
        </v-btn>
      </template>
      <v-list>
        <v-list-item to="/user/info">마이페이지</v-list-item>
        <v-list-item @click="onClickLogout">로그아웃</v-list-item>
      </v-list>
    </v-menu>

    <v-menu open-on-hover offset-y v-else>
      <template v-slot:activator="{ on }">
        <v-btn block text max-width="200px" v-on="on" to="/user/login">로그인/회원가입</v-btn>
      </template>
      <!-- <v-list>
      <v-list-item to="/user/login">로그인</v-list-item> -->
      <!-- <v-list-item to="/user/login">회원가입</v-list-item> -->
      <!-- </v-list> -->
    </v-menu>
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "NavBarUserItem",
  computed: {
    ...mapState(userStore, ["isLogin", "userId", "userNickname"]),
  },
  data() {
    return {};
  },
  methods: {
    ...mapActions(userStore, ["initUserInfoAction"]),
    onClickLogout() {
      this.initUserInfoAction().then(alert("로그아웃 되었습니다."));
    },
  },
};
</script>

<style></style>
