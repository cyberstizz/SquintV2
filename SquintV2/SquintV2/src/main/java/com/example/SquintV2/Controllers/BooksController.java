import main.java.com.example.SquintV2.Models.Books;
import main.java.com.example.SquintV2.Services.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/books")
public class BooksController { 

    private final BooksService booksService;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @GetMapping("/dashboard/{userId}")
    public ResponseEntity<DashboardResponse> showDashboard(@PathVariable UUID userId) {
        Books currentBook = booksService.getCurrentBook(userId);
        Books nextBook = booksService.getNextBookByCompletionDate(userId);

        DashboardResponse dashboardResponse = new DashboardResponse(currentBook, nextBook);

        return ResponseEntity.ok(dashboardResponse);
    }


    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        Books addedBook = booksService.addBookForUser(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }


}


 // Inner class for DashboardResponse
 private static class DashboardResponse {
    private final Books currentBook;
    private final Books nextBook;

    public DashboardResponse(Books currentBook, Books nextBook) {
        this.currentBook = currentBook;
        this.nextBook = nextBook;
    }

    public Books getCurrentBook() {
        return currentBook;
    }

    public Books getNextBook() {
        return nextBook;
    }
}








