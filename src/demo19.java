import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
//反射-动态代理
public class demo19 {
    public static void main(String[] args) {
        //被代理的真实对象
        RealSubject realSubject = new RealSubject();

        //我们要代理哪个真实对象，就将该对象传进去，最后是通过该真实对象来调用其方法的
        InvocationHandler handler = new Invocation(realSubject);

        /**
         * newProxyInstance 的三个参数
         * ClassLoader loader：指定一个动态加载代理类的类加载器
         *
         * Class<?>[] interfaces：指明被代理类实现的接口，之后我们通过拼接字节码生成的类才能知道调用哪些方法。
         *
         * InvocationHandler h：这是一个方法委托类，我们通过代理调用被代理类的方法时，就可以将方法名和方法参数都委托给这个委托类。
         */
        Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(),realSubject.getClass().getInterfaces(),handler);
        System.out.println(subject.getClass().getName());
        subject.hello("World");
    }
}

interface Subject {
    void hello(String str);
}

class RealSubject implements Subject {
    @Override
    public void hello(String name) {
        System.out.println("Hello " + name);
    }
}

class Invocation implements InvocationHandler {
    private Object ProxyObject;

    public Invocation(Object ProxyObject) {
        this.ProxyObject = ProxyObject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前置操作");
        System.out.println("开始调用函数");

        Object obj = method.invoke(this.ProxyObject, args);
        System.out.println("调用后置操作");

        return obj;
    }
}
