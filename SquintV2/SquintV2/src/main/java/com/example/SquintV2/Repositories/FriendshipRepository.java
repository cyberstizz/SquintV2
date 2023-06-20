package main.java.com.example.SquintV2.Repositories;

import main.java.com.example.SquintV2.Models.Friendship;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface FriendshipRepository extends CassandraRepository<Friendship, UUID>{
    List<Friendship> findByUserId(UUID userId);
    Optional<Friendship> findByUserIdAndFriendId(UUID userId, UUID friendId);

}

