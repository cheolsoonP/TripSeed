import { apiInstance } from "./index.js";

const api = apiInstance();

function postList(param, success, fail) {
  api.get(`/board/list`, { params: param }).then(success).catch(fail);
}

export { postList };
