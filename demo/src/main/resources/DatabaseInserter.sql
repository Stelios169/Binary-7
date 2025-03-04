-- -- Licensed under the Apache License, Version 2.0
-- -- For more details, see the LICENSE file in the root directory.

-- -- ! DO NOT RUN THE FOLLOWING BLOCK IF NOT NESESERY !
-- -- Only do so in case the database schema is recreated


INSERT INTO Progr.Restaurant (restaurant_id, restaurant_name, restaurant_address, restaurant_tel, restaurant_afm, restaurant_email, restaurant_rating, restaurant_password)
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
    (1, 'Tomato', 1.2, 'kg', 50.0, '2025-01-20'),
    (2, 'Mozzarella Cheese', 3.0, 'kg', 30.0, '2025-01-21'),
    (3, 'Pepperoni', 5.0, 'kg', 20.0, '2025-01-22'),
    (4, 'Salmon', 10.0, 'kg', 15.0, '2025-01-17'),
    (5, 'Garlic', 0.5, 'kg', 10.0, '2025-01-29'),
    (6, 'Basil', 2.0, 'kg', 15.0, '2025-01-20'),
    (7, 'Tuna', 12.0, 'kg', 10.0, '2025-01-23'),
    (8, 'Rice', 1.5, 'kg', 100.0, '2025-01-25'),
    (9, 'Nori Seaweed', 0.8, 'kg', 50.0, '2025-01-27'),
    (10, 'Shrimp', 8.0, 'kg', 10.0, '2025-01-22'),
    (11, 'Soy Sauce', 2.0, 'lt', 30.0, '2025-01-22'),
    (12, 'Tempura Flour', 3.0, 'kg', 20.0, '2025-02-22');

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

INSERT INTO Progr.RTable (table_id, restaurant_id)
VALUES
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1),
(6, 1), (7, 1), (8, 1), (9, 1), (10, 1),
(11, 1), (12, 1), (13, 1), (14, 1), (15, 1),
(16, 1), (17, 1), (18, 1), (19, 1), (20, 1),
(21, 1), (22, 1), (23, 1), (24, 1), (25, 1),
(26, 1), (27, 1), (28, 1), (29, 1), (30, 1),
(31, 1), (32, 1), (33, 1), (34, 1), (35, 1),
(36, 1), (37, 1), (38, 1), (39, 1), (40, 1),
(41, 1), (42, 1), (43, 1), (44, 1), (45, 1),
(46, 1), (47, 1), (48, 1), (49, 1), (50, 1),
(51, 1), (52, 1), (53, 1), (54, 1), (55, 1),
(56, 1), (57, 1), (58, 1), (59, 1), (60, 1),
(61, 1), (62, 1), (63, 1), (64, 1), (65, 1),
(66, 1), (67, 1), (68, 1), (69, 1), (70, 1),
(71, 1), (72, 1), (73, 1), (74, 1), (75, 1),
(76, 1), (77, 1), (78, 1), (79, 1), (80, 1),
(81, 1), (82, 1), (83, 1), (84, 1), (85, 1),
(86, 1), (87, 1), (88, 1), (89, 1), (90, 1),
(91, 1), (92, 1), (93, 1), (94, 1), (95, 1),
(96, 1), (97, 1), (98, 1), (99, 1), (100, 1),
(1, 2), (2, 2), (3, 2), (4, 2), (5, 2),
(6, 2), (7, 2), (8, 2), (9, 2), (10, 2),
(11, 2), (12, 2), (13, 2), (14, 2), (15, 2),
(16, 2), (17, 2), (18, 2), (19, 2), (20, 2),
(21, 2), (22, 2), (23, 2), (24, 2), (25, 2),
(26, 2), (27, 2), (28, 2), (29, 2), (30, 2),
(31, 2), (32, 2), (33, 2), (34, 2), (35, 2),
(36, 2), (37, 2), (38, 2), (39, 2), (40, 2),
(41, 2), (42, 2), (43, 2), (44, 2), (45, 2),
(46, 2), (47, 2), (48, 2), (49, 2), (50, 2),
(51, 2), (52, 2), (53, 2), (54, 2), (55, 2),
(56, 2), (57, 2), (58, 2), (59, 2), (60, 2),
(61, 2), (62, 2), (63, 2), (64, 2), (65, 2),
(66, 2), (67, 2), (68, 2), (69, 2), (70, 2),
(71, 2), (72, 2), (73, 2), (74, 2), (75, 2),
(76, 2), (77, 2), (78, 2), (79, 2), (80, 2),
(81, 2), (82, 2), (83, 2), (84, 2), (85, 2),
(86, 2), (87, 2), (88, 2), (89, 2), (90, 2),
(91, 2), (92, 2), (93, 2), (94, 2), (95, 2),
(96, 2), (97, 2), (98, 2), (99, 2), (100, 2);


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
