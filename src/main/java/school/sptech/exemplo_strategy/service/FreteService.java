package school.sptech.exemplo_strategy.service;

import org.springframework.stereotype.Service;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;
import school.sptech.exemplo_strategy.exception.FreteInvalidoException;
import school.sptech.exemplo_strategy.repository.FreteRepository;

import java.util.List;

@Service
public class FreteService {

    private final FreteRepository freteRepository;

    public FreteService(FreteRepository freteRepository) {
        this.freteRepository = freteRepository;
    }

    public Frete registrarCotacao(Frete frete) {
        for (TipoFreteEnum tipoFreteEnum : TipoFreteEnum.values()) {
            if (tipoFreteEnum.name().equalsIgnoreCase(frete.getTipo().toString())) {
                Double valorFrete = frete.getTipo().getValor() + ((frete.getPesoEmKg() * frete.getTipo().getAcrescimo()) / 100);
                frete.setValorFrete(valorFrete);
                return(freteRepository.save(frete));
            }
        }

        throw new FreteInvalidoException("O tipo de frete " + frete.getTipo() + " é inválido");
    }

    public List<Frete> listarCotacoes() {
        return freteRepository.findAll();
    }
}
