export function SET_ADVERT(state, payload) {
  state.id = payload.id;
  state.title = payload.title;
  state.type = payload.type;
  state.description = payload.description;
  state.location = payload.location;
  state.postTime = payload.postTime;
  state.price = payload.price;
  state.animal = payload.animal;
}
