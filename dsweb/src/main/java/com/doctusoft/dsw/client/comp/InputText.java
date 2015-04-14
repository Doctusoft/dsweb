package com.doctusoft.dsw.client.comp;

/*
 * #%L
 * dsweb
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
import com.doctusoft.dsw.client.comp.model.InputTextModel;
import com.doctusoft.dsw.client.comp.model.InputTextModel_;

public class InputText extends AbstractInputText<InputText, InputTextModel> {

	public InputText() {
		super(new InputTextModel());
	}

	public InputText withPlaceHolder(final String placeHolder) {
		model.setPlaceHolder(placeHolder);
		return this;
	}

	public InputText withInputType(final String inputType) {
		model.setInputType(inputType);
		return this;
	}
	
	public InputText withMaxLength(final int maxLength) {
		model.setMaxLength(maxLength);
		return this;
	}
	
	public InputText withImmediate(final boolean immediate) {
		model.setImmediate(immediate);
		return this;
	}

	public InputText immediate() {
		model.setImmediate(true);
		return this;
	}
	
	public InputText bindPlaceHolder(final ValueBinding<String> placeholderBinding) {
		Bindings.bind(placeholderBinding, Bindings.on(model).get(InputTextModel_._placeHolder));
		return this;
	}
	
	public InputText bindMaxLength(final ValueBinding<Integer> maxLengthBinding) {
		Bindings.bind(maxLengthBinding, Bindings.on(model).get(InputTextModel_._maxLength));
		return this;
	}

	public InputText bindImmediate(final ValueBinding<Boolean> immediateBinding) {
		Bindings.bind(immediateBinding, Bindings.on(model).get(InputTextModel_._immediate));
		return this;
	}
}
