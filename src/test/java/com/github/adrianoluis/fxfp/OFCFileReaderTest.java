package com.github.adrianoluis.fxfp;

import com.github.adrianoluis.fxfp.openfinancial.OFCFileReader;
import java.time.LocalDate;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class OFCFileReaderTest {

    @Test
    public void testWithDatesWithoutTimezone() throws Throwable {
        final InputStream is = getClass().getResourceAsStream("/example.ofc");
        final List<Transaction> transactions =  new OFCFileReader(is).read();

        final Transaction firstTransaction = transactions.get(0);
        assertEquals(Transaction.Type.CHECK, firstTransaction.getType());
        assertEquals(LocalDate.of(1996, 10, 4), firstTransaction.getPostedOn());

        final Transaction secondTransaction = transactions.get(1);
        assertEquals(Transaction.Type.ATM_WITHDRAWAL, secondTransaction.getType());
        assertEquals("00003", secondTransaction.getInstitutionId());
    }
}
