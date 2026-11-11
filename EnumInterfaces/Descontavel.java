package EnumInterfaces;
import ExcecoesPersonalizadas.*;

public interface Descontavel {
    double aplicarDesconto(double percentual) throws ValorInvalidoException, OrdemFinalizadaException;
}
