<template>
  <q-page>
    <SearchBar></SearchBar>
    <div class="row justify-center q-gutter-sm">
      <q-intersection
        transition="scale"
        @click.native="handleClick"
        class="example-item"
      >
        <q-card onClick="handleClick">
          <img
            src="https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/dog-puppy-on-garden-royalty-free-image-1586966191.jpg?crop=1.00xw:0.669xh;0,0.190xh&resize=1200:*"
          />

          <q-card-section>
            <div class="text-h6">
              Adopție Câine <i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">2 luni</div>
            <div class="text-subtitle3">București</div>
            <div class="text-subtitle3">Acum o oră</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://i.cbc.ca/1.5256404.1566499707!/fileImage/httpImage/image.jpg_gen/derivatives/16x9_940/cat-behaviour.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Adopție Pisică <i class="heart favorite fas fa-heart" />
            </div>
            <div class="text-subtitle3">3 săptămâni</div>
            <div class="text-subtitle3">Ilfov</div>
            <div class="text-subtitle3">Acum 4 zile</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://www.hospitalveterinariglories.com/wp-content/uploads/2020/02/20-02-05-loro-animal-de-compan%CC%83ia.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Adopție Papagal <i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">1 an</div>
            <div class="text-subtitle3">Constanța</div>
            <div class="text-subtitle3">Acum o săptămână</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://www.scottishspca.org/sites/default/files/styles/full_content/public/2019-09/Rabbit%20860x500.jpeg?itok=OvX2YuHA"
          />

          <q-card-section>
            <div class="text-h6">
              Adopție Iepure <i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">2 săptămâni</div>
            <div class="text-subtitle3">Iași</div>
            <div class="text-subtitle3">7 noiembrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img src="https://i.ytimg.com/vi/eUWFd28mfxk/maxresdefault.jpg" />

          <q-card-section>
            <div class="text-h6">
              Adopție Pești <i class="heart favorite fas fa-heart" />
            </div>
            <div class="text-subtitle3">3 luni</div>
            <div class="text-subtitle3">Sibiu</div>
            <div class="text-subtitle3">2 noiembrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://images.squarespace-cdn.com/content/v1/5486159de4b074841b303621/1625098587656-RAWMEEYLSLFFNK7J2F5O/WEBimage1.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Adopție Țestoasă <i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">O lună</div>
            <div class="text-subtitle3">Giurgiu</div>
            <div class="text-subtitle3">30 octombrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
    </div>

    <!-- <AdContainer @click.native="handleClick"></AdContainer> -->
  </q-page>
</template>
<script>
import AdContainer from "components/AdContainer.vue";
import SearchBar from "../components/SearchBar.vue";
export default {
  name: "Adoptions",
  components: {
    // AdContainer,
    SearchBar,
  },
  methods: {
    handleClick() {
      this.$router.push({ name: "Ad" });
    },
  },
  data() {
    return {
      tab: "mails",
      adverts: [],
    };
  },
  beforeMount() {
    this.$store.dispatch("advertsData/getAdvert");
  },
  computed: {
    id() {
      return this.$store.getters["advertsData/getId"];
    },
    title() {
      return this.$store.getters["advertsData/getTitle"];
    },
    type() {
      return this.$store.getters["advertsData/getType"];
    },
    description() {
      return this.$store.getters["advertsData/getDescription"];
    },
    location() {
      return this.$store.getters["advertsData/getLocation"];
    },
    postTime() {
      return this.$store.getters["advertsData/getPostTime"];
    },
    price() {
      return this.$store.getters["advertsData/getPrice"];
    },
    animal() {
      return this.$store.getters["advertsData/getAnimal"];
    },
  },
};
</script>
<style>
.example-item {
  width: 170px;
  margin-bottom: 70px;
}
.q-card__section--vert {
  background-color: #533549;
  color: #fff;
  /* height: 30px; */
}
.q-card > img {
  height: 100px;
}
.text-h6 {
  font-weight: 900;
  font-family: cardo, Arial, Helvetica, sans-serif;
  font-size: 12px;
}

.heart {
  color: #f6b042;
  margin-left: 30px;
}
</style>
