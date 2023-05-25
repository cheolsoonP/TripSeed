<template>
  <v-container>
    <div class="pl-2">
      {{ reply.userNickname }}
      <span class="text-overline"> {{ reply.updateDate }}</span>
    </div>
    <v-card class="mx-auto" color="grey lighten-5" elevation="0">
      <v-list-item class="px-4 my-2"> {{ reply.replyContent }} </v-list-item>

      <v-card-actions class="px-4">
        <v-btn outlined rounded text color="primary"> 답글 </v-btn>
      </v-card-actions>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "BoardDetailComment",
  props: {
    reply: Object,
  },
  data() {
    return {
      postId: "",
    };
  },
};
</script>

<style></style>
