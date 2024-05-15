package LibrarySystem.LibrarySystem;

import java.time.LocalDate;

public record BooksOnLoan(

        Book book,
        LocalDate checkoutDate,
        LocalDate returnDate
) {
}
