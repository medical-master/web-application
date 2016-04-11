package com.medicalmaster.common.helper;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.medicalmaster.common.workstation.QueryWorkstationRequest;

/**
 * 反射
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月8日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class ReflectionHelper {

	/**
	 * 获取属性
	 * 
	 * @param cs
	 * @param includeSuperFields
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static List<Field> getDeclaredFields(Class cs, boolean includeSuperFields) {
		List<Field> list = new ArrayList<Field>();
		Field[] fields = cs.getDeclaredFields();
		list.addAll(Arrays.asList(fields));

		if (includeSuperFields) {
			getSuperDeclaredFields(cs, list);
		}

		return list;
	}

	/**
	 * 获取父类属性
	 * 
	 * @param cs
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	static void getSuperDeclaredFields(Class cs, List<Field> list) {
		Class superClass = cs.getSuperclass();

		if (superClass == null) {
			return;
		}

		Field[] fields = superClass.getDeclaredFields();
		list.addAll(Arrays.asList(fields));

		getSuperDeclaredFields(superClass, list);
	}

	/**
	 * 获取属性
	 * 
	 * @param cz
	 * @param fieldName
	 * @param includeSuperClass
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("rawtypes")
	public static Field getDeclaredField(Class cz, String fieldName, boolean includeSuperClass)
			throws NoSuchFieldException, SecurityException {
		Field field = null;
		try {
			field = cz.getDeclaredField(fieldName);
		} catch (Exception exception) {

		}

		if (includeSuperClass && field == null) {
			return getSuperDeclaredField(cz, fieldName);
		}

		return field;
	}

	/**
	 * 
	 * @param cz
	 * @param filedName
	 * @return
	 * @throws SecurityException
	 * @throws NoSuchFieldException
	 */
	@SuppressWarnings("rawtypes")
	static Field getSuperDeclaredField(Class cz, String fieldName) throws NoSuchFieldException, SecurityException {
		Class superCz = cz.getSuperclass();
		if (superCz == null) {
			return null;
		}

		Field field = null;
		try {
			field = superCz.getDeclaredField(fieldName);
		} catch (Exception exception) {
		}

		if (field != null) {
			return field;
		}

		return getSuperDeclaredField(superCz, fieldName);
	}

	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		Field field = getDeclaredField(QueryWorkstationRequest.class, "action", true);
		System.out.println(field.getName());
	}
}
