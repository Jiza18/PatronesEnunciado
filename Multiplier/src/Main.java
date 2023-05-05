/*Multiplier
Haz que el método multiplica() obtenga los dos números a multiplicar llamando a dos métodos de un Adaptador.

class Multiplicador {
    int multiplica(int num1, int num2){
        return num1 * num2;
    }
}

public class Main {
    public static void main(String[] args) {
        Multiplicador multiplicador = new Multiplicador();

        int resultado = multiplicador.multiplica(1000, 2000);

        System.out.println(resultado);
    }
}*/

class Multiplicador {
    interface Adapter {
        int numero1();
        int numero2();
    }
    int multplica (Adapter adapter) {
        return adapter.numero1()*adapter.numero2();
    }
}

public class Main {
    public static void main(String[] args) {
        Multiplicador multiplicador = new Multiplicador();

        int resultado = multiplicador.multplica(new Multiplicador.Adapter() {
            @Override
            public int numero1() {
                return 100;
            }

            @Override
            public int numero2() {
                return 5;
            }
        });
    }
}