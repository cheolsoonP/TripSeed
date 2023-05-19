import { apiInstance } from "./index.js";

const api = apiInstance();

function postList(param, success, fail) {
  api.get(`/board/list`, { params: param }).then(success).catch(fail);
}

function getPost(postId, success, fail) {
  api.get(`/board/view/${postId}`).then(success).catch(fail);
}

function writePostApi(body, success, fail) {
  api.post(`/board/write`).then(success).catch(fail);
}

export { postList, getPost, writePostApi };
