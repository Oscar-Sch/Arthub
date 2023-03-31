const { createApp } = Vue

createApp( {
    data(){
        return {
            nombre: "Pepita de maiz",
            nickTitulo: "Pepi",
            nick: "Pepi",
            apellido: "Morello Pentesti",
            email: "pepita@gmail.com",
            direccion: "Av Siempre vivas",
            codigoPostal: "9876",
            ciudad: "Springfield",
            pais: "Estados Unidos",
            descripcionExtra: "Puerta amarilla con renacuajos multicolor",
            imagenUsuario: "",
            cvvTarjeta: 000,
            numeroTarjeta: "****-****-****-****",
            nombreTarjeta: "",
            expiracionTarjeta: "00/00",
            auxCambiarDatos: false,
            productos: [],
            error: "",
            pagoExitoso: false
        }
    },
    created(){
        this.informacion()
    },
    methods: {
        pagar(){
            console.log("holi")
            axios.post('https://mindhub-brothers-bank.up.railway.app/api/cards/transaction',{
                number : this.numeroTarjeta,
                cvv: this.cvvTarjeta,
                description : this.descripcionExtra,
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
                    console.log(error)
                })
        },
        informacion(){
            axios.get(`/api/clients`)
                .then(res=> {
                    console.log(res)
                    this.nombre = res.data.nombre
                    this.nickTitulo = res.data.nick
                    this.apellido = res.data.apellido
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
        activarFormulario(){
            document.getElementById('actualizarDatosBoton').classList.remove('ocultar-modal')
            for(let i = 0; i <= 9; i++){
                let input = document.getElementsByTagName("input")[i]
                input.removeAttribute("readonly")
                input.classList.add('formulario-input-bordebottom')
            }
        },
        actualizar(){
            axios.patch(`/api/clients/current`,`nombre=${this.nombre}&apellido=${this.apellido}&nick=${this.nick}&direccion=${this.direccion}
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
                if(this.email === "admin@mindhub.com"){
                    window.location.href = "../web/index.html"
                }else{
                    window.location.href = "./index.html"
                }
                
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
        },
    }
}).mount("#app")
