package by.kir;

import net.sf.cglib.proxy.Enhancer;

public class Jop {

    static {

    }

    public static <T> T of(T t) {
        return Jop.of(t, t.getClass());
    }

    public static <T> T of(T t, Class<?> returnType) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(returnType);
        enhancer.setCallback(new JopMethodInterceptor(t));
        T res = (T) enhancer.create();
        return res;
    }
}
