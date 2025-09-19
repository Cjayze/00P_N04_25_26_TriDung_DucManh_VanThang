Project: web bán hàng
Thành viên:
1.	Nguyễn Văn Thắng
ID:23010234
2.	Nguyễn Đức Mạnh
ID:23010024
3.	Dương Tri Dung
ID:23010005

Dự án: Xây dựng ứng dụng Quản Lý Bán Hàng
Yêu cầu:
• Giao diện Java Spring Boot.
1. Yêu cầu chức năng
1.	Quản lý người dùng (User/Customer)
o	Thêm, sửa, xóa người dùng.
o	Liệt kê danh sách người dùng.
o	Tìm kiếm và lọc sản phẩm theo thông tin người dùng.
2.	Quản lý nhân viên (Employee)
o	Thêm, sửa, xóa nhân viên.
o	Liệt kê danh sách nhân viên.
o	Gán người dùng cho nhân viên (mỗi nhân viên có thể quản lý nhiều khách hàng).
3.	Quản lý sản phẩm (Product)
o	Thêm, sửa, xóa sản phẩm.
o	Liệt kê sản phẩm.
o	Lọc sản phẩm theo loại, giá hoặc theo khách hàng đã mua.
4.	Lưu trữ dữ liệu
o	Dữ liệu được lưu dưới dạng file nhị phân.
o	Cần có các lớp đối tượng chính: Người dùng, Nhân viên, Sản phẩm.
o	Có chức năng đọc/ghi dữ liệu từ file.
5.	Quản lý dữ liệu trong bộ nhớ
o	Sử dụng Java Collection Framework như ArrayList, LinkedList, Map…
o	Khi thêm/xóa/sửa dữ liệu cần đồng bộ giữa bộ nhớ và file.
6.	Chức năng mở rộng (tùy chọn)
o	Quản lý đơn hàng, hóa đơn.
o	Thống kê doanh thu.
o	Phân quyền tài khoản: admin, nhân viên, khách hàng.

<<<<<<< HEAD

=======
>>>>>>> 71e1370a75f1dd42d2ccb6eae9aa9ca67a1453e7
classDiagram
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

<<<<<<< HEAD
    class Product {
=======
   class Product {
>>>>>>> 71e1370a75f1dd42d2ccb6eae9aa9ca67a1453e7
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
<<<<<<< HEAD
      - double total_amountgit status
=======
      - double total_amount
>>>>>>> 71e1370a75f1dd42d2ccb6eae9aa9ca67a1453e7
      - String status
      + create()
      + read()
      + update()
      + delete()
    }

<<<<<<< HEAD
    Customer "1" --> "*" Order
    Order "*" --> "*" Product
=======
>>>>>>> 71e1370a75f1dd42d2ccb6eae9aa9ca67a1453e7




