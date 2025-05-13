package com.example.demo.domain.out;

import java.util.Optional;

import com.example.demo.repository.entity.User;

// interface: todas as operações são ABSTRATAS
// em vez CONCRETAS
// então é definido O QUE É FEITO, MAS NÃO COMO É FEITO.

public interface IUserRepository {

    Optional<User> findByEmail(String email);

    Optional<User> findByHandle(String handle);

    User save(User user);

    boolean existsByHandle(String handle);

}
