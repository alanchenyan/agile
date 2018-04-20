package part_1.imageutil.tests;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class SingleFactory {

	private static Map<Class, Object> beansMap = new HashMap<Class, Object>();

	public static Object getSingleInstance(Class cls) {

		Object bean = beansMap.get(cls);
		if (bean == null) {
			try {
				Constructor con = cls.getDeclaredConstructor();
				con.setAccessible(true);
				bean = con.newInstance();
				beansMap.put(cls, bean);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}

		return bean;
	}
}
