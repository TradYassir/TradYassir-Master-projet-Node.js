
window.onload = init;
function init() {
    new Vue({
        el: '#app',
        data: {
            restaurants: [],
            input: "",
            NewName:"",
            NEwCuisine:"",
            page : 0,
            pagesize:10,
            length:0 
        },
        mounted() {
            console.log("--- MOUNTED, appelée avant le rendu de la vue ---");
            this.getDataFromWebService();
        },
        methods: {

            getDataFromWebService: function () {
                let url = "http://localhost:8080/api/restaurants?page="+this.page+"&pagesize="+this.pagesize;

                fetch(url).then((data) => {
                    console.log("les données sont arrivées !")
                  return data.json();
                }).then((dataEnJavaScript) => {
                    // ici on a bien un objet JS
                    this.restaurants = dataEnJavaScript.data;
                    this.length=dataEnJavaScript.count; 
                    console.log(dataEnJavaScript.count);
                });
            },
            RetourRestaurant:function(){
                this.getDataFromWebService();
                this.pagesize=10;
            },
            RechercherRestaurant: function (page) { 
                let url = "http://localhost:8080/api/restaurants?page="+0+"&name="+this.input;  
                fetch(url).then((data) => {
                    console.log("les données sont arrivées !")
                  return data.json();
                }).then((dataEnJavaScript) => { 
                    this.restaurants = dataEnJavaScript.data;
                    this.pagesize=dataEnJavaScript.count; 
                });
                 
            },ajouterRestaurant:function(name,cuisine){ 
                
                var formData = new FormData(); 
                formData.append("cuisine",cuisine); 
                 formData.append("nom",name); 
                 let url = "http://localhost:8080/api/restaurants";
                 fetch(url, {
                     method: "POST",
                     body: formData
                 })
                 .then(function(responseJSON) {
                  responseJSON.json()
                }).then(() => {
                    this.input=name;
                    this.RechercherRestaurant();
                    this.input="";
                    this.NewName="";
                    this.NEwCuisine="";
                }).catch(function (err) {
                   console.log(err);
                 });
              },
            updateRestaurant:function(id,name,cuisine){ 

                var formData = new FormData(); 
                formData.append("cuisine",cuisine); 
                 formData.append("nom",name);
                let url = "http://localhost:8080/api/restaurants/"+id;
                fetch(url, {
                          method: "PUT",
                          body: formData
                }).then(function(responseJSON) {
                responseJSON.json();
                
                 }).then(() => {
                    this.getDataFromWebService();
                }).catch(function (err) {
               console.log(err);
                });
            },
            removeRestaurant: function (id,index) { 
                console.log(index)
               let url = "http://localhost:8080/api/restaurants/"+id;
               fetch(url, {
                   method: "DELETE",
               })
               .then(function(responseJSON) {
                   responseJSON.json() ;
                   })
                   .catch(function (err) {
                       console.log(err);
               });
               this.restaurants.splice(index, 1);
            },
            PageSuivante: function(page){
                this.restaurants.page;
                this.page++;
                this.getDataFromWebService();
              },
              PagePrecedente: function(page){
                this.restaurants.page;
                if(this.page>0){
                  this.page--;
                  this.getDataFromWebService();
                }
              },
            PageFilter: function(page){
              console.log("hello");
            },
            getColor: function (index) {
                return (index % 2) ? 'black' : 'dimgray';
            },
            hide : function(){ 
            }
        }
    })
}
