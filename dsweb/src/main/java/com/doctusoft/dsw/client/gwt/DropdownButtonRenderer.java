package com.doctusoft.dsw.client.gwt;

import com.doctusoft.dsw.client.comp.model.DropdownButtonModel;
import com.xedge.jquery.client.JQuery;

public class DropdownButtonRenderer extends ContainerRenderer {

	public DropdownButtonRenderer(DropdownButtonModel container) {
		super(container);
		JQuery.select(widget.children().get(0)).append("<span class=\"caret\"></span>");
		JQuery.select(widget.children().get(0)).attr("data-toggle", "dropdown"); 
	}
	
}
