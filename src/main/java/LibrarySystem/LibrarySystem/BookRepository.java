package LibrarySystem.LibrarySystem;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer>{

   Book findByTitle(String title);
    Book findByIsbn(int isbn);
    Book findByAuthor(String author);


    //    private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

//    private static final List<Book> books = List.of(
//            new Book(1,12345, "author", "title"),
//            new Book(2, 23456, "author2", "title2"));


//    public static Book addNewBook(Book book) {
//        int id = ID_GENERATOR.incrementAndGet();
//        return new Book(id, book.isbn(), book.author(), book.title());
//    }
//
//    public List<Book> getAllAvailableBooks() {
//        return books;
//    }
//
//    public Optional<Book> getBookByIsbn(int isbn) {
//        return books.stream().filter(book -> book.isbn() == isbn).findAny();
//    }
//
//    public Optional<Book> getBookByAuthor(String author) {
//        return books.stream().filter(book -> Objects.equals(book.author(), author)).findAny();
//    }
//
//    public Optional<Book> getBookByTitle(String title) {
//        return books.stream().filter(book -> Objects.equals(book.title(), title)).findAny();
//    }
//
//    public static void deleteById(int bookID) {
//        books.remove(bookID);
//    }
}
