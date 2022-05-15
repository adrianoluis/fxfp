package com.github.adrianoluis.fxfp.quicken.parser;

import com.github.adrianoluis.fxfp.quicken.StatementType;

public interface ItemParser<T> {

	boolean canParseLine();

	void parseLine(String line);

	T build();

	final class Factory {

		public ItemParser<?> parser(StatementType type) {
			switch (type) {
				case BANK:
				case CASH:
				case CREDIT_CARD:
				case INVESTMENT:
					return new TransactionParser(type);
			}
			return null;
		}
	}
}
