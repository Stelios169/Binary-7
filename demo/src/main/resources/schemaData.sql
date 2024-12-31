-- Inserting data into tables that don't change much during the use of our app

INSERT INTO Progr.DishCategory (category_id, category_name)
VALUES
    (1, 'Appetizers'),
    (2, 'Main Course'),
    (3, 'Desserts'),
    (4, 'Drinks');

INSERT INTO Progr.Restaurant (restaurant_id, restaurant_name, restaurant_address, restaurant_tel, restaurant_afm, restaurant_email, restaurant_rating, restaurant_password)
VALUES
    (1, 'Pizza Place', '123 Pizza St, Pizza Town', 1234567890, 123456789012, 'pizza@place.com', 4.5, 'password123'),
    (2, 'Sushi World', '456 Sushi Ave, Tokyo City', 9876543210, 987654321098, 'sushi@world.com', 4.8, 'password456');

INSERT INTO Progr.Dish (dish_id, restaurant_id, dish_name, category_id, dish_price, dish_image_url, dish_description, dish_availability)
VALUES
    -- Pizza Place Dishes (Main Course and Appetizers)
    (1, 1, 'Margherita Pizza', 2, 9.99, 'http://example.com/margherita.jpg', 'Classic pizza with tomatoes and mozzarella', TRUE),
    (2, 1, 'Pepperoni Pizza', 2, 12.99, 'http://example.com/pepperoni.jpg', 'Pizza topped with pepperoni and cheese', TRUE),
    (4, 1, 'Garlic Bread', 1, 5.99, 'http://example.com/garlicbread.jpg', 'Toasted bread with garlic butter and herbs', TRUE),
    (5, 1, 'Bruschetta', 1, 6.99, 'http://example.com/bruschetta.jpg', 'Grilled bread topped with tomato, garlic, and basil', TRUE),
    -- Sushi World Dishes (Main Course and Appetizers)
    (3, 2, 'Salmon Sushi', 2, 15.99, 'http://example.com/salmon.jpg', 'Fresh salmon sushi with rice', TRUE),
    (6, 2, 'Tuna Sashimi', 2, 18.99, 'http://example.com/tuna_sashimi.jpg', 'Freshly sliced tuna served as sashimi', TRUE),
    (7, 2, 'Maki Roll', 2, 12.99, 'http://example.com/maki_roll.jpg', 'Rolled sushi with various fillings', TRUE),
    (8, 2, 'Edamame', 1, 4.99, 'http://example.com/edamame.jpg', 'Steamed young soybeans with sea salt', TRUE),
    (9, 2, 'Tempura Shrimp', 2, 13.99, 'http://example.com/tempura_shrimp.jpg', 'Crispy deep-fried shrimp served with dipping sauce', TRUE),
    -- Desserts (Both Restaurants)
    (10, 1, 'Tiramisu', 3, 6.99, 'http://example.com/tiramisu.jpg', 'Classic Italian dessert with coffee-soaked ladyfingers', TRUE),
    (11, 2, 'Green Tea Ice Cream', 3, 5.99, 'http://example.com/green_tea_ice_cream.jpg', 'Creamy ice cream made with green tea', TRUE);

INSERT INTO Progr.Ingredient (ingredient_id, ingredient_name, ingredient_cost, ingredient_unit, ingredient_stock, ingredient_exp_date, restaurant_id)
VALUES
    -- Pizza Place Ingredients
    (1, 'Tomato', 1.2, 'kg', 50.0, '2025-12-31', 1),
    (2, 'Mozzarella Cheese', 3.0, 'kg', 30.0, '2025-12-31', 1),
    (3, 'Pepperoni', 5.0, 'kg', 20.0, '2025-12-31', 1),
    (5, 'Garlic', 0.5, 'kg', 10.0, '2025-12-31', 1),
    (6, 'Basil', 2.0, 'kg', 15.0, '2025-12-31', 1),
    -- Sushi World Ingredients
    (4, 'Salmon', 10.0, 'kg', 15.0, '2025-12-31', 2),
    (7, 'Tuna', 12.0, 'kg', 10.0, '2025-12-31', 2),
    (8, 'Rice', 1.5, 'kg', 100.0, '2025-12-31', 2),
    (9, 'Nori Seaweed', 0.8, 'kg', 50.0, '2025-12-31', 2),
    (10, 'Shrimp', 8.0, 'kg', 10.0, '2025-12-31', 2),
    (11, 'Soy Sauce', 2.0, 'lt', 30.0, '2025-12-31', 2),
    (12, 'Tempura Flour', 3.0, 'kg', 20.0, '2025-12-31', 2);

INSERT INTO Progr.DishIngredients (dish_id, ingredient_id, ingredient_quantity, restaurant_id)
VALUES
    -- Pizza Place Dish Ingredients
    (1, 1, 0.2, 1),
    (1, 2, 0.3, 1),
    (2, 2, 0.3, 1),
    (2, 3, 0.5, 1),
    (4, 5, 0.1, 1),
    (4, 6, 0.05, 1), 
    (5, 1, 0.15, 1),
    (5, 6, 0.1, 1),
    -- Sushi World Dish Ingredients
    (3, 4, 0.1, 2),
    (3, 8, 0.2, 2),
    (6, 7, 0.1, 2),
    (7, 9, 0.05, 2),
    (7, 8, 0.1, 2),
    (8, 10, 0.2, 2),
    (9, 10, 0.3, 2),
    (9, 12, 0.1, 2),
    (10, 4, 0.1, 2),
    (11, 4, 0.05, 2);


INSERT INTO Progr.RTable (table_id, restaurant_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (1, 2),
    (2, 2),
    (3, 2);
