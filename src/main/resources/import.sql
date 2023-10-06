INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Harry Potter and the Chamber of Secrets', 'http://example.com/images/harrypotter.jpg', 'The second installment in the Harry Potter series.', 1000000, 19.99, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Dune', 'http://example.com/images/dune.jpg', 'A science fiction novel set in a desert world.', 750000, 24.99, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('The Great Gatsby', 'http://example.com/images/gatsby.jpg', 'A classic novel set in the Roaring Twenties.', 500000, 15.99, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('1984', 'http://example.com/images/1984.jpg', 'George Orwell''s dystopian masterpiece.', 800000, 20.00, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('To Kill a Mockingbird', 'http://example.com/images/mockingbird.jpg', 'A novel of racism and injustice.', 4, 18.50, 2);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('The Lord of the Rings', 'http://example.com/images/lotr.jpg', 'J.R.R. Tolkien''s epic fantasy trilogy.', 1200000, 25.99, 5);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Pride and Prejudice', 'http://example.com/images/pride.jpg', 'Jane Austen''s classic romance novel.', 203, 14.99, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Moby Dick', 'http://example.com/images/mobydick.jpg', 'Herman Melville''s tale of the white whale.', 100, 17.99, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Brave New World', 'http://example.com/images/bravenewworld.jpg', 'Aldous Huxley''s vision of a future dystopia.', 700000, 19.50, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('The Catcher in the Rye', 'http://example.com/images/catcher.jpg', 'J.D. Salinger''s novel of teenage angst.', 550000, 18.99, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('War and Peace', 'http://example.com/images/warandpeace.jpg', 'Leo Tolstoy''s epic tale of Russia during the Napoleonic Wars.', 300000, 27.99, 2);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('The Odyssey', 'http://example.com/images/odyssey.jpg', 'Homer''s ancient Greek epic poem.', 9, 16.99, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Crime and Punishment', 'http://example.com/images/crime.jpg', 'Fyodor Dostoevsky''s exploration of morality and redemption.', 500000, 19.99, 4);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('The Brothers Karamazov', 'http://example.com/images/brothersk.jpg', 'Dostoevsky''s philosophical novel on faith, doubt, and morality.', 480000, 21.99, 3);
INSERT INTO book (name, url_photo, description, copies, price, sold_copies) VALUES('Anna Karenina', 'http://example.com/images/anna.jpg', 'Tolstoy''s novel of love and society in Tsarist Russia.', 520000, 20.50, 4);
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
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 09:00:00', 4, 6);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 10:15:00', 8, 7);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 11:45:00', 6, 8);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 12:30:00', 3, 9);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 14:10:00', 7, 10);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 15:50:00', 5, 11);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 16:20:00', 2, 12);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 18:00:00', 9, 13);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 19:00:00', 10, 14);
INSERT INTO purchase (date_of_purchase, purchase_quantity, book_id) VALUES('2023-10-06 20:15:00', 1, 15);
INSERT INTO book_categories (book_id, categories_id) VALUES (1, 5)
INSERT INTO book_categories (book_id, categories_id) VALUES (2, 1)
INSERT INTO book_categories (book_id, categories_id) VALUES (2, 4)
INSERT INTO book_categories (book_id, categories_id) VALUES (2, 5)
INSERT INTO book_categories (book_id, categories_id) VALUES (3, 1)
INSERT INTO book_categories (book_id, categories_id) VALUES (4, 5)
INSERT INTO book_categories (book_id, categories_id) VALUES (5, 5)
