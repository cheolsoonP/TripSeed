<template>
  <v-row>
    <v-col>
      <v-textarea
              class="pv-tex-2"
              placeholder="댓글을 입력하세요"
              rows="1"
              auto-grow
              prepend-icon="mdi-comment"
            ></v-textarea>
    </v-col>
    <v-col cols="auto">
      <v-btn color="primary" elevation="0">등록</v-btn>
    </v-col>
  </v-row>
</template>

<script>
export default {
  name: "BoardDetailReaction",

}
</script>

<style>

</style>