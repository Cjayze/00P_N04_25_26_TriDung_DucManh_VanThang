public class testHangHoa {

    public static void main(String[] args) {
        // gọi test() trong main để chạy được
        test();
    }

    public static void test() {
        HangHoa testHH = new HangHoa();

        testHH.tenHangHoa = "Dienthoai iphone";
        testHH.maHangHoa = "ma01";

        // in tên hàng hóa với mã tương ứng
        System.out.println(testHH.layTenHangHoa("ma01"));`
    }
}
