import { sidoList, gugunList } from "@/api/region";

const regionStore = {
  namespaced: true,
  state: {
    sidos: [{ value: null, text: "선택하세요" }],
    guguns: [{ gugunCode: null, gugunName: "시도를 선택해주세요." }],
  },
  getters: {},
  mutations: {
    SET_SIDO_LIST(state, sidos) {
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
          commit("SET_GUGUN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default regionStore;
