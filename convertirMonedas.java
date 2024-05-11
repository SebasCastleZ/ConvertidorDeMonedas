import com.google.gson.annotations.SerializedName;

import javax.crypto.spec.PSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class convertirMonedas {

    @SerializedName("base_code")
    String valorDeLaMonedaBuscada;
    @SerializedName("target_code")
    String valordeLaMonedaSolicitada;
    @SerializedName("conversion_rate")
    String valordeLaMonedaConvertida;


    public void datosDeRecordaClase(obtenerDatos obtenerDatosOmdb) {
        this.valordeLaMonedaSolicitada = obtenerDatosOmdb.target_code();
        this.valorDeLaMonedaBuscada = obtenerDatosOmdb.base_code();

        if (valorDeLaMonedaBuscada.contains("null") || valordeLaMonedaSolicitada.contains("null")) {
            System.out.println("Moneda no ENCONTRADA");

        }
    }

}
