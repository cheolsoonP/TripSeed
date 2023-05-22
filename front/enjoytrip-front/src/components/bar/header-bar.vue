<template>
  <v-container>
    <v-card elevation="0" color="#a0ffd6" class="my-4">
      <v-row class="px-4">
        <v-col>
          <v-card tile elevation="0" color="transparent">
            <v-col class="text-h5 text--primary"> {{ title }} </v-col>
            <v-col class=" py-0">
              <div class="text-h7 text--primary" v-html="content"></div>
            </v-col>

            <v-card-actions v-if="need_btn">
              <div class="pt-2">
                <v-btn elevation="0" color="primary" :to="url">
                  <v-icon>{{ btn_icon }}</v-icon>
                  <span class="pl-1">{{ btn_text }}</span>
                </v-btn>
              </div>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="auto" class="d-flex justify-center">
          <v-img :src="imgsrc" max-width="200" contain/>
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
    need_btn: { type: Boolean, default: true},
    btn_icon: String,
    btn_text: String ,
    imgsrc: String 
  },
};
</script>

<style></style>
