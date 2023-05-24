<template>
  <v-container>
    <v-row class="pa-3">
      <v-col cols="4" v-if="tempPlan.thumnail !== null">
        <v-img :src="tempPlan.thumnail" max-height="300" max-width="300" contain></v-img>
      </v-col>
      <v-col cols="tempPlan.thumbnail == null ? 12 : 8">
        <v-card-title class="py-3"> 여행 제목을 입력하세요 </v-card-title>
        <v-list-item>
          <v-text-field
            clearable
            v-model="tempPlan.title"
            placeholder="여행 제목"
            solo
            hide-details
            @blur="onChangeTitle"
          >
          </v-text-field>
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
import { mapActions, mapState } from "vuex";

const planStore = "planStore";
const userStore = "userStore";

export default {
  name: "PlanWriteInfo",
  data() {
    return {
      fileRules: [
        (value) => !value || value.size < 5000000 || "이미지 용량은 5MB를 초과할 수 없습니다.",
      ],
    };
  },
  computed: {
    ...mapState(userStore, ["userId"]),
    ...mapState(planStore, ["tempPlan"]),
  },
  methods: {
    ...mapActions(planStore, ["updateDateAction", "updateTitleAction", "updateThumnailAction"]),
    onChangeFile(file) {
      if (file !== null) {
        let body = {
          file: file,
          thumnail: URL.createObjectURL(file),
        };
        this.updateThumnailAction(body);
      } else {
        let body = {
          file: null,
          thumnail: null,
        };
        this.updateThumnailAction(body);
      }
    },
    onChangeTitle(e) {
      this.updateTitleAction(e.target.value);
    },
  },
};
</script>
