package com.doctusoft.dsw.client.comp;

import lombok.Getter;

import com.doctusoft.dsw.client.comp.model.ContainerModel;

@Getter
public class Container extends AbstractContainer<Container, ContainerModel> {
	
	public Container() {
		super(new ContainerModel());
	}
	
}
