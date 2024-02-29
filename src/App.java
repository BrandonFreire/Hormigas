import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        JIHormigaReina hormigaReina = new JIHormigaReina("REINA");
        // List<String> listLarvas = hormigaReina.IFLarvas();
        // System.out.println(listLarvas);
        IJManejoArchivos manejoArchivos = new IJManejoArchivos();
        manejoArchivos.eliminarElementoDelArchivo("src/setAlimento.txt", "Carnivoro");
        manejoArchivos.leerArchivo("src/setAlimento.txt");
    }
}
