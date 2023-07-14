package com.example.SquintV2.Repositories;

import com.example.SquintV2.Models.Books;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.cassandra.repository.Query;


import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface BooksRepository extends CassandraRepository<Books, UUID>{
    List<Books> findByUserId(UUID userId);
    void deleteById(UUID bookId);

    @Query("SELECT * FROM books WHERE user_id=?0 ORDER BY completion_date DESC LIMIT 1")
    Books findTopByUserIdOrderByCompletionDateDesc(UUID userId);
    
    @Query("SELECT * FROM books WHERE user_id=?0 AND book_id != ?1 ORDER BY completion_date ASC LIMIT 1")
    Books findNextByUserIdAndCurrentBookIdOrderByCompletionDateAsc(UUID userId, UUID currentBookId);



}

