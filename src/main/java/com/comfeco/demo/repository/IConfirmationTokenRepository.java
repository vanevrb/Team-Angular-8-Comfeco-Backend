package com.comfeco.demo.repository;

import com.comfeco.demo.entity.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findByConfirmationTokenAndEstadoIsTrue(String confirmationToken);

    @Modifying
    @Query("UPDATE ConfirmationToken ct set ct.estado = false where ct.confirmationToken = ?1")
    Integer desactivarToken(String username);
}
