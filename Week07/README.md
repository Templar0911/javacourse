# 作业
## 第二题（必做）
### 要求
按自己设计的表结构，插入 100 万订单模拟数据，测试不同方式的插入效率
### 解答说明
- 方案一：关闭自动提交，批量插入。插入100万order表数据耗时58秒。见 [batchInsert.sql](batchInsert.sql)
- 方案二：打开自动提交（默认），一条一条插入。耗时4分49秒，远超方案一。见 [insertOneByOne.sql](insertOneByOne.sql)

