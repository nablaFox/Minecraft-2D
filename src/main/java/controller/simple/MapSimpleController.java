package controller.simple;

import data.model.Map;
import utils.MapCoordinates;
import view.gui.MapPane;

public class MapSimpleController implements SimpleController {
	Map map;
	MapPane map_pane;

	public MapSimpleController(Map map, MapPane map_pane) {
		this.map = map;
		this.map_pane = map_pane;
		redraw();
	}

	public void redraw() {
		map_pane.getChildren().clear();
		for (int i = 0; i < MapCoordinates.DIMENSION_ROWS; i++) {
			for (int j = 0; j < MapCoordinates.DIMENSION_COLUMNS; j++) {
				final MapCoordinates coords = new MapCoordinates(j, i);
				map_pane.set_cell(
						coords,
						map.get_block(coords));
			}
		}
	}
}
