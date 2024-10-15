package co.allura.view;

import java.util.List;
import java.util.Scanner;

public class View {
    Scanner sc = new Scanner(System.in);

    public View() {

    }

    public void print(String message) {
        System.out.println(message);
    }
    public String readLine() {
        return sc.next();
    }
    public int readInt() {
        return sc.nextInt();
    }
    public double readDouble() {
        return sc.nextDouble();
    }
    public void println(String message) {
        System.out.print(message);
    }
    public void printMessage() {
        System.out.println(" Digita Alguna de las monedas disponibles " +
                "USD --- Dólar Estadounidense\n" +
                "                    ARS --- Peso Argentino\n" +
                "                    BRL --- Real Brasileño\n" +
                "                    NOK --- Kron noruego\n" +
                "                    HKD  ---Dolar Hong Kong\n" +
                "                    COP --- Peso Colombiano\n" +
                "                    EUR --- Euro "

        );
    }
    public void printList(List<Double> listaMonedas) {
        System.out.println("Monedas convertidas:");
        if (listaMonedas.isEmpty()) {
            System.out.println("No hay conversiones realizadas.");
        } else {
            for (int i = 0; i < listaMonedas.size(); i++) {
                System.out.println("Conversión " + (i + 1) + ": " + listaMonedas.get(i));
            }
        }
    }

}
