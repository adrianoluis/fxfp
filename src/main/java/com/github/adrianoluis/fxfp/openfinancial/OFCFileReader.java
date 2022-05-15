package com.github.adrianoluis.fxfp.openfinancial;

import com.github.adrianoluis.fxfp.ExchangeFileReader;
import com.github.adrianoluis.fxfp.Transaction;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import static com.github.adrianoluis.fxfp.openfinancial.Fields.CHKNUM;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.OFC;
import static com.github.adrianoluis.fxfp.openfinancial.Fields.STMTTRN;

public class OFCFileReader extends SGMLBasedFileReader implements ExchangeFileReader {

	private final Reader reader;

	private final List<Transaction> transactions = new ArrayList<>();

	public OFCFileReader(String fileName) throws FileNotFoundException {
		this.reader = new FileReader(fileName);
	}

	public OFCFileReader(File file) throws FileNotFoundException {
		this.reader = new FileReader(file);
	}

	public OFCFileReader(InputStream stream) {
		this.reader = new InputStreamReader(stream);
	}

	public OFCFileReader(Reader reader) throws FileNotFoundException {
		this.reader = reader;
	}

	public List<Transaction> read() throws IOException {
		final BufferedReader bufferedReader;
		if (reader instanceof BufferedReader) {
			bufferedReader = (BufferedReader) reader;
		} else {
			bufferedReader = new BufferedReader(reader);
		}
		try {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				processLine(0, line);
			}
		} finally {
			bufferedReader.close();
		}
		return transactions;
	}

	@Override
	protected void processValue(String value) {
		if (CHKNUM.equals(lastOpenTag())) {
			transactionBuilder.referenceNumber(value);
		}
	}

	@Override
	protected void openTag(String tag) {
		if (!hasTagsOpened() && !tag.equals(OFC)) {
			throw new IllegalArgumentException();
		}
		if (tag.equals(STMTTRN)) {
			createTransaction();
		}
		super.openTag(tag);
	}

	@Override
	protected void closeTag(String tag) {
		super.closeTag(tag);
		if (null == transactionBuilder) return;
		if (tag.equals(STMTTRN)) {
			transactions.add(transactionBuilder.build());
			transactionBuilder = null;
		}
	}

	private void createTransaction() {
		if (null != transactionBuilder) {
			transactions.add(transactionBuilder.build());
		}
		transactionBuilder = Transaction.builder();
	}
}
