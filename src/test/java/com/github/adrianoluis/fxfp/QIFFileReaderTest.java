package com.github.adrianoluis.fxfp;

import com.github.adrianoluis.fxfp.quicken.QIFFileReader;
import org.junit.Test;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class QIFFileReaderTest {

    @Test
    public void testTypeBank() throws Throwable {
        final InputStream is = getClass().getResourceAsStream("/simple1.qif");
        final List<Transaction> transactions = new QIFFileReader(is).read();

        final Transaction firstTransaction = transactions.get(0);
        assertEquals(LocalDate.of(1994, 6, 1), firstTransaction.getPostedOn());
        assertEquals(2, firstTransaction.getCategoryInSplit().size());
        assertEquals("linda", firstTransaction.getCategoryInSplit().iterator().next());

        final Transaction thirdTransaction = transactions.get(2);
        assertEquals("1010 Rodeo Dr.\nWaco, Tx\n80505", thirdTransaction.getAddress());
    }

    @Test
    public void testTypeInvestment() throws Throwable {
        final InputStream is = getClass().getResourceAsStream("/simple2.qif");
        final List<Transaction> transactions = new QIFFileReader(is).read();

        final Transaction firstTransaction = transactions.get(0);
        assertEquals(LocalDate.of(1993, 8, 25), firstTransaction.getPostedOn());
        assertEquals("ShrsIn", firstTransaction.getAction());
        assertEquals("ibm4", firstTransaction.getSecurity());

        final Transaction secondTransaction = transactions.get(1);
        assertEquals(LocalDate.of(1993, 8, 25), secondTransaction.getPostedOn());
        assertEquals("BuyX", secondTransaction.getAction());
        assertEquals(100.0, secondTransaction.getAmount().doubleValue(), 0);
    }

    @Test
    public void testTypeMemorized() throws Throwable {
        final InputStream is = getClass().getResourceAsStream("/simple3.qif");
        final List<Transaction> transactions = new QIFFileReader(is).read();

        assertTrue(transactions.isEmpty());
    }
}
