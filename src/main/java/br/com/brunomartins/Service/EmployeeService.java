package br.com.brunomartins.Service;

import br.com.brunomartins.Model.ClientModel;
import br.com.brunomartins.Model.EmployeeModel;
import br.com.brunomartins.Repository.ClientRepository;
import br.com.brunomartins.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class EmployeeService implements iEmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeModel insert(EmployeeModel object) {
        return employeeRepository.save(object);
    }

    @Override
    public List<EmployeeModel> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<EmployeeModel> findById(UUID id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeModel update(EmployeeModel object) {
        return employeeRepository.save(object);
    }

    @Override
    public void delete(UUID id) {
        employeeRepository.deleteById(id);

    }
}
