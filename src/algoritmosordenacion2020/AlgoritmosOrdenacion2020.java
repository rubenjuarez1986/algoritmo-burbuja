package algoritmosordenacion2020;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Ruben
 */
public class AlgoritmosOrdenacion2020 {

    int[] lista1 = {13, 27, 455, 621, 23, 1, 15};
    int[] arrayParaBurbuja;
    int[] arrayParaInsercion;
    int[] arrayParaShell;

    public void ordenacionBurbuja(int[] numeros) {
        //el metodo recibe un array de números y lo ordenarà mediante el algoritmo de la burbuja
        for (int j = 0; j < numeros.length;
                j++) {
            for (int i = 0; i < numeros.length - 1; i++) {
                if (numeros[i] > numeros[i + 1]) {
                    // si se cumple intercambio los valores de i e i+1
                    int aux = numeros[i + 1];
                    numeros[i + 1] = numeros[i];
                    numeros[i] = aux;
                }
            }
        }
    }

    public void oedenacionInsercion(int[] numeros) {//chequear que arranque tambien con 0 elementos o 1 elemento
        for (int i = 2; i < numeros.length; i++) {
            int aux = numeros[i];
            int j = 0;
            for (j = i - 1; j >= 0 && numeros[j] > aux; j--) {

                numeros[j + 1] = numeros[j];
            }
            numeros[j + 1] = aux;
        }
    }

    public void shellSort(int[] numeros) {
        int salto, aux;
        boolean intercambio;
        for (salto = numeros.length / 2; salto != 0; salto /= 2) {
            intercambio = true;
            while (intercambio) {
                intercambio = false;
                for (int i = salto; i < numeros.length; i += salto) {
                    if (numeros[i - salto] > numeros[i]) {
                        //si los dos numeros estan desordenados entre si los intercambio y lo indico
                        aux = numeros[i];
                        numeros[i] = numeros[i - salto];
                        numeros[i - salto] = aux;
                        intercambio = true;
                    }
                }
            }
        }

    }

    //crea un array de tantos numeros aleatorios como le pasemos en la variable dimension
    public int[] generaNumerosRandom(int dimension) {
        int[] numeros = new int[dimension];
        Random r = new Random();
        for (int i = 0; i < dimension; i++) {
            numeros[i] = r.nextInt();

        }
        return numeros;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlgoritmosOrdenacion2020 ordenacion = new AlgoritmosOrdenacion2020();
        System.out.println(Arrays.toString(ordenacion.lista1));

        ordenacion.ordenacionBurbuja(ordenacion.lista1);
        System.out.println(Arrays.toString(ordenacion.lista1));

        /////empiezo las pruebas de rendimiento de los disintos algoritmos
        int rangoPrueba = 10000;//numero de datos con los que probamos el algoritmo
        int[] numeros = ordenacion.generaNumerosRandom(rangoPrueba);
        ordenacion.arrayParaBurbuja = new int[rangoPrueba];//inicializamos el array
        ordenacion.arrayParaInsercion = new int[rangoPrueba];//inicializamos el array
         ordenacion.arrayParaShell = new int[rangoPrueba];//inicializamos el array
        //ahora rellenamos con el bucle for
        for (int i = 0; i < rangoPrueba; i++) {
            ordenacion.arrayParaBurbuja[i] = numeros[i];
            ordenacion.arrayParaInsercion[i] = numeros[i];
            ordenacion.arrayParaShell[i]= numeros [i];
            //aqui ya tengo dos copias exactas del array de datos aleatorio
        }
        System.out.println("Empieza la burbuja:(vete a por un cafe)");
        long tiempoInicio = System.currentTimeMillis();
        ordenacion.ordenacionBurbuja(ordenacion.arrayParaBurbuja);
        long tiempoFinal = System.currentTimeMillis();
        System.out.println("la burbuja ha tardado: " + (tiempoFinal - tiempoInicio));
        ////////////////////////////////////////////////////////////////////////
        System.out.println("Empieza Insercion Directa");
        tiempoInicio = System.currentTimeMillis();

        ordenacion.oedenacionInsercion(ordenacion.arrayParaInsercion);

        tiempoFinal = System.currentTimeMillis();
        System.out.println("la insercion directa ha tardado: " + (tiempoFinal - tiempoInicio));
        ///////////////////////////////////////////////////////////////////////
         System.out.println("Empieza Shell Short");
        tiempoInicio = System.currentTimeMillis();

        ordenacion.shellSort(ordenacion.arrayParaShell);

        tiempoFinal = System.currentTimeMillis();
        System.out.println("shell sort ha tardado: " + (tiempoFinal - tiempoInicio));
    }

}
