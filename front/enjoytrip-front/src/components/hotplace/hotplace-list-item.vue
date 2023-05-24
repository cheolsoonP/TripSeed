<template>
  <div>
    <v-card width="200" height="200">
      <v-img :src="attraction.firstImage" width="200" height="200"></v-img>
    </v-card>
    <div class="mb-4 py-2">
      <span class="text-subtitle" v-if="attraction.title.length < 13">
        {{ attraction.title }}
      </span>
      <span class="text-subtitle" v-else>{{ attraction.title.slice(0, 12) }} ...</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "HotplaceListItem",
  props: {
    attraction: Object,
  },
  data() {
    return {};
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
