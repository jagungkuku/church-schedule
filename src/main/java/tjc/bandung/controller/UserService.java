package tjc.bandung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tjc.bandung.model.entity.User;
import tjc.bandung.model.entity.response.GenericResponse;
import tjc.bandung.model.enums.ResponseCode;
import tjc.bandung.model.repository.UserRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="users")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @ResponseBody
    public GenericResponse index() {

        Iterable<User> users = userRepository.findAll();

        if (users != null) {
            return new GenericResponse(users, ResponseCode.SUCCESS);
        }
        return new GenericResponse("Master Failure", ResponseCode.FAILED);
    }

    @PostMapping
    @ResponseBody
    public GenericResponse create(@RequestBody final User user) {
        if(user != null) {
            if(userRepository.findByName(user.getName()) != null) {
                return new GenericResponse("Name already exists", ResponseCode.BAD_REQUEST);
            }
        }
        User result = userRepository.save(user);
        if(result != null) {
            return new GenericResponse(result, ResponseCode.SUCCESS);
        }
        return new GenericResponse(user, ResponseCode.FAILED);
    }

}
