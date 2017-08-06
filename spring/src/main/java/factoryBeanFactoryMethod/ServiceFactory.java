package factoryBeanFactoryMethod;

/**
 * Created by wangxichun on 2017/8/6 0006.
 */
public class ServiceFactory {
    private static UserService userService= new UserService();
    private static LoginService loginService= new LoginService();
    private static ServiceFactory serviceFactory= new ServiceFactory();
    private ServiceFactory(){
        System.out.println("ServiceFactory instance created");
    }

    public  UserService createUserService(){
        return userService;
    }
    public  LoginService createLoginService(){
        return loginService;
    }
    public static ServiceFactory createInstance(){
        return serviceFactory;
    }
}
