import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.String.valueOf;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        ArrayList<Object> lista = new ArrayList<>();
        Monedas solicitud = new Monedas();
        String respuesta= "";
        String moneda = "";
        String moneda2 = "";
        int monto=0;
        double calculo=0;

        do {
                //moneda 1
                System.out.println("Ingrese Moneda");
                    moneda=lectura.nextLine().toUpperCase();
                    lista.add("Moneda Local: "+moneda);

                //monto a convertir
                System.out.println("ingrese el monto de monedas a convertir");
                monto =  Integer.parseInt(lectura.nextLine());

                //moneda 2
                System.out.println("Ingrese 2 Moneda a obtener el valor");
                System.out.println("si desea saber el valor equivalente en todas las monedas ESCRIBA ALL o all ");
                moneda2=lectura.nextLine().toUpperCase();
                lista.add("Moneda Solicitada: "+moneda2);
                //

                if (moneda2.equals("ALL")) {
                    Monedas consulta = new Monedas();
                    System.out.println(consulta.todasLasMonedas(moneda));
                } else {
                    obtenerDatos obtenerValor = solicitud.solicitarConversion(moneda, moneda2);
                    System.out.println(obtenerValor);
                    try {
                        double conversion =  (double)obtenerValor.conversion_rate();
                        calculo= conversion * monto;
                        lista.add("Conversion:" + conversion);
                        lista.add("calculo del monto total de las monedas convertidas: " + (Object)calculo);
                    }catch (NullPointerException e){
                        e.getMessage();
                        System.out.println("Valor no encontrado");
                    }catch (InputMismatchException e){
                        e.getMessage();
                        System.out.println("Valor no encontrado u tipo de valor no aceptado");
                    }
                }


            System.out.println("Escriba Salir para finalizar el programa");
                respuesta = lectura.nextLine();
            if (respuesta.equals("SALIR")) {
                break;
            }
        }while(true);
        GenerarJson archivo = new GenerarJson();
        archivo.generarJson(lista);
        System.out.println("Gracias por usar el programa");
    }
}
