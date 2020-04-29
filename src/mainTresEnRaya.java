//menu juego 3 en raya

import java.util.Scanner;

public class mainTresEnRaya {

    public void mainJuego1() {
        System.out.println();
        System.out.println();
        System.out.println("******************************");
        System.out.println("Benvingut al joc del tres en ratlla, espero que t'ho passis bé :DD");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Joc1TresEnRaya juego = new Joc1TresEnRaya();

        juego.iniciarTabla();

        juego.mostarTablero();

        boolean turno = true;

        int filas;
        int columnas;


        while (!juego.estaLLeno() && !juego.comprobarGanador()) {
            if (turno) {
                System.out.println("és el torn del jugador 1");
                System.out.println("Introdueix la posició que vulguis (files, columnes): ");
                juego.Turno(turno);
                filas = sc.nextInt() - 1;
                columnas = sc.nextInt() - 1;
                while (juego.comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introduït una posició correcta o ja està plena, introdueix de nou: ");
                    filas = sc.nextInt() - 1;
                    columnas = sc.nextInt() - 1;
                }
                juego.introducirPosicion(filas, columnas);
                turno = false;
            } else {
                System.out.println("és el torn del jugador 2");
                System.out.println("Introdueix la posició que vulguis (files, columnes): ");
                System.out.println();
                juego.Turno(turno);
                filas = sc.nextInt() - 1;
                columnas = sc.nextInt() - 1;
                while (juego.comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introduït una posició correcta o ja està plena, introdueix de nou: ");
                    filas = sc.nextInt() - 1;
                    columnas = sc.nextInt() - 1;
                }
                juego.introducirPosicion(filas, columnas);
                turno = true;
            }
            juego.comprobarGanador();
            juego.mostarTablero();
        }
        if (juego.comprobarGanador()) {
            if (juego.jugador) {
                System.out.println("Felicitats ha guanyat el jugador 1");
            } else {
                System.out.println("Felicitats ha guanyat el jugador 2");
            }
        } else System.out.println("Empat");

        System.out.println();
        System.out.println("******************************");
        System.out.println();
        System.out.println();
    }
}
