package BusinessLogic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import BusinessLogic.JIInterfaz.IPFHormiga;

public class PFHormiga implements IPFHormiga {
    private String PFNombreClasificacion;
    private ArrayList<String> PFAlimentos;
    public PFLarvaConAlimento pfLarvaConAlimento;
    private List<PFLarvaConAlimento> listaLarvasConAlimentos;
    private boolean bandera;
    private IJManejoArchivos manejoArchivos;

    public boolean isBandera() {
        return bandera;
    }

    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }

    public String getPFNombreClasificacion() {
        return PFNombreClasificacion;
    }

    public void setPFNombreClasificacion(String pFNombreClasificacion) {
        PFNombreClasificacion = pFNombreClasificacion;
    }

    public PFHormiga(PFTiposHormiga tiposHormiga) {
        listaLarvasConAlimentos = new ArrayList<>();
        PFAlimentos = new ArrayList<>();
        manejoArchivos = new IJManejoArchivos();
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
        if ((!PFAlimentos.isEmpty())) {
            bandera = true;
        } else {
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
                        manejoArchivos.eliminarElementoDelArchivo("src/setAlimento.txt", alimento);
                        listaLarvasConAlimentos.add(new PFLarvaConAlimento(pfLarva, alimento));
                        setBandera(true);
                    } else {
                        System.out.println("No hay alimentos disponibles para la larva " + numLarva);
                    }
                }
                numLarva++;
            }
            escribirArchivoLarvaClasificacion(listaLarvasConAlimentos);
            System.out.println("***************************************");
            System.out.println("Las larvas alimentadas son:");
            manejoArchivos.leerArchivo("src/LarvaClasificacion.txt");
        } else {
            System.out.println("No hay larvas para alimentar.");
        }
    }

    private void PFAsignarAlimento(String larva, String alimento) {
        System.out.println("Asignando " + alimento + " a " + larva);
    }

    public void imprimirListaLarvasConAlimentos(List<PFLarvaConAlimento> listaLarvasConAlimentos) {
        System.out.println("Lista de larvas con sus alimentos:");
        for (PFLarvaConAlimento larvaConAlimento : listaLarvasConAlimentos) {
            System.out
                    .println("Larva: " + larvaConAlimento.getLarva() + ", Alimento: " + larvaConAlimento.getAlimento());
        }
    }

    private void escribirArchivoLarvaClasificacion(List<PFLarvaConAlimento> listaLarvasConAlimentos) {
        String nombreArchivo = "src/LarvaClasificacion.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (PFLarvaConAlimento larvaConAlimento : listaLarvasConAlimentos) {
                String clasificacion = obtenerClasificacion(larvaConAlimento.getAlimento());
                writer.write(larvaConAlimento.getLarva() + ";" + larvaConAlimento.getAlimento() + ";" + clasificacion);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private String obtenerClasificacion(String alimento) {
        // Asignar "Rastreadora" si el alimento es "Hervivoro", de lo contrario, muere
        return alimento.equalsIgnoreCase("Herbivoro") ? "Rastreadora" : "Muerta";
    }

    public List<PFLarvaConAlimento> PFObtenerYEliminarRastreadorasDesdeArchivo() {
        String nombreArchivo = "LarvaClasificacion.txt";
        List<PFLarvaConAlimento> listaRastreadoras = new ArrayList<>();
        List<PFLarvaConAlimento> listaLarvas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length == 3) {
                    String larva = partes[0];
                    String alimento = partes[1];
                    String clasificacion = partes[2];

                    listaLarvas.add(new PFLarvaConAlimento(larva, alimento, clasificacion));

                    // Verificar si la clasificación es "Rastreadora"
                    if (clasificacion.equals("Rastreadora")) {
                        listaRastreadoras.add(new PFLarvaConAlimento(larva, alimento, clasificacion));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Eliminar las larvas con clasificación "Rastreadora" del archivo
        PDEliminarRastreadorasDelArchivo(nombreArchivo, listaRastreadoras);

        return listaRastreadoras;
    }

    private void PDEliminarRastreadorasDelArchivo(String nombreArchivo, List<PFLarvaConAlimento> listaRastreadoras) {
        for (PFLarvaConAlimento rastreadora : listaRastreadoras) {
            manejoArchivos.eliminarElementoDelArchivo(nombreArchivo, rastreadora.getLarva() + ";" + rastreadora.getAlimento() + ";" + rastreadora.getPfClasificacion());
        }
    }

    public void PFLarvas40(){
        
    }
}
