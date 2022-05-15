package com.github.adrianoluis.fxfp.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DateUtil {

	private static final DateTimeFormatter FORMATTER_OPEN_FINANCIAL = DateTimeFormatter.ofPattern("[yyyyMMdd][yyyyMMddHHmmss][yyyyMMddHHmmss.SSSS]['['x:z']']");
	private static final DateTimeFormatter FORMATTER_QUICKEN = new DateTimeFormatterBuilder().appendPattern("[M][MM]/[dd][ d][d]/[uuuu]")
		.optionalStart()
		.appendValueReduced(ChronoField.YEAR, 2, 2, 1950)
		.optionalEnd()
		.toFormatter();

	private DateUtil() {
	}

	/**
	 * Converts zone-offset into the right format if needed.
	 *
	 * @param value String date representation
	 * @return Normalized date format
	 */
	private static String normalizeOpenFinancialDateValue(String value) {
		if (!value.contains("[")) return value;
		// isolate the zone-offset data
		final String zoneOffset = value.substring(value.indexOf("[") + 1, value.indexOf("]"));
		// isolate the zone id
		final String zone = zoneOffset.substring(zoneOffset.indexOf(":") + 1);
		// isolate the offset amount as integer
		final int offset = Integer.parseInt(zoneOffset.substring(0, zoneOffset.indexOf(":")));
		// perform code formatting to add a leading 0
		final String normalizedZoneOffset = String.format("%03d", offset) + ":" + zone;
		// isolate datetime data
		final String dateTime = value.substring(0, value.indexOf("["));
		// rebuild full date with normalized zone-offset data
		return dateTime + "[" + normalizedZoneOffset + "]";
	}

	public static LocalDate parse(Parser parser, String value) {
		if (parser == Parser.OPEN_FINANCIAL) {
			return LocalDate.parse(normalizeOpenFinancialDateValue(value), FORMATTER_OPEN_FINANCIAL);
		}
		return LocalDate.parse(value, FORMATTER_QUICKEN);
	}

	public enum Parser {
		OPEN_FINANCIAL, QUICKEN
	}
}
