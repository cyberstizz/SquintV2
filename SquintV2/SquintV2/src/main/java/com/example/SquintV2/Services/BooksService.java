package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Books;
import main.java.com.example.SquintV2.Repositories.BooksRepository;
import main.java.com.example.SquintV2.Repositories.BooksReadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class BooksService {

    private final BooksRepository booksRepository;
    private final BooksReadRepository booksReadRepository;

    @Autowired
    public BooksService(BooksRepository booksRepository, BooksReadRepository booksReadRepository) {
        this.booksRepository = booksRepository;
        this.booksReadRepository = booksReadRepository;
    }


    public Books addBookForUser(Books book) {

        book.setBookId(UUID.randomUUID()); // Generate a new UUID for the book
        book.setCompletionDate(LocalDate.now()); // Set the completion date to the current date
    
        // Save the book using the repository
        return booksRepository.save(book);
    }


    public List<Books> getAllBooksForUser(UUID userId) {
        return booksRepository.findByUserId(userId);
    }

    public void deleteBookForUser(UUID bookId) {
        booksRepository.deleteById(bookId);
    }
}