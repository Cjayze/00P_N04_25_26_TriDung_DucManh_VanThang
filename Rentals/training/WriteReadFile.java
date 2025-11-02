import java.io.*;
package models;


public class WriteReadFile {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "data.txt";

        try {
    
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("<===Ghi du lieu vao file (nhap dong trong de ket thuc) ===>");

            String line;
            while (true) {
                System.out.print("> ");
                line = br.readLine();
                if (line == null || line.length() == 0) break;
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            System.out.println(" Da ghi du lieu ra file: " + fileName);



            
            FileReader fr = new FileReader(fileName);
            BufferedReader fileReader = new BufferedReader(fr);

            System.out.println("\n<=== Noi dung da duoc doc tu file ===>");
            String content;
            while ((content = fileReader.readLine()) != null) {
                System.out.println(content);
            }

            fileReader.close();
            System.out.println(" Da doc file thanh cong!");

        } catch (IOException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
}
