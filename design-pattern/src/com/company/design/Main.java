package com.company.design;

import com.company.design.adapter.*;
import com.company.design.aop.AopBrowser;
import com.company.design.decorator.*;
import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;
import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;
import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;
import com.company.design.strategy.*;

import java.util.concurrent.atomic.AtomicLong;

public class Main {

    public static void main(String[] args) {
        //싱글톤
        /*AClazz aClazz = new AClazz();
        BClazz bClazz = new BClazz();

        SocketClient aClient = aClazz.getSocketClient();
        SocketClient bClient = bClazz.getSocketClient();

        System.out.println("두개의 객체가 동일한가?");
        System.out.println(aClient.equals(bClient));*/

        //어댑터
        /*HairDryer hairDryer = new HairDryer();
        connect(hairDryer);

        Cleaner cleaner = new Cleaner();
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V adapter2 = new SocketAdapter(airConditioner);
        connect(adapter2);*/

        //Proxy
        /*Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        browser.show();

        IBrowser browser1 = new BrowserProxy("www.naver.com");
        browser1.show();
        browser1.show();
        browser1.show();
        browser1.show();*/

        //AOP
        /*AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();

        IBrowser aopBrowser = new AopBrowser("www.naver.com",
                ()->{
                    System.out.println("before");
                    start.set(System.currentTimeMillis());
                },
                ()->{
                    long now = System.currentTimeMillis();
                    end.set(now - start.get());
                }
        );
        aopBrowser.show();
        System.out.println("loading time : "+end.get());

        aopBrowser.show();
        System.out.println("loading time : "+end.get());*/

        //decorator
        /*ICar audi = new Audi(1000);
        audi.showPrice();

        ICar audi3 = new A3(audi,"A3");
        audi3.showPrice();

        ICar audi4 = new A4(audi,"A4");
        audi4.showPrice();

        ICar audi5 = new A5(audi,"A5");
        audi5.showPrice();*/

        //observer
        /*Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });

        button.click("message1");
        button.click("message2");
        button.click("message3");
        button.click("message4");*/

        //facade 사용하지 않으면
       /* Ftp ftpClient = new Ftp("www.foo.co.kr",22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();*/

        //facade
        /*SftpClient sftpClient = new SftpClient("www.foo.co.kr",22,"/home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.write();
        sftpClient.read();
        sftpClient.disConnect();*/

        //strategy
        Encoder encoder = new Encoder();

        EncodingStrategy base64 = new Base64Strategy();

        EncodingStrategy normal = new NormalStrategy();
        String message ="hello java";
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);

        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);

        System.out.println(base64Result);
        System.out.println(normalResult);

        encoder.setEncodingStrategy(new AppendStrategy());
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
    // 콘센트
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}
