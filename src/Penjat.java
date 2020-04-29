import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Penjat extends Joc {

    char letra;
    String palabraEscondida;
    char[] comillas;
    int fallos;

    Penjat(){

    }
    public void iniciarJuego(String palabraEscondida) {
        fallos = 0;
        this.palabraEscondida = palabraEscondida;
        comillas = new char[palabraEscondida.length()];
        Arrays.fill(comillas, '_');
    }

    public void iniciarComillas() {
        Arrays.fill(comillas, '_');
    }


    public void pintarComillas() {
        System.out.println();
        for (int i = 0; i < comillas.length; i++) {
            System.out.print(comillas[i] + " ");
        }
    }

    public int comprobarLetra(char letra) {
        int contador = 0;
        for (int i = 0; i < palabraEscondida.length(); i++) {
            if (letra != palabraEscondida.charAt(i)) {
            } else {
                comillas[i] = letra;
                contador++;
            }
        }
        return contador;
    }


    boolean palabraEncontrada() {
        int contador = 0;
        for (int i = 0; i < palabraEscondida.length(); i++) {
            if (palabraEscondida.charAt(i) == comillas[i]) {
                contador++;
            }
        }
        if (contador == palabraEscondida.length()) {
            return true;
        }

        return false;
    }

    boolean encontrada() {
        return palabraEncontrada();
    }


    public void dibujarFallos() {
        if (fallos == 1) {
            System.out.println("---------------");
        } else if (fallos == 2) {
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 3) {
            System.out.println("---------");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 4) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 5) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|" + "       o");
            System.out.println("|");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 6) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|" + "       o ");
            System.out.println("|" + "       | ");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 7) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|" + "       o ");
            System.out.println("|" + "      /| ");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 8) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|" + "       o ");
            System.out.println("|" + "      /|\\");
            System.out.println("|");
            System.out.println("---------------");
        } else if (fallos == 9) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|" + "       o ");
            System.out.println("|" + "      /|\\");
            System.out.println("|" + "      / ");
            System.out.println("---------------");
        } else if (fallos == 10) {
            System.out.println("---------");
            System.out.println("|" + "       |");
            System.out.println("|" + "       o ");
            System.out.println("|" + "      /|\\");
            System.out.println("|" + "      / \\");
            System.out.println("---------------");
        }
    }

    @Override
    void mostraRegles() {
        System.out.println();
        System.out.println("************************");
        System.out.println("Descripció del joc número 2: ");
        System.out.println();
        System.out.println("El joc tracta del clàssic penjat, tindràs 10 intents per trobar la paraula que hauràs d'introduir per teclat,");
        System.out.println("s'haurà d'introduir una paraula sense espais en blancs, pot contenir accents però si la lletra introduïda per trobar la paraula no conté accent o no és una lletra, ");
        System.out.println("contarà com una fallada, tambè es podrá jugar si només s'introdueix una lletra. ");
        System.out.println();
        System.out.println("************************");
        System.out.println();
    }

    @Override
    void juga() {
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
        iniciarJuego(palabraEscondida);
        char letra = 0;
        iniciarComillas();
        while (!encontrada() && fallos < 10) {
            pintarComillas();
            System.out.println();
            System.out.println("Introduce una letra (si la palabra que deseamos obtener tiene tilde debes introducirla igual o contará como fallo, si introduces un numero o dígito que no corresponda  auna eltra también contará como fallo: ");
            letra = sc.next().charAt(0);
            letra = Character.toLowerCase(letra);
            comprobarLetra(letra);
            if (comprobarLetra(letra) == 0) {
                fallos++;
                System.out.println("La letra no está en la palabra, te quedan " + (10 - fallos) + " Intentos");
                dibujarFallos();
            } else {
                if (!encontrada()) {
                    System.out.println("Muy bien la letra si está");
                    System.out.println();
                } else {
                    System.out.println("Felicidades, has adivinado la palabra :D");
                    System.out.println("la palabra era: " + palabraEscondida);
                }
            }
        }
        if (!encontrada()) {
            System.out.println("Has perdido la palabra era " + palabraEscondida);
        }
        System.out.println();
        System.out.println();
        System.out.println("*********************");
    }
}
