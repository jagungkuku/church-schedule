package tjc.bandung.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tjc.bandung.model.entity.Schedule;
import tjc.bandung.model.entity.User;
import tjc.bandung.model.entity.response.GenericResponse;
import tjc.bandung.model.enums.ResponseCode;
import tjc.bandung.model.enums.ServiceCategory;
import tjc.bandung.model.repository.ScheduleRepository;

import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="schedules")
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping
    @ResponseBody
    public GenericResponse listByCategories(
            @RequestParam (value = "year") final int year,
            @RequestParam (value = "quarter") final int quarter,
            @RequestParam (value = "category") final ServiceCategory category
            ) throws ParseException {
        LocalDate startDate = LocalDate.of(year, (quarter*3)-2, 01);
        LocalDate endDate = quarter != 4 ? LocalDate.of(year, (quarter*3)+1, 01) : LocalDate.of(year+1, 01, 01);

        Iterable<Schedule> schedules = scheduleRepository.findByScheduleDateBetweenAndTaskServiceCategory(startDate, endDate, category);

        if(schedules != null) {
            return new GenericResponse(schedules, ResponseCode.SUCCESS);
        }
        return new GenericResponse("Master failure", ResponseCode.FAILED);
    }

    @GetMapping(value = "user")
    @ResponseBody
    public GenericResponse listByUser(
            @RequestParam (value = "year") final String year,
            @RequestParam (value = "quarter") final int quarter,
            @RequestParam (value = "user") final User user
            ) {
        return null;
    }

    @PostMapping
    @ResponseBody
    public GenericResponse create(@RequestBody final Schedule schedule) {
        return null;
    }

    @GetMapping(value = "structure")
    @ResponseBody
    public GenericResponse getScheduleStructure(
            @RequestParam (value = "year") final String year,
            @RequestParam (value = "quarter") final int quarter,
            @RequestParam (value = "category") final ServiceCategory category
            ) {
        return null;
    }
}
