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
      },
    ],
  },
  {
    path: "/login",
    name: "login",
    component: () => import("@/views/login-view"),
  },
  {
    path: "/plan",
    name: "plan",
    component: () => import("@/views/plan-view"),
    redirect: "/plan/list",
    children: [
      {
        path: "list",
        name: "planlist",
        component: () => import("@/components/plan/plan-list"),
      },
      {
        path: "write",
        name: "planwrite",
        component: () => import("@/components/plan/plan-write"),
      },
      {
        path: "view/:planId",
        name: "planview",
        component: () => import("@/components/plan/plan-detail"),
      },
      {
        path: "edit/:planId",
        name: "planedit",
        component: () => import("@/components/plan/plan-edit"),
      },
    ],
  },
  {
    path: "/user/info",
    name: "userinfo",
    redirect: "/user/info/detail",
    component: () => import("@/views/user-view"),
    children: [
      {
        path: "detail",
        name: "userdetail",
        component: () => import("@/components/user/user-info-detail"),
      },
      {
        path: "content",
        name: "usercontent",
        component: () => import("@/components/user/user-info-content"),
      },
      {
        path: "followers",
        name: "userfollowers",
        component: () => import("@/components/user/user-info-followers"),
      },
      {
        path: "following",
        name: "userfollowing",
        component: () => import("@/components/user/user-info-following"),
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
