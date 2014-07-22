
package com.doctusoft.dsw.client.comp;

import java.io.Serializable;
import java.util.List;

import com.doctusoft.bean.ValueChangeListener;
import com.doctusoft.bean.binding.Bindings;
import com.doctusoft.bean.binding.Converter;
import com.doctusoft.bean.binding.ValueBinding;
import com.doctusoft.bean.binding.observable.BidirectionalConvertingListBinder;
import com.doctusoft.bean.binding.observable.ListBindingListener;
import com.doctusoft.bean.binding.observable.ObservableList;
import com.doctusoft.bean.binding.observable.ObservableValueBinding;
import com.doctusoft.dsw.client.comp.datatable.Column;
import com.doctusoft.dsw.client.comp.model.DataTableCellModel;
import com.doctusoft.dsw.client.comp.model.DataTableModel;
import com.doctusoft.dsw.client.comp.model.DataTableModel_;
import com.doctusoft.dsw.client.comp.model.DataTableRowModel;
import com.doctusoft.dsw.client.comp.model.SelectionMode;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

public class DataTable<Item> extends BaseComponent<DataTable<Item>, DataTableModel> {
	
	private class SelectItemToIndexConverter implements Converter<Item, Integer>, Serializable {
		
		@Override
		public Integer convertSource( Item source ) {
			if (source == null) {
				return -1;
			}
			return itemsListener.getShadowList().indexOf( source );
		}
		
		@Override
		public Item convertTarget( Integer target ) {
			if (target == -1) {
				return null;
			}
			return itemsListener.getShadowList().get( target );
		}
	}
	
	private final List<Column<Item>> columns = Lists.newArrayList();
	
	private ListBindingListener<Item> itemsListener;
	
	public DataTable() {
		super( new DataTableModel() );
		Bindings.obs( model ).get( DataTableModel_._selectionMode ).addValueChangeListener( new ValueChangeListener<SelectionMode>() {
			
			@Override
			public void valueChanged( SelectionMode newValue ) {
				model.getSelectedIndices().clear();
			}
		} );
	}
	
	public DataTable<Item> addColumn( Column<Item> column ) {
		model.getColumns().add( column.getHeader() );
		columns.add( column );
		return this;
	}
	
	public DataTable<Item> bind( ObservableValueBinding<? extends List<Item>> listBinding ) {
		if (itemsListener != null) {
			// remove previous binding
			itemsListener.remove();
		}
		itemsListener = new ListBindingListener<Item>( listBinding ) {
			
			@Override
			public void inserted( ObservableList<Item> list, int index, Item element ) {
				model.getRows().add( index, renderRow( element ) );
			}
			
			@Override
			public void removed( ObservableList<Item> list, int index, Item element ) {
				model.getRows().remove( index );
			}
		};
		return this;
	}
	
	public DataTable<Item> bindSelectedRowNumber( ValueBinding<Integer> valueBinding ) {
		Bindings.bind( Bindings.obs( model ).get( DataTableModel_._clickedRowNumber ), valueBinding );
		return this;
	}
	
	/**
	 * Binds to a list of selected items. This works in both Single and Multiple selection modes. You however should not
	 * add multiple items to the bound list in Single selection mode.
	 * In Single selection mode, you'd probably prefer bindSingleSelection
	 */
	public DataTable<Item> bindSelection( ObservableValueBinding<? extends List<Item>> selection ) {
		new BidirectionalConvertingListBinder<Item, Integer>(
			selection, new SelectItemToIndexConverter(),
			Bindings.obs( model ).get( DataTableModel_._selectedIndices ) );
		return this;
	}
	
	public DataTable<Item> bindSelectionMode( ValueBinding<SelectionMode> selectionModeBinding ) {
		Bindings.bind( selectionModeBinding, Bindings.obs( model ).get( DataTableModel_._selectionMode ) );
		return this;
	}
	
	//	public DataTable<Item> bindSingleSelection
	
	/**
	 * Removes all selection
	 */
	public DataTable<Item> removeSelection() {
		model.getSelectedIndices().clear();
		return this;
	}
	
	protected DataTableRowModel renderRow( final Item item ) {
		DataTableRowModel rowModel = new DataTableRowModel();
		rowModel.getCells().addAll( Lists.transform( columns, new Function<Column<Item>, DataTableCellModel>() {
			
			@Override
			public DataTableCellModel apply( Column<Item> input ) {
				return input.getCellModel( item );
			}
		} ) );
		return rowModel;
	}
	
	public DataTable<Item> withSelectionMode( SelectionMode selectionMode ) {
		model.setSelectionMode( selectionMode );
		return this;
	}
	
	//	protected void bindEvent(ObservableProperty<? super DataTableModel, ComponentEvent> eventProperty, final EmptyEventHandler handler) {
	//		eventProperty.getValue(model).setHasListeners(true);
	//		Bindings.obs(model).get(eventProperty).get(ComponentEvent_._fired).addValueChangeListener(new ValueChangeListener<Boolean>() {
	//			@Override
	//			public void valueChanged(Boolean newValue) {
	//				if (newValue == true) {
	//					handler.handle();
	//				}
	//			}
	//		});
	//	}
	
}
