import { awsFileUpload } from "./fileUpload.js";
import { apiInstance } from "./index.js";
const api = apiInstance();

function joinUserApi(body, success, fail) {
  api.post(`/users/join`, body).then(success).catch(fail);
}

async function loginUserApi(body, success, fail) {
  await api.post(`/users/login`, body).then(success).catch(fail);
}

async function updateUserApi(body, success, fail) {
  // 업로드할 파일이 있다면
  // 파일 업로드 후에 해당 링크 Backend 전달
  if (body.file !== null) {
    await awsFileUpload(body.file).then((data) => {
      if (data !== null) {
        body = {
          ...body,
          profile: data,
        };
        delete body.file;
        api.put(`/users/modify`, body).then(success).catch(fail);
      } else {
        console.log("파일 업로드 실패");
      }
    });
  } else {
    // 업로드할 이미지가 없다면 게시글만 올린다.
    delete body.file;
    api.put(`/users/modify`, body).then(success).catch(fail);
  }
}

function searchUserApi(param, success, fail) {
  api.get(`/users/search`, { params: param }).then(success).catch(fail);
}

function addFollowUserApi(body, success, fail) {
  api.post(`/users/${body.userId}/following`, body.followingUserId).then(success).catch(fail);
}

function getFollowerListApi(userId, success, fail) {
  api.get(`/users/${userId}/followers`).then(success).catch(fail);
}

export {
  joinUserApi,
  loginUserApi,
  updateUserApi,
  searchUserApi,
  addFollowUserApi,
  getFollowerListApi,
};
