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

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) throws URISyntaxException, IOException {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		var loader = new FXMLLoader(getLocation("jfx", "web.fxml"));
		Parent parent = loader.load();

		primaryStage.setTitle("WebView Example");
		primaryStage.setScene(new Scene(parent));
		primaryStage.show();
	}

	private static URL getLocation(String... parts) {
		var path = Path.of("", parts).toString();
		return Main.class.getClassLoader().getResource(path);
	}
}