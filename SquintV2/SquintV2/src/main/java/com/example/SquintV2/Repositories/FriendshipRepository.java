package main.java.com.example.SquintV2.Repositories;

import org.springframework.data.repository.CrudRepository;
import main.java.com.example.SquintV2.Models.Friendship;

public interface FriendshipRepository extends CrudRepository<Friendship, Integer> {
    
}