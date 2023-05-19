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
              <span> 2 </span>
            </v-col>
          </v-list-item-title>
          <board-detail-reaction />
        </v-list-item-content>
      </v-list-item>

      <v-list-item><board-detail-comment /></v-list-item>
      <v-list-item><board-detail-comment /></v-list-item>
    </v-list>
  </v-container>
</template>

<script>
import BoardDetailArticle from "@/components/board/board-detail-article.vue"
import BoardDetailComment from "@/components/board/board-detail-comment.vue"
import BoardDetailReaction from "@/components/board/board-detail-reaction.vue"

export default {
  components: { BoardDetailArticle, BoardDetailReaction, BoardDetailComment},
}
</script>

<style>

</style>