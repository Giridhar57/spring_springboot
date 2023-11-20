CREATE SCHEMA cookpick; 

USE cookpick; 

 

create table product( 

   product_id int, 

   product_name VARCHAR(20), 

   product_vendor VARCHAR(20), 

   product_price double , 

   product_in_stock boolean, 

   PRIMARY KEY (product_id) 
); 
