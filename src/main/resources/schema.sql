CREATE TABLE IF NOT EXISTS customers (
                                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL
    );

CREATE TABLE IF NOT EXISTS bank_accounts (
                                             id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                             customer_id BIGINT,
                                             created_at DATE,
                                             balance DECIMAL(10, 2),
    status VARCHAR(50),
    currency VARCHAR(3),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
    );
