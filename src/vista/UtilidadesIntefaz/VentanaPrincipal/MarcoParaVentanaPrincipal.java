package vista.UtilidadesIntefaz.VentanaPrincipal;

import controlador.Coordinador;
import controlador.CoordinadorPaneles;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.border.LineBorder;
import modelo.ExcepcionPersonalizada;
import vista.UtilidadesIntefaz.JPanelBase;
import vista.UtilidadesIntefaz.utilidadesOptimizadas.ColoresYFuentes;

/**
 * Esta clase crea un JFrame como base para las aplicaciones e incluye dentro de 
 * su construccion varios panles que ayudan a redimencionar, establecer una barra
 * 
 * 
 * @author Rafael Ángel Ramírez Estrada
 */


public class MarcoParaVentanaPrincipal extends JFrame{

    private static final long serialVersionUID = 1L;
    
    
    private Coordinador coordinador;
    
    /**
      * Fuentes 
      */

    private final Font fuenteMenu = ColoresYFuentes.FUENTE_MENU;
    private final Font fuenteItem = ColoresYFuentes.FUENTE_MENU_ITEM;
    private final Font fuenteFechaYHora = ColoresYFuentes.FUENTE_FECHA_Y_HORA;


     ///////////////////////
        



    //LA ACCION DE ACTUALIZACION QUE SE EJECUTARA SIEMPRE ANTES DE ABRIR UN PANEL
    // SIRVE PARA LOS MENUS E ITEMS QUE SE MODIFIQUEN FUERA DEL PANEL Y
    // QUE ES NECESARIO RECARGAR PERO QUE EN EL MOMENTO NO SE PUEDE Y POR
    // TANTO HAY QUE HACERLO CUANDO EL PANEL ESTE VISIBLE. 
    // ESTA VARIABLE SOLO GUARDA LA OPERACION QUE SE TIENE QUE DEFINIR. 
    // PARA DEFINIRLA HAY QUE USAR EL CONTROLADOR. 
    private Runnable operacionActualizacion;
   
    
    //ESTE EL JSCROLL PANE QUE PERMITE QUE AL REDIMECIONAR EL JFRAME ESTE TENGA
    // LAS BARRAS DE SCROLL. A ESTE ES EL QUE HAY QUE AGREGARLE LOS JPANEL QUE
    // DISEÑEMOS PERO CON SU RESPECTIVA OPERACION.
    private ScrollPane contenedorParaPaneles;
//    private JSplitPane contenedorParaPanelesSustituto;
    //El ménu para agregar las acciones. 
    private Menu menu;
    // LA BARRA DE TITULO DE LA VENTANA CON EL FONDO DE COLOR (DEPENDE DE CUAL)
    private BarraTitulo barraTitulo;
    
    
    //ACCION DE BOTON DE INICIO.
    // ESTE BOTON DEFINE LA ACCIÓN DE LA IMAGEN DE INICIO QUE SE
    // QUIERE REALIZAR AL HACER UN CLICK.
    private Runnable accionMenuInicio;
    
    
   
    /**
     * Incializa todos los parametros que requerimos para la crear la ventana que
     * contendra todos los elementos gráficos. Es la base de todo. 
     */
    public void init(){
     
       
        
        //EL TAMAÑO POR DEFECTO DE APERTURA DE LA VENTANA.
        // POR EL MOMENTO LO DEJAREMOS EN EL TAMAÑO DE LA RESOLUCIÓN 1440x900
        // QUE ES LA RESOLUCIÓN OBJETIVO PARA IMPLANTAR EN EL ALMACEN.
        
        //HAY QUE MODIFICAR LA RESOLUCÓN DESPUES PARA QUE SEA MAXIMIZADO.
        // DESCOMENTANDO LA SIGUIENTE LINEA.
        //Dimension medidasVentana = new Dimension(this.resolucion());
        
        // ESTA LINEA ES LA QUE HAY QUE QUITAR.
        Dimension medidasVentana = new Dimension(1440,900);
        //-----------------------------------------------------------
        
        //TAMAÑO MÍNIMO QUE TENDRA LA VENTANA AL REDIMENCIONARSE
        Dimension medidasVentanaMinimo = new Dimension(800, 600);
        //TAMAÑO MÁXIMO QUE TENDRA LA VENTANA AL REDIMENCIONARSE
        // (AL TAMAÑO DE LA PANTALLA)
        Dimension medidasVentanaMaximo = new Dimension(this.resolucion());
        
        
        //SETEAMOS EL TAMAÑO POR DEFECTO CON EL QUE INICIALIZARA. 
        this.setPreferredSize(medidasVentana);
        
        //ESTA CLASE ES LA QUE NOS PERMITE REDIMENCIONAR EL JFRAME.
        ComponentResizer cr = new ComponentResizer();
        //LAS MEDIDAS DEL COMPONENTE MÁXIMAS Y MÍNIMAS.
        cr.setMinimumSize(medidasVentanaMinimo);
        cr.setMaximumSize(medidasVentanaMaximo);
        cr.registerComponent(this);
        //LA CANTIDAD DE ESPACIO QUE TENEMOS QUE ARRASTRAR EL MOUSE PARA QUE 
        // EMPIEZE A REDIMENCIONAR. SE PUEDE VER TAMBIEN COMO EL BRINCO QUE DARA.
        // ENTRE MÁS ALTO SEA EL VALOR MÁS NOTORIO SERA EL SALTO. MIN = 1
        cr.setSnapSize(new Dimension(2, 2));
        
        /*------------------------------------------------------------
        INICIALIZAMOS TODOS LOS TIPOS DE CONTENEDORES QUE OCUPAMOS.
        ------------------------------------------------------------*/
        
        /* 
        ESTE PANEL ES EL CONTENEDOR DE TODOS. EN EL ESTA EL BORDE GRIS QUE
        PUSIMOS PARA ARRACTRAR LA VENTANA. 
        */
        PanelSuperContenedor panelSuperContenedor = new PanelSuperContenedor();
        /*
        CONTIENE LA BARRA DE TITULO Y EL MENU-FECHA-HORA-BOTONES DE CIERRE.
        */
        PanelEncabezado panelEncabezado = new PanelEncabezado(this);
        /*
         ESTE ES EL QUE HACE LA MAGIA DE CARGAR LOS DIFERENTES PANELES DENTRO
         DE TOODA LA ESTRUCTURA. DA LA POSIBILIDAD DE QUE EL PANEL QUE SE CARGUE
         SEA MAYOR QUE LA VENTANA Y QUE AL REDIMENCIONARSE O SER MÁS GRANDE EL 
         PANEL QUE LA SECCION DE VISUALIZCIÓN SE CREEN PANELES. LO HACEMOS GLOBAL
         PARA PODER CAMBIAR LOS PANELES DESDE UNA FUNCIÓN.
        */
        
        this.contenedorParaPaneles = new ScrollPane();
//        this.contenedorParaPanelesSustituto = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
//        this.contenedorParaPaneles.setViewportView(this.contenedorParaPaneles);
        /*
        LA BARRA DE MENUS. ESTA INCLUYE PROCEDIMIENTOS PARA CREAR MENUS E ITEM
        DE MANERA MÁS FÁCIL INVOCANDO LA OPERACION setMenu y setItem RESPECTIVAMENTE.
        */
        this.menu = new Menu();
        /*
        CREA LA BARRA DE TITULO DE LA VENTANA EN LA PARTE SUPERIOR Y LE ASIGNA
        SU NOMBRE. SI SE QUEIRE CAMBIAR SE PUEDE SETEAR CON LOS DEBIDOS PROCEDIMIENTOS.
        
        EL TITULO QUE SE LE ASIGNA AQUI ES QUE PREVALECERA DURANTE TODA LA APLICACIÓN.
        LOS PANELES QUE AGREGUEMOS SE AGRAGARAN AL LADO DE ESTE TITULO.
         */
        this.barraTitulo = new BarraTitulo("GESTION DE REFACCIONES");
        
        /*
        CREAMOS UN ICONO PARA LA BARRA.
        */
        URL imageURL;
        imageURL = this.getClass().getResource("/vista/imagenes/iconos_icono_principal.png");
        JLabel iconoEtiquetaPrincipal = new JLabel(new ImageIcon(imageURL));
        /**
         ASIGNAMOS LA ACCIÓN DE EJECUCIÓN DEL ICONO DE LA BARRA. 
         */
        this.accionMenuInicio = ()->this.getCoordinador().refaccionAbrirPanelConsultaRefacciones();
        iconoEtiquetaPrincipal.addMouseListener(new MouseAdapter() {
            
            Runnable r;
            public MouseAdapter parametros(Runnable r){
                this.r = r;
                return this;
            }
            @Override
            public void mouseClicked(MouseEvent e) {
                this.r.run();
                System.out.println("[+] Ejecutando accion de menú inicio.");
            }
        }.parametros(this.accionMenuInicio));
        
        /**
         CREAMOS EL PANEL QUE CONTIENE EL RELOJ, LA FECH Y LOS BOTONES DE INTERACCIÓN
         DE LA VENTANA.
         */
        RelojYBotonesDeCierre rybdc = new RelojYBotonesDeCierre(coordinador);
        
        /*
        ORDENAMOS LOS PANELES AGREGANDOLOS A SU RESPECTIVO PADRE. TENER CUIDADDO
        DE RESPETAR EL ÓRDEN QUE TIENEN PUESTO QUE AFECTA A LA ESTRUCUTRA. 
        */
        
        this.menu.add(iconoEtiquetaPrincipal);
        panelEncabezado.add(this.barraTitulo, BorderLayout.PAGE_START);
        panelEncabezado.add(this.menu, BorderLayout.SOUTH);
        panelSuperContenedor.add(panelEncabezado, BorderLayout.PAGE_START);
        panelSuperContenedor.add(this.contenedorParaPaneles);
        this.add(panelSuperContenedor);
        
//        /*------------------------------------------------------------
//            CREAMOS LOS MENUS DE LA BARRA DE MENUS
//            ===================
//            EJEMPLO DE CREACION
//            ===================
//            
//            COMENTAR ESTAS LINEAS CUANDO SE IMPLEMENTE EL SISTEMA.
//        ------------------------------------------------------------*/
//
//        MenuConstructor mArchivo = new MenuConstructor();
//        mArchivo.setMenu();
//        mArchivo.setNombre("Cambiar Modulos");
//        mArchivo.setImagen("imagenes/iconos_siguiente.png");
//        
//        MenuConstructor mArchivo1 = new MenuConstructor();
//        mArchivo1.setMenu();
//        mArchivo1.setNombre("otro menu");
//        mArchivo1.setImagen("imagenes/iconos_siguiente.png");
//        mArchivo1.setPadre(mArchivo);
//        
//        MenuConstructor p1 = new MenuConstructor();
//        p1.setItem();
//        p1.setNombre("Agregar Empresa");
//        p1.setPanel(this.coordinador.getFormulario());
//        p1.setImagen("imagenes/iconos_mas.png");
//        p1.setPadre(mArchivo);
//        
//        MenuConstructor p2 = new MenuConstructor();
//        p2.setItem();
//        p2.setNombre("Ventana Roja");
//        p2.setPanel(this.coordinador.getPanelPrimeraVentana());
//        p2.setImagen("imagenes/iconos_palomita.png");
//        p2.setPadre(mArchivo);
//        
//      
//        MenuConstructor p3 = new MenuConstructor();
//        p3.setItem();
//        p3.setNombre("Accion directa");
//        p3.setImagen("imagenes/iconos_icono_principal.png");
//        p3.setAccionDelItem(()->this.accion("accion directa"));
//        p3.setPadre(mArchivo1);
//        
//        //AÑADIMOS TODOS LOS MENUS.
//        this.addItemOMenu(mArchivo);
//        this.addItemOMenu(mArchivo1);
//        this.addItemOMenu(p1);
//        this.addItemOMenu(p2);
//        this.addItemOMenu(p3);



//        /*------------------------------------------------------------
//            NOMBRAMOS LOS PANELES CON VARIABLES ESTATICAS
//            PARA IDENTIFICARLOS Y LLAMARLOS POR FUERA. SOLO PANELES.
//        ------------------------------------------------------------*/
        
        //LA OPERACION GENERAL DE ACTUALIZACION
//        operacionActualizacion = ()->this.getCoordinador().ejecutarOperacionesParaActualizar();
        
        /**
         * /////////////////////////////////////////////////
         *      CREAMOS LOS MENUS
         * 
         *  LA INDENTACIÓN NOS AYUDA A SABER QUE LE PERTENECE A QUE. 
         * 
         * /////////////////////////////////////////////////
         */
        String imgMenus = "/vista/imagenes/iconos_siguiente.png";
        String imgRegistro = "/vista/imagenes/iconos_mas.png";
        String imgModificar = "/vista/imagenes/iconos_modificar.png";
        
        
        MenuConstructor menuConsultar = new MenuConstructor();
        menuConsultar.setMenu();
        menuConsultar.setNombre("Consultar");
        menuConsultar.setImagen(imgMenus);
        this.addItemOMenu(menuConsultar);
            
            MenuConstructor panelConsultaRefacciones = new MenuConstructor();
            panelConsultaRefacciones.setItem();
            panelConsultaRefacciones.setNombre(CoordinadorPaneles.PANEL_REFACCION_CONSULTAR);
            panelConsultaRefacciones.setPadre(menuConsultar);
            panelConsultaRefacciones.setAccionDelItem(
                    ()->this.getCoordinador().refaccionAbrirPanelConsultaRefacciones());
            this.addItemOMenu(panelConsultaRefacciones);
            
            MenuConstructor refaccionDetalle = new MenuConstructor();
            refaccionDetalle.setItem();
            refaccionDetalle.setNombre(CoordinadorPaneles.PANEL_REFACCION_DETALLE);
            refaccionDetalle.setPadre(menuConsultar);
            refaccionDetalle.setAccionDelItem(
                    ()->this.getCoordinador().refaccionAbrirDetalleRefaccion());
            this.addItemOMenu(refaccionDetalle);
        
        //MENU MODIFICAR DATOS. 
        MenuConstructor menuModificarDatos = new MenuConstructor();
        menuModificarDatos.setMenu();
        menuModificarDatos.setNombre("Modificar datos");
        menuModificarDatos.setImagen(imgMenus);
        this.addItemOMenu(menuModificarDatos);
        
            MenuConstructor menuRefaccion = new MenuConstructor();
            menuRefaccion.setMenu();
            menuRefaccion.setNombre("Refacciones");
            menuRefaccion.setImagen(imgMenus);
            menuRefaccion.setPadre(menuModificarDatos);
            this.addItemOMenu(menuRefaccion);
                
                MenuConstructor registroRefacciones = new MenuConstructor();
                registroRefacciones.setItem();
                registroRefacciones.setNombre(CoordinadorPaneles.PANEL_REGISTRAR_NUEVA_REFACCION);
                registroRefacciones.setPadre(menuRefaccion);
                registroRefacciones.setImagen(imgRegistro);
                registroRefacciones.setAccionDelItem(()->coordinador.refaccionAbrirPanelAgregar());
                this.addItemOMenu(registroRefacciones);

                MenuConstructor modificarRefaccion = new MenuConstructor();
                modificarRefaccion.setItem();
                modificarRefaccion.setNombre(CoordinadorPaneles.PANEL_MODIFICAR_REFACCION);
                modificarRefaccion.setPadre(menuRefaccion);
                modificarRefaccion.setImagen(imgModificar);
                modificarRefaccion.setAccionDelItem(()->coordinador.refaccionAbrirPanelModificar());
                this.addItemOMenu(modificarRefaccion);

            

            MenuConstructor menuEmpleados = new MenuConstructor();
            menuEmpleados.setMenu();
            menuEmpleados.setNombre("Empleados");
            menuEmpleados.setImagen(imgMenus);
            menuEmpleados.setPadre(menuModificarDatos);
            this.addItemOMenu(menuEmpleados);
            
                MenuConstructor dialogoEmpleadoAgregar = new MenuConstructor();
                dialogoEmpleadoAgregar.setItem();
                dialogoEmpleadoAgregar.setNombre(CoordinadorPaneles.PANEL_EMPLEADO_AGREGAR);
                dialogoEmpleadoAgregar.setPadre(menuEmpleados);
                dialogoEmpleadoAgregar.setImagen(imgRegistro);
                dialogoEmpleadoAgregar.setAccionDelItem(
                        ()->coordinador.empleadoAbrirDialogoAgregar());
                this.addItemOMenu(dialogoEmpleadoAgregar);
                
                MenuConstructor dialogoEmpleadoModificar = new MenuConstructor();
                dialogoEmpleadoModificar.setItem();
                dialogoEmpleadoModificar.setNombre(CoordinadorPaneles.PANEL_EMPLEADO_MODIFICAR);
                dialogoEmpleadoModificar.setPadre(menuEmpleados);
                dialogoEmpleadoModificar.setImagen(imgModificar);
                dialogoEmpleadoModificar.setAccionDelItem(
                        ()->this.getCoordinador().empleadoAbrirDialogoModificar());
                this.addItemOMenu(dialogoEmpleadoModificar);
        
            MenuConstructor menuMaquina = new MenuConstructor();
            menuMaquina.setMenu();
            menuMaquina.setNombre("Maquinas");
            menuMaquina.setPadre(menuModificarDatos);
            menuMaquina.setImagen(imgMenus);
            this.addItemOMenu(menuMaquina);

                MenuConstructor dialogoMaquinaModeloAgregar = new MenuConstructor();
                dialogoMaquinaModeloAgregar.setItem();
                dialogoMaquinaModeloAgregar.setNombre(CoordinadorPaneles.PANEL_MAQUINA_MODELO_AGREGAR);
                dialogoMaquinaModeloAgregar.setPadre(menuMaquina);
                dialogoMaquinaModeloAgregar.setImagen(imgRegistro);
                dialogoMaquinaModeloAgregar.setAccionDelItem(
                        ()->this.getCoordinador().maquinaModeloAbrirDialogoAgregar());
                this.addItemOMenu(dialogoMaquinaModeloAgregar);

                MenuConstructor dialogoModificarMaquinaModelo = new MenuConstructor();
                dialogoModificarMaquinaModelo.setItem();
                dialogoModificarMaquinaModelo.setNombre(CoordinadorPaneles.PANEL_MAQUINA_MODELO_MODIFICAR);
                dialogoModificarMaquinaModelo.setPadre(menuMaquina);
                dialogoModificarMaquinaModelo.setImagen(imgModificar);
                dialogoModificarMaquinaModelo.setAccionDelItem(
                        ()->this.getCoordinador().maquinaModeloAbrirDialogoModificar());
                this.addItemOMenu(dialogoModificarMaquinaModelo);

                
                MenuConstructor dialogoAsignarNúmeroAMaquina = new MenuConstructor();
                dialogoAsignarNúmeroAMaquina.setItem();
                dialogoAsignarNúmeroAMaquina.setNombre("NOMBRE DEL PANEL ESTA PENDIENTE|||||||||");
                dialogoAsignarNúmeroAMaquina.setPadre(menuMaquina);
                dialogoAsignarNúmeroAMaquina.setImagen(imgModificar);
                dialogoAsignarNúmeroAMaquina.setAccionDelItem(
                        ()->JOptionPane.showMessageDialog(null, "accion pendiente!"));
                this.addItemOMenu(dialogoAsignarNúmeroAMaquina);
                
                
                
                
            MenuConstructor menuProveedor = new MenuConstructor();
            menuProveedor.setMenu();
            menuProveedor.setNombre("Proveedores");
            menuProveedor.setPadre(menuModificarDatos);
            menuProveedor.setImagen(imgMenus);
            this.addItemOMenu(menuProveedor);
            
                MenuConstructor dialogoProveedorRegistrar = new MenuConstructor();
                dialogoProveedorRegistrar.setItem();
                dialogoProveedorRegistrar.setNombre(CoordinadorPaneles.PANEL_PROVEEDOR_REGISTRAR);
                dialogoProveedorRegistrar.setImagen(imgRegistro);
                dialogoProveedorRegistrar.setPadre(menuProveedor);
                dialogoProveedorRegistrar.setAccionDelItem(
                        ()->this.getCoordinador().proveedorAbrirDialogoGuardarNuevo());
                this.addItemOMenu(dialogoProveedorRegistrar);
                
                MenuConstructor dialogoProveedorModificar = new MenuConstructor();
                dialogoProveedorModificar.setItem();
                dialogoProveedorModificar.setNombre(CoordinadorPaneles.PANEL_PROVEEDOR_MODIFICAR);
                dialogoProveedorModificar.setPadre(menuProveedor);
                dialogoProveedorModificar.setImagen(imgModificar);
                dialogoProveedorModificar.setAccionDelItem(
                        ()->this.getCoordinador().proveedoresAbrirDialogoModificar());
                this.addItemOMenu(dialogoProveedorModificar);
        
        MenuConstructor menuEntradasSalidas = new MenuConstructor();
        menuEntradasSalidas.setMenu();
        menuEntradasSalidas.setNombre("Entradas/Salidas");
        menuEntradasSalidas.setImagen(imgMenus);
        this.addItemOMenu(menuEntradasSalidas);
        
            MenuConstructor menuLotes = new MenuConstructor();
            menuLotes.setMenu();
            menuLotes.setNombre("Lotes");
            menuLotes.setPadre(menuEntradasSalidas);
            menuLotes.setImagen(imgMenus);
            this.addItemOMenu(menuLotes);
            
                MenuConstructor dialogoEntradaLote = new MenuConstructor();
                dialogoEntradaLote.setItem();
                dialogoEntradaLote.setNombre(CoordinadorPaneles.PANEL_ENTRADA_LOTE);
                dialogoEntradaLote.setPadre(menuLotes);
                dialogoEntradaLote.setAccionDelItem(
                        ()->this.getCoordinador().entradaLoteAbrirDialogo());
                KeyStroke atajo_CtrlE = javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK);
                dialogoEntradaLote.setAtajoDeTeclado(atajo_CtrlE);
                this.addItemOMenu(dialogoEntradaLote);
                
                MenuConstructor dialogoSalidaLote = new MenuConstructor();
                dialogoSalidaLote.setItem();
                dialogoSalidaLote.setNombre(CoordinadorPaneles.PANEL_SALIDA_LOTE);
                dialogoSalidaLote.setPadre(menuLotes);
                dialogoSalidaLote.setAccionDelItem(
                        ()->this.getCoordinador().salidaLoteAbrirDialogo());
                KeyStroke atajo_CtrlS = javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK);
                dialogoSalidaLote.setAtajoDeTeclado(atajo_CtrlS);
                this.addItemOMenu(dialogoSalidaLote);
        
        
            MenuConstructor menuEntradas = new MenuConstructor();
            menuEntradas.setMenu();
            menuEntradas.setNombre("Entradas");
            menuEntradas.setPadre(menuEntradasSalidas);
            menuEntradas.setImagen(imgMenus);
            this.addItemOMenu(menuEntradas);

            MenuConstructor menuSalidas = new MenuConstructor();
            menuSalidas.setMenu();
            menuSalidas.setNombre("Salidas");
            menuSalidas.setPadre(menuEntradasSalidas);
            menuSalidas.setImagen(imgMenus);
            this.addItemOMenu(menuSalidas);
        
        MenuConstructor menuSystema = new MenuConstructor();
        menuSystema.setMenu();
        menuSystema.setNombre("Opciones de Sistema");
        menuSystema.setImagen(imgMenus);
        this.addItemOMenu(menuSystema);
        
            MenuConstructor salirSystema = new MenuConstructor();
            salirSystema.setItem();
            salirSystema.setNombre("Salir");
            salirSystema.setPadre(menuSystema);
            salirSystema.setAccionDelItem(
                    ()->coordinador.salirDelSistema());
            KeyStroke atajo_Salir = javax.swing.KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK);
            salirSystema.setAtajoDeTeclado(atajo_Salir);
            this.addItemOMenu(salirSystema);

        
        //AÑADIMOS LOS DIALOGOS.
       
        
        //GENERAMOS EL MENU.
        this.generarMenus();
        
        //ASIGNAMOS EL PANEL QUE ABRIRA POR DEFECTO
        this.getCoordinador().refaccionAbrirPanelConsultaRefacciones();
        
        /*
        ------------------------------------------------------------
            CREAMOS LOS MENUS DE LA BARRA DE MENUS
            ===============================
            FIN DE LOS EJEMPLOS DE CREACION
            ===============================
        ------------------------------------------------------------
        */
        
        /**
         ASIGNAMOS LA VENTANA PRINCIPAL AL PANEL DE BOTONES, RELOJ Y FECHA PARA 
         * QUE LOS BOTONES INTERECTUEN CON ELLA. SI NO LO HACEMOS NOS MANDARA
         * ERROR DE NULL POINTER EXCEPTION. 
         */
        rybdc.setVentanaPrincipal(this);
        //ASIGMAMOS LOS BOTONES. IMPORTANTE POR QUE SI NO NO FUNCIONAN. 
        rybdc.asignarAcciones();
        //AÑADIMOS EL PANEL AL MENU.
        this.menu.add(rybdc);

        /*------------------------------------------------------------
            CONFIGURACIONES BÁSICAS PARA EL JFRAME. 
        ------------------------------------------------------------*/
        this.dispose();
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
       
        /*
        NECESITAMOS EMPACAR PARA QUE TODOS LOS CAMBIOS EN LOS PANELES FUNCIONEN.
        */
        this.pack();
        this.setLocationRelativeTo(null);
        //ESTA LINEA HACE QUE SE TERMINE COMPLETAMENTE LA EJECUCIÓN CUANDO
        // SE CIERRA LA VENTANA DESDE LA BARRA. 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    
    /**
     * SOLO PARA EL EJEMPLO DE LOS MENUS. NO BORRAR
     */
    private void accion(String texto){
        JOptionPane.showMessageDialog(null, texto);
    
    }
    
    /**
     * Setea el panel que se le pase como parametro en la ventana principal.
     * Es necesario llamar a las variables estáticas de MarcoParaVentana para 
     * definirlo. Si se crea un panel nuevo hay que crear tambian su variable
     * estática. Hay que tener cuidado con los nombres puesto que tambien busca
     * dentro de los items. 
     * @param panel El nombre del panel que tiene que ser dato por una variable
     * estática para mantener el órden.
     */
    public void setJPanel(JPanelBase panel){

//        this.contenedorParaPanelesSustituto.add(panel);
        this.contenedorParaPaneles.setViewportView(panel);
    }
    
    /**
     * El coordinador del sistema.  
     * @return El jefe de jefes, señores!
     */
    public Coordinador getCoordinador() {
        return coordinador;
    }
    
    /**
     *Setea al coordinador del sistema.  
     * @param coordinador El jefe de jefes, señores!
     */
    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
    /**
     * Retorna la resolucion actual de la pantalla. 
     * @return  La resolución de la pantalla. 
     */
    public Dimension resolucion(){
        return Toolkit.getDefaultToolkit().getScreenSize();
    }

   
    
            
    /**
     * Crea la barra de titulo con color que se muestra a en la parte superior
     * de la ventana.
     */
    class BarraTitulo extends JPanel{
        
        private String titulo;
        private String tituloPrincipal;
        JLabel etiqueta;
       
        public BarraTitulo(String titulo) {
            //CREAMOS LA ETIQUETA PARA EL TITULO.
            etiqueta = new JLabel(this.getTitulo());
            //COLOR DE LA LETRA.
            etiqueta.setForeground(Color.WHITE);
            //AL CONSTRUIR SETEAMOS EL TITULO.
            tituloPrincipal = titulo;
            setTitulo("");
            //AÑADIMOS LA ETIQUETA AL PANEL.
            setLayout(new GridLayout());
            
            add(etiqueta);
            
            setPreferredSize(new Dimension(this.getWidth(), 16));
            //LE DAMOS EL COLORCITO AZUL
            setBackground(new Color(0,158,227));
        }
        /*
        * El título que llevara la ventana. 
        */
        public String getTitulo() {
            return "  "+titulo;
        }

        public void setTitulo(String titulo) {
            this.etiqueta.setText("    "+this.tituloPrincipal+" / "+titulo);
            this.titulo = titulo;
        }
    }
    
    class Menu extends JMenuBar{
        List<ElementoItemOMenu> elementoItemOMenuLista = new ArrayList<ElementoItemOMenu>();

        /**
         * Creamos los items que necesitemos y los guardamos para despues 
         * asignarlos con generarMenu(). 
         * 
         * @param padre El menu padre del elemento.
         * @param nombre El nombre de la etiqueta.
         * @param accion La accion que va a ejecutar. 
         * @param imagen Icono que se mostrara al lado del item o menu.
         * @see this.setMenu()
         */
        public void setItem(String padre, String nombre, Runnable accion, String imagen, KeyStroke atajoTeclado){
        
            try {
                if (accion == null) {
                    throw new ExcepcionPersonalizada("No definiste la accion.", this, "setItem");
                }else if(nombre == null){
                    throw new ExcepcionPersonalizada("No definiste un nombre para el item.", this, "setItem");
                }
                
                this.agregarMenuEItem(padre, nombre, accion, imagen, atajoTeclado);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Creamos los menus que necesitemos y los guardamos para despues 
         * asignarlos con generarMenu().
         * 
         * @param padre El menu padre del elemento. Si es raíz se deja en null
         * @param nombre El nombre de la etiqueta.
         * @param imagen Icono que se mostrara al lado del item o menu.
         * @sett this.setItem()
         */
        
        public void setMenu(String padre, String nombre, String imagen){
            //NO SE PUEDE CREAR UN MENU SIN SU NOMBRE. ES LO QUE LO IDENTIFICA
            try {
                if(nombre == null){
                    throw new ExcepcionPersonalizada("No definiste un nombre para el menu.", this, "setMenu");
                }
               
                this.agregarMenuEItem(padre, nombre, null, imagen, null);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /**
         * Creamos los menus y los items que necesitemos y los guardamos dentro 
         * de la lista elementoItemIMenuLista para despues asignarlos con generarMenu().
         * 
         * @param padre El menu padre del elemento. Poner null si es raiz.
         * @param nombre El nombre de la etiqueta.
         * @param accion La accion que va a ejecutar. 
         * @param imagen Icono que se mostrara al lado del item o menu.
         * 
         */
        private void agregarMenuEItem(String padre, String nombre, Runnable accion, String imagen, KeyStroke atajoDeTeclado){
            //CONTENEDOR DE TODOS LOS ELEMENTOS DEL MENU
            ElementoItemOMenu elemento = new ElementoItemOMenu();
            
            //CREAMOS LA URL PARA GUARDAR LA IMAGEN. SI SE PONE EN NULL ENTONCES
            // CREAMOS UNA NUEVA URL VACIA PARA QUE NO HAYA ERRORES.
            URL imageURL;
            if (imagen !=null) {
                imageURL = this.getClass().getResource(imagen);
            }else{
                imageURL = this.getClass().getResource("");
            }
            //OBJETO PARA CARGAR EN EL MENU O ITEM LA IMAGEN.
            ImageIcon image = new ImageIcon(imageURL);
            
            //SI NO HAY ACCIONES DEFINIDAS QUIERE DECIR QUE ES UN MENU.
            if (accion == null) {
                //CREAMOS UN OBJETO TIPO JMenu.
                JMenu menu = new JMenu(nombre);
                //ASIGNAMOS LA FUENTE
                menu.setFont(fuenteMenu);
                //ASIGNAMOS LA IMAGEN AL MENU.
                menu.setIcon(image);
                //ASIGNAMOS COLOR.
//                menu.setBackground(Color.red);
                //SETEAMOS EL MENU DENTRO DEL ELEMENTO CONTENEDOR GENERALIZANTE.
                elemento.setMenu(menu);
            }else{
                //DADO QUE SI SE DEFINIO UNA ACCIÓN SUPONEMOS QUE ES UN ITEM Y 
                // UN OBJETO JMenuItem.
                JMenuItem item = new JMenuItem(nombre);
                //ASIGNAMOS LA FUENTE.
                item.setFont(fuenteItem);
                //ASIGAMOS LA IMAGEN QUE LO ACOMPAÑARA.
                item.setIcon( image);
                //SETEAMOS EL COLOR.
                item.setBackground(ColoresYFuentes.TEMA_FONDO_OSCURO);
                //AÑADIMOS LA ACCION QUE QUEREMOS QUE EJECUTE EL ITEM.
                // SOLO EN mousePressed.
                item.addActionListener(new java.awt.event.ActionListener(){
                    //LA ACCION
                    Runnable accion;
                    Runnable aPerpetua;
                    //EL PROCEDIMIENTO PARA PASAR A LA FUNCION ANOMINA EL PARAMETRO
                    // DESEADO.
                    public ActionListener parametros(Runnable accion, Runnable a){
                        this.accion = accion;
//                        this.aPerpetua = a;
                        return this;
                    }
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        this.accion.run();
//                        this.aPerpetua.run();
                        
                    }

                }.parametros(accion, operacionActualizacion));
                
                //SI HAY UN keyStroke!= null ENTONCES GENERAMOS SE LO AÑADIMOS AL ITEM.
                if (atajoDeTeclado!=null) {
                    item.setAccelerator(atajoDeTeclado);
                }
                
                //AÑADIMOS EL ITEM AL ELEMENTO GENRALIZANTE. 
                
                elemento.setItem(item);
            }
            //EL NOMBRE DEL ELEMENTO QUE SE MOSTRARA.
            elemento.setNombre(nombre);
            //EL NOMBRE DEL PADRE PARA SABER A QUE MENU PERTENECE.
            elemento.setPadre(padre);
            
            //AÑADIMOS EL ELEMENTO QUE GUARDA EL ITEM O MENU A LA LISTA PARA 
            // DESPUES GENERARLOS CON generarMenu();
            this.elementoItemOMenuLista.add(elemento);
        }
        
        /**
         * Genera el menu despues de que se cargaron los elementos que contendra
         * con agregarMenu()
         */
        public void generarMenu(){
            //SI LA LISTA ESTA VACIA MOSTRAMOS ERROR.
            if (elementoItemOMenuLista.isEmpty()) {
                try {
                    throw new ExcepcionPersonalizada(
                            "No has definido ningún elemento"
                          + " para el menu.", this, "generarMenu");
                } catch (ExcepcionPersonalizada ex) {
                    Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //CREO QUE ESTA PARTE ES SEMI RECURSIVA. LLAMAMOS A LA FUNCION menusContinuos
            // CADA VES QUE TENEMOS UN ELEMENTO RAÍZ Y ESTA LLAMA A menusContinuos
            // QUE REVISA PARA CADA ELEMENTO DE LA LISTA SI EXISTE UN HIJO Y 
            // LO ASIGNA. 
            for (ElementoItemOMenu elementoItemOMenu : elementoItemOMenuLista) {
                //SI EL ELEMENTO QUE ESTAMOS REVISANDO NO TIENE PADRE QUIERE 
                // DECIR QUE VA EN LA RAÍZ. SI ES UN MENU SE CREA MENU, SI ES 
                // UN ITEM SE CREA UN ITEM! xp
                if (elementoItemOMenu.getPadre() == null) {
                    //SI NO ES MENU QUIERE DECIR QUE ES ITEM
                    if (elementoItemOMenu.menu != null) {
                        this.add(elementoItemOMenu.getMenu());
                    }else{
                        this.add(elementoItemOMenu.getItem());
                    }
                }
                //LLAMAMOS A LA FUNCION menusContinuos PARA COMPROBAR TODOS
                // LOS HIJOS QUE TIENE EL elementoItemMenu QUE EXTRAJIMOS DE
                // LA LISTA.
                this.menusContinuos(elementoItemOMenu);
            }
        }
    
        private void menusContinuos(ElementoItemOMenu elementoAComparar){
            // REVISA TODOS LOS ELEMENTOS QUE AÑADIMOS PARA CREAR LOS SUB MENUS.
            for (ElementoItemOMenu subEIM : elementoItemOMenuLista) {
                /*
                SI EL NOMBRE DEL ELEMENTO QUE LE PASAMOS A ESTA FUNCION 
                ES IGUAL A ALGUNO DE LOS ELEMENTOS QUE TENEMOS EN LA LISTA DE
                ITEMS O MENUS SIGNIFICA QUE subEIM ES HIJO de elementoAComparar.
                */
                if (elementoAComparar.getNombre().equals(subEIM.getPadre())) {
                    //SI subEIM TIENE ITEM CREADO SE TOMA SU ITEM Y SE AGREGA
                    // COMO HIJO DEL elementoAComparar.
                    if (subEIM.getItem() != null) {
                        elementoAComparar.getMenu().add(subEIM.getItem());
                    }
                    // SI EL ELEMENTO ES UN MENU ENTONCES SE AGREGA COMO MENU
                    //HIJO DE elementoAcomparar.
                    if (subEIM.getMenu() != null) {
                        elementoAComparar.getMenu().add(subEIM.getMenu());
                    }
                }
            }
        }
        
        /**
         * Crea un objeto item o menu para despues utilizarlo. 
         * No hay mucho que explicar.
         */
        private class ElementoItemOMenu{
            
            private JMenuItem item;
            private JMenu menu;
            private String padre;
            private String nombre;

            public String getNombre() {
                return nombre;
            }

            public void setNombre(String nombre) {
                this.nombre = nombre;
            }

            public JMenuItem getItem() {
                return item;
            }

            public void setItem(JMenuItem item) {
                this.item = item;
            }

            public JMenu getMenu() {
                return menu;
            }

            public void setMenu(JMenu menu) {
                this.menu = menu;
            }

            public String getPadre() {
                return padre;
            }

            public void setPadre(String padre) {
                this.padre = padre;
            }
        
        }
        
    }
    
    /***
     * Creamos los botones y las opciones para la fecha y configuraciones
     * del menu de la ventana incluyendo las acciones que tomaran los botones
     * de minimizar. 
     */
    class RelojYBotonesDeCierre extends JPanel{

        private final JButton cerrarBtn;
        private final JButton minimizarBtn;
        private final JButton maximizarBtn;
        private final Coordinador coordinador;

        private JFrame ventanaPrincipal;

        public RelojYBotonesDeCierre(Coordinador coordinador) {

            this.coordinador = coordinador;
            //EL PANEL QUE CONTENDRA EL RELOJ.
            JPanel reloj = new JPanel();

            //EL PANEL QUE CONTENDRA LOS BOTONES DE CIERRE Y APERTURA.
            JPanel botones = new JPanel();

            //LLAMAMOS A LA CLASE FECHA Y HORA Y LAS AGREGAMOS A SUS PANELES.
            HiloParaFechaYHoraCabecera fechaHora = new HiloParaFechaYHoraCabecera();
            JLabel hora = new JLabel();
            JLabel fecha = new JLabel();
            JLabel relleno= new JLabel("→");

            fechaHora.setEtiquetaHora(hora);
            fechaHora.setEtiquetaFecha(fecha);
            relleno.setFont(fuenteFechaYHora);
            hora.setFont(fuenteFechaYHora);
            fecha.setFont(fuenteFechaYHora);

            reloj.add(fecha);
            reloj.add(relleno);
            reloj.add(hora);

            //CREAMOS LOS BOTONES QUE LLEVARAN PARA CIEERE
            this.cerrarBtn = new JButton("X");
            this.minimizarBtn = new JButton("_");
            this.maximizarBtn = new JButton("█");
            
            //NO FOCUSABLES
            this.cerrarBtn.setFocusable(false);
            this.minimizarBtn.setFocusable(false);
            this.maximizarBtn.setFocusable(false);
            
            
            //FUENTE
            Font fuenteBotones = new Font("Arial", 0, 7);
            this.cerrarBtn.setFont(fuenteBotones);
            this.minimizarBtn.setFont(fuenteBotones);
            this.maximizarBtn.setFont(fuenteBotones);
            
            //AGREGAMOS AL JPANEL BOTONES LOS BOTONES.
            botones.add(minimizarBtn);
            botones.add(maximizarBtn);
            botones.add(cerrarBtn);
            
            //LOS LAYOUT PARA DAR ORDEN
            this.setLayout(new FlowLayout(FlowLayout.RIGHT));
            reloj.setLayout(new FlowLayout(FlowLayout.RIGHT));
            botones.setLayout(new FlowLayout(FlowLayout.RIGHT));
            
            //MEDIDAS DE LOS PANELES. 
            Dimension relojDim = new Dimension(450, 35);
            reloj.setPreferredSize(relojDim);
            reloj.setMinimumSize(relojDim);
            reloj.setMaximumSize(relojDim);
            reloj.setAutoscrolls(true);

            Dimension btnDimencion = new Dimension(120, 35);
            botones.setPreferredSize(btnDimencion);
            botones.setMinimumSize(btnDimencion);
            botones.setMaximumSize(btnDimencion);

            //AGREGAMOS LOS PANELES AL PANEL QUE LOS VA A CONTENER.
            this.add(reloj);
            this.add(botones);

        }
        
        public JFrame getVentanaPrincipal() {
            return ventanaPrincipal;
        }

        
        /**
         * Seteamos la ventana principal para fines de acomdoo. 
         */
        public void setVentanaPrincipal(JFrame ventanaPrincipal) {
            this.ventanaPrincipal = ventanaPrincipal;
        }
        
        /**
         * La acción que se ejecutara al minimizar.  
         */
        private void minimizar(){
            try {
                if(this.ventanaPrincipal ==null){
                        throw new ExcepcionPersonalizada("No has seteado la ventana principal", this, "minimizar");
                }
      
                this.ventanaPrincipal.setExtendedState(ICONIFIED);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        /*
        PARA MAXIMIZAR Y MINIMIZAR ES NECEARIO GUARDAR EL TAMAÑO DE LA VENTANA
        ANTES DE EJECUTAR LA ACCIÓN. EN ESTE CASO SOLO A LA HORA DE MAXIMIZAR. 
        
        LA VARIABLE tamanoantesDeMaximizar SE ENCARGA DE ALMACENAR EL TAMAÑO
        QUE TENIA LA VENTANA ANTES DE MAXIMIZARSE PARA LUEGO RECUPERARLO AL MAXI-
        MIZARSE.
        
        estaMaximzado ES PARA SABER EL ESTADO DE LA VENTANA Y EN CASO DE QUE
        SE DESMAXIMIZE RETORNE AL TAMAÑO QUE ORIGINALMENTE TENIA.
        
        TAMBIEN ES NESARIO QUE posicion SE GUARDE PARA QUE NO SE MUEVA LA VENTANA
        A LA EZQUINA SUPERIOR IZQUIERDA CADA VEZ. 
        
        */
        Dimension tamanoAntesDeMaximizar;
        Point posicion;
        boolean estaMaximizado = false;
        private void maximizar(){
            try {
                //NECESARIA LA VENTANA PRINCIPAL SETEADA PARA QUE FUNCIONE.
                if(this.ventanaPrincipal ==null){
                        throw new ExcepcionPersonalizada("No has seteado la ventana principal", this, "maximizar");
                }
                //EN CASO DE QUE ESTE MAXIMIZADO EJECUTEMOS LO SIGUIEINTE. 
                if (this.estaMaximizado) {
                    this.ventanaPrincipal.setSize(tamanoAntesDeMaximizar);
                    this.ventanaPrincipal.setLocation(posicion);
                    this.estaMaximizado = false;
                }else{
                    //SI NO ESTA MAXIMIZADO GUARDAMOS LOS DATOS NECESARIOS.
                    this.tamanoAntesDeMaximizar = new Dimension(this.ventanaPrincipal.getSize());
                    this.posicion = new Point(this.ventanaPrincipal.getLocationOnScreen());
                    this.ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    this.estaMaximizado = true;
                }
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
            
        /*
        ESTA NO TIENE MUCHO CHISTE, PERO SI SE QUIERE DEFINIR ALGÚNA ACCIÓN
        ANTES DE CERRAR CERÁ AQUI.
        */
        private void cerrar(){
            this.coordinador.salirDelSistema();
        }

        /**
         * Asigna las acciones para los botones de interacción de la ventana
         * que previamente fueron seteados. Sin este las acciones sobre los botones
         * no existen.
         * 
         */
        public void asignarAcciones(){
            this.asignarAccionABoton(this.minimizarBtn, ()->this.minimizar());
            this.asignarAccionABoton(this.maximizarBtn, ()->this.maximizar());
//            this.asignarAccionABoton(this.encimaBtn, ()->this.encima());
            this.asignarAccionABoton(this.cerrarBtn, ()->this.cerrar());
        }
        
        /**
         * Esta función asigna las operaciones correpondientes a cada boton 
         * de control de la ventana.
         */
        private void asignarAccionABoton(Component componente, Runnable accion){
            componente.addMouseListener(new MouseAdapter() {
                
                Runnable accion;
                MouseListener parametros(Runnable accion){
                    this.accion = accion;
                    return this;
                }
                
                @Override
                public void mousePressed(MouseEvent e) {
                    this.accion.run();
                }
            }.parametros(accion));
        }
    }


        
    //NO SE POR QUE CREE ESTO AQUI PERO DEFINE LO QUE PERMITE DARLE LAS BARRAS
    // A LA VENTNA PRINCIPAL. SI SE REQUIERE UNA MODIFICACIÓN MEJOR SERÍA QUE 
    // SE HIZIERA AQUI.
    class ScrollPane extends JScrollPane{

        public ScrollPane() {
            //PERMITE QUE SE MUESTREN LAS BARRAS DE SCROLL.
            setAutoscrolls(true);
        }
    }
    
    /**
     * Esta subclase crea un panel que contendra a todos los demas paneles.
   
     */
    class PanelContenedor extends JPanel {
    
    }

    /**
     * Es el contenedor que del panel de fecha, hora, menus y botones. Aqui estan
     * definidas las funciones para arrastrar la ventana. 
     */
    class PanelEncabezado extends JPanel {
        
        //LAS CORRDENADAS PARA EL ARRASTRE
        int pX, pY;

        public PanelEncabezado(JFrame ventanaPrincipal) {
            /*
            PERMITE EL ACOMODO HACIA NORTE, SUR, ESTE Y OESTE PARA QUE APAREZCAN
            ORDENADOS LAS DOS SUB BARRAS. LA DE TITULO Y LA QUE CONTIENE MENUS, 
            BOTONES Y FECHA Y HORA. 
            */
            BorderLayout gl = new BorderLayout();
            setLayout(gl);

            //AÑADE LA ESCUCHA PARA ARRASTRAR LA VENTANA 
            addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent me) {
                    //GUARDA LA POSICION ACTUAL AL PRESIONAR EL MOUSE.
                    pX = me.getX();
                    pY = me.getY();

                }
               
                
                               
            });
                //SUMA O RESTA LA EL MOVIMIENTO DEL MOUSE A LA POSICIÓN ACTUAL 
                //DE LA VENTANA.
            addMouseMotionListener(new MouseMotionAdapter() {
                public void mouseDragged(MouseEvent me) {

                    ventanaPrincipal.setLocation(
                            ventanaPrincipal.getLocation().x + me.getX() - pX,
                            ventanaPrincipal.getLocation().y + me.getY() - pY);
                }
            });
        }
    }

    /**
     * Es el panel principal que acomoda a todos los demas de manera que 
     * tengamos la posiblidad de arrastrar por los cuatro bordes.
     * 
     * El borde y color que tienen la ventana aqui se definen.
     */
    class PanelSuperContenedor extends JPanel {

        public PanelSuperContenedor() {
            setLayout(new BorderLayout());
            setBorder(new LineBorder(new Color(70,70,70), 5, false));
        }
    }
    
    /*
    LISTA QUE CONTROLA LOS PANELES PARA ACCEDER A LA CLASE menuConstructor.
    */
    
    List<MenuConstructor> menuConstructorLista = new ArrayList<>();

    public List<MenuConstructor> getMenuConstructorLista() {
        return menuConstructorLista;
    }

    public void setMenuConstructorLista(List<MenuConstructor> menuConstructorLista) {
        this.menuConstructorLista = menuConstructorLista;
    }
    
        
    
    /**
     * Agrega el menuConstructor lista que se debe definir dentro del Jpanel
     * para que se agregue al menu. Una vez que se allan agregado los menús
     * es necesario ejecutar generarMenus() para que se creen los menus. 
     * @param itemOMenu El elemento MenuConstructor que se va a agregar. 
     * @see MenuConstructor
     */
    public void addItemOMenu (MenuConstructor itemOMenu){
        this.menuConstructorLista.add(itemOMenu);
    }
    
        
    /**
     * Genera los menus para que se muestren en el JFrame.  
     */
    public void generarMenus(){
        
        if (menuConstructorLista.isEmpty()) {
            try {
                throw new ExcepcionPersonalizada(
                        "La lista de elementos del menu esta vacia!"
                      + "\n Parece que olvidaste agregar los elementos.", this, "generarMenus");
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(MarcoParaVentanaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //ITINERAMOS SOBRE CADA ELEMENTO QUE AGREGAMOS A LA LISTA menuConstructorLista
        for (MenuConstructor menuConstructor : menuConstructorLista) {
            
            //CREAMOS LOS MENUS
            if (menuConstructor.isMenu()) {
                this.menu.setMenu(menuConstructor.getPadre(),
                        menuConstructor.getNombre(), 
                        menuConstructor.getImagen());
                
            }
            //CREAMOS LOS ITEMS
            if (menuConstructor.isItem()) {
                
                this.menu.setItem(
                        menuConstructor.getPadre(), 
                        menuConstructor.getNombre(), 
                        /*
                        EN ESTE CASO LA ACCIÓN ESTA DEFINIDA Y POR TANTO 
                        LA ASIGAMOS AL ITEM PARA QUE LA EJECUTE DIRECTAMENTE.

                        AQUI YA NO OCUPAMOS EL LAMBDA POR QUE LO HACEMOS 
                        DESDE LA CLASE MenuConstructor.
                        */
                        menuConstructor.getAccionDelItem(), 
                        /*
                        LA FUNCION DENTRO DE LA INSTANCIA DE MENU SABE QUE 
                        HACER CUANDO LA IMAGEN QUE LE PASAMOS ESTA EN NULL.
                        */
                        menuConstructor.getImagen(),
                        /*
                        AQUI VA UN COMENTARIO INTELIGENTE, PERO COMO NO SE
                        QUE PONER VOYA DECIR QUE ESTE ES EL ATAJO DE TECLADO.
                        */
                        menuConstructor.getAtajoDeTeclado());
            }
        }
        
        /*
        ESTA LINEA ES DE VITAL IMPORTANCIA PARA QUE SE CONSTRUYAN LOS MENUS DENTRO
        DE LA BARRA, SI NO SE PONE NO SE CARGARAN.
         */
        this.menu.generarMenu();
    }
}
