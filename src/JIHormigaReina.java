import java.util.ArrayList;
import java.util.List;

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

    public List<String> IFLarvas(){
        List<String> listLarvas = new ArrayList<>();
        int num=1;
        for (int i = 0; i < 40; i++) {
            listLarvas.add("Larva "+num);
            num++;
        }
        return listLarvas;
    }
}
