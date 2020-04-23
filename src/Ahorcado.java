public class Ahorcado { //Creamos la clase Ahorcado con sus atributos:
    char letra ; //letra que será la letra a buscar
    String palabraEscondida; //La palabraEscondida que será la palabra a buscar
    char[] comillas; //Comillas será un array de panel el cual contendrá las _ de nuestro juego siendo remplazado por la letra si la adivinamos
    int fallos; //contendra los fallos que vamos teniendo, por defecto valdrá al iniciar 0
    Ahorcado(String palabraEscondida ){
        fallos = 0;
        this.palabraEscondida = palabraEscondida;
        comillas = new char [palabraEscondida.length()]; //inicializamos comillas con el valor de la palabra a buscar
    }

    public void iniciarComillas(){ //Inicializamos el panel del juego, cada posición valdra _
        for(int i = 0; i<comillas.length; i++){
            comillas[i] = '_';
        }
    }


    public void pintarComillas(){ //Método para ir printando el tablero del juego
        System.out.println();
        for(int i = 0; i<comillas.length; i++){
            System.out.print(comillas[i]+" ");
        }
    }

    public int comprobarLetra (char letra){ //Método para ir comprobando si la letra que pasamos por teclado existe en nuestro string
        int contador = 0;
        for(int i=0; i<palabraEscondida.length(); i++){
            if(letra != palabraEscondida.charAt(i)){ //Si la letra no está en nuestro string, contador valdrá 0 con lo cuál iremos controlando los fallos que vamos teniendo
            }
            else { //Si la letra está en el string entonces sumamos contador con lo cuál querrá decir que no tenemos ningún fallo y después copiamos la letra obtenida en nuestro tablero .
                comillas[i] = letra;
                contador++;
            }
        }
        if(contador == 0){
            fallos++;
        }

        return contador;
    }

    boolean palabraEncontrada(){//Método para ver si hemos encontrado la palabra
        int contador = 0;
        for(int i= 0; i<palabraEscondida.length(); i++){
            if(palabraEscondida.charAt(i) == comillas[i]){ //si cada letra de palabra es igual a cada letra del tablero sumamos un valor en el contador
                contador ++;
            }
        }
        if(contador == palabraEscondida.length()){ //si contador tiene el mismo tamaño que la palabra que deseamos buscar querrá decir que la hemos obtenido si no, seguiremos buscando
            return true;
        }

        return false;
    }

    boolean encontrada(){ //Método que nos devolverá si hemos encontrado la palabra

        return palabraEncontrada();
    }


    public void dibujarFallos(){ //Metodo en el cuál dibujaremos por cada fallo su correspondiente dibujo del clásico juego "Ahorcado"
        String dibujo = "";
        if(fallos == 1 ){
            System.out.println( "---------------");
        }
        else if(fallos == 2){

            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "---------------");


        }
        else if (fallos == 3){

            System.out.println( "---------");
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "---------------");

        }

        else if (fallos == 4) {

            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "---------------");

        }

        else if (fallos == 5) {
            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|"+"       o");
            System.out.println( "|" );
            System.out.println( "|" );
            System.out.println( "---------------");

        }
        else if (fallos == 6) {
            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|"+"       o ");
            System.out.println( "|"+"       | ");
            System.out.println( "|" );
            System.out.println( "---------------");

        }
        else if (fallos == 7) {

            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|"+"       o ");
            System.out.println( "|"+"      /| ");
            System.out.println( "|" );
            System.out.println( "---------------");

        }
        else if (fallos == 8) {

            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|"+"       o ");
            System.out.println( "|"+"      /|\\");
            System.out.println( "|" );
            System.out.println( "---------------");

        }
        else if (fallos == 9) {
            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|"+"       o ");
            System.out.println( "|"+"      /|\\");
            System.out.println( "|"+"      / ");
            System.out.println( "---------------");

        }
        else if (fallos == 10) {
            System.out.println( "---------");
            System.out.println( "|"+"       |");
            System.out.println( "|"+"       o ");
            System.out.println( "|"+"      /|\\");
            System.out.println( "|"+"      / \\");
            System.out.println( "---------------");

        }

    }


}