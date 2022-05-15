package com.github.adrianoluis.fxfp.util;

import java.math.BigDecimal;

public class NumberUtil {

	public static BigDecimal parseDecimal(String value) {
		return new BigDecimal(value.replaceAll(",", ""));
	}
}
