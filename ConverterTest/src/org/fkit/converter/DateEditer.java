package org.fkit.converter;

import java.beans.PropertyEditorSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEditer extends PropertyEditorSupport {
	//将传入的字符串配型转换成Date类型
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = dateFormat.parse(text);
			setValue(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
