import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class SimuladorHipoteca {

    interface CallBack {
        void resultado(double resultado);
        void equivocado(String equivocado);
    }

    static void calcularCuota(double capital, double plazo, CallBack callBack) {
        // if (capital <= 0) error: capital no valido
        // if (plazo <= 0) error: plazo no valido

        double interes = 0;

        try {
            // obtener 'interes' del banco...
            interes = Double.parseDouble(HttpClient.newHttpClient().send(HttpRequest.newBuilder()
                    .uri(URI.create("https://fakebank-tan.vercel.app/api/get-interest"))
                    .GET().build(), HttpResponse.BodyHandlers.ofString()).body());
        } catch (Exception e) {

        }

        if (capital <= 0){
            callBack.equivocado("Capital no valido");
        } else if (plazo <= 0){
            callBack.equivocado("Plazo no valido");
        } else {
            callBack.resultado(capital*interes/12/(1-Math.pow(1+(interes/12),-plazo*12)));
        }

    }
}

public class Main {
    public static void main(String[] args) {
       // double cuota = SimuladorHipoteca.calcularCuota(2000, 2);

        SimuladorHipoteca.calcularCuota(0,2, new SimuladorHipoteca.CallBack() {
                    @Override
                    public void resultado(double resultado) {
                        System.out.println("El resultado es: " + resultado);
                    }

                    @Override
                    public void equivocado(String equivocado) {
                        System.out.println("Error : " + equivocado);
                    }
                }
        );
    }
}