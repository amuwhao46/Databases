use NFTdb;
drop table if exists User; 
CREATE TABLE if not exists User(
    userid VARCHAR(50) NOT NULL, 
    firstName VARCHAR(10) NOT NULL, 
    lastName VARCHAR(10) NOT NULL, 
    password VARCHAR(10) NOT NULL, 
    birthday DATE NOT NULL, 
    adress_street_num VARCHAR(4) , 
    adress_street VARCHAR(30) , 
    adress_city VARCHAR(20), 
    adress_state VARCHAR(2),
    adress_zip_code VARCHAR(5),
    init_bal DECIMAL(13,2) DEFAULT 100,
    PRIMARY KEY (userid) ); 
    insert into User(userid, firstName, lastName, password, birthday, adress_street_num, adress_street, adress_city, adress_state, adress_zip_code, init_bal)
    values  ('root', 'default', 'default','pass1234', '0000-00-00', '0000', 'Default', 'Default', '0', '00000','100'),
            ('jondoe@gmail.com','Jon','Doe','','','','','','','',''),
            ('jackenoff@gmail.com','Jack','Enoff','','','','','','','',''),
            ('bendover@gmail.com','Ben','Dover','RandomString123','09-09-1999','2375','Something Dr.','Sterling Heights','MI','48314','100'),
            ('erinmoore@gmail.com','Erin','Moore','','','','','','','',''),
            ('mikehunt@gmail.com','Mike','Hunt','','','','','','','',''),
            ('jessicacole@gmail.com','Jessica','Cole','','','','','','','',''),
            ('meganfoxx@gmail.com','Megan','Foxx','','','','','','','',''),
            ('harrybules@gmail.com','Harry','Bules','','','','','','','',''),
            ('marymean@gmail.com','Mary','Mean','','','','','','','','');
select * from User;