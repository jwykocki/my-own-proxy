package com.jw.framework;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class ProxyHandler implements InvocationHandler {

    private final Object objectToHandle;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("PROXY: Invoking method: {}", method.getName());

        if(isTransactional(method)){
            return handleTransactional(method, args);
        }
        method.invoke(objectToHandle, args);

        return null;
    }

    private Object handleTransactional(Method method, Object[] args) {
        Object invoke = null;
        try{
            log.info("PROXY: BEGIN TRANSACTION");
            invoke = method.invoke(objectToHandle, args);
            log.info("PROXY: COMMIT TRANSACTION");
        }catch (Exception e){
            log.info("PROXY: ROLLBACK TRANSACTION");
        }
        return invoke;

    }

    private boolean isTransactional(Method method) {
        try {
            return objectToHandle.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(MyTransactional.class);
        }catch (NoSuchMethodException e){
            throw new RuntimeException(method.getName());
        }
    }
}
