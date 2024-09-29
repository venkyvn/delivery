ALTER TABLE receipt
    ADD sub_package_json nvarchar(MAX);
ALTER TABLE receipt
    ADD bill_status nvarchar(100);
ALTER TABLE receipt
    ADD settlement_status nvarchar(100);
