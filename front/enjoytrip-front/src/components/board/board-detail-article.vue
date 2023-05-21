<template>
  <v-col>
    <v-row class="text-h7 justify-space-between">
      <div class="d-flex">
      <v-col cols="auto" v-if="!post.sidoName">
        <v-btn elevation="0" color="transparent"> 전체 </v-btn>
      </v-col>
      <v-col cols="auto" class="pr-1">
        <v-btn elevation="0" color="transparent"> {{ post.sidoName }} </v-btn>
      </v-col>
      <v-col cols="auto" v-if="post.gugunName" class="px-0 d-flex align-center">
        <v-icon>mdi-chevron-right</v-icon>
      </v-col>
      <v-col cols="auto" class="pl-1">
        <v-btn elevation="0" color="transparent"> {{ post.gugunName }} </v-btn>
      </v-col>
      </div>
      <div>
      <v-col cols="auto" class="justify-end">
        <v-menu offset-y bottom left>
          <template v-slot:activator="{ on, attrs }">
            <v-btn elevation="0" color="transparent" v-bind="attrs" v-on="on">
              <v-icon>mdi-dots-vertical</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item>
              <v-list-item-content> 수정하기 </v-list-item-content>
              <v-list-item-icon>
                <v-icon>mdi-pencil-outline</v-icon>
              </v-list-item-icon>
            </v-list-item>
            <v-list-item @click="onClickDeletePost">
              <v-list-item-content class="red--text text--lighten-2">
                삭제하기
              </v-list-item-content>
              <v-list-item-icon>
                <v-icon color="red lighten-2">mdi-trash-can-outline</v-icon>
              </v-list-item-icon>
            </v-list-item>
          </v-list>
        </v-menu>
      </v-col>
      </div>
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

    <v-row>
        <v-img
          v-if="post.image !== null"
          :src="post.image"
          max-height="300"
          max-width="300"
        ></v-img>
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

<style></style>
