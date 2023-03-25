const { createApp } = Vue;

createApp({
    data(){
        return {
            currentIndex: 0,
            images: [
                'https://picsum.photos/id/237/500/300',
                'https://picsum.photos/id/238/500/300',
                'https://picsum.photos/id/239/500/300'
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