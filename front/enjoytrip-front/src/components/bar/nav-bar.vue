<template>
  <div>
    <v-app-bar app flat elevation="2" color="white">
      <v-app-bar-title>
        <img
          src="@/assets/logo_title.svg"
          height="40px"
          @click="goToPage('/')"
        />
      </v-app-bar-title>

      <v-spacer />
      <template v-if="$vuetify.breakpoint.mdAndDown">
        <v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
      </template>
      <template v-else>
        <nav-bar-menu-item class="d-flex" />
        <nav-bar-user-item />
      </template>
    </v-app-bar>
    <v-navigation-drawer v-model="drawer" absolute right temporary>
      <v-list-item class="py-3 justify-end">
        <img src="@/assets/logo_icon.svg" height="40px" />
      </v-list-item>
      <nav-bar-menu-item />
      <nav-bar-user-item />
    </v-navigation-drawer>
  </div>
</template>

<script>
import NavBarMenuItem from "./nav-bar-menu-item.vue";
import NavBarUserItem from "./nav-bar-user-item.vue";

export default {
  name: "NavBar",
  components: {
    NavBarMenuItem,
    NavBarUserItem,
  },
  data() {
    return {
      drawer: false,
    };
  },
  methods: {
    goToPage(path) {
      this.$router.push(path);
    },
  },
};
</script>
<style>

</style>
