package tjc.bandung.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import tjc.bandung.model.entity.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByName(String name);
}