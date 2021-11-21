<template>
  <q-layout view="lHh Lpr lFf">
    <q-page-container>
      <router-view />
    </q-page-container>
    <!-- <SearchBar></SearchBar>   -->
    <q-footer elevated>
      <q-tabs v-model="tab">
        <q-route-tab to="/" name="adoption" icon="fas fa-cat" />
        <q-route-tab to="/caring" name="caring" icon="fas fa-hands-helping" />
        <q-route-tab
          to="/add"
          class="add"
          name="add"
          icon="fas fa-plus-circle"
        />
        <!-- <q-route-tab to="/conversations" alert="white" name="conversations" icon="fas fa-comment" /> -->
        <q-route-tab to="/profile" name="profile" icon="fas fa-user" />
      </q-tabs>
    </q-footer>
  </q-layout>
</template>

<script>
export default {
  // components: {
  //   SearchBar
  // },
  name: "MainLayout",
  data() {
    return {
      tab: "mails",
    };
  },
};
</script>
<style>
.q-tab__alert {
  top: 10px;
  right: 4px;
}
.q-tab__icon {
  color: #f6b042;
}
.add .q-tab__icon {
  background-color: white;
  border-radius: 100%;
  font-size: 30px;
}

#q-app {
  overflow-x: hidden;
  font-family: JosefinSans, Arial, Helvetica, sans-serif;
}
</style>
