/*Haz que el método ping obtenga las direcciones IP de un Adaptador.

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

class Pinger {
    void ping(List<String> ips) {
        for (String ip : ips) {
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

        List<String> ips = new ArrayList<>();
        for (int i = 1; i < 254; i++) {
            ips.add("10.2.1." + i);
        }

        pinger.ping(ips);
    }
}*/

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