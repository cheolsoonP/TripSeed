<template>
  <form @submit.prevent="submit" height="100%">
    <v-text-field
      v-model="userId"
      :counter="50"
      label="아이디"
      required
      outlined
      disabled
      dense
    ></v-text-field>
    <v-text-field
      v-model="userName"
      :counter="50"
      label="이름"
      required
      outlined
      disabled
      dense
    ></v-text-field>
    <v-text-field
      v-model="userEmail"
      label="이메일"
      :rules="emailRules"
      required
      outlined
      disabled
      dense
    ></v-text-field>
    <v-text-field
      v-model="userNickname"
      :counter="50"
      label="현재 닉네임"
      required
      outlined
      disabled
      dense
    ></v-text-field>
    <v-text-field
      v-model="newNickname"
      :counter="50"
      label="변경할 닉네임"
      outlined
      dense
    ></v-text-field>
    <v-text-field
      label="변경할 비밀번호"
      :error-messages="errors"
      v-model="userPassword"
      type="password"
      required
      outlined
      dense
    ></v-text-field>
    <v-text-field
      label="비밀번호 확인"
      :error-messages="errors"
      :rules="passwordRules"
      type="password"
      outlined
      required
      dense
    ></v-text-field>
    <span v-if="errorMsg !== ''" class="text-caption red">
      {{ errorMsg }}
    </span>
    <v-btn type="submit" color="primary" width="100%" @click="updateUserInfo" :disabled="invalid">
      수정하기
    </v-btn>
  </form>
</template>

<script>
import { updateUserApi } from "@/api/user";
import { mapActions, mapState } from "vuex";

const userStore = "userStore";

export default {
  name: "UserInfoDetail",
  data() {
    return {
      invalid: false,
      userPassword: "",
      newNickname: "",
      errors: "",
      errorMsg: "",
      passwordRules: [
        (value) => !!value || "비밀번호를 입력해주세요.",
        (value) => {
          if (this.userPassword === value) return true;
          else {
            return "비밀번호가 일치하지 않습니다.";
          }
        },
      ],
      emailRules: [
        (value) => !!value || "이메일을 입력해주세요.",
        (value) => {
          const pattern =
            /^(([^<script>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
          return pattern.test(value) || "잘못된 이메일 형식입니다.";
        },
      ],
    };
  },
  methods: {
    ...mapActions(userStore, ["initUserInfoAction"]),
    updateUserInfo() {
      if (this.userPassword === "") {
        this.errorMsg = "새로운 비밀번호를 입력해주세요.";
        return;
      }

      alert("회원정보를 수정하시겠습니까?");

      let body = {
        userId: this.userId,
        userNickname: this.newNickname,
        userPassword: this.userPassword,
      };

      // 새로운 닉네임이 없다면 기존 닉네임으로 사용
      if (this.newNickname === "") {
        body.userNickname = this.userNickname;
      }
      updateUserApi(
        body,
        () => {
          alert("회원정보 수정 완료! 다시 로그인 해주세요.");
          this.initUserInfoAction();
          this.$router.push("/login");
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
  computed: {
    ...mapState(userStore, ["userId", "userName", "userNickname", "userName"]),
  },
};
</script>

<style></style>
