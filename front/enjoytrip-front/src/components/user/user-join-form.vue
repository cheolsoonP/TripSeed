<template>
  <form @submit.prevent="submit" height="100%">
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
      v-model="userNickname"
      :counter="50"
      :error-messages="errors"
      label="닉네임"
      required
      outlined
      dense
    ></v-text-field>
    <v-text-field
      v-model="userEmail"
      :error-messages="errors"
      label="이메일"
      :rules="emailRules"
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
      :rules="passwordRules"
      type='password'
      outlined
      dense
    ></v-text-field>
    <v-btn
      type="submit"
      color="primary"
      width="80%"
      @click="joinUser"
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
import { joinUserApi } from '@/api/user';
export default {
  name: "UserJoinForm",
  data() {
    return {
      invalid: false,
      userId: "",
      userNickname:"",
      userName: "",
      userEmail: "",
      userPassword: "",    
      errors: "", 
      passwordRules: [
        value => !!value || '비밀번호를 입력해주세요.',
        value => {
          if (this.userPassword === value)
            return true;
          else {
            return "비밀번호가 일치하지 않습니다.";
          }
        },
      ],
      emailRules: [
        value => !!value || '이메일을 입력해주세요.',
        value => {
          const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
          return pattern.test(value) || '잘못된 이메일 형식입니다.'
        },
      ],
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
    joinUser() {
      let body = {
        userId: this.userId,
        userNickname: this.userNickname,
        userName: this.userName,
        userEmail: this.userEmail,
        userPassword: this.userPassword,
      };
      joinUserApi(
        body,
        () => {
          alert("회원등록 성공!")
        },
        (error) => {
          console.log(error);
        }
      );
    }

  },
}
</script>

<style>

</style>