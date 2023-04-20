import adapter.*;
import proxy.Browser;
import proxy.BrowserProxy;
import proxy.IBrowser;
import singletone.Aclass;
import singletone.Bclass;
import singletone.SocketClient;

public class Main {

    public static void main(String[] args) {
        // singletone
        Aclass aclass = new Aclass();
        Bclass bclass = new Bclass();

        SocketClient a = aclass.getSocketClient();
        SocketClient b = bclass.getSocketClient();

        System.out.println("두개의 객체가 동일?");
        System.out.println(a.equals(b));


        // adapter 적용 x
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        //connect(cleaner); // 규격(타입)에 맞지 않아 x

        // adapter 적용 ver
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);


        // proxy 적용 x
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        // proxy 적용 ver
        // 처음에만 로드되고 두번째부터 캐쉬를 사용한다.
        IBrowser browser2 = new BrowserProxy("www.naver.com");
        browser2.show();
        browser2.show();
        browser2.show();
        browser2.show();

    }

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }
}
