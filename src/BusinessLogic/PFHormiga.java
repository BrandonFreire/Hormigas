package BusinessLogic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public List<String> PFLarvas(int cantidad) {
        List<String> listLarvas = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < cantidad; i++) {
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
        boolean bandera = true;
        if ((!PFAlimentos.isEmpty())){
            bandera = true;
        }else{
            bandera = false;
        }
        return true;
    }
 
    public void pfDarComer(List<String> PFLarvas) {
        Random PFRandom = new Random();
        int numLarva = 1;
        for (String pfLarva : PFLarvas) {
            if (comer()) {
                System.out.println("Alimentado a la larva "+numLarva);
                int indiceAleatorio = PFRandom.nextInt(PFAlimentos.size());
                String alimento = PFAlimentos.get(indiceAleatorio);
                PFAsignarAlimento(pfLarva, alimento);
            }
            numLarva++;
        }
    }

    private void PFAsignarAlimento(String larva, String alimento) {
        System.out.println("Asignando " + alimento + " a " + larva);
    }
}
