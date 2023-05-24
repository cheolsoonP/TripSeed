<template>
  <v-row>
    <v-col>
      <v-textarea
        class="pv-tex-2"
        placeholder="댓글을 입력하세요"
        rows="1"
        auto-grow
        prepend-icon="mdi-comment"
        v-model="replyContent"
      ></v-textarea>
    </v-col>
    <v-col cols="auto">
      <v-btn color="primary" elevation="0" @click="addReply">등록</v-btn>
    </v-col>
  </v-row>
</template>

<script>
import { postReply } from "@/api/board";
import { mapActions, mapState } from "vuex";

const userStore = "userStore";
const boardStore = "boardStore";

export default {
  name: "BoardDetailReaction",
  data() {
    return {
      replyContent: "",
      postId: "",
    };
  },
  created() {
    this.postId = this.$route.params.postId;
  },
  computed: {
    ...mapState(userStore, ["userId", "userNickname"]),
  },
  methods: {
    ...mapActions(boardStore, ["getReplyListAction"]),
    addReply() {
      let body = {
        postId: this.postId,
        reply: {
          writerId: this.userId,
          postId: this.postId,
          replyContent: this.replyContent,
        },
      };
      postReply(
        body,
        () => {
          this.getReplyListAction(this.postId);
          this.replyContent = "";
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style></style>
