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
    values  ('root', 'default', 'default','pass1234', '00-00-0000', '0000', 'Default', 'Default', '0', '00000','100'),
            ('jondoe@gmail.com','Jon','Doe','tVp7@MR59q','01-31-2001','3959','Pickens Way','Whitewright','TX','75491','100'),
            ('jackenoff@gmail.com','Jack','Enoff','99C2*iXAn3','04-12-2001','1485','Tator Patch Road','Chicago','IL','60605','100'),
            ('bendover@gmail.com','Ben','Dover','77@Z!G54pa','09-12-2000','3780','Green Acres Road','Greenville','NC','27834','100'),
            ('erinmoore@gmail.com','Erin','Moore','f5eO#24Z4@','04-18-2002','3921','Junior Avenue','Atlanta','GA','30309','100'),
            ('mikehunt@gmail.com','Mike','Hunt','RxS4k0$u30','09-15-1999','426','Farnum Road','New York City','NY','10004','100'),
            ('jessicacole@gmail.com','Jessica','Cole','G@078D*k3x','04-10-2001','444','Five Points','Easton','MD','21601','100'),
            ('meganfoxx@gmail.com','Megan','Foxx','%nXtVh264c','08-14-2000','3513','Palmer Road','Worthington','OH','43085','100'),
            ('harrybules@gmail.com','Harry','Bules','*x^Z9%me40','08-17-2000','859','Bassel Street','Metairie','LA','70001','100'),
            ('marymean@gmail.com','Mary','Mean','d^F3!s39$%','8c2cha1*D9','2562','Gateway Avenue','Bakersfield','CA','93301','100');
select * from User;