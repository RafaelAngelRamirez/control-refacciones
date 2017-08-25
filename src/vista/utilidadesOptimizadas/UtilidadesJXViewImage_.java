/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.utilidadesOptimizadas;

import controlador.capturadeerrores.Suceso;
import modelo.ExcepcionPersonalizada;
import controlador.Coordinador;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.jdesktop.swingx.JXImageView;

/**
 *
 * @author Particular
 */
public class UtilidadesJXViewImage_ extends OperacionesBasicasPorDefinir {
    
    private List<File> imagenesPorCargar = new ArrayList<>();
    private List<TransporteImagenesURL> listaURLsCargadas = new ArrayList<>();
    private int contadorPosicionImagenWeb=0;
    
    private JFrame formularioPadre;
    private int contadorImagenActiva;
    private JXImageView jxImagenView ;
    private JLabel jLabelContador;
    private File imagenActiva;
    private Colores_ colores = new Colores_();
    
    private boolean seEliminoUltimaImagen = false;
    
    private List <FileNameExtensionFilter> filtros = new ArrayList<FileNameExtensionFilter>();
    private List <String> extencionesAdmitidas = new ArrayList<String>();

    public UtilidadesJXViewImage_(Coordinador controlador) {
        super(controlador);
    }
    
    

    public void setFormularioPadre(JFrame formularioPadre) {
        this.formularioPadre = formularioPadre;
    }

    /**
     * El componente que se gestionara. Para contar las imágenes existe {@see: setjLabelContador}
     * que realiza las tareas sobre la etiqueta sin necesidad de ningúna intervención.
     * @param jxImagenView
     */
    public void setComponente(JXImageView jxImagenView) {
        if (jxImagenView==null) {
            try {
                throw new ExcepcionPersonalizada( "Se resivio null como parametro", this, "setComponente");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.jxImagenView = jxImagenView;
        
        this.jxImagenView.setBackground(colores.TEMA_VISOR_DE_IMAGENES
        );
        this.zoom();
    }
    
    /**
     *  Limpia el componenet dejandolo como recien seteado. 
     */
    public void limpiar(){
        this.imagenesPorCargar.clear();
        try {
            this.jxImagenView.setImage(new File(""));
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.imagenActiva=null;
        this.getjLabelContador().setText("");
        this.contadorImagenActiva = 0;
        reiniciar();
        
    }
    
    /**
     * El jLabel que se utilizara para ir contando las imágenes. 
     * @param jLabelContador
     */
    public void setjLabelContador(JLabel jLabelContador) {
        this.jLabelContador = jLabelContador;
    }
    
    /**
     * El JLabel que muestra el contador de imágenes. 
     * @return
     */
    public JLabel getjLabelContador(){
        if (this.jLabelContador == null) {
            try {
                throw new ExcepcionPersonalizada("No has definido la etiqueta para "
                        + "contar las imágenes.", this, "getjLabelContador");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return this.jLabelContador;
    }
    
    /**
     * Se agregan automaticamente a la lista de extenciones para filtrar 
     * las imagenes que se soportan. El usuario puede ver todas los tipos de
     * fichero y seleccionarlos pero solo se cargaran las imagenes definidas
     * dentro de filtros.
     * 
     * @param filtro Filtro a definir.
     */
    public void setFiltros (FileNameExtensionFilter filtro){
        for (int i = 0; i < filtro.getExtensions().length; i++) {
            String extension = filtro.getExtensions()[i];
            this.extencionesAdmitidas.add(extension);
        }
        this.filtros.add(filtro);
    }
    
    
    public JXImageView getThis() {
        return jxImagenView;
    }
    
    
    public void cargarImagenesArrastrando(boolean arrastrar){
        this.jxImagenView.setDragEnabled(arrastrar);
    }

    
    /**
     * Muestra un JFileChooser y prepara las imágenes para la vista previa.
     * 
     * Es necesaro setear los filtros que se van a aceptar antes. 
     * 
     */
    public void cargarImagenes(){
        if (this.filtros.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada("No has definido filtros.",
                        this, "cargarImagenes()");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setMultiSelectionEnabled(true);
        for (FileNameExtensionFilter ext : this.filtros) {
            jFileChooser.setFileFilter(ext);
        }
        //QUITAMOS LAS OPCIONES DE TODOS LOS ARCHIVOS.
        jFileChooser.setAcceptAllFileFilterUsed(false);
        
        int respuesta = jFileChooser.showOpenDialog(this.formularioPadre);
        //ESCOGEMOS LOS FICHEROS.
        if(respuesta == JFileChooser.APPROVE_OPTION){
            File[] imagenes = jFileChooser.getSelectedFiles();
            System.out.println("[!] Imagenes seleccionadas");
            for (File archivo : imagenes) {
                for (String ext : this.extencionesAdmitidas) {
                    if(archivo.getName().indexOf(ext) != -1){
                        //ESTAS SON LAS IMAGENES QUE SE CARGARAN EN EL PREVIO.   
                        this.imagenesPorCargar.add(archivo);
                        System.out.println("     | " +archivo.getName());
                        //MUY IMPORTANTE ESTE BREAK PARA QUE NO CARGA VARIAS 
                        // VECES LA MISMA IMAGEN.
                        break;
                    }
                }
            }
        }
        //CARGA LA PRIMERA IMAGEN DE LA LISTA.
        this.siguienteAnterior(true);
        this.comprobarVisibilidadDeImagenes();
    }
    
    /**
     * Carga las rutas de las imágenes que esten alojadas en el servidor.
     * 
     */
    public void cargarPrimeraImagen(){
//        try {
            if (!listaURLsCargadas.isEmpty()) {
                
                System.out.println("[!] Imagenes cargadas");
                contadorPosicionImagenWeb =0;
                //CARGA LA PRIMERA IMAGEN DE LA LISTA.
                this.setDeImagen();
            }else{
                System.out.println(""
                        + "==============================================\n"
                        + "==============================================\n"
                        + "==============================================\n"
                        + "==============================================\n"
                        + "[ERROR] PARECE QUE NO SE CARGO NINGUNA IMAGEN \n"
                        + "==============================================\n"
                        + "==============================================\n"
                        + "==============================================\n"
                        + "==============================================\n");
                
            }
        
    }
    
//    /**
//     *Agrega las imagenes para luego mostrarlas. Es necesario ejecutar cargarPrimeraImagen
//     * para que se previzualize esta.
//     * @param url
//     * @param nombre
//     */
//    public void addIMagenes(URL url, String nombre){
//        TransporteImagenesURL t = new TransporteImagenesURL();
//        t.setNombreImagen(nombre);
//        t.setUrl(url);
//        listaURLsCargadas.add(t);
//    }
    /**
     *Agrega las imagenes para luego mostrarlas. Es necesario ejecutar cargarPrimeraImagen
     * para que se previzualize esta.
     * @param transporteImagenesURL Las url que se mostraran desde el servidor.
     */
    public void addIMagenes(TransporteImagenesURL transporteImagenesURL){
        listaURLsCargadas.add(transporteImagenesURL);
    }
    
    /**
     * Limpia el componente dejandolo como recien seteado. Este se utiliza para
     * las veces que se cargan imagenes desde la web. 
     */
    public void limpiarComponenteURL(){
        listaURLsCargadas.clear();
        contadorPosicionImagenWeb=0;
        limpiar();
    }
    
    

    /**
     * Devuelve la lista de imagenes cargadas a travez de url.
     * @return Lista de TransporteImagenesURL.
     */
    public List<TransporteImagenesURL> getListaURLsCargadas() {
        return listaURLsCargadas;
    }
    
    /**
     * Setea la lista de url desde otro componente imagen View. 
     * @param listaURLsCargadas La lista de URL que serán mostradas. Normalemte
     * se pasa para no cargar de nuevo desde la BD.
     */
    public void setListaURLsCargadas(List<TransporteImagenesURL> listaURLsCargadas) {
        this.listaURLsCargadas = listaURLsCargadas;
    }
    
    
    
    /**
     * Permite que se gestionen el nombre y la url de la imagen que se carga
     * desde el servidor. 
     */
    public static class TransporteImagenesURL{
        
        private String nombreImagen;
        private String nombreImagenServidor;
        private URL url;
        private int IdImagen;
        private boolean idSeteado = false;

        public String getNombreImagenServidor() {
            if (nombreImagenServidor.isEmpty()) {
                try {
                    throw new ExcepcionPersonalizada(
                            "No definiste nombre de la imagen en servidor.", 
                            this, 
                            "getNombreImagen");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return nombreImagenServidor;
        }

        public void setNombreImagenServidor(String nombreImagenServidor) {
            this.nombreImagenServidor = nombreImagenServidor;
        }
        
        public String getNombreImagen() {
            if (nombreImagen==null) {
                try {
                    throw new ExcepcionPersonalizada(
                            "No definiste nombre.", 
                            this, 
                            "getNombreImagen");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return nombreImagen;
        }

        public void setNombreImagen(String nombreImagen) {
            this.nombreImagen = nombreImagen;
        }

        public URL getUrl() {
            if (url==null) {
                try {
                    throw new ExcepcionPersonalizada("No definiste la URL.", this, "getURL");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return url;
        }

        public void setUrl(URL url) {
            this.url = url;
        }

        public int getIdImagen() {
            if (!idSeteado) {
                try {
                    throw new ExcepcionPersonalizada("No definiste la URL.", this, "getURL");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return IdImagen;
        }

        public void setIdImagen(int IdImagen) {
            idSeteado = true;
            this.IdImagen = IdImagen;
        }
        
    
    }
    
    /**
     *Recorre las imagenes cargadas desde el servidor hacia la derecha.
     */
    public void imagenSiguiente(){
        cambiarImagen(true);
    }
    /**
     *Recorre las imagenes cargadas desde el servidor hacia la derecha.
     */
    public void imagenAnterior(){
        cambiarImagen(false);
    }
    
    /**
     * Permite realiza el cambio entre imagenes que son descargadas desde una
     * url.
     */
    private void cambiarImagen(boolean direccion){
        //El total de imagenes que estan cargadas en la lista.   
        int totalDeImagenes = this.listaURLsCargadas.size();
            //HACIA LA DERECHA.
        if (totalDeImagenes==0) {
            JOptionPane.showMessageDialog(null, "No hay imagenes cargadas.");
        }else{
            if (direccion) {
                //CORREGIMOS EL TOTAL DE IMAGNES PARA QUE SE AJUSTE AL CONTEO
                // DEL INDICE. 
                if (totalDeImagenes-1>contadorPosicionImagenWeb) {
                    //COMO SON MÁS IMAGENES QUE EL CONTEO ACTUAL SE SUMA UNO 
                    // AL CONTEO Y SE MUESTRA LA IMAGEN.
                    contadorPosicionImagenWeb++;
                    setDeImagen();

                }else if(totalDeImagenes-1 == contadorPosicionImagenWeb){
                    //CUANDO EL CONTADOR ES IGUAL AL AJUSTE DEL TOTAL DE LAS 
                    // IMÁGENES REINCIAMOS EL CONTADOR. 
                    contadorPosicionImagenWeb =0;
                    setDeImagen();
                }
            }else{

                if (contadorPosicionImagenWeb>0) {
                    //COMO SON MÁS IMAGENES QUE EL CONTEO ACTUAL SE SUMA UNO 
                    // AL CONTEO Y SE MUESTRA LA IMAGEN.
                    contadorPosicionImagenWeb--;
                    setDeImagen();

                }else if(0 == contadorPosicionImagenWeb){
                    //CUANDO EL CONTADOR ES IGUAL AL AJUSTE DEL TOTAL DE LAS 
                    // IMÁGENES REINCIAMOS EL CONTADOR. 
                    contadorPosicionImagenWeb =totalDeImagenes-1;
                    setDeImagen();
                }

            }
        }
    }
    
    /**
     * Obtiene la imagen actual de una lista que fue obtenida desde el servidor.  
     * @return  Clase TransporteImagenesURL que contiene la información necesaria
     * para mostrar la imágen en el componente. 
     * 
     * @see TransporteImagenesURL
     */
    public TransporteImagenesURL obtenerImagenActual(){
        if (this.listaURLsCargadas.size()==0) {
            JOptionPane.showMessageDialog(null, "No hay imagenes cargadas.");
            return null;
        }else{
            return this.listaURLsCargadas.get(contadorPosicionImagenWeb);
        }
    }
    
    /**
     * La estructura para las etiquetas  
     */
    private void setDeImagen(){
        try {
            
            TransporteImagenesURL tpiurl = listaURLsCargadas.get(contadorPosicionImagenWeb);
            String etiqueta = (contadorPosicionImagenWeb+1)+"/"+listaURLsCargadas.size()+ ":"+tpiurl.getNombreImagen();

            this.getThis().setImage(tpiurl.getUrl());
            this.jLabelContador.setText(etiqueta);
        } catch (IOException ex) {
            Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Recorre las imagenes cargadas en la clase. True en aumento y viceversa.
     * Esta función es exclusiva para cargar ficheros desde el equipo en que 
     * se esta ejecutando el cliente.
     * @param direccion True aumenta, false disminuye.
     */    
    public void siguienteAnterior(boolean direccion){
        
        if (this.imagenesPorCargar.isEmpty()) {
            if (this.seEliminoUltimaImagen) {
                
                File a = new File("");
                try {
                    this.getThis().setImage(a);
                } catch (IOException ex) {
                    Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.jLabelContador.setText("");
                this.imagenActiva = null;
                this.seEliminoUltimaImagen = true;
                reiniciar();
            }else{
                //NO HAY IMAGENES CARGARDAS.
                String mensaje = "No se a cargado ningúna imagen.";
                JOptionPane.showMessageDialog(this.formularioPadre, mensaje);
                System.out.println("[!] " + mensaje);
                reiniciar();
            }
        }else{
            //HAY IMAGENES.
            if (this.imagenActiva == null) {
                //NO SE HA CARGADO LA PRIMERA IMAGEN
                //INICIAMOS EL CONTADOR.
                Suceso s = new Suceso();
                s.setClase(this);
                s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                s.setTextoAMostrar("[!]Iniciando vista previa.");
                System.out.println(s);
                this.contadorImagenActiva = 0;
                this.imagenActiva = this.imagenesPorCargar.get(
                        this.contadorImagenActiva);
                try {
                    //CARGAMOS LA PRIMERA IMAGEN DE LA LISTA DE IMAGENES.
                    this.jxImagenView.setImage(this.imagenActiva);
                    
                } catch (IOException ex) {
                    Suceso s1 = new Suceso();
                    s1.setClase(this);
                    s1.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                    s1.setTextoAMostrar("[ERROR] ALGO PASO");
                    System.out.println(s1);
                    JOptionPane.showMessageDialog(this.formularioPadre,
                            "La imagen no se puede cargar. \n Se eliminara"
                                    + "de la lista.");
                    this.imagenesPorCargar.remove(imagenActiva);
                    
                    Logger.getLogger(UtilidadesJXViewImage_
                            .class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                    //HAY UNA IMAGEN ACTIVA POR QUE YA SE HABIA MOSTRADO EL PREVIO.
                if (direccion) {
                    Suceso s1 = new Suceso();
                    s1.setClase(this);
                    s1.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                    s1.setTextoAMostrar("[!]Cambiando vista previa - derecha.");
                    System.out.println(s1);
                    //HACIA LA DERECHA.
                    if ((this.imagenesPorCargar.size()-1)>this.contadorImagenActiva) {
                        //TODAVIA HAY MÁS IMAGENES POR CARGAR.
                        Suceso s2 = new Suceso();
                        s2.setClase(this);
                        s2.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                        s2.setTextoAMostrar("[!]Hay más imagenes - derecha.");
                        System.out.println(s2);
                        this.contadorImagenActiva++;
                    }else{
                        //LLEGAMOS AL FINAL DE LA LISTA.
                        Suceso s2 = new Suceso();
                        s2.setClase(this);
                        s2.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                        s2.setTextoAMostrar("[!]No hay más imagenes - reiniciando.");
                        System.out.println(s2);
                        this.contadorImagenActiva = 0;
                    }
                } else {
                    //HACIA LA IZQUIERDA
                    Suceso s1 = new Suceso();
                    s1.setClase(this);
                    s1.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                    s1.setTextoAMostrar("[!]Cambiando vista previa - izquierda.");
                    System.out.println(s1);
                    if (this.contadorImagenActiva==0) {
                        Suceso s2 = new Suceso();
                        s2.setClase(this);
                        s2.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                        s2.setTextoAMostrar("[!]Hay más imagenes - izquierda.");
                        System.out.println(s2);
                        this.contadorImagenActiva = this.imagenesPorCargar.size()-1;
                    } else {
                        Suceso s3 = new Suceso();
                        s3.setClase(this);
                        s3.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                        s3.setTextoAMostrar("[!]No hay más imagenes - reiniciando.");
                        System.out.println(s3);
                        this.contadorImagenActiva--;
                    }
                }
                                    
                                
                //DEFINIMOS LA IMAGEN POR CARGAR.
                this.imagenActiva = 
                        this.imagenesPorCargar.get(this.contadorImagenActiva);
                System.out.println(
                        "[INFO]Imágen activa: " + this.imagenActiva.getName());
                try {
                    //LA COLOCAMOS EL EL PREVIO.
                    this.jxImagenView.setImage(this.imagenActiva);
                } catch (IOException ex) {
                    Suceso s3 = new Suceso();
                    s3.setClase(this);
                    s3.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
                    s3.setTextoAMostrar("[ERROR] ALGO PASO");
                    System.out.println(s3);
                    String a = "La imagen "+imagenActiva.getName()+" no se puede cargar. "
                                    + "\n Se eliminara de la lista.";
                    JOptionPane.showMessageDialog(this.formularioPadre,a);
                    System.out.println("[ERROR] " + a);
                    this.imagenesPorCargar.remove(this.imagenActiva);
                    siguienteAnterior(direccion);
                    Logger.getLogger(UtilidadesJXViewImage_.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            this.jLabelContador.setText(
                            "["+ (this.contadorImagenActiva+1)+"/"+this.imagenesPorCargar.size() + " ] - " + this.imagenActiva.getName() );
            
//            this.escalarImagen();
        }
    }
    
    
    
    private void comprobarVisibilidadDeImagenes(){
        System.out.println("[!]Comptrobando compatibilidad de imagenes.");
                
        for (File file : imagenesPorCargar) {
            //FILE SOLO LO UTILIZE PARA ITINERAR EN EL TOTAL DE IMAGENES.
            // PRECIO DE IMAGENES HACE EL RECORRIDO Y CARGA PARA VER SI SON 
            // COMPATIBLES.
            this.siguienteAnterior(true);
        }
    }
    
//    private void escalarImagen(){
//        System.out.println("[!] Escalando imagen.", this);
//        try {
//            BufferedImage imagen = ImageIO.read(this.imagenActiva);
//            System.out.println("        [-] Tamaño de imagen:" 
//                    + imagen.getHeight() +  "x" +imagen.getWidth(), this);
//            double vistaAltura = this.jxImagenView.getHeight();
//            double vistaAnchura = this.jxImagenView.getWidth();
//            
//            double imagenAlto = imagen.getHeight();
//            double imagenAncho = imagen.getWidth();
//            
//            double escala;
//            
//            if (imagenAlto>imagenAncho) {
//                escala = vistaAltura/imagenAlto;
//            } else {
//                escala = vistaAnchura/imagenAncho;
//            }
//            escala = escala;
//            this.jxImagenView.setScale(escala);
//        } catch (IOException ex) {
//            Logger.getLogger(UtilidadesJXViewImage_.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    public void eliminarImagenSeleccionada(){
        if(this.imagenActiva!= null ){
            int respuesta = 
                JOptionPane.showConfirmDialog(this.formularioPadre,
                "¿Estas seguro que quieres eliminar la imagen '"
                        +this.imagenActiva.getName()+"'", "¿Eliminar imágen?",
                                    JOptionPane.YES_NO_OPTION);
            if (respuesta==0) {       
                String a = "Se elimino la imagen "+this.imagenActiva.getName()+" de la lista.";
                this.imagenesPorCargar.remove(this.imagenActiva);
                if (this.imagenesPorCargar.size() == 0) {
                    reiniciar();
                } else {
                    this.seEliminoUltimaImagen = false;
                }
                this.siguienteAnterior(true);
                System.out.println("[!!] "+a);
                JOptionPane.showMessageDialog(this.formularioPadre, a );

            }else{
                JOptionPane.showMessageDialog(this.formularioPadre, "No se elimino la imágen.");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No hay imagenes por eliminar");
            reiniciar();
        }
    }
    
    private void reiniciar(){
        this.imagenesPorCargar.clear();
        this.seEliminoUltimaImagen = true;
        this.contadorImagenActiva = 0;
        
    }
    
    public boolean isEmpty(){
        return this.imagenesPorCargar.isEmpty();
    }

    /**
     * No soportada para este componente.
     */
    @Override
    @Deprecated
    public String getText() {
        throw new UnsupportedOperationException("No soportada para este componente."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * No soportada para este componente.
     */
    @Override
    @Deprecated
    public void setText(String txt) {
        throw new UnsupportedOperationException("No soportada para este componente."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setError() {
        this.setImagenViewError(this.jxImagenView);
    }
    
    public void setError(String mensajeDeError){
        this.setMensajeDeError(mensajeDeError);
        this.setError();
        this.mostrarError();
    }
    
    public void setErrorQuitar(){
        this.setImagenViewErrorRestaurar(this.jxImagenView);
    
    }
    
    /**
     * No soportada para este componente.
     */
    @Override
    @Deprecated
    public void setFocus() {
           throw new UnsupportedOperationException("No soportada para este componente.");
    }

    public List<File> getImagenesPorCargar() {
        return imagenesPorCargar;
    }

    @Override
    public void setEditable(boolean editable) {
        try {
            throw new ExcepcionPersonalizada("Todavia no esta soportado.", this, "setEditable");
        } catch (ExcepcionPersonalizada ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Asigna el factor de escala de la imagen para dar la sensación de zoom. 
     */
    private void zoom(){
        this.getThis().addMouseWheelListener(new MouseAdapter() {
            
            JXImageView jxi;
            Double factorEscala;
            MouseWheelListener parametros (JXImageView jxi){
                this.jxi = jxi;
                return this;
            }
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation()==-1) {
                    if (jxi.getScale()>1.5) {
                        factorEscala = 0.5;
                        jxi.setScale(jxi.getScale()-factorEscala);
                    }else{
                        factorEscala = 0.1;
                        jxi.setScale(jxi.getScale()-factorEscala);
                    }
                }else{
                    if (jxi.getScale()>1.5) {
                        factorEscala = 0.5;   
                        jxi.setScale(jxi.getScale()+factorEscala);
                    }else{
                        factorEscala = 0.1;
                        jxi.setScale(jxi.getScale()+factorEscala);
                    }
                }
                
                if (jxi.getScale()<0.1) {
                    jxi.setScale(0.1);
                }
            }
        }.parametros(this.getThis()));
    
    this.getThis().addMouseListener(new MouseAdapter() {
        
        JXImageView jxi;
        Point2D p;
        MouseAdapter parametros (JXImageView jxi){
            this.jxi = jxi;
            p = this.jxi.getImageLocation();
            return this;
        }
        @Override
        public void mouseClicked(MouseEvent e){
            if (e.getClickCount()==2) {
                if (this.jxi.getScale()>=6 || this.jxi.getScale()<1) {
                    this.jxi.setScale(1);
                    this.jxi.setImageLocation(p);
                }else if (this.jxi.getScale()<6 && this.jxi.getScale()>=1) {
                    this.jxi.setScale(6);}
//                }else if (this.jxi.getScale()>=6 && this.jxi.getScale()>=1) {
                
            }
        }
    
    }.parametros(this.getThis()));
    }
}
