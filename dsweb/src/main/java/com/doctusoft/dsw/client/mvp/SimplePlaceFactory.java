package com.doctusoft.dsw.client.mvp;

public class SimplePlaceFactory implements PlaceFactory {
	
	@Override
	public <P extends Presenter<P>> Place<P> createPlaceForClass(Class<? extends Place<?>> placeClass) {
		try {
			return (Place<P>) placeClass.newInstance();
		} catch (Exception e) {
			throw new RuntimeException("Exception creating place: " + placeClass);
		}
	}

}
