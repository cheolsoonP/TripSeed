import { getAttractionListApi, getHotplaceListApi } from "@/api/attraction";

const attractionStore = {
  namespaced: true,
  state: {
    attractions: [],
    attractionCount: 0,
  },
  getters: {
    filteredAttractions: (state) => (gugunCode) => {
      // 구군 선택 시 : 시도별 attractions에서 필터링
      if (gugunCode) {
        return state.attractions.filter((attraction) => attraction.gugunCode === gugunCode);
      } else {
        return state.attractions;
      }
    },
  },
  mutations: {
    SET_ATTRACTION_LIST(state, attractions) {
      state.attractions = [];
      attractions.forEach((attraction) => {
        state.attractions.push(attraction);
      });
      state.attractionCount = 10;
    },
    INIT_ATTRACTION_LIST(state) {
      state.attractions = [];
      state.attractionCount = 0;
    },
  },
  actions: {
    getAttractionListAction: ({ commit }, param) => {
      console.log(param);
      getAttractionListApi(
        param,
        ({ data }) => {
          console.log(data);
          commit("SET_ATTRACTION_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    initAttractionListAction: ({ commit }) => {
      commit("INIT_ATTRACTION_LIST");
    },
    getHotplaceListAction: ({ commit }, param) => {
      getHotplaceListApi(
        param,
        ({ data }) => {
          console.log(data);
          commit("SET_ATTRACTION_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default attractionStore;
