import java.util.Scanner;
        import java.util.regex.Pattern;

public class MainAhorcado {

    public void mainJuego2() {
        Scanner sc = new Scanner(System.in);
        String palabraEscondida;
        System.out.println();
        System.out.println();
        System.out.println("******************************************");
        System.out.println("Benvinguts al joc del penjat: ");
        System.out.println("Introdueix la paraula a buscar: ");
        palabraEscondida = sc.nextLine();
        boolean comprobarPalabra = false;
        while (!comprobarPalabra) {
            if (Pattern.matches("^[a-zA-Z\\u00C0-\\u00FF]*$", palabraEscondida)) {
                comprobarPalabra = true;
            } else {
                System.out.println("La paraula introduïda no compleix amb el format, no s'accepten números, només lletres");
                System.out.println("introdueix la paraula de nou: ");
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
            System.out.println("Introdueix una lletra (si la paraula que volem obtenir s'accentua, has introduirà igual o contarà com un intent fallat, si introdueixes un número o dígit que no correspon amb una lletra també comptarà com un intent fallat: ");
            letra = sc.next().charAt(0);
            letra = Character.toLowerCase(letra);
            juego2.comprobarLetra(letra);
            if (juego2.comprobarLetra(letra) == 0) {
                juego2.fallos++;
                System.out.println("La lletra no està en la paraula, queden " + (10 - juego2.fallos) + " Intents");
                juego2.dibujarFallos();
            } else {
                if (!juego2.encontrada()) {
                    System.out.println("Molt bé, la lletra si està");
                    System.out.println();
                } else {
                    System.out.println("Felicitats, has endevinat la paraula :D");
                    System.out.println("la paraula era: " + juego2.palabraEscondida);
                }
            }
        }
        if (!juego2.encontrada()) {
            System.out.println("Has perdut la paraula era " + juego2.palabraEscondida);
        }
        System.out.println();
        System.out.println();
        System.out.println("*********************");
    }
}
