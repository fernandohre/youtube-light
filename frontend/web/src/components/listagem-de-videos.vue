<template>
  <v-row>
    <v-col
      v-for="video in videosRenderizados"
      :key="`${video.description}`"
      cols="6"
      md="4"
    >
      <v-card class="mx-auto" max-width="344">
        <v-img
          src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
          height="200px"
        ></v-img>

        <v-card-title> {{ video.description }}</v-card-title>
        
        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn icon>
            <v-icon>mdi-download</v-icon>
          </v-btn>
        </v-card-actions>
      </v-card>
    </v-col>
  </v-row>
</template>

<script>
import axios from "axios";
export default {
  created() {
    let _this = this;
    axios
      .get("http://localhost:1010/api/videos/findAllVideos")
      .then((response) => {
        console.log(response);
        _this.videos = response.data;
      })
      .catch((e) => console.log("Algo de errado não está certo!", e));
  },
  data() {
    return {
      videos: [],
    };
  },
  computed: {
    videosRenderizados() {
      return this.videos;
    },
  },
};
</script>