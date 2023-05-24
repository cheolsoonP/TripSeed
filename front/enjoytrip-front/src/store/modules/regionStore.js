import { sidoList, gugunList } from "@/api/region";

const regionStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ gugunCode: null, gugunName: "시도를 선택해주세요." }],
    hotplaceSido: "",
    hotplaceGugun: "",
  },
  getters: {},
  mutations: {
    SET_SIDO_LIST(state, sidos) {
      state.guguns = [];
      state.sidos = [];
      sidos.forEach((sido) => {
        state.sidos.push({ value: sido.sidoCode, text: sido.sidoName });
      });
    },
    SET_GUGUN_LIST(state, guguns) {
      state.guguns = [];
      guguns.forEach((gugun) => {
        state.guguns.push({ gugunCode: gugun.gugunCode, gugunName: gugun.gugunName });
      });
    },
    INIT_HOTPLACE_SIDO_GUGUN(state) {
      state.hotplaceSido = null;
      state.hotplaceGugun = null;
    },
    SET_HOTPLACE_SIDO(state, sidoCode) {
      function findSido(item) {
        if (item.value === sidoCode) return true;
      }
      const index = state.sidos.findIndex(findSido);
      state.hotplaceSido = state.sidos.at(index);
    },
    SET_HOTPLACE_GUGUN(state, gugun) {
      state.hotplaceGugun = gugun;
    },
  },
  actions: {
    getSido: ({ commit }) => {
      sidoList(
        ({ data }) => {
          commit("SET_SIDO_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getGugun: ({ commit }, sidoCode) => {
      gugunList(
        sidoCode,
        ({ data }) => {
          console.log(data);
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    changeHotplaceSidoAction: ({ commit }, sido) => {
      commit("SET_HOTPLACE_SIDO", sido);
    },
    changeHotplaceGugunAction: ({ commit }, gugun) => {
      commit("SET_HOTPLACE_GUGUN", gugun);
    },
    initHotplaceSidoGugunAction: ({ commit }) => {
      commit("INIT_HOTPLACE_SIDO_GUGUN");
    },
  },
};

export default regionStore;
