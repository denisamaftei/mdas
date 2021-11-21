<template>
  <q-page-container>
    <div class="q-pa-md row justify-center">
      <div class="login-info">
        <q-input
          class="name"
          filled
          v-model="text"
          label="Nume"
          :dense="dense"
        />
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
          class="phone"
          v-model="tel"
          filled
          type="tel"
          label="Număr de telefon"
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
          label="Creare cont"
          class="login-btn"
          to="/login"
        />
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
      tel: ref(""),
      text: ref(""),
      dense: ref(false),
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
.email,
.phone,
.name {
  width: -webkit-fill-available;
}
.phone,
.name {
  margin-bottom: 2vh;
}
.q-field__bottom {
  padding: 0;
}
</style>
