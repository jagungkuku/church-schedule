package tjc.bandung.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tjc.bandung.model.entity.User;
import tjc.bandung.model.repository.UserRepository;

@Component
public class InitDataTest implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    public void run(ApplicationArguments args) {
        User user = new User();
        user.setName("test");
        userRepository.save(user);
    }
}
