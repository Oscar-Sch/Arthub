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
            cvvTarjeta: 000,
            numeroTarjeta: "****-****-****-****",
            nombreTarjeta: "",
            expiracionTarjeta: "00/00",
            auxCambiarDatos: false,
            productos: [],
            error: "",
            loginAux: false,
            pagoExitoso: false
        }
    },
    created(){
        if(sessionStorage.getItem('logIn') == 'true' ){
            this.loginAux = sessionStorage.getItem('logIn')
        }
        this.informacion()
    },
    methods: {
        informacion(){
            axios.get(`/api/usuario/actual`)
                .then(res=> {
                    this.nombre = res.data.nombre.split("-")[0].trim()
                    this.nickTitulo = res.data.nick
                    this.apellido = res.data.nombre.split("-")[1].trim()
                    this.email = res.data.email
                    this.imagenUsuario = res.data.imagenUsuario
                    this.ciudad = res.data.ciudad
                    this.pais = res.data.pais
                    this.direccion = res.data.direccion
                    this.codigoPostal = res.data.codigoPostal
                    this.descripcionExtra = res.data.descripcionExtra
                    this.productos = res.data.productos
                })
                .catch(error => console.log(error))
        },
        pagar(){
            axios.post('https://mindhub-brothers-bank.up.railway.app/api/cards/transaction',{
                number : this.numeroTarjeta,
                cvv: this.cvvTarjeta,
                description : "Items bought on Arthub",
                amount: 1
            }).then(response => {
                    this.cerrarModal()
                    this.pagoExitoso = true
                    setTimeout(() => {
                        this.pagoExitoso = false
                    }, 3000)
                    console.log(response)
                })
                .catch(error => {
                    this.error = error.response.data
                })
        },
        activarFormulario(){
            document.getElementById('actualizarDatosBoton').classList.remove('ocultar-modal')
            for(let i = 0; i <= 9; i++){
                let input = document.getElementsByTagName("input")[i]
                input.removeAttribute("readonly")
                input.classList.add('formulario-input-bordebottom')
            }
        },
        actualizar(){
            axios.patch(`/api/usuario/modificar`,`nombre=${this.nombre}&apellido=${this.apellido}&nick=${this.nick}&direccion=${this.direccion}
            &codigoPostal=${this.codigoPostal}&ciudad=${this.ciudad}&pais=${this.pais}&descripcionExtra=${this.descripcionExtra}`,
                {headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(res=> {
                    this.informacion()
                })
                .catch(error => {
                    this.error = error.data
            })
            document.getElementById('actualizarDatosBoton').classList.add('ocultar-modal')
            for(let i = 0; i <= 9; i++){
                let input = document.getElementsByTagName("input")[i]
                input.setAttribute("readonly", "")
                input.classList.remove('formulario-input-bordebottom')
            }
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {
                sessionStorage.setItem('logIn', false)
                this.loginAux = false
            })
        },
        mostrarDatos(idMostrar, idOcultar, idTextoActivo,idTextoDesactivado){
            document.getElementById(idMostrar).classList.remove('ocultar-capa')
            document.getElementById(idOcultar).classList.add('ocultar-capa')
            document.getElementById(idTextoActivo).classList.add('informacion-navegar-activo')
            document.getElementById(idTextoDesactivado).classList.remove('informacion-navegar-activo')
            document.getElementById('iconoEditar').classList.toggle('ocultar-capa')
        },
        cerrarModal() {
            document.getElementById('modalCarrito').classList.toggle('ocultar-modal')
            this.error="";
        },
    }
}).mount("#app")
