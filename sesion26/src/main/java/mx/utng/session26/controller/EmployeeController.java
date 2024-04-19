package mx.utng.session26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import mx.utng.session26.model.entity.Employee;
import mx.utng.session26.model.service.IEmployeeService;

@Controller
public class EmployeeController {
    
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping({"/employee", "/employee/", "/employee/list"})
    public String list(Model model){
        model.addAttribute("title", "Listado de Empleados");
        model.addAttribute("employees", employeeService.list());
        return "employee-list";
    }

    @GetMapping("/employee/form")
    public String create(Model model){
        model.addAttribute("title", "Formulario de Empleados");
        model.addAttribute("employee", new Employee());
        return "employee-form";
    }

    @PostMapping("/employee/form")
    public String save(@Valid Employee employee, BindingResult br, Model model){
        if(br.hasErrors()){
            model.addAttribute("title", "Formulario de Empleados");
            return "employee-form";
        }
        employeeService.save(employee);
        return "redirect:/employee/list";
    }

    @GetMapping("/employee/form/{id}")
    public String update(@PathVariable Long id, Model model){
        Employee employee = null;
        if(id > 0){
            employee = employeeService.getById(id);
        }else{
            return "redirect:/employee/list";
        }
        model.addAttribute("title", "Editar Empleado");
        model.addAttribute("employee", employee);
        return "employee-form";
    }

    @GetMapping("/employee/delete/{id}")
    public String delete(@PathVariable Long id, Model model){
        if(id > 0){
            employeeService.delete(id);
        }
        return "redirect:/employee/list";
    }
}
