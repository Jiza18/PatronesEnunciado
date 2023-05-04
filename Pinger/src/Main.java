import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

class Pinger {
    interface Adapter {
        default int numIps() { return 100; }
        String ObtenerIp(int i);
    }

    void ping(Adapter adapter) {
        for (int i = 0; i < adapter.numIps(); i++) {

            String ip = adapter.ObtenerIp(i);

            try {
                if (InetAddress.getByName(ip).isReachable(500)) {
                    System.out.println(ip + " is online");
                } else {
                    System.out.println(ip + " is down");
                }
            } catch (IOException ignored) {}
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Pinger pinger = new Pinger();

        pinger.ping(new Pinger.Adapter() {

            @Override
            public String ObtenerIp(int i) {
                return "10.2.1."+i;
            }
        });
    }
}