//menu juego 3 en raya
import java.util.Scanner;

public class mainTresEnRaya {

    public void mainJuego1() {
        System.out.println();
        System.out.println();
        System.out.println("******************************");
        System.out.println("Bienvenido al juego de tres en raya, espero que lo pases bien :DD");
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
                System.out.println("es turno del jugador 1");
                System.out.println("introduce la posicion que deseas (filas, columnas) ");
                juego.Turno(turno);
                filas = sc.nextInt() -1;
                columnas = sc.nextInt()-1;
                while (juego.comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introducido una posicion correcta o ya está llena introduce de nuevo: ");
                    filas = sc.nextInt()-1;
                    columnas = sc.nextInt()-1;
                }
                juego.introducirPosicion(filas, columnas);
                turno = false;
            } else {
                System.out.println("es turno del jugador 2");
                System.out.println("introduce la posicion que deseas (filas, columnas) ");
                System.out.println();
                juego.Turno(turno);
                filas = sc.nextInt()-1;
                columnas = sc.nextInt()-1;
                while (juego.comprobarPosicion(filas, columnas)) {
                    System.out.println("No has introducido una posicion correcta o ya está llena introduce de nuevo: ");
                    filas = sc.nextInt()-1;
                    columnas = sc.nextInt()-1;
                }
                juego.introducirPosicion(filas, columnas);
                turno = true;
            }
            juego.comprobarGanador();
            juego.mostarTablero();
        }
        if (juego.comprobarGanador()) {
            if (juego.jugador) {
                System.out.println("Felicidades ha ganado el jugador 1");
            }
            else {
                System.out.println("Felicidades ha ganado el jugador 2");
            }
        }
        else System.out.println("Empate");

        System.out.println();
        System.out.println("******************************");
        System.out.println();
        System.out.println();
    }
}
