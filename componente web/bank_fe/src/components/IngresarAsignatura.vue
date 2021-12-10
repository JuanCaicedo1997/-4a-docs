<template>
  <body>
    <div class="formulario">
      <form class="form_Prueba" v-on:submit.prevent="guardarMateria">
        <label class="texto">Nombre de la asignatura: </label>
        <input class="inputs" type="text"  v-model="materia.nombreMateria" />
        <br />
        <label class="texto">Código: </label>
        <input class="inputs" type="text" v-model="materia.codigo"/>
        <br />
        <label class="texto">Calificación Materia: </label>
        <input class="inputs" type="float" v-model="materia.calificacionMateria"/>
        <br />
        <label class="texto">Creditos de la asignatura: </label>
        <input class="inputs" type="number" v-model="materia.creditosMateria"/>
        <br />
        <div class="botones_formulario">
          <button class="button" type="submit">Guardar</button>
          <button class="button">Cancelar</button>
        </div>
      </form>
    </div>
  </body>
</template>


<script>

import axios from "axios";
import jwt_decode from "jwt-decode";

export default {
  name: "Ingresar",
  data: function () {
    return {
      materia: {
        user: '',
        nombreMateria: '',
        codigo: '',
        calificacionMateria: '',
        creditosMateria: '',
      },
    };
  },

  methods: {
    guardarMateria: async function () {
      if (
        localStorage.getItem("token_access") === null ||
        localStorage.getItem("token_refresh") === null
      ) {
        this.$emit("logOut");
        return;
      }

      await this.verifyToken();

      let token = localStorage.getItem("token_access");
      let userId = jwt_decode(token).user_id.toString();
      this.materia.user = userId;

      axios
        .post(
          `https://bankend-1.herokuapp.com/materia/`,
          this.materia,
          {
            headers: { Authorization: `Bearer ${token}` },
          }
        )
        .then((result) => {         
          alert('Se guardó exitosamente');
          this.$router.push({ name: "home" });
        })
        .catch(() => {
          this.$emit("logOut");
        });
    },

    verifyToken: function () {
      return axios
        .post(
          "https://bankend-1.herokuapp.com/refresh/",
          { refresh: localStorage.getItem("token_refresh") },
          { headers: {} }
        )
        .then((result) => {
          localStorage.setItem("token_access", result.data.access);
        })
        .catch(() => {
          this.$emit("logOut");
        });
    },
  },
};
</script>


<style>
* {
  margin: 0;
  padding: 0;
}

.botones_formulario {
  display: flex;
  justify-content: center;
  margin-top: 5%;
  position: relative;
}

.formulario {
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 8%;
}

.button {
  cursor: pointer;
  width: 150px;
  margin: 1%;
  color: #e6e9e5;
  background: #4674c9;
  border: 1px solid #e6e9e5;
  border-radius: 5px;
  padding: 2% 3%;
}

.button:hover {
  color: #4674c9;
  background: #e7e9e5;
  border: 1px solid #e5e7e9;
}

.texto {
  margin-left: 50px;
  font-weight: bold;
  font-size: 17px;
  display: inline-block;
  width: 200px;
}

.inputs {
  margin-top: 23px;
  width: 10vw;
  height: 2vh;
}
</style>
