package ia.busqueda_8_puzle_profundidad;


public class Estado {
    
    public String estadoTablero;
    public int profundidad;
    public Estado predecesor;
    public String movimiento;
    
    public Estado(String estadoTablero,int profundidad, Estado predecesor,
            String movimiento) {
        this.estadoTablero=estadoTablero;
        this.profundidad=profundidad;
        this.predecesor=predecesor;
        this.movimiento=movimiento;
    }
    
  
    @Override
    public String toString() {
        return "[ Estado ("+estadoTablero+"), Profundidad "+profundidad+" ]";
    }
    
}
