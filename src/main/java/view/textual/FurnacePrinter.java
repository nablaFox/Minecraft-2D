package view.textual;

import data.blocks.interfaces.SmeltableBlock;

public class FurnacePrinter implements TextPrinter {
	private SmeltableBlock furnace_input;
	private SmeltableBlock furnace_output;

	public void update(SmeltableBlock input, SmeltableBlock output) {
		furnace_input = input;
		furnace_output = output;
	}

	public void display_on_out() {
		System.out.println("|| " + furnace_input.display() + " --> " + furnace_output.display() + " ||");
	}
}
