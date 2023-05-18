<template>
  <form @submit.prevent="submit">
    <v-text-field
      v-model="userId"
      :counter="50"
      :error-messages="errors"
      label="아이디"
      required
      outlined
      dense
    ></v-text-field>
    <v-text-field
      v-model="userName"
      :counter="50"
      :error-messages="errors"
      label="이름"
      required
      outlined
      dense
    ></v-text-field>
    <v-text-field
      v-model="userEmail"
      :error-messages="errors"
      label="이메일"
      required
      outlined
      dense
    ></v-text-field>
    <v-text-field
      label="비밀번호"
      v-model="userPassword"
      type='password'
      outlined
      dense
    ></v-text-field>
    <v-text-field
      label="비밀번호 확인"
      v-model="userPasswordConfirm"
      :rules="[checkPassword()]"
      type='password'
      outlined
      dense
    ></v-text-field>
    <v-btn
      type="submit"
      color="primary"
      width="80%"
      :disabled="invalid"
    >
      회원가입
    </v-btn>
    <v-btn 
      @click="clear"
      color="primary"
      width="20%"
      outlined
    >
      초기화
    </v-btn>
  </form>
</template>

<script>
export default {
  name: "UserJoinForm",
  data() {
    return {
      invalid: false,
      userId: "",
      userName: "",
      userEmail: "",
      userPassword: "",     
      errors:"", 
    }
  },
  methods: {
    clear() {
      this.invalid = false,
      this.userId = "",
      this.userName = "",
      this.userEmail = "",
      this.userPassword = "",     
      this.errors = ""
    },
    checkPassword() {
      if (this.userPassword !== this.userPasswordConfirm) {
        return "비밀번호가 일치하지 않습니다.";
      }
    }

  },
}
</script>

<style>

</style>