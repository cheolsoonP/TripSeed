<template>
  <v-form
    ref="form"
    @submit.prevent="submit"
    lazy-validation
    class="mx-auto my-auto"
    max-width="800"
    min-width="500"
  >
    <v-text-field
      v-model="userId"
      label="아이디"
      placeholder="아이디를 입력하세요."
      outlined
      required
      dense
      prepend-inner-icon="mdi-account"
    ></v-text-field>
    <v-text-field
      label="비밀번호를 입력하세요"
      required
      v-model="userPassword"
      type='password'
      outlined
      dense
      prepend-inner-icon="mdi-lock"
    ></v-text-field>
    <span v-if="errorMsg !== ''" class="text-caption red">
      {{ errorMsg }}
    </span>
    <div>
      <v-btn
        type="button"
        @click="loginUser"
        color="primary"
        width="100%"
      >
        로그인
      </v-btn>
    </div>
  </v-form>
</template>

<script>
import { mapActions, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "user-login-form",

  data() {
    return {
      userId: "",
      userPassword: "",
      valid: false,
      errorMsg: "",
    }
  },
  computed: {
    ...mapState(userStore, ["isLogin"]),
  },
  methods: {
    ...mapActions(userStore, ["loginUserAction"]),
    loginUser() {
      if (this.userId === "") {
        this.errorMsg = "아이디를 입력해주세요."
        return;
      }
      else if (this.userPassword === "") {
        this.errorMsg = "비밀번호를 입력해주세요."
        return;
      }
      let body = {
        userId: this.userId,
        userPassword: this.userPassword,
      };
      this.loginUserAction(body).then(() => this.checkUser());
    },
    checkUser() {
      if (this.isLogin === true) {
        alert("로그인 되었습니다.");
        this.errorMsg = "";
        this.$router.push({
          name: "/"
        })
      } else {
        this.errorMsg = "비밀번호를 다시 입력해주세요.";
      }
    },
  }
}

</script>

<style>

</style>