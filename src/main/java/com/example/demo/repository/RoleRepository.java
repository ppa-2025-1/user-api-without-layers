package com.example.demo.repository;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.repository.ListCrudRepository;

import com.example.demo.domain.out.IRoleRepository;
import com.example.demo.repository.entity.Role;

public interface RoleRepository 
        extends IRoleRepository, BaseRepository<Role, Integer> {
    // This interface will automatically provide CRUD operations for the Role entity
    // You can add custom query methods here if needed

    Role findByName(String name);

    Set<Role> findByNameIn(Collection<String> names);

    boolean existsByName(String name);
    
}
