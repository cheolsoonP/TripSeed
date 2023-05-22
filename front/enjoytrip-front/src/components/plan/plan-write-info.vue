<template>
  <v-container>
    <v-row class="pa-3">
      <v-col cols="4" v-if="thumnail !== null">
        <v-img :src="thumnail" max-height="300" max-width="300" contain></v-img>
      </v-col>
      <v-col cols="thumbnail == null ? 12 : 8">
        <v-card-title class="py-3"> 여행 제목을 입력하세요 </v-card-title>
        <v-list-item>
          <v-text-field
            clearable
            placeholder="여행 제목"
            solo
            hide-details
          ></v-text-field>
        </v-list-item>
        <v-list-item class="mt-4">
          <v-list-item-content>
            <v-list-item-subtitle>썸네일 이미지</v-list-item-subtitle>
            <v-file-input
              @change="onChangeFile"
              color="primary"
              light
              chips
              counter
              show-size
              :rules="fileRules"
              accept="image/*"
              truncate-length="34"
              class="pt-1"
            ></v-file-input>
          </v-list-item-content>
        </v-list-item>
        <v-card-text class="py-0 m-2">
          ! 제목과 썸네일 이미지를 등록하지 않으면 기본으로 설정됩니다.
        </v-card-text>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "PlanWriteInfo",
  data() {
    return {
      thumnail: null,
      file: null,
      fileRules: [
        (value) =>
          !value ||
          value.size < 5000000 ||
          "이미지 용량은 5MB를 초과할 수 없습니다.",
      ],
    };
  },

  methods: {
    onChangeFile(file) {
      if (file !== null) {
        this.thumnail = URL.createObjectURL(file);
        this.file = file;
      } else {
        this.thumnail = null;
        this.file = null;
      }
    },
  },
};
</script>
