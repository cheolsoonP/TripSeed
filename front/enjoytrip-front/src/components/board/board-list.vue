<template>
  <v-container>
    <v-row>
      <v-col cols="3"><side-bar/></v-col>
      <v-col cols="9">
        <v-list>
          <v-list-item v-for="post, index in posts" :key="index">
            <board-list-item :post="post"/>
          </v-list-item>
        </v-list>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import SideBar from "../bar/side-bar.vue"
import BoardListItem from "@/components/board/board-list-item.vue"
import { mapActions, mapState } from "vuex"

const regionStore = "regionStore";
const boardStore = "boardStore";

export default {
  components: { SideBar, BoardListItem },
  data() {
    return {

    }
  },

  computed: {
    ...mapState(regionStore, ["sidos"]),
    ...mapState(boardStore, ["posts"]),
  },
  created() {
    this.getSido();
    this.getPostList();
    console.log(this.posts);
  },
  methods: {
    ...mapActions(regionStore, ["getSido"]),
    ...mapActions(boardStore, ["getPostList"]),
  }
}
</script>

<style>

</style>