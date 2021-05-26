<template>
    <v-list>
        <v-list-item-group>
          <v-list-item to="/">
            <v-list-item-icon>
              <v-icon>mdi-download</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Download Videos</v-list-item-title>
          </v-list-item>

          <v-list-item to="/upload-de-videos">
            <v-list-item-icon>
              <v-icon>mdi-cloud-upload</v-icon>
            </v-list-item-icon>
            <v-list-item-title>Upload Videos</v-list-item-title>
          </v-list-item>
        </v-list-item-group>
      </v-list>
</template>
<script>
export default {
    
}
</script>