DROP PROCEDURE IF EXISTS onebyoneInit_orders;
DELIMITER $
CREATE PROCEDURE onebyoneInit_orders()
BEGIN
    DECLARE i INT DEFAULT 1;
    WHILE i<=1000000 DO
            insert into javatraining.order (order_no, uid, pid, cnt, order_amt, order_stat, create_time, paid_time, paid_type)
            VALUES ('000' + i, CEILING(rand()*100), 8, 1, 100.00, 2, now() , now(), 1);
        SET i = i+1;
    END WHILE;
END $
CALL onebyoneInit_orders();