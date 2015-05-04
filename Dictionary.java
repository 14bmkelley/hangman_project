import java.util.Random;

class Dictionary {

	public static final int EASY = 0;
	public static final int MEDIUM = 1;
	public static final int HARD = 2;

	public static final String[] easyWords =
		{"java", "double", "event", "jpanel", "return", "static", "class", "while", "loop", "method", "cast", "super"};
	public static final String[] mediumWords =
		{"variable", "operator", "extends", "boolean", "protected", "interface", "override", "abstract", "modulus", "object"};
	public static final String[] hardWords =
		{"instantiate", "expression", "arraylist", "polymorphism", "conditional", "graphics", "actionlistener", "recursion", "package", "constructor"};
	
	private int randomIndex;

	public Dictionary() {
		
		randomIndex = new Random().nextInt(10);
		
	}
	
	public String getWord(int difficulty) {

		if (difficulty == EASY) {

			return easyWords[randomIndex];

		} else if (difficulty == MEDIUM) {

			return mediumWords[randomIndex];

		} else {

			return hardWords[randomIndex];

		}

	}

}
