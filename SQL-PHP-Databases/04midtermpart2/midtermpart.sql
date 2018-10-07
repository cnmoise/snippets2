-- Create and populate table

CREATE TABLE Items(
	itemID int NOT NULL PRIMARY KEY AUTO_INCREMENT,
	itemDescription varchar(255) NOT NULL,
	itemDueDate date,
	itemPriority varchar(200) NOT NULL
	);

INSERT INTO Items(itemId, itemDescription, itemDueDate, itemPriority)
VALUES (0, "Create tut", "2018-05-12", "high");
INSERT INTO Items(itemId, itemDescription, itemDueDate, itemPriority)
VALUES (0, "Create screenplay", "2018-05-13", "low");
INSERT INTO Items(itemId, itemDescription, itemDueDate, itemPriority)
VALUES (0, "Feed cat", "2018-05-14", "med")

