
-- # 插入数据到订单表中，关闭自动提交，批量插入
DROP PROCEDURE IF EXISTS batchInit_orders;
DELIMITER $
CREATE PROCEDURE batchInit_orders()
BEGIN
    DECLARE i INT DEFAULT 1;
    set autocommit=0;
    WHILE i<=1000000 DO
            insert into javatraining.order (order_no, uid, pid, cnt, order_amt, order_stat, create_time, paid_time, paid_type)
            VALUES ('000' + i, CEILING(rand()*100), 8, 1, 100.00, 2, now() , now(), 1);
        SET i = i+1;
    END WHILE;
    commit;
    set autocommit=1;
END $
CALL batchInit_orders();