/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import controlador.Coordinador;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.FicherosOperaciones;
import modelo.InfoTabla.EmpleadoIT;
import modelo.InfoTabla.EntradaLoteIT;
import modelo.InfoTabla.MaquinaIT;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;
import modelo.InfoTabla.RelacionRefaccionProveedorIT;
import modelo.InfoTabla.SalidaLoteIT;
import modelo.InfoTabla.SeccionDeMaquinaIT;
import modelo.ParametrosDeCampo;
import modelo.dao.DepartamentoDao;
import modelo.dao.EmpleadoDao;
import modelo.dao.EntradaLoteDao;
import modelo.dao.ImagenProveedorDao;
import modelo.dao.ImagenRefaccionDao;
import modelo.dao.ImportanciaDao;
import modelo.dao.MaquinaDao;
import modelo.dao.MaquinaHistorialNombresDao;
import modelo.dao.MaquinaModeloDao;
import modelo.dao.MaterialDao;
import modelo.dao.PaisDao;
import modelo.dao.ProveedorDao;
import modelo.dao.RefaccionDao;
import modelo.dao.RelacionRefaccionMaquinaModeloDao;
import modelo.dao.RelacionRefaccionProveedorDao;
import modelo.dao.RelacionSeccionDeMaquinaRefaccionDAO;
import modelo.dao.SalidaLoteDao;
import modelo.dao.SeccionDeMaquinaDAO;
import modelo.dao.UnidadDao;
import modelo.vo.DepartamentoVo;
import modelo.vo.EmpleadoVo;
import modelo.vo.EntradaLoteVo;
import modelo.vo.ImagenProveedorVo;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.ImportanciaVo;
import modelo.vo.MaquinaHistorialNombresVO;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaquinaVo;
import modelo.vo.MaterialVo;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;
import modelo.vo.RelacionSeccionDeMaquinaRefaccionVO;
import modelo.vo.SalidaLoteVo;
import modelo.vo.SeccionDeMaquinaVO;
import modelo.vo.UnidadVo;
import vista.panels.PanelSalidaLoteContenedorDeFila;

/**
 *
 * @author Particular
 */
public class Logica {
    private Coordinador coordinador;

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }
    
   /* 
    ========================================================================
       INICIO DE REGISTRO DE PROVEEDORES.
    ////////////////////////////////////////////////////////////////////////
    */
    
    /**
     * Guarda un proveedor en la base de datos. 
     * @param vo Los datos de proveedor para guardar. 
     * @return  True si todo salio bien.
     */
    public boolean proveedorGuardar(ProveedorVo vo){
        ProveedorDao proveedor = new ProveedorDao(coordinador);
        return proveedor.guardar(vo);
                
    }
    
    /**
     * Revisa si el proveedor proveedorExiste en la base de datos.
     * @param proveedor El proveedor a comprobar. 
     * @return  True si existe. 
     */
    public boolean proveedorExiste(String proveedor){
        ProveedorDao dao_ = new ProveedorDao(coordinador);
        return dao_.existe(proveedor);
    }
    
    public boolean proveedorExiste(ProveedorVo vo){
        ProveedorDao dao = new ProveedorDao(coordinador);
        return dao.existe(vo);
    }
    
    public boolean proveedorModificar(ProveedorVo vo){
        ProveedorDao dao = new ProveedorDao(coordinador);
        return dao.modificar(vo);
    }
    
    /**
     * Consulta la lista de todos los proveedores y solo devuelve al proveedor-empresa.
     * 
     * @return Retorna la lista de proveedores existentes por su campo empresa. 
     */
    public List<ProveedorVo> proveedorConsultarMarcas(){
        ProveedorDao dao = new ProveedorDao(coordinador);
        return dao.consultarProveedores();
        
    }
    
    /**
     * Consulta los proveedores que estan seleccionados con el id de la máquina
     * que se le pase como parametro. 
     * @param vo La refacción de la cual se quiere buscar las máquinas. 
     * @return La lista de máquinas relacionadas. 
     */
    public List<ProveedorVo> proveedorConsultarMarcas(RefaccionVo vo){
        RelacionRefaccionProveedorDao dao = new RelacionRefaccionProveedorDao(coordinador);
        return dao.consultarProveedores(vo);
        
    }
    
    public ProveedorVo proveedorConsultar(int id){
        ProveedorDao d = new ProveedorDao(coordinador);
        return d.consultar(id);
    }
    
    public boolean proveedorEliminar(ProveedorVo vo){
        ProveedorDao dao = new ProveedorDao(coordinador);
        return dao.eliminar(vo);
    }
    
    /**
     * Valida los campos según la definición que se le da en la clase Dao en la
     * lista de tipo ParametrosDeCampo.
     * @param vo - La información que vamos a validad. 
     * @return La lista de campos validados con error.
     */
    public List<Validacion> proveedorValidarCampos (ProveedorVo vo, boolean valindadoUpdate){
        //LA LISTA QUE SE RETORNA DE VALIDACIONES.
        List<Validacion> listaValidaciones = new ArrayList<>();
        
        //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO.
        ProveedorIT b = new ProveedorIT();
        List<ParametrosDeCampo> listaPDC =b.getCAMPOS_PDC();
        //RECORREMOS CADA CAMPO.
        for (ParametrosDeCampo parametrosDeCampo : listaPDC) {
            try {
                //COMPROBAMOS QUE EL CAMPO NO ESTE NULO CUANDO ASÍ LO SOLICITA.

                //EL NOMBRE DEL CAMPO QUE VAMOS A VALIDAR.
                
                String NombreDelCampoActual = parametrosDeCampo.getNombre();
                //EL VALOR QUE TIENE ACTUALMENTE EL CAMPO. ESTE MAPA CONTIENE
                // LA FUNCION CALLABLE QUE RELACIONA EL NOMBRE DEL CAMPO CON EL 
                // VALOR TOMADO ACTUALMENTE. SE DEFINE EN EL VO Y SE HEREDA DE
                // VOGeneral.
                String valorAValidar =vo.getRelacionCampo().get(NombreDelCampoActual).call()+ "";
                if (!parametrosDeCampo.isNulo()) {
                    //EL OBJETO QUE SE VA A RETORNAR PARA SEÑALAR LOS ERRORES SOBRE LA GUI.
                    Validacion val = new Validacion();
                    //DEFINIMOS EL CAMPO QUE SE ESTA VALIDANDO.
                    val.setNombreDeCampo(parametrosDeCampo);
                    
                    //COMPROBAMOS QUE A VO SE LE HAYA PASADO UN VALOR.
                    if (valorAValidar.isEmpty()) {
                        //DEFINIMOS EL MENSAJE EN ESTE CASO.
                        val.setMensajeDeError("No puede estar vacio.");
                        //GUADAMOS EL VALOR FALSE POR QUE NO SE HA DEFINIDO. 
                        val.setValido(false);
                        
                    }else{
                        val.setValido(true);
                    }
                    
                    listaValidaciones.add(val);
                    
                } 
                
                if (!parametrosDeCampo.isPermiteRepetido() && !valorAValidar.isEmpty()) {
                    //VALIDAMOS LOS CAMPOS QUE NO PUEDEN REPETIRSE.
                    Validacion val = new Validacion();
                    val.setNombreDeCampo(parametrosDeCampo);
                    if (valindadoUpdate) {
                        if (this.proveedorExiste(vo)) {
                            val.setMensajeDeError("El valor '"+vo.getEmpresa()+"' ya fue asignado a otro proveedor.");
                            val.setValido(false);
                        }else{
                            val.setValido(true);
                        }
                    }else{
                        if (this.proveedorExiste(valorAValidar)) {
                            val.setMensajeDeError("El valor '"+valorAValidar+"' ya existe en la base." );
                            val.setValido(false);
                        }else{
                            val.setValido(true);
                        }
                    }
                    listaValidaciones.add(val);
                }
                
                
                
                
                
            } catch (Exception ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaValidaciones;
    }
    
    public int proveedorConsultarUltimoId(){
        ProveedorDao dao = new ProveedorDao(coordinador);
        return dao.consultarUltimoId();
    
    }
    
     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE REGISTRO DE PROVEEDORES
    ========================================================================
    */
    
    /* 
    ========================================================================
       INICIO DE PAISES
    ////////////////////////////////////////////////////////////////////////
    */
   
    public boolean paisGuardar(PaisVo vo){
        PaisDao paisDao_ = new PaisDao(coordinador);
        return paisDao_.guardar(vo);
        
    
    }
    
    public List <PaisVo> paisConsultar(){
        PaisDao dao = new PaisDao(coordinador);
        return dao.consultar();
    }
    
    public boolean paisExiste(String pais){
        PaisDao dao = new PaisDao(coordinador);
        return dao.existe(pais);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE PAISES
    ========================================================================
    */
    
   /* 
    ========================================================================
       INICIO DE REGISTRO MAQUINAMODELO
    ////////////////////////////////////////////////////////////////////////
    */
    
    /**
     * Guarda una MaquinaModelo en la base de datos. 
     * @param vo La MaquinaModelo que se guardara. 
     * @return  True si se guardo correctamente. 
     */
    public boolean maquinaModeloGuardar(MaquinaModeloVo vo){
       MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
       return dao.guardar(vo);
    }
    
    public boolean maquinaModeloModificar(MaquinaModeloVo vo){
        MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
        return dao.modificar(vo);
    
    }
    
    /**
     * Elimina la máquina-modelo que se le pase como parametro.
     * @param vo El id de la maquina-modelo a eliminar. 
     * @return True si se elimino correctamente. 
     */
    public boolean maquinaModeloEliminar(MaquinaModeloVo vo){
        MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
        return dao.eliminar(vo);
    }
    
    /**
     * Revisa si la maquinaModelo existe en la base de datos. Se busca por conincidencia
     * par de Maquina-Año de manera que si hay un modelo MASS y varios años (1999, 2011)
     * se busca el par que se quiere como repetido. 
     * @param modelo El modelo de la máquina que se quiere buscar. 
     * @param anio El año de la máquina Modelo que se quiere buscar. 
     * @return  True si encuentra coincidencia. 
     */
    public boolean maquinaModeloExiste(String modelo, int anio ){
        MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
        return dao.existe(modelo, anio);
    }
    
    /**
     * Revisa si la maquinaModelo existe en la base de datos. Se busca por conincidencia
     * par de Maquina-Año de manera que si hay un modelo MASS y varios años (1999, 2011)
     * se busca el par que se quiere como repetido descartando el id que se
     * pase como parametro.
     * @param modelo El modelo de la máquina que se quiere buscar. 
     * @param anio El año de la máquina Modelo que se quiere buscar. 
     * @return  True si encuentra coincidencia. 
     */
    public boolean maquinaModeloExiste(MaquinaModeloVo vo ){
        MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
        return dao.existe(vo);
    }
    
    /**
     * Consulta la lista de modelos - año.
     * @return  Retorna un objeto MaquinaModeloVo.
     */
    public List<MaquinaModeloVo> maquinaModeloConsultarModeloAnio(){
        MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
        return dao.consultar();
    }
    
    public MaquinaModeloVo maquinaModeloConsultarUno(int id){
        MaquinaModeloDao dao = new MaquinaModeloDao(coordinador);
        return dao.consultar(id);
        
    }
    
    public List<RelacionRefaccionMaquinaModeloVo> maquinaModeloConsultarModeloAnio(int id){
        RelacionRefaccionMaquinaModeloDao dao = new RelacionRefaccionMaquinaModeloDao(coordinador);
        return dao.consultarModeloAnio(id);
    }
    
    /** 
     * Consulta todas las máquinas que esten relacionadas con la lista de refacciones
     * que se le pase como parametro.
     * @param listRVO La lista de refacciones de las que se quiere obtener 
     * su relación con la máquina modelo. 
     * @return La lista de maquinas modelos relacionadas con la lista
     * de refacciones. 
     */
    public List<MaquinaModeloVo> maquinaModeloConsultarModeloAnio(List<RefaccionVo> listRVO){
        RelacionRefaccionMaquinaModeloDao dao = new RelacionRefaccionMaquinaModeloDao(coordinador);
        return dao.consultarModeloAnio(listRVO);

    
    }
    
    /**
     * Valida los campos según la definición que se le da en la clase Dao en la
     * lista de tipo ParametrosDeCampo.
     * @param vo - La información que vamos a validad. 
     * @param validarUpdate 
     * @return La lista de campos validados con error.
     */
    public List<Validacion> maquinaModeloValidarCampos (MaquinaModeloVo vo, boolean validarUpdate){
        //LA LISTA QUE SE RETORNA DE VALIDACIONES.
        List<Validacion> listaValidaciones = new ArrayList<>();
        
        //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO.
        MaquinaModeloIT b = new MaquinaModeloIT();
        List<ParametrosDeCampo> listaPDC =b.getCAMPOS_PDC();
        //RECORREMOS CADA CAMPO.
        for (ParametrosDeCampo parametrosDeCampo : listaPDC) {
            try {
                /*
                ----------------------------------------------------------------
                COMPROBAMOS QUE EL CAMPO NO ESTE NULO CUANDO ASÍ LO SOLICITA.
                ----------------------------------------------------------------
                */
                //EL NOMBRE DEL CAMPO QUE VAMOS A VALIDAR.
                String NombreDelCampoActual = parametrosDeCampo.getNombre();
                //EL VALOR QUE TIENE ACTUALMENTE EL CAMPO
                String valorAValidar = vo.getRelacionCampo().get(NombreDelCampoActual).call()+ "";
                if (!parametrosDeCampo.isNulo()) {
                    //EL OBJETO QUE SE VA A RETORNAR PARA SEÑALAR LOS ERRORES SOBRE LA GUI.
                    Validacion val = new Validacion();
                    //DEFINIMOS EL CAMPO QUE SE ESTA VALIDANDO.
                    val.setNombreDeCampo(parametrosDeCampo);
                    
                    //COMPROBAMOS QUE A VO SE LE HAYA PASADO UN VALOR.
                    if (valorAValidar.isEmpty()) {
                        //DEFINIMOS EL MENSAJE EN ESTE CASO.
                        val.setMensajeDeError("No puede estar vacio.");
                        //GUADAMOS EL VALOR FALSE POR QUE NO SE HA DEFINIDO. 
                        val.setValido(false);
                        
                    }else{
                        val.setValido(true);
                        val.setMensajeDeError("todo bien");
                    }
                    listaValidaciones.add(val);
                } 
                //-1 SE REQUIER POR QUE LAS VARBIABLES CON INT NO PUEDEN ESTAR NULAS. -1 ES EL ESTANDAR QUE NUNCA 
                // VA A TOCAR LA VALIDACION.
                if (!parametrosDeCampo.isPermiteRepetido() && !valorAValidar.isEmpty() && !valorAValidar.equals(-1)) {
                    //VALIDAMOS LOS CAMPOS QUE NO PUEDEN REPETIRSE.
                    Validacion val = new Validacion();
                    val.setNombreDeCampo(parametrosDeCampo);
                    int anio = Integer.parseInt(""+vo.getRelacionCampo().get(b.getAnioPDC().getNombre()).call()) ;
                    if (validarUpdate) {
                        if (parametrosDeCampo.getNombre().equals(b.getMODELO().getNombre())) {
                            if (this.maquinaModeloExiste(vo)) {
                                val.setMensajeDeError("El valor '"+valorAValidar+"' "
                                        + "y '"+ anio+"' ya están registrados para otro modelo." );
                                val.setValido(false);
                            }else{
                                val.setValido(true);
                            }
                        }else{
                            val.setValido(true);
                            val.setMensajeDeError("todo bien");
                        }
                    }else{
                        if (this.maquinaModeloExiste(valorAValidar, anio)) {
                            val.setMensajeDeError("El valor '"+valorAValidar+"' "
                                    + "y '"+ anio+"' ya están registrados." );
                            val.setValido(false);
                        }else{
                            val.setValido(true);
                            val.setMensajeDeError("todo bien");
                        }
                    }
                    listaValidaciones.add(val);
                }
                
                /**
                 Validamos que le campo de año no este en 0 por que en realidad
                 no se puede manejar como un null o vacio "" .
                 */
                if (NombreDelCampoActual.equals(b.getAnioPDC().getNombre())) {
                    
                    //CAMPO VACIO
                    int valorint =Integer.parseInt(vo.getRelacionCampo().get(NombreDelCampoActual).call()+"");
                    Validacion val1 = new Validacion();
                    val1.setNombreDeCampo(parametrosDeCampo);
                    if (valorint==0) {
                        val1.setMensajeDeError("No puede estar vacio.");
                        val1.setValido(false);
                    }else{
                        val1.setValido(true);
                        val1.setMensajeDeError("todo bien");
                    }
                    Validacion val2 = new Validacion();
                    val2.setNombreDeCampo(parametrosDeCampo);
                    
                    //MENOR A CUATRO DÍGITOS
                    if (valorAValidar.split("").length < b.getAnioPDC().getLongitudDeCaracteres()) {
                        val2.setMensajeDeError("Deben ser 4 dígitos.");
                        val2.setValido(false);
                    }else{
                        val2.setValido(true);
                        val2.setMensajeDeError("todo bien");
                    }
                    
                    //AÑO FUERA DEL RANGO 1960-ACTUAL.
                    Validacion val3 = new Validacion();
                    val3.setNombreDeCampo(parametrosDeCampo);
                    
                    int anio = Integer.parseInt(valorAValidar);
                    
                    Calendar cal= Calendar.getInstance(); 
                    int year= cal.get(Calendar.YEAR); 
                    if (anio<1960 || anio>year+1) {
                        val3.setMensajeDeError("El año debe estar entre 1960 y " + (year+1)+".");
                        val3.setValido(false);
                    }else{
                        val3.setValido(true);
                        val3.setMensajeDeError("todo bien");
                    }
                    
                    listaValidaciones.add(val1);
                    listaValidaciones.add(val2);
                    listaValidaciones.add(val3);
                }
            } catch (Exception ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaValidaciones;
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DE MODELO DE MAQUINAS. MAQUINASMODELO
    ========================================================================
    */
    
    /* 
    ========================================================================
       INICIO REGISTRO DE UNIDADES
    ////////////////////////////////////////////////////////////////////////
    */
    
    public boolean unidadGuardar(UnidadVo vo){
        UnidadDao dao = new UnidadDao(coordinador);
        return dao.guardar(vo);
    }
    
    public boolean unidadExiste(String unidad){
        UnidadDao dao = new UnidadDao(coordinador);
        return dao.existe(unidad);
    }
    
    public List<UnidadVo> unidadConsultar(){
        UnidadDao dao = new UnidadDao(coordinador);
        return dao.consultar();
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DE UNIDADES
    ========================================================================
    */
    
     /* 
    ========================================================================
       INICIO REGISTRO DE MATERIALES
    ////////////////////////////////////////////////////////////////////////
    */
    public boolean materialGuardar(MaterialVo vo){
        MaterialDao dao = new MaterialDao(coordinador);
        return dao.guardar(vo);
    }
    
    public boolean materialExiste(String material){
        MaterialDao dao = new MaterialDao(coordinador);
        return dao.existe(material);
    }
    
    public List<MaterialVo> materialConsultar(){
        MaterialDao dao = new MaterialDao(coordinador);
        return dao.consultar();
    }
    
     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DE MATERIALES
    ========================================================================
    */
    
     /* 
    ========================================================================
       INICIO REGISTRO DE REFACCIONES.
    ////////////////////////////////////////////////////////////////////////
    */
    public boolean refaccionExisteCodigoInterno (String codigoInterno){
        RefaccionDao dao = new RefaccionDao(coordinador);
        return dao.existeCodigoInterno(codigoInterno);
    }
    

    /**
     * Comprueba si el código interno existe. 
     * @param vo El código a buscar. 
     * @return True si existe. 
     */

    public boolean refaccionExisteCodigoInterno(RefaccionVo vo){
        RefaccionDao dao = new RefaccionDao(coordinador);
        return dao.existeCodigoInterno(vo);
    }
    
    public List<Validacion> refaccionValidarCampos(RefaccionVo vo){
        return refaccionValidarCampos(vo, false);
    }
    public List<Validacion> refaccionValidarCampos(RefaccionVo vo, boolean validandoUpdate){
        //LA LISTA QUE SE RETORNA DE VALIDACIONES.
        List<Validacion> listaValidaciones = new ArrayList<>();
        
        //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO.
        List<ParametrosDeCampo> listaPDC =RefaccionIT.getCAMPOS_PDC();
        //RECORREMOS CADA CAMPO.
        listaPDC.forEach((_PDC) -> {
            try {
                /*
                ----------------------------------------------------------------
                COMPROBAMOS QUE EL CAMPO NO ESTE NULO CUANDO ASÍ LO SOLICITA.
                ----------------------------------------------------------------
                */
                
                //EL VALOR QUE TIENE ACTUALMENTE EL CAMPO
                String valor = vo.getRelacionCampo().get(_PDC.getNombre()).call()+ "";
                //VALIDA SI NO SE PERMITEN NULOS.
                if (!_PDC.isNulo()) {
                    //EL OBJETO QUE SE VA A RETORNAR PARA SEÑALAR LOS ERRORES SOBRE LA GUI.
                    Validacion vNulo = new Validacion();
                    //DEFINIMOS EL CAMPO QUE SE ESTA VALIDANDO.
                    vNulo.setNombreDeCampo(_PDC);
                    //COMPROBAMOS QUE A VO SE LE HAYA PASADO UN VALOR. EN EL CASO
                    // DE LOS VALORES NUMERICOS HAY QUE DEFINIR SU FORMATO EN CERO
                    // PUESTO QUE CUANDO LOS CAPTURAMOS EN VO PASAMOS CERO SI ESTA
                    // VACIO.
                    if (valor.isEmpty() || valor.equals("-1")|| valor.equals("-1.0") ) {
                        boolean ningunoDeLosAnteriores = true;
                        if (_PDC.getNombre().equals(RefaccionIT.getIMPORTANCIA().getNombre())) {
                            //MENSAJE PARA IMPORTANCIA.
                            vNulo.setMensajeDeError("Debes definir la importancia de la refacción.");
                            ningunoDeLosAnteriores = false;
                        }
                        if(_PDC.getNombre().equals(RefaccionIT.getID_MATERIAL().getNombre())){
                            //MENSAJE PARA MATERIAL.
                            vNulo.setMensajeDeError("Debes registrar un material");
                            ningunoDeLosAnteriores = false;
                        }
                        if(_PDC.getNombre().equals(RefaccionIT.getUNIDAD().getNombre())){
                            //MENSAJE PARA UNIDAD.
                            vNulo.setMensajeDeError("Debes registrar una unidad.");
                            ningunoDeLosAnteriores = false;
                        }
                        if(ningunoDeLosAnteriores){
                        //DEFINIMOS EL MENSAJE GENERAL.
                            vNulo.setMensajeDeError("No puede estar vacio.");
                        }
                        //GUADAMOS EL VALOR FALSE POR QUE NO SE HA DEFINIDO. 
                        vNulo.setValido(false);
                        
                    }else{
                        vNulo.setValido(true);
                    }
                    listaValidaciones.add(vNulo);
                } 
                
                 /*
                ----------------------------------------------------------------
                COMPROBAMOS LOS CAMPOS QUE NO PUEDEN SER REPETIDOS
                ----------------------------------------------------------------
                */
                 if(!_PDC.isPermiteRepetido()&& !valor.isEmpty()){
                     Validacion vRepetido = new Validacion();
                     vRepetido.setNombreDeCampo(_PDC);
                     //EL CODIGO INTERNO NO PUEDE REPETIRSE, EL ID NO SE OCUPA
                     //COMPROBAR POR LO TANTO CUANDO PASE A COMPROBARSE SE
                     //DEFINIRA COMO TRUE DE QUE PASO LA VALIDACION.
                     // CUANDO SE VALIDA UN UPDATE EL CÓDIGO INTERNO SE VALIDA
                     // PARA QUE NO ESTE REPEDITO CON OTRO.
                     if (_PDC.getNombre().equals(RefaccionIT.getCODIGO_INTERNO().getNombre())) {
                         if (validandoUpdate) {
                         //SI ESTAMOS VALIDANDO UNA MODIFICAION ENTRA AQUI.
                            if (this.refaccionExisteCodigoInterno(vo)) {
                                vRepetido.setMensajeDeError(" Otra refacción ya tiene asignado este código.\n"
                                        + "Cambialo por uno diferente o modifica la refación que lo tiene asignado."+vo.toString());
                                vRepetido.setValido(false);
                            }else{
                                vRepetido.setValido(true);
                            }
                             
                         }else{
                            if (this.refaccionExisteCodigoInterno(valor)) {
                                vRepetido.setMensajeDeError(" El código ya existe.");
                                vRepetido.setValido(false);
                            }else{
                                vRepetido.setValido(true);
                            }
                         }
                     }else{
                            vRepetido.setMensajeDeError("paso permite repetido");
                            vRepetido.setValido(true);
                     }
                     listaValidaciones.add(vRepetido);
                 }
                 /*
                ----------------------------------------------------------------
                COMPROBAMOS QUE EL STOCK MINIMO Y MAXIMO ESTEN BIEN.
                ----------------------------------------------------------------
                */
                if (_PDC.getNombre().equals(RefaccionIT.getSTOCK_MAXIMO().getNombre())) {
                    String smax = vo.getRelacionCampo().get(
                            RefaccionIT.getSTOCK_MAXIMO().getNombre()).call()+"";
                    String smin = vo.getRelacionCampo().get(
                            RefaccionIT.getSTOCK_MINIMO().getNombre()).call()+"";
                    if (!smax.equals("-1.0") && !smin.equals("-1.0")) {
                        float fmax = Float.parseFloat(smax);
                        float fmin = Float.parseFloat(smin);
                        
                        if (fmax<fmin) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(RefaccionIT.getSTOCK_MAXIMO());
                            val.setMensajeDeError(
                                    "El stock máximo("+fmax+") no puede ser menor "
                                    + "\nque el stock mínimo("+fmin+")");
                            val.setValido(false);
                            listaValidaciones.add(val);
                        }else if (fmax==fmin && fmax!=0 && fmin!=0) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(RefaccionIT.getSTOCK_MAXIMO());
                            val.setMensajeDeError(
                                    "El stock máximo no puede ser igual"
                                    + "\nque el stock mínimo.");
                            val.setValido(false);
                            listaValidaciones.add(val);
                        }
                        
                        if (fmin==0) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(RefaccionIT.getSTOCK_MINIMO());
                            val.setMensajeDeError(
                                    "El stock mínimo no puede 0.");
                            val.setValido(false);
                            listaValidaciones.add(val);
                        }
                        
                        if (fmax==0) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(RefaccionIT.getSTOCK_MAXIMO());
                            val.setMensajeDeError(
                                    "El stock máximo no puede 0.");
                            val.setValido(false);
                            listaValidaciones.add(val);
                            
                        }
                    }
                }
                 
            } catch (Exception ex) {
                Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return listaValidaciones;
    }
    
    public List<Validacion> refaccionValidarCamposMaquinaModelo(List<RelacionRefaccionMaquinaModeloVo> lista){
        Validacion val = new Validacion();
        val.setNombreDeCampo(RelacionRefaccionMaquinaModeloIT.getID_MAQUINA_MODELO());
        if (lista.isEmpty()) {
            val.setMensajeDeError("No has seleccionado ningún modelo para esta refacción.");
            val.setValido(false);
        }else{
            val.setValido(true);
        
        }
        
        List<Validacion> a = new ArrayList<>();
        a.add(val);
        
        return a;
    }
    
    public List<Validacion> refaccionValidarCamposProveedor(List<RelacionRefaccionProveedorVo> lista){
        Validacion val = new Validacion();
        RelacionRefaccionProveedorIT it = new RelacionRefaccionProveedorIT();
        val.setNombreDeCampo(it.getID_PROVEEDOR());
        if (lista.isEmpty()) {
            val.setMensajeDeError("No has seleccionado ningún proveedor para esta refacción.");
            val.setValido(false);
        }else{
            val.setValido(true);
        }
        List<Validacion> a = new ArrayList<>();
        a.add(val);
        return a;
    }
    
    public int refaccionConsultarUltimoId(){
        RefaccionDao d = new RefaccionDao(coordinador);
        return d.consultarUltimoId();
    }
    
    public boolean refaccionGuardar(RefaccionVo vo){
        RefaccionDao d = new RefaccionDao(coordinador);
        return d.guardar(vo);
    }
    
    public List<RefaccionVo> refaccionConsultarTodoBusqueda(String buscar){
        RefaccionDao d = new RefaccionDao(coordinador);
        return d.consultarYBuscar(buscar);
    
    }
    public List<RefaccionVo> refaccionConsultar(){
        return refaccionConsultarTodoBusqueda("");
    }
    
    public RefaccionVo refaccionConsultar(int id){
        RefaccionDao d = new RefaccionDao(coordinador);
        return d.consultarPorId(id);
    }
    
    //MODIFICAR DATOS.

    /**
     * Modifica la refacción que se le pase como parametro. 
     * @param vo Los dato de la refacción. 
     */
    public boolean refaccionModificar(RefaccionVo vo){
        RefaccionDao d = new RefaccionDao(coordinador);
        return d.modificar(vo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DE REFACCIONES.
    ========================================================================
    */
    
     /* 
    ========================================================================
       INICIO REGISTRO DE IMAGENESREFACCION.
    ////////////////////////////////////////////////////////////////////////
    */
    public String imagenRefaccionGuardarLista (List<ImagenRefaccionVo> listaVo){
        ImagenRefaccionDao d = new ImagenRefaccionDao(coordinador);
        
        for (ImagenRefaccionVo vo : listaVo) {
            File renombrado = FicherosOperaciones.duplicarYRenombrar(vo.getFicheroImagen());
            vo.setNombreServidor(renombrado.getName());
            vo.setFicheroImagen(renombrado);
        }
        
        return d.guardarLista(listaVo);
    }
    
    public List<ImagenRefaccionVo> imagenRefaccionConsultar(int id){
        ImagenRefaccionDao d = new ImagenRefaccionDao(coordinador);
        return d.consultar(id);
    }
    
    public boolean imagenRefaccionEliminar(ImagenRefaccionVo vo){
        ImagenRefaccionDao d = new ImagenRefaccionDao(coordinador);
        return d.eliminar(vo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DE IMAGENESREFACCION
    ========================================================================
    */
     /* 
    ========================================================================
       INICIO REGISTRO DE IMAGENESPROVEEDOR.
    ////////////////////////////////////////////////////////////////////////
    */
    public String imagenProveedorGuardarLista (List<ImagenProveedorVo> listaVo){
        ImagenProveedorDao d = new ImagenProveedorDao(coordinador);
        
        for (ImagenProveedorVo vo : listaVo) {
            File renombrado = FicherosOperaciones.duplicarYRenombrar(vo.getFicheroImagen());
            vo.setNombreServidor(renombrado.getName());
            vo.setFicheroImagen(renombrado);
        }
        
        return d.guardarLista(listaVo);
    }
    
    public List<ImagenProveedorVo> imagenProveedorConsultar(int id){
        ImagenProveedorDao d = new ImagenProveedorDao(coordinador);
        return d.consultar(id);
    }
    
    public boolean imagenProveedorEliminar(ImagenProveedorVo vo){
        ImagenProveedorDao d = new ImagenProveedorDao(coordinador);
        return d.eliminar(vo);
    }
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DE IMAGENESPROVEEDOR
    ========================================================================
    */
     /* 
    ========================================================================
       INICIO REGISTRO RELACION REFACCION MAQUINA-MODELO
    ////////////////////////////////////////////////////////////////////////
    */

    /**
     * Guarda la lista de MaquinaModelo relacionada con una refaccion. 
     * @param listaVo La lista de maquina-modelo a guardar. 
     * @return  
     */
    public boolean relacionRefaccionMaquinaModeloGuardarLista(List<RelacionRefaccionMaquinaModeloVo> listaVo){
        RelacionRefaccionMaquinaModeloDao d = new RelacionRefaccionMaquinaModeloDao(coordinador);
        return d.guardarLista(listaVo);
    }
    
   /**
     * Actualiza la lista de máquinas relacionadas con una refacción.
     * @param lvo La lista de RelacionRefaccionMaquinaModeloVo que se quieren
     * actualizar. 
     * @return  
     */
    public boolean relacionRefaccionMaquinaModeloModificarLista(
            List<RelacionRefaccionMaquinaModeloVo> lvo){
        RelacionRefaccionMaquinaModeloDao d = new RelacionRefaccionMaquinaModeloDao(coordinador);
        return d.modificar(lvo);
    }
    
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO RELACION REFACCION MAQUINA-MODELO
    ========================================================================
    */
  
     /* 
    ========================================================================
       INICIO REGISTRO RELACION REFACCION PROVEEDOR
    ////////////////////////////////////////////////////////////////////////
    */

    /**
     * Guarda la lista de proveedores relacionados con una refaccion.
     * @param listaVo La lista de proveedores a guardar. 
     */

    public boolean relacionRefaccionProveedorGuardarLista(List<RelacionRefaccionProveedorVo> listaVo){
        RelacionRefaccionProveedorDao d = new RelacionRefaccionProveedorDao(coordinador);
        return d.guardarLista(listaVo);
    }
    
    /**
     * Actualiza la lista de máquinas relacionadas con una refacción. 
     * @param listaVo La lista de proveedores a actualizar. 
     */
    public boolean relacionRefaccionProveedorModificarLista(
            List<RelacionRefaccionProveedorVo> listaVo){
        RelacionRefaccionProveedorDao d = new RelacionRefaccionProveedorDao(coordinador);
        return d.modificar(listaVo);
     }
    
    
    
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO RELACION REFACCION PROVEEDOR
    ========================================================================
    */
    
  
     /* 
    ========================================================================
       INICIO DEPARTAMENTO
    ////////////////////////////////////////////////////////////////////////
    */
        public boolean departamentoGuardar(DepartamentoVo vo){
            DepartamentoDao d = new DepartamentoDao(coordinador);
            return d.guardar(vo);
            
        }
        
        public List<DepartamentoVo> departamentoConsultarTodo(){
            DepartamentoDao d = new DepartamentoDao(coordinador);
            return d.consultarTodo();
        
        }
    
    
     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO DEPARTAMENTO
    ========================================================================
    */
     /* 
    ========================================================================
       INICIO EMPLEADO
    ////////////////////////////////////////////////////////////////////////
    */
        
        
        public List<Validacion> empleadoValidarCampos(EmpleadoVo vo){
            return empleadoValidarCampos(vo, false);
        }

        public List<Validacion> empleadoValidarCampos(EmpleadoVo vo, boolean validandoUpdate){
            //LA LISTA QUE SE RETORNA DE VALIDACIONES.
            List<Validacion> listaValidaciones = new ArrayList<>();

            //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO.
            EmpleadoIT b = new EmpleadoIT();
            List<ParametrosDeCampo> listaPDC =b.getCAMPOS_PDC();
            //RECORREMOS CADA CAMPO.
            for (ParametrosDeCampo parametrosDeCampo : listaPDC) {
                try {
                    //----COMPROBAMOS QUE EL CAMPO NO ESTE NULO CUANDO ASÍ LO SOLICITA.

                    //EL NOMBRE DEL CAMPO QUE VAMOS A VALIDAR.

                    String nombreDelCampoActual = parametrosDeCampo.getNombre();
                    //EL VALOR QUE TIENE ACTUALMENTE EL CAMPO. ESTE MAPA CONTIENE
                    // LA FUNCION CALLABLE QUE RELACIONA EL NOMBRE DEL CAMPO CON EL 
                    // VALOR TOMADO ACTUALMENTE. SE DEFINE EN EL VO Y SE HEREDA DE
                    // VOGeneral.
                    String valorAValidar =vo.getRelacionCampo()
                            .get(nombreDelCampoActual).call()+ "";
                    if (!parametrosDeCampo.isNulo()) {
                        //EL OBJETO QUE SE VA A RETORNAR PARA SEÑALAR LOS ERRORES SOBRE LA GUI.
                        Validacion val = new Validacion();
                        //DEFINIMOS EL CAMPO QUE SE ESTA VALIDANDO.
                        val.setNombreDeCampo(parametrosDeCampo);

                        //COMPROBAMOS QUE A VO SE LE HAYA PASADO UN VALOR.
                        if (valorAValidar.isEmpty()) {
                            //DEFINIMOS EL MENSAJE EN ESTE CASO.
                            val.setMensajeDeError("No puede estar vacio.");
                            //GUADAMOS EL VALOR FALSE POR QUE NO SE HA DEFINIDO. 
                            val.setValido(false);

                        }else{
                            val.setValido(true);
                        }

                        listaValidaciones.add(val);

                    } 

                    if (!parametrosDeCampo.isPermiteRepetido() 
                            && !valorAValidar.isEmpty()) {
                        //VALIDAMOS LOS CAMPOS QUE NO PUEDEN REPETIRSE.
                        Validacion val = new Validacion();
                        val.setNombreDeCampo(parametrosDeCampo);
                        if (validandoUpdate) {
                            if (this.empleadoExiste(vo)) {
                                val.setMensajeDeError("El valor '"+vo.getNombre()
                                        +"' ya fue asignado a otro empleado.");
                                val.setValido(false);
                            }else{
                                val.setValido(true);
                            }
                        }else{
                            if (this.empleadoExiste(vo)) {
                                val.setMensajeDeError("El valor '"+valorAValidar
                                        +"' ya existe en la base." );
                                val.setValido(false);
                            }else{
                                val.setValido(true);
                            }
                        }
                        listaValidaciones.add(val);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        return listaValidaciones;
    }
        
    public boolean empleadoExiste(EmpleadoVo vo ){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.existe(vo);
    }
    public boolean empleadoGuardar(EmpleadoVo vo ){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.guardar(vo);
    }
    
    public boolean empleadoModificar(EmpleadoVo vo){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.modificar(vo);
    }
    
    public boolean empleadoDarDeBajaAlta(EmpleadoVo vo){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.darDeBajaAlta(vo);
    }
    public int empleadoConsultarUltimoId(){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.consultarUltimoId();
    }
    
    public List<EmpleadoVo> empleadoConsultarTodo(){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.consultarTodo();
    }
    public List<EmpleadoVo> empleadoConsultarTodoConBajas(){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.consultarTodoConBajas();
    }
    
    public List<EmpleadoVo> empleadoConsultarBusqueda(String busqueda){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.consultarBusqueda(busqueda);
    }
    
    public List<EmpleadoVo> empleadoConsultarBusquedaConBajas(String busqueda){
        EmpleadoDao d = new EmpleadoDao(coordinador);
        return d.consultarBusquedaConBajas(busqueda);
    }
      
    
     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO EMPLEADO
    ========================================================================
    */
    
     /* 
    ========================================================================
       INICIO ENTRADA LOTE
    ////////////////////////////////////////////////////////////////////////
    */
    public List<Validacion> entradaLoteValidarCampos(EntradaLoteVo vo){
        return entradaLoteValidarCampos(vo, false);
    }
    
    
    public List<Validacion> entradaLoteValidarCampos(EntradaLoteVo vo, boolean validandoUpdate){
        //LA LISTA QUE SE REORNA DE VALIDACIONES.
        List<Validacion> listaValidaciones = new ArrayList<>();
        
        //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO
        EntradaLoteIT b = new EntradaLoteIT();
        List<ParametrosDeCampo> listaPDC = b.getCAMPOS_PDC();
        
        //RECORREMOS CADA CAMPO.
        for (ParametrosDeCampo _PDC : listaPDC) {
            try {
                //---- COMPROBAMOS QUE EL CAMPO NO ESTE NULO CUANDO ASI LO SOLICITA.
                
                //EL NOMBRE DEL CAMPO QUE VAMOS A VALIDAR.
                
                String nombreDelCampoActual = _PDC.getNombre();
                //EL VALOR QUE TIENE ACTUALMENTE EL CAMPO. ESTE MAPA CONTIENE
                // LA FUNCION CALLABLE QUE RELACIONA EL NOMBRE DEL CAMPO CON EL 
                // VALOR TOMADO ACTUALMENTE. SE DEFINE EN EL VO Y SE HEREDA DE
                // VOGeneral.
                String valorAValidar =vo.getRelacionCampo()
                        .get(nombreDelCampoActual).call()+ "";
                if (!_PDC.isNulo()) {
                    //EL OBJETO QUE SE VA A RETORNAR PARA SEÑALAR LOS ERRORES SOBRE LA GUI.
                    Validacion val = new Validacion();
                    //DEFINIMOS EL CAMPO QUE SE ESTA VALIDANDO.
                    val.setNombreDeCampo(_PDC);

                    //COMPROBAMOS QUE A VO SE LE HAYA PASADO UN VALOR.
                    if (valorAValidar.isEmpty()|| valorAValidar.equals("-1")||valorAValidar.equals("-1.0")) {
                        //DEFINIMOS EL MENSAJE EN ESTE CASO.
                        val.setMensajeDeError("No puede estar vacio.");
                        //GUADAMOS EL VALOR FALSE POR QUE NO SE HA DEFINIDO. 
                        val.setValido(false);

                    }else{
                        val.setValido(true);
                    }

                    listaValidaciones.add(val);

                }
                
            } catch (Exception ex) {
                 Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listaValidaciones;
    }
    
    public boolean entradaLoteGuardar(EntradaLoteVo vo){
        EntradaLoteDao d = new EntradaLoteDao(coordinador);
        return d.guardar(vo);
                
    }
    
    public float entradaLoteExistencia(int id){
        EntradaLoteDao d = new EntradaLoteDao(coordinador);
        return d.existencia(id);
    }
    
    public List<EntradaLoteVo> entradaLoteLotes(int id, boolean cargarLotesVacios){
        EntradaLoteDao d = new EntradaLoteDao(coordinador);
        return d.lotes(id, cargarLotesVacios);
    }
    
    public EntradaLoteVo entradaLoteLoteMasAntiguo(int id){
        EntradaLoteDao d = new EntradaLoteDao(coordinador);
        return d.loteMasAntiguo(id);
    }
    
    
    
     /* 
    ////////////////////////////////////////////////////////////////////////
        FIN REGISTRO ENTRADA LOTE
    ========================================================================
    */
     /* 
    ========================================================================
       INICIO DE SALIDA LOTE
    ////////////////////////////////////////////////////////////////////////
*/
    public List<Validacion> salidaLoteValidarCampos(SalidaLoteVo vo){
       return salidaLoteValidarCampos(vo, false);
    }


    public List<Validacion> salidaLoteValidarCampos(SalidaLoteVo vo, boolean validandoUpdate){
           //LA LISTA QUE SE REORNA DE VALIDACIONES.
           List<Validacion> listaValidaciones = new ArrayList<>();

           //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO
           SalidaLoteIT b = new SalidaLoteIT();
           List<ParametrosDeCampo> listaPDC = b.getCAMPOS_PDC();

           //RECORREMOS CADA CAMPO.
           for (ParametrosDeCampo _PDC : listaPDC) {
               try {
                   //---- COMPROBAMOS QUE EL CAMPO NO ESTE NULO CUANDO ASI LO SOLICITA.

                   //EL NOMBRE DEL CAMPO QUE VAMOS A VALIDAR.

                   String nombreDelCampoActual = _PDC.getNombre();
                   //EL VALOR QUE TIENE ACTUALMENTE EL CAMPO. ESTE MAPA CONTIENE
                   // LA FUNCION CALLABLE QUE RELACIONA EL NOMBRE DEL CAMPO CON EL 
                   // VALOR TOMADO ACTUALMENTE. SE DEFINE EN EL VO Y SE HEREDA DE
                   // VOGeneral.
                   String valorAValidar =vo.getRelacionCampo()
                           .get(nombreDelCampoActual).call()+ "";
                   if (!_PDC.isNulo()) {
                       //EL OBJETO QUE SE VA A RETORNAR PARA SEÑALAR LOS ERRORES SOBRE LA GUI.
                       Validacion val = new Validacion();
                       //DEFINIMOS EL CAMPO QUE SE ESTA VALIDANDO.
                       val.setNombreDeCampo(_PDC);

                       //COMPROBAMOS QUE A VO SE LE HAYA PASADO UN VALOR.
                       if (valorAValidar.isEmpty()|| valorAValidar.equals("-1")||valorAValidar.equals("-1.0")) {
                           //DEFINIMOS EL MENSAJE EN ESTE CASO.
                           val.setMensajeDeError("No puede estar vacio.");
                           //GUADAMOS EL VALOR FALSE POR QUE NO SE HA DEFINIDO. 
                           val.setValido(false);

                       }else{
                           val.setValido(true);
                       }

                       listaValidaciones.add(val);

                   }

               } catch (Exception ex) {
                    Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
               }
           }
           return listaValidaciones;
        }
    
    /**
     * Validamos que sea el lote más antiguo. 
     * @param lotes
     * @param voActual Que esta seleccionado actualmente. 
     * @return La lista de validaciones. 
     */
    public Validacion salidaLoteValidarLotes(
            List<EntradaLoteVo> lotes,
            EntradaLoteVo voActual){
        
        EntradaLoteVo voMasAntiguo = lotes.get(0);
        
        Validacion valMasAntiguo = new Validacion();
        if (voActual.equals(voMasAntiguo)) {
            valMasAntiguo.setValido(true);
        }else{
            valMasAntiguo.setValido(false);
            valMasAntiguo.setMensajeDeError("Hay disponible un lote más antiguo que el tienes seleccionado.");
        }
        return valMasAntiguo;
    }     
        
        

    public boolean salidaLoteGuadar(List<SalidaLoteVo> vo){
        SalidaLoteDao d = new SalidaLoteDao(coordinador);
        return d.guardar(vo);

    }

//    public float salidaLoteExistencia(int id){
//        SalidaLoteDao d = new SalidaLoteDao(coordinador);
//        return d.existencia(id);
//    }
    
    public List<Validacion> salidaLoteCantidadADescontarDeLoteValidaciones(
            List<PanelSalidaLoteContenedorDeFila> list, BigDecimal totalSalida) {
        
        List<Validacion> listVal = new ArrayList<>();
        boolean loteConValorNegativo = false;
        Validacion v1 = new Validacion();
        v1.setNombreDeCampo("Existencia");
        String lotes = "";

        BigDecimal salidaDeTotalDeLotesParaComparacion = new BigDecimal(0);
        for (PanelSalidaLoteContenedorDeFila cF : list) {
            BigDecimal valExistenciaEti = new BigDecimal(cF.getEtiquetaExistencia().getText());
            if (valExistenciaEti.signum()==-1) {
                loteConValorNegativo = true;
                lotes+="\n"+cF.getCl().lote.getNombreParaMostrarLote();
            }
            
            salidaDeTotalDeLotesParaComparacion = 
                    salidaDeTotalDeLotesParaComparacion.add(
                            new BigDecimal(cF.getRecuadroEntrada().getText()));
        }
        
        if (loteConValorNegativo) {
            v1.setMensajeDeError(" Los siguientes lotes tienen valores negativos:"+lotes);
            v1.setValido(false);
        }else{
            v1.setValido(true);
        }
        listVal.add(v1);
        
        
        Validacion v2 = new Validacion();
        v2.setNombreDeCampo("Total negativo");
        if (totalSalida.signum()==-1) {
            v2.setValido(false);
            v2.setMensajeDeError("La suma de salida de los lotes es '"+salidaDeTotalDeLotesParaComparacion+"' y es mayor que\n"
                    + "la salida que ya habias definido '"+(salidaDeTotalDeLotesParaComparacion.add(totalSalida)).toString()+"'.");
        }else{
            v2.setValido(true);
        }
        listVal.add(v2);
        
        return listVal;
    }
    
    public boolean entradaloteActualizarLotes(List<EntradaLoteVo> listaELVParaActualizar) {
        EntradaLoteDao d = new EntradaLoteDao(coordinador);
        return d.actualizarLotes(listaELVParaActualizar);
        
    }
        
    /* 
    ////////////////////////////////////////////////////////////////////////
        FIN DE SALIDA LOTE
    ========================================================================
    */

    public List<ImportanciaVo> importanciaConsultar() {
        ImportanciaDao d = new ImportanciaDao(coordinador);
        return d.consultar();
    }

    /**
     * Retorna la lista de todas las máquinas existenten en la tabla maquina.  
     * @return 
     */
    public List<MaquinaVo> maquinaConsultar() {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.consultar();
    }

    /**
     * Elimina la máquina seleccionada y todo lo que este relacionada con ella. 
     * @param vo La máquina que se quiere eliminar. 
     * @return True si se elimino correctamente. 
     */
    public boolean maquinaEliminar(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.eliminar(vo);
    }
    
    
    /**
     * Comprueba si la refacción existe. A diferencia de {@see maquinaRepetido}
     * esta comprueba solo si la refacción que se le pase existe más de una vez
     * incluida la misma que se le pase.
     * 
     * Sirve para comprobar si se modifica la máquina o se agrega una nueva. 
     * 
     * @param vo La refacción que se comprobara si esta repetida. 
     * @return True si esta repetida. 
     */
    public boolean maquinaExiste(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.existe(vo);
    }

    public List<Validacion> maquinaValidadCampos(MaquinaVo vo) {
        
        MaquinaIT it = new MaquinaIT();
        List<ParametrosDeCampo> campos = it.getCAMPOS_PDC();
        List<Validacion> listVal = new ArrayList<>();
        for (ParametrosDeCampo campo : campos) {
            if (campo.getNombre().equals(it.getNUMERO_DE_MAQUINA().getNombre())) {
                if (vo.getId()==-1) {
                    Validacion a = new Validacion();
                    a.setNombreDeCampo(campo);
                    if (maquinaExiste(vo)) {
                        a.setValido(false);
                        a.setMensajeDeError("Este número ya esta registrado.");
                    } else {
                        a.setValido(true);
                    }
                    listVal.add(a);
                }else{
                    Validacion a = new Validacion();
                    a.setNombreDeCampo(campo);
                    if (maquinaRepetido(vo)) {
                        a.setValido(false);
                        a.setMensajeDeError("El número o nombre que asiganaste a la máquina ya esta relacionado con otra máquina.");
                    }else{
                        a.setValido(true);
                    }
                    listVal.add(a);
                }
            }
            
            
            if (campo.getNombre().equals(it.getMATRICULA().getNombre())) {
                //VALIDAMOS CUANDO ES UN NUEVO ELEMENTO A GUARDAR. 
                if (vo.getId()==-1) {
                    Validacion validacion = new Validacion();
                    validacion.setNombreDeCampo(campo);
                    if (maquinaExisteMatricula(vo)) {
                        validacion.setValido(false);
                        validacion.setMensajeDeError("Ya esta registrada esta matricula.");
                    }else{
                        validacion.setValido(true);
                    }
                    listVal.add(validacion);
                } else {
                    //VALIDAMOS CUANDO SE ESTA ACTUALIZANDO EL DATO. 
                    Validacion v = new Validacion();
                    v.setNombreDeCampo(campo);
                    if (maquinaRepetidoMatricula(vo)) {
                        v.setValido(false);
                        v.setMensajeDeError("La matricula que asignaste a la máquina ya esta relacionado con otra máquina.");
                    } else {
                        v.setValido(true);
                    }
                    listVal.add(v);
                }
            }
        }
        return listVal;
    }

    public boolean maquinaRepetido(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.repetido(vo);
        
    }

    /**
     * Modifca la refacción que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaModificar(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.modificar(vo);

    }

    /**
     * Guarda la máquina que se le pase como parametro. 
     * @param vo
     * @return
     */
    public boolean maquinaGuardar(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.guardar(vo);
    }

    /**
     * Almacena el nombre que fue modificado y guarda la fecha y hora en que se 
     * modifico. 
     * @param mhnVo El objeto que contiene los datos a alamcenar. 
     * @return True si se logro.
     */
    public boolean maquinaHistorialNombresGuardar(MaquinaHistorialNombresVO mhnVo) {
        MaquinaHistorialNombresDao d = new MaquinaHistorialNombresDao(coordinador);
        return d.guardar(mhnVo);

    }
    
    /**
     * Consulta todas las secciones que hay registradas. 
     * @return
     */
    public List<SeccionDeMaquinaVO> seccionDeMaquinaConsultar() {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.consultar();
    }
    
    /**
     * Guarda una sección de máquina en la BD.
     * @param sdmvo Los datos de la sección que se quieren guardar. 
     * @return True si todo fue correcto. 
     */
    public boolean seccionDeMaquinaGuardar(SeccionDeMaquinaVO sdmvo) {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.guardar(sdmvo);
    }

    /**
     * Retorna el último id en la tabla de secciones máquinas. 
     * @return El último id de la seccion;
     */
    public int seccionDeMaquinaUltimoId() {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.ultimoId();
    }
    
     /**
     * Guarda la relacion entre la refacción y la sección de máquina.  
     * @param listaRelacionSeccionDeMaquinaRefaccionVO La relación entre la sección
     * y la refacción.
     * @return True si todo fue correcto. 
     */
    public boolean refaccionRelacionSeccionMaquinaGuardar(List<RelacionSeccionDeMaquinaRefaccionVO> listaRelacionSeccionDeMaquinaRefaccionVO) {
        RelacionSeccionDeMaquinaRefaccionDAO d = new RelacionSeccionDeMaquinaRefaccionDAO(coordinador);
        return d.guardarRelacion(listaRelacionSeccionDeMaquinaRefaccionVO);
        

    }
    /**
     * Revisa que la mátricula que se le pase como parametro no este ya registradas.
     * @param vo La máquina con la matricula a revisar.
     * @return True si existe. 
     */
    public boolean maquinaExisteMatricula(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.existeMatricula(vo);
    }

    /**
     * Retorna true si la matrícula esta repetida para otra máquina exepto para
     * si misma. 
     * @param vo La máquina que se quiere revisar con su matricula.
     * @return True si esta repetida. 
     */
    public boolean maquinaRepetidoMatricula(MaquinaVo vo) {
        MaquinaDao d = new MaquinaDao(coordinador);
        return d.repetidoMatricula(vo);
    }

    /**
     * Consulta todas las refacciones que sean compatibles con la máquina modelo 
     * que se le pase como parametro. 
     * @param mmvo La máquina modelo que se quiere buscar. 
     * @return La lista de refacciones compatibles. 
     */
    public List<RefaccionVo> refaccionConsultarCompatiblesConMaquinaModelo(List<MaquinaModeloVo> mmvo) {
        RelacionRefaccionMaquinaModeloDao d = new RelacionRefaccionMaquinaModeloDao(coordinador);
        return d.consultarCompatiblesConMaquinaModelo(mmvo);

    }
    
    /**
     * Consulta todas las refacciones que sean compatibles con la máquina modelo 
     * que se le pase como parametro filtradas por el texto. s
     * @param mmvo La máquina modelo que se quiere buscar. 
     * @param texto 
     * @return La lista de refacciones compatibles. 
     */
    public List<RefaccionVo> refaccionConsultarCompatiblesConMaquinaModelo(List<MaquinaModeloVo> mmvo, String texto) {
        RelacionRefaccionMaquinaModeloDao d = new RelacionRefaccionMaquinaModeloDao(coordinador);
        return d.consultarCompatiblesConMaquinaModelo(mmvo, texto);
    }
    
    
    /**
     * Valida que la sección este correcta cuando hacemos un update. 
     * @param sdmvo Los datos de la sección.
     * @return El resultado de las validaciones. 
     */
    public List<Validacion> seccionDeMaquinaValidarUpdate(SeccionDeMaquinaVO sdmvo) {
        return seccionDeMaquinaValidar(sdmvo, true);
    }
    
    /**
     * Valida que la sección este correcta. 
     * @param sdmvo Los datos de la sección.
     * @return El resultado de las validaciones. 
     */
    public List<Validacion> seccionDeMaquinaValidar(SeccionDeMaquinaVO sdmvo) {
        return seccionDeMaquinaValidar(sdmvo, false);
    }
    
    /**
     * Valida que la sección este correcta. 
     * @param sdmvo Los datos de la sección.
     * @return El resultado de las validaciones. 
     */
    private List<Validacion> seccionDeMaquinaValidar(SeccionDeMaquinaVO sdmvo, boolean update) {
        List<Validacion> listVal = new ArrayList<>();
        for (ParametrosDeCampo parametrosDeCampo : SeccionDeMaquinaIT.getCAMPOS_PDC()) {
            
            if (parametrosDeCampo.getNombre().equals(SeccionDeMaquinaIT.getNOMBRE_SECCION().getNombre())) {
                Validacion val = new Validacion();
                val.setNombreDeCampo(parametrosDeCampo);

                if (sdmvo.getNombreSeccion().isEmpty()) {
                    val.setMensajeDeError("No has definido un nombre.");
                    val.setValido(false);
                } else {
                    //VALIDAMOS QUE NO ESTE REPETIDO EL NOMBRE. 
                    if (update) {
                        JOptionPane.showMessageDialog(null, "validando update:"+update);
                        //VALIDANDO CONTRA OTROS MENOS CONTRA SI.
                       if(seccionDeMaquinaNombreYaExiste(sdmvo)){
                           val.setMensajeDeError("El nombre ya fue asignado a otra sección.");
                           val.setValido(false);
                       }else{
                           val.setValido(true);
                       } 
                    }else{
                        //VALIDANDO QUE NO EXISTA EN LA TABLA. 
                        if (seccionDeMaquinaNombreRepetido(sdmvo)) {
                            val.setMensajeDeError("El nombre que proporcionaste ya esta registrado.");
                            val.setValido(false);
                        } else {
                            val.setValido(true);
                        }
                    }
                }
                listVal.add(val);
            }
        }
        return listVal;
    }
    
    

    /**
     * Consulta todas las refacciones que esten relacionadas con el id de seccion
     * que se le pase como parametro. 
     * @param idActual
     * @return La lista de refacciones compatibles con la sección.
     */
    public List<RefaccionVo> refaccionRelacionSeccionMaquinaConsultar(SeccionDeMaquinaVO idActual) {
        RelacionSeccionDeMaquinaRefaccionDAO d = new RelacionSeccionDeMaquinaRefaccionDAO(coordinador);
        return d.consultarRefacciones(idActual);
    }
    
    
    /**
     * Valida que el nombre de la sección que se le pase como parametro no este
     * ya registrado exceptuando la comprobación contra la refacción que se 
     * esta actualizando. 
     * @param sdmvo La sección que se quiere revisar que al cambiar el nombre
     * este no pertenezca a otra refacción.
     * @return True si existe. 
     */
    public boolean seccionDeMaquinaNombreYaExiste(SeccionDeMaquinaVO sdmvo) {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.nombreYaExiste(sdmvo);
        
    }

    /**
     * Valida que el nombre de la sección que se le pase como parametro no este
     * repetido. 
     * @param sdmvo La sección que se quiere revisar y que es nueva. 
     * @return True si ya se registro un nombre 
     */
    public boolean seccionDeMaquinaNombreRepetido(SeccionDeMaquinaVO sdmvo) {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.nombreRepetido(sdmvo);
    }

    /**
     * Actualiza una seccion de máquina. 
     * @param vo La sección que se quiere modificar. 
     * @return True si se modifico correctamente. 
     */
    public boolean seccionDeMaquinaUpdate(SeccionDeMaquinaVO vo) {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.update(vo);
        
    }

    /**
     * Actualiza la relación entre una sección de máquina y las refacciones que 
     * se le pasen como paramtro.
     * @param listRelacion Las nuevas relaciónes que se sustituiran a las anteriores. 
     * @return True si se modifico correctamente. 
     */
    public boolean refaccionRelacionSeccionMaquinaActualizar(List<RelacionSeccionDeMaquinaRefaccionVO> listRelacion) {
        RelacionSeccionDeMaquinaRefaccionDAO d = new RelacionSeccionDeMaquinaRefaccionDAO(coordinador);
        return d.actualizar(listRelacion);
    }

    public boolean seccionDeMaquinaEliminar(SeccionDeMaquinaVO vo) {
        SeccionDeMaquinaDAO d = new SeccionDeMaquinaDAO(coordinador);
        return d.eliminar(vo);
    }
    

    
    
}
