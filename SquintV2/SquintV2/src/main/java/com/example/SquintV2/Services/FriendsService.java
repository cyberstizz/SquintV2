package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Friendship;
import main.java.com.example.SquintV2.Repositories.FriendshipRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Service
public class FriendService {

    private final FriendshipRepository friendshipRepository;

    @Autowired
    public FriendService(FriendshipRepository friendshipRepository) {
        this.friendshipRepository = friendshipRepository;
    }

    public List<Friendship> getAllFriends(UUID userId) {
        return friendshipRepository.findByUserId(userId);
    }


    public Optional<Friendship> getFriendship(UUID userId, UUID friendId) {
        return friendshipRepository.findByUserIdAndFriendId(userId, friendId);
    }


    public void removeFriend(UUID userId, UUID friendId) {
        Optional<Friendship> friendship = friendshipRepository.findByUserIdAndFriendId(userId, friendId);
        friendship.ifPresent(friendshipRepository::delete);
    }


    public Friendship sendFriendRequest(UUID userId, UUID friendId) {
        Friendship friendship = new Friendship();
        friendship.setUserId(userId);
        friendship.setFriendId(friendId);
        friendship.setStatus("pending");
        friendship.setDate(LocalDate.now());
        return friendshipRepository.save(friendship);
    }


    public void acceptFriendRequest(UUID userId, UUID friendId) {
        Optional<Friendship> friendship = friendshipRepository.findByUserIdAndFriendId(userId, friendId);
        friendship.ifPresent(f -> {
            f.setStatus("accepted");
            friendshipRepository.save(f);
        });
    }

}