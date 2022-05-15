package com.github.adrianoluis.fxfp;

import com.github.adrianoluis.fxfp.openfinancial.OFCFileReader;
import com.github.adrianoluis.fxfp.openfinancial.OFXFileReader;
import com.github.adrianoluis.fxfp.quicken.QIFFileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.List;
import java.util.Optional;

public interface ExchangeFileReader {

	String EXTENSION_QIF = "qif";

	String EXTENSION_OFC = "ofc";

	String EXTENSION_OFX = "ofx";

	List<Transaction> read() throws IOException;

	final class Factory {

		private static Optional<String> fileExtension(String filename) {
			return Optional.ofNullable(filename)
				.filter(f -> f.contains("."))
				.map(f -> f.substring(filename.lastIndexOf(".") + 1));
		}

		public static ExchangeFileReader newReader(String fileName) throws FileNotFoundException {
			final Optional<String> fileExt = fileExtension(fileName);
			if (!fileExt.isPresent()) return null;
			switch (fileExt.get()) {
				case EXTENSION_QIF:
					return new QIFFileReader(fileName);
				case EXTENSION_OFC:
					return new OFCFileReader(fileName);
				case EXTENSION_OFX:
					return new OFXFileReader(fileName);
				default:
					return null;
			}
		}

		public static ExchangeFileReader newReader(File file) throws FileNotFoundException {
			final Optional<String> fileExt = fileExtension(file.getName());
			if (!fileExt.isPresent()) return null;
			switch (fileExt.get()) {
				case EXTENSION_QIF:
					return new QIFFileReader(file);
				case EXTENSION_OFC:
					return new OFCFileReader(file);
				case EXTENSION_OFX:
					return new OFXFileReader(file);
				default:
					return null;
			}
		}

		public static ExchangeFileReader newReader(String fileName, InputStream stream) {
			final Optional<String> fileExt = fileExtension(fileName);
			if (!fileExt.isPresent()) return null;
			switch (fileExt.get()) {
				case EXTENSION_QIF:
					return new QIFFileReader(stream);
				case EXTENSION_OFC:
					return new OFCFileReader(stream);
				case EXTENSION_OFX:
					return new OFXFileReader(stream);
				default:
					return null;
			}
		}

		public static ExchangeFileReader newReader(String fileName, Reader reader) throws FileNotFoundException {
			final Optional<String> fileExt = fileExtension(fileName);
			if (!fileExt.isPresent()) return null;
			switch (fileExt.get()) {
				case EXTENSION_QIF:
					return new QIFFileReader(reader);
				case EXTENSION_OFC:
					return new OFCFileReader(reader);
				case EXTENSION_OFX:
					return new OFXFileReader(reader);
				default:
					return null;
			}
		}
	}
}
