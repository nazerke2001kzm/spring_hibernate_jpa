package kz.bitlab.spring_jpa.controllers;

import kz.bitlab.spring_jpa.models.ApplicationRequest;
import kz.bitlab.spring_jpa.repositories.ApplicationRequestRepository;
import kz.bitlab.spring_jpa.services.ApplicationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ApplicationRequestService applicationRequestService;
    @Autowired
    ApplicationRequestRepository applicationRequestRepository;

    @GetMapping("/")
    public String homePage(Model model){
        List<ApplicationRequest> applicationRequests=applicationRequestService.getApplicationRequest();
        model.addAttribute("applications",applicationRequests);
        return "home";
    }
    @GetMapping ("/addNewApplication")
    public String NewApplicationPage(Model model){
        return "addNewApplication";
    }
    @PostMapping("/addApplicationForm")
    public String NewApplication (ApplicationRequest applicationRequest){
        applicationRequestService.AddNewApplication(applicationRequest);
        return "redirect:/";
    }
    @PostMapping("/processing")
    public String Processing (@RequestParam Long id){
        ApplicationRequest applicationRequest=applicationRequestService.findById(id);
        applicationRequest.setHandled(true);
        applicationRequestRepository.save(applicationRequest);
        return "redirect:/";
    }

    @GetMapping("/details/{id}")
    public String DetailsPage(@PathVariable  Long id, Model model){
        ApplicationRequest applicationRequest=applicationRequestService.findById(id);
        model.addAttribute("applicationid",applicationRequest);
        return "details";
    }
    @PostMapping("/deleteApplication")
    public String deleteApplication(@RequestParam Long id){
        applicationRequestService.deleteById(id);
        return "redirect:/";
    }
    @GetMapping("/allNewApplications")
    public String getAllNewApplications(Model model){
        List<ApplicationRequest> applicationRequests=applicationRequestService.getApplicationRequest();
        model.addAttribute("applications",applicationRequests);
        return "allNewApplications";
    }
    @GetMapping("/allProcessingApplications")
    public String getAllProcessingApplications(Model model){
        List<ApplicationRequest> applicationRequests=applicationRequestService.getApplicationRequest();
        model.addAttribute("applications",applicationRequests);
        return "allProcessingApplications";
    }
}
