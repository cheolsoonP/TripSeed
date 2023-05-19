<template>
  <v-container class="ma-10 d-flex justify-center" >
    <div>
      <div>
        <v-col class="d-flex justify-center">{{ post.sidoName }} > {{ post.gugunName }}</v-col>
          <v-col class="d-flex justify-center text-h4">{{ post.title }}</v-col>
        <v-row
          no-gutters
        >
          <v-col cols="2">{{ post.writerId }}</v-col>
          <v-col>{{ post.writeDate }}</v-col>
        </v-row>
        <v-row class="d-flex justify-end">
          <v-col cols="3">좋아요 {{ post.likeCount }}</v-col>
          <v-col cols="3">조회수 {{ post.viewCount }}</v-col>
        </v-row>
      </div>
      <div>
        <v-col cols="12" class="my-10" >{{ post.content }}</v-col>
      </div>
      <div> 
        <v-row>
          <v-col class="d-flex justify-end"><v-btn color="primary">수정하기</v-btn></v-col>
        </v-row>
      </div>
      <div>
        <v-col class="my-n5">댓글 {{ post.commentCount }}</v-col>
        <v-divider class="my-5"/>
        <div>
          <v-card
            class="mx-auto my-4"
            width="100%"
            outlined
          >
            <v-list-item three-line>
              <v-list-item-content>
                <div class="text-overline mb-4">
                  2022.05.21 12:24
                </div>
                <v-list-item-title class="text-h6 mb-1">
                  김싸피
                </v-list-item-title>
                <v-list-item-content class="subtitle-2">댓글 내용입니다. 이글 너무 좋아요</v-list-item-content>
              </v-list-item-content>
            </v-list-item>

            <v-card-actions>
              <v-btn
                outlined
                rounded
                text
                color="primary"
              >
                답글
              </v-btn>
            </v-card-actions>
          </v-card>
        </div>
    </div>      

    </div>
  </v-container>
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