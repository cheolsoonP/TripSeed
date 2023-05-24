import { postListApi, userPostListApi } from "@/api/board";

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
        state.posts.push(post);
      });
    },
  },
  actions: {
    getPostList: ({ commit }, param) => {
      postListApi(
        param,
        ({ data }) => {
          commit("SET_POST_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getUserPostList: ({ commit }, param) => {
      userPostListApi(
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
