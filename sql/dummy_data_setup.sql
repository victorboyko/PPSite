INSERT INTO user (id, name, password,  email) VALUES (1, 'victor', '123', 'boyko.victor@gmail.com');

INSERT INTO algo (id, name) VALUES (1, 'Equihash'); 

INSERT INTO currency (id, algo, abr, name) VALUES (1, 1, 'ZEC', 'Zcash');
INSERT INTO currency (id, algo, abr, name) VALUES (2, 1, 'BTG', 'BitcoinGold');

INSERT INTO pool (id, user, currency, host, port, login, password) VALUES (1, 1, 1, 'eu1-zcash.flypool.org', 3333, 't1VL1tTafDkVnvkiS4R84Mey5WWYKcgMpKf.ppRig1', 'x');
