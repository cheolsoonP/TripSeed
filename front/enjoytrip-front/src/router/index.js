import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

// import store from "@/store";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/board",
    name: "board",
    component: () => import("@/views/BoardView"),
    redirect: "/board/list",
    children: [
      {
        path: "list",
        name: "boardlist",
        component: () => import("@/components/board/board-list"),
      },
      {
        path: "view/:postId",
        name: "boardview",
        // beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/board-detail"),
      },
      {
        path: "write",
        name: "boardwrite",
        // beforeEnter: onlyAuthUser,
        component: () => import("@/components/board/board-write"),
      }
    ],
  },
  {
    path: "/user",
    name: "user",
    component: () => import("@/views/login-view"),
    redirect: "/user/login",
    children: [
      {
        path: "login",
        name: "userlogin",
        component: () => import("@/components/user/user-login"),
      },
    ],
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
