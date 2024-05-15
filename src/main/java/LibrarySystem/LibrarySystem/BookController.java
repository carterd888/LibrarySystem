package LibrarySystem.LibrarySystem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping(path = "/books")
    public Iterator<Book> getBooks() {
        return bookRepository.findAll().iterator();
    }
    @GetMapping(path = "/books/isbn/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable("isbn") int isbn) {
       Book bookFound = bookRepository.findByIsbn(isbn);
        return bookFound != null ? ResponseEntity.ok(bookFound) :
                ResponseEntity.notFound().build();
    }

    @GetMapping(path = "/books/author/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable("author") String author) {
        Book bookFound = bookRepository.findByAuthor(author);
        return bookFound != null ? ResponseEntity.ok(bookFound) :
                ResponseEntity.notFound().build();
    }
//    @GetMapping(path = "/books/author/{author}")
//    public ResponseEntity<Book> getBookByAuthor(@PathVariable("author") String author) {
//        Book bookFound = bookRepository.getBookByAuthor(author).orElse(null);
//        return bookFound != null ? ResponseEntity.ok(bookFound) :
//                ResponseEntity.notFound().build();
//    }


    @GetMapping(path = "/books/title/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable("title") String title) {
        Book bookFound = bookRepository.findByTitle(title);
        return bookFound != null ? ResponseEntity.ok(bookFound) :
                ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/books/new")
    public Book addNewBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping(path = "/books/remove/{bookId}")
    public void deleteById(@PathVariable("bookId") int bookId) {
        bookRepository.deleteById(bookId);
    }
}
