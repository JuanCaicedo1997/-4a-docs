import gql from "graphql-tag";
import { createRouter, createWebHistory } from "vue-router";
import { ApolloClient, createHttpLink, InMemoryCache } from '@apollo/client/core'

import LogIn from './components/LogIn.vue'
import SignUp from './components/SignUp.vue'
import Home from './components/Home.vue'
import Account from './components/Account.vue'
import Ingresar from './components/IngresarAsignatura.vue'
import Calcular from './components/CalcularPromedios.vue'
import Ver from './components/VerAsignatura.vue'


const routes = [
    {
        path: '/',
        name: 'root',
        component: App,
        meta: { requiresAuth: false }
        },

    {
        path: '/user/logIn',
        name: "logIn",
        component: LogIn,
        meta: { requiresAuth: false }
        
    },

    {
        path: '/user/signUp',
        name: "signUp",
        component: SignUp,
        meta: { requiresAuth: false }
    },

    {
        path: '/user/home',
        name: "home",
        component: Home,
        meta: { requiresAuth: false }
    },

    {
        path: '/user/account',
        name: "account",
        component: Account,
        meta: { requiresAuth: false }
    },

    {
        path: '/user/ingresar',
        name: "ingresar",
        component: Ingresar,
        meta: { requiresAuth: false }
    },

    {
        path: '/user/calcular',
        name: "calcular",
        component: Calcular,
        meta: { requiresAuth: false }
    },

    {
        path: '/user/ver',
        name: "ver",
        component: Ver,
        meta: { requiresAuth: false }
    },

    {
        path: '/user/account',
        name: "account",
        component: Account,
        meta: { requiresAuth: false }
    }

];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

const apolloClient = new ApolloClient({
    link: createHttpLink({ uri: 'https://backend-web-api-gateway.herokuapp.com/' }),
    cache: new InMemoryCache()
})

async function isAuth() {
    if (localStorage.getItem("token_access") === null ||
localStorage.getItem("token_refresh") === null) {
        return false;
    }
    try {
        var result = await apolloClient.mutate({
            mutation: gql `
                mutation ($refresh: String!) {
                    refreshToken(refresh: $refresh) {
                        access
                    }
                }
            `,
            variables: {
                refresh: localStorage.getItem("token_refresh"),
            },
        })

        localStorage.setItem("token_access", result.data.refreshToken.access);
        return true;
    } catch {
        localStorage.clear();
        alert("Su sesión expiró, por favor vuelva a iniciar sesión");
        return false;
    }
}

router.beforeEach(async(to, from) => {
    var is_auth = await isAuth();

    if (is_auth == to.meta.requiresAuth) return true

    if (is_auth) return { name: "home" };
        return { name: "logIn" };
})

export default router;
