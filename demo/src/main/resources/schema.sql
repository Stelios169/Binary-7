--Creates the schema only if it doesn't exist (will only happen in the first time of running the application)
CREATE SCHEMA IF NOT EXISTS Progr;
SET SCHEMA Progr;

-- Stores basic information about each restaurant

CREATE TABLE IF NOT EXISTS Progr.Restaurant (
    restaurant_id INT NOT NULL PRIMARY KEY,
    restaurant_name VARCHAR(60) NOT NULL,
    restaurant_address VARCHAR(50) NOT NULL,
    restaurant_tel BIGINT NOT NULL CHECK (restaurant_tel > 0),
    restaurant_afm BIGINT NOT NULL CHECK (restaurant_afm > 0),
    restaurant_email VARCHAR(50) NOT NULL UNIQUE,
    restaurant_rating FLOAT CHECK (restaurant_rating >= 0 AND restaurant_rating <= 5),
    restaurant_password VARCHAR(255) NOT NULL
);

--Stores all the dishes that each restaurant offers

CREATE TABLE IF NOT EXISTS Progr.Dish (
    dish_id INT NOT NULL PRIMARY KEY,
    dish_name VARCHAR(60) NOT NULL,
    dish_category VARCHAR(60) NOT NULL,
    dish_price FLOAT NOT NULL CHECK (dish_price >= 0),
    dish_image_url NVARCHAR(2083),
    dish_description VARCHAR(1000),
    dish_availability BOOLEAN NOT NULL
);

-- Stores all ingredients that a restaurant may use in dish preparation

CREATE TABLE IF NOT EXISTS Progr.Ingredient (
    ingredient_id INT NOT NULL PRIMARY KEY,
    ingredient_name VARCHAR(60) NOT NULL,
    ingredient_cost FLOAT CHECK (ingredient_cost >= 0),
    ingredient_unit VARCHAR(3) NOT NULL,
    ingredient_stock FLOAT CHECK (ingredient_stock >= 0),
    ingredient_exp_date DATE NOT NULL
);

-- Stores the ingredients used in the preparation of specific dishes

CREATE TABLE IF NOT EXISTS Progr.DishIngredients (
    dish_id INT NOT NULL,
    ingredient_id INT NOT NULL,
    ingredient_quantity FLOAT NOT NULL CHECK (ingredient_quantity >= 0),
    PRIMARY KEY (dish_id, ingredient_id),
    FOREIGN KEY (dish_id) REFERENCES Progr.Dish (dish_id),
    FOREIGN KEY (ingredient_id) REFERENCES Progr.Ingredient (ingredient_id)
);

-- Tracks the purchases of ingredients made by restaurants

CREATE TABLE IF NOT EXISTS Progr.Purchase (
    purchase_id INT NOT NULL PRIMARY KEY,
    ingredient_id INT NOT NULL,
    purchase_quantity FLOAT NOT NULL CHECK (purchase_quantity >= 0),
    purchase_date DATE NOT NULL,
    FOREIGN KEY (ingredient_id) REFERENCES Progr.Ingredient (ingredient_id)
);

-- Represents the tables available in each restaurant

CREATE TABLE IF NOT EXISTS Progr.RTable (
    table_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    PRIMARY KEY (restaurant_id, table_id),
    FOREIGN KEY (restaurant_id) REFERENCES Progr.Restaurant (restaurant_id)
);

-- Connects restaurants to their tables
 
CREATE TABLE IF NOT EXISTS Progr.RestaurantDishes (
    restaurant_id INT NOT NULL,
    dish_id INT NOT NULL,
    PRIMARY KEY (restaurant_id, dish_id),
    FOREIGN KEY (restaurant_id) REFERENCES Progr.Restaurant (restaurant_id),
    FOREIGN KEY (dish_id) REFERENCES Progr.Dish (dish_id)
);

-- Stores customer reviews for restaurants

CREATE TABLE IF NOT EXISTS Progr.Review (
    review_id INT NOT NULL PRIMARY KEY,
    restaurant_id INT NOT NULL,
    review_rating FLOAT NOT NULL CHECK (review_rating >= 0 AND review_rating <= 5),
    review_comment VARCHAR(2000),
    FOREIGN KEY (restaurant_id) REFERENCES Progr.Restaurant (restaurant_id)
);

-- Tracks open tabs for tables in a restaurant

CREATE TABLE IF NOT EXISTS Progr.Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    table_id INT NOT NULL,
    restaurant_id INT NOT NULL,
    order_total FLOAT CHECK (order_total >= 0),
    order_status BOOLEAN DEFAULT TRUE,
    order_datetime DATETIME,
    FOREIGN KEY (table_id, restaurant_id) REFERENCES Progr.RTable (table_id, restaurant_id)
);

-- Tracks individual dishes within orders

CREATE TABLE IF NOT EXISTS Progr.OrderPerDish (
    dish_id INT NOT NULL,
    order_id INT NOT NULL,
    orderPerDish_quantity INT NOT NULL CHECK (orderPerDish_quantity > 0),
    PRIMARY KEY (dish_id, order_id),
    FOREIGN KEY (dish_id) REFERENCES Progr.Dish (dish_id),
    FOREIGN KEY (order_id) REFERENCES Progr.Orders (order_id)
);

-- Recreates the schema
-- ! DO NOT RUN THE FOLLOWING LINE IF NOT NESESERY !
-- DROP SCHEMA Progr CASCADE;