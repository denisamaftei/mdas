<template>
  <div class="q-pa-md">
    <div class="q-gutter-md">
      <q-input
        v-model="search"
        color="accent"
        debounce="500"
        filled
        placeholder="Ce anume cauți?"
      >
        <template v-slot:append>
          <q-icon class="search" name="search" color="secondary" />
        </template>
        <q-icon
          class="fas fa-exchange-alt sort-icon"
          name="fas fa-exchange-alt"
          color="secondary"
        />
      </q-input>
    </div>
  </div>
</template>

<script>
export default {
  name: "SearchBar",
  data() {
    return {
      search: "",
    };
  },
};
</script>
<style>
.q-field {
  background-color: #533549ec;
  border-radius: 10px;
}
.q-field__native,
.q-field__prefix,
.q-field__suffix,
.q-field__input {
  color: #fff;
}
.q-field--filled .q-field__control {
  border-radius: 10px;
  flex-direction: row-reverse;
}
.text-accent {
  border-radius: 10px;
}
.q-field--filled .q-field__control::after {
  margin-left: 2vw;
  margin-right: 2vw;
}

.search {
  padding-right: 15px;
  opacity: 0.8;
}
.q-field__append {
  padding-left: 0;
}
.sort-icon {
  margin-top: 2.5vh;
  margin-right: 1vw;
  opacity: 0.8;
  width: 5vw;
  height: 2.5vh;
  -webkit-transform: rotate(90deg);
  -moz-transform: rotate(90deg);
  -o-transform: rotate(90deg);
  -ms-transform: rotate(90deg);
  transform: rotate(90deg);
}
.q-input ::placeholder {
  font-weight: 500;
  font-family: cardo, Arial, Helvetica, sans-serif;
}
</style>
