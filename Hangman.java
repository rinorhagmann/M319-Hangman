import java.util.*;
import java.util.concurrent.TimeUnit;

public class Hangman {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String word="";
        String m = "";
        while(true){
            //loop while no exit in menu
            clearScreen();
            Menu(sc, m);
            if(m.equals("e")){
                //checks if exit
                break;
            }
            word = preparation();
            clearScreen();
            game(word, sc);
        }
        sc.close();
    }
    public static String Menu(Scanner sc, String m){
        //shows menu
        String output = "";
        do{
            clearScreen();
            
            System.out.println("\u001B[38;2;249;132;74m||  ||    //\\\\    ||\\\\  ||  //¯¯¯¯  ||\\\\  //||    //\\\\    ||\\\\  ||");
            System.out.println("||__||   //__\\\\   || \\\\ || ||       || \\\\// ||   //__\\\\   || \\\\ ||");
            System.out.println("||  ||  //    \\\\  ||  \\\\|| || ¯¯¯\\\\ ||      ||  //    \\\\  ||  \\\\||");
            System.out.println("||  || //      \\\\ ||   \\||  \\\\___// ||      || //      \\\\ ||   \\||");
            System.out.println("\u001B[0m\n\n\n");
            System.out.println("\u001B[38;2;88;129;87m                ╔══════════════════╗");
            System.out.println("                ║     Play (p)     ║");
            System.out.println("                ╚══════════════════╝\u001B[0m");
            System.out.println("\u001B[38;2;255;195;0m                ╔══════════════════╗");
            System.out.println("                ║ Instructions (i) ║");
            System.out.println("                ╚══════════════════╝\u001B[0m");
            System.out.println("\u001B[38;2;106;4;15m                ╔══════════════════╗");
            System.out.println("                ║     Exit (e)     ║");
            System.out.println("                ╚══════════════════╝\u001B[0m");
            //looks for the input
            System.out.println(output);
            m = sc.nextLine();
            if(m.equals("p")){
                output="";
                break;
            }
            else if(m.equals("i")){
                output="";
                instructions(sc, m);
                continue;
            }
            else if(m.equals("e")){
                output="";
                System.exit(0);
            }
            else {
                output="Invalid input: Please select p/e.";
            }
        }
        while (true);
        //loop while no asked input
        return m;
    }
    public static void instructions(Scanner sc, String m){
        while (!m.equals("b")) {
            clearScreen();
            System.out.println("\u001B[1m Instructions\u001B[0m \n\n - Type p/e to play/exit\n - Type a letter after the other to find out the word\n - Press enter after input\n - If you type more than one character, it counts as word\n - If you fail 9 times, you loose\n - The words are only in english!!\n");
            System.out.println("Type 'b' to go to the menu.\n");
            m=sc.nextLine();
        
            //looks for the input
            if(!m.equals("b")){
                System.out.println("Invalid input: Please select b.");
            }
        }
            
        //loop while no asked input
    }

    public static String preparation() {
        Random rand = new Random();
        String[] words = {
            // A
            "acorn", "airplane", "artist", "astronaut", "autumn",
            "audience", "award", "awareness", 
            // B
            "backpack", "balance", "banana", "bandage", "baseball",
            "basket", "bathroom", "battery", "beach", "bear","bike", "big",
            // C
            "cabinet", "cake", "calculator", "calendar", "camera",
            "candle", "candy", "canoe", "cap", "captain",
            // D
            "dance", "dancer", "daydream", "decoration", "dentist",
            "desert", "desk", "diary", "dictionary", "dinner",
            // E
            "eagle", "earphone", "earthquake", "east", "elbow",
            "elevator", "emotion", "energy", "engineer", "envelope",
            // F
            "factory", "fairytale", "family", "fan", "farm", "french",
            "fashion", "feather", "festival", "fireworks", "fish", "fabulous",
            // G
            "gadget", "galaxy", "game", "garden", "garlic",
            "gate", "gear", "gecko", "gift", "giraffe",
            // H
            "habit", "hairbrush", "haircut", "hamburger", "hammer",
            "handkerchief", "happiness", "harbor", "harmony", "hat",
            // I
            "icecream", "imagination", "insect", "instrument", "island", "inducing",
            "ipod", "iron", "invitation", "island", "joke",
            // J
            "jacket", "jam", "jelly", "jeopardy", "jewelry", "justice",
            "jogging", "joke", "journalist", "journey", "juice",
            // K
            "kangaroo", "kayak", "kettle", "keyboard", "kite",
            "kitten", "knife", "knob", "knowledge", "koala","know",
            // L
            "label", "ladybug", "lake", "lamp", "landscape",
            "language", "laptop", "laugh", "laundry", "lawn","letter",
            // M
            "machine", "magazine", "magnet", "mailbox", "makeup", "mathematics",
            "map", "marble", "march", "market", "mask","make", "meet",
            // N
            "napkin", "necklace", "needles", "nest", "net",
            "newspaper", "nightingale", "notebook", "number", "nut",
            // O
            "oasis", "oatmeal", "octopus", "office", "oil", "old",
            "olive",  "onion", "opera", "orange", "orbit", "opinion",
            // P
            "package", "paint", "panda", "pancake", "pantry",
            "paper", "parade", "parent", "park", "parachute",
            // Q
            "quack", "quilt", "quiver", "quotation", "quilt", 
            // R
            "rabbit", "race", "racket", "radar", "radio", "random", "russia",
            "raft", "raincoat", "rainbow", "rake", "ravioli", "raise",
            // S
            "sandwich", "satellite",  "scepter", "scissors", "scooter",
            "scout", "screen", "seafood", "seashell", "season","sigma","swim",
            // T
            "table", "tablet", "tail", "talent", "tape", "take",
            "teacher", "team", "telephone", "telescope", "temple",
            // U
            "umbrella", "uniform", "unicorn", "university", "upset",
            // V
            "vacation", "valley", "value", "van", "vase",
            "vegetable", "vehicle", "veil", "verse", "vessel",
            // W
            "wagon", "waistcoat", "waiter", "walkway", "wall",
            "wallet", "wallpaper", "walnut", "warmth", "waterfall",
            // X
            "xylophone", 
            // Y
            "yak", "yarn", "yeast", "yogurt", "yo-yo",
            // Z
            "zebra", "zigzag", "zipper", "zone", "zoo",
        };
        //chooses a random word of the list
        int index = rand.nextInt(words.length);
        return words[index];
    }

    public static void game(String word, Scanner sc){
        char[] guesslist = new char[word.length()];
        List<Integer> indices = new ArrayList<>();
        List<String> guess = new ArrayList<>();
        Integer index;
        String input;
        int position;
        String guessword;
        int failedguess = 0;
        boolean check = false;        
        char[] letter = new char[word.length()];
        long start = System.currentTimeMillis();
        long end = 0;
        while(true){
            
            System.out.print("\nAlready guessed: ");
            //gives a list of already guessed letters and words
            for(int i = 0;i<guess.size();i++){
                System.out.print(guess.get(i)+", ");
            }
            //output the sectret word
            System.out.println("\nAmount of characters in word :"+word.length());
            System.out.println("\n\n");
            for(int i = 0;i<word.length();i++){
                if(guesslist[i] != '\u0000'/*null*/){
                    //letter that shows is the letter that is guessed
                    letter[i] = guesslist[i];
                    continue;
                }
                letter[i] = '─';
            }
            for(int i = 0;i<letter.length;i++){
                System.out.print(letter[i]+" ");
            }
            System.out.print("\n\n");
            hangman(failedguess);
            System.out.print("\n");

            input = sc.nextLine();
            //is input 1 character long and not null
            for(String s : guess){
                if(input.equals(s)){
                    check = true;
                }
            }
            if (!check) {
                if (input != null && input.length()==1) {
                    if (word.indexOf(input)>= 0) {
                        
                        index = word.indexOf(input);
                    
                        while (index >= 0) {
                            indices.add(index);
                            index = word.indexOf(input, index+1);
                        }
                        for(int i = 0;i<indices.size();i++){
                            position = indices.get(i);
                            guesslist[position] = input.charAt(0);
                        }
                        indices.clear();
                        index = null;
                    }
                    else{
                        failedguess++;
                    }
                }
                else if(input.isEmpty()){
                    clearScreen();
                    continue;
                }
                else if(input.equals(word)){
                    System.out.println("You found it! It was: "+ word);
                    end=System.currentTimeMillis();
                    break;
                }
                else{
                    System.out.println("No! It isn't "+input);
                    failedguess++;
                }   
                guess.add(input);
            }
            else{
                clearScreen();
                check=false;
                System.out.println("You've already guessed it!!");
                continue;
            }
            
            
            
            guessword = String.valueOf(guesslist);
            if (guessword.equals(word)) {
                System.out.println("You found it! It was: "+word);
                end=System.currentTimeMillis();
                break;
            }
            
            if(failedguess>=9){
                clearScreen();
                hangman(failedguess);
                System.out.println("\nOh no! You didn't do it.");
                System.out.println("The word was: "+word);
                end=System.currentTimeMillis();
                break;
            }
            clearScreen();
            check=false;
        }
        long time=(end-start)/1000;
        System.out.printf("\n\n\nTime played: %d s%nAmount of guesses: %d%nAmount of failed guesses: %d%n", time, guess.size(), failedguess);
        System.out.println("\n\u001B[38;2;106;4;15mPlease wait and don't press anything till the menu comes!\u001B[0m");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
            // Handle the exception (e.g., clean up resources, restore the interrupted status, etc.)
        }
        
        
    }
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
    public static void hangman(int failedguess) {
		if (failedguess == 1) {
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (failedguess == 2) {
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (failedguess == 3) {
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (failedguess == 4) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\ ");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (failedguess == 5) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
        if (failedguess == 6) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          /  ");
			System.out.println("___|___      /   ");
		}
		if (failedguess == 7) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
        if (failedguess == 8) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|");
			System.out.println("   |         / | ");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (failedguess == 9) {
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /   \\");
			System.out.println("   |        |     |");
			System.out.println("   |         \\_ _/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
        }
            
            
	}
}