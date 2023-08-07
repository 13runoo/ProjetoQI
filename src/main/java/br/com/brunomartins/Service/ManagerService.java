package br.com.brunomartins.Service;

import br.com.brunomartins.Model.ManagerModel;
import br.com.brunomartins.Repository.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ManagerService implements iManagerService {
    private ManagerRepository managerRepository;

    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Override
    public ManagerModel insert(ManagerModel object) {
        return managerRepository.save(object);
    }

    @Override
    public List<ManagerModel> findAll() {
        return managerRepository.findAll();
    }

    @Override
    public Optional<ManagerModel> findById(UUID id) {
        return managerRepository.findById(id);
    }

    @Override
    public ManagerModel update(ManagerModel object) {
        return managerRepository.save(object);
    }





    @Override
    public void delete(UUID id) {
        managerRepository.deleteById(id);

    }
}
