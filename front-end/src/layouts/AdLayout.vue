<template>
  <q-layout view="lHh Lpr lFf">
    <q-page-container>
      <router-view />
    </q-page-container>
    <div class="btn-container">
      <q-btn round color="primary" icon="arrow_back" to="/" />
    </div>
  </q-layout>
</template>
<script>
export default {
  name: "AdLayout",
};
</script>
<style>
.image {
  top: 20%;
}
.text {
  top: 30%;
  font-size: 25px;
  font-family: cardo;
  font-weight: 900;
}
.btn-container {
  margin-left: 16px;
  margin-bottom: 10px;
}
/* .q-btn {
  margin-right: 5px;
} */
</style>
