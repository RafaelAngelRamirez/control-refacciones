/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz.VentanaPrincipal;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import modelo.ExcepcionPersonalizada;

/**
 * Guarda la información del item o menú que se quiere crear para mostrarlo 
 * en la barra de menu de la ventan principal. 
 * @author Particular
 */
public class MenuConstructor {
        
    private boolean menu;
    private boolean item;
//    private JPanel thisPanel;
//    private JDialog thisDialog;


    private String nombre;
    private String padre;
    private String imagen;

    private Runnable accionDelItem;
//    private Runnable accionInicializacion;
//    private boolean accionInicializacionEjecutada = false;
//    private boolean siempreAccionInicializada = false;

    private KeyStroke atajoDeTeclado;


    /**
    * SE ENCARGA DE ALMACENAR EL PANEL JUNTO CON LA INFORMACION DEL MENU CONSTRUCTOR
    * PARA ACCEDER ATRAVEZ DE EL EN LA LISTA.
    */
    public MenuConstructor() {
    }

//    @Deprecated
//    public JDialog getThisDialog() {
//        if (thisDialog == null) {
//            try {
//                throw new ExcepcionPersonalizada("No has definido un dialgo.", this, "getThisDialog");
//            } catch (ExcepcionPersonalizada ex) {
//                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else if( thisPanel!=null){
//            try {
//                throw new ExcepcionPersonalizada(" No puedes tener un dialgo y un panel en el mismo objeto.", this, "getThisDialog");
//            } catch (ExcepcionPersonalizada ex) {
//                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return thisDialog;
//    }
//    @Deprecated
//    public void setDialog(JDialog thisDialog) {
//
//        this.thisDialog = thisDialog;
//    }




    /**
     * Devuelve la acción que ejecutara el item al ser presionado. Si no se
     * define ningúna acción entonces se ejecutara por defecto el cambio
     * de panel en caso de que este definido uno.
     * 
     * @return Retorna la acción que ejecutara un item al ser ejecutado .
     */
    @Deprecated
    public Runnable getAccionDelItem() {
        return accionDelItem;
    }

    /**
     * Define la acción que se quiere setear sobre el item. Si no se define 
     * una acción por defecto se ejecutara el cambio de paneles. 
     * @param accionDelItem La acción que se quiere ejecutar. 
     */
    public void setAccionDelItem(Runnable accionDelItem) {
        if (this.isMenu()) {
            try {
                throw new ExcepcionPersonalizada(
                        "Parece que"+" \" "+this.getNombre()+" \" esta definido como un menu."
                        +"\n Un menu no debe llevar acciones.", this, "setAccionDelItem");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.accionDelItem = accionDelItem;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna true si el elemento es un Menu. 
     * @return True si es menu. 
     */
    public boolean isMenu() {
        return menu;
    }

    /**
     * Define que el MenuConstructor tiene almacenado un Menú.
     */
    public void setMenu() {
        try {
            if (this.item==true) {
                throw new ExcepcionPersonalizada(
                    "El menuConstructor ya esta definido como un item.",
                    this, "setMenu");
            }

            this.menu = true;
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *Retorna true si es un item.
     * @return  True si es item.
     */
    public boolean isItem() {
        return item;
    }

    /*
    * Define que el MeuConstructor tiene almacenado un Item. 
    */
    public void setItem() {
        try {
            if (this.menu==true) {
                throw new ExcepcionPersonalizada(
                    "El menuConstructor ya esta definido como un menu.",
                    this, "setItem");
            }

            this.item = true;
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } 

    }

//    /**
//     * Retorna el panel al que señala el item. 
//     * @return El panel que se tiene almacenado.  
//     */
//    @Deprecated
//    public JPanel getThisPanel() {
//        try {
//            if (this.menu==true) {
//                throw new ExcepcionPersonalizada(
//                    "Este menyConstructor ya esta definido como un menu y no "
//                            + " puedes definir un panel dentro de el.",
//                    this, "setThisPanel");
//            }else if( this.accionDelItem == null && this.thisPanel==null){
//                throw new ExcepcionPersonalizada( 
//                    "No definiste una acción para este Menú costructor y por"
//                     + "defecto este tomando la acción de cambiar de Jpanel "
//                            + "pero tampoco esta definido un JPanel", this, "getThisPanel"
//                );
//            }
//            return thisPanel;
//
//        } catch (ExcepcionPersonalizada ex) {
//            Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

//    /**
//     * Setea el panel al que se quiere llamar por medio de un item.
//     * @param thisPanel El panel que se quiere almacenar. 
//     */
//    @Deprecated
//    public void setPanel(JPanel thisPanel) {
//        try {
//            if (this.menu==true) {
//                throw new ExcepcionPersonalizada(
//                    "Este menuConstructor ya esta definido como un menu y no "
//                            + " puedes definir un panel dentro de el.",
//                    this, "setThisPanel");
//            }
//
//            this.thisPanel = thisPanel;
//        } catch (ExcepcionPersonalizada ex) {
//            Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        } 
//    }

    /*
     * Retorna el padre de el menu o el item. 
     */
    public String getPadre() {
        return padre;
    }

    /**
     * 
     * Define el padre del el menu o el item. El necesario pasar el 
     * menúCosntructor del JPanel que se quiere señalar como padre del elemento
     * actual.
     * 
     * @param padre El MenuConstructor del padre. 
     */
    public void setPadre(MenuConstructor padre) {
        if (padre.isItem()) {
            try {
                throw new ExcepcionPersonalizada(
                    "\""+padre.getNombre() + "\" esta declarado como un item y no puede"
                    + " ser padre de ningún elemento. Definelo como menú.", this, "setPadre");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.padre = padre.getNombre();
    }

    /**
     * La ruta de la imagen que se quiere agregar como icono al menu. 
     * @return  La ruta para llegar a la imágen.
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Agrega el string para insertar una imagene en el elemento. 
     * @param imagen La ruta de la imagen que se quiere agregar como icono al menu. 
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * Define la acción que se ejecutara para inicializar el panel que es 
     * llamado a la ventana principal. Estas configuraciones solo se pueden
     * correr hasta despues de que la clase Coordinador haya cargado y 
     * seteado todos los paneles, de manera que no se puede hacer en el 
     * constructor del panel. Hay que hacerlo desde aquí y solo una vez. Para
     * eso esta la (@see setAccionInicializacionEjecutada)
     * @param accionInicialización La acción que se quiere ejecutar al inicializar
     * el panel. 
     */
//    @Deprecated
//    public void setAccionDeInicializacion(Runnable accionInicialización){
//        this.accionInicializacion = accionInicialización;
//    }

    /**
     * La acción para inicializar el panel. 
     * @return La acción que se ejecutara al inicializar el panel.
     */
//    @Deprecated
//    public Runnable getAccionInicializacion() {
//        if (accionInicializacion==null) {
//            try {
//                throw new ExcepcionPersonalizada(
//                        "No definiste el inicializador para el panel : "+ getNombre() ,
//                        this,
//                        "getAccionInicializacion");
//            } catch (ExcepcionPersonalizada ex) {
//                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//        return accionInicializacion;
//    }

    /**
     * Comprueba que si se ejecuto una sola vez la acción de inicialización
     * del panel. Si no se define siempreAccionInicializadaComo true entonces
     * solo se ejecutara la inicizalización una vez.
     * @return  True si se inicializo el panel y isSiempreAccionInicializada() es
     * false.
     */
//    @Deprecated
//    public boolean isAccionInicializacionEjecutada() {
//        if (isSiempreAccionInicializada()) {
//            return false;
//        }
//        return accionInicializacionEjecutada;
//    }

    /**
     * Define si se ha inicializado el panel. 
     * @param accionInicializacionEjecutada True cuando se ejecuto. 
     */
//    @Deprecated
//    public void setAccionInicializacionEjecutada(boolean accionInicializacionEjecutada) {
//        this.accionInicializacionEjecutada = accionInicializacionEjecutada;
//    }
//
//    @Deprecated
//    public boolean isSiempreAccionInicializada() {
//        return siempreAccionInicializada;
//    }

    /**
     * Provoca que la acción de inicialización siempre se ejecute al llamar
     * el panel. Para esto dentro de isAccionInicializacionEjecutada comprobamos
     * que este parametro este en true. Si es así entonces retorna siempre 
     * false de manera que ejecute las acciones de inicialización.
     * @param siempreAccionInicializada True para que sieempre se ejecute la
     * acción de inicialización o false para que solo ejecute una vez. 
     * @see #getAccionInicializacion() 
     */
//    @Deprecated
//    public void setSiempreAccionInicializada(boolean siempreAccionInicializada) {
//        this.siempreAccionInicializada = siempreAccionInicializada;
//    }

    /**
     * Define el atajo de teclado que se quiere mostrar. Esto solo se toma
     * en cuenta para los items, no para los menus. 
     * @return 
     */
    public KeyStroke getAtajoDeTeclado() {
        return atajoDeTeclado;
    }

    /**
     * Setea el objeto KeyStroke que contiene el atajo de teclado deseado.
     * Normalmente yo lo genero desde netbeans XP.
     * @param atajoDeTeclado
     */
    public void setAtajoDeTeclado(KeyStroke atajoDeTeclado) {
        this.atajoDeTeclado = atajoDeTeclado;
    }



}
    
    

