import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de ecuaciones: ");
        int n = scanner.nextInt();

        double[][] matriz = new double[n][n + 1];

        System.out.println("Ingrese los coeficientes de las ecuaciones:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print("Matriz[" + (i) + "][" + (j) + "]: ");
                matriz[i][j] = scanner.nextDouble();
            }
        }

        // Resolución mediante eliminación gaussiana
        for (int k = 0; k < n; k++) {
            for (int i = k + 1; i < n; i++) {
                double factor = matriz[i][k] / matriz[k][k];


                for (int j = k; j < n + 1; j++) {
                    matriz[i][j] -= factor * matriz[k][j];
                }
            }
        }

        // Sustitución hacia atrás para encontrar las soluciones
        double[] solucion = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            solucion[i] = matriz[i][n];

            for (int j = i + 1; j < n; j++) {
                solucion[i] -= matriz[i][j] * solucion[j];
            }
            solucion[i] /= matriz[i][i];
        }

        // Imprimir las soluciones
        System.out.println("\nLas soluciones son:");


        
        for (int i = 0; i < n; i++) {

            System.out.println("x" + (i + 1) + " = " + solucion[i]);
        }
    }
}
