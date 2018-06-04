package by.kir;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class JopMethodInterceptor implements MethodInterceptor {

    private Object value;

    public JopMethodInterceptor(Object value) {
        this.value = value;
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        if (value == null) {
            return null;
        } else {
            Object invoke = proxy.invoke(value, args);
            if (invoke != null && !Modifier.isFinal(invoke.getClass().getModifiers())) {
                return Jop.of(invoke, method.getReturnType());
            }else {
                return invoke;
            }
        }
    }
}
