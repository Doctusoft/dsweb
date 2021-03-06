package com.doctusoft.dsw.client;

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


import com.doctusoft.dsw.client.comp.model.BaseComponentModel;

public interface RendererFactory<ActualBaseComponent> {

	/**
	 * 
	 * @return null if no renderer was found
	 */
	public Renderer<ActualBaseComponent> resolveRenderer(BaseComponentModel baseWidget);

	/**
	 * 
	 * @throws RuntimeException if no renderer was found
	 */
	public Renderer<ActualBaseComponent> getRenderer(BaseComponentModel baseWidget);
	
	/**
	 * Marks the component as disposable, and 'hides' the rendered component. The rendered component and its renderer might still remaing cached until a GC run. 
	 */
	public void dispose(BaseComponentModel baseWidget);

	
	/**
	 * Removes the component from the disposables set 
	 */
	public void reattach(BaseComponentModel baseWidget);

}
