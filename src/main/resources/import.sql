INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Harry Potter and the Chamber of Secrets', 'https://m.media-amazon.com/images/I/91OINeHnJGL._AC_UF1000,1000_QL80_.jpg', 'The second installment in the Harry Potter series.', 'Mondadori', 2000, 1000000, 19.99, 4);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Dune', 'https://m.media-amazon.com/images/I/71dwfOuYLCL._AC_UF1000,1000_QL80_.jpg', 'A science fiction novel set in a desert world.', 'Feltrinelli', 2000, 750000, 24.99, 4);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('The Great Gatsby', 'https://m.media-amazon.com/images/I/71FTb9X6wsL._AC_UF1000,1000_QL80_.jpg', 'A classic novel set in the Roaring Twenties.', 'Flaccovio', 2000, 500000, 15.99, 3);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('1984', 'https://www.einaudi.it/content/uploads/2021/01/978880624818HIG.JPG', 'George Orwell''s dystopian masterpiece.', 'Mondadori', 2000, 800000, 20.00, 3);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('To Kill a Mockingbird', 'https://m.media-amazon.com/images/I/81NeMmw4RQL._SL1500_.jpg', 'A novel of racism and injustice.', 'Feltrinelli', 2000, 4, 18.50, 2);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('The Lord of the Rings', 'https://www.ibs.it/images/9780618640157_0_424_0_75.jpg', 'J.R.R. Tolkien''s epic fantasy trilogy.', 'Mondadori', 2000, 1200000, 25.99, 5);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Pride and Prejudice', 'https://www.ibs.it/images/9781783708277_0_424_0_75.jpg', 'Jane Austen''s classic romance novel.', 'Mondadori', 2000, 203, 14.99, 4);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Moby Dick', 'https://www.ibs.it/images/9788807900761_0_536_0_75.jpg', 'Herman Melville''s tale of the white whale.', 'Feltrinelli', 2000, 100, 17.99, 3);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Brave New World', 'https://m.media-amazon.com/images/I/71aDrgLp9CL._AC_UF1000,1000_QL80_.jpg', 'Aldous Huxley''s vision of a future dystopia.', 'La Terza', 2000, 700000, 19.50, 4);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('The Catcher in the Rye', 'https://m.media-amazon.com/images/I/91HPG31dTwL._AC_UF1000,1000_QL80_.jpg', 'J.D. Salinger''s novel of teenage angst.', 'Mondadori', 2000, 550000, 18.99, 3);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('War and Peace', 'https://cdn.kobo.com/book-images/6faafc7b-cec8-4c6d-9b3d-42aeba8fc09a/1200/1200/False/war-and-peace-166.jpg', 'Leo Tolstoy''s epic tale of Russia during the Napoleonic Wars.', 'Mondadori', 2000, 300000, 27.99, 2);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('The Odyssey', 'https://m.media-amazon.com/images/I/915u1KhUyWL._AC_UF1000,1000_QL80_.jpg', 'Homer''s ancient Greek epic poem.', 'La Terza', 2005, 9, 16.99, 3);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Crime and Punishment', 'https://m.media-amazon.com/images/I/61kIYOt3hIL._AC_UF1000,1000_QL80_.jpg', 'Fyodor Dostoevsky''s exploration of morality and redemption.', 'Feltrinelli', 1800, 500000, 19.99, 4);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('The Brothers Karamazov', 'https://m.media-amazon.com/images/I/71OZJsgZzQL._AC_UF1000,1000_QL80_.jpg', 'Dostoevsky''s philosophical novel on faith, doubt, and morality.', 'Mondadori', 2007, 480000, 21.99, 3);
INSERT INTO book (name, url_photo, description, publisher, date_of_publishing, copies, price, sold_copies) VALUES('Anna Karenina', 'https://www.einaudi.it/content/uploads/2017/04/978880623387HIG.JPG', 'Tolstoy''s novel of love and society in Tsarist Russia.', 'Mondadori', 1997, 520000, 20.50, 4);
INSERT INTO category (name) VALUES('Narrativa');
INSERT INTO category (name) VALUES('Classici');
INSERT INTO category (name) VALUES('Bambini');
INSERT INTO category (name) VALUES('Informatica');
INSERT INTO category (name) VALUES('Fantasy');
INSERT INTO category (name) VALUES('Gialli e Thriller');
INSERT INTO category (name) VALUES('Horror');
INSERT INTO category (name) VALUES('Manga e Fumetti');
INSERT INTO category (name) VALUES('Biografie');
INSERT INTO category (name) VALUES('Scienza e Natura');
INSERT INTO category (name) VALUES('Viaggi');
INSERT INTO category (name) VALUES('Poesia');
INSERT INTO category (name) VALUES('Spiritualità');
INSERT INTO category (name) VALUES('Saggistica');
INSERT INTO category (name) VALUES('Arte e Fotografia');
INSERT INTO category (name) VALUES('Cucina');
INSERT INTO category (name) VALUES('Sport');
INSERT INTO category (name) VALUES('Musica e Spettacolo');
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
INSERT INTO book_categories (books_id, categories_id) VALUES (1, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (2, 1);
INSERT INTO book_categories (books_id, categories_id) VALUES (2, 4);
INSERT INTO book_categories (books_id, categories_id) VALUES (2, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (3, 1);
INSERT INTO book_categories (books_id, categories_id) VALUES (4, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (5, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (6, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (7, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (8, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (9, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (10, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (11, 5);
INSERT INTO book_categories (books_id, categories_id) VALUES (12, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (13, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (14, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (15, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (16, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (17, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (18, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (19, 2);
INSERT INTO book_categories (books_id, categories_id) VALUES (20, 2);
INSERT INTO restocking (date_of_stock, bulk_price, supplier_name, supplied_copies) VALUES ('2023-10-06', 1500.00, 'Fornitore Test', 200);