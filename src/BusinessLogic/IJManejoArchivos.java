package BusinessLogic;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IJManejoArchivos {
    public void eliminarElementoDelArchivo(String nombreArchivo, String elementoAEliminar) {
        try {
            List<String> lineas = new ArrayList<>();
            File archivo = new File(nombreArchivo);

            // Leer todas las líneas del archivo
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    lineas.add(linea);
                }
            }

            // Eliminar la primera instancia del elemento especificado
            lineas.remove(elementoAEliminar);

            // Volver a escribir todas las líneas en el archivo
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
                for (String linea : lineas) {
                    bw.write(linea);
                    bw.newLine();
                }
            }

            //System.out.println("Se eliminó el primer '" + elementoAEliminar + "' del archivo.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        public void leerArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("Contenido del archivo:");

            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void eliminarArchivo(String nombreArchivo) {
        File archivo = new File(nombreArchivo);

        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("El archivo ha sido eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe.");
        }
    }
}
