package com.example.SquintV2.Repositories;

import com.example.SquintV2.Models.Photo;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface PhotoRepository extends CassandraRepository<Photo, UUID>{
    Photo findTopByUserIdOrderByDeadlineAsc(UUID userId);
}

