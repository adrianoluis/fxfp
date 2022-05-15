package com.github.adrianoluis.fxfp.quicken;

public enum StatementType {

	/**
	 * Bank account transactions
	 */
	BANK("Bank"),

	/**
	 * Cash account transactions
	 */
	CASH("Cash"),

	/**
	 * Credit card account transactions
	 */
	CREDIT_CARD("CCard"),

	/**
	 * Investment account transactions
	 */
	INVESTMENT("Invst"),

	/**
	 * Asset account transactions
	 */
	OTHER_ASSET("Oth A"),

	/**
	 * Liability account transactions
	 */
	OTHER_LIABILITY("Oth L"),

	/**
	 * Category list
	 */
	CATEGORY("Cat"),

	/**
	 * Class list
	 */
	CLASS("Class"),

	/**
	 * Memorized transaction list
	 */
	MEMORIZED("Memorized");

	private final String value;

	StatementType(final String header) {
		this.value = header;
	}

	public final String value() {
		return value;
	}

	public static StatementType toEnum(String value) {
		for (StatementType type : values()) {
			if (type.value.equals(value)) {
				return type;
			}
		}
		throw new IllegalArgumentException("Invalid for statement type identifier: " + value);
	}
}
