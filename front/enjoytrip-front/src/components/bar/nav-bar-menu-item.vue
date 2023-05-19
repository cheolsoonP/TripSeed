<template>
  <div>
    <v-btn
      class="d-none d-flex"
      v-for="menu in menus"
      :key="menu.title"
      :to="menu.url"
      text
    >
      {{ menu.title }}
    </v-btn>
  </div>
</template>

<script>
export default {
  name: "NavBarMenuItem",
  data() {
    return {
      menus: [
        { title: "나만의 여행 계획", url: "/plan" },
        { title: "핫 플레이스", url: "/hotplace" },
        { title: "여행 꿀팁 공유", url: "/board" },
      ],
    };
  },
};
</script>

<style></style>
