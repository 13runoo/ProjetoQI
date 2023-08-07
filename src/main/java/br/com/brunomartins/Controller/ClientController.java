package br.com.brunomartins.Controller;

import br.com.brunomartins.DTO.ClientDTO;
import br.com.brunomartins.Model.ClientModel;
import br.com.brunomartins.Service.ClientService;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/client")
public class ClientController {
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ClientDTO insert(@Validated @RequestBody ClientDTO clientDTO){
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDTO,clientModel);
        clientModel = clientService.insert(clientModel);
        BeanUtils.copyProperties(clientModel,clientDTO);
        return clientDTO;
    }

    @GetMapping
    public List<ClientDTO> findAll(){
        List<ClientDTO> clients = new ArrayList<>();
        var clientsModel = clientService.findAll();
        clientsModel.forEach(model -> {
            var clientDto = new ClientDTO();
            BeanUtils.copyProperties(model,clientDto);
            clients.add(clientDto);
        });
        return clients;
    }

    @GetMapping("/{id}")
    public ClientDTO findById(@PathVariable UUID id){
        var result = clientService.findById(id);
        if(result.isEmpty())
            return null;

        var clientDto = new ClientDTO();
        var clientModel = result.get();
        BeanUtils.copyProperties(clientModel,clientDto);
        return clientDto;
    }

    @PutMapping
    public ClientDTO update(@Validated @RequestBody ClientDTO clientDTO){
        var clientModel = new ClientModel();
        BeanUtils.copyProperties(clientDTO,clientModel);
        clientModel = clientService.update(clientModel);
        BeanUtils.copyProperties(clientModel,clientDTO);
        return clientDTO;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id){
        clientService.delete(id);
    }
}


