public class JIHormigaReina {
    private String nombreClasificacion;

    public JIHormigaReina(String nombreClasificacion) {
        if ( IJValidarClasificacion(nombreClasificacion)) {
            this.nombreClasificacion = nombreClasificacion;
        }
    }

    public boolean IJValidarClasificacion(String nombreClasificacion){
        Boolean bandera = true;
        String nombreMin = nombreClasificacion.toLowerCase();
        if (nombreMin.equals("reina")){
            bandera = true;
        }
        return bandera;
    }

    public void IFLarvas(){
        
    }
}
