<template>
  <v-container>
    <div class="pl-2">
      김싸피
      <span class="text-overline"> | 2022.05.21 12:24</span>
    </div>
    <v-card class="mx-auto" color="grey lighten-5" elevation="0">
      <v-list-item class="px-4 my-2">
        댓글 내용입니다. 이글 너무 좋아요
      </v-list-item>

      <v-card-actions class="px-4">
        <v-btn outlined rounded text color="primary"> 답글 </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
  <!-- <v-card class="mx-auto my-4" width="100%" outlined>
    <v-list-item>
      <v-list-item-content>
        <div class="text-h6">
          김싸피
          <span class="text-overline"> | 2022.05.21 12:24</span>
        </div>
        <v-list-item-content class="subtitle-2">댓글 내용입니다. 이글 너무 좋아요</v-list-item-content>
      </v-list-item-content>
    </v-list-item>

    <v-card-actions>
      <v-btn outlined rounded text color="primary"> 답글 </v-btn>
    </v-card-actions>
  </v-card> -->
</template>

<script>
export default {
  name: "BoardDetailComment",
};
</script>

<style>
</style>