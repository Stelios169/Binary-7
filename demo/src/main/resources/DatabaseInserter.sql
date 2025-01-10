-- ! DO NOT RUN THE FOLLOWING BLOCK IF NOT NESESERY !
-- Only do so in case the database schema is recreated

/*INSERT INTO Progr.Restaurant (restaurant_id, restaurant_name, restaurant_address, restaurant_tel, restaurant_afm, restaurant_email, restaurant_rating, restaurant_password)
VALUES
    (1, 'La Pasteria', 'Patision 28, Athens', 2101234567, 123456789012, 'despinalab@gmail.com', 4.5, 'password123'),
    (2, 'Shisan', 'Ermou 8, Athens', 2109876543, 987654321098, 'stella.panopoulou678@gmail.com', 4.8, 'password456');

INSERT INTO Progr.Dish (dish_id, dish_name, dish_category, dish_price, dish_image_url, dish_description, dish_availability)
VALUES
    (1, 'Margherita Pizza', 'Main Courses', 9.99, 'http://example.com/margherita.jpg', 'Classic pizza with tomatoes and mozzarella', TRUE),
    (2, 'Pepperoni Pizza', 'Main Courses', 12.99, 'http://example.com/pepperoni.jpg', 'Pizza topped with pepperoni and cheese', TRUE),
    (3, 'Salmon Sushi', 'Main Courses', 15.99, 'http://example.com/salmon.jpg', 'Fresh salmon sushi with rice', TRUE),
    (4, 'Garlic Bread', 'Appetizers', 5.99, 'http://example.com/garlicbread.jpg', 'Toasted bread with garlic butter and herbs', TRUE),
    (5, 'Bruschetta', 'Appetizers', 6.99, 'http://example.com/bruschetta.jpg', 'Grilled bread topped with tomato, garlic, and basil', TRUE),
    (6, 'Tuna Sashimi', 'Main Courses', 18.99, 'http://example.com/tuna_sashimi.jpg', 'Freshly sliced tuna served as sashimi', TRUE),
    (7, 'Maki Roll', 'Main Courses', 12.99, 'http://example.com/maki_roll.jpg', 'Rolled sushi with various fillings', TRUE),
    (8, 'Edamame', 'Appetizers', 4.99, 'http://example.com/edamame.jpg', 'Steamed young soybeans with sea salt', TRUE),
    (9, 'Tempura Shrimp', 'Main Courses', 13.99, 'http://example.com/tempura_shrimp.jpg', 'Crispy deep-fried shrimp served with dipping sauce', TRUE),
    (10, 'Tiramisu', 'Desserts', 6.99, 'http://example.com/tiramisu.jpg', 'Classic Italian dessert with coffee-soaked ladyfingers', TRUE),
    (11, 'Ice Cream', 'Desserts', 5.99, 'http://example.com/ice_cream.jpg', 'Creamy ice cream made with green tea', TRUE);

INSERT INTO Progr.Ingredient (ingredient_id, ingredient_name, ingredient_cost, ingredient_unit, ingredient_stock, ingredient_exp_date)
VALUES
    (1, 'Tomato', 1.2, 'kg', 50.0, '2024-12-31'),
    (2, 'Mozzarella Cheese', 3.0, 'kg', 30.0, '2025-01-10'),
    (3, 'Pepperoni', 5.0, 'kg', 20.0, '2025-01-03'),
    (4, 'Salmon', 10.0, 'kg', 15.0, '2025-01-15'),
    (5, 'Garlic', 0.5, 'kg', 10.0, '2025-01-08'),
    (6, 'Basil', 2.0, 'kg', 15.0, '2025-01-01'),
    (7, 'Tuna', 12.0, 'kg', 10.0, '2025-12-05'),
    (8, 'Rice', 1.5, 'kg', 100.0, '2025-12-31'),
    (9, 'Nori Seaweed', 0.8, 'kg', 50.0, '2025-02-01'),
    (10, 'Shrimp', 8.0, 'kg', 10.0, '2025-01-02'),
    (11, 'Soy Sauce', 2.0, 'lt', 30.0, '2026-10-31'),
    (12, 'Tempura Flour', 3.0, 'kg', 20.0, '2025-02-03');

INSERT INTO Progr.DishIngredients (dish_id, ingredient_id, ingredient_quantity)
VALUES
    (1, 1, 0.2),
    (1, 2, 0.3),
    (2, 2, 0.3),
    (2, 3, 0.5),
    (3, 4, 0.1),
    (3, 8, 0.2),
    (4, 5, 0.1),
    (4, 6, 0.05), 
    (5, 1, 0.15),
    (5, 6, 0.1),
    (6, 7, 0.1),
    (7, 9, 0.05),
    (7, 8, 0.1),
    (8, 10, 0.2),
    (9, 10, 0.3),
    (9, 12, 0.1),
    (10, 4, 0.1),
    (11, 4, 0.05);

INSERT INTO Progr.Purchase (purchase_id, ingredient_id, purchase_quantity, purchase_date)
VALUES
    (1, 1, 20.0, '2025-01-02'),
    (2, 2, 10.0, '2025-01-03'),
    (3, 3, 5.0, '2025-01-01'),
    (4, 4, 10.0, '2025-01-04'),
    (5, 5, 15.0, '2024-12-31');

INSERT INTO Progr.RTable (table_id, restaurant_id)
VALUES
    (1, 1),
    (2, 1),
    (3, 1),
    (1, 2),
    (2, 2),
    (3, 2),
    (4, 2);

INSERT INTO Progr.RestaurantDishes (restaurant_id, dish_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 3),
    (1, 4),
    (1, 5),
    (2, 6),
    (2, 7),
    (2, 8),
    (2, 9),
    (1, 10),
    (2, 11);
    
INSERT INTO Progr.Review (review_id, restaurant_id, review_rating, review_comment)
VALUES
    (1, 1, 5, 'Best pizza in town!!!'),
    (2, 1, 3, 'The food was good, but the service could be better :(');

INSERT INTO Progr.Orders (order_id, table_id, restaurant_id, order_total, order_status, order_datetime)
VALUES
    (1, 1, 1, 40.0, TRUE, '2025-01-04 18:30:00'),
    (2, 2, 2, 35.0, TRUE, '2025-01-04 19:00:00'),
    (3, 3, 1, 50.0, FALSE, '2025-01-04 19:15:00'),
    (4, 1, 1, 120.0, TRUE, '2025-01-04 19:12:00');

INSERT INTO Progr.OrderPerDish (dish_id, order_id, orderPerDish_quantity)
VALUES
    (1, 1, 2),
    (2, 1, 1),
    (3, 2, 1),
    (4, 2, 2),
    (5, 3, 1),
    (3, 4, 4);*/
