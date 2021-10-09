/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dictionary.ui;

/**
 *
 * @author MINH QUY
 */
public class Data {
    private String word, define;

    /**
     * @return the text
     */
    
    public Data(String word, String define) {
        this.word = word;
        this.define = define;
    }
    
    
    public String getWord() {
        return word;
    }

    /**
     * @param text the text to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return the dec
     */
    public String getDefine() {
        return define;
    }

    /**
     * @param dec the dec to set
     */
    public void setDefine(String dec) {
        this.define = define;
    }
    
}
