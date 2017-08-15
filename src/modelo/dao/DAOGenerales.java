package modelo.dao;

import vista.SplashInicio;
import controlador.Coordinador;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Conexion;

/**
 *
 * @author Particular
 */
public abstract class DAOGenerales  {
    
    Coordinador coordinador;
    private String nombreClase;
    protected Conexion conexion;

    public DAOGenerales(Coordinador coordinador) {
        this.conexion = new Conexion(coordinador);
        this.coordinador = coordinador;
        this.nombreClase = this.getClass().getName();
    }
    
    
 }
