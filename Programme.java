import java.util.Scanner;

public class Programme {

	public static void main(String[] args) {
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Quel exercice ? Saisissez :");
			System.out.println(" 1. Pour la règle graduée");
			System.out.println(" 2. Pour le calcul de puissance");
			System.out.println(" 3. Pour le test de primalité d’un nombre");
			System.out.println(" 4. Pour l’affichage des tables de multiplications");
			System.out.println(" 5. Pour l’affichage de la table de multiplication 2");
			System.out.println(" 6. Pour la recherche dans un tableau");
			System.out.println(" 7. Pour le calcul d’un élément de la suite de Fibonacci");
			int choix = scan.nextInt();
			switch (choix) {
			case 1:
				System.out.println("Quelle longueur ?");
				int longueur = scan.nextInt();
				System.out.println("Quelle graduation ?");
				int graduation = scan.nextInt();
				System.out.println(regle(longueur, graduation));
				break;
			case 2:
				System.out.println("Quel nombre ?");
				int nombre = scan.nextInt();
				System.out.println("Quel exposant ?");
				int exposant = scan.nextInt();
				System.out.println(puissance(nombre, exposant));
				break;
			case 3:
				System.out.println("Quel nombre ?");
				int nombrep = scan.nextInt();
				System.out.println(premier(nombrep));
				break;
			case 4:
				table1();
				break;
			case 5:
				System.out.println("Quel table ?");
				int nbtable = scan.nextInt();
				System.out.println("Jusqu'à quel nombre ?");
				int nbmax = scan.nextInt();
				calculerTable(nbtable, nbmax);
				break;
			case 6:
				int[] tab1 = { 1, 2, 3, 4, 5 };
				int[] tab2 = { 1, 2, 3, 4, 5 };
				int[] tab3 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
				int[] tab4 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
				System.out.println("Tab1 :");
				System.out.println(recherche(55, tab1));
				System.out.println("Tab2 :");
				System.out.println(recherche(5, tab2));
				System.out.println("Tab3 :");
				System.out.println(recherche(9, tab3));
				System.out.println("Tab4 :");
				System.out.println(recherche(5, tab4));
				break;
			case 7:
				System.out.println("Jusqu'à quel élément ?");
				int itera = scan.nextInt();
				fibonacci(itera);
			default:
				System.out.println("Choix non reconnu.");
				scan.close();
			}
		}
	}

	public static String regle(int longueur, int graduation) {
		String res = "";
		for (int i = 1; i <= longueur; i++) {
			res += "-";
			if (i % graduation == 0) {
				res += "|";
			}
		}
		return res;
	}

	/**
	 * Cette fonction calcule valeur puissance exposant. Renvoie un résultat double
	 * exposant doit être entier.
	 */
	public static double puissance(double valeur, int exposant) {
		double res = valeur;
		double val = valeur;
		int exp = exposant;
		if (exposant < 0) {
			exp = -exposant;
			val = 1 / valeur;
			res = 1 / valeur;
		}
		for (int i = 1; i < exp; i++) {
			res *= val;
		}
		return res;
	}

	/**
	 * Cette fonction détermine si number est premier. Renvoie true si c'est le cas,
	 * false sinon.
	 */
	public static boolean premier(int number) {
		double limite = Math.sqrt(number);
		if (number % 2 == 0 || number == 1) {
			return false;
		}
		for (int i = 3; i <= limite; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void table1() {
		for (int i = 0; i <= 10; i++) {
			for (int j = 0; j <= 10; j++) {
				int calc = i * j;
				System.out.print(calc);
				System.out.print("  ");
				if (calc < 10) {
					System.out.print(" ");
				}
			}
			System.out.print("\n");
		}
	}

	/**
	 * Renvoie un tableau conte-nant la table de multiplication du nombre nb de 0
	 * jusqu’au nombre max.
	 * 
	 */
	public static int[] calculerTable(int nb, int max) {
		int[] res = new int[max + 1];
		for (int i = 0; i <= max; i++) {
			res[i] = nb * i;
			System.out.print(res[i] + " ");
		}
		return res;
	}

	/**
	 * Recherche la valeur val dans le tableau tab et renvoie sa position dans le
	 * tableau, ou -1 si la valeur n’est pas présente dans le tableau.
	 * 
	 * @param val
	 * @param tab
	 * @return
	 */
	public static int recherche(int val, int[] tab) {
		for (int i = 0; i < tab.length; i++) {
			if (tab[i] == val) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Cette fonction calcule les n premiers termes de la suite de Fibonacci.
	 * 
	 * @param n
	 * @return
	 */
	public static int[] fibonacci(int n) {
		int[] res = new int[n];
		res[0] = 0;
		System.out.println(0);
		res[1] = 1;
		System.out.println(1);
		for (int i = 2; i < n; i++) {
			res[i] = res[i - 1] + res[i - 2];
			System.out.println(res[i]);
		}
		return res;
	}
}
