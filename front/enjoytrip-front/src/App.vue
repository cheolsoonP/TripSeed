<template>
  <v-app>
    <v-app-bar
      app
      color="white"
    >
      <div class="d-flex align-center">
        <v-btn 
          plane 
          to="/"
          max-height="100"
          max-width="140"
        >
          <v-img 
            src="./assets/logo_init.svg" 
            max-height="100"
            max-width="150">
          </v-img>
          </v-btn>
      </div>

      <v-spacer></v-spacer>
      <div>
        <v-btn class="ml-2" to="/plans" text color="black">나만의 여행 계획</v-btn>
        <v-btn class="ml-2" to="/hotplace" text color="black">핫플레이스</v-btn>
        <v-btn class="ml-2" to="/board" text color="primary">여행 꿀팁 공유</v-btn>
        <v-btn class="ml-2" to="/user/login" text color="primary">로그인</v-btn>
        <v-btn class="ml-2" to="/user/join" text color="primary">회원가입</v-btn>
        <!-- <v-btn to="/user/join">마이페이지</v-btn> -->
      </div>
    </v-app-bar>

    <v-main>
      <router-view/>
    </v-main>
    <v-footer
      color="primary lighten-1"
      padless
    >
      <v-row
        justify="center"
        no-gutters
      >
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
        <v-col
          class="primary lighten-2 py-4 text-center white--text"
          cols="12"
        >
        {{ new Date().getFullYear() }} — <strong>Enjoytrip</strong>
        </v-col>
      </v-row>
    </v-footer>
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    // footer link list
    links: [
        'Home',
        'About Us',
        'Team',
        'Services',
        'Blog',
        'Contact Us',
      ],
  }),
};
</script>
