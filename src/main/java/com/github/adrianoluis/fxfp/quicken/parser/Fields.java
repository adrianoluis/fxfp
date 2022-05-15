package com.github.adrianoluis.fxfp.quicken.parser;

public final class Fields {

	/**
	 * Prefix for Address (up to five lines; the sixth line is an optional message)
	 */
	static final String ADDRESS = "A";

	/**
	 * Prefix for Budget amount (only in a Budget Amounts QIF file)
	 */
	static final String BUDGET_AMOUNT = "B";

	/**
	 * Prefix for Cleared status
	 */
	static final String CLEARED_STATUS = "C";

	/**
	 * Prefix for Date
	 */
	static final String DATE = "D";

	/**
	 * Prefix for Description
	 */
	static final String DESCRIPTION = "D";

	/**
	 * Prefix for Expense category (if category type is unspecified, quicken assumes expense type)
	 */
	static final String EXPENSE_CATEGORY = "E";

	/**
	 * Prefix for Memo in split
	 */
	static final String MEMO_IN_SPLIT = "E";

	/**
	 * Prefix for Income category
	 */
	static final String INCOME_CATEGORY = "I";

	/**
	 * Prefix for Price
	 */
	static final String PRICE = "I";

	/**
	 * Prefix for Account for the transfer
	 */
	static final String TRANSFER_ACCOUNT = "L";

	/**
	 * Prefix for Category (Category/Subcategory/Transfer/Class)
	 */
	static final String CATEGORY = "L";

	/**
	 * Prefix for Credit limit (only for credit card accounts)
	 */
	static final String CREDIT_LIMIT = "L";

	/**
	 * Prefix for Memo
	 */
	static final String MEMO = "M";

	/**
	 * Prefix for Action
	 */
	static final String ACTION = "N";

	/**
	 * Prefix for Num (check or reference number)
	 */
	static final String REFERENCE_NUMBER = "N";

	/**
	 * Prefix for Class name
	 */
	static final String NAME = "N";

	/**
	 * Prefix for Commission
	 */
	static final String COMMISSION = "O";

	/**
	 * Prefix for Text in the first line for transfers and reminders
	 */
	static final String REMINDER_FIRST_LINE = "P";

	/**
	 * Prefix for Payee
	 */
	static final String PAYEE = "P";

	/**
	 * Prefix for Quantity (number of new shares or split ratio)
	 */
	static final String QUANTITY = "Q";

	/**
	 * Prefix for Quantity (number of old shares or split ratio)
	 */
	static final String QUANTITY_VARIANT = "R";

	/**
	 * Prefix for Tax schedule information
	 */
	static final String TAX_SCHEDULE_INFORMATION = "R";

	/**
	 * Prefix for Category in split (Category/Transfer/Class)
	 */
	static final String CATEGORY_IN_SPLIT = "S";

	/**
	 * Prefix for Amount
	 */
	static final String AMOUNT = "T";

	/**
	 * Prefix for Tax related if included, not tax related if omitted
	 */
	static final String TAX_RELATED = "T";

	/**
	 * Prefix for Type of account
	 */
	static final String TYPE = "T";

	/**
	 * Prefix for Variant Amount of Item
	 */
	static final String AMOUNT_VARIANT = "U";

	/**
	 * Prefix for Security
	 */
	static final String SECURITY = "Y";

	/**
	 * Prefix for Transaction type
	 */
	static final String TRANSACTION_TYPE = "K";

	/**
	 * Prefix for Amortization: First payment date
	 */
	static final String AMORTIZATION_FIRST_PAYMENT_DATE = "1";

	/**
	 * Prefix for Amortization: Total years for loan
	 */
	static final String AMORTIZATION_TOTAL_YEARS_FOR_LOAN = "2";

	/**
	 * Prefix for Amortization: Number of payments already made
	 */
	static final String AMORTIZATION_PAYMENTS_ALREADY_MADE = "3";

	/**
	 * Prefix for Amortization: Number of periods per year
	 */
	static final String AMORTIZATION_PERIODS_PER_YEAR = "4";

	/**
	 * Prefix for Amortization: Interest rate
	 */
	static final String AMORTIZATION_INTEREST_RATE = "5";

	/**
	 * Prefix for Amortization: Current loan balance
	 */
	static final String AMORTIZATION_CURRENT_LOAN_BALANCE = "6";

	/**
	 * Prefix for Amortization: Current loan balance
	 */
	static final String AMORTIZATION_ORIGINAL_LOAN_BALANCE = "7";

	/**
	 * Prefix for Amount transferred
	 */
	static final String AMOUNT_TRANSFERRED = "$";

	/**
	 * Prefix for Statement balance date
	 */
	static final String STATEMENT_BALANCE_DATE = "/";

	/**
	 * Prefix for Statement balance amount
	 */
	static final String STATEMENT_BALANCE_AMOUNT = "$";

	/**
	 * Prefix for Dollar amount of split
	 */
	static final String AMOUNT_OF_SPLIT = "$";

	/**
	 * Prefix for End of the entry
	 */
	public static final String END_OF_THE_ENTRY = "^";

	private Fields() {
	}
}
