import { apiInstance } from "./index.js";

const api = apiInstance();

function joinUserApi(body, success, fail) {
  api.post(`/users/join`, body).then(success).catch(fail);
}

function loginUserApi(body, success, fail) {
  api.post(`/users/login`, body).then(success).catch(fail);
}

export { joinUserApi, loginUserApi };
