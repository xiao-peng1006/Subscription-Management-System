create schema `subscription_management`;

create table `subscription_management`.`service_provider` (
	`id` int not null auto_increment,
    `name` varchar(45) not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`id`));
    
create table `subscription_management`.`subscriber` (
	`email` varchar(45) not null,
    `first_name` varchar(45),
    `last_name` varchar(45),
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`email`));

create table `subscription_management`.`subscription` (
	`id` int not null auto_increment,
    `status` varchar(45) not null,
    `auto_renew` boolean not null,
    `base` boolean not null,
    `service_provider_id` int not null,
    `subscriber_email` varchar(45) not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`id`),
    constraint `service_provider_id`
		foreign key (`service_provider_id`)
        references `subscription_management`.`service_provider` (`id`)
        on delete no action
        on update no action,
	constraint `subscriber_email`
		foreign key (`subscriber_email`)
        references `subscription_management`.`subscriber` (`email`)
        on delete no action
        on update no action);
        
create table `subscription_management`.`subscription_plan` (
	`id` int not null,
    `duration` int not null,
    `cost` int not null,
    `owner_subscription_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`id`),
    constraint `owner_subscription_id`
		foreign key (`owner_subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
		on update no action);

create table `subscription_management`.`service_provider_has_subscription` (
	`relation_service_provider_id` int not null,
	`relation_subscription_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`relation_service_provider_id`, `relation_subscription_id`),
    constraint `relation_service_provider_id`
		foreign key (`relation_service_provider_id`)
        references `subscription_management`.`service_provider` (`id`)
        on delete no action
		on update no action,
    constraint `relation_subscription_id`
		foreign key (`relation_subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
		on update no action);

create table `subscription_management`.`addon_subscription` (
	`addon_subscription_id` int not null,
    `base_subscription_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`addon_subscription_id`, `base_subscription_id`),
    constraint `addon_subscription_id`
		foreign key (`addon_subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
        on update no action,
	constraint `base_subscription_id`
		foreign key (`base_subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
        on update no action);
    
create table `subscription_management`.`subscription_beneficiaries` (
	`email` varchar(45) not null,
    `subscription_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`email`,`subscription_id`),
    constraint `email`
		foreign key (`email`)
        references `subscription_management`.`subscriber` (`email`)
        on delete no action
        on update no action,
	constraint `subscription_id`
		foreign key (`subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
        on update no action);
    

create table `subscription_management`.`order` (
	`id` int not null,
    `date` date not null,
    `status` varchar(45) not null,
    `purchased_subscription_id` int not null,
    `order_placed_email` varchar(45) not null,
    `purchased_subscription_plan_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`id`),
	constraint `purchased_subscription_id`
		foreign key (`purchased_subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
        on update no action,
	constraint `order_placed_email`
		foreign key (`order_placed_email`)
        references `subscription_management`.`subscriber` (`email`)
        on delete no action
        on update no action,
	 constraint `purchased_subscription_plan_id`
		foreign key (`purchased_subscription_plan_id`)
        references `subscription_management`.`subscription_plan` (`id`)
        on delete no action
        on update no action);

create table `subscription_management`.`period` (
	`id` int not null,
    `start_time` datetime not null,
    `end_time` datetime not null,
    `period_subscription_id` int not null,
    `order_id` int not null,
    `period_subscription_plan_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`id`),
    constraint `period_subscription_id`
		foreign key (`period_subscription_id`)
        references `subscription_management`.`subscription` (`id`)
        on delete no action
        on update no action,
	constraint `order_id`
		foreign key (`order_id`)
        references `subscription_management`.`order` (`id`)
        on delete no action
        on update no action,
	constraint `period_subscription_plan_id`
		foreign key (`period_subscription_plan_id`)
        references `subscription_management`.`subscription_plan` (`id`)
        on delete no action
        on update no action);

create table `subscription_management`.`subscription_has_period` (
	`id` int not null,
    `period_id` int not null,
    `create_time` datetime not null,
    `last_update_time` datetime not null,
    primary key (`id`),
    constraint `period_id`
		foreign key (`period_id`)
        references `subscription_management`.`period` (`id`)
        on delete no action
        on update no action);