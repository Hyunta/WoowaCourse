package example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class App2 {
    public static void main(String[] args)
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
//        Settings settings1 = new Settings();
//        Settings settings2 = new Settings();

        /**
         * 1단계. 가장 순수하게 구현하는 방법
         * 문제점: 멀티스레드 환경에서 안전하지 못하다
         *
         * 2단계. 메서드를 synchronized 를 붙인다.
         * 문제점: 동기화를 처리하는 작업때문에 성능에 불이득이 생길 수 있다.
         *
         * 3단계. 이른 초기화(eager initialization)
         * 문제점: 클래스가 로딩되는 시점에 스태틱한 블럭이므로 미리 생성을 한다. 이 방법은 스레드 세이프하다, 이미 생성된 것을 전달하니까.
         * 하지만 단점은 미리 만든다는 것이다. 만약 인스턴스를 만드는 과정이 길고 메모리를 많이 든다면. 사용하지 않더라도 로딩할 때 리소스를 많이쓰고 안쓰는 객체를 미리 만드는 경우가 된다
         */
//        Settings settings1 = Settings.getInstance();
//        Settings settings2 = Settings.getInstance();
//
//        System.out.println(settings1);
//        System.out.println(settings2);
//        System.out.println(settings1 == settings2);

        /**
         * 어떻게 false를 만들까?
         * 1. 리플렉션
         */
//        Settings2 settings1 = Settings2.INSTANCE;
//        Settings2 settings2 = null;
//
//        Constructor<?>[] declaredConstructors = Settings2.class.getDeclaredConstructors();
//        for (Constructor<?> constructor : declaredConstructors) {
//            constructor.setAccessible(true);
//            settings2 = (Settings2) constructor.newInstance("INSTANCE");
//        }
//
//        System.out.println(settings1 == settings2);

        /**
         * 2. 직렬화 & 역직렬화
         */
//        Settings settings1 = Settings.getInstance();
//        Settings settings2 = null;
//
//        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings.obj"))) {
//            out.writeObject(settings1);
//        }
//
//        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings.obj"))) {
//            settings2 = (Settings) in.readObject();
//        }
//
//        System.out.println(settings1 == settings2);

    }
}
