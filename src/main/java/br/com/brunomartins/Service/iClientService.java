package br.com.brunomartins.Service;

import br.com.brunomartins.Model.ClientModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface iClientService<C> {

    ClientModel insert(ClientModel object);
    List<ClientModel> findAll();
    Optional<ClientModel> findById(UUID id);
    ClientModel update(ClientModel object);
    void delete(UUID id);
}
