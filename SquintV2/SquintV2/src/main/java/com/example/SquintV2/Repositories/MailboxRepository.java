package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MaiilboxRepository extends CassandraRepository<Mailbox, UUID>{

}

