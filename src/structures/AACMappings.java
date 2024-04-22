package structures; 
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * an implementation of AACMappings class with stub methods that
 * follows the specifications 
 *
 * @author Tony
 */


public class AACMappings {
  private AssociativeArray<String, AACCategory> cat;
  private AACCategory currentCat;

  public AACMappings(String filename) {
    this.cat = new AssociativeArray<>();
    this.currentCat = new AACCategory(filename);
  }

  public void add(String imageLoc, String text) {
    currentCat.addItem(imageLoc, text);
  }

  public String getCurrentCategory() {
    return currentCat.getCategory();
  }

  public String[] getImageLocs() {
    return currentCat.getImages();
  }

  public String getText(String imageLoc) throws KeyNotFoundException {
    if (isCategory(imageLoc)) {
      currentCat = cat.get(imageLoc);
        return null; 
    }
    return currentCat.getText(imageLoc);
  }

  public void reset() {
        // Reset to default category
    currentCat = new AACCategory("default");
  }

  public boolean isCategory(String imageLoc) {
    try {
      return cat.hasKey(imageLoc);
    } catch (Exception e) {
        return false;
    }
  }
    
    
  public void writeToFile(String filename) throws IOException {
    PrintWriter writer = new PrintWriter(new FileWriter(filename));
      for (int i = 0; i < cat.size(); i++) {
        KVPair<String, AACCategory> kvPair = cat.pairs[i]; 
        String categoryKey = kvPair.key;
        AACCategory category = kvPair.value;
        writer.println(categoryKey + " " + category.getCategory());
    
        for (String imageLoc : category.getImages()) {
          String text = category.getText(imageLoc);

          writer.println(">" + imageLoc + " " + text);
        }
    }
            
  }
}


