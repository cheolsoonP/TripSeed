<template>
  <div>
    <v-menu open-on-hover offset-y v-if="this.isLogin">
      <template v-slot:activator="{ on }">
        <v-btn block text max-width="200px" v-on="on">
          <v-card v-if="profile !== null" class="rounded-pill" width="30" height="30">
            <v-img :src="profile"></v-img>
          </v-card>
          <v-avatar v-else color="teal" size="36">
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
    <div v-else>
      <v-btn class="d-none d-flex" text v-on="on" to="/login">로그인/회원가입</v-btn>
    </div>
    <!-- <v-menu open-on-hover offset-y v-else>
      <template v-slot:activator="{ on }">
      </template>
      <v-list>
        <v-list-item to="/user/login">로그인</v-list-item>
        <v-list-item to="/user/login">회원가입</v-list-item>
      </v-list>
    </v-menu> -->
  </div>
</template>

<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "NavBarUserItem",
  computed: {
    ...mapState(userStore, ["isLogin", "userId", "userNickname", "profile"]),
  },
  data() {
    return {};
  },
  methods: {
    ...mapActions(userStore, ["initUserInfoAction"]),
    onClickLogout() {
      this.initUserInfoAction().then(alert("로그아웃 되었습니다."));
      this.$router.push("/login");
    },
  },
};
</script>

<style></style>
