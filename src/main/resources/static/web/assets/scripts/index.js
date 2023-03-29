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
            error: ""
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
        },
        informacion(){
            axios.get(`/api/clients`)
                .then(res=> {
                    this.nickTitulo = res.data.nick
                })
                .catch(error => console.log(error))
        },
        registro(){
            console.log("holi")
            axios.post('/api/usuario/registro',`nombre=${this.nombre + "-" + this.apellido}&email=${this.email}&contraseña=${this.contraseñaRegistro}&direccion=${this.direccion}
                        &codigoPostal=${this.codigoPostal}&pais=${this.pais}&ciudad=${this.ciudad}&nick=${this.nick}&descripcionExtra=${this.descripcionExtra}`,
                        {headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(response => {
                axios.post('/api/login',`email=${this.email}&password=${this.password}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
                .then(res => { this.informacion() 
                    }) 
                .catch(error => {})
            })
        },
        logIn(){
            console.log("pucha")
            axios.post('/api/login',`email=${this.emailONick}&password=${this.contraseña}`,{headers:{'content-type':'application/x-www-form-urlencoded'}})
            .then(res => {
                if(this.email === "admin@mindhub.com"){
                    window.location.href = "../admin/create-loan.html"
                }else{
                    window.location.href = "./index.html"
                }

                
                this.informacion()
            }) 
            .catch(error => {console.log(error)})
        },
        logOut(){
            axios.post('/api/logout')
            .then(response => {})
        }
    }
}).mount("#app")
