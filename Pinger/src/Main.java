import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.List;

class Pinger {
    interface Adapter {
        String ObtenerIp();
    }
    void ping(List <String> ips) {
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
}