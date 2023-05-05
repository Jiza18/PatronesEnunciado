/*Crea un Builder para la siguiente clase Computer:

Los campos HDD y RAM son obligatorios, y se deben pasar en el constructor del Builder.

Los campos isGraphicsCardEnabled y isBluetoothEnabled son opcionales y se deben establecer con métodos setter del Builder

Crea un constructor privado en la clase Computer para impedir que se instancien objetos de esta clase, si no es a través del Builder.

Crea un programa principal que instancia un Computer usando el Builder.

*/


class Computer {
    //required
    String HDD;
    String RAM;

    //optional
    boolean isGraphicsCardEnabled;
    boolean isBluetoothEnabled;

    static class Builder {
        String HDD;
        String RAM;

        //optional
        boolean isGraphicsCardEnabled;
        boolean isBluetoothEnabled;

        public Builder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        Builder isGraphicsCardEnabled (boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        Builder isBluetoothEnabled (boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        Computer build() {
            Computer computer = new Computer();
            computer.HDD = this.HDD;
            computer.RAM = this.RAM;
            return computer;
        }
    }


}

public class Main {
    public static void main(String[] args) {

        Computer comp = new Computer.Builder("1TB","28GB")
                .build();
    }
}