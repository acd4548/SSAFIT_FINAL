import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";
import UserView from "../views/UserView.vue";
import VideoView from "../views/VideoView.vue";
import LoginForm from "@/components/user/LoginForm.vue";
import SignupForm from "@/components/user/SignupForm.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/video",
    name: "video",
    component: VideoView,
    // children: [
    //   {
    //     path: "result",
    //     name: "result",
    //     component: () => import("@/components/video/SearchVideoResult.vue"),
    //   },
    //   {
    //     path: "detail",
    //     name: "detail",
    //     component: () => import("@/components/video/DetailVideo.vue"),
    //   },
    //   {
    //     path: "comment",
    //     name: "comment",
    //     component: () => import("@/components/video/DetailVideoComment.vue"),
    //   },
    //   {
    //     path: "search",
    //     name: "search",
    //     component: () => import("@/components/video/SearchVideo.vue"),
    //   },
    // ],
  },
  {
    path: "/user",
    name: "user",
    component: UserView,
    children: [
      {
        path: "",
        name: "login",
        component: LoginForm,
      },
      {
        path: "signup",
        name: "signup",
        component: SignupForm,
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
