package com.doctusoft.dsw.mvp.client;

/*
 * #%L
 * dsweb-mvp
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


import lombok.Getter;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;

public class GwtPlaceControllerWrapper implements IPlaceController {
	
	@Getter
	private PlaceController placeController;

	public GwtPlaceControllerWrapper(PlaceController placeController) {
		this.placeController = placeController;
	}
	
	@Override
	public void goTo(Place newPlace) {
		placeController.goTo(newPlace);
	}

}
