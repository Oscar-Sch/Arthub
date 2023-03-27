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
            auxCambiarDatos: false,
            productos: [],
            error: ""
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
            axios.patch(`/api/clients/current`,`nombre=${this.nombre}&apellido=${this.apellido}&email=${this.email}&nick=${this.nick}&direccion=${this.direccion}
            &codigoPostal=${this.codigoPostal}&ciudad=${this.ciudad}&pais=${this.pais}&descripcionExtra=${this.descripcionExtra}&imagenUsuario=${this.imagenUsuario}`,
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
