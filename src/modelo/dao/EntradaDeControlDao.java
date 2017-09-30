/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import controlador.Coordinador;
import modelo.InfoTabla.EntradaDeControlIT;
import modelo.InfoTabla.SalidaDeControlIT;

/**
 *
 * @author Particular
 */
public class EntradaDeControlDao extends DAOGenerales{
    
    EntradaDeControlIT it;
    public EntradaDeControlDao(Coordinador coordinador) {
        super(coordinador);
        it = new EntradaDeControlIT();
        
    }
    
    
    
}
