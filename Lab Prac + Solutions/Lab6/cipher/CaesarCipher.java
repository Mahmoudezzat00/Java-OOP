package cipher;

public class CaesarCipher {
	private int shift;

	public CaesarCipher(int shift) {
		this.shift = shift;
	}

	public String encrypt(String text) {
		char startChar = 'a';
		char endChar = 'z';
		int charCount = endChar - startChar + 1;

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); ++i)	{
			char origChar = text.charAt(i);
			if (startChar <= origChar && origChar <= endChar) {
				int charIdx = origChar - startChar;
				int newCharIdx = ((charIdx + shift) % charCount);
				char newChar = (char)(newCharIdx + startChar);
				sb.append(newChar);
			} else {
				sb.append(origChar);
			}
		}
		return sb.toString();
	}

	public String decrypt(String text) {
		return new CaesarCipher(-shift).encrypt(text);
	}
}