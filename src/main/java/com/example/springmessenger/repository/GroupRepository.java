package com.example.springmessenger.repository;

import com.example.springmessenger.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group save(Group group);

    Group getById(Long id);
    List<Group> findAll();
}
