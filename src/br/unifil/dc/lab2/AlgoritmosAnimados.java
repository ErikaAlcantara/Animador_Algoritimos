package br.unifil.dc.lab2;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/**
 * Write a description of class AlgoritmosAnimados here.
 * 
 * @author Ricardo Inacio
 * @version 20200408
 */
public class AlgoritmosAnimados {
    public static Gravador listaEstatica(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Valores da lista imutável");
        return anim;

    }

    public static Gravador pesquisaSequencial(List<Integer> valores, int chave) {
        Gravador anim = new Gravador(); // instancia um novo objeto gravador. Atribui-se à variavel anim, um novo objeto
                                        // Gravador.
        anim.gravarLista(valores, "Inicio de pesquisa sequencial"); // objeto chama método gravar lista da classe
                                                                    // gravador para demonstrar os valores da lista
                                                                    // passados pelo usuário. Acompanha mensagem
                                                                    // descritiva.

        int i = 0; // estabelece o que o índice inicial será o primeiro da lista.
        anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial"); // demonstra a lista e o índice em destaque.
                                                                       // Acompanha mensagem descritiva.
        while (i < valores.size() && valores.get(i) != chave) { // laço estabelece condição para percorrer a lista.
            i++; // iteração. Passa-se ao próximo índice.
            anim.gravarIndiceDestacado(valores, i, "Pesquisa sequencial"); // demonstra a lista e o índice em destaque.
                                                                           // Acompanha mensagem descritiva.
        }

        if (i < valores.size()) { // condição para saber se chave foi encontrada. Como o elemento do índice não é
                                  // =! de chave e o índice não extrapolou o tamanho da lista, encontrou-se a
                                  // chave.
            anim.gravarIndiceDestacado(valores, i, "Chave encontrada"); // demonstra a lista e o índice em que a chave
                                                                        // foi encontrada. Acompanha mensagem
                                                                        // descritiva.
        } else {
            anim.gravarLista(valores, "Chave não encontrada"); // caso índice extrapole tamanho da lista, a chave não
                                                               // existe na lista. Acompanha mensagem descritiva.
        }

        return anim; // retorna o objeto em seu estado atual.
    }

    public static Gravador classificarPorBolha(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        boolean trocou;
        do {
            trocou = false;
            for (int i = 1; i < valores.size(); i++) {
                anim.gravarIndiceDestacado(valores, i, "Classificar por Bolha");
                if (valores.get(i - 1) > valores.get(i)) {
                    anim.gravarComparacaoSimples(valores, i, i - 1);
                    valores.set(i - 1, i);
                    anim.gravarPosTrocas(valores, i, i - 1);
                    trocou = true;
                }
            }
        } while (trocou);

        anim.gravarLista(valores, "Disposição final");
        return anim;
    }

    public static Gravador classificarPorSelecao(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        for (int i = 0; i < valores.size(); i++) {
            int minimo = i;
            anim.gravarIndiceDestacado(valores, i, "Classificar por Seleção");
            for (int j = i + 1; j < valores.size(); j++) {
                if (valores.get(j) < valores.get(minimo)) {
                    anim.gravarComparacaoSimples(valores, j, minimo);
                    minimo = j;
                }
            }
            int aux = valores.get(i);
            valores.set(i, minimo);
            valores.set(minimo, aux);
            anim.gravarPosTrocas(valores, i, minimo);
        }
        anim.gravarLista(valores, "Disposição final");
        return anim;
    }

    public static Gravador pesquisaBinaria(List<Integer> valores, int chave) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        int beginning = 0;
        int end = valores.size() - 1;

        while (beginning <= end) {
            int middle = (beginning + end) / 2;
            if (chave < valores.get(middle)) {
                anim.gravarIndiceDestacado(valores, middle, "Pesquisa Binária");
                anim.gravarIndiceDestacadoBlue(valores, beginning, "Posição inicial");
                anim.gravarIndiceDestacadoRed(valores, end, "Posição final");
                end = middle - 1;
            } else if (chave > valores.get(middle)) {
                anim.gravarIndiceDestacado(valores, middle, "Pesquisa Binária");
                anim.gravarIndiceDestacadoBlue(valores, beginning, "Posição inicial");
                anim.gravarIndiceDestacadoRed(valores, end, "Posição final");
                beginning = middle + 1;
            } else {
                anim.gravarIndiceDestacado(valores, middle, "Chave encontrada");
                anim.gravarIndiceDestacadoBlue(valores, beginning, "Posição inicial");
                anim.gravarIndiceDestacadoRed(valores, end, "Posição final");
            }
        }
        anim.gravarLista(valores, "Chave não encontrada");

        anim.gravarLista(valores, "Disposição final");
        return anim;
    }

    public static Gravador classificarPorInsercao(List<Integer> list) {
        Gravador anim = new Gravador();
        anim.gravarLista(list, "Disposição inicial");
        for (int i = 0; i < list.size(); i++) {

            for (int j = i; j >= 0; --j) {
                int currentIndex = j;
                int previousIndex = j - 1;

                if (previousIndex >= 0) {
                    int currentElement = list.get(j);
                    int previousElement = list.get(j - 1);

                    if (currentElement < previousElement) {

                        anim.gravarComparacaoSimples(list, i, j);

                        list.set(currentIndex, previousElement);
                        list.set(previousIndex, currentElement);

                        anim.gravarPosTrocas(list, currentIndex, previousIndex);
                    }
                }
            }
        }
        anim.gravarLista(list, "Disposição final");
        return anim;
    }

    public static Gravador classificarPorMergeSort(List<Integer> valores) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        if (valores.size() <= 1) {
            anim.gravarLista(valores, "Disposição final");
            return anim;
        } else {
            final int middle = valores.size() / 2;
            List<Integer> left = valores.subList(0, middle);
            classificarPorMergeSort(left);
            anim.gravarLista(valores, "subdivisão");

            List<Integer> right = valores.subList(middle, valores.size());
            classificarPorMergeSort(right);
            anim.gravarLista(valores, "subdivisão");

            merge(valores, left, right);
        }
        anim.gravarLista(valores, "Disposição final");
        return anim;
    }

    private static void merge(List<Integer> tempList, List<Integer> left, List<Integer> right) {
        int indexLeft = 0, indexRight = 0, idxL = 0;
        while (indexLeft < left.size() && indexRight < right.size()) {
            if (left.get(indexLeft) < right.get(indexRight)) {
                tempList.set(idxL, left.get(indexLeft));
                indexLeft++;
            } else {
                tempList.set(idxL, right.get(indexRight));
                indexRight++;
            }
            idxL++;
        }

        int idxF;
        List<Integer> faltantes;
        if (indexLeft < left.size()) {
            faltantes = left;
            idxF = indexLeft;
        } else {
            faltantes = right;
            idxF = indexRight;
        }

        while (idxF < faltantes.size()) {
            tempList.set(idxL, faltantes.get(idxF));
            idxL++;
            idxF++;
        }
    }

    public static Gravador classificarPorQuickSort(List<Integer> valores, int start, int end) {
        Gravador anim = new Gravador();
        anim.gravarLista(valores, "Disposição inicial");

        if (start < end) {
            int partitionPoint = partition(valores, start, end);
            classificarPorQuickSort(valores, start, partitionPoint - 1);
            classificarPorQuickSort(valores, partitionPoint + 1, end);

        }
        anim.gravarLista(valores, "Disposição final");
        return anim;
    }
    public static int partition(List<Integer> valores, int start, int end){
        Gravador anim = new Gravador();

        int pivot = valores.get(end);
        int i = start - 1;
        for(int j = start; j <= end-1; j++){
            if(valores.get(j) <= pivot){
                anim.gravarComparacaoSimples(valores, j, pivot);
                i++;
                int iValue = valores.get(i);
                int jValue = valores.get(j);
                valores.set(i, jValue);
                valores.set(j, iValue);
                anim.gravarPosTrocas(valores, i, j);
            }
        }

        int iValue = valores.get(i + 1);
        valores.set(end, iValue);
        valores.set(i + 1, pivot);
        anim.gravarPosTrocas(valores, end, i + 1);
        
        
        return i+1;

    }

}
