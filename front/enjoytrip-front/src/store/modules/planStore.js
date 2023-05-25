import { getPlanDetailApi, getPlanListApi, getRouteApi } from "@/api/plan";

const planStore = {
  namespaced: true,
  state: {
    plans: [],
    planDetail: {},
    routes: [],
    tempPlan: {
      dates: [],
      title: "",
      thumnail: "",
      file: "",
      partners: [],
    },
    route: {
      planId: "",
      attractionId: "",
      visitOrder: "",
      memo: "",
      visitTime: "",
      visitDate: "",
    },
    activeTabDate: "",
    markers: [],
  },
  getters: {
    sortOrderRoutes: (state) => {
      // value 기준으로 정렬
      state.routes.sort(function (a, b) {
        if (a.visitOrder > b.visitOrder) {
          return 1;
        }
        if (a.visitOrder < b.visitOrder) {
          return -1;
        }
        // a must be equal to b
        return 0;
      });

      return state.routes;
    },
  },
  mutations: {
    SET_PLAN_LIST(state, plans) {
      state.plans = [];
      plans.forEach((plan) => {
        state.plans.push(plan);
      });
    },
    SET_PLAN_DETAIL(state, planDetail) {
      state.planDetail = {};
      state.planDetail = planDetail;
    },
    SET_PLAN_ROUTES(state, routes) {
      state.routes = [];
      routes.forEach((route) => {
        state.routes.push(route);
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
      state.tempPlan.partners = [];
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
    ADD_PARTNER(state, partnerInfo) {
      if (!state.tempPlan.partners.includes(partnerInfo)) {
        state.tempPlan.partners.push(partnerInfo);
      }
    },
    DELETE_PARTNER(state, partnerId) {
      function findPartner(partner) {
        if (partner.userId === partnerId) return true;
      }
      const index = state.tempPlan.partners.findIndex(findPartner);
      state.tempPlan.partners.splice(index, 1);
    },
    ADD_ATTRACTION_TO_ROUTE(state, route) {
      function findRoute(item) {
        if (item.attractionId === route.attractionId) return true;
      }
      if (!state.routes.find(findRoute)) {
        state.routes.push(route);
        // 새로운 route 객체를 추가할 때, 마커도 함께 생성하여 저장합니다.
        state.markers.push({ lat: route.latitude, lng: route.longitude });
      }
    },
    INIT_PLAN_EDIT_ROUTE(state, startDate) {
      state.activeTabDate = startDate;
      state.routes = [];
      state.markers = [];
    },
    SET_ACTIVE_TAB_DATE(state, date) {
      state.activeTabDate = date;
    },

    DELETE_ROUTE(state, route) {
      function findRoute(item) {
        if (item.attractionId === route.attractionId) return true;
      }
      const index = state.routes.findIndex(findRoute);
      state.routes.splice(index, 1);
      state.markers.splice(index, 1);
      state.routes.forEach((route, idx) => {
        if (idx >= index) route.visitOrder--;
      });
    },
    ORDER_UP(state, route) {
      function findRoute(item) {
        if (item.attractionId === route.attractionId) return true;
      }
      const index = state.routes.findIndex(findRoute);
      if (index !== 0) {
        state.routes[index - 1].visitOrder++;
        state.routes[index].visitOrder--;
        let temp = state.markers[index - 1];
        state.markers.splice(index - 1, 1);
        state.markers.splice(index, 0, temp);
      }
    },
    ORDER_DOWN(state, route) {
      function findRoute(item) {
        if (item.attractionId === route.attractionId) return true;
      }
      const index = state.routes.findIndex(findRoute);
      if (index !== state.routes.length - 1) {
        state.routes[index].visitOrder++;
        state.routes[index + 1].visitOrder--;
        let temp = state.markers[index + 1];
        state.markers.splice(index + 1, 1);
        state.markers.splice(index, 0, temp);
      }
    },

    UPDATE_MARKER(state, { index, marker }) {
      state.markers.splice(index, 1, marker);
    },
    REMOVE_MARKER(state, index) {
      state.markers.splice(index, 1);
    },
    SET_MARKER(state, markers) {
      state.markers = [];
      markers.forEach((marker) => state.markers.push(marker));
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
      console.log("경로 불러오기");
      getRouteApi(
        planId,
        ({ data }) => {
          console.log(data);
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
    addPatnerAction: ({ commit }, partnerInfo) => {
      commit("ADD_PARTNER", partnerInfo);
    },
    deletePartnerAction: ({ commit }, partnerId) => {
      commit("DELETE_PARTNER", partnerId);
    },
    addAttractionToRouteAction: ({ commit }, route) => {
      commit("ADD_ATTRACTION_TO_ROUTE", route);
    },
    initPlanEditRouteAction: ({ commit }, startDate) => {
      commit("INIT_PLAN_EDIT_ROUTE", startDate);
    },
    setActiveTabDateAction: ({ commit }, date) => {
      commit("SET_ACTIVE_TAB_DATE", date);
    },
    deleteRouteAction: ({ commit }, route) => {
      commit("DELETE_ROUTE", route);
    },
    orderUpAction: ({ commit }, route) => {
      commit("ORDER_UP", route);
    },
    orderDownAction: ({ commit }, route) => {
      commit("ORDER_DOWN", route);
    },
    updateMarker({ commit, state }, { index, marker }) {
      const updatedMarker = { ...state.markers[index], ...marker };
      commit("UPDATE_MARKER", { index, marker: updatedMarker });
    },
    removeMarker({ commit }, index) {
      commit("REMOVE_MARKER", index);
    },
    setMarker({ commit }, markers) {
      commit("SET_MARKER", markers);
    },
  },
};

export default planStore;
