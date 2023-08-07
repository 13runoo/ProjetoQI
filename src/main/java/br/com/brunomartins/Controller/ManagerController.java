package br.com.brunomartins.Controller;


import br.com.brunomartins.DTO.ClientDTO;
import br.com.brunomartins.DTO.ManagerDTO;
import br.com.brunomartins.Model.ClientModel;
import br.com.brunomartins.Model.ManagerModel;
import br.com.brunomartins.Service.ManagerService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/managers")
public class ManagerController {
   private ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }
    @PostMapping
    public ManagerDTO insert(@Validated @RequestBody ManagerDTO managerDTO){
        var managerModel = new ManagerModel();
        BeanUtils.copyProperties(managerDTO, managerDTO);
        managerModel = managerService.insert(managerModel);
        BeanUtils.copyProperties(managerModel,managerDTO);
        return managerDTO;
    }

    @GetMapping
    public List<ManagerDTO> findAll(){
        List<ManagerDTO> managers = new ArrayList<>();
        var managerModel = managerService.findAll();
        managerModel.forEach(model -> {
            var managerDTO = new ManagerDTO();
            BeanUtils.copyProperties(model,managerDTO);
            managers.add(managerDTO);
        });
        return managers;
    }

    @GetMapping("/{id}")
    public ManagerDTO findById(@PathVariable UUID id){
        var result = managerService.findById(id);
        if(result.isEmpty())
            return null;

        var managerDTO = new ManagerDTO();
        var managerModel = result.get();
        BeanUtils.copyProperties(managerModel,managerDTO);
        return managerDTO;
    }

    @PutMapping
    public ManagerDTO update(@Validated @RequestBody ManagerDTO managerDTO){
        var managerModel = new ManagerModel();
        BeanUtils.copyProperties(managerDTO,managerModel);
        managerModel = managerService.update(managerModel);
        BeanUtils.copyProperties(managerModel,managerDTO);
        return managerDTO;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        managerService.delete(id);
    }
}
