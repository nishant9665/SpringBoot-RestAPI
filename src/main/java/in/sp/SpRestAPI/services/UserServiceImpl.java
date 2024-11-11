package in.sp.SpRestAPI.services;


import in.sp.SpRestAPI.entities.User;
import in.sp.SpRestAPI.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
       return userRepository.save(user) ;

    }

    @Override
    public List<User> getAlluser() {
        return userRepository.findAll();
    }

    @Override
    public Optional getUserDetails(int id) {
        return userRepository.findById(id);
    }

    @Override
    public User updateUserDetails(int id, User new_user) {
      User user_data =  userRepository.findById(id).orElse(null);
        if(user_data!= null){
            return userRepository.save(new_user);
        }
        else {
            throw new RuntimeException("User is not found with id : "+id);
        }

    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}
