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
}