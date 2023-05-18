<template>
  <v-container class="d-flex justify-center mx-auto">
    <v-card
      class="mx-auto"
      max-width="800"
      min-width="500"
    >
      <v-col>
        <v-img>enjoytrip</v-img>
      
      </v-col>
      
      <v-card-actions >
        <v-btn-toggle
          v-model="toggleLoginJoin"
          mandatory
          group
        >
          <v-btn color="primary" width="150px" outlined :value="1">
            로그인
          </v-btn>
          <v-btn color="primary" width="150px" outlined :value="2">
            회원가입
          </v-btn>
        </v-btn-toggle>
      </v-card-actions>
      <div v-if="toggleLoginJoin==1">
        <user-login-form/>
      </div>
      <div v-else>
        
      </div>
    </v-card>
  </v-container>
</template>

<script>
import userLoginForm from "./user-login-form.vue"
export default {
    components: { userLoginForm },
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