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
        cerrarModal(movimiento) {
            document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
        },
        mostrarRegistro(){
            document.getElementById('inicioSesion').classList.toggle('ocultar-modal')
            document.getElementById('registro').classList.toggle('ocultar-modal')
        },
        register(){
            axios.post('/api/clients',`nombre=${this.nombre}&apellido=${this.apellido}&email=${this.email}&contraseña=${this.contraeña}&direccion=${this.direccion}
                        &codigoPostal=${this.codigoPostal}&pais=${this.pais}&ciudad=${this.ciudad}&nick=${this.nick}&descripcionExtra=${this.descripcionExtra}`,
                        {headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                axios.post('/api/login',`email=${this.email}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(res => { this.informacion()}) 
                .catch(error => {})
            })
        },
        logIn(){
            axios.post('/api/login',`email=${this.email}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(res => {
                if(this.email === "admin@mindhub.com"){
                    window.location.href = "../admin/create-loan.html"
                }else{
                    window.location.href = "./index.html"
                }
                this.informacion()
            }) 
            .catch(error => {})
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {})
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
