<template>
  <div class="login">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: "LoginView",

}
</script>

<style>
.login {
  background-image: url(@/assets/login_background.png);
  background-repeat: no-repeat;
  background-size: cover;
  height: 85vh;
}
</style>