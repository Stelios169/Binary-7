DROP SCHEMA Progr CASCADE;

CREATE SCHEMA Progr;

CREATE TABLE Progr.Restaurant (
restaurant_id INT NOT NULL PRIMARY KEY,
restaurant_name VARCHAR(60) NOT NULL,
restaurant_address VARCHAR(50) NOT NULL,
restaurant_tel INT NOT NULL,
restaurant_afm INT NOT NULL,
restaurant_email VARCHAR(50) NOT NULL,
restaurant_rating FLOAT
);

CREATE TABLE Progr.Dish_Category (
category_id INT NOT NULL PRIMARY KEY,
category_name VARCHAR(60) NOT NULL
);

CREATE TABLE Progr.Dish (
dish_id INT NOT NULL PRIMARY KEY,
restaurant_id INT,
dish_name VARCHAR(60) NOT NULL,
dish_category INT,
dish_price FLOAT NOT NULL CHECK (dish_price >= 0),
dish_image NVARCHAR(2083),
dish_description VARCHAR(1000),
dish_availability INT CHECK (dish_availability = 1 OR dish_availability = 2),
FOREIGN KEY (restaurant_id) REFERENCES Progr.Restaurant (restaurant_id),
FOREIGN KEY (dish_category) REFERENCES Progr.Dish_Category (category_id)
);

CREATE TABLE Progr.Ingredient (
ingredient_id INT NOT NULL PRIMARY KEY,
ingredient_name VARCHAR(60) NOT NULL,
ingredient_cost FLOAT CHECK (ingredient_cost >= 0),
ingredient_unit VARCHAR(3) NOT NULL,
ingredient_stock FLOAT CHECK (ingredient_stock >= 0),
ingredient_exp_date INT CHECK (ingredient_exp_date >= 0)
);

CREATE TABLE Progr.Dish_Ingridients (
dish_id INT,
ingredient_id INT,
ingredient_quantity FLOAT CHECK (ingredient_quantity >= 0),
FOREIGN KEY (dish_id) REFERENCES Progr.Dish (dish_id),
FOREIGN KEY (ingredient_id) REFERENCES Progr.Ingredient (ingredient_id)
);

CREATE TABLE Progr.Purchase (
ingredient_id INT NOT NULL PRIMARY KEY,
purchase_quantity FLOAT CHECK (purchase_quantity >= 0),
purchase_cost FLOAT CHECK (purchase_cost >= 0),
purchase_date DATE,
FOREIGN KEY (ingredient_id) REFERENCES Progr.Ingredient (ingredient_id)
);

CREATE TABLE Progr.RTable (
table_id INT NOT NULL PRIMARY KEY,
table_total FLOAT CHECK (table_total >= 0)
);

CREATE TABLE Progr.Review (
review_id INT NOT NULL PRIMARY KEY,
table_id INT,
review_rating INT CHECK (review_rating >= 0 AND review_rating <= 5),
review_comment VARCHAR(200),
FOREIGN KEY (table_id) REFERENCES Progr.RTable (table_id)
);

CREATE TABLE Progr.Ordrer (
order_id INT NOT NULL PRIMARY KEY,
table_id INT,
dish_id INT,
order_datetime DATETIME NOT NULL,
order_subtotal FLOAT CHECK (order_subtotal >= 0),
FOREIGN KEY (table_id) REFERENCES Progr.RTable (table_id),
FOREIGN KEY (dish_id) REFERENCES Progr.Dish (dish_id)
);
