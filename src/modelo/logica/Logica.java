/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.logica;

import controlador.Coordinador;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.FicherosOperaciones;
import modelo.InfoTabla.MaquinaModeloIT;
import modelo.InfoTabla.ProveedorIT;
import modelo.dao.PaisDao;
import modelo.InfoTabla.ParametrosDeCampo;
import modelo.InfoTabla.RefaccionIT;
import modelo.InfoTabla.RelacionRefaccionMaquinaModeloIT;
import modelo.InfoTabla.RelacionRefaccionProveedorIT;
import modelo.dao.ImagenProveedorDao;
import modelo.dao.ImagenRefaccionDao;
import modelo.dao.MaquinaModeloDao;
import modelo.dao.MaterialDao;
import modelo.dao.ProveedorDao;
import modelo.dao.RefaccionDao;
import modelo.dao.RelacionRefaccionMaquinaModeloDao;
import modelo.dao.RelacionRefaccionProveedorDao;
import modelo.dao.UnidadDao;
import modelo.vo.ImagenProveedorVo;
import modelo.vo.ImagenRefaccionVo;
import modelo.vo.MaquinaModeloVo;
import modelo.vo.MaterialVo;
import modelo.vo.PaisVo;
import modelo.vo.ProveedorVo;
import modelo.vo.RefaccionVo;
import modelo.vo.RelacionRefaccionMaquinaModeloVo;
import modelo.vo.RelacionRefaccionProveedorVo;
import modelo.vo.UnidadVo;

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
     */
    public void proveedorGuardar(ProveedorVo vo){
        ProveedorDao proveedor = new ProveedorDao(coordinador);
        proveedor.guardar(vo);
                
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
     * Consulta la lista de todos los proveedores y solo devuelve al proveedor-
     * empresa que se filtre como parametro.
     * 
     * @param id El id del proveedor a filtrar. 
     * @return La lista coincidente de proveedores.
     */
    public List<RelacionRefaccionProveedorVo> proveedorConsultarMarcas(int id){
        RelacionRefaccionProveedorDao dao = new RelacionRefaccionProveedorDao(coordinador);
        return dao.consultarProveedores(id);
        
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
        List<ParametrosDeCampo> listaPDC =b.getCamposPDC();
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
   
    public void paisGuardar(PaisVo vo){
        PaisDao paisDao_ = new PaisDao(coordinador);
        paisDao_.guardar(vo);
        
    
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
     * Revisa si la maquinaModelo en la base de datos. Se busca por conincidencia
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
     * Valida los campos según la definición que se le da en la clase Dao en la
     * lista de tipo ParametrosDeCampo.
     * @param vo - La información que vamos a validad. 
     * @return La lista de campos validados con error.
     */
    public List<Validacion> maquinaModeloValidarCampos (MaquinaModeloVo vo){
        //LA LISTA QUE SE RETORNA DE VALIDACIONES.
        List<Validacion> listaValidaciones = new ArrayList<>();
        
        //LOS CAMPOS DE LA TABLA RECORRIDOS UNO POR UNO.
        MaquinaModeloIT b = new MaquinaModeloIT();
        List<ParametrosDeCampo> listaPDC =b.getCamposPDC();
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
                    if (this.maquinaModeloExiste(valorAValidar, anio)) {
                        val.setMensajeDeError("El valor '"+valorAValidar+"' "
                                + "y '"+ anio+"' ya están registrados." );
                        val.setValido(false);
                    }else{
                        val.setValido(true);
                        val.setMensajeDeError("todo bien");
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
    
    public void unidadGuardar(UnidadVo vo){
        UnidadDao dao = new UnidadDao(coordinador);
        dao.guardar(vo);
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
    public void materialGuardar(MaterialVo vo){
        MaterialDao dao = new MaterialDao(coordinador);
        dao.guardar(vo);
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
        RefaccionIT rIT = new RefaccionIT();
        List<ParametrosDeCampo> listaPDC =rIT.getCamposPDC();
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
                        if (_PDC.getNombre().equals(rIT.getImportanciaPDC().getNombre())) {
                            //MENSAJE PARA IMPORTANCIA.
                            vNulo.setMensajeDeError("Debes definir la importancia de la refacción.");
                            ningunoDeLosAnteriores = false;
                        }
                        if(_PDC.getNombre().equals(rIT.getIdMaterialPDC().getNombre())){
                            //MENSAJE PARA MATERIAL.
                            vNulo.setMensajeDeError("Debes registrar un material");
                            ningunoDeLosAnteriores = false;
                        }
                        if(_PDC.getNombre().equals(rIT.getUnidadPDC().getNombre())){
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
                     if (_PDC.getNombre().equals(rIT.getCodigoInternoPDC().getNombre())) {
                         if (validandoUpdate) {
                         //SI ESTAMOS VALIDANDO UNA MODIFICAION ENTRA AQUI.
                            if (this.refaccionExisteCodigoInterno(vo)) {
                                vRepetido.setMensajeDeError(" Otra refacción ya tiene asignado este código.\n"
                                        + "Cambialo por uno diferente o modifica la refación que lo tiene asignado.");
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
                if (_PDC.getNombre().equals(rIT.getStockMaximoPDC().getNombre())) {
                    String smax = vo.getRelacionCampo().get(
                            rIT.getStockMaximoPDC().getNombre()).call()+"";
                    String smin = vo.getRelacionCampo().get(
                            rIT.getStockMinimoPDC().getNombre()).call()+"";
                    if (!smax.equals("-1.0") && !smin.equals("-1.0")) {
                        float fmax = Float.parseFloat(smax);
                        float fmin = Float.parseFloat(smin);
                        
                        if (fmax<fmin) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(rIT.getStockMaximoPDC());
                            val.setMensajeDeError(
                                    "El stock máximo("+fmax+") no puede ser menor "
                                    + "\nque el stock mínimo("+fmin+")");
                            val.setValido(false);
                            listaValidaciones.add(val);
                        }else if (fmax==fmin && fmax!=0 && fmin!=0) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(rIT.getStockMaximoPDC());
                            val.setMensajeDeError(
                                    "El stock máximo no puede ser igual"
                                    + "\nque el stock mínimo.");
                            val.setValido(false);
                            listaValidaciones.add(val);
                        }
                        
                        if (fmin==0) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(rIT.getStockMinimoPDC());
                            val.setMensajeDeError(
                                    "El stock mínimo no puede 0.");
                            val.setValido(false);
                            listaValidaciones.add(val);
                        }
                        
                        if (fmax==0) {
                            Validacion val = new Validacion();
                            val.setNombreDeCampo(rIT.getStockMaximoPDC());
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
        RelacionRefaccionMaquinaModeloIT it = new RelacionRefaccionMaquinaModeloIT();
        val.setNombreDeCampo(it.getIdMaquinaModeloPDC());
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
        val.setNombreDeCampo(it.getIdProveedorPDC());
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
    
    public void refaccionGuardar(RefaccionVo vo){
        RefaccionDao d = new RefaccionDao(coordinador);
        d.guardar(vo);
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
    public void refaccionModificar(RefaccionVo vo){
        RefaccionDao d = new RefaccionDao(coordinador);
        d.modificar(vo);
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
    
    public void imagenRefaccionEliminar(ImagenRefaccionVo vo){
        ImagenRefaccionDao d = new ImagenRefaccionDao(coordinador);
        d.eliminar(vo);
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
    
    public void imagenProveedorEliminar(ImagenProveedorVo vo){
        ImagenProveedorDao d = new ImagenProveedorDao(coordinador);
        d.eliminar(vo);
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
     */
    public void relacionRefaccionMaquinaModeloGuardarLista(List<RelacionRefaccionMaquinaModeloVo> listaVo){
        RelacionRefaccionMaquinaModeloDao d = new RelacionRefaccionMaquinaModeloDao(coordinador);
        d.guardarLista(listaVo);
    }
    
   /**
     * Actualiza la lista de máquinas relacionadas con una refacción.
     * @param lvo La lista de RelacionRefaccionMaquinaModeloVo que se quieren
     * actualizar. 
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

    public void relacionRefaccionProveedorGuardarLista(List<RelacionRefaccionProveedorVo> listaVo){
        RelacionRefaccionProveedorDao d = new RelacionRefaccionProveedorDao(coordinador);
        d.guardarLista(listaVo);
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
    
    
    
}
