NHÓM 6

ỨNG DỤNG QUẢN LÝ CỬA HÀNG DŨNG - MẠNH - THẮNG

 Đây là một ứng dụng quản lý bán hàng được xây dựng bằng ngôn ngữ lập trình Java sử dụng thư viện Java Swing để thiết kế giao diện người dùng và sử dụng cơ sở dữ liệu SQL SERVER.

 Đây là một ứng dụng quản lý bán hàng được xây dựng bằng ngôn ngữ lập trình Java sử dụng thư viện Java Swing để thiết kế giao diện người dùng và sử dụng cơ sở dữ liệu SQL SERVER.




**Các chức năng chính

-Xác thực người dùng

-Đăng ký tài khoản mới

-Đăng nhập hệ thống với phân quyền

-Quản lý người dùng Thêm / sửa / xóa người dùng

-Phân quyền người dùng

-Quản lý nhân viên Thêm / sửa / xóa nhân viên

-Quản lý sản phẩm Thêm / sửa / xóa sản phẩm

-Quản lý loại sản phẩm Thêm / sửa / xóa loại sản phẩm

-Quản lý quyền sử dụng Thêm / sửa / xóa quyền sử dụng classDiagram

class Customer {

int id
String name
String email
String phone
String address
String password
create()
read()
update()
delete() }
class Product {

int id
String name
String description
double price
int quantity
int category_id
create()
read()
update()
delete() }
class Order {

int id
int customer_id
Date order_date
double total_amount
String status
create()
read()
update()
delete() }

-Phân quyền người dùng 

-Quản lý nhân viên Thêm / sửa / xóa nhân viên 

-Quản lý sản phẩm Thêm / sửa / xóa sản phẩm

-Quản lý loại sản phẩm Thêm / sửa / xóa loại sản phẩm 

-Quản lý quyền sử dụng Thêm / sửa / xóa quyền sử dụng
classDiagram

* 
class Customer {
- int id
- String name
- String email
- String phone
- String address
- String password
+ create()
+ read()
+ update()
+ delete()
}

class Product {
- int id
- String name
- String description
- double price
- int quantity
- int category_id
+ create()
+ read()
+ update()
+ delete()
}

class Order {
- int id
- int customer_id
- Date order_date
- double total_amount
- String status
+ create()
+ read()
+ update()
+ delete()
}


