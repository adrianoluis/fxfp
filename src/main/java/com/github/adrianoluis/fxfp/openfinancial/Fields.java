package com.github.adrianoluis.fxfp.openfinancial;

public final class Fields {

	/**
	 * Start tag of OFC file
	 */
	static final String OFC = "OFC";

	/**
	 * Start tag of OFC file
	 */
	static final String OFX = "OFX";

	/**
	 * Start tag for statement transaction aggregate
	 */
	static final String STMTTRN = "STMTTRN";

	/**
	 * Type of transaction
	 */
	static final String TRNTYPE = "TRNTYPE";

	/**
	 * Date transaction was posted to the account
	 */
	static final String DTPOSTED = "DTPOSTED";

	/**
	 * Amount of transaction
	 */
	static final String TRNAMT = "TRNAMT";

	/**
	 * Transaction identifier issued by financial institution
	 */
	static final String FITID = "FITID";

	/**
	 * Client assigned transaction identifier
	 */
	static final String CLTID = "CLTID";

	/**
	 * Reference number for transaction
	 */
	static final String CHKNUM = "CHKNUM";

	/**
	 * Reference number for transaction
	 */
	static final String CHECKNUM = "CHECKNUM";

	/**
	 * Standard Industrial Code
	 */
	static final String SIC = "SIC";

	/**
	 * Payee identifier for payee
	 */
	static final String PAYEEID = "PAYEEID";

	/**
	 * Name of payee Note: The STMTTRN must include a NAME or a PAYEE, but not both.
	 */
	static final String NAME = "NAME";

	/**
	 * Description of transaction
	 */
	static final String MEMO = "MEMO";

	/**
	 * Payee aggregate for the payee. Note: The STMTTRN must include a NAME or a PAYEE, but not both.
	 */
	static final String PAYEE = "PAYEE";

	private Fields() {
	}
}
