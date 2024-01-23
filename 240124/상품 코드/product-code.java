import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc =new Scanner(System.in);
        Product p = new Product("codetree",50);
        
        System.out.println("product " +p.productCode +" is "+ p.productName);
        
        p.productName = sc.next();
        p.productCode = sc.nextInt();
        System.out.println("product " +p.productCode +" is "+ p.productName);
    }
}

class Product{
    String productName; 
    int productCode;
    public Product(String productName, int productCode){
        this.productName = productName;
        this.productCode = productCode;
    }
}