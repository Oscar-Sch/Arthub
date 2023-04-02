const { createApp } = Vue

createApp( {
    data(){
        return {
            nombre: "",
            nickTitulo: "",
            nick: "",
            apellido: "",
            email: "",
            direccion: "",
            codigoPostal: "",
            ciudad: "",
            pais: "",
            descripcionExtra: "",
            imagenUsuario: "",
            auxCambiarDatos: false,
            productos: [],
            error: "",
            loginAux: false,
            avatarUrl: ""
        }
    },
    created(){
        if(sessionStorage.getItem('logIn') == 'true'){
            this.loginAux = sessionStorage.getItem('logIn')
        }
        this.informacion()
    },
    methods: {
        informacion(){
            axios.get(`/api/usuario/actual`)
                .then(res=> {
                    this.nombre = res.data.nombre.split(" ")[0].trim()
                    this.nickTitulo = res.data.nick
                    this.nick = this.nickTitulo
                    this.apellido = res.data.nombre.split(" ")[1].trim()
                    this.email = res.data.email
                    this.avatarUrl=res.data.avatarUrl
                    this.imagenUsuario = res.data.imagenUsuario
                    this.ciudad = res.data.direcciones.ciudad
                    this.pais = res.data.direcciones.pais
                    this.direccion = res.data.direcciones.direccion
                    this.codigoPostal = res.data.direcciones.zipCode
                    this.descripcionExtra = res.data.direcciones.descripcion
                    this.productos = res.data.listaDeCompras
                })
                .catch(error => console.log(error))
        },
        activarFormulario(){
            for(let i = 0; i <= 9; i++){
                let input = document.getElementsByTagName("input")[i]
                input.removeAttribute("readonly")
                input.classList.add('formulario-input-bordebottom')
            }
        },
        actualizar(){
            axios.patch(`/api/usuario/modificar`,`nombre=${this.nombre + "-" + this.apellido}&email=${this.email}&nick=${this.nick}&direccion=${this.direccion}
            &zipCode=${this.codigoPostal}&ciudad=${this.ciudad}&pais=${this.pais}&descripcion=${this.descripcionExtra}&avatarUrl=${this.imagenUsuario}`,
                {headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(res=> {
                    document.getElementById('inicioSesionRegistro').classList.remove('contenedor-despedida')
                    document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                    document.getElementById('mensaje').innerText = res.data
                    setTimeout(()=>{
                        document.getElementById('inicioSesionRegistro').classList.toggle('contenedor-despedida')
                        setTimeout(()=>{
                            document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                        }, 1500)
                    }, 2000)
                })
                .catch(error => {
                    document.getElementById('inicioSesionRegistro').classList.remove('contenedor-despedida')
                    document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                    document.getElementById('mensaje').innerText = error.data
                    setTimeout(()=>{
                        document.getElementById('inicioSesionRegistro').classList.toggle('contenedor-despedida')
                        setTimeout(()=>{
                            document.getElementById('inicioSesionRegistro').classList.toggle('ocultar-modal')
                        }, 1500)
                    }, 2000)
            })
            for(let i = 0; i <= 9; i++){
                let input = document.getElementsByTagName("input")[i]
                input.setAttribute("readonly", "")
                input.classList.remove('formulario-input-bordebottom')
            }
           
        },
        logOut(){
            sessionStorage.setItem('logIn', false)
            this.loginAux = false
            axios.post('/api/logout')
        },
        mostrarDatos(idMostrar, idOcultar, idTextoActivo,idTextoDesactivado){
            document.getElementById(idMostrar).classList.remove('ocultar-capa')
            document.getElementById(idOcultar).classList.add('ocultar-capa')
            document.getElementById(idTextoActivo).classList.add('informacion-navegar-activo')
            document.getElementById(idTextoDesactivado).classList.remove('informacion-navegar-activo')
            document.getElementById('iconoEditar').classList.toggle('ocultar-capa')
        },
        verProductos(){
            window.location.href = `./productos.html`
        }
    }
}).mount("#app")
