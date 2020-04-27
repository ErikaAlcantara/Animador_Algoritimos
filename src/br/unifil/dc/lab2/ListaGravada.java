package br.unifil.dc.lab2;

import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;

/**
 * Write a description of class ListaGravada here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ListaGravada implements Transparencia
{
    /**
     * Constructor for objects of class ListaGravada
     */
    public ListaGravada(List<Integer> lista, List<Color> coresIndices, String nome) {
        this.lista = lista;
        this.nome = nome;
        this.coresIndices = coresIndices;
    }


    public void pintar(Graphics2D pincel, JPanel contexto) {
        int X = contexto.getWidth();
        int Y = contexto.getHeight();

        acharMaiorElementos(lista);
        compararElementos(lista, maiorElemento);
        definirTamanhos(lista, X, Y);
        desenharGraficos(pincel);
        Dimension dim = contexto.getSize();
    }

    private void compararElementos(List<Integer> valores, int maiorElemento) {
        listaProporcoes = new ArrayList<>();
        for(int i = 0; i < lista.size(); i++) {
            float listTemp = lista.get(i);
            float temp = listTemp / maiorElemento;
            listaProporcoes.add(i, temp);
        }
    }

    private void acharMaiorElementos(List<Integer> lista) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > maiorElemento) {
                maiorElemento = lista.get(i);
            }
        }
    }

    public void definirTamanhos(List<Integer> lista, int X, int Y) {
        double porcentagemLargura = 60;
        double porcentagemDistancia = 41.7;
        double porcentagemMargem = 16.7;

        porcentagemLargura = porcentagemLargura / lista.size();
        porcentagemDistancia = porcentagemDistancia / lista.size();
        porcentagemMargem = porcentagemMargem / lista.size();

        largBlocos = ((X / 100) * porcentagemLargura);
        espacBlocos = ((X / 100) * porcentagemDistancia);
        margem = ((X / 100) * porcentagemMargem);

        maiorBloco = Y / (Y / (float) (Y / 2));
        margemSuperior = Y / (Y / (float) (Y / 4 ));
    }

    private void desenharGraficos(Graphics2D pincel) {
        int xAux = (int) margem;
        for (int i = 0; i < lista.size(); i++) {

            if (coresIndices.get(i) == null) {
                pincel.setColor(Color.cyan);
            } else {
                pincel.setColor(coresIndices.get(i));
            }

            double alturaI = maiorBloco * listaProporcoes.get(i);
            double eixoY = margemSuperior + (maiorBloco - alturaI);

            pincel.fillRect((int) xAux, (int) eixoY,
                    (int) largBlocos, (int) alturaI);


            pincel.setStroke(bs);
            pincel.setColor(Color.black);

            pincel.drawRect((int) xAux, (int) eixoY,
                    (int) largBlocos, (int) alturaI);

            desenharString(pincel, i, xAux, eixoY, alturaI);


            xAux += (int) largBlocos + (int) espacBlocos;
        }
    }

    private void desenharString(Graphics2D pincel, int i, int xAux, double eixoY, double alturaI) {
        nome = lista.get(i).toString();
        FontMetrics fm = pincel.getFontMetrics();

        double xString = xAux + (largBlocos / 2) - (fm.stringWidth(nome) / 2);
        double yString = (eixoY + alturaI + 1) + fm.getHeight();
        pincel.drawString(nome, (int) xString, (int) yString);
    }


    private List<Integer> lista;
    private List<Float> listaProporcoes;
    private List<Color> coresIndices;
    private String nome;
    private int maiorElemento;
    private BasicStroke bs = new BasicStroke(3);
    private double largBlocos;
    private double espacBlocos;
    private double margem;
    private double maiorBloco;
    private double margemSuperior;
}