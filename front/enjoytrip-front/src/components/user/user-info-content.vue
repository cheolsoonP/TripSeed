<template>
  <div>
    <v-container>
      <v-list>
        <v-list-item v-for="(post, index) in posts" :key="index">
          <board-list-item :post="post" />
        </v-list-item>
      </v-list>
    </v-container>
  </div>
</template>

<script>
export default {
  name: "UserInfoContent",
  data() {
    return {};
  },
  computed: {},
  methods: {},
};
</script>

<style></style>
