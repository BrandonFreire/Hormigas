import java.util.ArrayList;
import java.util.List;

import BusinessLogic.PFHormiga;

public class App {
    public static void main(String[] args) throws Exception {
        //JIHormiga hormigaReina = new JIHormiga();
        PFHormiga hormigaReina = new PFHormiga(PFHormiga.PFTiposHormiga.Reina);
        PFHormiga hormigaLarva = new PFHormiga(PFHormiga.PFTiposHormiga.Larva);
        //hormigaLarva.IFLarvas();
        //System.out.println(hormigaLarva.PFLarvas());
        hormigaLarva.pfDarComer(hormigaLarva.PFLarvas(40));

        // System.out.println(listLarvas);

        // IJManejoArchivos manejoArchivos = new IJManejoArchivos();
        // manejoArchivos.eliminarElementoDelArchivo("src/setAlimento.txt", "Carnivoro");
        // manejoArchivos.leerArchivo("src/setAlimento.txt");
    }
}
