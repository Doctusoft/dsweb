package com.doctusoft.dsw.client.comp;

import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.ValueBinding;
import com.doctusoft.dsw.client.comp.model.CellModel;
import com.doctusoft.dsw.client.comp.model.CellModel_;

public class Cell extends AbstractContainer<Cell, CellModel> {
	
	public Cell() {
		super(new CellModel());
	}
    
    public Cell bindSpan(final ValueBinding<Integer> spanBinding) {
		Bindings.bind(spanBinding, Bindings.obs(model).get(CellModel_._span));
		return this;
	}
    
    public Cell bindOffset(final ValueBinding<Integer> offsetBinding) {
		Bindings.bind(offsetBinding, Bindings.obs(model).get(CellModel_._offset));
		return this;
	}
	
}