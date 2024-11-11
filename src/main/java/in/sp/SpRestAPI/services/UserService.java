package in.sp.SpRestAPI.services;

import in.sp.SpRestAPI.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User createUser(User user);
    public List<User> getAlluser();
    public Optional getUserDetails(int id);
    public User updateUserDetails(int id , User user);
    public void deleteUser(int id);
}
