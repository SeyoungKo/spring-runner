package singletone;

public class Aclass {
    private SocketClient socketClient;

    public Aclass(){
        this.socketClient = SocketClient.getInstance();
        // socketClient 객체를 생성하는 기본 생성자를 막아두었기 때문에 getInstance() static 메서드로 접근한다.
    }

    public SocketClient getSocketClient() {
        return this.socketClient;
    }
}
