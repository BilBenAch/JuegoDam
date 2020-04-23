public class Joc1TresEnRaya {

    char tabla[][];
    boolean jugador;
    //Creamos nuestro constructor, por defecto vacío e inicializamos los atributos de tabla que será el tablero y un booleano de jugador(true jugador 1, false jugador 2);
    Joc1TresEnRaya() {
        tabla = new char[3][3];
        boolean jugador = true;
    }
    //inicializamos nuestro tablero, cada posicion tiene el valor - .
    void iniciarTabla() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tabla[i][j] = '-';
            }
        }
    }
    //Comprobamos que en nuestro tablero se puedan añadir valores y no esté lleno(asi comprobamos la condición de empate).
    boolean estaLLeno() {
        boolean lleno = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(tabla[i][j] == '-'){
                    lleno = false;
                }
            }
        }
        return lleno;
    }
    //Método para ir mostrando el tablero por cada tanda
    public void mostarTablero() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tabla[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    //Comprobamos de quien es el turno de la tanda, true es jugador 1 false jugador 2
    public boolean Turno (boolean jugador){
        this.jugador = jugador;
        if(jugador == true){
            return true;
        }

        else {
            return false;
        }
    }
    //introducimos la posicion en nuestro tablero, si está vacío escribimos en la posición deseada
    public void introducirPosicion(int filas, int columnas) {
        if((filas < 3 && filas >= 0 ) && (columnas >= 0 && columnas < 3)){
            if(Turno (jugador)) {
                if (tabla[filas][columnas] == '-') {
                    tabla[filas][columnas] = 'X';
                }
            }
            else{
                if (tabla[filas][columnas] == '-') {
                    tabla[filas][columnas] = 'O';
                }
            }
        }
    }
    //Comprobamos que el valor introducido de las filas y columnas es correcto y no esté ya escrita en esa posición
    public boolean comprobarPosicion(int filas, int columnas){
        if(((filas < 3 && filas >= 0 ) && (columnas >= 0 && columnas < 3)) && (tabla[filas][columnas] == '-')){
            return false;
        }
        return true;
    }
    //Comprobamos que haya 3 posicione iguales del mismo jugador en las filas en caso de que sea true el es el ganador.
    public boolean comprobarGanadorColumnas(){
        for(int j = 0; j<3; j++){
            if((tabla[0][j] == 'X') && (tabla[1][j] == 'X') && (tabla[2][j] == 'X')){

                return true;
            }
            else if(tabla[0][j] == 'O' && tabla[1][j] == 'O' && tabla[2][j] == 'O'){

                return true;
            }
        }
        return false;
    }
    //Comprobamos que haya 3 posicione iguales del mismo jugador en las columnas en caso de que sea true el es el ganador.
    public boolean comprobarGanadorFilas(){
        for(int i = 0; i<3; i++){
            if((tabla[i][0] == 'X') && (tabla[i][1] == 'X') && (tabla[i][2] == 'X')){

                return true;
            }
            else if((tabla[i][0] == 'O') && (tabla[i][1] == 'O') && (tabla[i][2] == 'O')){

                return true;
            }
        }
        return false;
    }

    //Comprobamos que haya 3 posicione iguales del mismo jugador en diagonal en caso de que sea true el es el ganador.
    public boolean comprobarganadorDiagonal(){
        if(((tabla[0][0] == 'X') && (tabla[1][1] == 'X') && (tabla[2][2] == 'X')) || (tabla[0][2] == 'X') && (tabla[1][1] == 'X') && (tabla[2][0] == 'X')){
            return true;
        }
        else if(((tabla[0][0] == 'O') && (tabla[1][1] == 'O') && (tabla[2][2] == 'O')) || (tabla[0][2] == 'O') && (tabla[1][1] == 'O') && (tabla[2][0] == 'O')){

            return true;
        }

        return false;

    }

    // Comprobarmos el ganador
    public boolean comprobarGanador(){
        return comprobarGanadorColumnas() || comprobarGanadorFilas() || comprobarganadorDiagonal();
    }

}