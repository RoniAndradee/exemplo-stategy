package school.sptech.exemplo_strategy.controller.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;
import school.sptech.exemplo_strategy.exception.FreteInvalidoException;

public class FreteRequestDto {
    @NotNull
    private String tipo;
    @NotNull
    @DecimalMin(value = "10.01")
    private Double valorEncomenda;
    @NotNull
    @DecimalMin(value = "1.01")
    private Double pesoEmKg;

    public FreteRequestDto(String tipo, Double valorEncomenda, Double pesoEmKg) {
        this.tipo = tipo;
        this.valorEncomenda = valorEncomenda;
        this.pesoEmKg = pesoEmKg;
    }

    public FreteRequestDto() {
    }

    public static Frete toEntity(FreteRequestDto dto) {
        TipoFreteEnum tipoEnum = TipoFreteEnum.converterString(dto.getTipo());
        if (tipoEnum == null) {
            throw new FreteInvalidoException("O tipo de frete '" + dto.getTipo() + "' é inválido");
        }
        Frete frete = new Frete();
        frete.setTipo(tipoEnum);
        frete.setValorEncomenda(dto.getValorEncomenda());
        frete.setPesoEmKg(dto.getPesoEmKg());
        return frete;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Double getValorEncomenda() {
        return valorEncomenda;
    }

    public void setValorEncomenda(Double valorEncomenda) {
        this.valorEncomenda = valorEncomenda;
    }

    public Double getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(Double pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }
}
