<template>
  <v-container class="d-flex-row">
    <v-card
      class="mx-auto pa-5 my-16"
      max-width="40%"
    > 
      <v-row>
        <v-col class="d-flex justify-center">
          <img src="@/assets/logo_title.svg" height="40" />
        </v-col>
      </v-row>
      <v-col class="ma-0 mb-8">
        <v-btn-toggle
          v-model="toggleLoginJoin"
          mandatory
          group
        >
          <v-btn color="primary" min-width="100%" outlined :value="1">
            로그인
          </v-btn>          
          <v-btn color="primary" min-width="100%" outlined :value="2">
            회원가입
          </v-btn>
        </v-btn-toggle>
      </v-col>      
      <div v-if="toggleLoginJoin==1">
        <user-login-form/>
      </div>
      <div v-else>
        <user-join-form/>
      </div>
    </v-card>
  </v-container>
</template>

<script>
import UserJoinForm from "./user-join-form.vue"
import userLoginForm from "./user-login-form.vue"
export default {
    components: { userLoginForm, UserJoinForm },
  name: "UserLogin",
  data() {
      return {
        toggleLoginJoin: undefined,
      }
    },
}
</script>

<style>

</style>