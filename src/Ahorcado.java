public class Ahorcado {
    char letra ;
    String palabraEscondida;
    char[] comillas;
    int fallos;
    Ahorcado(String palabraEscondida ){
        fallos = 0;
        this.palabraEscondida = palabraEscondida;
        comillas = new char [palabraEscondida.length()];
    }

    public void iniciarComillas(){
        for(int i = 0; i<comillas.length; i++){
            comillas[i] = '_';
        }
    }


    public void pintarComillas(){
        System.out.println();
        for(int i = 0; i<comillas.length; i++){
            System.out.print(comillas[i]+" ");
        }
    }

    public int comprobarLetra (char letra){
        int contador = 0;
        for(int i=0; i<palabraEscondida.length(); i++){
            if(letra != palabraEscondida.charAt(i)){
            }
            else {
                comillas[i] = letra;
                contador++;
            }
        }


        return contador;
    }


    boolean palabraEncontrada(){
        int contador = 0;
        for(int i= 0; i<palabraEscondida.length(); i++){
            if(palabraEscondida.charAt(i) == comillas[i]){
                contador ++;
            }
        }
        if(contador == palabraEscondida.length()){
            return true;
        }

        return false;
    }

    boolean encontrada(){

        return palabraEncontrada();
    }


    public void dibujarFallos(){

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