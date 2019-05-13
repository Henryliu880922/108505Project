/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 
 */
public class NewClass1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String  url = "jdbc:mysql://localhost:3306/108xxxdb?useUnicode=true&characterEncoding=utf8";
        String  userName = "root";
        String  password = "123456";
        String  s = "SELECT DateTime,Date,max(Time),Open,max(High),Low,Close,volume FROM 108xxxdb.108xxxdb group by Date;";
        Connection  cn = null;
        try{
            cn = DriverManager.getConnection(url, userName, password);
            Statement   st = cn.createStatement();
            ResultSet   rs = st.executeQuery(s);
            System.out.println("日期時間\t\t開\t高\t低\t收\t成交量\tK棒顏色\tABC\t買/賣\t達標\t停損\t結果\t進場\t\t\t出場");     
          
            while(rs.next()){
                 
                String  DateTime = rs.getString(1);
                String  Date = rs.getString(2);
                String  Time = rs.getString(3);
                int     Open = rs.getInt(4);
                int     High = rs.getInt(5);
                int     Low = rs.getInt(6);
                int     Close = rs.getInt(7);
                int     Volume = rs.getInt(8);
                
                    System.out.print(Date+" "+Time+"\t"+Open+"\t"+
                        High+"\t"+Low+"\t"+Close+"\t"+Volume+"\t");
                  
                    System.out.print("--\t");                   
                    System.out.println("");   
            }
            rs.close();
            st.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){}
        }
    }    
}
