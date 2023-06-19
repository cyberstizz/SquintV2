package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Books;
import main.java.com.example.SquintV2.Models.BooksRead;
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

        book.setBook_id(UUID.randomUUID()); // Generate a new UUID for the book
        book.setCompletion_date(LocalDate.now()); // Set the completion date to the current date
    
        // Save the book using the repository
        return booksRepository.save(book);
    }


    public List<Books> getAllBooksForUser(UUID userId) {
        return booksRepository.findByUserId(userId);
    }

    public void deleteBookForUser(UUID bookId) {
        booksRepository.deleteById(bookId);
    }


    public Books updateBookForUser(UUID bookId, Books updatedBook) {
        Books existingBook = booksRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found: " + bookId));
    
        // Update the individual attributes of the existing book using the updated book
        existingBook.setBook_title(updatedBook.getBook_title());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setTotal_pages(updatedBook.getTotal_pages());
        existingBook.setCurrent_page(updatedBook.getCurrent_page());
        existingBook.setCompletion_date(updatedBook.getCompletion_date());
    
        // Save the updated book using the repository
        return booksRepository.save(existingBook);
    }

    public Books getNextBookByCompletionDate(UUID userId) {
        return booksRepository.findTopByUserIdOrderByCompletionDateAsc(userId);
    }


    public void markBookAsReadForUser(UUID userId, UUID bookId) {
        // Check if the book is already marked as read by the user
        if (booksReadRepository.existsByUserId(userId)) {
            // If the book is already marked as read, increment the count of books_read by 1
            BooksRead booksRead = booksReadRepository.findByUserId(userId)
                    .orElseThrow(() -> new RuntimeException("BooksRead not found for user: " + userId));
            booksRead.setBooks_read(booksRead.getBooks_read() + 1);
            booksReadRepository.save(booksRead);
        } else {
            // If the book is not marked as read, create a new BooksRead object and set books_read to 1
            BooksRead booksRead = new BooksRead();
            booksRead.setUser_id(userId);
            booksRead.setBooks_read(1);
            booksReadRepository.save(booksRead);
        }
    
        // Update the book's completion date to the current date
        Books book = booksRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found: " + bookId));
        book.setCompletionDate(LocalDate.now());
        booksRepository.save(book);
    }
    
}