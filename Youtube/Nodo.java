package ListaGenericaDoblementeEnlazada;

// Clase que representa un video
public class Nodo {
    private int video;
    private String titulo;
    private int duracion;
    
   Nodo sig;
   Nodo prev;
   
   //Contructor
   public Nodo(int video, String titulo, int duracion) {
       this.video = video;
       this.titulo = titulo;
       this.duracion = duracion;
       this.sig = null;
       this.prev = null;
   }
   
   //Getters
   public int getVideo(){
       return video;
   }
   
   public String getTitulo() {
       return titulo;
   }
   
   public int getDuracion() {
       return duracion;
   }
}


