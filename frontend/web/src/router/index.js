import Vue from 'vue'
import VueRouter from 'vue-router'
import ListagemDeVideos from '../components/listagem-de-videos'
import UploadDeVideos from '../components/upload-de-videos';

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'listagem-de-videos',
    component: ListagemDeVideos
  },
  {
    path: '/upload-de-videos',
    name: 'upload-de-videos',
    component: UploadDeVideos
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
