package ia.busqueda_8_puzle_profundidad;

import javax.swing.JFrame;

public class Main {
    
    public static void main (String[]args) {
        
        //Ventana
        VentanaPrincipal vp =new VentanaPrincipal();
        vp.setVisible(true);
        vp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Estado inicial
        String tablero="123H56478";
       
        OchoPuzzleProfundidad ochopuzzle=new OchoPuzzleProfundidad(tablero);
        ochopuzzle.buscarSolucion(); 
        
    }
    
}
