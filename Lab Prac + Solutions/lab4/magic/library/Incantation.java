package magic.library;

public class Incantation {
	private String text;
	private int index;

	public Incantation(String text, int index) {
		if (text == null)    throw new IllegalArgumentException();

		this.text = text;
		this.index = index;
	}

	public Incantation(Incantation other) {
		text = other.text;
		index = other.index;
	}

	public String getText() {
		return text;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public boolean enchant(Incantation other, boolean isPrepend) {
		String[] parts = text.split(" ");

		if (index < 1 || index > parts.length)  return false;

		String word = parts[index-1];
		String pre = isPrepend ? word + " " : "";
		String post = isPrepend ? "" : " " + word;
		other.text = pre + other.text + post;

		index += isPrepend ? -1 : 1;

		return true;
	}
}
