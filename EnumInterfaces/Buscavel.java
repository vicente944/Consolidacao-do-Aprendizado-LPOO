package EnumInterfaces;
import ExcecoesPersonalizadas.ValorInvalidoException;

public interface Buscavel {
    void buscarPorInicioDoNome(String inicio) throws ValorInvalidoException;
}