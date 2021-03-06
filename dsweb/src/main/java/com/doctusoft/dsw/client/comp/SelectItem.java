package com.doctusoft.dsw.client.comp;

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


import java.io.Serializable;

import lombok.Data;

@Data
public class SelectItem<T> implements Serializable {
	
	/**
	 * This id will be rendered as name attribute of the option element.
	 * You don't necessarily need this, but if you plan Selenium tests, you should better fill them :)
	 * Nb: the internals of the Select component don't rely on this value - it's index based.
	 */
	private String id;
	
	/**
	 * This will be displayed on the screen for the user
	 */
	private String caption;
	
	/**
	 * This is the value that will be bound to your data model
	 */
	private T value;

}
