use ex03_mysql;

/*tạo bảng*/
create table kho(
	id int auto_increment not null,
    ma_kho varchar(20) not null,
    ten varchar(20) not null,
    dia_diem varchar(50) not null,
    ngay_tao  datetime default current_timestamp,
    ngay_sua  datetime default current_timestamp,
     primary key(id)
);

create table loai_danh_muc(
	id int auto_increment not null,
    ma_loai_danh_muc varchar(20) not null,
    ten varchar(20) not null,
    mo_ta varchar(20) not null,
    ngay_tao  datetime default current_timestamp,
    ngay_sua  datetime default current_timestamp,
     primary key(id)
);

create table san_pham(
  id int auto_increment not null,
  ma_san_pham varchar(20) not null,
  danh_muc  int not null ,
  kho  int  not null,
  gia decimal not null,
  ten_mota_sp varchar(50) not null,
  duong_dan_anh varchar(255),
  so_luong_sp int(20),
  so_luong_ban int(20),
  ngay_tao  datetime default current_timestamp,
  ngay_sua  datetime default current_timestamp,
   primary key(id),
   foreign key (kho) references kho(id),
   foreign key (danh_muc) references loai_danh_muc(id)
);
use ex03_mysql;
create table tong_sl_sp_kho(
	id int auto_increment not null,
    ma_kho_sp varchar(20) not null,
    sl_sp_kho int(20),
	ngay_thong_ke datetime default current_timestamp,
    primary key(id)
);

/*thêm kho, sản phẩm, loại danh mục*/
insert into  kho (ma_kho,ten,dia_diem) values ('a','Sapo','266 Đội Cấn');

insert into  loai_danh_muc (ma_loai_danh_muc,ten,mo_ta) values ('Apple','Apple','Hãng điện thoại hàng đầu');
insert into  loai_danh_muc (ma_loai_danh_muc,ten,mo_ta) values ('SS','Sam Sung','Hãng điện thoại hàng đầu');

use ex03_mysql;
insert into  san_pham (ma_san_pham,danh_muc,kho,gia,ten_mota_sp,duong_dan_anh,so_luong_sp,so_luong_ban) values ('DT','6','1','20000000','Điện Thoại iphone 13',null,20,12);
insert into  san_pham (ma_san_pham,danh_muc,kho,gia,ten_mota_sp,duong_dan_anh,so_luong_sp,so_luong_ban) values ('DT','7','1','30000000','Điện Thoại Sam Sung Galaxy S20',null,13,10);
insert into  san_pham (ma_san_pham,danh_muc,kho,gia,ten_mota_sp,duong_dan_anh,so_luong_sp,so_luong_ban) values ('DT','8','1','40000000','Sam Sung Galaxy S30',null,13,9);
insert into  san_pham (ma_san_pham,danh_muc,kho,gia,ten_mota_sp,duong_dan_anh,so_luong_sp,so_luong_ban) values ('DT','9','1','50000000','iphone 11',null,15,5);

/*upadate theo id*/
update kho set ma_kho = '', ten ='', dia_diem ='', ngay_sua ='' where id ='';
update loai_danh_muc set ma_loai_danh_muc = '', ten ='', mo_ta ='', ngay_sua ='' where id ='';
update san_pham set ma_san_pham = '', danh_muc ='', kho ='', gia = '', ten_mota_sp ='', duong_dan_anh ='', so_luong_sp ='', so_luong_ban ='', ngay_sua =''  where id ='';

/*xoá theo id*/
delete from kho where id = '';
delete from danh_muc where id = '';
delete from sanp_ham where id = '';

use ex03_mysql;
/*Lọc các sản phẩm có chứa từ 'Điện Thoại' và thuộc loại danh mục có tên là 'Apple'*/
select san_pham.*,loai_danh_muc.ma_loai_danh_muc from san_pham inner join loai_danh_muc on san_pham.danh_muc = loai_danh_muc.id where san_pham.ten_mota_sp like '%Điện Thoại%' and loai_danh_muc.ma_loai_danh_muc ='Apple';

/*đếm số lượng sản phẩm trong mỗi loại danh mục, sắp xếp giảm dần*/
select loai_danh_muc.ma_loai_danh_muc, Sum(so_luong_sp) as tong_so_luong from san_pham inner join loai_danh_muc on san_pham.danh_muc = loai_danh_muc.id group by danh_muc order by sum(so_luong_sp) desc;

/*lấy 10 sản phẩm có số lượng bán nhiều nhất*/
DELIMITER $$
CREATE  PROCEDURE selectTop10()
BEGIN
select san_pham.* from san_pham group by san_pham.id order by san_pham.so_luong_ban desc limit 10;
END;$$



/*xoá loại danh mục sẽ xoá cả sản phẩm của danh mục đó*/
DROP PROCEDURE IF EXISTS delete_danh_muc_by_id ;
DELIMITER $$
CREATE PROCEDURE delete_danh_muc_by_id(IN ma_danh_muc int)
BEGIN
				declare result int;
                
                
                if  not exists (select * from loai_danh_muc where id = ma_danh_muc) then
                -- trả về 0 khi mã danh mục không tồn tại 
				set @result=0 ;
                else 	
						start transaction;
								begin
									DECLARE EXIT HANDLER FOR sqlstate '23000' 
									set @result=1 ;
									-- trả về 1 khi  không xóa được sản phẩm với mã danh mục truyền vào
									delete from san_pham
												where san_pham.danh_muc = ma_danh_muc;    
									-- trả về 2 khi không xóa được danh mục
									set @result=2 ;
									delete from loai_danh_muc 
												where id = ma_danh_muc;
									-- trả về 3 tức là đã xóa thành công
									set @result=3;

									commit;
									end;
					end if;
				select @result;
END; $$


use ex03_mysql;
DROP PROCEDURE IF EXISTS delete_kho_by_id ;
DELIMITER $$
CREATE PROCEDURE delete_kho_by_id(IN ma_kho int)
BEGIN
				declare result int;
                
                
                if  not exists (select * from kho where id = ma_kho) then
                -- trả về 0 khi mã danh mục không tồn tại 
				set @result=0 ;
                else 	
						start transaction;
								begin
									DECLARE EXIT HANDLER FOR sqlstate '23000' 
									set @result=1 ;
									-- trả về 1 khi  không xóa được sản phẩm với mã danh mục truyền vào
									delete from san_pham
												where san_pham.kho = ma_kho;    
									-- trả về 2 khi không xóa được danh mục
									set @result=2 ;
									delete from kho 
												where id = ma_kho;
									-- trả về 3 tức là đã xóa thành công
									set @result=3;

									commit;
									end;
					end if;
				select @result;
END; $$

call delete_kho_by_id(1);
use ex03_mysql;
DELIMITER $$
CREATE PROCEDURE total_sanpham_kho(IN ma_kho1 int)
begin
	select sum(san_pham.so_luong_sp) from kho left join san_pham on kho.id = san_pham.kho where kho.id = ma_kho1 group by kho;
end;$$

call total_sanpham_kho(3);






