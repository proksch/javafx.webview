# Example usage of JavaFX WebView

This project illustrates how to use a [JavaFX WebView](https://openjfx.io/javadoc/23/javafx.web/javafx/scene/web/WebView.html) control,
how to load HTML content with it, and how to react with the controller to clicks in the loaded web page.
 
Assuming that you have [Maven](https://maven.apache.org/install.html) installed, you can run the project out-of-the-box from your terminal via

    mvn clean javafx:run

Running it within your IDE (Eclipse/IntelliJ) requires setting up OpenJFX.

First download (and unzip!) an [OpenJFX SDK](https://openjfx.io).
Make sure that the download *matches your Java JDK version*.

Then create a *run configuration* and add the following *VM* commands:

	--module-path="/path/to/javafx-sdk/lib"
	--add-modules=javafx.controls,javafx.fxml,javafx.web

Adjust the module path to your local download and make sure you adapt the path
to the `lib`(!) directory (not just the directory that you unzipped)...

*Tip:* Windows uses `\` to separate path elements.

*Tip:* Make sure not to forget the `/lib` at the end of the path

*Tip:* Double-check that the path is correct. If you receive abstract error messages, like `Module javafx.web not found`
or a segmentation fault, you are likely not pointing to the right folder
