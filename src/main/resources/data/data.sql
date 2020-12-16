INSERT INTO BOOK (BOOK_NM, BOOK_PRICE, BOOK_AUTHOR, BOOK_PUBLISHER, BOOK_DESC, BOOK_IMG_PATH, REG_DTS, REG_ID, MOD_DTS, MOD_ID)
VALUES ('인텔리제이 IDEA', 28000, '이마이 마사노부, 야마모토 유스케', '에이콘출판사', '기본 사용법부터 고급 기능까지 마스터하기', '/image/books/intellij-idea.png', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');


INSERT INTO MEMBER(MEM_ID, MEM_NM, MEM_PWD, MEM_EMAIL, REG_DTS, REG_ID, MOD_DTS, MOD_ID)
VALUES('admin','관리자','admin20!#@','admin@test.com', CURRENT_TIMESTAMP, 'admin', CURRENT_TIMESTAMP, 'admin');