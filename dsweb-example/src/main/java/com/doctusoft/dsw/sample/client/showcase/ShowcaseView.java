package com.doctusoft.dsw.sample.client.showcase;

import java.util.Map;

import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.dsw.client.comp.Cell;
import com.doctusoft.dsw.client.comp.Container;
import com.doctusoft.dsw.client.comp.HasComponentModel;
import com.doctusoft.dsw.client.comp.Link;
import com.doctusoft.dsw.client.comp.Navs;
import com.doctusoft.dsw.client.comp.Row;
import com.doctusoft.dsw.client.comp.mvp.ContainerWithPresenter;
import com.google.common.collect.Maps;

public class ShowcaseView extends ContainerWithPresenter<ShowcaseActivity> {
	
	private Container subcontainer;
	private Map<ShowcaseItem, HasComponentModel> subitems = Maps.newHashMap();

	public ShowcaseView() {
		Row row = new Row().appendTo(container);
		Cell menuCell = new Cell().withSpan(3).appendTo(row);
		new Navs().stacked()
			.addMenuItem(new Link("Buttons", "#ShowcasePlace:Buttons"))
			.addMenuItem(new Link("Navs", "#ShowcasePlace:Navs"))
			.addMenuItem(new Link("Tables", "#ShowcasePlace:Tables"))
			.appendTo(menuCell);
		subcontainer = new Container().appendTo(new Cell().withSpan(9).appendTo(row));
		// a lazy initialization would be nicer, but that's okay for now
		subitems.put(ShowcaseItem.Buttons, new ShowcaseButtonsView());
		subitems.put(ShowcaseItem.Navs, new ShowcaseNavsView());
		subitems.put(ShowcaseItem.Tables, new ShowcaseTableView());
		bindOnPresenter().get(ShowcaseActivity_._item).addValueChangeListener(new ValueChangeListener<ShowcaseItem>() {
			@Override
			public void valueChanged(ShowcaseItem item) {
				subcontainer.clear();
				subcontainer.add(subitems.get(item));
			}
		});
	}

}