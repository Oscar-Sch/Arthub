const { createApp } = Vue;

createApp({
    data(){
        return {
            currentIndex: 0,
            images: [
                '../web/assets/images/illustrations/illust_Joel/1.png',
                '../web/assets/images/illustrations/illust_Joel/2.png',
                '../web/assets/images/illustrations/illust_Joel/3.png'
              ]
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
          }
    },
    computed: {
        currentImage() {
          return this.images[this.currentIndex]
        }
    }
  
}).mount("#app")