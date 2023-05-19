import { apiInstance } from "./index.js";
const api = apiInstance();

function joinUserApi(body, success, fail) {
  api.post(`/users/join`, body).then(success).catch(fail);
}

async function loginUserApi(body, success, fail) {
  console.log(body);
  await api.post(`/users/login`, body).then(success).catch(fail);
}

export { joinUserApi, loginUserApi };
