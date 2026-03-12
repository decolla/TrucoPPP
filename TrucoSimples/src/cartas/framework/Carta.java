package cartas.framework;

// a classe carta originalmente viola o princípio de reutilização, devido ter as regras de manilha do truco
// cravadas dento dela

import java.util.Objects;

// transformei em uma classe genérica simples
public class Carta<T> {

    private final String valor;
    private final String classe;

    public Carta(String valor, String naipe) {
        this.valor = valor;
        this.classe = naipe;
    }

    public String getValor() { return valor; }
    public String getNaipe() { return classe; }

    /*
    @Override
    public String toString() {
        String simbolo;
        switch (classe) {
            case Constants.COPAS: simbolo = Constants.SIMBOLO_COPAS; break;
            case Constants.OUROS: simbolo = Constants.SIMBOLO_OUROS; break;
            case Constants.ESPADAS: simbolo = Constants.SIMBOLO_ESPADAS; break;
            case Constants.PAUS: simbolo = Constants.SIMBOLO_PAUS; break;
            default: simbolo = "";
        }
        return valor + simbolo;
    }
*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carta carta = (Carta) o;
        return Objects.equals(valor, carta.valor) && Objects.equals(classe, carta.classe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, classe);
    }


    // removi o getForça, as própias classes que herdarem carta devem implementar suas lógicas
}
