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
import BoardListItem from "@/components/board/board-list-item.vue";
import { mapActions, mapState } from "vuex";

const boardStore = "boardStore";
const userStore = "userStore";

export default {
  name: "UserInfoContent",
  components: { BoardListItem },
  data() {
    return {};
  },
  computed: {
    ...mapState(userStore, ["userId"]),
    ...mapState(boardStore, ["posts"]),
  },
  created() {
    this.getUserPostList(this.userId);
  },
  methods: {
    ...mapActions(boardStore, ["getUserPostList"]),
  },
};
</script>

<style></style>
