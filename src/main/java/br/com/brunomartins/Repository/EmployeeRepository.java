package br.com.brunomartins.Repository;

import br.com.brunomartins.Model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, UUID> {
}
