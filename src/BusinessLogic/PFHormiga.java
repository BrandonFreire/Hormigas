package BusinessLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import BusinessLogic.JIInterfaz.IPFHormiga;

public class PFHormiga implements IPFHormiga {
    private String PFNombreClasificacion;
    private ArrayList<String> PFAlimentos;

    public String getPFNombreClasificacion() {
        return PFNombreClasificacion;
    }

    public void setPFNombreClasificacion(String pFNombreClasificacion) {
        PFNombreClasificacion = pFNombreClasificacion;
    }

    // public ArrayList<String> getPFAlimentos() {
    //     return PFAlimentos;
    // }

    // public void setPFAlimentos(ArrayList<String> pFAlimentos) {
    //     PFAlimentos = pFAlimentos;
    // }

    public PFHormiga(PFTiposHormiga tiposHormiga) {
        PFAlimentos = new ArrayList<>();
        switch (tiposHormiga) {
            case Reina:
                this.PFNombreClasificacion = "reina";
                break;
            case Zangano:
                this.PFNombreClasificacion = "zangano";
                break;
            case Soldado:
                this.PFNombreClasificacion = "soldado";
                break;
            case Rastreadora:
                this.PFNombreClasificacion = "rastreadora";
                break;
            case Larva:
                this.PFNombreClasificacion = "larva";
                break;

            default:
                break;
        }

    }

    // Enum PFTiposHormiga
    public enum PFTiposHormiga {
        Reina,
        Zangano,
        Soldado,
        Rastreadora,
        Larva
    }

    public List<String> PFLarvas() {
        List<String> listLarvas = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < 40; i++) {
            listLarvas.add("Larva " + num);
            num++;
        }
        return listLarvas;
    }

    public void pfCargarAlimentos(String PFNombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(PFNombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Convertir la línea a un tipo de hormiga y agregar a la lista
                PFAlimentos.add(linea.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean comer() {
        return true;
    }

    public void pfDarComer() {

    }
}
