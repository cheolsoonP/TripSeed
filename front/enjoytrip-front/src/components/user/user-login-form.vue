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
      :rules="[() => ('다시 입력해주세요.')]"
      type='password'
      outlined
      dense
      prepend-inner-icon="mdi-lock"
    ></v-text-field>
    <div>
      <v-btn
        type="submit"
        color="primary"
        width="100%"
      >
      로그인
    </v-btn>
    </div>
  </v-form>
</template>

<script>
export default {
  name: "user-login-form",
  data() {
    return {
      userId:"",
      userPassword: "",
      valid: false,
    }
  }
}
</script>

<style>

</style>