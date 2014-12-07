import java.io.*;
import java.util.*;

public class DataAccessObject{

	DataAccessObject() {

	}

	public static void main(String[] args) throws FileNotFoundException{
		
		int x;
		Scanner scan = new Scanner(System.in);

		System.out.println("\n\n-----DATA ACCESS OBJECT-----\n[1] Read File Only\n[2] Write File Only\n[3] Read and Write File\n[4] Exit\n\n");
		System.out.print("Choice: ");
		x = scan.nextInt();

		if (x == 1) {
			System.out.println("\nREAD FROM A FILE:\n-----------------\n");
			readFile();
		}
		else if (x == 2) {
			System.out.println("\nWRITE TO A FILE:\n-----------------\n");
			writeFile();
		}
		else if (x == 3) {
			System.out.println("\nWRITE TO A FILE:\n-----------------\n");
			writeFile();
			System.out.println();
			System.out.println("\nREAD FROM A FILE:\n-----------------\n");
			readFile();
		}
		else if (x == 4) {
			System.exit(0);
		}
		else {
			System.out.println("Invalid choice!");
		}
	}


	public static void writeFile() {
		Scanner scan = new Scanner(System.in);
		String name = "", description = "", date = "", stime = "", etime = "", ffile = "", ans1 = "", ans2 = "";
		File file = new File("database.txt");
		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile(),true));

			do {
				System.out.print("Name: ");
				name = scan.nextLine();
				bw.write(name);
				bw.write("\n");

				System.out.print("Description: ");
				description = scan.nextLine();
				bw.write(description);
				bw.write("\n");

				System.out.print("Date: ");
				date = scan.nextLine();
				bw.write(date);
				bw.write("\n");

				System.out.print("Start Time: ");
				stime = scan.nextLine();
				bw.write(stime + " - ");
				System.out.print("End Time: ");
				etime = scan.nextLine();
				bw.write(etime+ "\n");

				System.out.print("Associate Files? (y/n): ");
				ans1 = scan.nextLine();
				while(ans1.equals("y")){
					System.out.print("Input File URL: ");
					ffile = scan.nextLine();
					bw.write(ffile + "\n");
					ffile = "";
					System.out.print("Associate Files? (y/n): ");
					ans1 = scan.nextLine();
				}
				
				System.out.print("Input pa more? (y/n): ");
				ans2 = scan.nextLine();
				bw.write("\n");
			}while(ans2.equals("y"));
			
			bw.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		};
	}

	public static void readFile() throws FileNotFoundException{
		File file = new File("database.txt");
		String current="";
		FileReader fr = new FileReader(file.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fr);

		try {
			if (!file.exists()) {
				file.createNewFile();
			}
			while (((current = br.readLine()) != null)) {
				System.out.println(current);
			}
		}
		catch(Exception e){

		}finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (Exception e) {}
		}
	}
}
