CREATE TABLE ENCRYPTED_TRANSACTION (ENCODED_PAYLOAD BLOB NOT NULL, HASH RAW(100) NOT NULL, TIMESTAMP NUMBER(19), PRIMARY KEY (HASH))
