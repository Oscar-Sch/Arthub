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
            password: "",
            nombreIlustrador: "",
            tipoDeProducto: false, 
            productos: ["Remera", "Taza", "Cuaderno", "Llavero", "Poster"],
            productosFiltrados: [],
            ilustradores: [],
            ilustradoresFiltrados: [],
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
                        },1500)
                    }) 
                    .catch(error => {this.error = error.response.data})
                }, 1500)
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
                },1500)
            }) 
            .catch(error => {
                console.log(this.emailONick)
                console.log(this.contraseña)
                if(this.emailONick == "" || this.contraseña == "" ){
                    this.error = "Completa todos los campos."
                }else if(error.code == 'ERR_BAD_REQUEST'){
                    this.error = "La contraseña no coincide con el usuario."
                }

            })
        },
        logOut(){
            sessionStorage.setItem('logIn', false)
            this.loginAux = false
            axios.post('/api/logout')
        },
        informacion(){
            axios.get(`/api/ilustradores`)
            .then(res=>{
                this.ilustradores = res.data
                this.ilustradoresFiltrados = [...this.ilustradores]
                console.log(res.data)
            })
        },
        filtroNombreIlustrador(){
            let filtro = this.ilustradores.filter(ilustrador => ilustrador.nick.toLowerCase().includes(this.nombreIlustrador.toLowerCase()))
            this.ilustradoresFiltrados = filtro

        },
        filtroProducto(){
            let filtroInput = this.ilustradores.filter(e => e.nick.toLowerCase().includes(this.nombreIlustrador.toLowerCase))
            let filtroSelect = filtroInput.filter(e => this.tipoDeProducto.includes(e.productos))
            this.productosFiltrados = filtroSelect
        }
    },
    mounted() {
        AOS.init();
    },
}).mount("#app")
