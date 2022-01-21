# README.md
A rest api made with flask and postgresql.

Requirements:
~~~
pip install flask flask-sqlalchemy flask-marshmallow psycopg2
~~~

Then you need to go to the app.py file, change the database user and password to your own on the line 7 and run the file.

You can perform crud operations based on different routes:

GET
--
/products

GET
--
/products/id

id **required**

**int**

ID of the product

POST
--
/products

**Body parameters**

name **string**

Name of the product

description **string**

Description of the product

PUT
--
/products/id

id **required**

**int**

ID of the product

**Body parameters**

name **string**

Name of the product

description **string**

Description of the product

DELETE
--
/products/id

id **required**

**int**

ID of the product