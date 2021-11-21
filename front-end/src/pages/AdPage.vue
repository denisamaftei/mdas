<template>
  <q-page-container>
    <div class="q-pa-md">
      <div class="q-gutter-md">
        <q-banner rounded>
          <template v-slot:avatar>
            <img
              class="ad-banner"
              src="https://idsb.tmgrup.com.tr/ly/uploads/images/2020/08/19/52894.jpg"
            />
          </template>
        </q-banner>

        <div class="description-container text-justify">
          <div class="description-postedTime text-subtitle1 text-italic">
            Acum 2 ore
          </div>
          <div class="description-title publish-ad-header text-h4">
            Plimbare câine
          </div>
          <div class="description-priceOrAge text-subtitle1">15 RON/oră</div>
          <div class="description-text">
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin arcu
            turpis, scelerisque malesuada mollis sed, gravida at nulla. Duis
            viverra ex imperdiet risus vestibulum, vitae egestas risus semper.
            Donec interdum elit in fringilla dignissim. Aliquam malesuada purus
            ut mauris accumsan suscipit. Nulla in pretium elit. Aliquam sed
            pellentesque elit. Curabitur malesuada velit sit amet diam
            ultricies, id dapibus augue eleifend. Proin efficitur in ante
            facilisis varius. Sed id turpis hendrerit orci auctor tincidunt sed
            ut magna. Vivamus eu iaculis quam. Aenean eget mi purus. Integer
            convallis justo a sapien vulputate euismod fringilla viverra urna.
            Suspendisse nec tellus tellus. Integer fermentum egestas placerat.
            Nam et gravida tellus.
          </div>
          <div class="location-container">
            <div class="title">Locație</div>
            <div class="location">București</div>
          </div>
          <div class="user-info">
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
}
.ad-info {
  margin-top: 5vh;
}
.q-uploader {
  width: initial;
}
.ad-banner {
  width: -webkit-fill-available;
  border-radius: 10%;
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
  border-radius: 5%;
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
  flex-direction: row-reverse;

  padding: 5%;
}
.user-name {
  height: fit-content;
  margin-right: 2%;
}
.location-container {
  margin-top: 10%;
}
.title {
  font-weight: 700;
  font-size: 18px;
}
</style>
