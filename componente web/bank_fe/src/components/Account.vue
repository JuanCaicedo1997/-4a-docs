<template>

    <div v-if="loaded" class="information">
        <h1>Información de su cuenta</h1>
        <h2>Nombre: <span>{{name}}</span></h2>
        <h2>Correo electrónico: <span>{{email}}</span></h2>
    </div>

</template>


<script>

import gql from "graphql-tag";

export default {
    name: "Account",

   data: function () {
        return {
            username: localStorage.getItem("username") || "none",
        accountByUsername: {
            codigo: "",
            nombreMateria: "",
            calificacionMateria:"",
            creditosMateria:""
        }
    };
},
apollo: {
    accountByUsername: {
        query: gql`
            query ($username: String!) {
                accountByUsername(username: $username) {
                    codigo
                    nombreMateria
                    calificacionMateria
                    creditosMateria
                }
            }
        `,
        variables() {
            return {
                username: this.username,
            };

        },
    },
},
    created: function () {
        this.$apollo.queries.accountByUsername.refetch();
    }
};
</script>


<style>
    .information{
        margin: 0;
        padding: 0%;
        width: 100%;
        height: 100%;

        display: flex;
        flex-direction: column;
        justify-content: center;    
        align-items: center;
    }

    .information h1{
        font-size: 60px;
        color: #0f1316;
    }

    .information h2{
        font-size: 40px;
        color: #4674c9;
    }

    .information span{
        color: #0f1316;
        font-weight: bold;
    }
</style>