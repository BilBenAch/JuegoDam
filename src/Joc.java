public abstract class Joc {

    abstract void mostraRegles();

    abstract void juga();

    void mostraMenu() {
        System.out.println("1. Saber les regles");
        System.out.println("2. Jugar al joc ");
        System.out.println("3. Sortir ");
    }

}