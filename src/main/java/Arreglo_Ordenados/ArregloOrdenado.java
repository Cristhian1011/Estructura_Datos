// Source code is decompiled from a .class file using FernFlower decompiler.
package Arreglo_Ordenados;

public class ArregloOrdenado {
   private long[] arr;
   private int numElems;

   public ArregloOrdenado(int tam) {
      this.arr = new long[tam];
   }

   public int busquedaBinaria(long dato) {
      int minimo = 0;
      int maximo = this.numElems - 1;

      while(minimo <= maximo) {
         int central = (minimo + maximo) / 2;
         if (this.arr[central] == dato) {
            return central;
         }

         if (dato > this.arr[central]) {
            minimo = central + 1;
         } else {
            maximo = central - 1;
         }
      }

      return -1;
   }

   public void insertar(long dato) {
      int j;
      for(j = 0; j < this.numElems && this.arr[j] <= dato; ++j) {
      }

      for(int k = this.numElems; k > j; --k) {
         this.arr[k] = this.arr[k - 1];
      }

      this.arr[j] = dato;
      ++this.numElems;
   }

   public boolean eliminar(long dato) {
      int j = this.busquedaBinaria(dato);
      if (j == -1) {
         return false;
      } else {
         for(int k = j; k < this.numElems; ++k) {
            this.arr[k] = this.arr[k + 1];
         }

         --this.numElems;
         return true;
      }
   }

   public void mostrarArreglo() {
      for(int j = 0; j < this.numElems; ++j) {
       
         System.out.print("" + this.arr[j] + " ");
      }

      System.out.println("");
   }
}