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