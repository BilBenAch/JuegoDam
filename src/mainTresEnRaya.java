//menu juego 3 en raya
import java.util.Scanner;

public class mainTresEnRaya {
    //la clase mainJuego donde contendrá el menú del juego
    public void mainJuego1() {
        System.out.println();
        System.out.println();
        System.out.println("******************************");
        System.out.println("Bienvenido al juego de tres en raya, espero que lo pases bien :DD");
        System.out.println();
        Scanner sc = new Scanner(System.in);
        Joc1TresEnRaya juego = new Joc1TresEnRaya();
        //inicializamos la tabla para que se dibuje y esté vacía
        juego.iniciarTabla();
        //mostramos la tabla anteriormente inicializada
        juego.mostarTablero();
        //creamos un boleano de turno para saber a quien le toca la tirada
        boolean turno = true;
        //creamos un entero de filas y columnas para indicar la posicion de la tabla
        int filas;
        int columnas;

        //vamos iterando hasta que s eencuentre un ganador o se llene la table que en ese caso será empate
        while (!juego.estaLLeno() && !juego.comprobarGanador()) {
            if (turno) {   //si el turno es true le toca al jugador 1
                System.out.println("es turno del jugador 1");
                System.out.println("introduce la posicion que deseas (filas, columnas) ");
                juego.Turno(turno);         //introducimos la posición en el tablero de 1 a 3
                filas = sc.nextInt() -1;
                columnas = sc.nextInt()-1;
                while (juego.comprobarPosicion(filas, columnas)) {//si la posicion es incorrecta debemos introducirla o no podremos continuar
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
            juego.comprobarGanador();//comprobamos si hay algun ganador, si no seguimos
            juego.mostarTablero();//mostramos el tablero depués de cada tirada
        }
        if (juego.comprobarGanador()) {//si hay un ganador comprobamos quien es, si es true es jugador 1 si no es el 2
            if (juego.jugador) {
                System.out.println("Felicidades ha ganado el jugador 1");
            }
            else {
                System.out.println("Felicidades ha ganado el jugador 2");
            }
        }
        else System.out.println("Empate");//si no hya ganadores entonces hay un empate

        System.out.println();
        System.out.println("******************************");
        System.out.println();
        System.out.println();
    }
}
