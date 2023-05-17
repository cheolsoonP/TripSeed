<template>
  <div>
    <v-container grid-list-xs>
      <v-row>{{ post.title }}</v-row>
      <v-row>{{ post.content }}</v-row>
    </v-container>
  </div>
</template>

<script>

import { getPost } from "@/api/board.js"

export default {
  name: "BoardDetail",
  data() {
    return {
      post: {},
    };
  },
  created() {
    let postId = this.$route.params.postId;
    getPost(
      postId,
      ({ data }) => {
        console.log(data)
        this.post = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
}
</script>

<style>

</style>