package br.com.brunomartins.Service;

import br.com.brunomartins.Model.ManagerModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface iManagerService {
    ManagerModel insert(ManagerModel object);
    List<ManagerModel> findAll();
    Optional<ManagerModel> findById(UUID id);
    ManagerModel update(ManagerModel object);


    void delete(UUID id);
}
