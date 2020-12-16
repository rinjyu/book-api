# Book Api Service

내가 읽은 도서, 읽고 있는 중인 도서, 읽을 예정인 도서에 대한 관리용 도서 서비스로, Book Web 서비스에서 사용할 수 있는 다양한 I/F를 제공합니다. 


### Specification

---
- zulu jdk 11.0.2
- maven 3.6.3
- Spring Boot 2.3.7.RELEASE
- Spring Cloud Hoxton.SR9
- Embedded Tomcat  
- H2DB
- Mybatis  
- IntelliJ IDEA Ultimate
- Git


### Database Schema

---
#### MEMBER

|column|data type|null able|default|pk|description|
|------|---|---|------|---|---|
|mem_id|varchar(15)|not null| | |아이디|
|mem_nm|varchar(15)|not null| | |이름|
|mem_pwd|varchar(250)|not null| | |비밀번호|
|mem_email|varchar(100)|not null| | |이메일|
|reg_dts|datetime|not null|current_timestamp| |등록일자|
|reg_id|varchar(15)|not null| | |등록자|
|mod_dts|datetime|not null|current_timestamp| |수정일자|
|mod_id|varchar(15)|not null| | |수정자|

---

#### BOOK

|column|data type|null able|default|pk|description|
|------|---|---|------|---|---|
|book_no|int|not null| |1|번호|
|book_nm|varchar(50)|not null| | |도서명|
|book_price|int|not null| | |가격|
|book_author|varchar(50)|not null| | |저자|
|book_publisher|varchar(100)|not null| | |출판사|
|book_desc|varchar(250)|not null| | |설명|
|book_img_desc|varchar(250)|null| | |이미지 경로|
|reg_dts|datetime|not null|current_timestamp| |등록일자|
|reg_id|varchar(15)|not null| | |등록자|
|mod_dts|datetime|not null|current_timestamp| |수정일자|
|reg_id|varchar(15)|not null| | |수정자|


### Browser Support

---
- Chrome 87.0.4280.88(공식 빌드) (64비트)
- Microsoft Edge
- Whale Version 2.8.108.15 (64-bit)