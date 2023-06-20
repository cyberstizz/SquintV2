package main.java.com.example.SquintV2.Services;

import main.java.com.example.SquintV2.Models.Friendship;
import main.java.com.example.SquintV2.Models.Stats;
import main.java.com.example.SquintV2.Repositories.FriendshipRepository;
import main.java.com.example.SquintV2.Repositories.StatsRepository;
import main.java.com.example.SquintV2.Services.StatsService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class FriendshipService {

    private final FriendshipRepository friendshipRepository;
    private final StatsRepository statsRepository;
    private final StatsService statsService;



    @Autowired
    public FriendshipService(FriendshipRepository friendshipRepository, StatsRepository statsRepository, StatsService statsService) {
        this.friendshipRepository = friendshipRepository;
        this.statsRepository = statsRepository;
        this.statsService = statsService;
    }

    public List<Friendship> getAllFriends(UUID userId) {
        List<Friendship> friends = friendshipRepository.findByUserId(userId);
        LocalDate previousDay = LocalDate.now().minusDays(1);
    
        for (Friendship friend : friends) {
            Optional<Stats> stats = statsService.getStatsForCurrentDay(friend.getFriend_id());
            // as it currently stands i am not doing anything with the fetched stats for each friend.
            //i have to make adjustments in order to include the stats with the friends in the returned data
        }
    
        return friends;
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
        friendship.setUser_id(userId);
        friendship.setFriend_id(friendId);
        friendship.setStatus("pending");
        friendship.setDate(LocalDate.now());
        return friendshipRepository.save(friendship);
    }


    public void acceptFriendRequest(UUID userId, UUID friendId) {
        Optional<Friendship> friendship = friendshipRepository.findByUserIdAndFriendId(userId, friendId);
        friendship.ifPresent(friend -> {
            friend.setStatus("accepted");
            friendshipRepository.save(friend);
        });
    }


    public void blockUser(UUID userId, UUID friendId) {
        Optional<Friendship> friendship = friendshipRepository.findByUserIdAndFriendId(userId, friendId);
        friendship.ifPresent(friend -> {
            friend.setStatus("blocked");
            friendshipRepository.save(friend);
        });
    }

}