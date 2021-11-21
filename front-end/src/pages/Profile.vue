<template>
  <q-page-container>
    <div
      class="
        q-pa-md q-gutter-sm
        row
        justify-center
        items-center
        content-center
        profile-page
      "
    >
      <q-banner rounded>
        <template v-slot:avatar>
          <img class="profile-banner" src="../assets/PetsProfile.jpg" />
        </template>
      </q-banner>
      <div class="user-info">
        <q-avatar class="user-avatar" color="primary" text-color="white"
          >J</q-avatar
        >
        <div class="user-info-details user-name">Johnny Doe</div>
        <div class="user-info-details user-mail">johnny@doe.com</div>
        <div class="user-info-details user-phone">+407362536643</div>
      </div>
    </div>
    <div class="user-panel">
      <div class="icon-text">
        <q-icon class="fas fa-cog icons" name="fas fa-cog" color="primary" />
        <div class="panel-text">Setări</div>
      </div>
      <q-separator inset="item" />
      <div class="icon-text">
        <q-icon
          class="fas fa-question icons"
          name="fas fa-question"
          color="primary"
        />
        <div class="panel-text">Ajutor</div>
      </div>
      <q-separator inset="item" />
      <div class="icon-text">
        <q-icon class="fas fa-lock icons" name="fas fa-lock" color="primary" />
        <div class="panel-text">Termeni și condiții</div>
      </div>
      <q-separator inset="item" />
      <div class="icon-text">
        <q-icon
          class="fas fa-user-secret icons"
          name="fas fa-user-secret"
          color="primary"
        />
        <div class="panel-text">Politica de confidențialitate</div>
      </div>
      <q-separator inset="item" />
      <div class="icon-text">
        <q-icon class="fas fa-info icons" name="fas fa-info" color="primary" />
        <div class="panel-text">Despre aplicație</div>
      </div>
      <q-separator inset="item" />
      <div class="icon-text log-out" @click="handleClick">
        <q-icon
          class="fas fa-sign-out-alt icons"
          name="fas fa-sign-out-alt"
          color="primary"
        />
        <div class="panel-text">Ieși din cont</div>
      </div>
    </div>
  </q-page-container>
</template>
<script>
// import AdContainer from 'components/AdContainer.vue'
import SearchBar from "components/SearchBar.vue";
export default {
  components: {
    // AdContainer,
    // SearchBar
  },
  methods: {
    handleClick() {
      this.$router.push({ name: "Login" });
    },
  },
  data() {
    return {
      tab: "mails",
    };
  },
};
</script>

<style lang="scss" scoped>
.profile-banner {
  opacity: 0.15;
  width: 100%;
  object-fit: cover;
  height: 30vh;
  border-bottom-left-radius: 10%;
  border-bottom-right-radius: 10%;
}
.user-avatar {
  /* height: 2em;
  width: 2em; */
}
.icons,
.panel-text {
  display: inline;
}
.user-panel {
  display: flex;
  flex-direction: column;
  margin-left: 15vw;
}
.icons {
  padding-top: 0.5vh;
  margin-right: 1vw;
  font-size: 5vw;
}
.panel-text {
  font-size: 5vw;
}
.icon-text {
  display: flex;
  flex-direction: row;
  margin-top: 1.2vh;
  margin-bottom: 1.2vh;
}
.q-separator--horizontal-item-inset {
  margin-left: 0;
}
.user-info {
  display: flex;
  flex-direction: column;
  align-items: center;
  position: absolute;
  top: 10;
}
.user-info-details {
  margin-top: 1vh;
  font-size: 5vw;
}
.user-name {
  font-weight: 900;
  font-family: cardo, Arial, Helvetica, sans-serif;
}
.profile-page {
  padding-left: 0;
  padding-right: 0;
  padding-top: 0;
}
.q-banner {
  background: #f6b042;
  margin: 0;
  padding: 0;
  opacity: 0.9;
  height: 30vh;
  border-bottom-left-radius: 10%;
  border-bottom-right-radius: 10%;
}
</style>
