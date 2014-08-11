package com.doctusoft.dsw.client.comp.model;

import com.doctusoft.ObservableProperty;
import com.doctusoft.bean.ModelObject;

public class DataTableCellModel implements ModelObject {
	
	@ObservableProperty
	private String textContent;
	
	@ObservableProperty
	private BaseComponentModel component;
	
}
