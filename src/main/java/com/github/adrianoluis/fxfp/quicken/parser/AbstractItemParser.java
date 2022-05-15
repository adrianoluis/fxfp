package com.github.adrianoluis.fxfp.quicken.parser;

import com.github.adrianoluis.fxfp.util.DateUtil;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractItemParser<T> implements ItemParser<T> {

	static String getFieldType(String value) {
		String fieldType;
		if (value.startsWith("X")) {
			fieldType = value.substring(0, 2);
		} else {
			fieldType = value.substring(0, 1);
		}
		return fieldType;
	}

	static String getFieldValue(String value) {
		String fieldType;
		if (value.startsWith("X")) {
			fieldType = value.substring(2);
		} else {
			fieldType = value.substring(1);
		}
		return fieldType;
	}

	static LocalDate parseDate(String value) {
		return DateUtil.parse(DateUtil.Parser.QUICKEN, value);
	}

	static List<String> parseList(String value) {
		return new ArrayList<>(Arrays.asList(value.replaceAll("[\\[\\]]", "").split(",")));
	}
}
