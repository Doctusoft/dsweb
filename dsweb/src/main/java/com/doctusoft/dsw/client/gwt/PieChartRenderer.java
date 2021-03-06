
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


import java.util.List;

import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.observable.ListChangeListener;
import com.doctusoft.dsw.client.comp.model.ChartItemClickParam;
import com.doctusoft.dsw.client.comp.model.PieChartItemModel;
import com.doctusoft.dsw.client.comp.model.PieChartModel;
import com.doctusoft.dsw.client.comp.model.PieChartModel_;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.xedge.jquery.client.JQuery;

public class PieChartRenderer extends BaseComponentRenderer {
	
	private final PieChartModel model;
	
	private JQuery lastPlot;
	
	public PieChartRenderer( PieChartModel model ) {
		super( JQuery.select( "<div id=\"" + model.getId() + "\"></div>" ), model );
		this.model = model;
		initializePlot();
		new ListChangeListener( Bindings.obs( model ).get( PieChartModel_._pieChartItems) ) {
			
			@Override
			protected void changed() {
				if (lastPlot != null ) {
					destroyLastPlot( lastPlot );
				}
				initializePlot();
			}
			
		};
	}
	
	private void initializePlot(  ) {
		JsArray<JavaScriptObject> jsArray = createJsArrayFromItems( model.getPieChartItems() );
		initPieChartRendererNative(  widget, jsArray, model.getLegendPosition().getAbbreviation(), model.getTitle(), model.isShowTooltip(), model.getId());
	}
	
	private JsArray<JavaScriptObject> createJsArrayFromItems(List<PieChartItemModel> items ){
		JsArray<JavaScriptObject> array = JavaScriptObject.createArray().cast();
		for (PieChartItemModel item : items) {
			JsArray<JavaScriptObject> innerArray = createArrayFromEntry(  item.getName(), item.getValue() );
			array.push( innerArray );
		}
		return array;
	}
	
	private void rowClicked(int itemIndex, int subIndex){
		model.getRowClickedEvent().fire( new ChartItemClickParam( itemIndex, subIndex ) );
	}
	
	private void setLastPlot(JQuery plot){
		this.lastPlot = plot;
	}
	
	private native void destroyLastPlot(JQuery lastPlot)/*-{
		lastPlot.destroy();
	}-*/;
	
	private native JsArray<JavaScriptObject> createArrayFromEntry(String name, int value)/*-{
		return [name, value];
	}-*/;
	
	private native void initPieChartRendererNative(JQuery widget, JsArray<JavaScriptObject> data, String legendOrientation, String title, boolean showTooltip, String id) /*-{
		
		setTimeout(function() {
			var plot1 = $wnd.$.jqplot(id, [ data ], {
				title : title,
				seriesDefaults : {
					shadow : false,
					renderer : $wnd.jQuery.jqplot.PieRenderer,
					rendererOptions : {
						sliceMargin : 4,
						showDataLabels : true
					}
				},
				legend : {
					show : true,
					location : legendOrientation
				},
				highlighter: {
				  show: showTooltip,
				  formatString:'%s',
				  tooltipLocation:'sw',
				  useAxesFormatters:false,
       			  tooltipContentEditor:tooltipContentEditor,
				}
			});
			that.@com.doctusoft.dsw.client.gwt.PieChartRenderer::setLastPlot(Lcom/xedge/jquery/client/JQuery;)(plot1);
			
		}, 0);
		
		function tooltipContentEditor(str, seriesIndex, pointIndex, plot) {
		    return plot.data[seriesIndex][pointIndex][0]+': '+plot.data[seriesIndex][pointIndex][1];
		}
		
		that = this;
		
		// CLICK CODE START
		widget.unbind('jqplotDataClick');
        widget.bind('jqplotDataClick',
            function (ev, seriesIndex, pointIndex, data) {
           		that.@com.doctusoft.dsw.client.gwt.PieChartRenderer::rowClicked(II)(pointIndex, seriesIndex);
            }
        );
        // CLICK CODE END
	}-*/;
	
	
	
}
