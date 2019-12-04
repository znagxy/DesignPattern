package proxypattern.dynamicpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyFactory {

    private Object target;

    public DynamicProxyFactory(Object target){
        this.target = target;
    }

    public Object getProxyInstance(){
        ClassLoader classLoader = target.getClass().getClassLoader();
        Class<?>[] classes = target.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                start();
                Object invoke = method.invoke(target, args);
                end();
                return invoke;
            }
        };
        return Proxy.newProxyInstance(classLoader,classes,invocationHandler);
    }



    private void start(){
        System.out.println("dynamic static proxy...");
    }

    private void end(){
        System.out.println("dynamic static proxy...");
    }
}
