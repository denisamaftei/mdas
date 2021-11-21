<template>
  <q-page>
    <SearchBar></SearchBar>
    <div class="row justify-center q-gutter-sm">
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://idsb.tmgrup.com.tr/ly/uploads/images/2020/08/19/52894.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Plimbare Câine <i class="heart favorite fas fa-heart" />
            </div>
            <div class="text-subtitle3">15 RON/oră</div>
            <div class="text-subtitle3">Cluj-Napoca</div>
            <div class="text-subtitle3">Acum 2 ore</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://www.catster.com/wp-content/uploads/2016/06/GettyImages-1137327185.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Spălare Animal<i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">25-50 RON/spălare</div>
            <div class="text-subtitle3">București</div>
            <div class="text-subtitle3">Ieri</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://www.fetchpetcare.com/wp-content/uploads/2014/07/bigstock-152145332.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Îngrijire Animal<i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">65 RON/zi</div>
            <div class="text-subtitle3">Constanța</div>
            <div class="text-subtitle3">13 noiembrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://www.telegraph.co.uk/content/dam/Travel/hotels/europe/united-kingdom/Hotels%20-%20England/london/rosewood-london-pet-friendly-pearl-dog-xlarge.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Cazare Animal <i class="heart favorite fas fa-heart" />
            </div>
            <div class="text-subtitle3">90 RON/noapte</div>
            <div class="text-subtitle3">Brașov</div>
            <div class="text-subtitle3">3 noiembrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="http://cdn.cnn.com/cnnnext/dam/assets/190222152554-14-pet-friendly-hotels-kimpton-hotel.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Cazare Animal<i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">80 RON/noapte</div>
            <div class="text-subtitle3">Iași</div>
            <div class="text-subtitle3">1 noiembrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
      <q-intersection transition="scale" class="example-item">
        <q-card>
          <img
            src="https://dfcby4322olzt.cloudfront.net/wp-content/uploads/2019/12/dog-walker-2-wide.jpg"
          />

          <q-card-section>
            <div class="text-h6">
              Plimbare Câini<i class="heart no-favorite far fa-heart" />
            </div>
            <div class="text-subtitle3">25 RON/oră</div>
            <div class="text-subtitle3">București</div>
            <div class="text-subtitle3">26 octombrie</div>
          </q-card-section>
        </q-card>
      </q-intersection>
    </div>
  </q-page>
</template>
<script>
import AdContainer from "components/AdContainer.vue";
import SearchBar from "../components/SearchBar.vue";
export default {
  name: "Caring",
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
    };
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
  margin-left: 20px;
}
</style>
