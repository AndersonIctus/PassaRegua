package br.com.inteliprojects.passaregua.itens.model;

import java.math.BigDecimal;

/**
 * Created by DARUMA02 on 21/02/2017.
 */
public class ItemModel {
    private int numItem;
    private String descricao;
    private int qtd;
    private String unidMedida;
    private BigDecimal valorUnitario;

    public ItemModel(int numItem, String descricao, int qtd, String unidMedida, BigDecimal valorUnitario) {
        this.numItem = numItem;
        this.descricao = descricao;
        this.qtd = qtd;
        this.unidMedida = unidMedida;
        this.valorUnitario = valorUnitario;
    }

    public int getNumItem() { return this.numItem; }

    public int getQtd() {
        return qtd;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getUnidMedida() {
        return unidMedida;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public BigDecimal calcularValorTotal() {
        return new BigDecimal(qtd).multiply(valorUnitario);
    }

    public String toString(){
        String out = "";
        out += "ItemModel('" + numItem + "', '" +
                             descricao + "', '" +
                             qtd + "', '" +
                             descricao + "', '" +
                             valorUnitario + "', '" +
                             calcularValorTotal() + "')";

        return out;
    }
}
