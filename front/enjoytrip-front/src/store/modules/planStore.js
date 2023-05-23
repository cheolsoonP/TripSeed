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
    tempPlan: {
      startDate: "2023-02-01",
      endDate: "2023-02-05",
      title:"임시제목",
    },
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
    UPDATE_DATE(state, body){
      state.tempPlan.startDate = body.startDate;
      state.tempPlan.endDate = body.endDate;
    }
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
    updateDateAction: ({commit}, body) => {
      commit("UPDATE_DATE", body);
    }
  },
};

export default planStore;
