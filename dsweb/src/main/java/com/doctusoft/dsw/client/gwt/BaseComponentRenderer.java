package com.doctusoft.dsw.client.gwt;

import lombok.Getter;

import com.doctusoft.bean.ObservableProperty;
import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.observable.ObservableList;
import com.doctusoft.dsw.client.Renderer;
import com.doctusoft.dsw.client.comp.model.BaseComponentModel;
import com.doctusoft.dsw.client.comp.model.BaseComponentModel_;
import com.doctusoft.dsw.client.util.Booleans;
import com.doctusoft.dsw.client.util.ListBindingListener;
import com.xedge.jquery.client.JQEvent;
import com.xedge.jquery.client.JQuery;
import com.xedge.jquery.client.handlers.EventHandler;

public class BaseComponentRenderer implements Renderer<JQuery> {
	
	private static <T, K> void addChangeListener(ObservableProperty<K, T> property, BaseComponentModel model, ValueChangeListener<T> listener) {
		property.addChangeListener((K) model, listener);
		listener.valueChanged(property.getValue((K) model));
	}
	
	@Getter
	protected JQuery widget;
	
	public BaseComponentRenderer(final JQuery widget, final BaseComponentModel component) {
		this.widget = widget;
		
		addChangeListener(BaseComponentModel_._visible, component, new ValueChangeListener<Boolean>() {
			@Override
			public void valueChanged(Boolean newValue) {
				if (Booleans.isTrue(newValue)) {
					widget.show();
				} else {
					widget.hide();
				}
			}
		});
		new ListBindingListener<String>(Bindings.obs(component).get(BaseComponentModel_._styleClasses)) {
			@Override
			public void inserted(ObservableList<String> list, int index,
					String element) {
				widget.addClass(element);
			}
			
			@Override
			public void removed(ObservableList<String> list, int index,
					String element) {
				widget.removeClass(element);
			}
		};
		addChangeListener(BaseComponentModel_._style, component, new ValueChangeListener<String>() {
			
			@Override
			public void valueChanged(String newValue) {
				if (newValue == null) {
					newValue = "";
				}
				widget.attr("style", newValue);
			}
		});
		
		widget.click(new EventHandler() {
			@Override
			public void eventComplete(JQEvent event, JQuery currentJQuery) {
				if (component.getClickHandler() != null) {
					component.getClickHandler().handle();
				}
			}
		});
	}
	
}
