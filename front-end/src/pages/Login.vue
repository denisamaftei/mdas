<template>
  <q-page-container>
    <div class="q-pa-md row justify-center">
      <div class="login-info">
        <q-input
          lazy-rules
          :rules="[
            (val) =>
              (val && val.length > 0) || 'Trebuie să introduci un email valid',
          ]"
          filled
          class="email"
          v-model="email"
          label="Email"
        />
        <q-input
          v-model="password"
          filled
          :type="isPwd ? 'password' : 'text'"
          label="Parolă"
        >
          <template v-slot:append>
            <q-icon
              :name="isPwd ? 'visibility_off' : 'visibility'"
              class="cursor-pointer"
              @click="isPwd = !isPwd"
            />
          </template>
        </q-input>
        <q-btn
          :loading="loading1"
          color="primary"
          @click="simulateProgress(1)"
          label="Intră în cont"
          class="login-btn"
          to="/"
        />
      </div>
      <div class="alternatives">
        <div class="recover-pass cursor-pointer">Ți-ai uitat parola?</div>
        <q-btn class="register cursor-pointer" to="/register">
          Creează-ți cont
        </q-btn>
      </div>
    </div>
  </q-page-container>
</template>
<script>
export default {
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
    simulateProgress(number) {
      // we set loading state
      this[`loading${number}`] = true;
      // simulate a delay
      setTimeout(() => {
        // we're done, we reset loading state
        this[`loading${number}`] = false;
      }, 3000);
    },
  },
  data() {
    return {
      email: "",
      password: "",
      isPwd: true,
      loading1: false,
    };
  },
};
</script>
<style lang="scss">
.login-info {
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
  margin-top: 40vh;
}

.login-btn {
  margin-top: 3vh;
}
.email {
  width: -webkit-fill-available;
}
.alternatives {
  display: flex;
  gap: 10vw;
  flex-wrap: nowrap;
  margin-top: 10vh;
  font-family: cardo;
  font-weight: 800;
}
.register {
  padding: 0;
  min-height: 0;
  border-radius: unset;
  width: 50vw;
  height: 0%;
  font-weight: 800;
  font-size: 14px;
  text-transform: unset;
}
.register .q-btn__wrapper {
  padding: 0;
  margin: 0;
}
.recover-pass {
  width: 30vw;
  margin-left: 10vw;
  margin-top: 1vw;
}
</style>
