
class TextBox {
    String texto;
    int ancho, alto;

    static class Builder {
        String texto;
        int ancho,alto;

        Builder setTexto(String texto) {
            this.texto = texto;
            return this;
        }

        Builder setAncho(int ancho) {
            this.ancho = ancho;
            return this;
        }

        Builder setAlto(int alto) {
            this.alto = alto;
            return this;
        }

        TextBox build() {
            TextBox cuadrado = new TextBox();

            if (this.alto < 0 && this.ancho < 0) {
                cuadrado.alto = 1;
                cuadrado.ancho = 1;
            }

            if (this.ancho >= this.texto.length()) {
                cuadrado.ancho = this.texto.length();
            }

            if (this.texto.length() !=0) {
                cuadrado.alto = 1;
            }

            if (this.texto != null) {
                cuadrado.texto = this.texto;
            }

            return cuadrado;
        }


    }



    @Override
    public String toString() {
        return ancho + "x" + alto + "\n" +
                "┏" + "━".repeat(ancho) + "┓\n" +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat((alto - 1) / 2) +
                (alto > 0 ? "┃" + " ".repeat((ancho - texto.length() + 1) /2) + texto + " ".repeat((ancho - texto.length()) / 2) + "┃\n" : "") +
                ("┃" + " ".repeat(ancho) + "┃\n").repeat(alto / 2) +
                "┗" + "━".repeat(ancho) + "┛\n";
    }
}





public class Main {
    public static void main(String[] args) {

        TextBox cuadrado = new TextBox.Builder()
                .setAlto(10)
                .setAncho(10)
                .setTexto("Alejandro")
                .build();

        System.out.println(cuadrado.toString());
    }
}