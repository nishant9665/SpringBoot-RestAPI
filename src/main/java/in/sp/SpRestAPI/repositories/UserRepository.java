package in.sp.SpRestAPI.repositories;


import in.sp.SpRestAPI.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
