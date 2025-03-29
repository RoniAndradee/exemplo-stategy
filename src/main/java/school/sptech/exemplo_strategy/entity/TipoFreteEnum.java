package school.sptech.exemplo_strategy.entity;

public enum TipoFreteEnum {
    NORMAL("Entrega em até 12 dias úteis", 10.0, 10),
    EXPRESSO("Entrega em até 3 dias úteis", 30.0, 50),
    TRANSPORTADORA("Entrega em até 6 dias úteis", 20.0, 20);

    private final String descricao;
    private final Double valor;
    private final Integer acrescimo;

    TipoFreteEnum(String descricao, Double valor, Integer acrescimo) {
        this.descricao = descricao;
        this.valor = valor;
        this.acrescimo = acrescimo;
    }

    public static TipoFreteEnum converterString(String tipo) {
        for (TipoFreteEnum t : TipoFreteEnum.values()) {
            if (t.name().equalsIgnoreCase(tipo)) {
                return t;
            }
        }
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getAcrescimo() {
        return acrescimo;
    }
}
