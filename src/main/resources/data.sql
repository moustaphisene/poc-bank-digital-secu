-- Insérer des clients
INSERT INTO Customer (name, email, phoneNumber)
VALUES ('John Doe', 'john.doe@example.com', '1234567890'),
       ('Jane Smith', 'jane.smith@example.com', '0987654321');

-- Insérer des comptes bancaires
INSERT INTO BankAccount (createdAt, balance, status, currency, customer_id)
VALUES (CURRENT_DATE, 1000.00, 'ACTIVATED', 'USD', 1),
       (CURRENT_DATE, 500.00, 'ACTIVATED', 'EUR', 2);

-- Insérer des opérations
INSERT INTO Operation (date, amount, type, bank_account_id)
VALUES (CURRENT_DATE, 200.00, 'CREDIT', 1),
       (CURRENT_DATE, 100.00, 'DEBIT', 2);
