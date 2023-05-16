<template>
  <v-app>
    <nav-bar />
    <v-main>
      <router-view />
    </v-main>
    <v-footer color="primary lighten-1" padless>
      <v-row justify="center" no-gutters>
        <v-btn
          v-for="link in links"
          :key="link"
          color="white"
          text
          rounded
          class="my-2"
        >
          {{ link }}
        </v-btn>
        <v-col class="primary lighten-2 py-4 text-center white--text" cols="12">
          {{ new Date().getFullYear() }} — <strong>Enjoytrip</strong>
        </v-col>
      </v-row>
    </v-footer>
  </v-app>
</template>

<script>
import NavBar from "@/components/bar/nav-bar";

export default {
  name: "App",
  components: {
    NavBar,
  },
  data: () => ({
    // footer link list
    links: ["Home", "About Us", "Team", "Services", "Blog", "Contact Us"],
  }),
};
</script>
