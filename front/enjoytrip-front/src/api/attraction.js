import { apiInstance } from "./index.js";
const api = apiInstance();

function getAttractionListApi(param, success, fail) {
  api.get(`/attractions`, { params: param }).then(success).catch(fail);
}

export { getAttractionListApi };