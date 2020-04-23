import java.util.Scanner;
import java.util.regex.Pattern;

public class mainAhorcado {

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
        while (!comprobarPalabra) { //Comprobamos que la palabra a buscar cumple con el formato
            if (Pattern.matches("^[a-zA-Z\\u00C0-\\u00FF]*$", palabraEscondida)) { //método de expresiones regulares para introducir palabras con tilde y que sean solo letras
                comprobarPalabra = true;
            } else { //Si cumple el formato sale del while y prosigue con el programa
                System.out.println("La palabra introducida no cumple con el formato, no se aceptan numeros, solo letras");
                System.out.println("Introduce la palabra de nuevo: ");
                palabraEscondida = sc.nextLine();
            }
        }
        palabraEscondida = palabraEscondida.toLowerCase(); //Pasamos la palabra a minúscula para evitar errores
        Ahorcado juego2 = new Ahorcado(palabraEscondida); //Inicializamos el constructor
        char letra = 0;
        juego2.iniciarComillas(); //Inicializamos el panel de comillas de nuestro juego
        while (!juego2.encontrada() && juego2.fallos < 10) { //Mientras no encontremos la palabra deseada o tengamos menos de 10 fallos seguiremos jugando
            juego2.pintarComillas(); //Printamos por cada iteración el panel
            System.out.println();
            System.out.println("Introduce una letra (si la palabra que deseamos obtener tiene tilde debes introducirla igual o contará como fallo, si introduces un numero o dígito que no corresponda  auna eltra también contará como fallo: ");
            letra = sc.next().charAt(0); //Introducimos la letra
            letra = Character.toLowerCase(letra); //Pasamos la letra a minúscula para que haga la busqueda bien y evitar fallos por si la hemos introducido en mayúscula
            juego2.comprobarLetra(letra); //comprobamos con el método de la clase si aparece o no la letra
            if (juego2.comprobarLetra(letra) == 0) { //Si no aparce  nos cuenta como fallo.
                juego2.fallos--;
                System.out.println("La letra no está en la palabra, te quedan " + (10 - juego2.fallos) + " Intentos");
                juego2.dibujarFallos();
            } else { //Si aparece proseguiremos con el juego
                if (!juego2.encontrada()) { //Mientras no tengamos la palabra y la letra sea correcta seguimos con el juego
                    System.out.println("Muy bien la letra si está");
                    System.out.println();
                } else { //Si adivinamos la palabra, la mostraremos por teclado y recibiremos un mensaje de felicitación
                    System.out.println("Felicidades, has adivinado la palabra :D");
                    System.out.println("la palabra era: " + juego2.palabraEscondida);
                }
            }
        }
        if (!juego2.encontrada()) {//Si hemos agotado todas las oportunidades y no hemos encontrado la plabra, perderemos y mostraremos la palabra
            System.out.println("Has perdido la palabra era " + juego2.palabraEscondida);
        }
        System.out.println();
        System.out.println();
        System.out.println("*********************");
    }
}
