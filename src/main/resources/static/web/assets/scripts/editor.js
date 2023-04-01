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
            colorSeleccionado: 'BLANCO',
            medida: 'L',
            productoSeleccionado: 'REMERA',
            listaCarrito:[],
            listaProductosGenericos:[],
            listaIlustraciones:[]
        }
    },
    created(){
        if(sessionStorage.getItem('logIn') == 'true' ){
            this.loginAux = sessionStorage.getItem('logIn')
        }
        this.cargarDatos();

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
            console.table([this.images[this.currentIndex],this.productoSeleccionado,this.colorSeleccionado,this.medida]);
          },
        nextImage() {
            console.log("next")
            this.currentIndex = (this.currentIndex + 1) % this.images.length
            console.table([this.images[this.currentIndex],this.productoSeleccionado,this.colorSeleccionado,this.medida]);
        },
        llavero(){

        },
        cambiarColor(color){
            console.log(color)
            this.colorSeleccionado = color
            console.table([this.images[this.currentIndex],this.productoSeleccionado,this.colorSeleccionado,this.medida]);
        },
        seleccion(icono, producto){
            this.seleccionado = icono
            this.productoSeleccionado = producto
            console.log(icono)
            if(icono == 'vista-previa__editor-producto-llavero' || icono == 'vista-previa__editor-producto-cuaderno'  || icono == 'vista-previa__editor-producto-retrato' || icono == 'vista-previa__editor-producto-taza'){
                this.colorSeleccionado = ''
            }
            console.table([this.images[this.currentIndex],this.productoSeleccionado,this.colorSeleccionado,this.medida]);
        },
        talle(medida){
            this.medida = medida
            console.table([this.images[this.currentIndex],this.productoSeleccionado,this.colorSeleccionado,this.medida]);
        },
        cargarDatos(){
            axios.get("/api/productos")
            .then(res=>{
                this.listaProductosGenericos=res.data;
            })
            // axios.get("/api/productos")
            // .then(res=>{
            //     this.listaProductosGenericos=res.data;
            // })
        },
        agregarAlCarrito(){
            let ilustracion=this.images[this.currentIndex];
            console.log({"ilustracion":ilustracion})
            let producto;
            if (this.productoSeleccionado=="LLAVERO" || this.productoSeleccionado=="LIBRETA" || this.productoSeleccionado=="TAZA"){
                producto=this.listaProductosGenericos.find(prod=> prod.tipoProducto==this.productoSeleccionado);
            }else if (this.productoSeleccionado=="PRINT"){
                producto=this.listaProductosGenericos.find(prod=> prod.tipoProducto==this.productoSeleccionado && prod.tamaño==this.medida);
            }else{
                producto=this.listaProductosGenericos.find(prod=> prod.tipoProducto==this.productoSeleccionado && prod.talla==this.medida && prod.color==this.colorSeleccionado);
            }
            console.log(producto)
            let index= this.listaCarrito.findIndex(prod=>prod.productoId===producto.id);
            // let index= this.listaCarrito.findIndex(prod=>prod.productoId===producto.id && prod.ilustracionId===ilustracion.id);
            if (index<0){
                console.log("pusheado")
                let nuevoProducto={
                    productoId:producto.id,
                    ilustracionId:ilustracion,
                    cantidad:1
                }
                this.listaCarrito.push(nuevoProducto);
            }else{
                console.log("agregado")
                this.listaCarrito[index].cantidad++;
            }
            localStorage.setItem("Carrito", JSON.stringify(this.listaCarrito));
            // this.productoculosFiltrados=this.ActualizarEstadoCarrito();
            console.log(JSON.parse(localStorage.getItem("Carrito")))
        },
        RestarAlCarrito(producto, ilustracion){
            let index= this.listaCarrito.findIndex(prod=>prod.productoId===producto.id && prod.ilustracionId);
            this.listaCarrito[index].cantidad--;
            // this.articulosFiltrados=this.ActualizarEstadoCarrito();
            if(this.listaCarrito[index].enCarrito<=0){
                this.listaCarrito.splice(index,1);
            }
            localStorage.setItem("Carrito", JSON.stringify(this.listaCarrito));
            // this.articulosFiltrados=this.ActualizarEstadoCarrito();
            console.log(JSON.parse(localStorage.getItem("Carrito")))
        },
    },
    computed: {
        currentImage() {
          return this.images[this.currentIndex]
        },
        estaEnCarrito(){
            if(localStorage.getItem("Carrito")){
                this.listaCarrito= JSON.parse(localStorage.getItem("Carrito"));
                this.articulosFiltrados= this.ActualizarEstadoCarrito();
                // console.log(this.articulosFiltrados)
            }
        }
    }
  
}).mount("#app")