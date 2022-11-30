package hello.core.singleton;

public class SingletonService {

    //자기자신을 static으로 가지기 때문에 클래스 레벨에 올라가서 오직 1개만 존재
    private static final SingletonService instance = new SingletonService();
                                                        //실행을 하면 싱글톤서비스의 static 영역에
    public static SingletonService getInstance() {      //(자기자신)객체를 생성해서 인스턴스로 넣어둠
        return instance;
    }

    private SingletonService() {    //싱글톤서비스가 다른 곳에서 실행되는 것을 막아줌(객체의 생성을 막음)
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
