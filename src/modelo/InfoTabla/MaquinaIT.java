package modelo.InfoTabla;

public class MaquinaIT extends ITGenerales{
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "maquina";
    
    private ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private ParametrosDeCampo idMaquinaModeloPDC = new ParametrosDeCampo();
    private ParametrosDeCampo numeroDeMaquinaPDC = new ParametrosDeCampo();

    public MaquinaIT() {
        
        idPDC.setNombre("id");
        idPDC.setLongitudDeCaracteres(11);
        idPDC.setTipoDeDatos("int");
        idPDC.setNulo(false);
        idPDC.setAutoIncrement(true);
        idPDC.setPermiteRepetido(false);
        
        idMaquinaModeloPDC.setNombre("idMaquinaModelo");
        idMaquinaModeloPDC.setLongitudDeCaracteres(11);
        idMaquinaModeloPDC.setTipoDeDatos("int");
        idMaquinaModeloPDC.setNulo(false);
        idMaquinaModeloPDC.setAutoIncrement(false);
        idMaquinaModeloPDC.setPermiteRepetido(true);
        idMaquinaModeloPDC.setNombreParaMostrar("Modelo de máquina");
        
        
        numeroDeMaquinaPDC.setNombre("nombre");
        numeroDeMaquinaPDC.setNombreParaMostrar("Número");
        numeroDeMaquinaPDC.setLongitudDeCaracteres(50);
        numeroDeMaquinaPDC.setTipoDeDatos("varchar");
        numeroDeMaquinaPDC.setNulo(false);
        numeroDeMaquinaPDC.setAutoIncrement(false);
        numeroDeMaquinaPDC.setPermiteRepetido(false);
        numeroDeMaquinaPDC.setNombreParaMostrar("Número");
        

        camposPDC.add(idPDC);
        camposPDC.add(idMaquinaModeloPDC);
        camposPDC.add(numeroDeMaquinaPDC);
        
        
    }

    public ParametrosDeCampo getIdPDC() {
        return idPDC;
    }

    public void setIdPDC(ParametrosDeCampo idPDC) {
        this.idPDC = idPDC;
    }

    public ParametrosDeCampo getIdMaquinaModeloPDC() {
        return idMaquinaModeloPDC;
    }

    public void setIdMaquinaModeloPDC(ParametrosDeCampo idMaquinaModeloPDC) {
        this.idMaquinaModeloPDC = idMaquinaModeloPDC;
    }
    public ParametrosDeCampo getNumeroDeMaquinaPDC() {
        return numeroDeMaquinaPDC;
    }

    public void setNumeroDeMaquinaPDC(ParametrosDeCampo numeroDeMaquinaPDC) {
        this.numeroDeMaquinaPDC = numeroDeMaquinaPDC;
    }
    
    
    
    
}
