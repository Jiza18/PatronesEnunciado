class Calculadora {

    interface CallBack {
        void resultado(int resultado);
        void equivocado(String equivocado);
    }


    static int suma(int... numeros) {
        int resultado = 0;
        for (Integer numero : numeros) resultado += numero;     // ¿ y si resultado + numero > Integer.MAX_VALUE ?
        return resultado;
    }


    static void divide(int a, int b, CallBack callBack) {
        if (b==0){
            callBack.equivocado("Dividir por 0");
        } else {
            callBack.resultado(a/b);     // ¿ y si b es 0 ?
        }
    }
}


public class Main {
    public static void main(String[] args) {

//        int resultadoSuma = Calculadora.suma(1, 2, 3, 10, 20);
//        System.out.println("La suma es: " + resultadoSuma);
//
//        int resultadoOtraSuma = Calculadora.suma(1, 2147483646, 1);
//        System.out.println("La suma es: " + resultadoOtraSuma);



        Calculadora.divide(13, 0, new Calculadora.CallBack() {
            @Override
            public void resultado(int resultado) {
                System.out.println("La division es: " + resultado);
            }

            @Override
            public void equivocado(String equivocado) {
                System.out.println("Error: " + equivocado);
            }
        });





    }
}