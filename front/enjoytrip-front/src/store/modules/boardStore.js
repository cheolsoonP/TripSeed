import { postList } from "@/api/board";

const boardStore = {
  namespaced: true,
  state: {
    posts: [],
  },
  getters: {},
  mutations: {
    SET_POST_LIST(state, posts) {
      state.posts = [];
      posts.forEach((post) => {
        state.posts.push({
          postId: post.postId,
          title: post.title,
          writerId: post.writerId,
          content: post.content,
          likeCount: post.likeCount,
          viewCount: post.viewCount,
          writeDate: post.writeDate,
          updateDate: post.updateDate,
          sidoCode: post.sidoCode,
          sidoName: post.sidoName,
          gugunCode: post.gugunCode,
          gugunName: post.gugunName,
        });
      });
    },
  },
  actions: {
    getPostList: ({ commit }, param) => {
      console.log(param);
      postList(
        param,
        ({ data }) => {
          commit("SET_POST_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default boardStore;
