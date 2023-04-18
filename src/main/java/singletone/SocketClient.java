package singletone;

// 서버와 통신할 때 하나의 소켓 객체를 활용한다.
public class SocketClient {
    private static SocketClient socketClient = null;

    // 기본 생성자는 private으로 생성
    private SocketClient(){

    }

    // 어디서나 접근 가능한 static으로 만들어서 내부에서 객체를 생성하도록 함
    // 분기문에서 있을 경우 기존의 객체를 사용하도록 함 (싱글톤)
    public static SocketClient getInstance(){
        if(socketClient == null){
            socketClient = new SocketClient();
        }
        return socketClient;
    }

    public void connect(){
        System.out.println("connect!");
    }
}
