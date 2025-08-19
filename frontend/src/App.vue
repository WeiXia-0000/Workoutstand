<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/dumbbells.png" width="400px" height="175px">
    <HelloWorld msg="Welcome to the world of athletes!"/>
  </div>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'
//import SignUp from './components/SignUp.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
    //SignUp
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top:10px;


  background-image: url('./assets/background_silver.png');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
