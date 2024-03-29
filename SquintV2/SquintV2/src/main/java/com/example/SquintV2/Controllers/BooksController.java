package com.example.SquintV2.Controllers;

import com.example.SquintV2.Models.Books;
import com.example.SquintV2.Services.BooksService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        Books nextBook = booksService.getNextBook(userId, currentBook.getBook_id());

        DashboardResponse dashboardResponse = new DashboardResponse(currentBook, nextBook);

        return ResponseEntity.ok(dashboardResponse);
    }


    @PostMapping("/add")
    public ResponseEntity<Books> addBook(@RequestBody Books book) {
        Books addedBook = booksService.addBookForUser(book);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedBook);
    }


    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable UUID bookId) {
        booksService.deleteBookForUser(bookId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/complete/{userId}/{bookId}")
    public ResponseEntity<?> completeBook(@PathVariable UUID userId, @PathVariable UUID bookId) {
        booksService.markBookAsReadForUser(userId, bookId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{bookId}")
    public ResponseEntity<Books> updateBook(@PathVariable UUID bookId, @RequestBody Books updatedBook) {
        Books book = booksService.updateBookForUser(bookId, updatedBook);
        return ResponseEntity.ok(book);
    }



    // Inner class for DashboardResponse
 private static class DashboardResponse {
    private final Books currentBook;
    private final Books nextBook;

    public DashboardResponse(Books currentBook, Books nextBook) {
        this.currentBook = currentBook;
        this.nextBook = nextBook;
    }

    // public Books getCurrentBook() {
    //     return currentBook;
    // }

    // public Books getNextBook() {
    //     return nextBook;
    // }
}


}











