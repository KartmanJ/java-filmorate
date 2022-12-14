package ru.yandex.practicum.filmorate.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.FriendshipStatus;
import ru.yandex.practicum.filmorate.model.User;
import ru.yandex.practicum.filmorate.service.UserService;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userService.getUsersById(userId);
    }

    @GetMapping("/{userId}/friends/common/{friendId}")
    public Set<User> getUsersCommonFriends(@PathVariable Integer userId, @PathVariable Integer friendId) {
        return userService.commonFriends(userId, friendId);
    }

    @GetMapping("/{userId}/friends/status/{friendId}")
    public FriendshipStatus getFriendshipStatus(@PathVariable Integer userId, @PathVariable Integer friendId) {
        return userService.getFriendshipStatus(userId, friendId);
    }

    @GetMapping("/{userId}/friends")
    public Set<User> getUsersFriends(@PathVariable Integer userId) {
        return userService.listOfFriends(userId);
    }

    @PutMapping
    public User update(@Valid @RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping
    public User save(@RequestBody @Valid User user) throws SQLException {
        return userService.save(user);
    }

    @PutMapping("/{userId}/friends/{friendId}")
    public String addFriend(@PathVariable Integer userId, @PathVariable Integer friendId) throws SQLException {
        return userService.addFriend(userId, friendId);
    }

    @DeleteMapping("/{userId}/friends/{friendId}")
    public String deleteFriend(@PathVariable Integer userId, @PathVariable Integer friendId) {
        return userService.removeFriend(userId, friendId);
    }

}
