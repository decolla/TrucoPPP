package cartas.framework;

import java.util.ArrayList;
import java.util.List;

// esta classe ja é genérica, pois já gerencia uma lista de cartas
public class Mao {

    // lista de cartas contidas na mão
    private final List<Carta> cartas;

    public Mao() {
        this.cartas = new ArrayList<>();
    }

    public void adicionar(Carta carta) {
        cartas.add(carta);
    }

    public Carta remover(int indice) {
        if (indice < 0 || indice >= cartas.size()) return null;
        return cartas.remove(indice);
    }

    public Carta get(int indice) {
        if (indice < 0 || indice >= cartas.size()) return null;
        return cartas.get(indice);
    }

    public int tamanho() {
        return cartas.size();
    }

    public boolean estaVazia() {
        return cartas.isEmpty();
    }

    public List<Carta> getCartas() {
        return new ArrayList<>(cartas);
    }
}
