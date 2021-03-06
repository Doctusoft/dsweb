package com.doctusoft.dsw.sample.client.custom;

/*
 * #%L
 * dsweb-example
 * %%
 * Copyright (C) 2014 Doctusoft Ltd.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */


import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.ValueBinding;
import com.doctusoft.dsw.client.comp.BaseComponent;

public class CustomComponent extends BaseComponent<CustomComponent, CustomComponentModel> {
	
	public CustomComponent(String label) {
		super(new CustomComponentModel());
		model.setLabel(label);
	}
	
	public CustomComponent bindLabel(ValueBinding<String> labelBinding) {
		Bindings.bind(labelBinding, Bindings.on(model).get(CustomComponentModel_._label));
		return this;
	}
	
}
