/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.doctusoft.dsw.client.gwt;

import java.util.Map;

import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.observable.ObservableList;
import com.doctusoft.bean.binding.observable.ObservableValueBinding;
import com.doctusoft.dsw.client.RendererFactory;
import com.doctusoft.dsw.client.comp.model.AbstractContainerModel_;
import com.doctusoft.dsw.client.comp.model.BaseComponentModel;
import com.doctusoft.dsw.client.comp.model.CellModel;
import com.doctusoft.dsw.client.comp.model.CellModel_;
import com.doctusoft.dsw.client.util.ListBindingListener;
import com.google.common.collect.Maps;
import com.google.gwt.core.client.GWT;
import com.xedge.jquery.client.JQuery;

/**
 *
 * @author dipacs
 */
public class CellRenderer extends BaseComponentRenderer {
	
	public static RendererFactory<JQuery> rendererFactory = GWT.create(RendererFactory.class);
	
	private Map<BaseComponentModel, JQuery> renderedWidgets = Maps.newHashMap();
    
    private int actualSpan = -1;
    private int actualOffset = -1;
	
	public CellRenderer(CellModel model) {
		super(JQuery.select("<div/>"), model);
		new ListBindingListener<BaseComponentModel>((ObservableValueBinding) Bindings.obs(model).get(AbstractContainerModel_._children)) {
			@Override
			public void inserted(ObservableList<BaseComponentModel> list, int index,
					BaseComponentModel element) {
				widgetAdded(element);
			}
			
			@Override
			public void removed(ObservableList<BaseComponentModel> list, int index,
					BaseComponentModel element) {
				// remove the rendered JQuery element
				renderedWidgets.get(element).remove();
				// remove the handle from the map
				renderedWidgets.remove(element);
			}
		};
        Bindings.obs(model).get(CellModel_._offset).addValueChangeListener(new ValueChangeListener<Integer>() {

            @Override
            public void valueChanged(Integer newValue) {
                refreshOffset(newValue);
            }
        });
        Bindings.obs(model).get(CellModel_._span).addValueChangeListener(new ValueChangeListener<Integer>() {

            @Override
            public void valueChanged(Integer newValue) {
                refreshSpan(newValue);
            }
        });
        refreshOffset(model.getOffset());
        refreshSpan(model.getSpan());
	}
	
	protected void widgetAdded(BaseComponentModel baseWidget) {
		JQuery rendered = rendererFactory.getRenderer(baseWidget).getWidget();
		widget.append(rendered);
		renderedWidgets.put(baseWidget, rendered);
	}
    
    private void refreshOffset(Integer newValue) {
        removeOffsetClass();
        actualOffset = -1;
        if (newValue != null && newValue >= 0 && newValue < 12) {
            actualOffset = newValue;
            widget.addClass("offset" + actualOffset);
        }
    }
    
    private void removeOffsetClass() {
        if (actualOffset > -1) {
            widget.removeClass("offset" + actualOffset);
        }
    }
    
    private void refreshSpan(Integer newValue) {
        removeSpanClass();
        actualSpan = -1;
        if (newValue != null && newValue > 0 && newValue <= 12) {
            actualSpan = newValue;
            widget.addClass("span" + actualSpan);
        }
    }
    
    private void removeSpanClass() {
        if (actualSpan > -1) {
            widget.removeClass("span" + actualSpan);
        }
    }
    
}
