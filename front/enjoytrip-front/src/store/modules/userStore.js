import { loginUserApi } from "@/api/user";

const userStore = {
  namespaced: true,
  state: {
    userId: "",
    userName: "",
    userNickname: "",
    userEmail: "",
    authToken: "",
    isLogin: false,
    authFail: false,
  },
  getters: {
    isLogedIn(state) {
      return !!state.isLogin;
    },
    getToken(state) {
      return !!state.authToken;
    },
  },
  mutations: {
    SET_INIT_USER(state) {
      state.authToken = "";
      state.userId = "";
      state.userName = "";
      state.userNickname = "";
      state.userEmail = "";
      state.isLogin = false;
      state.authFail = false;
      state.profile = null;
    },
    SET_AUTH_USER(state, info) {
      state.authToken = info.authToken;
      state.userId = info.userId;
      state.userName = info.userName;
      state.userNickname = info.userNickname;
      state.userEmail = info.userEmail;
      state.isLogin = true;
      state.authFail = false;
      state.profile = info.profile;
    },
    SET_AUTH_FAIL(state) {
      state.isLogin = false;
      state.authFail = true;
    },
  },
  actions: {
    loginUserAction: async ({ commit }, body) => {
      await loginUserApi(
        body,
        ({ data }) => {
          commit("SET_AUTH_USER", data);
        },
        (error) => {
          commit("SET_INIT_USER");
          commit("SET_AUTH_FAIL");
          console.log(error);
        }
      );
    },
    initUserInfoAction: ({ commit }) => {
      commit("SET_INIT_USER");
    },
  },
};

export default userStore;
