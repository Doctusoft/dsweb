package com.doctusoft.dsw.sample.client.showcase;

import java.io.Serializable;

import lombok.Getter;

import com.doctusoft.dsw.mvp.client.ViewOf;
import com.doctusoft.dsw.sample.client.ClientFactory;

public class ShowcaseInputsActivity extends com.doctusoft.dsw.client.mvp.AbstractPresenter<ShowcaseInputsActivity>{

	@Getter
	private ViewOf<ShowcaseInputsActivity> view;
	
	public ShowcaseInputsActivity(Place place, ClientFactory clientFactory ) {
		view = clientFactory.getShowcaseInputsView();
	}
	
	public static class Place extends com.doctusoft.dsw.client.mvp.AbstractPlace<ShowcaseInputsActivity> implements Serializable {
		public Place() {
			super("showcaseinputs", ShowcaseInputsActivity.class );
		}
	}

}
