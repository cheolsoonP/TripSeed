<template>
  <div>
    <v-card class="my-1 pa-0" max-width="300">
      <v-img tile max-width="300" max-height="180">
        <v-img :src="route.image" contain></v-img>
      </v-img>
      <v-card-title class="mx-1"> {{ route.title }} </v-card-title>

      <v-card-subtitle class="mx-1 py-1"> {{ route.addr }} </v-card-subtitle>

      <v-card-actions @click="show = !show">
        <v-btn color="primary" text> 메모 </v-btn>

        <v-spacer></v-spacer>

        <v-btn icon>
          <v-icon>{{ show ? "mdi-chevron-up" : "mdi-chevron-down" }}</v-icon>
        </v-btn>
      </v-card-actions>

      <v-expand-transition>
        <div v-show="show">
          <v-divider></v-divider>
          <v-textarea solo name="input-7-4" label="메모 작성하기">{{ route.memo }}</v-textarea>
        </div>
      </v-expand-transition>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "RouteItem",
  data() {
    return {
      show: false,
    };
  },
  props: {
    route: {},
  },
};
</script>

<style></style>
