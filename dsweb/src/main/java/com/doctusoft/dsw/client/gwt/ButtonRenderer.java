package com.doctusoft.dsw.client.gwt;

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


import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.dsw.client.comp.model.ButtonModel;
import com.doctusoft.dsw.client.comp.model.ButtonModel_;
import com.google.common.base.Objects;
import com.xedge.jquery.client.JQuery;

public class ButtonRenderer extends BaseComponentRenderer {
	
	public ButtonRenderer(final ButtonModel button) {
		super(JQuery.select("<button/>"), button);
		widget.addClass("btn");
		addChangeListenerAndApply(ButtonModel_._caption, button, new ValueChangeListener<String>() {
			@Override
			public void valueChanged(String newValue) {
				widget.text(Objects.firstNonNull(newValue, ""));
			}
		});
	}
	
}
