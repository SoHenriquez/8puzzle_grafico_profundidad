/*cd cod
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ia.busqueda_8_puzle_profundidad;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author esteb
 */
public class MundoVirtual extends Canvas {
    public MundoVirtual(){
        this.setBackground(Color.blue);
    }
    @Override
    public void paint (Graphics g){
        g.drawString("Texto provisorio",10,10);
    }
}
