/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public void setDefine(String dec) {
        this.define = define;
    }
    
    
    
}
