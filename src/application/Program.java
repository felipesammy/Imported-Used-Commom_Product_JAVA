package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> list = new ArrayList<>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for(int i =1; i<=n; i++) {
			
			System.out.println("Product #" + i + " data:");
			
			System.out.print("Common, used or imported (c/u/i)? ");
			char c = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if(c == 'i') {
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
			
			else if(c == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				sc.nextLine();
				String dat = sc.nextLine();
				Date manufacturedDate = sdf.parse(dat);
				list.add(new UsedProduct(name, price, manufacturedDate));
			}
			else if(c == 'c') {
				list.add(new Product(name, price));
			}
		}
		
		System.out.println("\nPRICE TAGS:");
		
		for(Product c: list) {
			System.out.println(c.priceTag());
		}
		sc.close();

	}

}
