package tjc.bandung.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tjc.bandung.model.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}
