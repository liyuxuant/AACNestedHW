package structures;

/**
 * ann implementation of AACCategory class with stub methods that
 * follows the specifications 
 *
 * @author Tony
 */

public class AACCategory {

    //field
    private String name; 
    private AssociativeArray<String, String> items; 
    
    //Constructor
    public AACCategory(String name) {
        this.name = name;
        this.items = new AssociativeArray<>(); 
    }

    /**
       Adds the mapping of the imageLoc to the text to the category(associative array).
     */
    public void addItem(String imageLoc, String text) {
    
        try {
            items.set(imageLoc, text);
        } catch (NullKeyException e) {
            
        }
    }

    /**
     * Returns the name of the category.
     */
    public String getCategory() {
        return this.name; 
    }

    /**
     * Returns the text associated with the given image location in this category.
     */
    public String getText(String imageLoc) {
        try {
            return items.get(imageLoc);
        } catch (KeyNotFoundException e) {
            return null;
        }
    }

    /**
     * Determines if the provided image is stored in the category(associative array).
     */
    public boolean hasImage(String imageLoc) {
        // Check if the image location is in the AssociativeArray
        return items.hasKey(imageLoc);
    }

    /**
     * Returns an array of all the images in the category.
     */
    public String[] getImages() {
        String[] imageLocs = new String[items.size()];
        for (int i = 0; i < items.size(); i++) {
            imageLocs[i] = items.pairs[i].key.toString(); 
        }
        return imageLocs;
    }
}