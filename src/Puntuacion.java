import java.util.Scanner;

public class Puntuacion {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        String error = "Puntuación inválida";

        String[] equipoVS = new String[2];
        int[] marcador = new int[2];
        int[] resultadoPuntos = new int[2]; // acumulado de la liga (empieza en 0-0)

        // 1. Primero se piden los datos
        System.out.println("Equipo Local");
        equipoVS[0] = sc.nextLine();
        System.out.println("Equipo Visitante");
        equipoVS[1] = sc.nextLine();
        System.out.println("Puntos Local");
        marcador[0] = sc.nextInt();
        System.out.println("Puntos Visitante");
        marcador[1] = sc.nextInt();

        // 2. Después se valida y se calcula
        if (resultadoValido(marcador)) {
            int[] puntosPartido = puntosLiga(marcador);     // puntos de ESTE partido

            resultadoPuntos[0] += puntosPartido[0];  // se suman al acumulado
            resultadoPuntos[1] += puntosPartido[1];

            // 3. Y al final se muestra
            String ganador = "Local " + equipoVS[0] + " " + marcador[0] + " - " + marcador[1] + " " + equipoVS[1] + " Visitante";
            String clasificacion = "Clasificación " + equipoVS[0] + " " + resultadoPuntos[0] + " || " + "Clasificación " + equipoVS[1] + " " + resultadoPuntos[1];
            System.out.println(ganador);
            System.out.println(clasificacion);
        }
        else {
            System.out.println(error);
        }
    }

    public static boolean resultadoValido(int[] marcador) {
        int totalPuntos = marcador[0] + marcador[1];

        if (marcador[0] > 6 || marcador[0] < 0 || marcador[1] > 6 || marcador[1] < 0) {
            return false;
        }
        else if (totalPuntos == 7) {
            return marcador[0] == 4 || marcador[1] == 4;
        }
        else if (totalPuntos == 6) {
            return marcador[0] != marcador[1];
        }
        else {
            return false;
        }
    }

    // Solo calcula los puntos de liga de UN partido. No suma nada al acumulado.
    public static int[] puntosLiga(int[] marcador) {
        int[] puntos = new int[2];
        int totalPuntos = marcador[0] + marcador[1];

        if (totalPuntos == 7) {
            if (marcador[0] > marcador[1]) {
                puntos[0] = 2;
                puntos[1] = 1;
            }
            else {
                puntos[0] = 1;
                puntos[1] = 2;
            }
        }
        else if (marcador[0] == 4 && marcador[1] == 2) {
            puntos[0] = 2;
            puntos[1] = 1;
        }
        else if (marcador[1] == 4 && marcador[0] == 2) {
            puntos[0] = 1;
            puntos[1] = 2;
        }
        else if (marcador[0] > marcador[1]) {
            puntos[0] = 3;
        }
        else {
            puntos[1] = 3;
        }
        return puntos;
    }
}