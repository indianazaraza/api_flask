from flask import Flask, request, jsonify
from flask_sqlalchemy import SQLAlchemy
from flask_marshmallow import Marshmallow

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = "postgresql+psycopg2://postgres:zachemya@localhost/categories"
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

database = SQLAlchemy(app)
marshmall = Marshmallow(app)


class Products(database.Model):
    """Create a record in the database table"""
    id = database.Column(database.Integer, primary_key=True)
    name = database.Column(database.String(30), nullable=False)
    description = database.Column(database.String())

    def __init__(self, name, description):
        self.name = name
        self.description = description


# Create table
database.create_all()


class ProductsSchema(marshmall.Schema):
    """Database table schema"""

    class Meta:
        fields = ("id", "name", "description")


product_schema = ProductsSchema()
# Deals with more than one object
products_schema = ProductsSchema(many=True)


@app.route('/products', methods=["GET"])
def products():
    """Get all products"""
    all_products = Products.query.all()
    return jsonify(products_schema.dump(all_products))


@app.route('/products/<id>', methods=["GET"])
def product(id):
    """Get a product given an id"""
    id_product = Products.query.get(id)
    return product_schema.jsonify(id_product)


@app.route('/products', methods=["POST"])
def create_product():
    """Create a product"""
    data = request.get_json(force=True)
    name = data['name']
    description = data['description']
    new_product = Products(name, description)
    database.session.add(new_product)
    database.session.commit()
    return product_schema.jsonify(new_product)


@app.route('/products/<id>', methods=['PUT'])
def update_product(id):
    """Update a product given an id"""
    id_product = Products.query.get(id)
    data = request.get_json(force=True)
    id_product.name = data['name']
    id_product.description = data['description']
    database.session.commit()
    return product_schema.jsonify(id_product)


@app.route('/products/<id>', methods=['DELETE'])
def delete_product(id):
    """Delete a product given an id"""
    id_product = Products.query.get(id)
    database.session.delete(id_product)
    database.session.commit()
    return product_schema.jsonify(id_product)


if __name__ == "__main__":
    app.run(debug=True)
