import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.BufferedReader;

/**
 * Valida la contraseña que se introduce mediante stdin.
 * Imprime "Senha valida" cuando el tamaño de la contraseña esta entre 6 y 32
 * caracteres, esta contiene al menos una minuscula, una mayuscula y un 
 * número. La contraseña no debe de contener espacios, letras acentuadas ni 
 * signos de puntuación.
 * */
public class Main {
 
    public static void main(String[] args) throws IOException {
	passwordValidator(); 
    }

    /* Recibe mediante stdin la entrada del usuario/juez.
     * Imprime "Senha valida." si la linea que se le ha pasado
     * es valida. Sera valida si contiene unicamente letras del
     * alfabeto ingles y numeros arabigos. En otro caso se imprime
     * "Senha invalida".
     * El algoritmo tiene complejidad en tiempo O(n^2).
     * */
    private static void passwordValidator() throws IOException {
	InputStreamReader ips = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(ips);
	String linea = null;
	while((linea = br.readLine()) != null) {
	    if (linea.length() > 32 || linea.length() < 6) {
		System.out.println("Senha invalida.");
                continue;
	    }
	    
	    if (!contieneNumerosDigitos(linea)) {
		System.out.println("Senha invalida.");
		continue;
	    }
	    
	    if (esValida(linea))
		System.out.println("Senha valida.");
	    else
		System.out.println("Senha invalida.");
	}
    }

    /* Regresa true si el string contiene al menos una minuscula,
     * una letra mayuscula y un numero. Regresa false en caso contrario.
     * El string debe contener letras sin acentuar ni signos de
     * puntuacion.
     * @param linea el string a analizar.
     * @return true si el string contiene al menos una minuscula, una
     * mayuscula y un numero arabigo.
     */
    private static boolean esValida(String linea) {
	boolean hasLowerCase = false;
	boolean hasUpperCase = false;
	boolean hasDigit = false;
	for (int i = 0; i < linea.length(); i++) {
	    char ch = linea.charAt(i);
	    if (isUpper(ch))
		hasUpperCase = true;
	    else if (isLower(ch))
		hasLowerCase = true;
	    else if (isNumber(ch))
		hasDigit = true;
	    if (hasDigit && hasLowerCase && hasUpperCase)
		return true;
	}
	return false;
    }

    /* Regresa true si el string contiene numeros y letras no
     * acentuadas ni signos de puntuacion.
     */
    private static boolean contieneNumerosDigitos(String linea) {
	for (int i = 0; i < linea.length(); i++) {
	    char ch = linea.charAt(i);		
	    if (!isLower(ch) && !isUpper(ch) && !isNumber(ch))
		return false;
	}
	return true;	
    }
    
    /* Regresa true si un caracter es minuscula, falso en otro caso. 
     * Cuenta falso si es una letra acentuada o signo de puntuacion.
     * @param ch el caracter a validar.
     * @return true si el caracter es una minuscula, false en caso contrario.
     */
    private static boolean isLower(char ch) {
	return (ch >= 'a' && ch <= 'z');
    }

    /* Regresa true si un caracter es mayuscula, falso en otro caso 
     * Cuenta falso si es una letra acentuada o signo de puntuacion.
     */
    private static boolean isUpper(char ch) {
	return (ch >= 'A' && ch <= 'Z');
    }

    /* Regresa true si un caracter es un numero arabigo,
     * falso en otro caso. Cuenta falso si es una letra acentuada o 
     * signo de puntuacion.
     * @param ch el caracter a verificar.
     * @return true si el caracter es un digito, false en caso
     * contrario.
     */
    private static boolean isNumber(char ch) {
	return (ch >= '0' && ch <= '9');
    }    
}
