public class Cipher {
	private String plaintext;

	public Cipher(String text) {
		plaintext = text;
	}

	public String getAnalyserText() {
		return plaintext;
	}

	public void setAnalyserText(String text) {
		plaintext = text;
	}

	public String caesarShift(int shift) {
		String ciphertext = "";
		for(int i = 0; i < plaintext.length(); i++) {
			char cipherChar = plaintext.charAt(i);
			if(Character.isLetter(cipherChar)) {
				cipherChar += shift;
				if(cipherChar < 'a') {
					cipherChar += 26;
				}
				if(cipherChar > 'z') {
					cipherChar -= 26;
				}
			}

			ciphertext += cipherChar;
		}

		return ciphertext;
	}

	public String vigenereCipher(String key) {
		String ciphertext = "";
		int j = 0;
		for(int i = 0; i < plaintext.length(); i++) {
			char cipherChar = plaintext.charAt(i);
			if(Character.isLetter(cipherChar)) {
				char shift = key.charAt(j % key.length());
				shift -= 'a';
				cipherChar += shift;
				if(cipherChar < 'a') {
					cipherChar += 26;
				}
				if(cipherChar > 'z') {
					cipherChar -= 26;
				}
				j++;
			}

			ciphertext += cipherChar;
		}

		return ciphertext;
	}
}
