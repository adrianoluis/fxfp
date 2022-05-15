package com.github.adrianoluis.fxfp.quicken.parser;

import com.github.adrianoluis.fxfp.Transaction;
import com.github.adrianoluis.fxfp.quicken.StatementType;
import com.github.adrianoluis.fxfp.util.NumberUtil;
import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

import static com.github.adrianoluis.fxfp.quicken.StatementType.BANK;
import static com.github.adrianoluis.fxfp.quicken.StatementType.CASH;
import static com.github.adrianoluis.fxfp.quicken.StatementType.CREDIT_CARD;
import static com.github.adrianoluis.fxfp.quicken.StatementType.INVESTMENT;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.ACTION;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.ADDRESS;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.AMOUNT;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.AMOUNT_OF_SPLIT;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.AMOUNT_TRANSFERRED;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.AMOUNT_VARIANT;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.CATEGORY;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.CATEGORY_IN_SPLIT;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.CLEARED_STATUS;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.COMMISSION;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.DATE;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.MEMO;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.MEMO_IN_SPLIT;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.PAYEE;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.PRICE;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.QUANTITY;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.REFERENCE_NUMBER;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.REMINDER_FIRST_LINE;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.SECURITY;
import static com.github.adrianoluis.fxfp.quicken.parser.Fields.TRANSFER_ACCOUNT;

public class TransactionParser extends AbstractItemParser<Transaction> {

	private final Transaction.TransactionBuilder builder;

	private final StatementType statementType;

	private int addressLineCount = 0;

	private String mainCategory;

	private StringBuilder addressBuilder;

	private Set<String> memoInSplit;

	private Set<String> categoryInSplit;

	private Set<BigDecimal> amountOfSplit;

	public TransactionParser(StatementType statementType) {
		this.statementType = statementType;
		this.builder = Transaction.builder();
	}

	private void parseNonInvestment(String type, String value) {
		switch (type) {
			case REFERENCE_NUMBER:
				builder.referenceNumber(value);
				break;
			case PAYEE:
				builder.payee(value);
				break;
			case CATEGORY:
				mainCategory = value;
				builder.category(new LinkedHashSet<>(parseList(value)));
				break;
			case ADDRESS:
				if (addressLineCount > 6 || value.trim().equals("")) break;
				if (null == addressBuilder) {
					addressBuilder = new StringBuilder(value);
				} else {
					addressBuilder.append("\n").append(value);
					addressLineCount++;
				}
				break;
			case CATEGORY_IN_SPLIT:
				if (null == categoryInSplit) {
					categoryInSplit = new LinkedHashSet<>(parseList(mainCategory));
					builder.categoryInSplit(categoryInSplit)
						.category(null);
				}
				categoryInSplit.addAll(parseList(value));
				break;
			case MEMO_IN_SPLIT:
				if (null == memoInSplit) {
					memoInSplit = new LinkedHashSet<>();
					builder.memoInSplit(memoInSplit);
				}
				memoInSplit.add(value);
				break;
			case AMOUNT_OF_SPLIT:
				if (null == amountOfSplit) {
					amountOfSplit = new LinkedHashSet<>();
					builder.amountOfSplit(amountOfSplit);
				}
				amountOfSplit.add(NumberUtil.parseDecimal(value));
				break;
		}
	}

	private void parseInvestment(String type, String value) {
		switch (type) {
			case ACTION:
				builder.action(value);
				break;
			case REMINDER_FIRST_LINE:
				builder.reminderFirstLine(value);
				break;
			case TRANSFER_ACCOUNT:
				builder.transferAccount(value);
				break;
			case SECURITY:
				builder.security(value);
				break;
			case PRICE:
				builder.price(NumberUtil.parseDecimal(value));
				break;
			case QUANTITY:
				builder.quantity(NumberUtil.parseDecimal(value));
				break;
			case COMMISSION:
				builder.commission(NumberUtil.parseDecimal(value));
				break;
			case AMOUNT_TRANSFERRED:
				builder.amountTransferred(NumberUtil.parseDecimal(value));
				break;
		}
	}

	@Override
	public boolean canParseLine() {
		return statementType.equals(BANK) || statementType.equals(CASH) || statementType.equals(CREDIT_CARD) ||
			statementType.equals(INVESTMENT);
	}

	@Override
	public void parseLine(String line) {
		if (!canParseLine()) return;
		final String type = getFieldType(line);
		final String value = getFieldValue(line);

		switch (type) {
			case DATE:
				builder.postedOn(parseDate(value));
				break;
			case AMOUNT:
			case AMOUNT_VARIANT:
				builder.amount(NumberUtil.parseDecimal(value));
				break;
			case CLEARED_STATUS:
				builder.clearedStatus(Transaction.ClearedStatus.toEnum(value));
				break;
			case MEMO:
				builder.memo(value);
				break;
			default:
				if (statementType == INVESTMENT) {
					parseInvestment(type, value);
				} else {
					parseNonInvestment(type, value);
				}
		}
	}

	@Override
	public Transaction build() {
		if (null != addressBuilder) {
			builder.address(addressBuilder.toString());
		}
		return builder.build();
	}
}
