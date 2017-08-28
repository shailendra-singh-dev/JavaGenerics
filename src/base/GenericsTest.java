package base;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.HashMap;

public class GenericsTest {

	public static void testClasses() {
		Class classObject = ImplClass.class;
		classObject = new ImplClass().getClass();
		try {
			classObject = Class.forName("base.ImplClass");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(classObject.getCanonicalName());

		classObject = boolean.class;
		System.out.println(classObject.getCanonicalName());

		classObject = Double.TYPE;
		System.out.println(classObject.getCanonicalName());

		classObject = String[][].class;
		System.out.println(classObject.getCanonicalName());

		Class superClassObject = classObject.getSuperclass();
		System.out.println(superClassObject);

		superClassObject = Object.class.getSuperclass();
		System.out.println(superClassObject);

		superClassObject = String[][].class.getSuperclass();
		System.out.println(superClassObject);

		Class[] declaredClasses = classObject.getDeclaredClasses();
		for (Class clazz : declaredClasses) {
			System.out.println(clazz.getSimpleName());
		}

		Class[] classes = classObject.getClasses();
		for (Class clazz : classes) {
			System.out.println(clazz.getSimpleName());
		}

		Type[] genericInterfaces = classObject.getGenericInterfaces();
		for (Type type : genericInterfaces) {
			System.out.println(type);
		}

	}

	public static void testFields() {
		Class classObject = ImplClass.class;
		Field field = null;
		try {
			field = classObject.getField("i");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		Class declaringClass = field.getDeclaringClass();
		System.out.println("declaringClass:" + declaringClass);

		Class fieldType = field.getType();
		System.out.println("fieldType:" + fieldType.getCanonicalName());

		ImplClass implClass = new ImplClass();
		try {
			int i = (Integer) field.get(implClass);
			field.set(implClass, 100);
			i = (Integer) field.get(implClass);
			System.out.println("i:" + i);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	public static void testMethods() {
		Class classObject = null;
		try {
			classObject = Class.forName("java.util.HashMap");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Class[] parameterTypes = new Class[] { Object.class, Object.class };
		Method method = null;
		try {
			method = classObject.getMethod("put", parameterTypes);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		System.out.println(method.getDeclaringClass());
		System.out.println(Modifier.toString(method.getModifiers()));
		System.out.println(method.getReturnType());

		HashMap<String, String> hashMap = null;
		try {
			hashMap = new HashMap<String, String>();
			method.invoke(hashMap, "key", "value");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		System.out.println(hashMap);
		
		classObject = ImplClass.class;
		try {
			method = classObject.getDeclaredMethod("privateMethod", parameterTypes);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		method.setAccessible(true);
		System.out.println(method);

	}

}
