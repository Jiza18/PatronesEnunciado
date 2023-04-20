import java.util.concurrent.ThreadLocalRandom;

class Calculadora {
    interface Adapter {
        int cantidad();
        int numero();
    }

    int sumar (Adapter adapter) {
        int suma = 0;
        for (int i=0;i < adapter.cantidad() ; i++) {
            suma += adapter.numero();
        }
        return suma;
    }
}

public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();
        int res = calculadora.sumar(new Calculadora.Adapter() {
            @Override
            public int cantidad() {
                return 10000000;
            }

            @Override
            public int numero() {
                return 3;
            }
        });
    }
}