/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dictionary.connection;

import java.sql.Connection;
import java.util.ArrayList;
import Dictionary.ui.Data;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class Data_connect 
{   
    private ArrayList <Data> data = new ArrayList <Data> ();
    public Data_connect() 
    {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM tbl_edict ORDER BY word";
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next())
            {
                String word = rs.getString("word");
                String define = rs.getString("detail");
                Data New_Word = new Data(word, define);
                data.add(New_Word);
            }
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public ArrayList <Data> get_Data()
    {
        return data;
    }
    public int get_size()
    {
        return data.size();
    }
    public ArrayList <String> get_Word()
    {
       int n = get_size();
       ArrayList <String> tmp = new ArrayList <String> ();
       for(int i = 0; i < n; i++)
       {
           tmp.add(data.get(i).getWord());
       }
       return tmp;
    }
    public ArrayList <String> get_Define()
    {
       int n = get_size();
       ArrayList <String> tmp = new ArrayList <String> ();
       for(int i = 0; i < n; i++)
       {
           tmp.add(data.get(i).getDefine());
       }
       return tmp;
    }
    
    public int find_position(String word)
    {
        int left = 0;
        int right = get_size()-1;
        if(word.compareTo(data.get(right).getWord()) > 0)
        {
            return right;
        }
        else if(word.compareTo(data.get(left).getWord()) < 0)
        {
            return left;
        }
        else
        {
            int ans = (left + right)/2;
            while(left <= right)
            {
                ans = (left + right)/2;
                if(word.compareTo(data.get(ans).getWord()) == 0)
                break;
                else if(word.compareTo(data.get(ans).getWord()) < 0)
                right = ans - 1;
                else
                left = ans + 1;
            }
            return ans;
        }
    }
    
    public void add_data_to_db(Data data) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO tbl_edict( word, detail) VALUES ( ?, ?)";
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1,100 );
            preparedStatement.setString(1, data.getWord());
            preparedStatement.setString(2, data.getDefine());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    public void edit_data_to_db(String fixOldWord, String fixNewWord, String fixNewDefine) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "";
        if((fixNewWord != null && fixNewWord.length() > 0) && !(fixNewDefine != null && fixNewDefine.length() > 0))
        {
            sql = "UPDATE tbl_edict SET word = ? WHERE word = ?";
            try 
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(2,fixOldWord);
                preparedStatement.setString(1, fixNewWord);
                
                int rs = preparedStatement.executeUpdate();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(!(fixNewWord != null && fixNewWord.length() > 0) && (fixNewDefine != null && fixNewDefine.length() > 0))
        {
            sql = "UPDATE tbl_edict SET detail = ? WHERE word = ?";
            try 
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(2,fixOldWord);
                preparedStatement.setString(1, fixNewDefine);
                
                int rs = preparedStatement.executeUpdate();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
        if(!(fixNewWord != null && fixNewWord.length() > 0) && (fixNewDefine != null && fixNewDefine.length() > 0))
        {
            sql = "UPDATE tbl_edict SET word = ?, detail = ? WHERE word = ?";
            try 
            {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(3,fixOldWord);
                preparedStatement.setString(1, fixNewWord);
                preparedStatement.setString(2, fixNewDefine);
                
                int rs = preparedStatement.executeUpdate();
            }catch(SQLException e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public void delete_data_from_db(String select) {
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "DELETE FROM tbl_edict WHERE word = ?";
        try 
        {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //preparedStatement.setInt(1,100 );
            preparedStatement.setString(1, select);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        }catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void add_Data(int index, Data data)
    {
        if(index >= get_size())
        this.data.add(data);
        else this.data.add(index, data);
        
    }
   
    public boolean edit_Data(int index, String new_word, String new_define)
    {
        if(new_word == null && new_define == null) return false;
        else
        {
            if(new_word != null && new_word.length() > 0)
            {
                data.get(index).setWord(new_word);
            }
            if(new_define != null && new_define.length() > 0)
            {
                data.get(index).setDefine(new_define);
            }
            return true;
        }
    }
    public int delete_Data(String word)
    {
        int tmp = find_position(word);
        if(this.data.get(tmp).getWord().equals(word))
        {
            this.data.remove(tmp);
            return tmp;
        }
        else return -1;
    }   
 }
