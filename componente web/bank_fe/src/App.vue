<template>
  <div id="app" class="app">
    <div class="header">
        <h1 v-if="is_auth" v-on:click="loadHome">Calculos Promedios</h1>
      <div class="menu">
        <button v-if="is_auth" v-on:click="loadIngresar">Ingresar asignatura</button>
        <button v-if="is_auth" v-on:click="loadVer">Ver asignatura</button>
      </div>
      <nav>
        <button v-if="is_auth" v-on:click="loadHome">Inicio</button>
        <button v-if="is_auth" v-on:click="loadAccount">Cuenta</button>
        <button v-if="is_auth" class="boton_cerrar_sesion" v-on:click="logOut">Cerrar</button>
        <button v-if="!is_auth" v-on:click="loadLogIn">Iniciar Sesión</button>
        <button v-if="!is_auth" v-on:click="loadSignUp">Registrarse</button>
      </nav>
    </div>

    <div class="main-component">
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
        v-on:logOut="logOut"
      >
      </router-view>
    </div>

    <div class="footer">
      <h2>Académicos</h2>
    </div>
  </div>
</template>


<script>

export default {
  name: "App",

  computed: {
    is_auth: {

      get: function() {
        return this.$route.meta.requiresAuth;
      },
        set: function() { }
    }
  },

  methods: {
    verifyAuth: function () {
      this.is_auth = localStorage.getItem("isAuth") || false;

      if (this.is_auth == false) this.$router.push({ name: "logIn" });
      else this.$router.push({ name: "home" });
    },

    loadHome: function () {
      this.$router.push({ name: "home" });
    },

    loadIngresar: function () {
      this.$router.push({ name: "ingresar" });
    },

    loadCalcular: function () {
      this.$router.push({ name: "calcular" });
    },

    loadVer: function () {
      this.$router.push({ name: "ver" });
    },

    loadAccount: function () {
      this.$router.push({ name: "account" });
    },

    logOut: function () {
      localStorage.clear();
      alert("Sesión Cerrada");
      this.verifyAuth();
    },

    loadLogIn: function () {
      this.$router.push({ name: "logIn" });
    },

    loadSignUp: function () {
      this.$router.push({ name: "signUp" });
    },

    loadAccount: function () {
      this.$router.push({ name: "account" });
    },

    completedLogIn: function (data) {
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.verifyAuth();
    },

    completedSignUp: function (data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    },
  },

  created: function () {
    this.verifyAuth();
  },
};

const router = createRouter({
    history: createWebHistory(),
    routes,
});

router.beforeEach((to, from) => {
  localStorage.setItem("Key", "Value");
    return { name: "logIn" };
  
})
</script>

<style>
body {
  margin: 0 0 0 0;
}

.header {
  margin: 0%;
  padding: 0;
  width: 100%;
  height: 10vh;
  min-height: 100px;

  background-color: #4674c9;
  color: #e5e7e9;

  display: flex;
  justify-content: space-between;
  align-items: center;
}

.header h1 {
  width: 20%;
  text-align: center;
}

.header nav {
  height: 100%;
  width: 20%;

  display: flex;
  justify-content: space-around;
  align-items: center;

  font-size: 20px;
}

.header nav button {
  color: #e6e9e5;
  background: #4674c9;
  border: 1px solid #e6e9e5;

  border-radius: 5px;
  padding: 10px 20px;
}

.header nav button:hover {
  color: #4674c9;
  background: #e7e9e5;
  border: 1px solid #e5e7e9;
}

.main-component {
  height: 75vh;
  margin: 0%;
  padding: 0%;

  background: #fdfefe;
}

.footer {
  margin: 0;
  padding: 0;
  width: 100%;
  height: 2vh;
  min-height: 92px;

  background-color: #4674c9;
  color: #e5e7e9;
}

.footer h2 {
  width: 100%;
  height: 100%;

  display: flex;
  justify-content: center;
  align-items: center;
}

.menu button {
  color: #e6e9e5;
  background: #4674c9;
  border: 1px solid #e6e9e5;

  border-radius: 5px;
  padding: 10px 20px;
  margin: 2%;
}

.menu button:hover {
  color: #4674c9;
  background: #e7e9e5;
  border: 1px solid #e5e7e9;
}

.menu {
  height: 100%;
  width: 20%;

  display: flex;
  justify-content: space-around;
  align-items: center;

  font-size: 20px;
}
</style>


