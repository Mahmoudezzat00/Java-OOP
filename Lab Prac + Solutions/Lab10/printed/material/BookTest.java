package printed.material;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import printed.material.specific.EBook;
import printed.material.specific.PrintedBook;

public class BookTest {
    @Test
    public void testConstants() {
        assertEquals("John Steinbeck", Book.defaultAuthor);
        assertEquals("Of Mice and Men", Book.defaultTitle);
        assertEquals(107, Book.defaultPageCount);
    }

    @Test
    public void testNoArg() {
        Book book = new Book();
        assertEquals("J. Steinbeck: Of M; 107", book.getShortInfo());
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        John Steinbeck, Of Mice and Men, 107, 'John Steinbeck: Of Mice and Men; 107', 'J. Steinbeck: Of M; 107', 5, true, $, 'EBook(John Steinbeck: Of Mice and Men; 107, $111.99)', SOFTCOVER, 'John Steinbeck: Of Mice and Men; 113 (HARDCOVER)'
        Kozsik Tamás, Java programozás, 234, 'Kozsik Tamás: Java programozás; 234', 'K. Tamás: Java; 234', 10000, false, ' Ft', 'EBook(Kozsik Tamás: Java programozás; 234, 10233 Ft)', HARDCOVER, 'Kozsik Tamás: Java programozás; 240 (HARDCOVER)'
        Alan Alexander Milne, Winnie-the-Pooh, 145, 'Alan Alexander Milne: Winnie-the-Pooh; 145', 'A. A. Milne: Winn; 145', 8, true, £, 'EBook(Alan Alexander Milne: Winnie-the-Pooh; 145, £152.99)', SOFTCOVER, 'Alan Alexander Milne: Winnie-the-Pooh; 151 (HARDCOVER)'
    """)
    public void validBook(String author, String title, int pageCount, String expected, String expectedShort, int pdfSize, boolean isUnitPrefix, String unit, String expectedEbook, CoverType coverType, String expectedPrintedBook) {
        try {
            Book book = new Book(author, title, pageCount);
            assertEquals(expected, book.toString());
            assertEquals(expectedShort, book.getShortInfo());

            Book decoded = Book.decode(book.toString());
            assertEquals(author, decoded.getAuthor());
            assertEquals(title, decoded.getTitle());
            assertEquals(pageCount, decoded.getPageCount());
            assertEquals(pageCount, decoded.getPrice());

            Book eBook = new EBook(book, pdfSize, isUnitPrefix, unit);
            assertEquals(author, eBook.getAuthor());
            assertEquals(title, eBook.getTitle());
            assertEquals(pageCount, eBook.getPageCount());
            assertEquals(expectedEbook, eBook.toString());

            Book printedBook = new PrintedBook(book);
            assertEquals(author, printedBook.getAuthor());
            assertEquals(title, printedBook.getTitle());
            assertEquals(pageCount+6, printedBook.getPageCount());
            assertEquals(expectedPrintedBook, printedBook.toString());

            Book decodedPrintedBook = PrintedBook.decode(printedBook.toString());
            assertEquals(author, decodedPrintedBook.getAuthor());
            assertEquals(title, decodedPrintedBook.getTitle());
            assertEquals(pageCount+6, decodedPrintedBook.getPageCount());
            assertEquals(expectedPrintedBook, decodedPrintedBook.toString());
        } catch (InvalidBookException e) {
            fail();
        }
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
        abc, def, 0
        a, bcdef, 123
        '', '', 123
    """)
    public void invalidBook(String author, String title, int pageCount) {
        try {
            new Book(author, title, pageCount);
            fail();
        } catch (InvalidBookException e) {
            assertEquals(author, e.getAuthor());
            assertEquals(title, e.getTitle());
        }
    }

//    PrintedBook pbook1 = new PrintedBook();
//    System.out.println(pbook1.getShortName());
//    System.out.println(" price = " + pbook1.getPrice());
//    PrintedBook pbook2 = new PrintedBook("author", "Printed: Title", 100, CoverType.Softcover);
//    System.out.println(pbook2.getShortName());
//    System.out.println(" price = " + pbook2.getPrice());
//
//    System.out.println();
//
//    EBook ebook1 = new EBook("author2", "Digitalised: Title", 100, 12);
//    System.out.println(ebook1.getShortName());
//    System.out.println(" price = " + ebook1.getPrice());
//
//    System.out.println();
//
//    System.out.println(book1);
//    System.out.println(pbook1);
//    System.out.println(pbook2);
//    System.out.println(ebook1);
//
//    System.out.println();
//
//    System.out.println(book1.createReference("articlename", 10, 20));
//    System.out.println(pbook1.createReference("articlename", 10, 20));
//    System.out.println(ebook1.createReference("articlename", "2020/04/11"));
//    System.out.println(ebook1.createReference("articlename", 10, 20));

}
