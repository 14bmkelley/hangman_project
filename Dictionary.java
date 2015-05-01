

class Dictionary {

	public static final int EASY = 0;
	public static final int MEDIUM = 1;
	public static final int HARD = 2;

	public static String getWord(int difficulty) {

		if (difficulty == EASY) {

			return "java";

		} else if (difficulty == MEDIUM) {

			return "variable";

		} else {

			return "instantiate";

		}

	}

}
