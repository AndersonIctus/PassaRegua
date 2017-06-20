package br.com.inteliprojects.passaregua.itens;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import br.com.inteliprojects.passaregua.R;
import br.com.inteliprojects.passaregua.itens.model.ItemModel;
import br.com.inteliprojects.passaregua.utilitarios.UtilString;

/**
 * TODO: document your custom view class.
 */
public class ItemView {
    private ItemModel itemModel;
    private View myView;

    public ItemView(Context context, ItemModel itemModel) {
        myView = LayoutInflater.from( context ).inflate(R.layout.item_view, null);
        atualizarItemModel(itemModel);
    }

    /**
     * @param itemModel
     */
    public void atualizarItemModel(ItemModel itemModel) {
        Log.i("SavedInstance", itemModel.toString() );
        this.itemModel = itemModel;

        //Atualizando os atributos do novo itemModel ...
        atualizaCampo(R.id.txtItemViewNumItem, UtilString.zerosLeft(itemModel.getNumItem(), 3) );
        atualizaCampo(R.id.txtItemViewDescricaoItem, itemModel.getDescricao() );
        atualizaCampo(R.id.txtItemViewQtdItens, "x" + itemModel.getQtd() );
        atualizaCampo(R.id.txtItemViewUnidMedida, itemModel.getUnidMedida() );
        atualizaCampo(R.id.txtItemViewValorUnit, UtilString.formataCasasDecimais( itemModel.getValorUnitario() ) );
        atualizaCampo(R.id.txtItemViewValorTotal, UtilString.formataCasasDecimais( itemModel.calcularValorTotal() ) );
    }

    private void atualizaCampo(int handleView, String strValor) {
        TextView txtAux = (TextView) myView.findViewById(handleView);
        txtAux.setText(strValor);
    }

    public View getView() {
        return this.myView;
    }
}
