package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Users;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface UsersRepository extends CassandraRepository<Users, UUID>{

}

