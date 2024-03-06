package controller.textual;

import view.textual.TextPrinter;

public abstract class AbstractTextController {
	TextPrinter printer;

	abstract void update_printer();

	public void update_and_display() {
		update_printer();
		printer.display_on_out();
	}

	public TextPrinter get_printer() {
		return printer;
	}
}
