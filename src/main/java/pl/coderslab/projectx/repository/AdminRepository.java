package pl.coderslab.projectx.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.projectx.domain.Admin;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findAllById(Long id);
}
