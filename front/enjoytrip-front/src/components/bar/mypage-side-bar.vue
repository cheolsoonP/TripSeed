<template>
  <v-card height="500" width="256" class="mx-auto">
    <v-navigation-drawer permanent>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6"> 마이페이지 </v-list-item-title>
        </v-list-item-content>
      </v-list-item>

      <v-divider></v-divider>

      <v-list dense nav>
        <v-list-item v-for="item in items" :key="item.title" :to="item.route">
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
  </v-card>
</template>

<script>
export default {
  name: "MypageSideBar",
  data() {
    return {
      items: [
        { title: "회원정보", icon: "mdi-file-document-edit-outline", route: "/user/info/detail" },
        { title: "내가 작성한 글", icon: "mdi-table-of-contents", route: "/user/info/content" },
        { title: "팔로워", icon: "mdi-account-arrow-left", route: "/user/info/followers" },
        { title: "팔로우", icon: "mdi-account-arrow-right", route: "/user/info/following" },
      ],
      right: null,
    };
  },
  computed: {},
  methods: {},
};
</script>

<style></style>
