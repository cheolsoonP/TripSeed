<template>
  <v-card tile :to='"/board/view/"+post.postId'>
    <v-row>
      <v-col cols="8">
        <v-card-title>
          <span class="text-h4 font-weight-bold">{{post.title}}</span>
        </v-card-title>
        <v-card-subtitle>
          <span class="text-h6 font-weight-light">{{post.sidoName}} {{ post.gugunName }}</span>
        </v-card-subtitle>
        <v-card-text class="text-h5 font-weight-bold">
          {{ post.content }}
        </v-card-text>

        <v-row>
          <v-col cols="6">
            <v-list-item>
              <v-list-item-avatar>
                <v-icon>mdi-account</v-icon>
              </v-list-item-avatar>

              <v-list-item-content>
                <v-list-item-title>{{ post.writerId }}</v-list-item-title>
              </v-list-item-content>
            </v-list-item>
          </v-col>
          <v-col cols="6">
            <v-list-item>
              <v-row>
                <v-col v-for="reaction in reactions" :key="reaction.icon">
                  <v-icon>{{ reaction.icon }}</v-icon>
                  <span> {{ reaction.cnt }}</span>
                </v-col>
              </v-row>
            </v-list-item>
          </v-col>
        </v-row>
      </v-col>
      <!-- <v-col cols="4">
        <v-img src="" aspect-ratio="1" style="background-color: black" />
      </v-col> -->
    </v-row>
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
        { icon: "mdi-heart", cnt: "256" },
        { icon: "mdi-comment", cnt: "256" },
      ],
    };
  },
};
</script>

<style></style>
