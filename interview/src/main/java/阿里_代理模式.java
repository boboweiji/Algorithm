import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class 阿里_代理模式 {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap();
        Map<String,Object> proxy =  (Map<String,Object>) getProxyInstance(map);
        System.out.println(proxy.getClass());
        System.out.println(proxy.containsKey("1"));
    }

    public static Object getProxyInstance(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub
                        System.out.println("代理前置方法~~");
                        Object returnVal = method.invoke(target, args);
                        System.out.println("代理后置方法");
                        return returnVal;
                    }
                });
    }
}
