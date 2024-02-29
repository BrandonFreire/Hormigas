package BusinessLogic;
public class PFLarvaConAlimento {
    private String pfLarva;
    private String pfAlimento;
    private String pfClasificacion;

    public PFLarvaConAlimento(String pfLarva, String pfAlimento) {
        this.pfLarva = pfLarva;
        this.pfAlimento = pfAlimento;
    }
    
    public PFLarvaConAlimento(String pfLarva, String pfAlimento, String pfClasificacion) {
        this.pfLarva = pfLarva;
        this.pfAlimento = pfAlimento;
        this.pfClasificacion= pfClasificacion;
    }

    public String getLarva() {
        return pfLarva;
    }

    public String getAlimento() {
        return pfAlimento;
    }
    
    public String getPfClasificacion() {
        return pfClasificacion;
    }
}
