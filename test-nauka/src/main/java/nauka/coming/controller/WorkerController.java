package nauka.coming.controller;

import nauka.coming.domain.WorkerEntity;
import nauka.coming.exceptions.RecordNotFoundException;
import nauka.coming.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class WorkerController {

    @Autowired
    WorkerService workerService;

    @RequestMapping
    public String getAllWorkers(Model model) {
        List<WorkerEntity> list = workerService.getAllWorkers();

        model.addAttribute("workers", list);
        return "list-workers";

    }
    @RequestMapping(path = {"/edit" , "edit/{id}"})
    public String editWorkerById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()) {
            WorkerEntity entity = workerService.getWorkerById(id.get());
            model.addAttribute("worker", entity);
        } else {
            model.addAttribute("worker", new WorkerEntity());
        }
        return "add-edit-worker";
    }
    @RequestMapping(path = "/delete/{id}")
    public String deleteEmployeeById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException
    {
        workerService.deleteEmployeeById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createEmployee", method = RequestMethod.POST)
    public String createOrUpdateEmployee(WorkerEntity workerEntity)
    {
        workerService.createOrUpdateWorker(workerEntity);
        return "redirect:/";
    }
}
