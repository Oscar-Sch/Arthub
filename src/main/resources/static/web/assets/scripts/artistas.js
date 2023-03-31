const { createApp } = Vue

createApp( {
    data(){
        return {
            ilustradores: [],
            ilustradoresFiltados: [],
            nombreIlustrador: ""
        }
    },
    created(){
    },
    methods: {
        logOut(){
            axios.post('/api/logout')
            .then(response => {
                if(this.email === "admin@mindhub.com"){
                    window.location.href = "../web/index.html"
                }else{
                    window.location.href = "./index.html"
                }
                
            })
        },
        filtroNombreIlustrador(){
            let filtro = this.ilustradores.filter(ilustrador => ilustrador.nick.toLowerCase().includes(this.nombreIlustrador.toLowerCase()))
            this.ilustradoresFiltados = filtro
        }
    },
    mounted() {
        AOS.init();
    },
}).mount("#app")
