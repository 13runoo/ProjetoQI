package br.com.brunomartins.Controller;

import br.com.brunomartins.DTO.EmployeeDTO;
import br.com.brunomartins.Model.EmployeeModel;
import br.com.brunomartins.Service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/EmployeeModel")
public class EmployeeController {
    private EmployeeService employeeService;

    public void EmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO insert(@Validated @RequestBody EmployeeDTO employeeDTO){
        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDTO,employeeModel);
        employeeModel = employeeService.insert(employeeModel);
        BeanUtils.copyProperties(employeeModel,employeeDTO);
        return employeeDTO;
    }

    @GetMapping
    public List<EmployeeDTO> findAll(){
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        var employeesModel = employeeService.findAll();
        employeesModel.forEach(model -> {
            var employeesDTO = new EmployeeDTO();
            BeanUtils.copyProperties(model,employeesDTO);
            employeeDTOS.add(employeesDTO);
        });
        return employeeDTOS;
    }

    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable UUID id){
        var result = employeeService.findById(id);
        if(result.isEmpty())
            return null;

        var employeeDTO = new EmployeeDTO();
        var employeeModel = result.get();
        BeanUtils.copyProperties(employeeModel,employeeDTO);
        return employeeDTO;
    }

    @PutMapping
    public EmployeeDTO update(@Validated @RequestBody EmployeeDTO employeeDTO){
        var employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeDTO,employeeModel);
        employeeModel = employeeService.update(employeeModel);
        BeanUtils.copyProperties(employeeModel,employeeDTO);
        return employeeDTO;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        employeeService.delete(id);
    }
}
