/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.UtilidadesIntefaz;

import controlador.Coordinador;
import controlador.capturadeerrores.Suceso;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import modelo.ExcepcionPersonalizada;

/**
 * Operaciones básicas sobre los componentes gráficos.
 * @author Particular
 */
public  abstract class OperacionesBasicasPorDefinir extends SenalarErroresSobreGUI_{
    
    private Component componenteSiguienteAEnfocar;
    private String nombre;
    

    private int maximoDeEnteros;
    private  int maximoDeDecimales;
 
    //OBLIGAR A MAYUSCULAS O SOLO NÚMEROS
    private boolean reclamarMayusculasOMinusculas = true;
    protected boolean exepcionALaReglaMayusculasYNumeros = false;
    private boolean solicitadoMayusculas = false;
    //
    
    //CONSTANTES PARA EVENTOS CON EL TECLADO Y COMPONENTES
    public static final boolean GANO_EL_FOCO = true;
    public static final boolean PERDIO_EL_FOCO = false;
    
    public static final int KEY_TYPED = 1;
    public static final int KEY_PRESSED_POR_DEFECTO = 2;
    public static final int KEY_RELEASE = 3;
    
    //CONSTANTES DE TECLAS PARA KEYCODE
    public static final int TECLA_TABULADOR = 9;
    public static final int TECLA_ENTER = 10;
    public static final int TECLA_TABULADOR_ESPECIAL = 9998;
    public static final int TECLA_CUALQUIERA = 9999;
    public static final int TECLA_CUALQUIERA_EXCEPTO_ENTER = 9997;
    
    int evitarEjecucionDoble = 0;
    
    /**
     * Diferencia la forma de actuar del gettext para evitar errores. 
     */
    protected boolean esComboBox;
    
    
    
    public OperacionesBasicasPorDefinir(Coordinador controlador) {
        super(controlador);
               
    }

    
    
    /**
     * Retorna el texto que tiene el componente. 
     * @return Texto del componente.
     */
    public abstract String getText();
    
    /**
     * Retorna el texto que tiene el componente. 
     * @param txt Coloca texto en el componente. 
     */
    public abstract void setText(String txt);
    
    /**
     * Pone en blanco el componente de texto.
     */
    public void setText(){
        this.setText("");
    }
    
    /**
     * Marca un error en la interfaz gráfica.
     */
    public abstract void setError();
    
    /**
     * Asigna el foco al componente. 
     */
    public abstract void setFocus();
    
    /**
     * Devuelve este componente.
     * @return El componente que see definio en la utilidad. 
     */
    public abstract Component getThis();
    
    /**
     * Permite editar o no el campo. En el caso del combobox hay que revisar
     * especificamente como funciona!
     * @param editable True si lo permite. 
     */
    public abstract void setEditable(boolean editable);
    
       
    
    //FIN DE ABSTRACS--------------------------------------------------------

    /**
     * Define el nombre del componente. 
     * @param nombre
     */
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Define el siguiente componente para el foco.
     * @param componente El siguiente componente a enfocar. 
     */
    public void setNextFocusableComponent(Component componente) {
        this.componenteSiguienteAEnfocar = componente;
        
        keyActionAlmacen action = new keyActionAlmacen();
        action.setAccion(()->this.componenteAEnfocar());
        action.setCodigoDeCaracter(this.TECLA_TABULADOR_ESPECIAL);
        action.setEvento(this.KEY_PRESSED_POR_DEFECTO);
        
        this.setKeyAction(this.getThis(), action);
    }
    
    /**/
    private void componenteAEnfocar(){
        System.out.println(
                "[!] Componente ejecutando accion:" + this.nombre );
        
        this.componenteSiguienteAEnfocar.requestFocusInWindow();
        
        if (reclamarMayusculasOMinusculas && !this.exepcionALaReglaMayusculasYNumeros) {
            try {
                throw new ExcepcionPersonalizada("No has seteado mayusculas o números para el campo", this);
            } catch (ExcepcionPersonalizada ex) {
                Logger.getLogger(OperacionesBasicasPorDefinir.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
 
    /**
     * Compara el texto del componente con el que se le pase. 
     * Retorna un booleano si son iguales o no. Nos facilita la vida.
     * @param textoAcomparar La cadena de texto que se quiere comparar. 
     * @return  True si son iguales. 
     */
    public boolean equals(String textoAcomparar){
        return textoAcomparar.equals(this.getText());
    }
    
        
    protected void setFocusAction(Runnable accionCuandoPierdeElfoco, 
            Component esteComponente, boolean ganadoPerdido){
        Suceso s = new Suceso();
        s.setTextoAMostrar("[!] Asignando acción de foco a "
                + "componente: "+ this.nombre);
        s.setClase(this);
        s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
        System.out.println(s);
        
        esteComponente.addFocusListener( new FocusListener() {
            
            Runnable accionRecivida;
            boolean ejecutarEnEntradaOSalida;
            
            public FocusListener parametro(Runnable accion, 
                    boolean ejecutarEnEntradaOSalida){
                this.accionRecivida = accion;
                this.ejecutarEnEntradaOSalida = ejecutarEnEntradaOSalida;
                return this;
            }
            
            @Override
            public void focusGained(FocusEvent e) {
                this.activarAccion(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                this.activarAccion(false);
            }
            
            public void activarAccion(boolean entroOSalio){
                if (entroOSalio && this.ejecutarEnEntradaOSalida) {
                    this.accionRecivida.run();
                }
                if (!entroOSalio && !this.ejecutarEnEntradaOSalida) {
                    this.accionRecivida.run();
                }
            }
            
        }.parametro(accionCuandoPierdeElfoco, ganadoPerdido));
    
    }
    
    /**
     * Ejecuta la acción que se le pase como parametros con el código de la 
     * tecla que se le asigne cuando esta es precionada. Por defecto trabaja
     * con este componente.
     * 
     * @param accion - La función que se queire ejecutar.
     * @param codigoDecaracter - El código de la tecla que disparara la acción.
     */
    public void setKeyPressAction(Runnable accion, int codigoDecaracter){
        keyActionAlmacen act = new keyActionAlmacen();
        act.setAccion(accion);
        act.setCodigoDeCaracter(codigoDecaracter);
        act.setEvento(KEY_PRESSED_POR_DEFECTO);
        
        
        this.setKeyAction(this.getThis(), act);
    }
    
    public void setKeyRelease(Runnable accion, int codigoDecaracter){
        keyActionAlmacen act = new keyActionAlmacen();
        act.setAccion(accion);
        act.setCodigoDeCaracter(codigoDecaracter);
        act.setEvento(KEY_RELEASE);
        
        this.setKeyAction( this.getThis(), act);
    }
    
    public void setKeyTyped(Runnable accion, int codigoDecaracter){
        keyActionAlmacen act = new keyActionAlmacen();
        act.setAccion(accion);
        act.setCodigoDeCaracter(codigoDecaracter);
        act.setEvento(KEY_TYPED);
        
        this.setKeyAction(this.getThis(), act);
        
        
    }
    
    /**
     * Define las acciones que se quieren ejecutar por medio de acciones del 
     * teclado. 
     */
    
    private class keyActionAlmacen {
        Runnable accion;
        int codigoDeCaracter;
        int evento;

        public Runnable getAccion() {
            return accion;
        }

        public void setAccion(Runnable accion) {
            this.accion = accion;
        }

        public int getCodigoDeCaracter() {
            return codigoDeCaracter;
        }

        public void setCodigoDeCaracter(int codigoDeCaracter) {
            this.codigoDeCaracter = codigoDeCaracter;
        }

        public int getEvento() {
            return evento;
        }

        public void setEvento(int evento) {
            this.evento = evento;
        }
        
        @Override
        public String toString() {
           return "El componente:"+nombre+"\n"+
                   "codigoDeCaracter:" +codigoDeCaracter +"\n"+
                   "evento:"+evento;   

        }
    }
    
    private void setKeyAction(
            Component esteComponente,
            keyActionAlmacen act){
            
        Suceso s = new Suceso();
        s.setClase(this);
        s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
        s.setTextoAMostrar(
            "[!] Asignando accion a: '"+this.nombre+"'"
                    + "\n"
                    + "\tTecla:" + act.getCodigoDeCaracter()
                    + "\tEvento:" + act.getEvento()
                    + "\tAccion:" + act.getAccion());
        System.out.println(s);


        esteComponente.setFocusTraversalKeysEnabled(false);

        KeyListener keyListener = new KeyListener() {

            Runnable accion;
            int codigoDeCaracter;
            int evento;
            OperacionesBasicasPorDefinir obpd;

            public KeyListener parametros(keyActionAlmacen act,
                    OperacionesBasicasPorDefinir obpd){
                this.accion = act.getAccion();
                this.codigoDeCaracter = act.getCodigoDeCaracter();
                this.evento = act.getEvento();
                this.obpd = obpd ;
                return this;
            }

            @Override
            public void keyTyped(KeyEvent e) {
                this.ejecutarAccion(e, 1);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                this.ejecutarAccion(e, 2);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                this.ejecutarAccion(e, 3);
            }


            public void ejecutarAccion(KeyEvent e, int ev){
                // EL VALOR QUE ASIGNAMOS PARA COMPROBAR QUE EVENTO SE SOLICITO
                // DESDE SUS RESPECTIVOS EVENTOS.
                // 1 Typed
                // 2 Pressed
                // 3 Released

                boolean enterEjecutado = false;
                if(evento==ev){
                    switch (e.getKeyCode()){
                        case 1:


                        case 9:
                            //EL TABULADOR ES UN CASO MUY ESPECIAL POR QUE 
                            // REQUERIMOS EN OCASIONES EJECUTAR DOS ACCIONES.
                            // UNA PUEDE ES PARA CAMBIAR EL FOCO Y LA OTRA ESTA
                            // DEFINIDA PARA EJECUTAR LA ACCIÓN AL PRESIONAR EL 
                            // BOTON TABULADOR. ESTA DOBLE ACCION SE ESTORBA 
                            // Y TERMINA EJECUTANDO LA FUNCIÓN DOS VECES. 
                            // PARA EVITARLO DECLARAMOS UNA VARIABLE GLOBAL QUE CUENTE
                            // O SUME 1 SI YA SE EJECUTO LA ACCION DEL TABULADOR.
                            if (codigoDeCaracter == 9 && obpd.evitarEjecucionDoble == 0) {
                                obpd.evitarEjecucionDoble++;
                                this.accion.run();
                            }else if (codigoDeCaracter == TECLA_TABULADOR_ESPECIAL && obpd.evitarEjecucionDoble == 0){
                                obpd.evitarEjecucionDoble++;
                                this.accion.run();
                            }else{
                                obpd.evitarEjecucionDoble =0;
                            }
                            break;

                        //DESACTIVAMOS ESTAS TECLAS POR EL MOMENTO.
                        case 39://FLECHA derecha
                        case 37://FLECHA izquierda
                        case 32://BARRA ESPACIADORA
                        case 16://TECLA SHIFT
                        case 17://TECLA CONTROL
                            break;
                        case 10:

                            if(codigoDeCaracter==TECLA_ENTER){
                                this.accion.run();
                                enterEjecutado = true;
                                break;
                            }

                        default:
                                //SI SE PRESIONA CUALQUIER TECLA EXEPTO ENTER
                                // ENTRA AQUI.
                                if(codigoDeCaracter==TECLA_CUALQUIERA_EXCEPTO_ENTER){
                                   this.accion.run();
                                   break;
                                }
                                // SI TODO VA BIEN Y NO SE PRESIONO ENTER (DEFINIDO DESDE
                                // SU CORRESPONDIENTE 
                                if(this.codigoDeCaracter == TECLA_CUALQUIERA && !enterEjecutado){
                                    this.accion.run();
                                };
                            break;
                    }
                }
            }
        }.parametros(act, this);
        esteComponente.addKeyListener(keyListener);
    }
    
    /**
     * Establece que el campo solo puede recibir los valores [0-9\.] 
     * y define el número máximo de digitios que se quieren introducir 
     * para el campo.
     *
     */
    public void setPermitirSoloNumeros(){
        this.filtroDecaracteres("numeros");
        this.setFocusAction(
                ()->this.invocarFiltradoDeNumerosySetearEnComponente(),
                this.getThis(),
                false);
        
        //this.setMaximoDeCaracteres(maximoDeEnterosOCaracteres);
        this.reclamarMayusculasOMinusculas = false;
    }
    
    /**
     * Establece que el campo solo puede recibir los valores [0-9\.] y 
     * define el número máximo de caracteres que se quieren introducir
     * en el campo. Este se utiliza para contar decimales despues de un punto.
     * 
     * Se utiliza el formato de mysql para los float que es de (16,3) donde 16
     * es el número máximo de caracteres que puede haber incluyendo al punto y
     * los decimales.
     * 
     * @param maximoDeEnterosOCaracteres - Si el campo es número significan 
     * digitios, si es texto cualquier caracter.
     * @param maximoDeDecimales - Solo para decimales. 
     */
    public void setPermitirSoloNumeros(int maximoDeEnterosOCaracteres, int maximoDeDecimales){
        this.filtroDecaracteres("numeros");
        this.setFocusAction(
                ()->this.invocarFiltradoDeNumerosySetearEnComponente(),
                this.getThis(),
                false);
        //this.setMaximoDeCaracteres(maximoDeEnterosOCaracteres, maximoDeDecimales);
        this.reclamarMayusculasOMinusculas = false;
        
    }
    
     /**
     * Establece que el campo solo acepte mayusculas y define el número máximo 
     * de caracteres que se quieren introducir para el campo.
     *
     */
    public void setPermitirSoloMayusculas(){
        this.filtroDecaracteres("mayusculas");
        //this.setTamanoDeCampo(maximoDeEnterosOCaracteres);
        this.reclamarMayusculasOMinusculas = false;
        this.solicitadoMayusculas = true;
    }
    
    /**
     * Permite que el campo contenga la fecha con formato dd/mm/aa.
     */
    public void setPermitirSoloFecha_ddmmaa(){
        this.filtroDecaracteres("fecha_ddmmaa");
        this.reclamarMayusculasOMinusculas = false;
        
    }
    
    //INVOCAMOS ESTA FUNCIÓN DESDE EL FOCUS ACTION PARA QUE CADA VEZ QUE 
    // EL COMPONENTE PIERDA EL FOCO SE COMPRUEBA QUE EL FORMATO ES CORRECTO.
    // EL FORMATO ESTA DEFINIDO EN filtraNumeros. DESPUES SETEA EL TEXTO EN 
    // EL COMPONENTE QUE LO INVOCA.
    private void invocarFiltradoDeNumerosySetearEnComponente(){
        this.setText(this.filtraNumeros(this.getText()));;
       
    }
    
    //ESTA FUNCIÓN FILTRA LA CADENA QUE SE LE PASE, EN ESTE CASO NUMÉRICA.
    // EL FORMATO QUE UTILIZA ES: "###.###". ESTOS VALORES SE DEFINEN EN 
    // setMaximoDeCaracteres().

    private String filtraNumeros(String texto){
         //Retorna solo el número necesario de caracteres
        String exprecion= "";
        
        //SI SOLO SE DEFINE UNO COMO MAXIMO DE ENTEROS CAMBIAMOS LA EXPRECION.
        //PONGO MENOR QUE DOS POR QUE YA CUANDO SETEAMOS LOS MÁXIMOS DE ENTEROS
        // DECIMALES AVISAMOS CON EL THROW QUE NO SE DEBE PONER 0 EN ENTEROS.
        // EN EL CASO DE LOS DECIMALES ÑO PASA ÑADA. XP
        if (this.getMaximoDeEnteros()<2) {
            exprecion= "^.";    
        }else{
            //ojo!! EL TOTAL DE ENTEROS INCLUYE UN ESPACIO Y UN PUNTO. ASÍ QUE SI
            //DEFINIMOS (16,3) EN REALIDAD LO ENTEROS TIENEN QUE SER = 16-3 -1 = 12
            // EL -1 ES EL PUNTO Y EL -3 SON LOS DÍGITOS DEL DECIMAL POR TANTO,
            // CUANDO LA EXPRECIÓN REGULAR ES SOLO PARA ENTEROS HAY QUE HACER
            // LA DEVIDA RESTA, PERO SE HACE AQUI Y NO EN SETEO DE EL MAXIMO DE
            // CARACTERES POR QUE ES NECESARIO QUE PERMITA SEGUIR AGREGANDO DIGITOS
            // PARA PONER EL PUNTO!! Y LOS DECIMALES!!. Xp
            if (this.getMaximoDeDecimales() < 2) {
                //SI EL MAXIMO DE DECIMALES ES MENOR QUE UNO CAMBIAMOS SU EXPRECION
                // PARA QUE SOLO RETORNE ÑA PARTE EÑTERA.
                if (this.getMaximoDeDecimales()==1) {
                    exprecion= "^\\d{1,"+(this.getMaximoDeEnteros()-this.getMaximoDeDecimales()-1)+"}(\\.\\d)?";
                }else{
                    //COMO SOLO HAY DOS POSIBILIDADES, QUE getMaximoDeDecimales 
                    // UNO O SEA 0 ENTONCES AQUI NO HACEMOS LA RESTA DE LOS 
                    // CARACTERES, SOLO TOMAMOS EL TOTAL getMaximoDeEnteros.
                    exprecion= "^\\d{1,"+(this.getMaximoDeEnteros())+"}";
                }
            }else{
                exprecion= "^\\d{1,"+(this.getMaximoDeEnteros()-this.getMaximoDeDecimales()-1)+"}(\\.\\d{1,"+this.getMaximoDeDecimales()+"})?";
            }
        }
       
        //EJECUTAMOS LA EXPRECIÓ REGULAR.
        Pattern patron = Pattern.compile(exprecion);
        Matcher matcher = patron.matcher(texto);
        //EN CASO DE QUE NO SE CUMPLAN LAS CONDICIONES DEL MATCHER SE ELIMINARA
        // EL RESULTADO Y SE RETORNA VACIO PARA SUTITITUIR EL TEXTO EN EL 
        // COMPONENTE.
        String retorno = "";
        if (matcher.find()) {
            retorno = matcher.group();
        }
        return retorno;
    }
    
    //ESTA FUNCIÓN SE LLAMA DESDE FILTRO DE CARACTERES. CADA VEZ QUE SE PULSA
    // UN CARACTER SE COMPRUEBA SI EL TAMAÑO DE LA CADENA CORRESPONDE AL 
    // DEFINIDO EN maximoDeEnteros. (Hay que usar los setters para definir ese
    // valor.) SI SE LLEGA EL MAXIMO SUSTITUYE . 
    private boolean limitarEntradaDeCaracteres(){
        if (this.getText().isEmpty()) {
            //SI LA CADENA ESTA VACIA RETORNA TRUE O SI EL 
            return true;
        }else if(this.getText()==null){
            //ESTA LINEA ES PARA LOS COMBOBOX
            return true;
        }else if (this.getText().split("").length+1>this.maximoDeEnteros) {
            
            return false;
        } 
        return true;
    }
    
    /**
     * Setea el tamaño de campo permitido para elemento en que se definio. 
     * Cuando se ingresa un solo parametro se estima que el campo es varchar o
     * int. Para campos con decimales se utiliza la función con dos paramentros.
     * 
     * @param maximoDeEnterosOCaracteres Cantidad de caracteres a restringir el
     * campo.
     */
    public void setTamanoDeCampo(int maximoDeEnterosOCaracteres) {
        try {
            if (maximoDeEnterosOCaracteres<1) {
                throw new ExcepcionPersonalizada("El valor del campo no puede ser 0.",this);
            }
            this.maximoDeEnteros = maximoDeEnterosOCaracteres;
            
//            this.filtroDecaracteres("cantidad");
        } catch (ExcepcionPersonalizada ex) {
            
            Logger.getLogger(OperacionesBasicasPorDefinir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
   
    /**
     * Define el tamaño de campo permitido para el elemento que se definio. 
     * Cuando se ingresan los dos parametros se estima que el campo es de tipo
     * decimal. 
     * @param maximoDeEnteros Cantidad máxima de caracteres que se soportaran incluido el punto y decimales. 
     * @param maximoDeDecimales Los decimales máximos que se aceptaran.
     */
    public void setTamanoDeCampo(int maximoDeEnteros, int maximoDeDecimales) {
        
        try {
            int enteros = maximoDeEnteros-maximoDeDecimales-1;
            if (enteros==0) {
                throw new ExcepcionPersonalizada("No puedes tener cero enteros en un campo con decimales!",this);
            }
            
            this.maximoDeEnteros = maximoDeEnteros;
            this.maximoDeDecimales = maximoDeDecimales;
//            this.filtroDecaracteres("cantidad");
        } catch (ExcepcionPersonalizada ex) {
            
            Logger.getLogger(OperacionesBasicasPorDefinir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

    /**
     * Devuelve el número máximo de caracteres que se pueden escribir dentro de
     * el campo.
     * @return El número máximo de enteros.
     */
    public int getMaximoDeEnteros() {
        return maximoDeEnteros;
    }

    /**
     * Devuelve el número de máximo de decimales que se pueden escribir dentro
     * de un campo numérico.
     * @return Número máximo de decimales. 
     */
    public int getMaximoDeDecimales() {
        return maximoDeDecimales;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    /**
     * Devuevle true si el texto esta seleccionado. Esta función ayuda a que
     * se borre el texto que se escribe en los campos cuando este se limite por
     * sus cantidad de caracteres. 
     * @return True si la selección coincide con el tamaño de la cadena escrita. 
     */
    public boolean isTextSelected(){
        if (this.getThis() instanceof JTextField) {
            JTextField campo = (JTextField) this.getThis();
            if (campo.getSelectedText()!= null) {
               
                return true;
            }
        }
        return false;
    }

    
    //FILTRA CARACTER POR CARACTER PARA SOLO OBTENER, SEGÚN EL tipoDeFiltro
    // CON EL QUE SE INVOQUE LA CADENA DESEADA. ESO ES PARA EL KEYLISTENER.
    // EL FOCUS SE SETEA PARA QUE EN CASO DE QUE EL USUARIO PEGE TEXTO DENTRO
    // DEL CAMPO Y ESTE TRAIGA MINISCULAS SE PONGAN TODAS A MAYUSCULAS CUANDO
    // SE PIERDA EL FOCO DEL CAMPO.
    private void filtroDecaracteres(String tipoDeFiltro){
        
        //ESCUCHA DE TECLAS.
        this.getThis().addKeyListener(new KeyAdapter() {
            
            //LA FUNCION parametros QUE UTILIZAMOS PARA PASAR PARAMETROS Y 
            // EL CONTROLADOR A ESTA INSTANCIA ¿HUERFANA?
            OperacionesBasicasPorDefinir operaciones;
            String tipoDeFiltro;
            boolean revisarCaracterParaSobreescribirSeleccion = false;
            KeyListener parametros(OperacionesBasicasPorDefinir operaciones,
                    String tipoDeFiltro){
                this.operaciones = operaciones;
                this.tipoDeFiltro = tipoDeFiltro;
                return this;
            }
                        
            @Override
            public void keyTyped(KeyEvent e) {
                if(!this.operaciones.limitarEntradaDeCaracteres()){
                    //SI EL TEXTO ESTA SELECCIONADO ENTONCES PERMITIMOS QUE
                    // SE SIGA ESCRIBIENDO PARA QUE SE ELIMINE TODO LO SELECCIONADO.
                    if (!this.operaciones.isTextSelected()) {
                        //QUITAMOS EL CARACTER CUANDO SE SUPERO EL MÁXIMO DEFINIDO.
                        e.setKeyChar('\0');
                    }else{
                        //EN CASO DE QUE EL TEXTO QUE SE ESTA LIMITANDO ESTE SELECCIONADO
                        // SE PONE EN VERDADERO ESTA VARIABLE PARA QUE SE UTILIZE
                        // EL FILTRO QUE SE DEFINIO PARA EL CAMPO. DE ESTE MANERA
                        // LOGRAMOS QUE SI SE PRESIONA OTRA TECLA QUE NO CORRESPONDA
                        // AL FILTRO ESTE NO SE ESCRIBA, EN CAMBIO, SI SE PRESIONA
                        // UNA LETRA QUE PERTENEZCA AL FILTRO ENTONCES LA SELECCIÓN
                        // SI SE SOBREESCRIBE. 
                        revisarCaracterParaSobreescribirSeleccion = true;
                    }
                }
                                
                if(this.operaciones.limitarEntradaDeCaracteres() || revisarCaracterParaSobreescribirSeleccion){
                //LIMITAMOS EL NUMERO DE CARACTERES.
                //limitarEntradaDeCaracteres COMPRUEBA QUE NO SE INTRODUZCAN MÁS
                // CARACTERES DE LOS QUE SE ESPECIFICAN.
                    //CARGAMOS EL CHAR DIGITADO.
                    char c = e.getKeyChar();
                    //FILTRAMOS SEGÚN EL TIPO DE FILTRO Xp.
                    switch(tipoDeFiltro){
                        case "mayusculas":
                            //COMPROBAMOS CADA TECLA INTRODUCIDA Y LA CONVIERTIMOS
                            // A MAYUSCULAS SI NO LO ESTA.
                            if (Character.isLowerCase(c)) {
                                String cadd = (""+c).toUpperCase();
                                c=cadd.charAt(0);
                                e.setKeyChar(c);
                            }
                            break;
                        case "numeros":
                            //SI SE INTRODUCE ALGUN CARACTER A EXCEPCION DE UN 
                            // PUNTO SE COMPRUEBA. SI ES DIGITO SE RETORNA CON
                            // setKeyChar(char) SI NO, LO SUSTITUIMOS CON \0 QUE
                            // ES UN CARACTER VACIO.

                            if (Character.isDigit(c) || c=='.') {
                                e.setKeyChar(c);
                            } else {
                                e.setKeyChar('\0');
                            }
                            break;
                        case "fecha_ddmmaa":
                            // SOLO PERMITIMOS NÚMEROS Y / PARA QUE SE AÑADAN 
                            // AL CAMPO TIPO FECHA. 
                            if (Character.isDigit(c) || c == '/') {
                                e.setKeyChar(c);
                            }else{
                                e.setKeyChar('\0');
                            }
                            break;
                            
//                        case "cantidad":
//                            //ES PARA LIMITAR LA CANTIDAD DE CARACTERES DE 
//                            // CUALQUIER TIPO. ESTA VACIO POR QUE NO QUITA TEXTO, 
//                            // SOLO UTILIZA EL e.setKeyChar('\0') PARA QUE NO 
//                            // SE PUEDA SEGUIR ESCRIBIENDO DENTRO DEL COMPONENTE.
//                            break;
                        default:
                            
                            try {
                                throw new ExcepcionPersonalizada(
                                        "[>>>] Filtro no definido: "+tipoDeFiltro
                                       + "\nParece que el filtro de caracteres no coincide.\n"
                                       + "Definiste: " + tipoDeFiltro + " y solamente estan definidos\n"
                                       + "'mayusculas', 'numeros' y fecha_ddmmaa." 
                                        ,operaciones);
                            } catch (ExcepcionPersonalizada ex) {

                                Logger.getLogger(OperacionesBasicasPorDefinir
                                        .class.getName()).log(Level.SEVERE, null, ex);
                            }
                            break;
                    }
                    revisarCaracterParaSobreescribirSeleccion = false;
                }
            }
        }.parametros(this, tipoDeFiltro));
        
        this.getThis().addFocusListener(new FocusListener() {
            OperacionesBasicasPorDefinir operaciones;
            FocusListener operaciones  (OperacionesBasicasPorDefinir operaciones){
                this.operaciones = operaciones;
                return this;
            }
            @Override
            public void focusGained(FocusEvent e) {
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.out.println("[+]Mayusculas foco perdido: " + this.operaciones.nombre);
                //AQUI LE DECIMOS QUE CORTE LA CADENA SI ESTA MÁS LARGA DE LO 
                // QUE DEFINIMOS EN setMaximoDeCaracteres(int numero); xP
                // Y TAMBIEN PONE EN MAYUSCULAS TODA LA CADENA SI SE SETEO COMO MAYUSCULAS,
                // POR SI ACASO PASA ALGO COMO PEGAR TEXTO EN MINUSCULAS.
                String texto = this.operaciones.filtrarCantidadDeLetras(this.operaciones.getText());
                if (this.operaciones.solicitadoMayusculas) {
                    System.out.println(""
                            + "     [!]MAYUSCULAS SOLICITADAS - Cadena puesta en mayusculas.");
                    this.operaciones.setText(texto.toUpperCase());
                }
            }
        }.operaciones(this));
    }
    
    private String filtrarCantidadDeLetras(String texto){
        //RETORNA SOLO EL NÚMERO NECESARIO DE CARACTERES
        String exprecion= "";
        if (this.getMaximoDeEnteros()<2) {
            //SI SOLO ES UN CARACTER EL QUE SE DEFINIO PARA INTRODUCIR.
            exprecion= "^.";
        }else{
            exprecion= "^.{1,"+this.getMaximoDeEnteros()+"}";
        }
        Pattern patron = Pattern.compile(exprecion);
        Matcher matcher = patron.matcher(texto);
        String retorno = "";
        if (matcher.find()) {
            retorno = matcher.group();
        }
        return retorno;
    }
    
    /**
     * Quita los espacios en blanco al principio y al final de la cadena dentro
     * del campo.
     */
    public void setEspaciosEnBlanco(){
        this.setFocusAction(()->this.quitarEspaciosSobrantes(),
                this.getThis(), false);
    }
    
    //SOBRE CARGA PARA LLAMAR LA FUNCION QUITAR ESPACIOS SOBREANTES DESDE UN 
    //RUNNABLE.
    private void quitarEspaciosSobrantes(){
        Suceso s = new Suceso();
        s.setTextoAMostrar("[i]Ajustanto espacios: " + this.nombre);
        s.setClase(this);
        s.setComoSeMostraraLaInfo(Suceso.INFO_CLASE);
        System.out.println(s);
        this.setText(this.quitarEspaciosSobrantes(this.getText()));
    }
    
    //QUITAR ESPACIOS EN BLANCO AL PRINICIPIO Y AL FINAL.
    protected String quitarEspaciosSobrantes(String cadena){
                
        if (cadena!=null) {
            String exprecion ="^\\s{1,}|\\s{1,}$";
            Pattern patron = Pattern.compile(exprecion);
            Matcher matcher = patron.matcher(cadena);
            
            matcher.find();
            cadena = matcher.replaceAll("");
            
            String exp2 = "\\s{1,}";
            Pattern pat2 = Pattern.compile(exp2);
            Matcher matcher2 = pat2.matcher(cadena);
            
            matcher2.find();
            cadena = matcher2.replaceAll(" ");
                    
        }
            return cadena;
    }
    
    /**
     * Define una acción para doble click.
     * @param accion La acción que queremos que se ejecute.
     */
    public void setDobleClick(Runnable accion){
        
        this.getThis().addMouseListener(new MouseAdapter() {
            
            Runnable accion;
            OperacionesBasicasPorDefinir operaciones;
            
            MouseListener parametros(OperacionesBasicasPorDefinir operaciones, Runnable accion ){
                this.accion = accion;
                this.operaciones = operaciones;
                return this;
            
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2) {
                    this.accion.run();
                }
            }
           
        }.parametros(this, accion));
    }
    
     /**
     * Define una acción para cuando se hace click sobre el elemento
     * @param accion La acción que queremos que se ejecute.
     */
    public void setSingleClick(Runnable accion){
        this.getThis().addMouseListener(new MouseAdapter() {
            
            Runnable accion;
            OperacionesBasicasPorDefinir operaciones;
            
            MouseListener parametros(OperacionesBasicasPorDefinir operaciones, Runnable accion ){
                this.accion = accion;
                this.operaciones = operaciones;
                return this;
            
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==1) {
                    this.accion.run();
                }
            }
           
        }.parametros(this, accion));
    }
    
}
