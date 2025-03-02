package com.ebank.bankdigital.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VaultConfig {

    private static final Logger logger = LoggerFactory.getLogger(VaultConfig.class);

    // Valeurs statiques pour les secrets a enlever
    private static final String partner1ClientId = "bank-digital";
    private static final String partner1ClientSecret = "ecpex74Bv6sEm1ebiF3pcc6z7wLoBZl9";

    public String getPartner1ClientId() {
        logger.info("Fetching partner1ClientId: {}", partner1ClientId);
        return partner1ClientId;
    }

    public String getPartner1ClientSecret() {
        logger.info("Fetching partner1ClientSecret: {}", partner1ClientSecret);
        return partner1ClientSecret;
    }
}
