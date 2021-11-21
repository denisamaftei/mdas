<template>
  <div class="q-pa-md">
    <div class="row justify-center q-gutter-sm">
      <q-intersection
        v-for="index in 20"
        :key="index"
        transition="scale"
        class="example-item"
      >
        <q-card class="q-ma-sm">
          <img src="https://cdn.quasar.dev/img/mountains.jpg" />

          <q-card-section>
            <div class="text-h6">Card #{{ index }}</div>
            <div class="text-subtitle2">by John Doe {{ index }}</div>
          </q-card-section>
        </q-card>
      </q-intersection>
    </div>
  </div>
</template>
<script>
export default {
  name: "AdContainer",
  data() {
    return {
      index: 0,
    };
  },
};
</script>

<style>
.example-item {
  height: 160px;
  width: 160px;
  margin-bottom: 30px;
}
.q-card__section--vert {
  background-color: #533549;
  color: #fff;
}
.text-h6 {
  font-weight: 900;
  font-family: cardo, Arial, Helvetica, sans-serif;
}
</style>
