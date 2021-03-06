
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
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.dsw.client.comp.model.CheckboxModel;
import com.doctusoft.dsw.client.comp.model.CheckboxModel_;
import com.doctusoft.dsw.client.util.DeferredFactory;
import com.doctusoft.dsw.client.util.DeferredRunnable;
import com.google.common.base.Objects;
import com.xedge.jquery.client.JQEvent;
import com.xedge.jquery.client.JQuery;
import com.xedge.jquery.client.handlers.EventHandler;

public class CheckboxRenderer extends BaseComponentRenderer {
	
	private JQuery input;
	private CheckboxModel model;
	
	private DeferredRunnable updateValue = null;

	public static native void setCheckedNative( JQuery checkbox, boolean isChecked ) /*-{
		checkbox.prop('checked', isChecked);
	}-*/;
	
	public CheckboxRenderer( final CheckboxModel model ) {
		super( JQuery.select( "<label class=\"checkbox\">" ), model );
		this.model = model;
		input = JQuery.select( "<input type=\"checkbox\">" );
		
		input.appendTo( widget );
		input.after( "<span></span>" );
		applyValue(model.getLabel());
		setCheckedNative( input, Objects.firstNonNull(model.getChecked(), false) );
		
		addChangeListener(CheckboxModel_._checked, model, new ValueChangeListener<Boolean>() {
			
			@Override
			public void valueChanged( Boolean newValue ) {
				updateValue = DeferredFactory.defer(updateValue, new DeferredUpdateValue());
			}
		});
		
		input.change( new EventHandler() {
			
			@Override
			public void eventComplete( JQEvent event, JQuery currentJQuery ) {
				model.setChecked( input.is( ":checked" ) );
			}
		} );
		
		addChangeListener(CheckboxModel_._label, model, new ValueChangeListener<String>() {
			@Override
			public void valueChanged( String newValue ) {
				applyValue(newValue);
			}

		} );
        new EnabledAttributeRenderer(input, model, this);
	}
	
	public class DeferredUpdateValue implements Runnable {
		@Override
		public void run() {
			setCheckedNative( input, Objects.firstNonNull(model.getChecked(), false) );
			updateValue = null;
		}
	}

	private void applyValue(String newValue) {
		input.next().text( Objects.firstNonNull(newValue, "") );
	}
	
}
