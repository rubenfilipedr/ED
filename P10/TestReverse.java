import java.util.Arrays;

public class TestReverse {

   // Inverter array v entre posicoes start e end
   static void reverse(int v[], int start, int end) {
      if (start>=end) return;     // Caso base: array de tamanho < 2
      int tmp = v[start];         // Trocar primeiro com ultimo
      v[start] = v[end];
      v[end] = tmp;
      reverse(v, start+1, end-1); // Chamada recursiva para o resto
   }

   // -----------------------------------------------------------

   static boolean capicua(int v[], int start, int end) {
     if (start>=end) { return true; }
     boolean StartEnd = (v[start] == v[end]);
     return (StartEnd && capicua(v, start+1, end-1));
   }

   // -----------------------------------------------------------

   public static void main(String[] args) {
      int v1[] = {2,4,6,8,10}; // Inicializacao de array

      System.out.println("Antes  do reverse: " + Arrays.toString(v1));
      reverse(v1, 0, v1.length-1);
      System.out.println("Depois do reverse: " + Arrays.toString(v1));
      System.out.println("Capicua v1[]? " + capicua(v1, 0, v1.length-1));

      int v2[] = {2,4,5,4,2}; // Inicializacao de array

      System.out.println("Antes  do reverse: " + Arrays.toString(v2));
      reverse(v2, 0, v2.length-1);
      System.out.println("Depois do reverse: " + Arrays.toString(v2));
      System.out.println("Capicua v2[]? " + capicua(v2, 0, v2.length-1));
   }
}
