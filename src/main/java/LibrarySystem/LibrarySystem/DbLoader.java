package LibrarySystem.LibrarySystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DbLoader implements CommandLineRunner {
    private final BookRepository bookRepository;

    public DbLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Book> books = List.of(
                new Book(1,12345, "author", "title"),
                new Book(2, 23456, "author2", "title2"));
        bookRepository.deleteAll();
        bookRepository.saveAll(books);

    }
}
