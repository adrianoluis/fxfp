package com.github.adrianoluis.fxfp.quicken;

import com.github.adrianoluis.fxfp.ExchangeFileReader;
import com.github.adrianoluis.fxfp.Transaction;
import com.github.adrianoluis.fxfp.quicken.parser.ItemParser;
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

import static com.github.adrianoluis.fxfp.quicken.parser.Fields.END_OF_THE_ENTRY;

public class QIFFileReader implements ExchangeFileReader {

	private final Reader reader;

	private StatementType type;

	private List<Transaction> transactions;

	private ItemParser<?> itemParser;

	public QIFFileReader(String fileName) throws FileNotFoundException {
		this.reader = new FileReader(fileName);
	}

	public QIFFileReader(File file) throws FileNotFoundException {
		this.reader = new FileReader(file);
	}

	public QIFFileReader(InputStream stream) {
		this.reader = new InputStreamReader(stream);
	}

	public QIFFileReader(Reader reader) throws FileNotFoundException {
		this.reader = reader;
	}

	@Override
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
				processLine(line);
			}
		} finally {
			bufferedReader.close();
		}
		return transactions;
	}

	private void processLine(String line) {
		if (null == type) {
			if ((type = processType(line)) != null) {
				itemParser = new ItemParser.Factory().parser(type);
				transactions = new ArrayList<>();
				return;
			}
		}
		if (null == type) throw new IllegalStateException("No transaction type identifier found");
		if (null == itemParser || !itemParser.canParseLine()) return;
		itemParser.parseLine(line);

		if (isEndOfEntry(line)) {
			transactions.add((Transaction) itemParser.build());
			itemParser = new ItemParser.Factory().parser(type);
		}
	}

	private boolean isEndOfEntry(String value) {
		return value.equals(END_OF_THE_ENTRY);
	}

	private StatementType processType(String line) {
		if (!line.startsWith("!Type:")) return null;
		return StatementType.toEnum(line.substring(line.indexOf(":") + 1));
	}
}
