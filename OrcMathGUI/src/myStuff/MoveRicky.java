package myStuff;

public class MoveRicky implements MoveInterfaceRicky {

	private ButtonRicky button;

	public MoveRicky(ButtonRicky button) {
		this.button=button;
	}

	@Override
	public ButtonInterfaceRicky getButton() {
		return button;
	}

}
