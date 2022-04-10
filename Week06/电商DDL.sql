create table user
(
    uid         bigint auto_increment comment '用户ID'
        primary key,
    uname       varchar(32)  not null comment '用户姓名',
    pwd         varchar(512) not null comment '密码',
    mobile      varchar(11)  not null comment '手机号',
    nickname    varchar(32)  null comment '昵称',
    create_time datetime     not null,
    update_time datetime     not null
)
    comment '用户表';

create table product
(
    pid               bigint auto_increment comment '商品ID'
        primary key,
    pname             varchar(128)                       not null comment '商品名称',
    price             decimal(20, 2)                     not null comment '商品价格',
    pdesc             varchar(512)                       not null comment '商品描述',
    all_pstorage      int                                not null comment '总库存',
    remaining_storage int                                not null comment '剩余库存',
    create_time       datetime default CURRENT_TIMESTAMP not null,
    update_time       datetime default CURRENT_TIMESTAMP not null
)
    comment '商品表';

create table `order`
(
    oid         bigint auto_increment comment '订单ID'
        primary key,
    order_no    varchar(32) not null comment '订单编号',
    uid         bigint      not null comment '用户ID',
    pid         bigint      not null comment '产品ID',
    cnt         int         not null comment '购买数量',
    order_amt   decimal     not null comment '订单金额',
    order_stat  int         not null comment '订单状态：0 初始化，1 待支付，2 已支付，3 已取消..',
    create_time datetime    not null comment '下单时间',
    paid_time   datetime    not null comment '支付完成时间',
    paid_type   int         not null comment '支付方式',
    constraint order_order_no_uindex
        unique (order_no)
)
    comment '订单表';

