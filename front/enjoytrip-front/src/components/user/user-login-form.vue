<template>
  <v-form
    ref="form"
    v-model="valid"
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
      dense
      prepend-inner-icon="mdi-account"
    ></v-text-field>
    <v-text-field
      label="비밀번호를 입력하세요"
      v-model="userPassword"
      :rules="testPassword"
      type='password'
      outlined
      dense
      prepend-inner-icon="mdi-lock"
    ></v-text-field>
    <div>
      <v-btn
        type="submit"
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
import { loginUserApi } from "@/api/user";

export default {
  name: "user-login-form",
  data() {
    return {
      userId:"",
      userPassword: "",
      valid: false,
      testPassword: [
        () => {
          if (this.valid == false) {
            return "다시 입력해 주세요.";
          }
          return true;
        }
      ]
    }
  },
  methods: {
    loginUser() {
      let body = {
        userId: this.userId,
        userPassword: this.userPassword,
      };
      loginUserApi(
        body,
        () => {
          alert("로그인 성공!")
        },
        (error) => {
          console.log(error);
        }
      );
    }
  }
}
</script>

<style>

</style>