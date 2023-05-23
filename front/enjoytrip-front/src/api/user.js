import { apiInstance } from "./index.js";
const api = apiInstance();

function joinUserApi(body, success, fail) {
  api.post(`/users/join`, body).then(success).catch(fail);
}

async function loginUserApi(body, success, fail) {
  console.log(body);
  await api.post(`/users/login`, body).then(success).catch(fail);
}

function updateUserApi(body, success, fail) {
  api.put(`/users/modify`, body).then(success).catch(fail);
}

function searchUserApi(param, success, fail) {
  api.get(`/users/search`, { params: param }).then(success).catch(fail);
}

export { joinUserApi, loginUserApi, updateUserApi, searchUserApi };
