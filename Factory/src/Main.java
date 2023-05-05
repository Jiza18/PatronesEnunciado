/*Para facilitar su uso, se ha incluido un metodo factory en la clase Notification, que retorna un objeto de la clase correspondiente según el parámetro destination recibido:

Si el parámetro destination contiene una @, se retorna un EmailNotification
Si el parámetro destination empieza por http, se retorna un PushNotification
En cualquier otro caso, se retorna un SMSNotification
Las clases que implementan el método sendNotification(), por el momento, no es necesario que realicen la acción de enviar la notificación; simplemente escriben por pantalla un mensaje.

A continuación se muestra un ejemplo de cómo se usaría la clase Notification:

public class Main {
    public static void main(String[] args) {

        Notification.factory("gerard@benigaslo.com").sendNotification();
        Notification.factory("http://benigaslo.com/gerard").sendNotification();
        Notification.factory("+34 678 789 890").sendNotification();
    }
}
*/

abstract class Notification {
    String destination;
    abstract void sendNotification();

    static Notification factory(String destination) {
        if (destination.contains("@")) {
            return new EmailNotification(destination);
        } else if (destination.contains("http")) {
            return new PushNotification(destination);
        } else {
            return new SMSNotification(destination);
        }
    }


    Notification (String destination) {
        this.destination = destination;
    }
}

class SMSNotification extends Notification{
    SMSNotification(String destination) {
        super(destination);
    }
    @Override
    void sendNotification() {
        System.out.println("SEND SMS to: " + destination);
    }
}

class EmailNotification extends Notification {
    EmailNotification (String destination) {
        super(destination);
    }
    @Override
    void sendNotification() {
        System.out.println("SENDING EMAIL to : " + destination);
    }
}

class PushNotification extends Notification {

    PushNotification (String destination) {
        super(destination);
    }

    @Override
    void sendNotification() {
        System.out.println("SENDING PUSH to : " + destination);
    }

}

public class Main {
    public static void main(String[] args) {

        Notification.factory("gerard@benigaslo.com").sendNotification();
        Notification.factory("http://benigaslo.com/gerard").sendNotification();
        Notification.factory("+34 678 789 890").sendNotification();

    }
}