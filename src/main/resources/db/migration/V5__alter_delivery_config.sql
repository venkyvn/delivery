ALTER TABLE delivery_config
    ADD code nvarchar(255);

ALTER TABLE delivery_config
    ADD name nvarchar(255);

ALTER TABLE delivery_config
    ADD note nvarchar(255);

ALTER TABLE delivery_config
    ADD percentage nvarchar(255);

ALTER TABLE delivery_config
drop
column tax;

ALTER TABLE region_rates
ALTER
COLUMN label nvarchar(255);

ALTER TABLE region_rates
ALTER
COLUMN name nvarchar(255);

ALTER TABLE region_rates
ALTER
COLUMN note nvarchar(255);

GO

