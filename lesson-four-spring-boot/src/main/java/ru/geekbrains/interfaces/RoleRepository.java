package ru.geekbrains.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.geekbrains.persist.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}