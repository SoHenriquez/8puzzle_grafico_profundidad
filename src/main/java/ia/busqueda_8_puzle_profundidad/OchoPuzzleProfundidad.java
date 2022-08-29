package ia.busqueda_8_puzle_profundidad;

import java.util.*;

class OchoPuzzleProfundidad {

   public ArrayList<Estado> colaEstados; 
   public HashMap<String,Integer> registroEstados;
   public Estado estadoInicial, estadoFinal; 
   public static final int PROFUNDIDAD_MAXIMA=100;
   public static final String ESTADO_FINAL="12345678H";
   
   public OchoPuzzleProfundidad(String estadoInicialTablero){
      //estado del tablero igual al inicial					 
      estadoInicial=new Estado(estadoInicialTablero,0,null,""); 
      colaEstados = new ArrayList<>();  //cola vacia al inicio  
      colaEstados.add(estadoInicial);
      
      registroEstados =new HashMap<>(); //registro vacio
      //registroEstados.put(estadoInicial,estadoInicial.toString().hashCode());
   }
   
   public void buscarSolucion() {
      boolean exito=false;
      Estado temp=null;
      ArrayList<Estado> sucesores;
      
      if ( estadoInicial.estadoTablero.equals(ESTADO_FINAL)) {
          exito=true;
          estadoFinal=estadoInicial;
      }
      
      int n_iteraciones=0;
      while ( !colaEstados.isEmpty() && !exito ) {
          System.out.println(" tamaño cola de estados "+colaEstados.size());
          temp=colaEstados.get(0);
          colaEstados.remove(0);
          sucesores=getSucesores(temp);
          //System.out.println(" Sucesores "+sucesores.toString());
          
          if ( temp.profundidad < PROFUNDIDAD_MAXIMA && 
                sucesores != null) {
       
              for ( int i=sucesores.size()-1 ; i >= 0 && !exito; i--) {
                  if ( sucesores.get(i).estadoTablero.equals(ESTADO_FINAL)) {
                      exito=true;
                      estadoFinal=sucesores.get(i);
                  }else {
                      colaEstados.add(0,sucesores.get(i));
                  } 
              }
          }
          
          ++n_iteraciones;
          
      }
      System.out.println(" iteraciones "+n_iteraciones);
	
      if ( estadoFinal == null ) System.out.println(" No se encontro solución");
      else {
          Estado temp_predecesor=estadoFinal;
          ArrayList<String> movimientos=new ArrayList<>();
          while (temp_predecesor != null ) {
              
              movimientos.add(temp_predecesor.movimiento);
              temp_predecesor=temp_predecesor.predecesor;
              
          }
          
          System.out.println("La solución para "+estadoInicial.estadoTablero);
          System.out.println("es "+estadoFinal.estadoTablero+" con profundidad "+estadoFinal.profundidad);
          System.out.println("");
          System.out.println("Movimientos:");
          int n=movimientos.size();
          for ( int i = n-1 ; i >= 0 ; i--)
              System.out.println(movimientos.get(i));
          
      }
      
   }//fin del método buscarSolucion
	
   public ArrayList<Estado> getSucesores(Estado e) {
       
      ArrayList<Estado> sucesores=new ArrayList<>(); 
      Estado arriba, abajo, izquierda, derecha;
      //si el estado no ha sido explorado lo añadimos la historial y 
      // generamos sus sucesores registramos
      if(!registroEstados.containsKey(e.estadoTablero)){
          
	 registroEstados.put(e.estadoTablero,e.estadoTablero.hashCode());
         
         izquierda=moverHuecoIzquierda(e,e.profundidad+1);
         abajo=moverHuecoAbajo(e,e.profundidad+1);
         arriba=moverHuecoArriba(e,e.profundidad+1);
         derecha=moverHuecoDerecha(e,e.profundidad+1);
         
         
         
         if ( arriba!=null ) sucesores.add(arriba);
         if ( abajo!=null ) sucesores.add(abajo);
         if ( izquierda!=null ) sucesores.add(izquierda);
         if ( derecha!=null ) sucesores.add(derecha);
         
         
         
         
        
       
         if ( sucesores.size() > 0 ) return sucesores;
         else return null;
         
      }else {
         
         return null; 
          
      }
         
   }
	
   private Estado moverHuecoArriba(Estado estado,int profundidad) {
      
      //Obtenemos la posicion del hueco 
      String estadoTablero=estado.estadoTablero; 
      int posicionHueco = estadoTablero.indexOf("H");
      //si la posición es mayor que 2 entonces realizamos el movimiento
      //realizar movimiento = cambiar configuracion de la cadena
      if( posicionHueco > 2 ) {
               
         String resultadoMover = estadoTablero.substring(0,posicionHueco-3)+"H"+
                    estadoTablero.substring(posicionHueco-2,posicionHueco)+
                    estadoTablero.charAt(posicionHueco-3)+estadoTablero.substring(posicionHueco+1);
         
        Estado nuevo=new Estado(resultadoMover,profundidad,estado,"mover Arriba");
        
        if (!registroEstados.containsKey(nuevo.estadoTablero) )
           return nuevo;
        else
           return null; 
        
      }else {   
        return null;
      }
   }//fin del metodo estático moverHuecoArriba
	
   private Estado moverHuecoAbajo(Estado estado,int profundidad) {
      
      String estadoTablero=estado.estadoTablero;  
      int posicionHueco = estadoTablero.indexOf("H");
      
      if( posicionHueco < 6 ){
               
         String resultadoMover = estadoTablero.substring(0,posicionHueco)+
                    estadoTablero.substring(posicionHueco+3,posicionHueco+4)+
                    estadoTablero.substring(posicionHueco+1,posicionHueco+3)+"H"+
                    estadoTablero.substring(posicionHueco+4);
         
	 Estado nuevo=new Estado(resultadoMover,profundidad,estado,"mover Abajo");
         
         if (!registroEstados.containsKey(nuevo.estadoTablero) )
           return nuevo;
         else
           return null; 
	 
      }else {
          
         return null;
          
      }
     
   }
        
   private Estado moverHuecoIzquierda(Estado estado,int profundidad){
      
      String estadoTablero=estado.estadoTablero;  
      int posicionHueco = estadoTablero.indexOf("H");
      if(posicionHueco!=0 && posicionHueco!=3 && posicionHueco!=6){
          
	String resultadoMover = estadoTablero.substring(0,posicionHueco-1)+"H"+
                   estadoTablero.charAt(posicionHueco-1)+
                   estadoTablero.substring(posicionHueco+1);
        
	Estado nuevo=new Estado(resultadoMover,profundidad,estado,"mover Izquierda");
        
        if (!registroEstados.containsKey(nuevo.estadoTablero) )
           return nuevo;
        else
           return null; 
	
      }else {
          
        return null;
          
          
      }
      
   }

   private Estado moverHuecoDerecha(Estado estado,int profundidad){

      String estadoTablero=estado.estadoTablero;   
      int posicionHueco = estadoTablero.indexOf("H");
      if(posicionHueco!=2 && posicionHueco!=5 && posicionHueco!=8){
          
         String resultadoMover = estadoTablero.substring(0,posicionHueco)+
            estadoTablero.charAt(posicionHueco+1)+"H"+
            estadoTablero.substring(posicionHueco+2);
         
	 Estado nuevo=new Estado(resultadoMover,profundidad,estado,"mover Derecha");
         
         if (!registroEstados.containsKey(nuevo.estadoTablero) )
           return nuevo;
         else
           return null; 
	
    
       }else {
          
         return null;
      }
      
    }
   
 
}

