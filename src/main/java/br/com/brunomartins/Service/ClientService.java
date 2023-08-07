package br.com.brunomartins.Service;

import br.com.brunomartins.Model.ClientModel;
import br.com.brunomartins.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ClientService implements iClientService<ClientModel> {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ClientModel insert(ClientModel object) {
        return clientRepository.save(object);
    }

    @Override
    public List<ClientModel> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<ClientModel> findById(UUID id) {
        return clientRepository.findById(id);
    }

    @Override
    public ClientModel update(ClientModel object) {
        return clientRepository.save(object);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.deleteById(id);

    }
}
