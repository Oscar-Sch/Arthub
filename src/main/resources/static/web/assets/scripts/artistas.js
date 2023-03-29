const { createApp } = Vue

createApp( {
    data(){
        return {
           
        }
    },
    created(){

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
    },
    mounted() {
        AOS.init();
    },
}).mount("#app")
