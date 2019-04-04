package zadaniedomowe25.zadanielistazadan;

import org.springframework.format.annotation.DateTimeFormat;
import zadaniedomowe25.zadanielistazadan.TasksWorker;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate taskRealiz;
    @Enumerated(EnumType.STRING)
    private TasksWorker tasksWorker;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getTaskRealiz() {
        return taskRealiz;
    }

    public void setTaskRealiz(LocalDate taskRealiz) {
        this.taskRealiz = taskRealiz;
    }

    public TasksWorker getTasksWorker() {
        return tasksWorker;
    }

    public void setTasksWorker(TasksWorker tasksWorker) {
        this.tasksWorker = tasksWorker;
    }
}

