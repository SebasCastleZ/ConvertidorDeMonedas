import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.function.IntConsumer;

public class Monedas {

    public obtenerDatos todasLasMonedas(String moneda) throws IOException, InterruptedException {
        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/5979acb143978a757a3389ee/latest/"+moneda );
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    return null;
    }

    public obtenerDatos solicitarConversion (String moneda,String moneda2) throws IOException, InterruptedException {
        URI direccion= URI.create("https://v6.exchangerate-api.com/v6/5979acb143978a757a3389ee/pair/"+moneda+"/"+moneda2 );
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        //codigo para convertir la primera letra en Mayuscula detro de l record
        /*
        Gson Gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
        */
        //convertirMonedas mostrardatos = new convertirMonedas();
        //System.out.println(mostrardatos.valorDeLaMonedaBuscada);

        obtenerDatos mostrar = new Gson().fromJson(response.body(), obtenerDatos.class);

       // mostrardatos.datosDeRecordaClase(mostrar);
        return new Gson().fromJson(response.body(), obtenerDatos.class);
    }
}
