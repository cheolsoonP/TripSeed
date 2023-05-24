<template>
  <div>팔로워목록</div>
</template>

<script>
import { mapState } from "vuex";
import { getFollowerListApi } from "@/api/user";

const userStore = "userStore";

export default {
  name: "UserInfoFollowers",
  data() {
    return {};
  },
  computed: {
    ...mapState(userStore, ["userId"]),
  },
  methods: {},
  created() {
    getFollowerListApi(
      this.userId,
      (data) => {
        console.log(data);
      },
      (error) => {
        console.log(error);
      }
    );
  },
};
</script>

<style></style>
