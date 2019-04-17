package src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Example {

	public static void main(String[] args) {
		
		Button loginButton = new Button("Click", "HP");
		Button logoutButton = new Button("Click", "ClickClickClick");
		Button registerButton = new Button("Clickr", "ClickClickClickClickClick");

		Field usernameField = new Field(1, "wefwef");
		Field passwordField = new Field(2, "rewfwef");
		Field searchField = new Field(3, "wefjkgwyeugnvoiufhv");

		Label userNameLabel = new Label("UClickClickClick");
		Label passwordLabel = new Label("PClickClickClick");
		Label searchLabel = new Label("SClickClickClickh");

		List<String> countries = new ArrayList<String>();
		countries.add("SJKEh");
		countries.add("Itwefwefewf");
		countries.add("Cfwefwefwefa");
		countries.add("Hhhhh");
		countries.add("Bwehfwhebfjhwebf");

		List<String> edededs = new ArrayList<String>();
		edededs.add("One");
		edededs.add("Two");
		edededs.add("Three");

		Dropdown countriesDropdown = new Dropdown(countries, true, "Jefefwefws");
		Dropdown monthsDropdown = new Dropdown(edededs, true, "JefefwefwsJefefwefws");

		ArrayList<Button> buttons = new ArrayList<Button>();
		buttons.add(loginButton);
		buttons.add(logoutButton);

		LinkedList<Field> fields = new LinkedList<Field>();
		fields.add(passwordField);
		fields.add(usernameField);

		HashSet<Label> labels = new HashSet<Label>();
		labels.add(passwordLabel);
		labels.add(searchLabel);

		HashMap<Integer, Dropdown> dropdowns = new HashMap<Integer, Dropdown>();
		dropdowns.put(222, monthsDropdown);

		Page age = new Page(buttons, fields, labels, dropdowns, 1, "Home page");

		Page.addButton(registerButton);
		Page.addField(searchField);
		Page.addLabel(userNameLabel);
		Page.addDropdown(111, countriesDropdown);

		Page.deleteButton(registerButton);
		Page.deleteField(searchField);
		Page.deleteLabel(userNameLabel);
		Page.deleteDropdown(1, countriesDropdown);

		Page.replaceButton(1, registerButton);
		Page.replaceField(1, searchField);
		Page.replaceLabel(passwordLabel, userNameLabel);
		Page.replaceDropdown(222, countriesDropdown);

	}

}
