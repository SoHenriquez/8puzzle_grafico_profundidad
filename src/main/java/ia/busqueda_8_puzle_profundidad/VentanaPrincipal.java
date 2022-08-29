/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia.busqueda_8_puzle_profundidad;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author esteb
 */
public class VentanaPrincipal extends JFrame {
    public MundoVirtual mv;
    
    public VentanaPrincipal (){
        this.getContentPane().setLayout(null);
        mv = new MundoVirtual();
        mv.setBounds(10,50,300,300);
        this.getContentPane().add(mv);
        
        this.setSize(500,400);
        this.setTitle("8puzzle Busqueda en Profundidad");
        this.getContentPane().setBackground(Color.gray);
    }

}
