const { createApp } = Vue;

createApp({
    data(){
        return {
            currentIndex: 0,
            images: [
                '../web/assets/images/illustrations/illust_Joel/1.png',
                '../web/assets/images/illustrations/illust_Joel/2.png',
                '../web/assets/images/illustrations/illust_Joel/3.png'
            ],
            seleccionado: 'vista-previa__editor-producto',
            colorSeleccionado: '',
            medida: '',
            productoSeleccionado: '',
        }
    },
    created(){
       

    },
    methods:{
        openMenu() {
            let container=document.querySelector(".menu-container");
            if (container.style.width=="11rem"){
                container.style.width = "4.2rem";
            }else{
                container.style.width = "11rem";
            }
        },
        prevImage() {
            console.log("prev")
            this.currentIndex = (this.currentIndex - 1 + this.images.length) % this.images.length
          },
        nextImage() {
            console.log("next")
            this.currentIndex = (this.currentIndex + 1) % this.images.length
        },
        llavero(){

        },
        cambiarColor(color){
            console.log(color)
            this.colorSeleccionado = color

        },
        seleccion(icono, producto){
            this.seleccionado = icono
            this.productoSeleccionado = producto
            console.log(icono)
            if(icono == 'vista-previa__editor-producto-llavero' || icono == 'vista-previa__editor-producto-cuaderno'  || icono == 'vista-previa__editor-producto-retrato' || icono == 'vista-previa__editor-producto-taza'){
                this.colorSeleccionado = ''
            }
        },
        talle(medida){
            this.medida = medida
        }
    },
    computed: {
        currentImage() {
          return this.images[this.currentIndex]
        }
    }
  
}).mount("#app")