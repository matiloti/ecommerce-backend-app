INSERT INTO BRANDS (id, name) VALUES (1, 'TEST_BRAND');

INSERT INTO PRODUCTS (id, name) VALUES (35455, 'TEST_PRODUCT');

INSERT INTO PRICE_LIST (id) VALUES (1);
INSERT INTO PRICE_LIST (id) VALUES (2);
INSERT INTO PRICE_LIST (id) VALUES (3);
INSERT INTO PRICE_LIST (id) VALUES (4);

INSERT INTO prices (brandId, productId, startDate, endDate, priority, price, priceList, currency, lastUpdate, lastUpdateBy) VALUES(1, 35455, '2020-06-14 00:00:00' , '2020-12-31 23:59:59', 0, 35.50, 1, 'EUR', '2020-03-26 14:49:07', 'user1');
INSERT INTO prices (brandId, productId, startDate, endDate, priority, price, priceList, currency, lastUpdate, lastUpdateBy) VALUES(1, 35455, '2020-06-14 15:00:00' , '2020-06-14 18:30:00', 1, 25.45, 2, 'EUR', '2020-05-26 15:38:22', 'user1');
INSERT INTO prices (brandId, productId, startDate, endDate, priority, price, priceList, currency, lastUpdate, lastUpdateBy) VALUES(1, 35455, '2020-06-15 00:00:00' , '2020-06-15 11:00:00', 1, 30.50, 3, 'EUR', '2020-05-26 15:39:22', 'user2');
INSERT INTO prices (brandId, productId, startDate, endDate, priority, price, priceList, currency, lastUpdate, lastUpdateBy) VALUES(1, 35455, '2020-06-15 16:00:00' , '2020-12-31 23:59:59', 1, 38.95, 4, 'EUR', '2020-06-02 10:14:00', 'user1');
