package com.doctusoft.dsw.sample.client.person;

import com.doctusoft.dsw.client.comp.BaseComponent;
import com.doctusoft.dsw.client.comp.Button;
import com.doctusoft.dsw.client.comp.Checkbox;
import com.doctusoft.dsw.client.comp.Container;
import com.doctusoft.dsw.client.comp.InplaceText;
import com.doctusoft.dsw.client.comp.Label;
import com.doctusoft.dsw.client.comp.Link;
import com.doctusoft.dsw.client.comp.ModalDialog;
import com.doctusoft.dsw.client.comp.PasswordField;
import com.doctusoft.dsw.client.comp.Repeat;
import com.doctusoft.dsw.client.comp.Textarea;
import com.doctusoft.dsw.client.comp.mvp.ContainerWithPresenter;
import com.doctusoft.dsw.sample.client.custom.CustomComponent;

public class PersonListView extends ContainerWithPresenter<PersonListActivity> {
	
	public PersonListView() {
		final Label label = new Label("Person list:");
		label.addStyleClass("heading");
		container.add(label);
		Repeat<PersonDto> repeat = new Repeat<PersonDto>() {
			@Override
			protected BaseComponent renderItem(PersonDto item,  int rowNum) {
				Container row = new Container();
				row.add(new Label("" + item.getId()));
				row.add(new Link(item.getName(), "#PersonDetailPlace:" + item.getId()));
				row.add(new Button("Delete").click(presenterMethod(PersonListActivity_.__deletePerson, item)));
				return row;
			}
		}.bind(bindOnPresenter().get(PersonListActivity_._personList));
		container.add(repeat);
		Button button = new Button();
		button.getModel().setCaption("Add person");
		button.click(presenterMethod(PersonListActivity_.__addPerson));
		button.addStyleClass("btn-primary");
		container.add(button);
		ModalDialog dialog = new ModalDialog();
		dialog.bindVisible(bindOnPresenter().get(PersonListActivity_._checked));
		
		container.add(dialog);
		
		Checkbox checkbox = new Checkbox();
		checkbox.bindLabel(bindOnPresenter().get(PersonListActivity_._checkboxLabel));
		checkbox.bindChecked(bindOnPresenter().get(PersonListActivity_._checked));
		container.add(checkbox);
		
		PasswordField passwordField = new PasswordField();
		passwordField.bind(bindOnPresenter().get(PersonListActivity_._password));
		
		container.add(passwordField);
		
		Button checkButton = new Button("check");
		checkButton.click(presenterMethod(PersonListActivity_.__checkBindings));
		container.add(checkButton);
		
		Textarea textarea = new Textarea(6);
		textarea.bind(bindOnPresenter().get(PersonListActivity_._textareaText));
		container.add(textarea);
		
		InplaceText inplaceText = new InplaceText();
		inplaceText.bind(bindOnPresenter().get(PersonListActivity_._inplaceTextLabel));
		container.add(inplaceText);
		
		dialog.getModel().setHeading("dialog heading");
		dialog.addContent(new Label("hello world"));
		
		dialog.addContent(new CustomComponent("custom component"));
		dialog.addFooter(new Button("Close"));
		
	}

}
