package com.comfeco.demo.service.impl;

import com.comfeco.demo.entity.ConfirmationToken;
import com.comfeco.demo.repository.IConfirmationTokenRepository;
import com.comfeco.demo.service.IConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ConfirmationTokenServiceImpl implements IConfirmationTokenService {

    @Autowired
    private IConfirmationTokenRepository confirmationTokenRepository;

    @Transactional(readOnly = true)
    @Override
    public ConfirmationToken findByConfirmationToken(String confirmationToken) {
        Optional<ConfirmationToken> op = confirmationTokenRepository.findByConfirmationTokenAndEstadoIsTrue(confirmationToken);
        return op.isPresent() ? op.get() : new ConfirmationToken();
    }

    @Transactional
    @Override
    public ConfirmationToken save(ConfirmationToken confirmationToken) {
        return confirmationTokenRepository.save(confirmationToken);
    }

    @Transactional
    @Override
    public ConfirmationToken desactivarToken(String token) {
        Optional<ConfirmationToken> op = confirmationTokenRepository.findByConfirmationTokenAndEstadoIsTrue(token);
        confirmationTokenRepository.desactivarToken(token);
        return op.get();
    }
}
