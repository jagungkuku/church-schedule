package tjc.bandung.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tjc.bandung.model.entity.Schedule;
import tjc.bandung.model.entity.Task;
import tjc.bandung.model.entity.User;
import tjc.bandung.model.enums.ServiceCategory;
import tjc.bandung.model.repository.ScheduleRepository;
import tjc.bandung.model.repository.TaskRepository;
import tjc.bandung.model.repository.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Component
public class InitDataTest implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public void run(ApplicationArguments args) {
        User andrew = new User();
        andrew.setName("Andrew");
        userRepository.save(andrew);

        User bobby = new User();
        bobby.setName("Bobby");
        userRepository.save(bobby);

        Task pujian = new Task();
        pujian.setServiceCategory(ServiceCategory.UMUM_JUMAT);
        pujian.setName("Pemimpin Pujian");
        taskRepository.save(pujian);

        Task pianis = new Task();
        pianis.setServiceCategory(ServiceCategory.UMUM_JUMAT);
        pianis.setName("Pianis");
        taskRepository.save(pianis);

        Schedule schedule1 = new Schedule();
        schedule1.setScheduleDate(LocalDate.of(2018, 05, 02));
        schedule1.setTask(pianis);
        schedule1.setUsers(Collections.singletonList(andrew));
        scheduleRepository.save(schedule1);

        Schedule schedule2 = new Schedule();
        schedule2.setScheduleDate(LocalDate.of(2018, 02, 02));
        schedule2.setTask(pujian);
        schedule2.setUsers(Collections.singletonList(bobby));
        scheduleRepository.save(schedule2);
    }
}
