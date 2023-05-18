<template>
  <div>

    <v-container >
      <!-- github-markdown-light -->

      <v-row>{{ post.sidoName }} > {{ post.gugunName }}</v-row>
      <v-row>{{ post.title }}</v-row>
      <v-row>
        <v-col>{{ post.writerId }}</v-col>
        <v-col>{{ post.writerDate }}</v-col>
      </v-row>
      <v-row>
        <v-col>좋아요 {{ post.likeCount }}</v-col>
        <v-col>조회수 {{ post.viewCount }}</v-col>
      </v-row>
      
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