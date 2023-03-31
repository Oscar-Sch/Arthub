const { createApp } = Vue

createApp( {
    data(){
        return {
            nombreIlustrador: "",
            tipoDeProducto: false, 
            productos: ["Remera", "Taza", "Cuaderno", "Llavero", "Poster"],
            productosFiltrados: []
        }
    },
    created(){
        
    },
    methods: {
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
