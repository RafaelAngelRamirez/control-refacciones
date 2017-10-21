/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.capturadeerrores;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
     * Esta clase permite el tranporte de una más complicada información para
     * representarla en consola de debugueo. Es necesario pues que se defina
     * en el <Code>System.out.println({@literal <Object>})</Code>. La clase
     * {@see CapturaDeSucesos} se encarga de lo demas. 
     */
    public class Suceso {
        /**
         *Muestra al información en la consola de errores junto con la descripción
         * de la clase donde se ejecuta el suceso. 
         */
        public final static int INFO_CLASE = 1;
        /**
         *Muestra al información en la consola de errores junto con la descripción
         * de la clase donde se ejecuta el suceso y una ventana emergente. 
         */
        public final static int INFO_CLASE_VENTANA_EMERGENTE = 2;
        private int comoSeMostraraLaInfo;
        private Object clase;
        private String textoAMostrar;

        /**
         * Retorna la opción que define la forma en que se mostrara la info.
         * @return Un valor entero. Utilizar las variables destaticas de {@see CapturaDeSucesos}
         */
        public int getComoSeMostraraLaInfo() {
            if (comoSeMostraraLaInfo==0) {
                try {
                    throw new ExcepcionPersonalizada("No has definido como quieres "
                            + "que se muestre la información.", this, "getComoSeMostraraLaInfo");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(CapturaDeSucesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return comoSeMostraraLaInfo;
        }

        /**
         * Define la forma que se mostrara la info. 
         * Utilizar las variables destaticas de {@see CapturaDeSucesos}
         * @param comoSeMostraraLaInfo La opción que define como se mostrara la info.
         */
        public void setComoSeMostraraLaInfo(int comoSeMostraraLaInfo) {
            this.comoSeMostraraLaInfo = comoSeMostraraLaInfo;
        }

        /**
         * La clase de la que se quiere mostrar el nombre. 
         * @return El objeto de la clase de la que se quiere mostrar el nombre.
         */
        public Object getClase() {
            if (clase==null) {
                try {
                    throw new ExcepcionPersonalizada("No has definido la clase de la que quieres obtener el nombre.",
                            this, "getClase()");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(CapturaDeSucesos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return clase;
        }

        /**
         * Define la clase de la que se quiere mostrar el nombre. 
         * @param clase La clase de la que se mostrará el nombre. 
         */
        public void setClase(Object clase) {
            this.clase = clase;
        }

        /**
         * El texto que se mostrara.
         * @return Cadena de texto. 
         */
        public String getTextoAMostrar() {
            return textoAMostrar;
        }

        /**
         * El mensaje que se quire mostrar. 
         * @param textoAMostrar El texto que se mostrara. 
         */
        public void setTextoAMostrar(String textoAMostrar) {
            this.textoAMostrar = textoAMostrar;
        }
    }
    