
package com.doctusoft.dsw.client;

import org.junit.Test;

import com.doctusoft.dsw.client.comp.Button;
import com.xedge.jquery.client.JQuery;

public class TestButtonRenderer extends AbstractDswebTest {
	
	@Test
	public void testCaption() {
		final String initialCaption = "proba";
		Button button = new Button( initialCaption ).withId( "button" );
		registerApp( button );
		assertEquals( initialCaption, JQuery.select( "#button" ).text() );
		String changedCaption = "uj";
		button.getModel().setCaption( changedCaption );
		assertEquals( changedCaption, JQuery.select( "#button" ).text() );
	}
}
