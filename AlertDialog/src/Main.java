import javax.swing.*;

class AlertDialog {
    String title,text,yesButtonText,noButtonText;

    static class Builder {
        String title,text,yesButtonText,noButtonText;

        public Builder(String title, String text) {
            this.title = title;
            this.text = text;
        }

        Builder setYes(String yesButtonText) {
            this.yesButtonText = yesButtonText;
            return this;
        }

        Builder setNo(String noButtonText) {
            this.noButtonText = noButtonText;
            return this;
        }

        Builder setYes() {
            this.yesButtonText = "OK";
            return this;
        }

        Builder setNo() {
            this.noButtonText = "Cancel";
            return this;
        }


        AlertDialog build() {
            AlertDialog alert = new AlertDialog();
                alert.text = this.text;
                alert.title = this.title;
                alert.yesButtonText = this.yesButtonText;
                alert.noButtonText = this.noButtonText;
                return alert;
        }

        void show(){
            AlertDialog alertDialog = build();

            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.PAGE_AXIS));
            jPanel.add(new JLabel(alertDialog.text));
            if (alertDialog.yesButtonText != null)
                jPanel.add(new JButton(alertDialog.yesButtonText));
            if (alertDialog.noButtonText != null)
                jPanel.add(new JButton(alertDialog.noButtonText));


            JFrame jFrame = new JFrame(title);
            jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jFrame.add(jPanel);
            jFrame.pack();
            jFrame.setLocationRelativeTo(null);
            jFrame.setVisible(true);
        }
    }
}

public class Main {
    public static void main(String[] args) {

        new AlertDialog.Builder("Suscribirse", "Desea suscribirse a mi canal?")
                .setYes()
                .show();

    }
}