DROP TABLE AuthorProduct;
DROP TABLE PurchaseHistory;
DROP TABLE Authors;
DROP TABLE Products;
DROP TABLE Users;

CREATE TABLE IF NOT EXISTS Authors (
	author_id BIGSERIAL PRIMARY KEY NOT NULL,
	author_name VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS Products (
	product_id BIGSERIAL PRIMARY KEY NOT NULL,
	product_type VARCHAR(50) NOT NULL,
	title VARCHAR(255) NOT NULL,
	purchase_price DECIMAL(10, 2) NOT NULL,
	markup DECIMAL(5, 2) NOT NULL DEFAULT 0.07,
	quantity INT
);

CREATE TABLE IF NOT EXISTS Users (
	user_id BIGSERIAL PRIMARY KEY NOT NULL,
	user_name VARCHAR(255) NOT NULL,
	discount DECIMAL(3, 2) NOT NULL DEFAULT 0.00 CHECK (discount >= 0.00 AND discount <= 0.05)
);

CREATE TABLE IF NOT EXISTS PurchaseHistory (
	purchase_id BIGSERIAL PRIMARY KEY NOT NULL,
	user_id INT,
	product_id INT,
	quantity INT NOT NULL,
	purchase_date DATE NOT NULL,
	total_cost DECIMAL(5, 2) NOT NULL DEFAULT 0.00,
	FOREIGN KEY (user_id) REFERENCES Users(user_id),
	FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE IF NOT EXISTS AuthorProduct (
	author_id INT,
	product_id INT,
	PRIMARY KEY (author_id, product_id),
	FOREIGN KEY (author_id) REFERENCES Authors(author_id),
	FOREIGN KEY (product_id) REFERENCES Products(product_id)
);