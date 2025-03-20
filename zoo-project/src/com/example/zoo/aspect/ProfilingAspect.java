package com.example.zoo.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingAspect implements InvocationHandler {
	private Object target;
	
	public ProfilingAspect(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var begin = System.nanoTime();
		var result = method.invoke(target, args);
		var end = System.nanoTime();
		System.err.println("%s runs %d ns.".formatted(method.getName(),end-begin));
		return result;
	}

}
