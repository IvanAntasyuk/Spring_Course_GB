package ru.geekbrains.interfaces;

import org.springframework.data.domain.Page;
import ru.geekbrains.controller.UserDto;
import ru.geekbrains.persist.*;

import java.util.List;
import java.util.Optional;

public interface UserInter {
    List<UserDto> findAll();

    Page<UserDto> findWithFilter(UserParams userParams);

    Optional<UserDto> findById(Long id);

    void save(UserDto user);

    void deleteById(Long id);
}
