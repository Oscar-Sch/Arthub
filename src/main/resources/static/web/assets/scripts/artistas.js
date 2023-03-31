const { createApp } = Vue

createApp( {
    data(){
        return {
            ilustradores: [],
            ilustradoresFiltrados: [],
            nombreIlustrador: "",
            loginAux: false
        }
    },
    created(){
        if(sessionStorage.getItem('logIn') == 'true' ){
            this.loginAux = sessionStorage.getItem('logIn')
        }
        this.informacion()
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
            axios.post('/api/usuario/registro',
                        {
                            nombre: this.nombre + "-" + this.apellido,
                            email: this.email,
                            contraseña: this.contraseñaRegistro,
                            direccion: this.direccion,
                            zipCode: this.codigoPostal,
                            pais: this.pais,
                            ciudad: this.ciudad,
                            nick: this.nick,
                            descripcion:this.descripcionExtra
                        })
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
                        sessionStorage.setItem('logIn', true)
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
                sessionStorage.setItem('logIn', true)
                this.loginAux = true
                setTimeout(()=>{
                    document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                },2000)
            }) 
            .catch(error => {this.error = error.response.data
            console.log(error)})
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {
                sessionStorage.setItem('logIn', false)
                this.loginAux = false
            })
        },
        informacion(){
            axios.get(`/api/ilustradores`)
            .then(res=>{
                this.ilustradores = res.data
                this.ilustradoresFiltrados = [...this.ilustradores]
            })
        },
        filtroNombreIlustrador(){
            let filtro = this.ilustradores.filter(ilustrador => ilustrador.nick.toLowerCase().includes(this.nombreIlustrador.toLowerCase()))
            this.ilustradoresFiltrados = filtro
        },
        verPerfil(nick){
            window.location.href = `./ilustrador.html?nick=${nick}`
        }
    },
    mounted() {
        AOS.init();
    },
}).mount("#app")
