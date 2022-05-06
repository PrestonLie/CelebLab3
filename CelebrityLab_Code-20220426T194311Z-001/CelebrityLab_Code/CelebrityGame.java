import java.util.ArrayList;
import java.lang.Math;
/**
 * The framework for the Celebrity Game project
 * 
 * @author cody.henrichsen
 * @version 2.3 25/09/2018 refactored the prepareGame and play methods
 */
public class CelebrityGame
{
	/**
	 * A reference to a Celebrity or subclass instance.
	 */

	/**
	 * The GUI frame for the Celebrity game.
	 */

	/**
	 * The ArrayList of Celebrity values that make up the game
	 */
	public ArrayList<Celebrity> celebGameList = new ArrayList<Celebrity>();
	public Celebrity gameCelebrity;
	public CelebrityFrame gameWindow;
	/**
	 * Builds the game and starts the GUI
	 */
	public CelebrityGame()
	{
		celebGameList = new ArrayList<Celebrity>();
		gameWindow = new CelebrityFrame(this);
	}

 /**
   * Prepares the game to start by re-initializing the celebGameList and having the gameFrame open the start screen.
   */
  public void prepareGame()
  {
    celebGameList = new ArrayList<Celebrity>();
    gameWindow.replaceScreen("START");
  }

	/**
	 * Determines if the supplied guess is correct.
	 * 
	 * @param guess
	 *            The supplied String
	 * @return Whether it matches regardless of case or extraneous external
	 *         spaces.
	 */
	public boolean processGuess(String guess)
	{
		return guess.trim().equalsIgnoreCase(gameCelebrity.getName());
	}
  /**
   * Asserts that the list is initialized and contains at least one Celebrity.
   * Sets the current celebrity as the first item in the list. Opens the game
   * play screen.
   */
  public int currentCeleb = (int) (Math.random() * celebGameList.size());
  public void play()
  {
    if (celebGameList != null && celebGameList.size() > 0)
    {
      this.gameCelebrity = celebGameList.get(currentCeleb);
      gameWindow.replaceScreen("GAME");
    }
  }

  public void cycleCeleb(){
	  celebGameList.remove(currentCeleb);
	  currentCeleb = (int) (Math.random() * celebGameList.size());
	  gameCelebrity = celebGameList.get(currentCeleb);
  }
	/**
	 * Adds a Celebrity of specified type to the game list
	 * 
	 * @param name
	 *            The name of the celebrity
	 * @param guess
	 *            The clue(s) for the celebrity
	 * @param type
	 *            What type of celebrity
	 */
	public void addCelebrity(String name, String guess, String type)
	{
		celebGameList.add(new Celebrity(name));
		celebGameList.get(celebGameList.size()-1).addClue(guess);
	}

	/**
	 * Validates the name of the celebrity. It must have at least 4 characters.
	 * @param name The name of the Celebrity
	 * @return If the supplied Celebrity is valid
	 */
	public boolean validateCelebrity(String name)
	{
    	if(name.trim().length() >= 4){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * Checks that the supplied clue has at least 10 characters or is a series of clues
	 * This method would be expanded based on your subclass of Celebrity.
	 * @param clue The text of the clue(s)
	 * @param type Supports a subclass of Celebrity 
	 * @return If the clue is valid.
	 */
	
	public boolean validateClue(String clue, String type)
	{
		if(clue.trim().length() >= 10){
			return true;
		}else{
			return false;
		}
	
	}

	/**
	 * Accessor method for the current size of the list of celebrities
	 * 
	 * @return Remaining number of celebrities
	 */
	public int getCelebrityGameSize(){

		return celebGameList.size();
	}

	/**
	 * Accessor method for the games clue to maintain low coupling between
	 * classes
	 * 
	 * @return The String clue from the current celebrity.
	 */
	public String sendClue()
	{
		return gameCelebrity.getClue(0);
	}
}