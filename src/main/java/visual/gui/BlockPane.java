package visual.gui;

import data.blocks.interfaces.Block;
import data.blocks.utils.BlockComparator;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BlockPane extends StackPane {
	private Block block;
	private Text text;
	private Rectangle bg;

	public static final int DIM_SQUARE = 50;
	private static final String FONT_NAME = "Verdana";
	private static final int FONT_SIZE = 18;
	private static final FontWeight FONT_WEIGHT = FontWeight.BOLD;
	private static final Color BLOCK_BORDER = Color.BLACK;
	private static final Color FONT_FILL = Color.BLACK;
	private static final Color FONT_BORDER = Color.BLACK;

	public BlockPane(Block block) {
		super();
		this.block = block;
		init();
	}

	public void init() {
		bg = new Rectangle(DIM_SQUARE, DIM_SQUARE);
		bg.setFill(chooseColorFromBlock(block));
		bg.setStroke(BLOCK_BORDER);

		text = new Text("" + block.display());
		text.setFont(Font.font(FONT_NAME, FONT_WEIGHT, FONT_SIZE));
		text.setFill(FONT_FILL);
		text.setStroke(FONT_BORDER);

		getChildren().addAll(bg, text);
		setAlignment(Pos.CENTER);
	}

	public void change_block(Block block) {
		this.block = block;
		text.setText("" + block.display());
	}

	private Color chooseColorFromBlock(Block block) {
		int int_of_block = BlockComparator.get_value_of_block(block);
		Color col = null;
		switch (int_of_block) {
			case 0:
				col = Color.BLACK;
				break;
			case 1:
				col = Color.WHITE;
				break;
			case 2:
				col = Color.AQUA;
				break;
			case 3:
				col = Color.GREEN;
				break;
			case 4:
				col = Color.BEIGE;
				break;
			case 5:
				col = Color.AZURE;
				break;
			case 6:
				col = Color.DARKGRAY;
				break;
			case 7:
				col = Color.SILVER;
				break;
		}
		return col;
	}
}
