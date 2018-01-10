package myStuff;

public class MoveRicky implements MoveInterfaceRicky {

	private ButtonInterfaceRicky button;

	public MoveRicky(ButtonInterfaceRicky buttonI) {
		this.button = buttonI;
	}

	@Override
	public ButtonInterfaceRicky getButton() {
		return button;
	}

}
