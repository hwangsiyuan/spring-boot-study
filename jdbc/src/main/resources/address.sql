CREATE TABLE address (
  id varchar(24) NOT NULL, -- 地址id
  address varchar(256) NULL, -- 地址
  address_detail varchar(256) NOT NULL, -- 详细地址
  CONSTRAINT address_pk PRIMARY KEY (id)
);