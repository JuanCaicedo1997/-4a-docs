<template>

<div class="contenedor">
    <p >Calificación Materia: <span class="negrita">{{ asignatura.nombreMateria }} </span> </p>
    <br />
    <p >Calificación Materia: <span class="negrita">{{ asignatura.codigo }} </span> </p>
    <br />
    <p >Calificación Materia: <span class="negrita">{{ asignatura.calificacionMateria }} </span> </p>
    <br />
    <p >Calificación Materia: <span class="negrita">{{ asignatura.creditosMateria }} </span> </p>
    <br />
  </div>

  
</template>


<script>
export default {
  name: "Ver",
  data: function () {
    this.obtenerAsignatura();
    return {
      asignatura: this.obtenerAsignatura(),
    };
  },
  methods: {
    obtenerAsignatura() {
      return JSON.parse(localStorage.getItem("asignatura"));
    },
  },
};
</script>


<style>
  * {
    margin: 0;
    padding: 0;
  }


  .contenedor {
    align-items: center;
    text-align: center;
    font-size: 20px;
    padding-top:8%;
  }

  .negrita{
    font-weight: 800;
  }

</style>