/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import modelo.InfoTabla.MaquinaIT;

/**
 *
 * @author Particular
 */
public class MaquinaDao extends DAOGenerales{
    
    MaquinaIT it;
    
    public MaquinaDao(Coordinador coordinador) {
        super(coordinador);
        it = new MaquinaIT();
        
    }
    
    
    
}
