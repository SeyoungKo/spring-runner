import singletone.Aclass;
import singletone.Bclass;
import singletone.SocketClient;

public class Main {

    public static void main(String[] args) {

        Aclass aclass = new Aclass();
        Bclass bclass = new Bclass();

        SocketClient a = aclass.getSocketClient();
        SocketClient b = bclass.getSocketClient();

        System.out.println("두개의 객체가 동일?");
        System.out.println(a.equals(b));

    }
}
