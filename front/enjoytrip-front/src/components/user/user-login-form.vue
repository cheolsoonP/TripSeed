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
        :rules="nameRules"
        label="아이디"
        placeholder="아이디를 입력하세요."
        max-width="300"
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
      <v-btn
        class="mr-4"
        type="submit"
        :disabled="invalid"
      >
        로그인
      </v-btn>
    </v-form>
</template>

<script>
export default {

}
</script>

<style>

</style>