INSERT INTO roles (name) VALUES ('ROLE_ADMIN');
INSERT INTO roles (name) VALUES ('ROLE_USER');


INSERT INTO categories (name, description) VALUES ('Electronica', 'Esta categoria contiene productos electronicos de muchas marcas');


INSERT INTO products (name, description, upc, trademark, quantity, price) VALUES ('Audifonos Bluetooth Jbl Vibe', 'BL, marca de renombre mundial en el mercado de audio, es desde hace más 70 años una referente por la alta calidad de sus productos.', "0000", "JBL", 12, 856.50);

INSERT INTO categories_products (categories_id, products_id) VALUES (1, 1);

