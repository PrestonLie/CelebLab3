import java.util.ArrayList;


public class Celebrity {

    private String name;
    private ArrayList<String> clues = new ArrayList<String>();

    public Celebrity (String name)
    {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void addClue(String newClue){
        clues.add(newClue);
    }

    public String getClue(int i){
        return clues.get(i);
    }
}
