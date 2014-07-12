package com.doctusoft.dsw.client.comp.model;

import com.doctusoft.bean.ObservableProperty;

public class ModalDialogModel extends BaseComponentModel {

	@com.doctusoft.ObservableProperty
	private String header = "";
	
	@com.doctusoft.ObservableProperty
	private Boolean dialogVisible;

	@com.doctusoft.ObservableProperty
	private ContainerModel footerContainer = new ContainerModel();

	@com.doctusoft.ObservableProperty
	private ContainerModel contentContainer = new ContainerModel();

	@Override
	public Iterable<ObservableProperty<?, ?>> getObservableProperties() {
		return ModalDialogModel_._observableProperties;
	}
}
