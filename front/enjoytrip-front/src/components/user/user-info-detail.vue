<template>
  <form @submit.prevent="submit" height="100%">
    <div>
      <div class="text-subtitle ml-5">프로필 등록</div>
      <v-row class="text-h6">
        <v-col cols="2">
          <v-avatar class="my-3 mx-2" width="100" height="100">
            <v-img v-if="profile !== null" :src="profile" max-height="100" max-width="100"></v-img>
          </v-avatar>
        </v-col>
        <v-col cols="3">
          <v-file-input
            @change="onChangeFile"
            color="primary"
            light
            chips
            counter
            show-size
            :rules="fileRules"
            accept="image/*"
            truncate-length="34"
          ></v-file-input>
        </v-col>
      </v-row>
    </div>
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
      label="변경할 닉네임 (기본값은 현재 닉네임)"
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
      v-model="checkPassword"
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
      checkPassword: "",
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
      profile: null,
      file: null,
      fileRules: [
        (value) => !value || value.size < 5000000 || "이미지 용량은 5MB를 초과할 수 없습니다.",
      ],
    };
  },
  methods: {
    ...mapActions(userStore, ["initUserInfoAction"]),
    updateUserInfo() {
      if (this.userPassword === "" || this.checkPassword === "") {
        this.errorMsg = "새로운 비밀번호를 입력해주세요.";
        return;
      }

      alert("회원정보를 수정하시겠습니까?");

      let body = {
        userId: this.userId,
        userNickname: this.newNickname,
        userPassword: this.userPassword,
        file: this.file,
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
    onChangeFile(file) {
      if (file !== null) {
        this.profile = URL.createObjectURL(file);
        this.file = file;
      } else {
        this.profile = null;
        this.file = null;
      }
    },
  },
  computed: {
    ...mapState(userStore, ["userId", "userName", "userNickname", "userEmail"]),
  },
};
</script>

<style></style>
