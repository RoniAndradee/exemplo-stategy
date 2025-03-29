package school.sptech.exemplo_strategy.controller.dto;

import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;

public class FreteResponseDto {
    private Integer id;
    private TipoFreteEnum tipo;
    private String descricao;
    private Double valorFrete;

    public FreteResponseDto(Integer id, TipoFreteEnum tipo, String descricao, Double valorFrete) {
        this.id = id;
        this.tipo = tipo;
        this.descricao = descricao;
        this.valorFrete = valorFrete;
    }

    public FreteResponseDto() {
    }

    public static FreteResponseDto toResponse(Frete frete) {
        FreteResponseDto dto = new FreteResponseDto();
        dto.setId(frete.getId());
        dto.setTipo(frete.getTipo());
        dto.setDescricao(frete.getTipo().getDescricao());
        dto.setValorFrete(frete.getValorFrete());
        return dto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoFreteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoFreteEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }
}
