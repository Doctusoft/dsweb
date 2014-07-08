package com.doctusoft.dsw.sample.client.person;

import java.util.List;

import com.doctusoft.bean.binding.observable.ObservableList;
import com.doctusoft.dsw.client.comp.Button;
import com.doctusoft.dsw.client.comp.InputTags;
import com.doctusoft.dsw.client.comp.PaginationItem;
import com.doctusoft.dsw.client.comp.SelectItem;
import com.doctusoft.dsw.client.comp.Typeahead;
import com.doctusoft.dsw.client.comp.mvp.ContainerWithPresenter;

public class SandboxView extends ContainerWithPresenter<SandboxActivity> {
	
	private Typeahead<Long> typeahead;

	public SandboxView() {
		SelectItem<Long> selectItem = new SelectItem<Long>();
		selectItem.setCaption("ad");
		selectItem.setValue(new Long(42));
		SelectItem<Long> selectItem2 = new SelectItem<Long>();
		selectItem2.setCaption("asd");
		selectItem2.setValue(new Long(43));
		SelectItem<Long> selectItem3 = new SelectItem<Long>();
		selectItem3.setCaption("blip");
		selectItem3.setValue(new Long(44));
		SelectItem<Long> selectItem4 = new SelectItem<Long>();
		selectItem4.setCaption("Nagybetá");
		selectItem4.setValue(new Long(45));
		
		
//		Select<Long> s = new Select<Long>();
//		container.add(s);
		
//		typeahead = new Typeahead<Long>(true);
//		typeahead.bind(bindOnPresenter().get(PersonListActivity_._person).get(PersonDto_._id));
//		container.add(typeahead);
		
		InputTags tags = new InputTags();
		tags.bind(bindOnPresenter().get(SandboxActivity_._tags));
//		tags.bind(bindOnPresenter().get(PersonListActivity_._person).get(PersonDto_._someList));
		tags.appendTo(container);
		
//		final Label label = new Label("Person list:");
//		label.addStyleClass("heading");
//		container.add(label);
//		Repeat<PersonDto> repeat = new Repeat<PersonDto>() {
//			@Override
//			protected BaseComponent renderItem(PersonDto item,  int rowNum) {
//				Container row = new Container();
//				row.add(new Label("" + item.getId()));
//				row.add(new Link(item.getName(), "#PersonDetailPlace:" + item.getId()));
//				row.add(new Button("Delete").click(presenterMethod(PersonListActivity_.__deletePerson, item)));
//				return row;
//			}
//		}.bind(bindOnPresenter().get(PersonListActivity_._personList));
//		container.add(repeat);
//		Button button = new Button();
//		button.getModel().setCaption("Add person");
//		button.click(presenterMethod(PersonListActivity_.__addPerson));
//		button.addStyleClass("btn-primary");
//		container.add(button);
//		ModalDialog dialog = new ModalDialog();
//		dialog.bindVisible(bindOnPresenter().get(PersonListActivity_._checked));
//		
//		container.add(dialog);
//		
//		Checkbox checkbox = new Checkbox();
//		checkbox.bindLabel(bindOnPresenter().get(PersonListActivity_._checkboxLabel));
//		checkbox.bindChecked(bindOnPresenter().get(PersonListActivity_._checked));
//		container.add(checkbox);
//		
//		PasswordField passwordField = new PasswordField();
//		passwordField.bind(bindOnPresenter().get(PersonListActivity_._password));
//		
//		container.add(passwordField);
//		
		Button checkButton = new Button("check");
		checkButton.click(presenterMethod(SandboxActivity_.__checkBindings));
		container.add(checkButton);
//		
//		Textarea textarea = new Textarea(6);
//		textarea.bind(bindOnPresenter().get(PersonListActivity_._textareaText));
//		container.add(textarea);
//		
//		InplaceText inplaceText = new InplaceText();
//		inplaceText.bind(bindOnPresenter().get(PersonListActivity_._inplaceTextLabel));
//		container.add(inplaceText);
//		
//		dialog.getModel().setHeading("dialog heading");
//		dialog.addContent(new Label("hello world"));
//		
//		dialog.addContent(new CustomComponent("custom component"));
//		dialog.addFooter(new Button("Close"));
//		
//		DropdownButton buttonDropdown = new DropdownButton("Button Dropdown").
//				addLink(new Link("asd","http://www.tehcute.com/pics/201201/Pug-wants-cookie.jpg"))
//				.addLink(new Link("blup", new EmptyEventHandler() {
//					@Override
//					public void handle() {
//						System.out.println("blup");
//					}
//				}));
//		
//		DropdownLink menuDropdown = new DropdownLink("Button Dropdown").
//				addLink(new Link("asd","http://www.tehcute.com/pics/201201/Pug-wants-cookie.jpg"))
//				.addLink(new Link("blup", new EmptyEventHandler() {
//					@Override
//					public void handle() {
//						System.out.println("blup");
//					}
//				}));
//		
//		Select<Long> select = new Select<Long>();
//		select.setSelectItems(Lists.newArrayList(selectItem, selectItem2));
//		select.bind(bindOnPresenter().get(PersonListActivity_._selectValue));
//		container.add(select);
//		
//		container.add(buttonDropdown);
//		
//		container.add(new Navs()
//			.addMenuItem(new Link("Dirr","#"))
//			.addMenuItem(new Link("Durr","#"))
//			.addDropdownItem(menuDropdown)
//			.setType(NavsItemType.Pills)
//		);
//		
//		container.add(new Navs(true)
//			.addMenuItem(new Link("Dirr","#"))
//			.addMenuItem(new Link("Durr","#"))
//			.addDropdownItem(menuDropdown)
//			.setType(NavsItemType.Pills)
//		);
//		
//		container.add(new Navbar("Title")
//			.addMenuItem(new Link("Blip","#"))
//			.addMenuItem(new Link("Blup","#"))
//			.addDropdownItem(menuDropdown)
//		);
//		
//		container.add(new ButtonGroup()
//			.addButton(new Button("^_^"))
//			.addButton(new Button("\\o/"))
//			.addButton(new Button(",,(O_O),,"))
//		);
//		
//		container.add(new Alert("Hádevigyázzá!"));
//		
////		container.add(new Alert("Többsoros is megy!","Achtung tesó!").setDisplayType(AlertDisplayType.TwoLine).setAlertType(AlertType.Success));
//		
//		container.add(new ProgressBar());
//		
//		ProgressBar boundBar = new ProgressBar().setType(ProgressBarType.StripedActive);
//		boundBar.bind(bindOnPresenter().get(PersonListActivity_._progress));
//		container.add(boundBar);
//		
////		container.add(new Pagination().setPaginationItems(generatePaginationItems()));
//		
//		InputTags inputTags = new InputTags();
////		inputTags.bind(bindOnPresenter().get(PersonListActivity_._tags));
//		container.add(inputTags);

		Button removeTagButton = new Button("Remove tag");
		removeTagButton.click(presenterMethod(SandboxActivity_.__removeTag));
		container.add(removeTagButton);
		
		Button addTagButton = new Button("Add tag");
		addTagButton.click(presenterMethod(SandboxActivity_.__addTag));
		container.add(addTagButton);
//		
//		new Icon(BootstrapIcon.ICON_REMOVE).appendTo(container);
	}
	
	private List<PaginationItem> generatePaginationItems() {
		List<PaginationItem> paginationItems = com.google.common.collect.Lists.newArrayList();
		PaginationItem paginationItem = new PaginationItem();
		paginationItem.setSeq(1);
		paginationItems.add(paginationItem);
		paginationItem = new PaginationItem();
		paginationItem.setSeq(2);
		paginationItems.add(paginationItem);
		paginationItem = new PaginationItem();
		paginationItem.setSeq(3);
		paginationItems.add(paginationItem);
		paginationItem = new PaginationItem();
		paginationItem.setSeq(4);
		paginationItems.add(paginationItem);
		return paginationItems;
	}
	
	@Override
	public void viewPresented() {
		ObservableList<SelectItem<Long>> selectItems = getPresenter().getLocationItems();
//		typeahead.setSelectItems(selectItems);
	}
	
	

}