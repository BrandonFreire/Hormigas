package BusinessLogic;

public class PFHormigaDTO {
    private String PFIdHormiga;
    private String PFCodigo;
    private String PFClasificacion; 
    //comio
    private String PFEstado;

    public PFHormigaDTO(String pFIdHormiga, String pFCodigo, String pFClasificacion, String pFEstado) {
        this.PFIdHormiga = pFIdHormiga;
        this.PFCodigo = pFCodigo;
        this.PFClasificacion = pFClasificacion;
        this.PFEstado = pFEstado;
    }

    public String getPFIdHormiga() {
        return PFIdHormiga;
    }
    public void setPFIdHormiga(String pFIdHormiga) {
        PFIdHormiga = pFIdHormiga;
    }
    public String getPFCodigo() {
        return PFCodigo;
    }
    public void setPFCodigo(String pFCodigo) {
        PFCodigo = pFCodigo;
    }
    public String getPFClasificacion() {
        return PFClasificacion;
    }
    public void setPFClasificacion(String pFClasificacion) {
        PFClasificacion = pFClasificacion;
    }
    public String getPFEstado() {
        return PFEstado;
    }
    public void setPFEstado(String pFEstado) {
        PFEstado = pFEstado;
    }

    
}
