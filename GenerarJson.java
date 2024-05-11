import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GenerarJson {
    public void generarJson(ArrayList<Object> lista) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            FileWriter archivo = new FileWriter("Conversiones.txt");
            archivo.write(gson.toJson(lista));
            archivo.close();
        } catch (IOException e) {
            System.out.println("Error al generar el archivo");
        }
    }
}
