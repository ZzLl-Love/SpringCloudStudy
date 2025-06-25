-- 订单表
CREATE DATABASE order_micro_service;
USE order_micro_service;
create TABLE  `order`(
    id bigint not null auto_increment primary key,
    user_id bigint default null,
    product_id bigint default  null,
    nums int default null,
    money int default null,
    `status` int default null comment '0: 创建中;1:已完结'
);


-- 库存`storage``order`
CREATE DATABASE storage_micro_service;
USE storage_micro_service;
create TABLE  `storage`(
                         id bigint not null auto_increment primary key,
                         product_id bigint default  null,
                         amount INT DEFAULT NULL COMMENT '库存量'
);
INSERT INTO `storage` VALUES(NULL, 1, 10);

-- 账户表
CREATE DATABASE account_micro_service;
USE account_micro_service;
create TABLE  `account`(
                         id bigint not null auto_increment primary key,
                         user_id bigint default null,
                         money INT DEFAULT NULL COMMENT '账户金额'
);
