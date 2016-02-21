package com.medicalmaster.web.control;

import java.lang.reflect.Field;

import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Validator;

public class FieldValidator implements Validator{
	private String name = "action";
	private String validValue = "inviteMaster";
	private String invalidValue;
	
	@Override
	public boolean validate(Context context) {
		try {
			Field f =context.getClass().getDeclaredField(name);
			f.setAccessible(true);
			Object value = f.get(context);
			if(validValue != null && validValue.equals(value.toString()))
				return true;
			
			if(invalidValue != null && invalidValue.equals(value.toString()))
				return false;
		} catch (Throwable e) {
			throw new RuntimeException(e);
		}
		
		throw new RuntimeException("Invalid value");
	}

}
