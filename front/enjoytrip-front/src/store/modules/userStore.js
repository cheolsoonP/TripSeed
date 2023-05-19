import { loginUserApi } from "@/api/user";

const userStore = {
  namespaced: true,
  state: {
    userId: "",
    userName: "",
    userNickname: "",
    authToken: "",
    isLogin: false,
    authFail: false,
  },
  getters: {},
  mutations: {
    SET_INIT_USER(state) {
      state.authToken = "";
      state.userId = "";
      state.userName = "";
      state.userNickname = "";
      state.isLogin = false;
      state.authFail = false;
    },
    SET_AUTH_USER(state, info) {
      state.authToken = info.authToken;
      state.userId = info.userId;
      state.userName = info.userName;
      state.userNickname = info.userNickname;
      state.isLogin = true;
      state.authFail = false;
    },
    SET_AUTH_FAIL(state) {
      state.isLogin = false;
      state.authFail = true;
    },
  },
  actions: {
    loginUserAction: ({ commit }, body) => {
      loginUserApi(
        body,
        ({ data }) => {
          commit("SET_AUTH_USER", data);
        },
        (error) => {
          commit("SET_AUTH_FAIL");
          console.log(error);
        }
      );
    },
    initUserInfoAction: ({ commit }) => [
      () => {
        commit("SET_INIT_USER");
      },
      (error) => {
        console.log(error);
      },
    ],
  },
};

export default userStore;
