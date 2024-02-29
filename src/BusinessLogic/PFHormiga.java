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

    public List<String> PFLarvas() {
        List<String> listLarvas = new ArrayList<>();
        int num = 1;
        for (int i = 0; i < PFAlimentos.size(); i++) {
            listLarvas.add("Larva " + num);
            num++;
        }
        return listLarvas;
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
 
    public void pfDarComer() {
        List<String> larvas = PFLarvas(); 
        if (!larvas.isEmpty()) { 
            Random PFRandom = new Random();
            int numLarva = 1;
    
            for (String pfLarva : larvas) {
                if (comer()) {
                    System.out.println("Alimentado a la larva " + numLarva);
                    
                    if (!PFAlimentos.isEmpty()) { // Verificar si hay alimentos disponibles
                        int indiceAleatorio = PFRandom.nextInt(PFAlimentos.size());
                        String alimento = PFAlimentos.get(indiceAleatorio);
                        PFAsignarAlimento(pfLarva, alimento);
    
                        // Quitar el alimento de la lista (si se desea)
                        PFAlimentos.remove(indiceAleatorio);
                    } else {
                        System.out.println("No hay alimentos disponibles para la larva " + numLarva);
                    }
                }
                numLarva++;
            }
        } else {
            System.out.println("No hay larvas para alimentar.");
        }
    }
    

    private void PFAsignarAlimento(String larva, String alimento) {
        System.out.println("Asignando " + alimento + " a " + larva);
    }
}
