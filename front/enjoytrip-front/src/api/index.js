import axios from "axios";
import { setInterceptors } from "./common/interceptors";
function apiInstance() {
  const instance = axios.create({
    baseURL: process.env.VUE_APP_API_BASE_URL,
    headers: {
      "Content-Type": "application/json;charset=utf-8",
    },
  });

  return setInterceptors(instance);
}

export { apiInstance };
