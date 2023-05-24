import { awsFileUpload } from "./fileUpload.js";
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

async function postPlanApi(body, success, fail) {
  if (body.file !== null) {
    // 업로드할 이미지가 있을 때
    await awsFileUpload(body.file).then((data) => {
      if (data !== null) {
        body.image = data;
        delete body.file;
        api.post(`/plans/plan`, body).then(success).catch(fail);
      } else {
        console.log("파일 업로드 실패");
      }
    });
  } else {
    // 업로드할 이미지가 없다면
    delete body.file;
    api.post(`/plans/plan`, body).then(success).catch(fail);
  }
}

function postPlanPartner(body, success, fail) {
  api.post(`/plans/${body.planId}/partners`, body).then(success).catch(fail);
}

export { getPlanListApi, getPlanDetailApi, getRouteApi, postPlanApi, postPlanPartner };
