package adapter;

// 110v와 220v의 호환성 문제가 발생했을 때 adapter를 통해 중간에서 변환해준다.
// adapter의 powerOn을 호출했을 때 110v를 220v로 변환한다.
public class SocketAdapter implements Electronic110V{
    private Electronic220V electronic220V;

    public SocketAdapter(Electronic220V electronic220V){
        this.electronic220V = electronic220V;
    }

    @Override
    public void powerOn() {
        electronic220V.connect();
    }
}
