create table access_token
(
    id            numeric(19) identity
        primary key,
    created_by    nvarchar(255),
    created_date  datetime,
    updated_by    nvarchar(255),
    updated_date  datetime,
    account_id    numeric(19),
    expired       datetime,
    refresh_token varchar(600),
    token         varchar(600),
    user_agent    varchar(255)
)
    go

create table packaging_cbm_prices
(
    id                              numeric(19) identity
        primary key,
    created_by                      nvarchar(255),
    created_date                    datetime,
    updated_by                      nvarchar(255),
    updated_date                    datetime,
    additional_price                numeric(19, 2),
    additional_weight_after_packing float,
    code                            nvarchar(255),
    from_cbm                        float,
    label                           nvarchar(255),
    max_cbm                         bit,
    max_weight_per_package          float,
    name                            nvarchar(255),
    note                            varchar(255),
    price                           numeric(19, 2),
    price_coefficient               float,
    to_cbm                          float,
    vat                             float
)
    go

create table packaging_prices
(
    id           numeric(19) identity
        primary key,
    created_by   nvarchar(255),
    created_date datetime,
    updated_by   nvarchar(255),
    updated_date datetime,
    code         nvarchar(255),
    discount     float,
    first_price  numeric(19, 2),
    label        nvarchar(255),
    labor_cost   numeric(19, 2),
    name         nvarchar(255),
    note         varchar(255),
    price        numeric(19, 2),
    reuse_price  numeric(19, 2),
    second_price numeric(19, 2),
    size         varchar(255),
    unit         varchar(255),
    v1_price     numeric(19, 2),
    vat          float
)
    go

create table region_freight_prices
(
    id            numeric(19) identity
        primary key,
    created_by    nvarchar(255),
    created_date  datetime,
    updated_by    nvarchar(255),
    updated_date  datetime,
    code          nvarchar(255),
    delivery_time varchar(255),
    discount      float,
    label         nvarchar(255),
    name          nvarchar(255),
    proposal      nvarchar(255)
)
    go

create table cbm_rates
(
    id                      numeric(19) identity
        primary key,
    created_by              nvarchar(255),
    created_date            datetime,
    updated_by              nvarchar(255),
    updated_date            datetime,
    additional_price        numeric(19, 2),
    additional_volume       float,
    from_volume             float,
    note                    varchar(255),
    price                   numeric(19, 2),
    to_volume               float,
    region_freight_price_id numeric(19)
        constraint FK4xe6nuc0e11rvem00riepklnn
            references region_freight_prices
)
    go

create table region_rates
(
    id                      numeric(19) identity
        primary key,
    created_by              nvarchar(255),
    created_date            datetime,
    updated_by              nvarchar(255),
    updated_date            datetime,
    additional_price        numeric(19, 2),
    additional_weight       numeric(19, 2),
    from_kg                 float,
    label                   varchar(255),
    name                    varchar(255),
    note                    varchar(255),
    price                   numeric(19, 2),
    to_kg                   float,
    region_freight_price_id numeric(19)
        constraint FK14ivy9dkjiyl04rbuwb7jlqr7
            references region_freight_prices
)
    go

create table regions
(
    id           numeric(19) identity
        primary key,
    created_by   nvarchar(255),
    created_date datetime,
    updated_by   nvarchar(255),
    updated_date datetime,
    code         nvarchar(255),
    name         nvarchar(255)
)
    go

create table provinces
(
    id                      numeric(19) identity
        primary key,
    created_by              nvarchar(255),
    created_date            datetime,
    updated_by              nvarchar(255),
    updated_date            datetime,
    code                    nvarchar(255),
    km                      varchar(255),
    license_plate_code      nvarchar(255),
    name                    nvarchar(255),
    route_code              nvarchar(255),
    region_id               numeric(19)
        constraint FKr52p9hvmia0r4042b4s4h6qil
            references regions,
    region_freight_price_id numeric(19)
        constraint FK2xdv34vbk4ffa7n6ucac2f715
            references region_freight_prices
)
    go

create table districts
(
    id           numeric(19) identity
        primary key,
    created_by   nvarchar(255),
    created_date datetime,
    updated_by   nvarchar(255),
    updated_date datetime,
    code         nvarchar(255),
    name         nvarchar(255),
    province_id  numeric(19)
        constraint FK82doq1t64jhly7a546lpvnu2c
            references provinces
)
    go

create table communes
(
    id            numeric(19) identity
        primary key,
    created_by    nvarchar(255),
    created_date  datetime,
    updated_by    nvarchar(255),
    updated_date  datetime,
    code          nvarchar(255),
    km            nvarchar(255),
    label         nvarchar(255),
    name          nvarchar(255),
    percent_rate  nvarchar(255),
    shipment_type nvarchar(255),
    district_id   numeric(19)
        constraint FK2icy3sshsnesyj7runy3r5brt
            references districts
)
    go

create table roles
(
    id           numeric(19) identity
        primary key,
    created_by   nvarchar(255),
    created_date datetime,
    updated_by   nvarchar(255),
    updated_date datetime,
    name         varchar(255) not null
        constraint UK_ofx66keruapi6vyqpv6f2or37
            unique
)
    go

create table user_token
(
    id            numeric(19) identity
        primary key,
    created_by    nvarchar(255),
    created_date  datetime,
    updated_by    nvarchar(255),
    updated_date  datetime,
    refresh_token varchar(500),
    user_id       numeric(19)
)
    go

create table users
(
    id            numeric(19) identity
        primary key,
    created_by    nvarchar(255),
    created_date  datetime,
    updated_by    nvarchar(255),
    updated_date  datetime,
    email         varchar(255)
        constraint UK_6dotkott2kjsp8vw4d0m25fb7
            unique,
    name          varchar(255),
    password_hash varchar(255) not null,
    status        varchar(255),
    username      varchar(255)
        constraint UK_r43af9ap4edm43mmtq01oddj6
            unique
)
    go

create table user_roles
(
    user_id numeric(19) not null
        constraint FKhfh9dx7w3ubf1co1vdev94g3f
            references users,
    role_id numeric(19) not null
        constraint FKh8ciramu9cc9q3qcqiv4ue8a6
            references roles,
    primary key (user_id, role_id)
)
    go

