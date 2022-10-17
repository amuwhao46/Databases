use NFTdb;
drop table if exists User; 
CREATE TABLE if not exists User(
    userid VARCHAR(10) NOT NULL,
    email VARCHAR(50) NOT NULL, 
    firstName VARCHAR(10) NOT NULL, 
    lastName VARCHAR(10) NOT NULL, 
    password VARCHAR(10) NOT NULL, 
    birthday DATE NOT NULL, 
    adress_street_num VARCHAR(4) , 
    adress_street VARCHAR(30) , 
    adress_city VARCHAR(20), 
    adress_state VARCHAR(2),
    adress_zip_code VARCHAR(5),
    init_bal DECIMAL(13,2) DEFAULT 1000,
    PPS_bal DECIMAL(13,2) DEFAULT 0,
    PRIMARY KEY (userid) ); 
    insert into User(userid, email, firstName, lastName, password, birthday, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, init_bal)
    values  ('0000000000','root', 'default', 'default','pass1234', '0000-00-00', '0000', 'Default', 'Default', '0', '00000','100'),
            ('3331398714','bendover@gmail.com','Ben','Dover','RandomString123','09-09-1999','2375','Something Dr.','Sterling Heights','MI','48314','100'),
            ('6729620608','','','','','','','','','','',''),
            ('7349883064','','','','','','','','','','',''),
            ('7023314302','','','','','','','','','','',''),
            ('7519164811','','','','','','','','','','',''),
            ('3375550918','','','','','','','','','','',''),
            ('3172913064','','','','','','','','','','',''),
            ('9000887893','','','','','','','','','','',''),
            ('8810766662','','','','','','','','','','','');
select * from User;