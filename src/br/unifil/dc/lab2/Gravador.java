package br.unifil.dc.lab2;

import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.awt.Color;

/**
 * Write a description of class Gravador here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gravador
{
    public Gravador() {
        this.seqGravacoes = new ArrayList<Transparencia>();
    }


    /**
     * Método gravador de Lista. Demonstra a lista, acompanhada de
     * mensagem descritiva sobre estado da lista.
     * @param lista Lista com valores Integer passados pelo usuário.
     * @param nome String que contém a mensagem descritiva.
     */
    public void gravarLista(List<Integer> lista, String nome) {
        List<Integer> copia = new ArrayList<Integer>(lista);
        List<Color> cores = novaListaColors(lista.size());
        ListaGravada gravacao = new ListaGravada(copia, cores, nome);
        seqGravacoes.add(gravacao);
    }
    /**
     * Método gravador de índice. Demonstra a lista, índice que está sendo
     * pesquisado e mensagem descritiva da etapa.
     * @param lista Lista com valores Integer passados pelo usuário.
     * @param i Índice da lista pesquisado no momento.
     * @param nome String que contém a mensagem descritiva.
     */
    public void gravarIndiceDestacado(List<Integer> lista, int i, String nome) {
        List<Integer> copia = new ArrayList<Integer>(lista);
        List<Color> cores = novaListaColors(lista.size());
        cores.set(i, Color.YELLOW);
        ListaGravada gravacao = new ListaGravada(copia, cores, nome);
        seqGravacoes.add(gravacao);
    }

    public void gravarIndiceDestacadoBlue(List<Integer> lista, int i, String nome) {
        List<Integer> copia = new ArrayList<Integer>(lista);
        List<Color> cores = novaListaColors(lista.size());
        cores.set(i, Color.BLUE);
        ListaGravada gravacao = new ListaGravada(copia, cores, nome);
        seqGravacoes.add(gravacao);
    }

    public void gravarIndiceDestacadoRed(List<Integer> lista, int i, String nome) {
        List<Integer> copia = new ArrayList<Integer>(lista);
        List<Color> cores = novaListaColors(lista.size());
        cores.set(i, Color.RED);
        ListaGravada gravacao = new ListaGravada(copia, cores, nome);
        seqGravacoes.add(gravacao);
    }

    /**
     * Método gravador de comparação simples. Registra o momento em que é feita uma
     * comparação entre elementos da lista.
     * @param lista Lista com valores Integer passados pelo usuário.
     * @param i Elemento existente no índice anterior.
     * @param j Elemento existente no índice posterior.
     */
    public void gravarComparacaoSimples(List<Integer> lista, int i, int j) {
        List<Integer> copia = new ArrayList<Integer>(lista);
        List<Color> cores = novaListaColors(lista.size());
        cores.set(i, Color.GRAY);
        cores.set(j, Color.GRAY);
        ListaGravada gravacao = new ListaGravada(copia, cores, "Comparação");
        seqGravacoes.add(gravacao);
    }

    // /**
    //  * Método gravador de comparação complexo. Registra o momento em que é feita uma
    //  * comparação entre subdivisoes da lista.
    //  * @param lista Lista com valores Integer passados pelo usuário.
    //  * @param left Lista à esquerda.
    //  * @param right Lista à direita.
    //  */
    // public void gravarComparacaoComplexo(List<Integer> lista, List<Integer> left, List<Integer> right) {
    //     List<Integer> copia = new ArrayList<Integer>(lista);
    //     List<Color> cores = novaListaColors(lista.size());
    //     cores.set(left, Color.GRAY); //must create a new method for colors for arrays.
    //     cores.set(right, Color.GRAY); //must create a new method for colors for arrays.
    //     ListaGravada gravacao = new ListaGravada(copia, cores, "Comparação");
    //     seqGravacoes.add(gravacao);
    // }

    

    
    /**
     * Método gravador de trocas. Registra a lista logo após a troca entre elementos,
     * bem como os elementos que foram objetos da troca.
     * @param lista Lista com valores Integer passados pelo usuário atualizada pós-troca.
     * @param i Atual elemento anterior.
     * @param j Atual elemento posterior.
     */
    public void gravarPosTrocas(List<Integer> lista, int i, int j) {
        List<Integer> copia = new ArrayList<Integer>(lista);
        List<Color> cores = novaListaColors(lista.size());
        
        if (lista.size() == i) --i;
        
        cores.set(i, Color.YELLOW);
        cores.set(j, Color.YELLOW);
        ListaGravada gravacao = new ListaGravada(copia, cores, "Pós-troca");
        seqGravacoes.add(gravacao);
    }

    public ListIterator<Transparencia> getFilme() {
        return seqGravacoes.listIterator();
    }

    private static List<Color> novaListaColors(int numElems) {
        ArrayList<Color> lista = new ArrayList<>(numElems);
        for (; numElems > 0; numElems--) lista.add(null);
        return lista;
    }

    private List<Transparencia> seqGravacoes;
}
