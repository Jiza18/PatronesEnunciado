class Calculadora {

    interface CallBack {
        void resultado(int resultado);
        void equivocado(String equivocado);
    }


    static void suma(CallBack callBack, int... numeros) {
        int resultado = 0;
        for (Integer numero : numeros) {
           if (resultado + numero > Integer.MAX_VALUE){
               callBack.equivocado("Error");
           } else {
               callBack.resultado(resultado += numero);
           }
        }
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


        Calculadora.suma(new Calculadora.CallBack() {
                    @Override
                    public void resultado(int resultado) {
                        System.out.println("La suma es: " + resultado);
                    }

                    @Override
                    public void equivocado(String equivocado) {
                        System.out.println("Error :" + equivocado);
                    }
                }, 1,2,10,6,7);

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