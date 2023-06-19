package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Affirmation;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface AffirmationRepository extends CassandraRepository<Affirmation, UUID>{
    Optional<Affirmation> findByUserId(UUID userId);
}

