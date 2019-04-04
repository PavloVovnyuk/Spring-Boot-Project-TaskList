package zadaniedomowe25.zadanielistazadan;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class TaskController {
    TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/")
    public String allTasks(Model model) {
        List<Task> allTasks = taskRepository.findAll();
        model.addAttribute("tasks", allTasks);
        return "tasks";
    }

    @GetMapping("/task/{id}")
    public String taskDescription(@PathVariable Long id, Model model) {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            Task task = optional.get();
            model.addAttribute("task", task);
            return "task";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteTask (@PathVariable Long id) {
        taskRepository.deleteById(id);
        return "usunięte zadanie o id" + id;
}
//    @GetMapping("/delete/{id}")
//    public String taskDelete(@RequestParam Long id, Model model) {
//        List<Task> allTasks = taskRepository.findAll();
//        taskRepository.deleteById(id);
//        model.addAttribute("task",allTasks);
//            return "deleteZadanie";
//        }

    @GetMapping("/addtask")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        model.addAttribute("tasksWorker", TasksWorker.values());
        return "taskForm";
    }

    @PostMapping("/addtask")
    public String postMovie(Task task) {
        taskRepository.save(task);
        return "redirect:/";
    }
}
