# README.md
A rest api made with flask and postgresql.

Requirements:
~~~
pip install flask flask-sqlalchemy flask-marshmallow psycopg2
~~~
You must have the categories database created.

Then you need to go to the app.py file, change the database user and password to your own on the line 7 and run the file.

The api creates the products table along with the fields: id, name and description.

You can perform crud operations based on different routes: GET, POST, PUT and DELETE.

You can see the documentation made with [postman](https://documenter.getpostman.com/view/18957545/UVXqGZPW).


