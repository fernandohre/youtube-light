<template>
  <v-row>
    <template v-for="n in quantidadeDeFileirasHorizontais">
      <!-- <v-col :key="n" class="mt-2" cols="12">
        <strong>Categoria {{ n }}</strong>
      </v-col> -->

      <v-col v-for="j in n" :key="`${n}${j}`" cols="6" md="2">
        <v-sheet height="150"></v-sheet>
      </v-col>
    </template>
  </v-row>
</template>

<script>
import axios from "axios";
export default {
  created() {
    let _this = this;
    axios.get("http://localhost:1010/api/videos/findAllVideos")
         .then(response => {
           console.log(response);
           _this.videos = response.data;
         })
         .catch(e => console.log("Algo de errado não está certo!", e));
  },
  data() {
    return {
      videos: []
    }
  },
  computed: {
    quantidadeDeFileirasHorizontais() {
      let tamanho = this.videos.length | 4;
      return tamanho / 4;
    }
  }
};
</script>