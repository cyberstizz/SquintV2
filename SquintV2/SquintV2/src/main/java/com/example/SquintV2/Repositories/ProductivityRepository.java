package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface ProductivityRepository extends CassandraRepository<Productivity, UUID>{

}

