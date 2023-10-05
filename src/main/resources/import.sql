INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Harry Potter and the Chamber of Secrets', 'http://example.com/images/harrypotter.jpg', 'The second installment in the Harry Potter series.', 1000000, 19.99, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Dune', 'http://example.com/images/dune.jpg', 'A science fiction novel set in a desert world.', 750000, 24.99, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('The Great Gatsby', 'http://example.com/images/gatsby.jpg', 'A classic novel set in the Roaring Twenties.', 500000, 15.99, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('1984', 'http://example.com/images/1984.jpg', 'George Orwell''s dystopian masterpiece.', 800000, 20.00, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('To Kill a Mockingbird', 'http://example.com/images/mockingbird.jpg', 'A novel of racism and injustice.', 4, 18.50, 2);
INSERT INTO category (name) VALUES('fiction');
INSERT INTO category (name) VALUES('teenagers');
INSERT INTO category (name) VALUES('kids');
INSERT INTO category (name) VALUES('science');
INSERT INTO category (name) VALUES('fantasy');
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-05 12:00:00', 5, 1);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-05 14:00:00', 3, 2);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-05 16:00:00', 7, 3);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-05 18:00:00', 2, 4);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-05 20:00:00', 10, 5);
INSERT INTO book_categories (book_id, categories_id) VALUES (1, 5)
INSERT INTO book_categories (book_id, categories_id) VALUES (2, 1)
INSERT INTO book_categories (book_id, categories_id) VALUES (2, 4)
INSERT INTO book_categories (book_id, categories_id) VALUES (2, 5)
INSERT INTO book_categories (book_id, categories_id) VALUES (3, 1)
INSERT INTO book_categories (book_id, categories_id) VALUES (4, 5)
INSERT INTO book_categories (book_id, categories_id) VALUES (5, 5)
