const routes = [
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    meta: {
      requiresAuth: true,
    },
    children: [
      {
        path: "/",
        component: () => import("pages/Adoptions.vue"),
        name: "Adoptions",
      },
      {
        path: "/caring",
        component: () => import("pages/Caring.vue"),
        name: "Caring",
      },
      {
        path: "/add",
        component: () => import("pages/Add.vue"),
        name: "Add",
      },
      {
        path: "/profile",
        component: () => import("pages/Profile.vue"),
        name: "Profile",
      },
    ],
  },
  {
    path: "/ad",
    component: () => import("layouts/AdLayout.vue"),
    children: [
      {
        path: "/",
        component: () => import("pages/AdPage.vue"),
        name: "Ad",
      },
    ],
  },
  {
    path: "/login",
    component: () => import("layouts/AuthLayout.vue"),
    children: [
      {
        path: "/",
        component: () => import("pages/Login.vue"),
        name: "Login",
      },
    ],
  },
  {
    path: "/register",
    component: () => import("layouts/AuthLayout.vue"),
    children: [
      {
        path: "/",
        component: () => import("pages/Register.vue"),
        name: "Register",
      },
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "*",
    component: () => import("pages/Error404.vue"),
  },
];

export default routes;
