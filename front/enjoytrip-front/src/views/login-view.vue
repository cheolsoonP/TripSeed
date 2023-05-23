<template>
  <div class="login">
    <user-login />
  </div>
</template>

<script>
import UserLogin from "@/components/user/user-login.vue";
export default {
  name: "LoginView",
  components: { UserLogin },
};
</script>

<style>
.login {
  background-image: url(@/assets/login_background.png);
  background-repeat: no-repeat;
  background-size: cover;
  min-height: 85vh;
}
</style>
