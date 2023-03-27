const { createApp } = Vue

createApp( {
    data(){
        return {
            nick: "Pepi",
            ilustraciones: [],
            ilustracionesCantidad: "5",
            imagenIlustrador: "",
            ciudad: "Springfield",
            redes: ['pepita', 'pepitadelmaiz'],
            nombreIlustracion: "Nombre de la ilu",
            auxCambiarDatos: false
        }
    },
    created(){
        this.informacion()
    },
    methods: {
        openMenu() {
            let container=document.querySelector(".menu-container");
            if (container.style.width=="11rem"){
                container.style.width = "4.2rem";
            }else{
                container.style.width = "11rem";
            }
        },
        informacion(){
            axios.get(`/api/clients`)
                .then(res=> {
                    this.nick = res.data.nick
                    this.imagenIlustrador = res.data.imagenUsuario
                    this.ilustracionesCantidad = res.data.ilustraciones.length
                    this.ilustraciones = res.data.ilustraciones
                    this.ciudad = res.data.ciudad
                    this.redes = res.data.redes
                })
                .catch(error => console.log(error))
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {
                if(this.email === "admin@mindhub.com"){
                    window.location.href = "../web/index.html"
                }else{
                    window.location.href = "./index.html"
                }
                
            })
        }
    }
}).mount("#app")
