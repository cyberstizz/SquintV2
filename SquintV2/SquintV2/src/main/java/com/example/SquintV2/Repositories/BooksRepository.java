package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Books;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface BooksRepository extends CassandraRepository<Books, UUID>{
    List<Books> findByUserId(UUID userId);

    Books findTopByUserIdOrderByCompletionDateAsc(UUID userId);



}

