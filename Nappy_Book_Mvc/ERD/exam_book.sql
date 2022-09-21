SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS exam_book;




/* Create Tables */

CREATE TABLE exam_book
(
	bk_id int NOT NULL AUTO_INCREMENT,
	bk_title varchar(20) NOT NULL,
	bk_summary text,
	bk_price int DEFAULT 0 CHECK(bk_price >=0),
	bk_viewcnt int DEFAULT 0 CHECK(bk_viewcnt >=0),
	bk_regdate datetime DEFAULT now(),
	PRIMARY KEY (bk_id)
);



