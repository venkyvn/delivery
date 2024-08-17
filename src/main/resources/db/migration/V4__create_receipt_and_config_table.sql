create table receipt
(
    id                         numeric(19) identity primary key,
    created_by                 nvarchar(255),
    created_date               datetime,
    updated_by                 nvarchar(255),
    updated_date               datetime,
    item_fragile               bit,
    item_height                numeric(19, 2),
    item_length                numeric(19, 2),
    item_name                  varchar(255),
    item_quantity              int,
    item_value                 numeric(19, 2),
    item_weight                numeric(19, 2),
    item_width                 numeric(19, 2),
    packaging_service          varchar(255),
    packaging_service_fee      numeric(19, 2),
    packaging_service_quantity int,
    receiver_address           varchar(255),
    receiver_id_card           varchar(255),
    receiver_name              varchar(255),
    receiver_phone             varchar(255),
    sender_address             varchar(255),
    sender_id_card             varchar(255),
    sender_name                varchar(255),
    sender_phone               varchar(255),
    service_fee                numeric(19, 2),
    total_amount               numeric(19, 2),
    receiver_commune_id        numeric(19),
    receiver_district_id       numeric(19),
    receiver_province_id       numeric(19)
);
GO

create table delivery_config
(
    id           numeric(19) identity primary key,
    created_by   nvarchar(255),
    created_date datetime,
    updated_by   nvarchar(255),
    updated_date datetime,
    tax          nvarchar(255)
);
GO

