import Vue from "vue";
import Vuex from "vuex";
// import createPersistedState from "vuex-persistedstate";
// module import
import attractionStore from "@/store/modules/attractionStore";
import boardStore from "@/store/modules/boardStore";
import planStore from "@/store/modules/planStore";
import regionStore from "@/store/modules/regionStore";
import userStore from "@/store/modules/userStore";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    attractionStore,
    boardStore,
    planStore,
    regionStore,
    userStore,
  },
  plugins: [
    // createPersistedState({
    //   // 브라우저 종료시 제거하기 위해 localStorage가 아닌 sessionStorage로 변경. (default: localStorage)
    //   storage: sessionStorage,
    // }),
  ],
});
