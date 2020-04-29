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
        System.out.println("Benvingut al joc del penjat: ");
        System.out.println("Introdueix la paraula a buscar: ");
        palabraEscondida = sc.nextLine();
        boolean comprobarPalabra = false;
        while (!comprobarPalabra) {
            if (Pattern.matches("^[a-zA-Z\\u00C0-\\u00FF]*$", palabraEscondida)) {
                comprobarPalabra = true;
            } else {
                System.out.println("La paraula introduïda no compleix amb el format, no s'accepten números, només lletres");
                System.out.println("Introdueix la paraula de nou: ");
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
            System.out.println("Introdueix una lletra (si la paraula que vulguem obtenir s'accentua has d'introduir-la igual o contarà com a malament i es sumarà un error, si introdueixes un número o dígit que no correspongui a una lletra també contarà com malament: ");
            letra = sc.next().charAt(0);
            letra = Character.toLowerCase(letra);
            comprobarLetra(letra);
            if (comprobarLetra(letra) == 0) {
                fallos++;
                System.out.println("La lletra no està en la paraula, quedan " + (10 - fallos) + " Intents");
                dibujarFallos();
            } else {
                if (!encontrada()) {
                    System.out.println("Molt bé la lletra si està");
                    System.out.println();
                } else {
                    System.out.println("Felicitats, has endevinat la paraula :D");
                    System.out.println("la paraula era: " + palabraEscondida);
                }
            }
        }
        if (!encontrada()) {
            System.out.println("Has perdut la paraula era " + palabraEscondida);
        }
        System.out.println();
        System.out.println();
        System.out.println("*********************");
    }
}
