package com.comfeco.demo.service;

import com.comfeco.demo.entity.ConfirmationToken;

public interface IConfirmationTokenService {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
    ConfirmationToken save(ConfirmationToken confirmationToken);
    ConfirmationToken desactivarToken(String token);
}
