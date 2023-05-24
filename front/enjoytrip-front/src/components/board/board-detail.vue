<template>
  <v-container>
    <board-detail-article />

    <v-divider />

    <v-list>
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title>
            <v-col class="pa-0">
              <span>댓글</span>
              <span> {{ replys.length }} </span>
            </v-col>
          </v-list-item-title>
          <board-detail-reaction />
        </v-list-item-content>
      </v-list-item>

      <v-list-item v-for="(reply, index) in replys" :key="index">
        <board-detail-comment :reply="reply" />
      </v-list-item>
    </v-list>
  </v-container>
</template>

<script>
import BoardDetailArticle from "@/components/board/board-detail-article.vue";
import BoardDetailComment from "@/components/board/board-detail-comment.vue";
import BoardDetailReaction from "@/components/board/board-detail-reaction.vue";
import { mapState, mapActions } from "vuex";

const userStore = "userStore";
const boardStore = "boardStore";

export default {
  components: { BoardDetailArticle, BoardDetailReaction, BoardDetailComment },
  data() {
    return {
      postId: "",
    };
  },
  created() {
    this.postId = this.$route.params.postId;
    this.getReplyListAction(this.postId);
  },
  computed: {
    ...mapState(userStore, ["userId", "userNickname"]),
    ...mapState(boardStore, ["replys"]),
  },
  methods: {
    ...mapActions(boardStore, ["getReplyListAction"]),
  },
};
</script>

<style></style>
