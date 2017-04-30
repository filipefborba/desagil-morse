public class Mor {
public static void main(String[] args) 
{

    Scanner input = new Scanner(System.in); 
    System.out.println("Type 1 for text to morse, 0 from morse to text."); 
    String myChoice = input.nextLine(); 
    System.out.println("Type what you want to decode/encode ");
    String userMessage = input.nextLine();
    System.out.println("");

if("1".equals(myChoice)){
 System.out.println(toMorse(userMessage));}
//else{
//     System.out.println(fromMorse(userMessage));
}

}

public static String toMorse(String userMessage)
{
    String s = userMessage;
        System.out.printf("Message: %s\n", s);

        String message = "";



        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String[] morseAlphabet = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",  
        "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", 
        "...-", ".--", "-..-", "-.--", "--.."};


        for (char alphabetLetter : usermessage.toCharArray())
        {
           int index = -1;
           String letter = " ";
            for (int i = 0; i < alphabet.length(); i++)
                {
                    if (alphabet.charAt(i) == alphabetLetter)
                        {
                        index = i;
                        }
                }
            if (index >=0)
                {
                    letter = morseAlphabet[index];
                }
            message += letter + " ";
        }
       System.out.printf("Message: %s\n", message);

    return message;


}
}