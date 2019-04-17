package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Page {
	
	private ArrayList<Button> buttons;
	private LinkedList<Field> fields;
	private HashSet<Label> labels;
	private HashMap<Integer, Dropdown> dropdowns;
	private float id;
	private String title;

	public Page() {
	}

	public Page(ArrayList<Button> buttons, LinkedList<Field> fields, HashSet<Label> labels,
			HashMap<Integer, Dropdown> dropdowns, float id, String title) {
		this.buttons = buttons;
		this.fields = fields;
		this.labels = labels;
		this.dropdowns = dropdowns;
		this.id = id;
		this.title = title;
	}

	public ArrayList<Button> getButtons() {
		return buttons;
	}

	public void setButtons(ArrayList<Button> buttons) {
		this.buttons = buttons;
	}

	public LinkedList<Field> getFields() {
		return fields;
	}

	public void setFields(LinkedList<Field> fields) {
		this.fields = fields;
	}

	public HashSet<Label> getLabels() {
		return labels;
	}

	public void setLabels(HashSet<Label> labels) {
		this.labels = labels;
	}

	public HashMap<Integer, Dropdown> getDropdowns() {
		return dropdowns;
	}

	public void setDropdowns(HashMap<Integer, Dropdown> dropdowns) {
		this.dropdowns = dropdowns;
	}

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void addButton(Button button) {
		buttons.add(button);
	}

	public void deleteButton(Button button) {
		buttons.remove(button);
	}

	public void replaceButton(int oldButtonIndex, Button newButton) {
		try {
			buttons.set(oldButtonIndex, newButton);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(String.format("The passed index %s doesn't exist in the collection", oldButtonIndex));
		}
	}

	public void printButtons() {
		System.out.println(buttons);
	}

	public void addField(Field field) {
		fields.add(field);
	}

	public void deleteField(Field field) {
		fields.remove(field);
	}

	public void replaceField(int oldFieldIndex, Field newField) {
		try {
			fields.set(oldFieldIndex, newField);
		} catch (IndexOutOfBoundsException ex) {
			System.out.println(String.format("The passed index %s doesn't exist in the collection", oldFieldIndex));
		}
	}

	public void printFields() {
		System.out.println(fields);
	}

	public void addLabel(Label label) {
		labels.add(label);
	}

	public void deleteLabel(Label label) {
		labels.remove(label);
	}

	public void replaceLabel(Label oldLabel, Label newLabel) {
		deleteLabel(oldLabel);
		addLabel(newLabel);
	}

	public void printLabels() {
		System.out.println(labels);
	}

	public void addDropdown(int key, Dropdown dropdown) {
		dropdowns.put(key, dropdown);
	}

	public void deleteDropdown(int key, Dropdown dropdown) {
		dropdowns.remove(key, dropdown);
	}

	public void replaceDropdown(int key, Dropdown dropdown) {
		dropdowns.replace(key, dropdown);
	}

	public void printDropdowns() {
		System.out.println(dropdowns);
	}

}
