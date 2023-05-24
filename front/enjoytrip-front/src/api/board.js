import { apiInstance } from "./index.js";
import { awsFileUpload } from "@/api/fileUpload.js";
const api = apiInstance();

function postListApi(param, success, fail) {
  api.get(`/board/list`, { params: param }).then(success).catch(fail);
}
function userPostListApi(param, success, fail) {
  api.get(`/board/list/${param}`).then(success).catch(fail);
}
function getPost(postId, success, fail) {
  api.get(`/board/view/${postId}`).then(success).catch(fail);
}

async function writePostApi(body, success, fail) {
  // 업로드할 파일이 있다면
  // 파일 업로드 후에 해당 링크 Backend 전달
  if (body.file !== null) {
    await awsFileUpload(body.file).then((data) => {
      if (data !== null) {
        body = {
          ...body,
          image: data,
        };
        delete body.file;
        api.post(`/board/write`, body).then(success).catch(fail);
      } else {
        console.log("파일 업로드 실패");
      }
    });
  } else {
    // 업로드할 이미지가 없다면 게시글만 올린다.
    delete body.file;
    api.post(`/board/write`, body).then(success).catch(fail);
  }
}

function addView(postId, success, fail) {
  api.put(`/board/view/${postId}`).then(success).catch(fail);
}

function postReply(body, success, fail) {
  api.post(`/board/${body.postId}/reply`, body.reply).then(success).catch(fail);
}

function getReplyList(postId, success, fail) {
  api.get(`/board/${postId}/reply`).then(success).catch(fail);
}

function updateReply(body, success, fail) {
  api.put(`/board/${body.postId}/reply/${body.replyId}`, body.reply).then(success).catch(fail);
}
function deleteReply(body, success, fail) {
  api.delete(`/board/${body.postId}/reply/${body.replyId}`).then(success).catch(fail);
}
export {
  postListApi,
  userPostListApi,
  getPost,
  writePostApi,
  addView,
  postReply,
  getReplyList,
  updateReply,
  deleteReply,
};
