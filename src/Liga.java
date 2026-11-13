import java.util.Scanner;

public class Liga {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String[] equipos = {"CORDOBA 6 A 8 'A'", "CTM CIUDAD DE UBEDA", "CAJA RURAL DE BAENA TM", "CD SAFA ANDÚJAR-KANINA BIKE TM", "CTM SIERRA DE SEGURA", "TECNIGEN LINARES 'A' 2ª", "CORDOBA 6 A 8 'B'", "AIRCITY CLIMATIZACION CTM JAEN", "TECNIGEN LINARES 'B' 2ª", "CD SAFA ANDUJAR-SAFAUTO TM"};
        int[] puntosLiga = new int[equipos.length];
        int opcion;
        String error = "Valor inválido";
        do {
            opcion = menuAplicacion();

            switch (opcion) {
                case 1:
                    for (int i = 0; i < equipos.length; i++) {
                        System.out.println((i + 1) + ". " + equipos[i]);
                    }

                    System.out.println("Nº Equipo Local");
                    int local = sc.nextInt() - 1;
                    System.out.println("Nº Equipo Visitante");
                    int visitante = sc.nextInt() - 1;

                    if (local < 0 || visitante < 0 || local >= equipos.length || visitante >= equipos.length || local == visitante) {
                        System.out.println(error);
                        break;
                    }
                    else {
                        int[] marcador = new int[2];
                        System.out.println("------------------------");
                        System.out.println("Puntos Local");
                        marcador[0] = sc.nextInt();
                        System.out.println("Puntos Visitante");
                        marcador[1] = sc.nextInt();
                        System.out.println("------------------------");

                        if (Puntuacion.resultadoValido(marcador)) {
                            int[] puntos = Puntuacion.puntosLiga(marcador);
                            puntosLiga[local] += puntos[0];
                            puntosLiga[visitante] += puntos[1];
                        }
                        else {
                            System.out.println(error);
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < equipos.length; i++) {
                        System.out.println((i + 1) + ". " + equipos[i] + " Puntos: " + puntosLiga[i]);
                    }
                    break;
                case 0:
                    System.out.println("Has salido de la aplicación");
                    break;
                default:
                    System.out.println(error);
                    break;
            }

        } while (opcion != 0);
    }
    public static int menuAplicacion (){
        System.out.println();
        System.out.println("------------------------");
        System.out.println("APLICACION TENIS DE MESA");
        System.out.println("1. Introducir partido");
        System.out.println("2. Ver clasificación");
        System.out.println("0. Salir");
        System.out.println("------------------------");
        return sc.nextInt();
    }

}
