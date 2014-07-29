
package com.doctusoft.dsw.client.comp.model;

import com.doctusoft.bean.ObservableProperty;
import com.doctusoft.bean.binding.observable.ObservableList;

public class PieChartModel extends AbstractChartModel {
	
	@com.doctusoft.ObservableProperty
	private ObservableList<PieChartItemModel> pieChartItems = new ObservableList<PieChartItemModel>();
	
	@Override
	public Iterable<ObservableProperty<?, ?>> getObservableProperties() {
		return PieChartModel_._observableProperties;
	}
	
	
}