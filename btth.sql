create database library_management;
use library_management;
create table Reader(
    reader_id int auto_increment primary key,
    reader_name varchar(100) not null,
    phone varchar(15) unique,
    register_date date default (current_date)
);
create table Book(
	book_id int primary key,
    book_title varchar(150) not null,
    author varchar(100),
    publish_year int check(publish_year>=1900)
);
create table Borrow(
	reader_id int,
    book_id int,
	borrow_date date default(current_date),
    return_date date
);

alter table Reader
add email varchar(100) unique;
alter table Book
modify author varchar(150);
alter table Borrow
add constraint chk_return_date
check (return_date is null or return_date >= borrow_date);


insert into Reader(reader_id, reader_name, phone, email, register_date) value
('1','Nguyễn Văn An', '0901234567', 'an.nguyen@gmail.com','2024-09-01'),
('2','Trần Thị Bình', '0912345678', 'binh.tran@gmail.com','2024-09-05'),
('3','Lê Minh Châu', '092345679', 'chau.le@gmail.com','2024-09-10');

insert into Book(book_id, book_title, author, publish_year) value
('101','Lập trình C căn bản', 'Nguyễn Văn A', '2018'),
('102','Cơ sở dữ liệu', 'Trần Thị B', '2020'),
('103','Lập trình Java', 'Lê Minh C', '2019'),
('104','Hệ quản trị MySQ:', 'Phạm Văn D', '2021');

INSERT INTO Borrow(reader_id, book_id, borrow_date, return_date) VALUES
(1, 101, '2024-09-15', NULL),
(1, 102, '2024-09-15', '2024-09-25'),
(2, 103, '2024-09-18', NULL);

UPDATE Borrow
SET return_date = '2024-10-01'
WHERE reader_id = 1;
