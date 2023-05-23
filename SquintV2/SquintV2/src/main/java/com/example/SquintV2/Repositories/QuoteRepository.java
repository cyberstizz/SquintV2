package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface QuoteRepository extends CassandraRepository<Quote, UUID>{

}

