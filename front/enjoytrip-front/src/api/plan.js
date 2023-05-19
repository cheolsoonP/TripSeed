import { apiInstance } from "./index.js";
const api = apiInstance();

function getPlanListApi(userId, success, fail) {
  api.get(`/plans/list/${userId}`).then(success).catch(fail);
}

function getPlanDetailApi(planId, success, fail) {
  api.get(`/plans/view/${planId}`).then(success).catch(fail);
}

function getRouteApi(planId, success, fail) {
  api.get(`/plans/${planId}/routes`).then(success).catch(fail);
}

export { getPlanListApi, getPlanDetailApi, getRouteApi };
