/*
 * Copyright 2021 Delft University of Technology
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jfx;

import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;

public class Controller {

	@FXML
	private Label label;

	@FXML
	private Button btn;

	@FXML
	private TextArea text;

	@FXML
	private WebView webview;

	public void updateHtml() {
		var e = webview.getEngine();

		// you can embed CSS formatting directly in the HTML or point to a local file
		// e.setUserStyleSheetLocation("file:///path/to/your/formats.css");

		var curText = text.getText();
		e.loadContent(curText);

		// wait for the page loading to complete
		e.getLoadWorker().stateProperty().addListener((obs, oldState, newState) -> {
			if (newState == Worker.State.SUCCEEDED) {
				var window = (JSObject) e.executeScript("window");
				// make `this` available in JS with the name `ctrl`
				window.setMember("ctrl", this);
			}
		});
	}

	public void buttonClicked() {
		// You can register on-click calls like `java.htmlClick`. These use
		// 1) the name under which `this` has been made available before
		// 2) one of its methods.
		text.setText("<h1>How to register for clicks ...</h1>\n" //
				+ "<p>You can subscribe to click events and call methods on the previously assigned bridge object (with and without parameters):</p>\n" //
				+ "<a href=\"#\" onclick=\"ctrl.htmlClick('Link 1')\">one</a>\n" //
				+ "<a href=\"#\" onclick=\"ctrl.htmlClick2()\">two</a>\n" //
				+ "<p>This also works for buttons:</p>\n" //
				+ "<button onclick=\"ctrl.htmlClick(3)\">three</button>\n" //
				+ "<p>Try it! Clicking an element will set the label.</p>");
		text.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED, "", "", KeyCode.A, false, false, false, false));
	}

	public void setLabel(String s) {
		label.setText("Last clicked: " + s);
	}

	// You can use arbitrary method names and (optionally) introduce parameters
	public void htmlClick(String s) {
		setLabel(s);
	}

	public void htmlClick2() {
		setLabel("Clicked2");
	}
}