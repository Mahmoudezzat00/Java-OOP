package printed.material;

import java.util.Arrays;

public class MainBook {

    static void splitIt(String str) {
        String[] split1 = str.split("[(]");
        String[] split2 = split1[1].split("[)]");
        System.out.println(Arrays.toString(split1));
        System.out.println(Arrays.toString(split2));
    }

    public static void main(String[] args) throws InvalidBookException {
        Book book = new Book();
        System.out.println(book.getAuthorWithInitials());
        Book book2 = new Book("Midya Alqa Azad Maya", "Java Security", 12);
        System.out.println(book2.getAuthorWithInitials());
        System.out.println(book);
        System.out.println(Book.decode("Kozsik Tamas: Java programming; 234"));

        splitIt("Vanessa (midya)");

    }
}