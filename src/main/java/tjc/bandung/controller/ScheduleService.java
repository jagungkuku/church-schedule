package tjc.bandung.controller;

import org.springframework.web.bind.annotation.*;
import tjc.bandung.model.entity.Schedule;
import tjc.bandung.model.entity.User;
import tjc.bandung.model.entity.response.GenericResponse;
import tjc.bandung.model.enums.ServiceCategory;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path="schedules")
public class ScheduleService {

    @GetMapping
    @ResponseBody
    public GenericResponse listByCategories(
            @RequestParam (value = "year") final String year,
            @RequestParam (value = "quarter") final int quarter,
            @RequestParam (value = "category") final ServiceCategory category
            ) {
        return null;
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
