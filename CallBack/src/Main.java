class Calculadora {

    interface CallBack {
        void resultado(String resultado);
        void equivocado(String equivocado);
    }

    void darExplicacion(CallBack callBack) {
        if (Calculadora.divide(13,0) == 0) {
            callBack.equivocado("Ha habido un error.");
        } else {
            callBack.resultado("El resultado es: ");
        }
    }

    static int suma(int... numeros) {
        int resultado = 0;
        for (Integer numero : numeros) resultado += numero;     // ¿ y si resultado + numero > Integer.MAX_VALUE ?
        return resultado;
    }


    static int divide(int a, int b) {
        return a/b;     // ¿ y si b es 0 ?
    }
}


public class Main {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        int resultadoSuma = Calculadora.suma(1, 2, 3, 10, 20);
        System.out.println("La suma es: " + resultadoSuma);


        int resultadoDivision = Calculadora.divide(13, 2);
        System.out.println("La division es: " + resultadoDivision);


        int resultadoOtraSuma = Calculadora.suma(1, 2147483646, 1);
        System.out.println("La suma es: " + resultadoOtraSuma);


        int resultadoOtraDivision = Calculadora.divide(13, 0);
        System.out.println("La division es: " + resultadoOtraDivision);

        calculadora.darExplicacion(new Calculadora.CallBack() {
            @Override
            public void resultado(String resultado) {
                System.out.println(resultado + resultadoSuma);
            }
            @Override
            public void equivocado(String equivocado) {
                System.err.println(equivocado + resultadoOtraDivision);
            }
        });

    }
}