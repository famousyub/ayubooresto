create schema restaurant collate latin1_swedish_ci;

create table comments
(
    id bigint unsigned auto_increment
        primary key,
    email varchar(191) not null,
    name varchar(191) not null,
    subject varchar(191) not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create index comments_email_index
    on comments (email);

create table deliveries
(
    user_id bigint not null,
    date date not null,
    service_time time not null,
    delivery_address varchar(191) not null,
    delivery_fee double not null,
    order_id bigint not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (user_id, date)
)
    collate=utf8mb4_unicode_ci;

create index deliveries_order_id_foreign
    on deliveries (order_id);

create table employee
(
    id bigint unsigned auto_increment
        primary key,
    name varchar(191) not null,
    payment_classification_id bigint not null,
    payment_method_id bigint not null,
    payment_schedule_id bigint not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table failed_jobs
(
    id bigint unsigned auto_increment
        primary key,
    connection text not null,
    queue text not null,
    payload longtext not null,
    exception longtext not null,
    failed_at timestamp default CURRENT_TIMESTAMP not null
)
    collate=utf8mb4_unicode_ci;

create table hibernate_sequence
(
    next_val bigint null
)
    engine=InnoDB;

create table hibernate_sequences
(
    sequence_name varchar(255) not null
        primary key,
    next_val bigint null
)
    engine=InnoDB;

create table hold_method
(
    id bigint unsigned auto_increment
        primary key,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table hourly_classification
(
    id bigint unsigned auto_increment
        primary key,
    hourly_rate double not null,
    over_hours_bonus_rate double not null,
    over_hours_threshold int not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table items
(
    id bigint unsigned auto_increment
        primary key,
    name varchar(191) not null,
    description varchar(191) null,
    image varchar(191) null,
    price double not null,
    calories double null,
    fat double null,
    protein double null,
    carbohydrates double null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table items_types
(
    item_id bigint not null,
    types_name varchar(191) not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (item_id, types_name)
)
    collate=utf8mb4_unicode_ci;

create table message
(
    id bigint unsigned auto_increment
        primary key,
    contents varchar(191) not null,
    sender varchar(191) not null,
    receiver varchar(191) not null,
    seen tinyint(1) not null,
    created_at datetime(6) not null
)
    collate=utf8mb4_unicode_ci;

create table migrations
(
    id int unsigned auto_increment
        primary key,
    migration varchar(191) not null,
    batch int not null
)
    collate=utf8mb4_unicode_ci;

create table monthly_schedule
(
    id bigint unsigned auto_increment
        primary key,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table order_items
(
    order_id bigint not null,
    item_id bigint not null,
    quantity int not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (order_id, item_id)
)
    collate=utf8mb4_unicode_ci;

create index order_items_item_id_foreign
    on order_items (item_id);

create table orders
(
    id bigint unsigned auto_increment
        primary key,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table password_resets
(
    email varchar(191) not null,
    token varchar(191) not null,
    created_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create index password_resets_email_index
    on password_resets (email);

create table ratings
(
    user_id bigint not null,
    item_id bigint not null,
    rating int not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (user_id, item_id)
)
    collate=utf8mb4_unicode_ci;

create index ratings_item_id_foreign
    on ratings (item_id);

create table recommendations
(
    user_id bigint not null,
    item_id bigint not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (user_id, item_id)
)
    collate=utf8mb4_unicode_ci;

create index recommendations_item_id_foreign
    on recommendations (item_id);

create table reservations
(
    user_id bigint not null,
    date date not null,
    service_time time not null,
    active tinyint(1) not null,
    reservation_fee double not null,
    order_id bigint not null,
    table_id bigint not null,
    created_at timestamp null,
    updated_at timestamp null,
    primary key (user_id, date)
)
    collate=utf8mb4_unicode_ci;

create index reservations_order_id_foreign
    on reservations (order_id);

create index reservations_table_id_foreign
    on reservations (table_id);

create table salaried_classification
(
    id bigint unsigned auto_increment
        primary key,
    salary double not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table sick_classification
(
    id bigint unsigned auto_increment
        primary key,
    compensation double not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table tables
(
    id bigint unsigned auto_increment
        primary key,
    capacity int not null,
    fee double not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create table telegram_users
(
    id int not null
        primary key,
    email varchar(191) null,
    last_command varchar(191) null,
    verification_code int null,
    is_verified tinyint(1) default 0 not null
)
    collate=utf8mb4_unicode_ci;

create table timecard
(
    date date not null,
    hourly_classification_id bigint not null,
    time_worked time not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create index timecard_hourly_classification_id_foreign
    on timecard (hourly_classification_id);

create table types
(
    name varchar(191) not null
        primary key
)
    collate=utf8mb4_unicode_ci;

create table userlaters
(
    id bigint unsigned auto_increment
        primary key,
    email varchar(191) not null,
    city varchar(191) not null,
    region varchar(191) not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

create index userlaters_email_index
    on userlaters (email);

create table users
(
    id bigint unsigned auto_increment
        primary key,
    name varchar(191) not null,
    email varchar(191) not null,
    email_verified_at timestamp null,
    password varchar(191) not null,
    remember_token varchar(100) null,
    created_at timestamp null,
    updated_at timestamp null,
    constraint users_email_unique
        unique (email)
)
    collate=utf8mb4_unicode_ci;

create table weekly_schedule
(
    id bigint unsigned auto_increment
        primary key,
    payment_day int not null,
    created_at timestamp null,
    updated_at timestamp null
)
    collate=utf8mb4_unicode_ci;

