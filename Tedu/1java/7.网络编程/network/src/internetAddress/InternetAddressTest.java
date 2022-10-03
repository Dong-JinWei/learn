package internetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InternetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("DESKTOP-GM1910");
        System.out.println(address);

        address = InetAddress.getByName("www.baidu.com");
        System.out.println(address);

        System.out.println(address.getHostName());
        System.out.println(address.getHostAddress());

        InetAddress[] allByName = InetAddress.getAllByName("www.bilibili.com");

        for (InetAddress inetAddress : allByName) {
            System.out.println(inetAddress);
        }

        InetAddress localHost = InetAddress.getLocalHost();

        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());


    }
}
