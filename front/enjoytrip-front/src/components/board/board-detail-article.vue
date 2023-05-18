<template>
  <v-col>
    <v-row class="text-h7">
      <v-col cols="auto" v-if="!post.sidoName">전체</v-col>
      <v-col cols="auto" class="pr-1">{{ post.sidoName }}</v-col>
      <v-col cols="auto" v-if="post.gugunName" class="px-0"
        ><v-icon>mdi-chevron-right</v-icon></v-col
      >
      <v-col cols="auto" class="pl-1">{{ post.gugunName }}</v-col>
    </v-row>

    <v-row class="justify-center text-h4 pa-3 pt-0">{{ post.title }}</v-row>
    <v-row class="d-flex justify-space-between px-4">
      <v-col cols="auto">
        <v-icon>mdi-account</v-icon>
        <span class="pl-2">{{ post.writerId }}</span>
      </v-col>
      <v-col cols="auto" class="d-flex justify-center">
        <div class="px-4">
        <v-icon>mdi-heart-outline</v-icon>
        <span class="pl-2">{{ post.likeCount }}</span>
        </div>
        <div class="px-4">
        <v-icon>mdi-eye-outline</v-icon>
        <span class="pl-2">{{ post.viewCount }}</span>
        </div>
      </v-col>
    </v-row>

    <v-row class="px-8 py-4">{{ post.content }}</v-row>

    <v-row class="px-4 justify-end">
      <v-col cols="auto">
        <v-icon>mdi-update</v-icon>
        <span class="pl-2 text-overline">{{ post.writeDate }}</span>
      </v-col>
    </v-row>
  </v-col>
</template>

<script>
import { getPost } from "@/api/board.js";

export default {
  name: "BoardDetailArticle",
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
        console.log(data);
        this.post = data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
};
</script>

<style>
</style>