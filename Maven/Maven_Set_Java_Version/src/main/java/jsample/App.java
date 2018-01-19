package jsample;

public class App {
	public static void main(String[] args) {
		String str = "maven";
		// 'Using string in switch statement' feature is available from Java 1.7
		switch (str) {
		case "hello":
			System.out.println("Hello World!");
		case "maven":
			System.out.println("Hello Maven!");
		}
	}
}
