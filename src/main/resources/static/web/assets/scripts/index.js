const { createApp } = Vue

createApp( {
    data(){
        return {
            nombre: "",
            nickTitulo: "",
            nick: "",
            nickOEmail: "",
            apellido: "",
            email: "",
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
        cerrarModal(movimiento) {
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
        }
    }
}).mount("#app")
