import { getPlanDetailApi, getPlanListApi, getRouteApi } from "@/api/plan";

const planStore = {
  namespaced: true,
  state: {
    plans: [],
    planDetail: {},
    routes: [
      {
        planId: "",
        attractionId: "",
        memo: "",
        visitTime: "",
        image: "",
      },
    ],
  },
  getters: {},
  mutations: {
    SET_PLAN_LIST(state, plans) {
      state.plans = [];
      plans.forEach((plan) => {
        state.plans.push({
          planId: plan.planId,
          userId: plan.userId,
          planTitle: plan.planTitle,
          startDate: plan.startDate,
          endDate: plan.endDate,
          complete: plan.complete,
          image: plan.image,
        });
      });
    },
    SET_PLAN_DETAIL(state, planDetail) {
      state.planDetail = {};
      state.planDetail = planDetail;
    },
    SET_PLAN_ROUTES(state, routes) {
      state.routes = [];
      routes.forEach((plan) => {
        state.routes.push({ planId: plan.planId });
      });
    },
  },
  actions: {
    getPlanListAction: ({ commit }, userId) => {
      getPlanListApi(
        userId,
        ({ data }) => {
          commit("SET_PLAN_LIST", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getPlanDetailAction: ({ commit }, planId) => {
      getPlanDetailApi(
        planId,
        ({ data }) => {
          commit("SET_PLAN_DETAIL", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
    getRouteAction: ({ commit }, planId) => {
      getRouteApi(
        planId,
        ({ data }) => {
          commit("SET_PLAN_ROUTES", data);
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};

export default planStore;
