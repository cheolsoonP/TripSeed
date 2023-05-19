<template>
  <v-container>
    <v-card elevation="0" color="#a0ffd6" class="my-4">
      <v-row class="px-4">
        <v-col>
          <v-card tile elevation="0" color="transparent">
            <v-col class="text-h5 text--primary pb-0"> {{ title }} </v-col>
            <v-col>
              <div class="text-h7 text--primary" v-html="content"></div>
            </v-col>

            <v-card-actions>
              <v-btn elevation="0" color="primary" :to="url">
                <v-icon>mdi-plus</v-icon>
                <span class="pl-1">{{ btntext }}</span>
              </v-btn>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="auto" class="d-flex justify-center">
          <img :src="imgsrc" alt="header_img" />
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "HeaderBar",
  components: {},
  props: {
    title: String,
    content: String,
    url: String,
    btntext: String ,
    imgsrc: String 
  },
};
</script>

<style></style>
