<template>
  <q-page-container>
    <div class="q-pa-md">
      <div class="q-gutter-md">
        <div class="text-center publish-ad-header">Publică propriul anunț</div>
        <q-uploader
          url="http://localhost:4444/upload"
          label="Adaugă imagini"
          multiple
          accept=".jpg, image/*"
          @rejected="onRejected"
        />
        <q-input
          class="ad-info"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Trebuie să introduci un titlu',
          ]"
          v-model="title"
          label="Titlul anunțului"
        />
        <q-input
          class="ad-info"
          lazy-rules
          :rules="[
            (val) => (val && val.length > 0) || 'Trebuie să introduci locația',
          ]"
          v-model="location"
          label="Locația"
        />
        <q-select
          behavior="dialog"
          class="ad-info"
          v-model="optionType"
          :options="adTypes"
          label="Tipul anunțului"
        />
        <q-input
          class="ad-info"
          v-model="description"
          label="Descrierea anunțului"
        />
        <q-input
          v-if="optionType === 'Îngrijire'"
          class="ad-info"
          lazy-rules
          :rules="[(val) => val > 0 || 'Trebuie să introduci un preț în cifre']"
          v-model="price"
          label="Preț"
        />
        <q-input
          v-if="optionType === 'Adopție'"
          class="ad-info"
          lazy-rules
          :rules="[
            (val) =>
              (val !== null && val !== '') ||
              'Trebuie să introduci vârsta animalului',
            (val) =>
              (val > 0 && val < 100) || 'Trebuie să introduci o vârstă reală',
          ]"
          v-model="age"
          label="Vârsta animalului"
        />
      </div>
      <div class="btn-container">
        <q-btn round color="primary" icon="done" to="/" />
      </div>
    </div>
  </q-page-container>
</template>
<script>
export default {
  components: {
    // AdContainer,
  },
  methods: {
    onItemClick() {
      // console.log('Clicked on an Item')
    },
    onRejected(rejectedEntries) {
      // Notify plugin needs to be installed
      // https://quasar.dev/quasar-plugins/notify#Installation
      this.$q.notify({
        type: "negative",
        message: `${rejectedEntries.length} file(s) did not pass validation constraints`,
      });
    },
  },
  data() {
    return {
      title: "",
      type: "",
      description: "",
      price: "",
      age: "",
      selected: "",
      adTypes: ["Adopție", "Îngrijire"],
      optionType: null,
      location: "",
    };
  },
};
</script>
<style lang="scss" scoped>
.publish-ad-header {
  font-size: 10vw;
  margin-top: 5vh;
  margin-bottom: 5vh;
  font-weight: 800;
  font-family: cardo, Arial, Helvetica, sans-serif;
}
.ad-info {
  margin-top: 5vh;
}
.q-uploader {
  width: initial;
}
.btn-container {
  display: flex;
  justify-content: center;
  margin-top: 5vh;
}
.q-page-container {
  padding-bottom: 0% !important;
}
</style>
