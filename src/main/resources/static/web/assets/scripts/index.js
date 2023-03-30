const { createApp } = Vue

createApp( {
    data(){
        return {
            nombre: "",
            nickTitulo: "",
            nick: "",
            emailONick: "",
            apellido: "",
            email: "",
            contraseñaRegistro: "",
            contraseña: "",
            direccion: "",
            codigoPostal: "",
            ciudad: "",
            pais: "",
            descripcionExtra: "",
            imagenUsuario: "",
            auxCambiarDatos: false,
            error: "",
            loginAux: false,
            password: ""
        }
    },
    created(){
       
    },
    methods: {
        cerrarModal() {
            document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
        },
        mostrarRegistro(){
            document.getElementById('inicioSesion').classList.toggle('ocultar-modal')
            document.getElementById('registro').classList.toggle('ocultar-modal')
            this.error = ""
        },
        registro(){
            axios.post('/api/usuario/registro',`nombre=${this.nombre + "-" + this.apellido}&email=${this.email}&contraseña=${this.contraseñaRegistro}&direccion=${this.direccion}
                        &codigoPostal=${this.codigoPostal}&pais=${this.pais}&ciudad=${this.ciudad}&nick=${this.nick}&descripcionExtra=${this.descripcionExtra}`,
                        {headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(res => {
                let mensajeTexto = res.data
                document.getElementById('registro').classList.toggle('ocultar-modal')
                let mensaje = document.getElementById('mensaje')
                mensaje.classList.toggle('ocultar-modal')
                mensaje.innerText = mensajeTexto
                
                this.password = this.contraseñaRegistro
                setTimeout(()=>{
                    axios.post('/api/login',`email=${this.nick}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
                    .then(res => { 
                        this.loginAux = true
                        mensaje.innerHTML = `${mensajeTexto} <p class="mt-2">Iniciaste sesion...</p>`

                        setTimeout(()=>{
                            document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                        },2000)
                    }) 
                    .catch(error => {this.error = error.response.data})
                }, 2000)
            })
            .catch(error => {this.error = error.response.data})
        },
        logIn(){
            axios.post('/api/login',`email=${this.emailONick}&password=${this.contraseña}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(res => {
                this.loginAux = true
                document.getElementById('inicioSesion').classList.toggle('ocultar-modal')
                let mensaje = document.getElementById('mensaje')
                mensaje.classList.toggle('ocultar-modal')
                mensaje.innerText = `Iniciaste sesion correctamente.`

                setTimeout(()=>{
                    document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                },2000)
            }) 
            .catch(error => {this.error = error.response.data
            console.log(error)})
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {this.loginAux = false})
        }
    }
}).mount("#app")
