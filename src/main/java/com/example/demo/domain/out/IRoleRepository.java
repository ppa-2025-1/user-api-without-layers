package com.example.demo.domain.out;

import java.util.Collection;
import java.util.Set;

import com.example.demo.repository.entity.Role;

public interface IRoleRepository {

    Set<Role> findByNameIn(Collection<String> names);
    
}
