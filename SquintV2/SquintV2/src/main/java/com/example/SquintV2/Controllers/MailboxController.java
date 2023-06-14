package main.java.com.example.SquintV2.Controllers;

import main.java.com.example.SquintV2.Models.Mailbox;
import main.java.com.example.SquintV2.Services.MailboxService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;