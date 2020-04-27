import java.util.Scanner;
        import java.util.regex.Pattern;

public class MainAhorcado {

    public void mainJuego2() {
        Scanner sc = new Scanner(System.in);
        String palabraEscondida;
        System.out.println();
        System.out.println();
        System.out.println("******************************************");
        System.out.println("Bienvenido al juego del ahorcado: ");
        System.out.println("Introduce la palabra a buscar: ");
        palabraEscondida = sc.nextLine();
        boolean comprobarPalabra = false;
        while (!comprobarPalabra) {
            if (Pattern.matches("^[a-zA-Z\\u00C0-\\u00FF]*$", palabraEscondida)) {
                comprobarPalabra = true;
            } else {
                System.out.println("La palabra introducida no cumple con el formato, no se aceptan numeros, solo letras");
                System.out.println("Introduce la palabra de nuevo: ");
                palabraEscondida = sc.nextLine();
            }
        }
        palabraEscondida = palabraEscondida.toLowerCase();
        Ahorcado juego2 = new Ahorcado(palabraEscondida);
        char letra = 0;
        juego2.iniciarComillas();
        while (!juego2.encontrada() && juego2.fallos < 10) {
            juego2.pintarComillas();
            System.out.println();
            System.out.println("Introduce una letra (si la palabra que deseamos obtener tiene tilde debes introducirla igual o contará como fallo, si introduces un numero o dígito que no corresponda  auna eltra también contará como fallo: ");
            letra = sc.next().charAt(0);
            letra = Character.toLowerCase(letra);
            juego2.comprobarLetra(letra);
            if (juego2.comprobarLetra(letra) == 0) {
                juego2.fallos++;
                System.out.println("La letra no está en la palabra, te quedan " + (10 - juego2.fallos) + " Intentos");
                juego2.dibujarFallos();
            } else {
                if (!juego2.encontrada()) {
                    System.out.println("Muy bien la letra si está");
                    System.out.println();
                } else {
                    System.out.println("Felicidades, has adivinado la palabra :D");
                    System.out.println("la palabra era: " + juego2.palabraEscondida);
                }
            }
        }
        if (!juego2.encontrada()) {
            System.out.println("Has perdido la palabra era " + juego2.palabraEscondida);
        }
        System.out.println();
        System.out.println();
        System.out.println("*********************");
    }
}
