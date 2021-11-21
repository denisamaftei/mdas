import Axios from "axios";

export async function getAdvert({ commit }) {
  const response = await Axios.get("http://localhost:8080/advert/all");
  commit("SET_ADVERT", response.data);
}
