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
public class NewClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String  url = "jdbc:mysql://localhost:3306/108xxxdb?useUnicode=true&characterEncoding=utf8";
        String  userName = "root";
        String  password = "123456";
        String  s = "SELECT * FROM 108xxxdb.108xxxdb;";
        Connection  cn = null;
        try{
            cn = DriverManager.getConnection(url, userName, password);
            Statement   st = cn.createStatement();
            ResultSet   rs = st.executeQuery(s);
            System.out.println("日期時間\t\t開\t高\t低\t收\t成交量\tK棒顏色\tABC\t買/賣\t達標\t停損\t結果\t進場\t\t\t出場");
            
            int     cntSuccess = 0;
            int     cntbreak = 0;
            int     A1S = 0, A1B = 0;
            int     A2S = 0, A2B = 0;
            int     B1S = 0, B1B = 0;
            int     B2S = 0, B2B = 0;
            int     C1S = 0, C1B = 0;
            int     C2S = 0, C2B = 0;
            int     mark11 = 0, mark12 = 0, mark21 = 0, mark22 = 0, markPoint = 0, markPoint1 = 0, markPoint2 = 0;
            
            int     S2 = 0, B2 = 0;
            int     plus1 = 30;
            int     lose1 = 20;
            int     plus2 = 30;
            int     lose2 = 20;
//            int     plus1 = 21;
//            int     lose1 = 20;
//            int     plus2 = 39;
//            int     lose2 = 18;
            
            while(rs.next()){
                int     alpha = 13;
                
                String  DateTime = rs.getString(1);
                String  Date = rs.getString(2);
                String  Time = rs.getString(3);
                int     Open = rs.getInt(4);
                int     High = rs.getInt(5);
                int     Low = rs.getInt(6);
                int     Close = rs.getInt(7);
                int     Volume = rs.getInt(8);
//                Date a = java.sql.Date.valueOf("2018-10-1");
                //Date b = java.sql.Date.valueOf(rs.getString(2)); // && a.before(b)
                String  ABC="";
                if(rs.getString(3).equals("08:50:00") ){
                    System.out.print(Date+" "+Time+"\t"+Open+"\t"+
                        High+"\t"+Low+"\t"+Close+"\t"+Volume+"\t");
                    if(Open<Close){
                        System.out.print("R\t");
                    }else if(Open>Close){
                        System.out.print("G\t");
                    }else{
                        System.out.print("+\t");
                    }
                    
                    if(High-Open>=alpha &&  Close-Open>=alpha ){
                        System.out.print("+A\t");
                        ABC="+A";
                        rs.next();
                        int Enter = rs.getInt(4);
                        int Success = Enter+plus1;
                        int Stop = Enter-lose1;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("B"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            if(High_Next >= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                A1S++;
                                break;
                            }else if(Low_Next <= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                A1B++;
                                
                                /*---------------------------------------------------------*/
                               /* int Enter2 = rs.getInt(4);
                                int Success2 = Enter2-plus2;
                                int Stop2 = Enter2+lose2;
                                String  DateTime_in_2 = rs.getString(1);
                                System.out.print("\t--S"+Enter2+"\t"+Success2+"\t"+Stop2+"\t");
                                
                                do{
                                    int High_Next2 = rs.getInt(5);
                                    int Low_Next2 = rs.getInt(6);
                                    if(Low_Next2 <= Success2 && Date.equals(rs.getString(2))){
                                        System.out.print("Success2\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        S2++;
                                        break;
                                    }else if(High_Next2 >= Stop2 && Date.equals(rs.getString(2))){
                                        System.out.print("Break2\t\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        B2++;
                                        break;
                                    }else if(rs.getString(3).equals("10:30:00")){
                                        markPoint2+=(Enter2-rs.getInt(4));
                                        System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4))+"\t\t\t"+rs.getString(1)); 
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals("10:30:00")){
                                markPoint1+=(rs.getInt(4)-Enter);
                                System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter+" = "+(rs.getInt(4)-Enter)); 
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                        
                    }else if(Open-Close>=alpha  &&  Open-Low>=alpha){
                        System.out.print("-A\t");
                        ABC="-A";
                        rs.next();
                        int Enter = rs.getInt(4);
                        int Success = Enter-plus1;
                        int Stop = Enter+lose1;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("S"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        
                        
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            if(Low_Next <= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                A2S++;
                                break;
                            }else if(High_Next >= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                A2B++;
                                
                                /*---------------------------------------------------------*/
                            /*    int Enter2 = rs.getInt(4);
                                int Success2 = Enter2+plus2;
                                int Stop2 = Enter2-lose2;
                                String  DateTime_in_2 = rs.getString(1);
                                System.out.print("\t--B"+Enter2+"\t"+Success2+"\t"+Stop2+"\t");
                                
                                do{
                                    int High_Next2 = rs.getInt(5);
                                    int Low_Next2 = rs.getInt(6);
                                    if(High_Next2 >= Success2 && Date.equals(rs.getString(2))){
                                        System.out.print("Success2\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        S2++;
                                        break;
                                    }else if(Low_Next2 <= Stop2 && Date.equals(rs.getString(2))){
                                        System.out.print("Break2\t\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        B2++;
                                        break;
                                    }else if(rs.getString(3).equals("10:30:00")){
                                        markPoint2+=(rs.getInt(4)-Enter2);
                                        System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter2+" = "+(rs.getInt(4)-Enter2)+"\t"+rs.getString(1));
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                /*---------------------------------------------------------*/
                                
                                
                                
                                break;
                            }else if(rs.getString(3).equals("10:30:00")){
                                markPoint1+=(Enter-rs.getInt(4));
                                System.out.print("!!!!!!\t"+Enter+" - "+rs.getInt(4)+" = "+(Enter-rs.getInt(4)));
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                    }else if(Close>Open &&  High-Open<alpha){
                        System.out.print("+B\t");
                        ABC="+B";
                        rs.next();
                        int Enter = rs.getInt(4);
                        int Success = Enter+plus1;
                        int Stop = Enter-lose1;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("B"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        
                        
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            if(High_Next >= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                B1S++;
                                break;
                            }else if(Low_Next <= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                B1B++;
                                
                                
                                /*---------------------------------------------------------*/
                           /*     int Enter2 = rs.getInt(4);
                                int Success2 = Enter2-plus2;
                                int Stop2 = Enter2+lose2;
                                String  DateTime_in_2 = rs.getString(1);
                                System.out.print("\t--S"+Enter2+"\t"+Success2+"\t"+Stop2+"\t");
                                
                                do{
                                    int High_Next2 = rs.getInt(5);
                                    int Low_Next2 = rs.getInt(6);
                                    if(Low_Next2 <= Success2 && Date.equals(rs.getString(2))){
                                        System.out.print("Success2\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        S2++;
                                        break;
                                    }else if(High_Next2 >= Stop2 && Date.equals(rs.getString(2))){
                                        System.out.print("Break2\t\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        B2++;
                                        break;
                                    }else if(rs.getString(3).equals("10:30:00")){
                                        markPoint2+=(Enter2-rs.getInt(4));
                                        System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4))+"\t\t\t"+rs.getString(1)); 
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                
                                /*---------------------------------------------------------*/
                                break;
                            }else if(rs.getString(3).equals("10:30:00")){
                                markPoint1+=(rs.getInt(4)-Enter);
                                System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter+" = "+(rs.getInt(4)-Enter)); 
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                    }else if(Close<Open &&  Open-Low<alpha){
                        System.out.print("-B\t");
                        ABC="-B";
                        rs.next();
                        int Enter = rs.getInt(4);
                        int Success = Enter-plus1;
                        int Stop = Enter+lose1;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("S"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            if(Low_Next <= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                B2S++;
                                break;
                            }else if(High_Next >= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                B2B++;
                                
                                /*---------------------------------------------------------*/
                         /*       int Enter2 = rs.getInt(4);
                                int Success2 = Enter2+plus2;
                                int Stop2 = Enter2-lose2;
                                String  DateTime_in_2 = rs.getString(1);
                                System.out.print("\t--B"+Enter2+"\t"+Success2+"\t"+Stop2+"\t");
                                
                                do{
                                    int High_Next2 = rs.getInt(5);
                                    int Low_Next2 = rs.getInt(6);
                                    
                                    if(High_Next2 >= Success2 && Date.equals(rs.getString(2))){
                                        System.out.print("Success2\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        S2++;
                                        break;
                                    }
                                    else if(Low_Next2 <= Stop2 && Date.equals(rs.getString(2))){
                                        System.out.print("Break2\t\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        B2++;
                                        break;
                                    }else if(rs.getString(3).equals("10:30:00")){
                                        markPoint2+=(rs.getInt(4)-Enter2);
                                        System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter2+" = "+(rs.getInt(4)-Enter2)+"\t"+rs.getString(1));
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals("10:30:00")){
                                markPoint1+=(Enter-rs.getInt(4));
                                System.out.print("!!!!!!\t"+Enter+" - "+rs.getInt(4)+" = "+(Enter-rs.getInt(4)));
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                    }else if(Close<Open &&  Open-Low>=alpha &&  Open-Close<alpha ){
                        System.out.print("+C\t");
                        ABC="+C";
                        rs.next();
                        int Enter = rs.getInt(4);
                        int Success = Enter+plus1;
                        int Stop = Enter-lose1;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("B"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        
                        
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            if(High_Next >= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                C1S++;
                                break;
                            }else if(Low_Next <= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                C1B++;
                                
                                
                                
                                /*---------------------------------------------------------*/
                         /*       int Enter2 = rs.getInt(4);
                                int Success2 = Enter2-plus2;
                                int Stop2 = Enter2+lose2;
                                String  DateTime_in_2 = rs.getString(1);
                                System.out.print("\t--S"+Enter2+"\t"+Success2+"\t"+Stop2+"\t");
                                
                                do{
                                    int High_Next2 = rs.getInt(5);
                                    int Low_Next2 = rs.getInt(6);
                                    if(Low_Next2 <= Success2 && Date.equals(rs.getString(2))){
                                        System.out.print("Success2\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        S2++;
                                        break;
                                    }else if(High_Next2 >= Stop2 && Date.equals(rs.getString(2))){
                                        System.out.print("Break2\t\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        B2++;
                                        break;
                                    }else if(rs.getString(3).equals("10:30:00")){
                                        markPoint2+=(Enter2-rs.getInt(4));
                                        System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4))+"\t\t\t"+rs.getString(1)); 
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals("10:30:00")){
                                markPoint1+=(rs.getInt(4)-Enter);
                                System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter+" = "+(rs.getInt(4)-Enter)); 
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                    }else if(Close>Open && High-Open>=alpha && Close-Open<alpha){
                        System.out.print("-C\t");
                        ABC="-C";
                        rs.next();
                        int Enter = rs.getInt(4);
                        int Success = Enter-plus1;
                        int Stop = Enter+lose1;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("S"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            if(Low_Next <= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                C2S++;
                                break;
                            }else if(High_Next >= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                C2B++;     
                                
                                /*---------------------------------------------------------*/
                        /*        int Enter2 = rs.getInt(4);
                                int Success2 = Enter2+plus2;
                                int Stop2 = Enter2-lose2;
                                String  DateTime_in_2 = rs.getString(1);
                                System.out.print("\t--B"+Enter2+"\t"+Success2+"\t"+Stop2+"\t");
                                
                                do{
                                    int High_Next2 = rs.getInt(5);
                                    int Low_Next2 = rs.getInt(6);
                                    if(High_Next2 >= Success2 && Date.equals(rs.getString(2))){
                                        System.out.print("Success2\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        S2++;
                                        break;
                                    }else if(Low_Next2 <= Stop2 && Date.equals(rs.getString(2))){
                                        System.out.print("Break2\t\t"+DateTime_in_2+"\t"+rs.getString(1));
                                        if(!Date.equals(rs.getString(2))){mark12++; System.out.print("!!!");}
                                        B2++;
                                        break;
                                    }else if(rs.getString(3).equals("10:30:00")){
                                        markPoint2+=(rs.getInt(4)-Enter2);
                                        System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter2+" = "+(rs.getInt(4)-Enter2)+"\t"+rs.getString(1));
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals("10:30:00")){
                                markPoint1+=(Enter-rs.getInt(4));
                                System.out.print("!!!!!!\t"+Enter+" - "+rs.getInt(4)+" = "+(Enter-rs.getInt(4)));
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                    }else{
                        System.out.print("--\t");
                    }
                    System.out.println("");
                }
                
            }
            cntSuccess=A1S+A2S+B1S+B2S+C1S+C2S;
            cntbreak = A1B+A2B+B1B+B2B+C1B+C2B;
            
            
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("測試天數: %5d\n",(cntSuccess+cntbreak) );
            System.out.printf("+A-S: %5d\t+A-B: %5d\t-A-S: %5d\t-A-B: %5d\tA-S: %5d\t\tA-B: %5d\t\t用A的勝率: %5d％\n", A1S, A1B, A2S, A2B, (A1S+A2S), (A1B+A2B),(A1S+A2S)*100/(A1S+A2S+A1B+A2B));
            System.out.printf("+B-S: %5d\t+B-B: %5d\t-B-S: %5d\t-B-B: %5d\tB-S: %5d\t\tB-B: %5d\t\t用B的勝率: %5d％\n", B1S, B1B, B2S, B2B, (B1S+B2S), (B1B+B2B),(B1S+B2S)*100/(B1S+B2S+B1B+B2B));
            System.out.printf("+C-S: %5d\t+C-B: %5d\t-C-S: %5d\t-C-B: %5d\tC-S: %5d\t\tC-B: %5d\t\t用C的勝率: %5d％\n", C1S, C1B, C2S, C2B, (C1S+C2S), (C1B+C2B),(C1S+C2S)*100/(C1S+C2S+C1B+C2B));
            System.out.printf("勝率: %5d％\n",cntSuccess*100/(cntSuccess+cntbreak) );
            
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("Success1: %5d\tBreak1: %5d\nmark11  : %5d\tmark21: %5d\n", cntSuccess, cntbreak, mark11, mark21);
            System.out.println((cntSuccess*plus1-cntbreak*lose1)*200);
            System.out.printf("--------------------------------\nBreak1 -> %5d\n", cntbreak);
            System.out.printf("Success2: %5d\tBreak2: %5d\nmark12  : %5d\tmark22: %5d\n", S2, B2, mark12, mark22);
            int totPoint = cntSuccess*plus1+S2*plus2-cntbreak*lose1-B2*lose2+markPoint1+markPoint2 ;
            System.out.printf("--------------------------------\n");
            System.out.println("( Success1*plus + Success2*plus - Break1*lose - Break2*lose + markPoint1 - markPoint2 )*200");
            
            System.out.printf("( %8d*%4d + %8d*%4d - %6d*%4d - %6d*%4d + %10d + %10d )*200 = %5d*200 = %5d元", cntSuccess, plus1, S2, plus2, cntbreak, lose1, B2, lose2, markPoint1, markPoint2, totPoint, totPoint*200 );
            
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
