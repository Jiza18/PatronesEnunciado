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