<template>
  <v-card
    elevation="0"
    tile
    :to="'/board/view/' + post.postId"
    min-width="100%"
  >
    <v-card-title>
      <v-col cols="12">
        <v-row class="pb-1" v-if="!post.sidoName && !post.gugunName">
          <v-col cols="auto" class="pa-0 pr-1">
            <v-icon>mdi-map-marker-off-outline</v-icon>
          </v-col>
        </v-row>
        <v-row class="pb-1" v-else>
          <v-col cols="auto" class="pa-0 pr-1">
            <v-icon>mdi-map-marker</v-icon>
          </v-col>

          <v-col class="pa-0">
            <h6>{{ post.sidoName }} {{ post.gugunName }}</h6>
          </v-col>
        </v-row>
      </v-col>

      <v-row>
      <v-col>
        <h4>{{ post.title }}</h4>
        <v-list-item class="pt-2 px-0">
          {{ previewContent(post.content, 120) }}
        </v-list-item>
      </v-col>

      <v-col cols="3" v-if="post.image !== null">
        <v-img
          :src="post.image"
          aspect-ratio="1"
          fill-height
        ></v-img>
      </v-col>
      </v-row>
    </v-card-title>
    <v-col>
      <v-row class="d-flex justify-space-between">
        <v-col cols="4" class="pd-0">
          <v-card-text class="pa-0">
            <span class="pr-4">
              <v-icon>mdi-account</v-icon>
              <span class="pl-1">{{ post.writerId }}</span>
            </span>
          </v-card-text>
        </v-col>
        <v-col cols="auto" class="pd-0">
          <v-card-text class="pa-0">
            <span
              class="pr-4"
              v-for="reaction in reactions"
              :key="reaction.icon"
            >
              <v-icon>{{ reaction.icon }}</v-icon>
              <span class="pl-1"> {{ reaction.cnt }}</span>
            </span>
          </v-card-text>
        </v-col>
      </v-row>
    </v-col>    

    <v-divider />
  </v-card>
</template>

<script>
export default {
  name: "BoardListItem",
  props: {
    post: {},
  },
  data() {
    return {
      reactions: [
        { icon: "mdi-heart-outline", cnt: "120" },
        { icon: "mdi-comment-outline", cnt: "10" },
        { icon: "mdi-eye-outline", cnt: "256" },
      ],
    };
  },
  methods: {
    previewContent(content, maxLength) {
      if (content.length > maxLength) {
        return content.substring(0, maxLength) + "\u00a0\u00a0...더 보기";
      }
      return content;
    },
  },
};
</script>

<style></style>
