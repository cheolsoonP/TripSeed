import { apiInstance } from "./index.js";

const api = apiInstance();

function sidoList(success, fail) {
  api.get(`/attractions/sido`).then(success).catch(fail);
}

function gugunList(sidoCode, success, fail) {
  api.get(`/attractions/sido/${sidoCode}/gugun`).then(success).catch(fail);
}

export { sidoList, gugunList };
