package com.github.adrianoluis.fxfp.openfinancial;

import com.github.adrianoluis.fxfp.Transaction;
import com.github.adrianoluis.fxfp.util.DateUtil;
import com.github.adrianoluis.fxfp.util.NumberUtil;
import java.util.ArrayList;
import java.util.List;

import static com.github.adrianoluis.fxfp.openfinancial.Fields.CLTID;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.DTPOSTED;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.FITID;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.MEMO;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.NAME;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.PAYEE;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.PAYEEID;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.SIC;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.TRNAMT;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.TRNTYPE;

public abstract class SGMLBasedFileReader {

	protected static final String LESS_THAN = "<";

	protected static final String LESS_THAN_SLASH = "</";

	protected static final String GREATER_THAN = ">";

	protected static final String GREATER_THAN_SLASH = "/>";

	private final List<String> openTags = new ArrayList<>();

	protected Transaction.TransactionBuilder transactionBuilder;

	private boolean startsWith(int position, String content, String s) {
		return content.length() >= position + s.length() && content.startsWith(s, position);
	}

	protected void closeTag(String tag) {
		if (!lastOpenTag().equals(tag)) closeTag(lastOpenTag());
		openTags.remove(openTags.size() - 1);
	}

	protected boolean hasTagsOpened() {
		return !openTags.isEmpty();
	}

	protected void openTag(String tag) {
		openTags.add(tag);
	}

	protected final String lastOpenTag() {
		if (openTags.isEmpty()) return "";
		return openTags.get(openTags.size() - 1);
	}

	protected void processLine(int position, String line) {
		// escape recursive
		if (line.length() == position) return;
		// get position to tag close
		int tagEnd = line.indexOf(GREATER_THAN, position);
		if (startsWith(position, line, LESS_THAN_SLASH)) {
			closeTag(line.substring(position + 2, tagEnd));
			processLine(tagEnd + 1, line);
		} else if (startsWith(position, line, LESS_THAN)) {
			openTag(line.substring(position + 1, tagEnd));
			processLine(tagEnd + 1, line);
		} else {
			int next = line.indexOf(LESS_THAN, position);
			if (next == -1) {
				next = line.length();
			}
			String value = line.substring(position, next).trim();
			if (!value.trim().equals("")) {
				innerProcessValue(value);
			}
			processLine(next, line);
		}
	}

	private void innerProcessValue(String value) {
		// check if a transaction was created
		if (null == transactionBuilder) return;
		switch (lastOpenTag()) {
			case TRNTYPE:
				Transaction.Type type;
				if (value.length() > 1) {
					type = Transaction.Type.toEnum(value);
				} else {
					type = Transaction.Type.toEnum(value.charAt(0));
				}
				transactionBuilder.type(type);
				break;
			case DTPOSTED:
				transactionBuilder.postedOn(DateUtil.parse(DateUtil.Parser.OPEN_FINANCIAL, value));
				break;
			case TRNAMT:
				transactionBuilder.amount(NumberUtil.parseDecimal(value));
				break;
			case FITID:
				transactionBuilder.institutionId(value);
				break;
			case CLTID:
				transactionBuilder.clientId(value);
				break;
			case SIC:
				transactionBuilder.industrialCode(value);
				break;
			case PAYEEID:
				transactionBuilder.payeeId(value);
			case PAYEE:
				transactionBuilder.payee(value);
				break;
			case NAME:
				transactionBuilder.name(value);
				break;
			case MEMO:
				transactionBuilder.memo(value);
				break;
			default:
				processValue(value);
		}
	}

	protected abstract void processValue(String value);
}
