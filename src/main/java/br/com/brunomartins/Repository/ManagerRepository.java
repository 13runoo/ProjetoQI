package br.com.brunomartins.Repository;

import br.com.brunomartins.Model.ManagerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ManagerRepository extends JpaRepository<ManagerModel, UUID> {
}
