package tjc.bandung.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tjc.bandung.model.entity.Schedule;
import tjc.bandung.model.enums.ServiceCategory;

import java.time.LocalDate;
import java.util.Date;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    Iterable<Schedule> findByScheduleDateBetweenAndTaskServiceCategory(LocalDate startDate, LocalDate endDate, ServiceCategory serviceCategory);
}
