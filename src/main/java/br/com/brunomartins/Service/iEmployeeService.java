package br.com.brunomartins.Service;

import br.com.brunomartins.Model.EmployeeModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface iEmployeeService {
    EmployeeModel insert(EmployeeModel object);


    List<EmployeeModel> findAll();
    Optional<EmployeeModel> findById(UUID id);

    EmployeeModel update(EmployeeModel object);

    void delete(UUID id);


}
