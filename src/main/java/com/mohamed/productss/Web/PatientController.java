package com.mohamed.productss.Web;

import com.mohamed.productss.Reposetory.PatientReposetory;
import com.mohamed.productss.enteties.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PatientController {
    @Autowired
    private PatientReposetory patientReposetory;
    private Long a = 1L;

    @GetMapping(path = "/index")
    public String index(){
        return "index";
    }
    @GetMapping(path = "/patients")
    public String list(Model model,@RequestParam(name = "page",defaultValue = "0") int page
            ,@RequestParam(name = "size",defaultValue = "5") int size
            ,@RequestParam(name = "keyword",defaultValue = "") String kw){
        Page<Patient> patient = patientReposetory.findByNameContains(kw,PageRequest.of(page,size));
        model.addAttribute("patients",patient.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("pages",new int [patient.getTotalPages()]);
        model.addAttribute("kw",kw);
        return "patients";
    }
    @GetMapping(path = "/deletePatient")
    public String delete(Long id){
        patientReposetory.deleteById(id);
        return "redirect:/patients";
    }
    @GetMapping("/pt")
    @ResponseBody
    public List<Patient> getpatients(){
        List<Patient> pt = patientReposetory.findAll();
        return pt;
    }
    @GetMapping("/pt/{id}")
    @ResponseBody
    public Patient getpatient(@PathVariable(name = "id") Long id){
        Optional<Patient> pt = patientReposetory.findById(id);
        return pt.get();
    }
    @GetMapping(path = "/editPatient")
    public String edit(@RequestParam(name = "id") Long id, Model model){
        Optional<Patient> pt =  patientReposetory.findById(id);
        model.addAttribute("patient",pt.get());
        return "edit";
    }
    @PostMapping(path = "/save")
    public String edite(Model model,Patient patient){
        patientReposetory.save(patient);
        return "redirect:/patients";
    }
}
