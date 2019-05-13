/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * 
 */
public class abc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String  url = "jdbc:mysql://localhost:3306/108xxxdb?useUnicode=true&characterEncoding=utf8";
        String  userName = "root";
        String  password = "123456";
        String  s = "SELECT * FROM 108xxxdb.108xxxxdb;";
        Connection  cn = null;
        try{
            cn = DriverManager.getConnection(url, userName, password);
            Statement   st = cn.createStatement();
            ResultSet   rs = st.executeQuery(s);
            System.out.println("日期時間\t\t\t開\t高\t低\t收\t移動平均線120\t成交量\tK棒顏色\tABC\t買/賣\t停利\t停損\t結果\t進場\t\t\t出場");
            
            int     cntSuccess = 0;
            int     cntbreak = 0;
            int     A1S = 0, A1B = 0;
            int     A2S = 0, A2B = 0;
            int     B1S = 0, B1B = 0;
            int     B2S = 0, B2B = 0;
            int     C1S = 0, C1B = 0;
            int     C2S = 0, C2B = 0;
            int     E1S = 0, E1B = 0;
            int     MAS = 0, MAB = 0;
            int     mark11 = 0, mark12 = 0, mark21 = 0, mark22 = 0, markPoint = 0, markPoint1 = 0, markPoint2 = 0, HF = 100;
            
            int     S2 = 0, B2 = 0;
            int     plus1 = 33;
            int     lose1 = 22;
            int     plus2 = 33;
            int     lose2 = 22;
            int     plus3 = 33;//a
            int     lose3 = 22;
            int     plus = 47;
            int     lose = 38;
            String   timein ="08:50:00";
            String   timeout ="13:30:00";
            
            
            while(rs.next()){
                int     alpha = 13;
                
               
                String  Date = rs.getString(2);
                String  Time = rs.getString(3);
                int     Open = rs.getInt(4);
                int     High = rs.getInt(5);
                int     Low = rs.getInt(6);
                int     Close = rs.getInt(7);
                int     Volume = rs.getInt(8);   
                int     MA = rs.getInt(9);
                //Date a = java.sql.Date.valueOf("2018-10-1");
                //Date b = java.sql.Date.valueOf(rs.getString(2)); // && a.before(b)
                String  ABC="";
                if(rs.getString(3).equals(timein) ){
                    System.out.print(Date+" "+Time+"\t"+Open+"\t"+
                        High+"\t"+Low+"\t"+Close+"\t"+MA+"\t"+"\t"+Volume+"\t");
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
                        int Success = Enter+plus3;
                        int Stop = Enter-lose3;
                        String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
                        System.out.print("B"+Enter+"\t"+Success+"\t"+Stop+"\t");
                        
                        do{
                            int High_Next = rs.getInt(5);
                            int Low_Next = rs.getInt(6);
                            int Close_Next=rs.getInt(7);
                            
                          
                            
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
                                    }else if(rs.getString(3).equals("13:45:00")){
                                        markPoint2+=(Enter2-rs.getInt(4));
                                        System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4))+"\t\t\t"+rs.getString(1)); 
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals(timeout)){
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
                        int Success = Enter-plus3;
                        int Stop = Enter+lose3;
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
                                    }else if(rs.getString(3).equals("13:45:00")){
                                        markPoint2+=(rs.getInt(4)-Enter2);
                                        System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter2+" = "+(rs.getInt(4)-Enter2)+"\t"+rs.getString(1));
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                /*---------------------------------------------------------*/
                                
                                
                                
                                break;
                            }else if(rs.getString(3).equals(timeout)){
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
                        int Success = Enter+plus2;
                        int Stop = Enter-lose2;
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
                                    }else if(rs.getString(3).equals("13:45:00")){
                                        markPoint2+=(Enter2-rs.getInt(4));
                                        System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4))+"\t\t\t"+rs.getString(1)); 
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                
                                /*---------------------------------------------------------*/
                                break;
                            }else if(rs.getString(3).equals(timeout)){
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
                        int Success = Enter-plus2;
                        int Stop = Enter+lose2;
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
                                    }else if(rs.getString(3).equals("13:45:00")){
                                        markPoint2+=(rs.getInt(4)-Enter2);
                                        System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter2+" = "+(rs.getInt(4)-Enter2)+"\t"+rs.getString(1));
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals(timeout)){
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
                        /*        int Enter2 = rs.getInt(4);
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
                                    }else if(rs.getString(3).equals("13:45:00")){
                                        markPoint2+=(Enter2-rs.getInt(4));
                                        System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4))+"\t\t\t"+rs.getString(1)); 
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals(timeout)){
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
                        String  DateTime_in_1 =rs.getString(2)+" "+rs.getString(3);
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
                                    }else if(rs.getString(3).equals("13:45:00")){
                                        markPoint2+=(rs.getInt(4)-Enter2);
                                        System.out.print("!!!!!!\t"+rs.getInt(4)+" - "+Enter2+" = "+(rs.getInt(4)-Enter2)+"\t"+rs.getString(1));
                                        mark22++; 
                                        break;
                                    }
                                }while(rs.next());
                                /*---------------------------------------------------------*/
                                
                                break;
                            }else if(rs.getString(3).equals(timeout)){
                                markPoint1+=(Enter-rs.getInt(4));
                                System.out.print("!!!!!!\t"+Enter+" - "+rs.getInt(4)+" = "+(Enter-rs.getInt(4)));
                                mark21++; 
                                break;
                            }
                        }while(rs.next());
                    }else if(Close==Open){
                        System.out.print("+\t");
                        ABC="等九點";
                        rs.next();
                        int close=rs.getInt(7);
                        if(High>Low){rs.next();}
                        if((Open+3
                                ) > close){
                        int Enter2 = rs.getInt(4);
                        int Success = Enter2+plus1;
                        int Stop = Enter2-lose1;
                        String  DateTime_in_1 =rs.getString(2)+" "+rs.getString(3);
                        System.out.print("B"+Enter2+"\t"+Success+"\t"+Stop+"\t");
                        
                        do{
                            int High_Next2 = rs.getInt(5);
                            int Low_Next2 = rs.getInt(6);
                            if(High_Next2 >= Success && Date.equals(rs.getString(2))){
                                System.out.print("Success\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                E1S++;
                                break;
                            }else if(Low_Next2 <= Stop && Date.equals(rs.getString(2))){
                                System.out.print("Break\t"+DateTime_in_1+"\t"+rs.getString(2)+" "+rs.getString(3));
                                if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
                                E1B++;              
                                break;
                            }else if(rs.getString(3).equals(timeout)){
                                markPoint1+=(Enter2-rs.getInt(4));
                                System.out.print("!!!!!!\t"+Enter2+" - "+rs.getInt(4)+" = "+(Enter2-rs.getInt(4)));
                                mark21++; 
                                break;
                            }
                        
                        }while(rs.next());
                    }
                    }else{
                        System.out.print("--\t");
                    }
                    System.out.println("");
                }
                
            }
            cntSuccess=A1S+A2S+B1S+B2S+C1S+C2S+E1S+MAS;
            cntbreak = A1B+A2B+B1B+B2B+C1B+C2B+E1B+MAB;
            
            
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("測試天數: %5d\n",(cntSuccess+cntbreak) );
            System.out.printf("A成功次數: %5d次\t\tA失敗次數: %5d次\t\t用A的勝率: %5d％\n",(A1S+A2S), (A1B+A2B),(A1S+A2S)*100/(A1S+A2S+A1B+A2B));
            System.out.printf("B成功次數: %5d次\t\tB失敗次數: %5d次\t\t用B的勝率: %5d％\n",(B1S+B2S), (B1B+B2B),(B1S+B2S)*100/(B1S+B2S+B1B+B2B));
            System.out.printf("C成功次數: %5d次\t\tC失敗次數: %5d次\t\t用C的勝率: %5d％\n", (C1S+C2S), (C1B+C2B),(C1S+C2S)*100/(C1S+C2S+C1B+C2B));
            System.out.printf("+成功次數: %5d次\t\t+失敗次數: %5d次\t\t用站上開盤的勝率: %5d％\n", E1S, E1B,E1S*100/(E1S+E1B));
            System.out.printf("超過移動平均線成功次數: %5d次\t\t超過移動平均線失敗次數: %5d次\t\t用超過移動平均線的勝率: %5d％\n", MAS, MAB,MAS*100/(MAS+MAB));
            System.out.printf("勝率: %5d％\n",cntSuccess*100/(cntSuccess+cntbreak) );
            System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("總成功次數: %5d次\t總失敗次數: %5d次\n", cntSuccess, cntbreak);
            System.out.println((cntSuccess*plus1-cntbreak*lose1)*200);
            System.out.printf("--------------------------------\nBreak1 -> %5d\n", cntbreak);
            System.out.printf("Success2: %5d\tBreak2: %5d\nmark12  : %5d\tmark22: %5d\n", S2, B2, mark12, mark22);
           
            System.out.printf("--------------------------------------------------------------------------------------------------------------------------------------\n");
            int totPoint = cntSuccess*plus1+S2*plus2-cntbreak*lose1-B2*lose2+markPoint1+markPoint2 ;
            System.out.println("(總成功次數*30點-總失敗次數*20點+extra)*200");
            int cost =HF*(cntSuccess+cntbreak)+totPoint*200*(cntSuccess+cntbreak)*2/1000;
            
            System.out.printf("(%8d*%4d  - %6d*%4d   +%10d)*200-%5d = %5d*200-%5d = %5d元", cntSuccess, plus1,  cntbreak, lose1,  markPoint1,cost, totPoint,cost ,totPoint*200-cost );
            
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
