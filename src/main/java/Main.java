import adapter.*;
import aop.AopBrowser;
import facade.Ftp;
import facade.Reader;
import facade.SftpClient;
import facade.Writer;
import observer.Button;
import observer.IButtonListener;
import decorator.*;
import proxy.Browser;
import proxy.BrowserProxy;
import proxy.IBrowser;
import singletone.Aclass;
import singletone.Bclass;
import singletone.SocketClient;

import java.util.concurrent.atomic.AtomicLong;

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

        // AOP by proxy
        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser browser3 = new AopBrowser("www.naver.com",
                () -> {System.out.println("before"); start.set(System.currentTimeMillis());},
                () -> {
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }); // runnable은 람다 표현식 사용

        browser3.show();
        System.out.println("loading time: " + end.get());

        // 두번째 show를 호출할 때는 캐쉬를 사용하기 때문에 0초가 소요된다.
        browser3.show();
        System.out.println("loading time: " + end.get());

//        // observer
//        Button button = new Button("버튼");
//        button.addListener({
//            @Override
//            public void clickEvent(String event) {
//
//            }
//        });
//        button.click("메세지 전달 : click");

        // decorator
        ICar audi = new Audi(1000);
        audi.showPrice();

        ICar audi3 = new A3(audi, "A3");
        audi3.showPrice();

        ICar audi4 = new A4(audi, "A4");
        audi4.showPrice();

        ICar audi5 = new A5(audi, "A5");
        audi5.showPrice();

        // Facade
        // 적용 x
        Ftp ftpClient = new Ftp("www.ftp.com", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.fileWrite();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        // 적용 o
        // sftpClient를 통해 세부 기능들을 구현하고 한번에 관련 기능을 접근할 수 있다.
        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();

        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();
    }

    // 콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }

}
