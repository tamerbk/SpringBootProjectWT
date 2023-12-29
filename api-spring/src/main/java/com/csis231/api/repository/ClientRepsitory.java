package com.csis231.api.repository;

import com.csis231.api.model.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ClientRepsitory extends JpaRepository<Client, Long> {
    @Query("SELECT c FROM Client c WHERE c.userName = :userName AND c.password = :password")
    Client findByUsernameAndPassword(@Param("userName") String userName, @Param("password") String password);
}
