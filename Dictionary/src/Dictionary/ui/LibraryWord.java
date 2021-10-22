/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dictionary.ui;

/**
 *
 * @author MINH QUY
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LibraryWord 
{
    private ArrayList <Data> data;
    
    public LibraryWord()
    {
        data = new ArrayList <Data> ();
    }
    public void setdata()
    {
        ArrayList <Data> Word_list = new ArrayList <Data> ();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try
        {
            String url = "jdbc:mysql://localhost:3307/edict";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) 
            {
                System.out.println("Kết nối thành công");
            }
            String sql = "SELECT * FROM tbl_edict";
            // Tạo đối tượng thực thi câu lệnh Select
            st = conn.createStatement();
            if(st != null)
            {
                System.out.println("Dữ liệu ko rỗng");
            }
            // Thực thi
            rs = st.executeQuery(sql);
            // Nếu sách không tồn tại
            if(rs != null)
            {
                System.out.println(" ko rỗng");
            }

            if (rs.isBeforeFirst() == true)
            {
                //int count = 0;
                while(rs.next())
                {
                    //if(count < 10)
                    //{
                      //  System.out.println(rs.getString("word") + "\n");
                        //count++;
                    //}
                   String word = rs.getString("word");
                   String define = rs.getString("detail");
                   Data New_Word = new Data(word, define);
                   Word_list.add(New_Word);
                }
            }
        }
        catch (Exception e) 
        {
           e.printStackTrace();
        }
    }
    public ArrayList <Data> getdata()
    {
        return data;
    }
//    
//    public int edit_Word(String Word_Old,String Word_New, String Define_New) 
//    {
//        int index = -1;
//        for (int i = 0; i < this.Word_list.size(); i++) {
//            if (this.Word_list.get(i).getWord().equals(Word_Old)) 
//            {
//                index = i;
//                break;
//            }
//        }
//        if(index > -1)
//        {
//            this.Word_list.get(index).setWord(Word_New);
//            this.Word_list.get(index).setDefine(Define_New);
//        }
//        return index;
//    }
//    public int delete_Word(String selectWord)
//    {
//        int index = -1;
//        for (int i = 0; i < this.Word_list.size(); i++) {
//            if (this.Word_list.get(i).getWord().equals(selectWord)) 
//            {
//                index = i;
//                break;
//            }
//        }
//        if(index > -1)this.Word_list.remove(index);
//        return index;
//    }
//    
//    public int add_Word(String Word, String Define)
//    {
//        Data New_Word = new Data(Word, Define);
//        this.Word_list.add(New_Word);
//        return this.Word_list.size() - 1;
//    }
//    public String get_Word(int index)
//    {
//        return this.Word_list.get(index).getWord();
//    }
//    public ArrayList <Data> get_List()
//    {
//        return this.Word_list;
//    }
//    public ArrayList <String> get_word_list()
//    {
//        int n = this.Word_list.size();
//        ArrayList <String> tmp = new ArrayList <String> ();
//        for(int i = 0; i < n; i++)
//        {
//            tmp.add(this.Word_list.get(i).getWord());
//        }
//        return tmp;
//    }
//     public ArrayList <String> get_word_define()
//    {
//        int n = this.Word_list.size();
//        ArrayList <String> tmp = new ArrayList <String> ();
//        for(int i = 0; i < n; i++)
//        {
//            tmp.add(this.Word_list.get(i).getDefine());
//        }
//        return tmp;
//    }
//    /**
//     * @return the Word_list
//     */
//   // public ArrayList<Data> getWord_list() {
//     //   return Word_list;
//    //}
//     public static void main(String agrs[])
//     {
//         LibraryWord a = new LibraryWord();
//         for(int i = 0; i < 10; i++)
//         {
//             System.out.println(a.Word_list.get(i).getWord() + "\n");
//         }
//     }
}

