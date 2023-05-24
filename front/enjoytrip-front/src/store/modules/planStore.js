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
      dates: [],
      title: "",
      thumnail: "",
      file: "",
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
    INIT_PLAN_INFO(state) {
      state.tempPlan.title = "새 여행일정";
      let today = new Date(Date.now() - new Date().getTimezoneOffset() * 60000)
        .toISOString()
        .substr(0, 10);
      state.tempPlan.dates[0] = today;
      state.tempPlan.dates[1] = today;
      state.tempPlan.file = null;
      state.tempPlan.thumnail = null;
    },
    UPDATE_DATE(state, dates) {
      state.tempPlan.dates = dates;
    },
    UPDATE_TITLE(state, title) {
      state.tempPlan.title = title;
    },
    UPDATE_THUMNAIL(state, body) {
      state.tempPlan.file = body.file;
      state.tempPlan.thumnail = body.thumnail;
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
    initTempPlanAction: ({ commit }) => {
      commit("INIT_PLAN_INFO");
    },
    updateDateAction: ({ commit }, dates) => {
      commit("UPDATE_DATE", dates);
    },
    updateTitleAction: ({ commit }, title) => {
      commit("UPDATE_TITLE", title);
    },
    updateThumnailAction: ({ commit }, body) => {
      commit("UPDATE_THUMNAIL", body);
    },
  },
};

export default planStore;
