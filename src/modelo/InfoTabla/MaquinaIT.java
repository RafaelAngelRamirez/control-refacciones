package modelo.InfoTabla;

public class MaquinaIT extends ITGenerales{
    /**
    * El nombre de la tabla en la base de datos. 
    */
    public static final String NOMBRE_TABLA = "maquina";
    
    private static final ParametrosDeCampo idPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo idMaquinaModeloPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo numeroDeMaquinaPDC = new ParametrosDeCampo();
    private static final ParametrosDeCampo matriculaPDC = new ParametrosDeCampo();

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
        numeroDeMaquinaPDC.setLongitudDeCaracteres(50);
        numeroDeMaquinaPDC.setTipoDeDatos("varchar");
        numeroDeMaquinaPDC.setNulo(false);
        numeroDeMaquinaPDC.setAutoIncrement(false);
        numeroDeMaquinaPDC.setPermiteRepetido(false);
        numeroDeMaquinaPDC.setNombreParaMostrar("Número");
        
        matriculaPDC.setNombre("matricula");
        matriculaPDC.setLongitudDeCaracteres(200);
        matriculaPDC.setTipoDeDatos("varchar");
        matriculaPDC.setNulo(true);
        matriculaPDC.setAutoIncrement(false);
        matriculaPDC.setPermiteRepetido(false);
        matriculaPDC.setNombreParaMostrar("Matricula");
        

        camposPDC.add(idPDC);
        camposPDC.add(idMaquinaModeloPDC);
        camposPDC.add(numeroDeMaquinaPDC);
        camposPDC.add(matriculaPDC);
        
        
    }

    public ParametrosDeCampo getMatriculaPDC() {
        return matriculaPDC;
    }

    public void setMatriculaPDC(ParametrosDeCampo matriculaPDC) {
        this.matriculaPDC = matriculaPDC;
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
