import { apiInstance } from "./index.js";

const api = apiInstance();

function listArticle(param, success, fail) {
    api.get(`/board`, { params: param }).then(success).catch(fail);
}

export { listArticle };
