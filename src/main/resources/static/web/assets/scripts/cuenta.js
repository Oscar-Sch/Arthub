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
            error: ""
        }
    },
    created(){
        this.informacion()
    },
    methods: {
        informacion(){
            axios.get(`/api/usuario/actual`)
                .then(res=> {
                    this.nombre = res.data.nombre.split("-")[0].trim()
                    this.nickTitulo = res.data.nick
                    this.nick = this.nickTitulo
                    this.apellido = res.data.nombre.split("-")[1].trim()
                    this.email = res.data.email
                    this.imagenUsuario = res.data.imagenUsuario
                    this.ciudad = res.data.ciudad
                    this.pais = res.data.pais
                    this.direccion = res.data.direccion
                    this.codigoPostal = res.data.codigoPostal
                    this.descripcionExtra = res.data.descripcionExtra
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
            for(let i = 0; i <= 9; i++){
                let input = document.getElementsByTagName("input")[i]
                input.setAttribute("readonly", "")
                input.classList.remove('formulario-input-bordebottom')
            }
            axios.patch(`/api/usuario/modificar`,`nombre=${this.nombre + "-" + this.apellido}&email=${this.email}&nick=${this.nick}&direccion=${this.direccion}
            &codigoPostal=${this.codigoPostal}&ciudad=${this.ciudad}&pais=${this.pais}&descripcionExtra=${this.descripcionExtra}&avatarUrl=${this.imagenUsuario}`,
                {headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(res=> {
                    this.informacion()
                })
                .catch(error => {
                    this.error = error.data
            })
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {this.loginAux = sessionStorage.setItem('logIn', false)})
        },
        mostrarDatos(idMostrar, idOcultar, idTextoActivo,idTextoDesactivado){
            document.getElementById(idMostrar).classList.remove('ocultar-capa')
            document.getElementById(idOcultar).classList.add('ocultar-capa')
            document.getElementById(idTextoActivo).classList.add('informacion-navegar-activo')
            document.getElementById(idTextoDesactivado).classList.remove('informacion-navegar-activo')
            document.getElementById('iconoEditar').classList.toggle('ocultar-capa')
        }
    }
}).mount("#app")
