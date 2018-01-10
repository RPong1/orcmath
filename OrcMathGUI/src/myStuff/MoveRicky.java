package myStuff;

public class MoveRicky implements MoveInterfaceRicky {

	private ButtonInterfaceRicky button;

	public MoveRicky(ButtonInterfaceRicky button) {
		this.button = button;
	}

	@Override
	public ButtonInterfaceRicky getButton() {
		return button;
	}

}
