import java.util.Arrays;

// Testando o metodo Arrays.sort()
class TestSort {
   public static void main(String[] args) {
      // Inicializar array v
      String[] v = {"ana","carlos","adalberto","maria","luis","filipa"};

      // Ordenar array v
      Arrays.sort(v);

      // Se fosse escrito diretamente v, apenas seria mostrada a sua referência
      System.out.println(Arrays.toString(v));
   }
}
