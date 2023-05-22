package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface FriendshpRepository extends CassandraRepository<Playbook, UUID>{

}

