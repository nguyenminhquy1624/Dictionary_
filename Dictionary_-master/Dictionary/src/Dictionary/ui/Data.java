
package Dictionary.ui;

import java.util.ArrayList;
import org.xml.sax.InputSource;

/**
 *
 * @author MINH QUY
 */
public class Data extends Dictionary{
    private String word, define;
    
    public Data(String word, String define) {
        this.word = word;
        this.define = define;
    }
    
    
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefine() {
        return define;
    }

    public void setDefine(String define) {
        this.define = define;
    }
}
