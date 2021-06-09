<template>
  <div class="video-upload">
    <v-text-field
      counter="50"
      label="Descrição"
      v-model="description"
    ></v-text-field>
    <v-file-input
      name="video-file"
      counter
      show-size
      v-model="fileVideo"
    ></v-file-input>
    <v-btn depressed color="primary" @click.stop="uploadVideo"> Enviar </v-btn>
  </div>
</template>

<script>
import axios from "axios";
export default {
  data() {
    return {
      description: null,
      fileVideo: null,
    };
  },
  methods: {
    uploadVideo() {
      let formData = new FormData();
      if (this.fileVideo) {
        formData.append("file", this.fileVideo);
        formData.append("description", this.description)
      }
      axios.post("http://localhost:1010/api/videos/upload", formData)
        .then((response) => {
          console.log("Success!");
          console.log({ response });
        })
        .catch((error) => {
          console.log({ error });
        });
      console.log("upload do video...");
      console.log(formData);
    },
  },
};
</script>