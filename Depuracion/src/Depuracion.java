import java.util.Scanner;


public class Depuracion {

	static final String[] palabrasIntroducidas = new String[5];
	static String limite20 = new String("");
	static char[] caracteresRestantes = new char[100];
	static int j = 0;
	
	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		Scanner leer = new Scanner(System.in);
		char[] caracteres = new char[20];	
		
		introducir_5_palabras(leer);
						
		introducir_oracion_20_caracteres(leer);
		
		int i = 0;
		
		try {
			
			for(i=0;i<limite20.length()-1;i++)
				caracteres[i] = limite20.charAt(i);
			
		}catch(StringIndexOutOfBoundsException e) {
			
			escribir_en_caracteres_restantes(i);
						
		}catch(ArrayIndexOutOfBoundsException e) {
			
			escribir_en_caracteres_restantes(i);
			
		}
				
		validarResto(j);
							
	}
	
	public static void introducir_5_palabras(Scanner leer) {
		
		for(int a=0;a<5;a++) {
			System.out.println("Por favor, escribe una palabra que se te ocurra: ");
			palabrasIntroducidas[a] = leer.nextLine();
		}
				
	}
	
	public static void introducir_oracion_20_caracteres(Scanner leer){
		
		System.out.println("Por favor, escribe una oración de 20 caracteres o más:");
		limite20 = leer.nextLine();
		
		while(limite20.length()<20) {
			System.out.println("Por favor, escribe 20 caracteres o más: ");
			limite20 = leer.nextLine();			
		}

	}
	
	public static void escribir_en_caracteres_restantes(int i){
		
		for(j=0;j<limite20.length()-21;j++)
			caracteresRestantes[j] = limite20.charAt(i + j);

	}
	
	public static void validarResto(int j) {
		
        String palabra = new String("");
		
		for(int x=0;x<j-1;x++) {
			palabra = comprobarPalabras(caracteresRestantes[x]);
			System.out.println(palabra);
		}
		
	}	
	
	public static String comprobarPalabras(char caracter) {
		
		for(int y=0;y<palabrasIntroducidas.length-1;y++)
			for(int z=0;z<palabrasIntroducidas[y].length()-1;z++)
			  if(caracter==palabrasIntroducidas[y].charAt(z))
				  return palabrasIntroducidas[y];
		return new String("Lo siento, no se ha encontrado palabra coincidente.");
		
	}

}
