import { getReplyList, postListApi, userPostListApi } from "@/api/board";

const boardStore = {
  namespaced: true,
  state: {
    posts: [],
    replys: [],
  },
  getters: {},
  mutations: {
    SET_POST_LIST(state, posts) {
      state.posts = [];
      posts.forEach((post) => {
        state.posts.push(post);
      });
    },
    SET_REPLY_LIST(state, replys) {
      state.replys = [];
      replys.forEach((reply) => {
        state.replys.push(reply);
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
    getReplyListAction: ({ commit }, body) => {
      getReplyList(
        body,
        ({ data }) => {
          commit("SET_REPLY_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default boardStore;
