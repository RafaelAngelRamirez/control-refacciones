package modelo.dao;

import controlador.Coordinador;
import modelo.Conexion;

/**
 *
 * @author Particular
 */
public abstract class DAOGenerales  {
    
    Coordinador coordinador;
    private final String nombreClase;
    protected Conexion conexion;

    public DAOGenerales(Coordinador coordinador) {
        this.coordinador = coordinador;
        this.nombreClase = this.getClass().getName();
    }
    
    
 }
