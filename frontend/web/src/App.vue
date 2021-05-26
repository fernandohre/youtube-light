<template>
  <v-app id="inspire">
    <v-toolbar>
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>
      <!--Ícone do youtube-->
      <v-toolbar-title><icone-youtube-light></icone-youtube-light></v-toolbar-title>
      <v-text-field></v-text-field>
      <v-btn icon>
        <v-icon>mdi-magnify</v-icon>
      </v-btn>
      <v-spacer></v-spacer>
      <v-btn icon>
        <v-icon>mdi-apps</v-icon>
      </v-btn>

      <v-btn icon>
        <v-icon>mdi-dots-vertical</v-icon>
      </v-btn>
    </v-toolbar>

    <v-navigation-drawer v-model="drawer" fixed temporary>
      <!--Opções do drawer componentizadas-->
      <opcoes-menu></opcoes-menu>
    </v-navigation-drawer>

    <v-main class="grey lighten-2">
      <v-container>
        <v-row>
          <template v-for="n in 4">
            <v-col :key="n" class="mt-2" cols="12">
              <strong>Categoria {{ n }}</strong>
            </v-col>

            <v-col v-for="j in 6" :key="`${n}${j}`" cols="6" md="2">
              <v-sheet height="150"></v-sheet>
            </v-col>
          </template>
        </v-row>
      </v-container>
    </v-main>
  </v-app>
</template>

<script>
import OpcoesMenu from "./components/opcoes-menu";
import IconeYoutubeLight from "./components/icone-youtube-light"
export default {
  name: "App",

  components: { OpcoesMenu, IconeYoutubeLight },

  data() {
    return {
      drawer: null,
    };
  },
};
</script>
