<template>
  <v-container class="px-8">
    <div class="form-header">
      <v-row class="text-h6 align-center">
        <v-col cols="2"> 제목 </v-col>
        <v-col class="py-0">
          <v-text-field
            placeholder="제목을 입력하세요"
            v-model="title"
            outlined
            rounded
            full-width
            hide-details
          ></v-text-field>
        </v-col>
        <v-col cols="auto">
          <v-btn 
            x-large rounded elevation="0" 
            color="primary"
            @click="onClickWritePost"
          >
            게시하기
          </v-btn>
        </v-col>
      </v-row>

      <v-row align="center" class="text-h6 py-0">
        <v-col cols="2"> 지역 </v-col>
        <v-col class="d-flex px-0">
          <v-col>
            <v-select
              dark
              background-color="primary"
              v-model="sidoCode"
              :items="sidos"
              label="시 • 도"
              solo
              hide-details
              @change="getGugun"
            ></v-select>
          </v-col>
          <v-col cols="auto" class="px-3">
            <v-icon>mdi-chevron-right</v-icon>
          </v-col>
          <v-col>
            <v-select
              dark
              background-color="primary"
              v-model="gugunCode"
              item-text="gugunName"
              item-value="gugunCode"
              :items="guguns"
              label="군 • 구"
              solo
              hide-details
            ></v-select>
          </v-col>
        </v-col>
      </v-row>

      <v-row><v-divider /></v-row>
    </div>
    <div>
      <v-row class="text-h6">
        <v-col cols="2">썸네일 이미지</v-col>
        <v-col cols="3">
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
          ></v-file-input>
        </v-col>
      </v-row>
      <v-row>미리보기</v-row>
      <v-row>
        <v-img
          v-if="thumnail !== null"
          :src="thumnail"
          max-height="300"
          max-width="300"
        ></v-img>
      </v-row>
    </div>
    <div class="pt-3">
      <v-row class="text-h6 pa-3">
        <v-textarea
          placeholder="내용을 입력하세요"
          v-model="content"
          outlined
          full-width
          row-height="48"
          auto-grow
          hide-details
        ></v-textarea>
      </v-row>
    </div>
  </v-container>
</template>

<script>
import { writePostApi } from '@/api/board';
import { mapActions, mapState } from "vuex";

const regionStore = "regionStore";
const userStore = "userStore";

export default {
  name: "BoardWrite",
  data() {
    return {
      sidoCode: null,
      sidoName: null,
      gugunCode: null,
      gugunName: null,
      title: "",
      content: "",
      thumnail: null,
      file: null,
      fileRules: [
        value => !value || value.size < 5000000 || '이미지 용량은 5MB를 초과할 수 없습니다.',
      ],
    };
  },
  computed: {
    ...mapState(regionStore, ["sidos", "guguns"]),
    ...mapState(userStore, ["userId", "userNickname"]),
  },
  methods: {
    ...mapActions(regionStore, ["getGugun"]),

    onClickWritePost() {
      if (this.title === "") {
        this.errorMsg = "제목을 입력해주세요."
        return;
      }
      else if (this.conetent === "") {
        this.errorMsg = "내용을 입력해주세요."
        return;
      }
      const formData = new FormData();
      formData.append("file", this.file);

      let body = {
        sidoCode: this.sidoCode,
        gugunCode: this.gugunCode,
        title: this.title,
        content: this.content,
        writerId: this.userId,
        writerNickname: this.userNickname,
        file: this.file,
      }
      
      writePostApi(
        body,
        () => {
          alert("게시글 업로드 성공!")
          this.$router.push("/board/list");
        },
        (error) => {
          console.log(error);
        }
      );
    },
    onChangeFile(file) {
      if (file !== null) {
        this.thumnail = URL.createObjectURL(file);
        this.file = file;
      } else {
        this.thumnail = null;
        this.file = null;
      }
    }
  },
};
</script>

<style>
.form-header {
  position: sticky;
  top: 56px;
  background-color: #ffffff;
  padding: 16px;
  z-index: 1;
}

</style>
