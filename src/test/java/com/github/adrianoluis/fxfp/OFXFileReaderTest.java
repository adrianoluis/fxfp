package com.github.adrianoluis.fxfp;

import com.github.adrianoluis.fxfp.openfinancial.OFXFileReader;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OFXFileReaderTest {

    @Test
    public void testWithDatesWithoutTimezone() throws Throwable {
        final InputStream is = getClass().getClassLoader().getResourceAsStream("example1.ofx");
        final List<Transaction> transactions = new OFXFileReader(is).read();

        final Transaction firstTransaction = transactions.get(0);
        assertEquals(Transaction.Type.CHECK, firstTransaction.getType());
        assertEquals(LocalDate.of(1996, 10, 4), firstTransaction.getPostedOn());

        final Transaction secondTransaction = transactions.get(1);
        assertEquals(Transaction.Type.ATM_WITHDRAWAL, secondTransaction.getType());
        assertEquals("00003", secondTransaction.getInstitutionId());
    }

    @Test
    public void testWithDatesWithTimezone() throws Throwable {
        final InputStream is = getClass().getClassLoader().getResourceAsStream("example2.ofx");
        final List<Transaction> transactions = new OFXFileReader(is).read();

        final Transaction firstTransaction = transactions.get(0);
        assertEquals(Transaction.Type.ELECTRONIC_PAYMENT, firstTransaction.getType());
        assertEquals(LocalDate.of(2005, 8, 24), firstTransaction.getPostedOn());
        assertEquals("219378", firstTransaction.getInstitutionId());
        assertEquals("FrogKick Scuba Gear", firstTransaction.getName());
    }
}
