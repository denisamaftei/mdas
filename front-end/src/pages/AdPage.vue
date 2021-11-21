<template>
  <q-page-container>
    <div class="q-pa-md">
      <div class="q-gutter-md">
        <q-banner rounded>
          <template v-slot:avatar>
            <img
              class="ad-banner"
              src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*"
            />
          </template>
        </q-banner>

        <div class="description-container text-justify">
          <div class="description-postedTime text-subtitle1 text-italic">
            Acum o oră
          </div>
          <div class="description-title publish-ad-header text-h4 text-center">
            Adopție Câine
          </div>
          <div class="description-priceOrAge text-subtitle1">
            Vârstă: 2 luni
          </div>
          <div class="description-text">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin arcu
            turpis, scelerisque malesuada mollis sed, gravida at nulla. Duis
            viverra ex imperdiet risus vestibulum, vitae egestas risus semper.
            Donec interdum elit in fringilla dignissim. Aliquam malesuada purus
            ut mauris accumsan suscipit. Nulla in pretium elit. Aliquam sed
            pellentesque elit. Curabitur malesuada velit sit amet diam
            ultricies, id dapibus augue eleifend.
          </div>
          <div class="location-container">
            <div class="title">Locație</div>
            <div class="location">București</div>
          </div>
          <div class="user-info">
            <q-btn color="accent" class="adopt-btn">Adoptă!</q-btn>

            <q-avatar class="user-avatar" color="accent" text-color="white"
              >J</q-avatar
            >
            <div class="user-info-details user-name">Johnny Doe</div>
          </div>
        </div>
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
    };
  },
};
</script>
<style lang="scss" scoped>
.q-page-container {
  font-family: cardo;
}
.publish-ad-header {
  // font-size: 10vw;
  margin-top: 2vh;
  margin-bottom: 2vh;
  font-weight: 900;
  font-family: cardo, Arial, Helvetica, sans-serif;
  background-color: #f6b042;
  border-radius: 20px;
  height: 50px;
  padding-top: 5px;
}
.ad-info {
  margin-top: 5vh;
}
.q-uploader {
  width: initial;
}
.ad-banner {
  width: -webkit-fill-available;
  border-radius: 20px;
}
.q-banner {
  display: flex;
  justify-content: center;
  width: 100%;
  padding-left: 0px;
}
.q-gutter-y-md,
.q-gutter-md {
  margin-left: 0px;
}
.q-pa-md {
  padding-left: 0px;
}
.description-container {
  background-color: #533549;
  color: #fff;
  border-radius: 20px;
  padding: 5%;
}
.description-priceOrAge {
  font-weight: 600;
  margin-bottom: 2%;
}
.text-h4 {
  margin-bottom: 3%;
  margin-top: 3%;
}
.user-info {
  display: flex;
  align-items: center;
  flex-direction: row;

  padding: 5%;
  padding-left: 0%;
  padding-right: 0%;
}
.user-name {
  height: fit-content;
  margin-right: 2%;
  order: 2;
}
.location-container {
  margin-top: 10%;
}
.title {
  font-weight: 700;
  font-size: 18px;
}
.adopt-btn {
  order: 1;
  margin-right: 80px;
  font-weight: 800;
  border-radius: 20px;
}
.user-avatar {
  order: 3;
}
</style>
