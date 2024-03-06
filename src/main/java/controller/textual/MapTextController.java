package controller.textual;

import view.textual.MapPrinter;
import data.model.Map;

public class MapTextController extends AbstractTextController {
	Map map;

	public MapTextController(Map map) {
		super();
		this.printer = new MapPrinter();
		this.map = map;
	}

	public void update_printer() {
		((MapPrinter) printer).update(map.get_content());
	}
}
