<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
    <%@ page import="java.sql.*"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head >
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>ABC</title>
<meta name="keywords" content="">
  <meta name="description" content="">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
  
	<meta property="og:title" content="">
	<meta property="og:type" content="website">
	<meta property="og:url" content="">
	<meta property="og:site_name" content="">
	<meta property="og:description" content="">

  <!-- Styles -->
  <script type="text/javascript" src="/js/flot/jquery.flot.js"></script>
  <script type="text/javascript" src="/js/flot/jquery.flot.time.js"></script>    
  <script type="text/javascript" src="/js/flot/jquery.flot.symbol.js"></script>
  <script type="text/javascript" src="/js/flot/jquery.flot.axislabels.js"></script>
  <link rel="stylesheet" href="css/font-awesome.min.css">
  <link rel="stylesheet" href="css/animate.css">
  <link href='http://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900|Montserrat:400,700' rel='stylesheet' type='text/css'>
  <script src="js/jquery-1.11.0.min.js"></script> 

  <link rel="stylesheet" href="css/bootstrap.min.css">
  <link rel="stylesheet" href="css/main.css">
  <script src="js/modernizr-2.7.1.js"></script>
  
</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top">
	
		
		<div class="navbar-collapse collapse" >
		  <ul class="nav navbar-nav navbar-left">
		    <li><a >����ɶ� </a></li>
		    <li><a >�} </a></li>
		    <li><a >     </a></li>
		    <li><a >�� </a></li>
		    <li><a >     </a></li>
		    <li><a >�C </a></li>
		    <li><a >     </a></li>
		    <li><a >�� </a></li>
		    <li><a >     </a></li>
		    <li><a >ABC </a></li>
		    <li><a >   </a></li>
		    <li><a >�R/��</a></li>
		    <li><a >���G</a></li>
		    <li><a >     </a></li>
		    <li><a >���Q/�l</a></li>
		    <li><a >�X��</a></li>
		    <li><a >�l�q���B�֥[</a></li>
		  </ul>
		</div><!--/.navbar-collapse -->
</div>
<div class="mouse-icon hidden-xs">
	<div class="scroll"></div>
</div>

<div class="container"  >
<div class="content">
	<div class="row">
		<div class="col-md-8">
		
			<table class="table table-hover table-bordered">
				<thead>			
						<%
						Class.forName("org.gjt.mm.mysql.Driver").newInstance();
						
						String  s ="SELECT * FROM 108xxxdb.108xxxxdb;";
						String  url ="jdbc:mysql://localhost:3306/108xxxdb?useUnicode=true&characterEncoding=utf8";
						String  userName = "root";
						String  password = "123456";
						
						Connection  cn = null;
						
						try{
							cn = DriverManager.getConnection(url, userName, password);
							Statement   st = cn.createStatement();
							
							ResultSet   rs = st.executeQuery(s);
							
							
							int     cntSuccess = 0;
							int     cntbreak = 0;
							int     A1S = 0, A1B = 0;
							int     A2S = 0, A2B = 0;
							int     B1S = 0, B1B = 0;
							int     B2S = 0, B2B = 0;
							int     C1S = 0, C1B = 0;
							int     C2S = 0, C2B = 0;
							int     E1S = 0, E1B = 0;
							int     mark11 = 0, mark12 = 0, mark21 = 0, mark22 = 0, markPoint = 0, markPoint1 = 0, markPoint2 = 0, HF = 100;
							int     cnt = 0, M = 6000, N = 4000;
							
							int     S2 = 0, B2 = 0;
							int     plus1 = 36;
							int     lose1 = 24;
							int     plus2 = 36;
							int     lose2 = 24;
							int     plus3 = 36;
							int     lose3 = 24;
							int     plus = 200;
							
							
							while(rs.next()) { 
						
								String   timein ="08:50:00";
								String   timeout ="13:30:00";
								String   dateout ="2019-06-02";
								int     alpha = 13;
								String  Date = rs.getString(2);
								String  Time = rs.getString(3);
								int     Open = rs.getInt(4);
								int     High = rs.getInt(5);
								int     Low = rs.getInt(6);
								int     Close = rs.getInt(7);
								Date a = java.sql.Date.valueOf("2019-01-01");
								Date b = java.sql.Date.valueOf(rs.getString(2)); 
								String  ABC="";
								
								if(a.before(b)){
						            if(Date.equals(dateout)){break;}
						            else{
								if(Time.equals("08:50:00")){
						%>
						<tr>
										<th><%= Date +" "+ Time %></th>						        		
						        		<th><%= Open %></th>
						        		<th><%= High %></th>
						        		<th><%= Low %></th>
						        		<th><%= Close %></th>
						        	
						<%
									if (High - Open >= alpha && Close - Open >= alpha) {
						%>
						                
						        		<th><%="+A"%></th>
						        			                    
						<%   				
						                ABC = "+A";
						                rs.next();
						                int Enter = rs.getInt(4);
						                int Success = Enter + plus3;
						                int Stop = Enter - lose3;
						                String DateTime_in_1 = rs.getString(2) + " " + rs.getString(3);               
						%>
						                
						        		<th><%="B"+Enter %></th>
						        			                    
						<%               
						                do {
						                    int High_Next = rs.getInt(5);
						                    int Low_Next = rs.getInt(6);
						                    int Close_Next = rs.getInt(7);
						
						                    if (High_Next >= Success && Date.equals(rs.getString(2))) {                   	
						%>
						                <th><%="S"%></th> 
						                <th><%=Success %></th>
						                <th><%=rs.getString(2)+" "+rs.getString(3) %></th>   
						                   
						<%                      
						                    	
						                    if (!Date.equals(rs.getString(2))) {
						                        mark11++;                           
						%>
						                <th><%="!!!"%></th>                 
						<%                           
						                        }
						                        A1S++;
						                        cnt += M;
						%>
						                <th><%=cnt%></th>
						                 
						<%
						                        break;
						                    } else if (Low_Next <= Stop && Date.equals(rs.getString(2))) {
						%>
						                <th><%="F"%></th>
						                <th><%=Stop %></th>
						                <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<%                        
						                    	if (!Date.equals(rs.getString(2))) {
						                            mark11++;
						%>                                    
						                <th><%="!!!"%> </th>
						                
						<%                            
						                        }                 
						
						                        A1B++;
						                        cnt -= N;
						%>
						               <th> <%=cnt%></th>
						               
						<%                       
						                        break;
						                    } else if (rs.getString(3).equals(timeout)) {
						                        markPoint1 += (rs.getInt(7) - Enter);
						 %>
						               <th><%="!!!!!!"%></th>
						               <th><%=rs.getInt(7)+" - "+Enter+" = "+(rs.getInt(7) - Enter) %></th>	
						               <th><%=" "%></th>	                      
						<%                        mark21++;
						                        cnt += ((rs.getInt(7) - Enter) * plus);
						%>                        
						               <th> <%=cnt%></th>         
						<%                     break;
						                    }
						%>  
						<%         			
						                } while (rs.next());
						
						            } else if (Open - Close >= alpha && Open - Low >= alpha) {
						%>
						                
						        		<th><%="-A"%></th>
						        			                    
						<%   
						                ABC = "-A";
						                rs.next();
						                int Enter = rs.getInt(4);
						                int Success = Enter - plus3;
						                int Stop = Enter + lose3;
						                String DateTime_in_1 = rs.getString(2) + " " + rs.getString(3);
						%>
						                
						            	<th><%="S"+Enter %></th>
						            			                    
						<% 
						                do {
						                    int High_Next = rs.getInt(5);
						                    int Low_Next = rs.getInt(6);
						                    if (Low_Next <= Success && Date.equals(rs.getString(2))) {
						%>
						               <th> <%="S"%> </th>
						               <th><%=Success %></th>
						               <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<%                 
						                        if (!Date.equals(rs.getString(2))) {
						                            mark11++;
						%>                                    
						                <th><%="!!!"%></th> 
						<%  
						                        }
						                        A2S++;
						                        cnt += M;
						%>
						                <th><%=cnt%></th>
						               
						<%     
						                        break;
						                    } else if (High_Next >= Stop && Date.equals(rs.getString(2))) {
						%>                        
						                <th><%="F"%></th>    
						                <th><%=Stop %></th>
						                <th><%=rs.getString(2)+" "+rs.getString(3) %></th>            			                    
						<%
						                        if (!Date.equals(rs.getString(2))) {
						                            mark11++;
						%>                                    
						                 <th><%="!!!"%></th> 
						<%  
						                        }
						                        A2B++;
						                        cnt -= N;
						%>
						                 <th><%=cnt%></th>
						                 
						<%   
						                        break;
						                    } else if (rs.getString(3).equals(timeout)) {
						                        markPoint1 += (Enter - rs.getInt(7));
						%>
						                        
						            	<th><%="!!!!!!"%></th>
						            	<th><%=Enter+" - "+rs.getInt(7)+" = "+(Enter-rs.getInt(7)) %></th>	
						            	<th><%=" "%></th>					                			                    
						<%   
						                        mark21++;
						                        cnt += ((Enter - rs.getInt(7)) * plus);
						%>
						                  <th><%=cnt%></th>
						                   
						<%   
						                        break;
						                    }
						                } while (rs.next());
						            }else if(Close>Open &&  High-Open<alpha){
						%>               
						           		<th><%="+B"%></th>        			                    
						<%   	
						                ABC="+B";
						                rs.next();
						                int Enter = rs.getInt(4);
						                int Success = Enter+plus2;
						                int Stop = Enter-lose2;
						                String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
						%>                
						        		<th><%="B"+Enter%></th>       			                    
						<%   	
						                
						                do{
						                    int High_Next = rs.getInt(5);
						                    int Low_Next = rs.getInt(6);
						                    if(High_Next >= Success && Date.equals(rs.getString(2))){
						%>                        
						                <th><%="S"%></th>
						                <th><%=Success %></th>
						                <th><%=rs.getString(2)+" "+rs.getString(3) %></th>                  			                    
						<% 
						                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
						                <th><%="!!!"%></th>              			                    
						<%  				 }
						                        B1S++;
						                        cnt+=M;
						%>
						                <th><%=cnt%></th>
						                 
						<% 
						                        break;
						                    }else if(Low_Next <= Stop && Date.equals(rs.getString(2))){
						%>                        
						                 <th><%="F"%></th>
						                 <th><%=Stop %></th>
						                 <th><%=rs.getString(2)+" "+rs.getString(3) %></th>                 			                    
						<% 
						                        if(!Date.equals(rs.getString(2))){mark11++;
						%>
						                 <th><%="!!!"%></th>              			                    
						<%
						                        }
						                        B1B++;
						                        cnt-=N;
						%>
						                 <th><%=cnt%></th>
						                 
						<%                 
						                        break;
						                    }else if(rs.getString(3).equals(timeout)){
						                        markPoint1+=(rs.getInt(7)-Enter);
						%>
						                <th><%="!!!!!!"%></th> 
						                <th><%=rs.getInt(7)+" - "+Enter+" = "+(rs.getInt(7)-Enter) %></th>
						                <th><%=" "%></th>					                 
						<%  
						                        mark21++; 
						                        cnt+=((rs.getInt(7)-Enter)*plus);
						%>
						                 <th><%=cnt%></th>
						                   
						<%   
						                        break;
						                    }
						                }while(rs.next());
						            }else if(Close<Open &&  Open-Low<alpha){
						%>               
						           		<th><%="-B"%></th>        			                    
						<% 
						                ABC="-B";
						                rs.next();
						                int Enter = rs.getInt(4);
						                int Success = Enter-plus2;
						                int Stop = Enter+lose2;
						                String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
						%>                
						        		<th><%="S"+Enter%></th>       			                    
						<% 
						                do{
						                    int High_Next = rs.getInt(5);
						                    int Low_Next = rs.getInt(6);
						                    if(Low_Next <= Success && Date.equals(rs.getString(2))){
						%>                        
						                <th><%="S"%></th> 
						                <th><%=Success %></th>
						                <th><%=rs.getString(2)+" "+rs.getString(3) %></th>                  			                    
						<%
						                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
						                <th><%="!!!"%></th>              			                    
						<%
						                        }
						                        B2S++;
						                        cnt+=M;
						%>
						                        <th><%=cnt%></th>
						                           
						<%  
						                        break;
						                    }else if(High_Next >= Stop && Date.equals(rs.getString(2))){
						%>                        
						                 <th><%="F"%></th>
						                 <th><%=Stop %></th>
						                 <th><%=rs.getString(2)+" "+rs.getString(3) %></th>                 			                    
						<%
						                        if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
						                        B2B++;
						                        cnt-=N;
						%>
						                <th> <%=cnt%></th>
						                 
						<%                        
						                        break;
						                    }else if(rs.getString(3).equals(timeout)){
						                        markPoint1+=(Enter-rs.getInt(7));
						%>                        
						                 <th><%="!!!!!!"%></th> 
						                 <th><%=Enter+" - "+rs.getInt(7)+" = "+(Enter-rs.getInt(7))%></th>
						                 <th><%=" "%></th>			                    
						<%
						                        mark21++; 
						                        cnt+=((Enter-rs.getInt(7))*plus);
						%>
						                 <th><%=cnt%></th>
						                  
						<% 
						                        break;
						                    }
						                }while(rs.next());
						                }else if(Close<Open &&  Open-Low>=alpha &&  Open-Close<alpha ){
						%>               
							           	 <th><%="+C"%></th>        			                    
						<% 
							                ABC="+C";
							                rs.next();
							                int Enter = rs.getInt(4);
							                int Success = Enter+plus1;
							                int Stop = Enter-lose1;
							                String  DateTime_in_1 = rs.getString(2)+" "+rs.getString(3);
						%>                
							           	<th><%="B"+Enter%></th>      			                    
						<% 
							                
							                
							                do{
							                    int High_Next = rs.getInt(5);
							                    int Low_Next = rs.getInt(6);
							                    if(High_Next >= Success && Date.equals(rs.getString(2))){
						%>
							             <th><%="S"%></th> 
							             <th><%=Success %></th>
						                 <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<%  
							                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
							              <th><%="!!!"%></th> 
						<%  
							                        }
							                        C1S++;
							                        cnt+=M;
						%>
							             <th><%=cnt%></th>
							               
						<%
							                        break;
							                    }else if(Low_Next <= Stop && Date.equals(rs.getString(2))){
						%>
							       	      <th><%="F"%></th> 
							       	      <th><%=Stop %></th>
						                  <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<%  
							                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
							      	      <th><%="!!!"%></th> 
						<%  
							                        }
							                        C1B++;
							                        cnt-=N;
						%>
							              <th><%=cnt%></th>
							               
						<%                                
							                        break;
							                    }else if(rs.getString(3).equals(timeout)){
							                        markPoint1+=(rs.getInt(7)-Enter);
						%>
							              <th><%="!!!!!!"%> </th>
							              <th><%=rs.getInt(7)+" - "+Enter+" = "+(rs.getInt(7)-Enter)%></th>
							              <th><%=" "%></th>
						<%  
							                        mark21++; 
							                        cnt+=((rs.getInt(7)-Enter)*plus);
						%>
							      	      <th><%=cnt%></th>
							      	       
						<%
							                        break;
							                    }
							                }while(rs.next());
							            }else if(Close>Open && High-Open>=alpha && Close-Open<alpha){
						%>               
								          <th><%="-C"%></th>        			                    
						<%
							                ABC="-C";
							                rs.next();
							                int Enter = rs.getInt(4);
							                int Success = Enter-plus1;
							                int Stop = Enter+lose1;
							                String  DateTime_in_1 =rs.getString(2)+" "+rs.getString(3);
						%>                
								         <th><%="S"+Enter%></th>       			                    
						<% 
							                
							                do{
							                    int High_Next = rs.getInt(5);
							                    int Low_Next = rs.getInt(6);
							                    if(Low_Next <= Success && Date.equals(rs.getString(2))){
						%>
							       	      <th><%="S"%></th> 
							       	      <th><%=Success %></th>
						                  <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<% 
							                        if(!Date.equals(rs.getString(2))){mark11++;
						%>
							      	      <th><%="!!!"%></th> 
						<%	                        
							                        }
							                        C2S++;
							                        cnt+=M;
						%>
							      	      <th><%=cnt%></th>
							      	      
						<%
							                        break;
							                    }else if(High_Next >= Stop && Date.equals(rs.getString(2))){
						%>                        
							             <th> <%="F"%> </th>
							             <th><%=Stop %></th>
						                 <th><%=rs.getString(2)+" "+rs.getString(3) %></th>               			                    
						<% 
							                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
							      	      <th><%="!!!"%></th> 
						<%
							                        }
							                        C2B++;     
							                        cnt-=N;
						%>
								      	  <th><%=cnt%></th>
								      	      	       
						<%                  
							                        break;
							                    }else if(rs.getString(3).equals(timeout)){
							                        markPoint1+=(Enter-rs.getInt(7));
						%>
							      	      <th><%="!!!!!!"%></th>
						                  <th><%=Enter+" - "+rs.getInt(7)+" = "+(Enter-rs.getInt(7))%></th>
						                  <th><%=" "%></th>
						<%
							                        mark21++; 
							                        cnt+=((Enter-rs.getInt(7))*plus);
						%>
							      	      <th><%=cnt%></th>
							      	       
						<%
							                        break;
							                    }
							                }while(rs.next());
							            }else if(Close==Open){
						%>               
								          <th><%="+"%></th>        			                    
						<% 
							                ABC="���E�I";
							                rs.next();
							                int close=rs.getInt(7);
							                if(High>Low){rs.next();}
							                if((Open+2) > close){
							                int Enter = rs.getInt(4);
							                int Success = Enter+plus1;
							                int Stop = Enter-lose1;
							                String  DateTime_in_1 =rs.getString(2)+" "+rs.getString(3);
						%>                
								          <th><%="B"+Enter%></th>       			                    
						<%
							                
							                do{
							                    int High_Next2 = rs.getInt(5);
							                    int Low_Next2 = rs.getInt(6);
							                    if(High_Next2 >= Success && Date.equals(rs.getString(2))){
						%>
							       	      <th><%="S"%></th> 
							       	      <th><%=Success %></th>
						                  <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<%
							                        if(!Date.equals(rs.getString(2))){mark11++; System.out.print("!!!");}
							                        E1S++;
							                        cnt+=M;
						%>
						  	      	      <th><%=cnt%></th>
						        	       
						<%                                
							                        break;
							                    }else if(Low_Next2 <= Stop && Date.equals(rs.getString(2))){
						%>                        
							      	      <th><%="F"%></th>
							      	      <th><%=Stop %></th>
						                  <th><%=rs.getString(2)+" "+rs.getString(3) %></th>                			                    
						<%
							                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
							       	      <th><%="!!!"%></th> 
						<%
							                        }
							                        E1B++;
							                        cnt-=N;
						%>
							              <th><%=cnt%></th>
							       	       
						<%
							                        break;
							                    }else if(rs.getString(3).equals(timeout)){
							                        markPoint1+=(rs.getInt(7)-Enter);
						%>
							      	      <th><%="!!!!!!"%></th>
						                  <th><%=rs.getInt(7)+" - "+Enter+" = "+(rs.getInt(7)-Enter)%></th>
						                  <th><%=" "%></th>
						<%
							                        mark21++; 
							                        cnt+=((rs.getInt(7)-Enter)*plus);
						%>
						 	              <th><%=cnt%></th>
						   	       	       
						<%
							                        break;
							                    }
							                
							                }while(rs.next());
							                    }else if((Open-2) < close){
							                    int Enter = rs.getInt(4);
							                    int Success = Enter-plus1;
							                    int Stop = Enter+lose1;
						%>                
							  		      <th><%="S"+Enter%></th>       			                    
						<%
							                
							                do{
							                    int High_Next2 = rs.getInt(5);
							                    int Low_Next2 = rs.getInt(6);
							                    if(Low_Next2 <= Success && Date.equals(rs.getString(2))){
						%>
							       	      <th><%="S"%></th> 
							       	      <th><%=Success %></th>
						                  <th><%=rs.getString(2)+" "+rs.getString(3) %></th>
						<%
							                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
							       	      <th><%="!!!"%></th> 
						<%
							                        }
							                        E1S++;
							                        cnt+=M;
						%>
							       	      <th><%=cnt%></th>
							       	      
						<%
							                        break;
							                    }else if(High_Next2 >= Stop && Date.equals(rs.getString(2))){
						%>                        
							      	      <th><%="F"%></th>
							      	      <th><%=Stop %></th>
						                  <th><%=rs.getString(2)+" "+rs.getString(3) %></th>                			                    
						<%
							                        if(!Date.equals(rs.getString(2))){mark11++; 
						%>
							      	      <th><%="!!!"%></th> 
						<%
							                        }
							                        E1B++;
							                        cnt-=N;
						%>
							      	      <th><%=cnt%></th>
							       	      
						<%
							                        break;
							                    }else if(rs.getString(3).equals(timeout)){
							                        markPoint1+=(Enter-rs.getInt(7));
						%>
							      	      <th><%="!!!!!!"%></th> 
							      	      <th><%=Enter+" - "+rs.getInt(7)+" = "+(Enter-rs.getInt(7))%></th>
							      	      <th><%=" "%></th>
						<%
							                        mark21++; 
							                        cnt+=((Enter-rs.getInt(7))*plus);
						%>
							      	      <th><%=cnt%></th>
							       	      
						<%
							                        break;
							                    }
							                
							                }while(rs.next());
							              }
							            } else {
						 %>
						                <%=" "%>
						                 
						<%   
						            }
						%>
						                <%=" "%>
						                
						<%   
							      }
						        }
							  }
							}
						%>
					</tr>
				</thead>
			</table>
			</div>
		</div>

<%
	 cntSuccess=A1S+A2S+B1S+B2S+C1S+C2S+E1S;
     cntbreak = A1B+A2B+B1B+B2B+C1B+C2B+E1B;
     int totPoint = cntSuccess*plus1+S2*plus2-cntbreak*lose1-B2*lose2+markPoint1+markPoint2 ;
     int cost =HF*(cntSuccess+cntbreak+mark11+mark21+mark12+mark22)+200;
%>
<table class="table table-hover table-bordered">
				<thead>
					<tr>			
	     <th> <%="���դѼ�:"+(cntSuccess+cntbreak+mark11+mark21+mark12+mark22)+"��"%></th>
	      </tr>
	      <tr>
	      <th><%="A���Q����:"+(A1S+A2S)+"��"%></th>
		  <th><%="A���l����:"+(A1B+A2B)+"��"%></th> 
		  <th><%="��A���Ӳv:"+((A1S+A2S)*100/(A1S+A2S+A1B+A2B))+"%"%></th> 
		  </tr>
		  <tr>
		  <th><%="B���Q����:"+(B1S+B2S)+"��"%></th>
		  <th><%="B���l����:"+(B1B+B2B)+"��"%></th> 
		  <th><%="��B���Ӳv:"+((B1S+B2S)*100/(B1S+B2S+B1B+B2B))+"%"%></th>
		  </tr>
		  <tr>
		  <th><%="C���Q����:"+(C1S+C2S)+"��"%></th>
		  <th><%="C���l����:"+(C1B+C2B)+"��"%></th> 
		  <th><%="��C���Ӳv:"+((C1S+C2S)*100/(C1S+C2S+C1B+C2B))+"%"%></th>
		  </tr>
		  <tr> 
		  <th><%="��X���ɶ��|���F�찱�l���Q����:"+(mark11+mark21+mark12+mark22)+"��"%></th>
		  </tr>
		  <tr>
		  <th><%="�Ӳv:"+(cntSuccess*100/(cntSuccess+cntbreak+mark11+mark21+mark12+mark22))+"%"%></th>
		  </tr>
		  <tr>
		  <th><%="200*("+cntSuccess+"*"+plus1+"-"+cntbreak+"*"+lose1+"+"+markPoint1+")-"+cost+"="+"200*"+totPoint+"-"+cost+"="+(totPoint*200-cost)+"��"%></th>
		  </tr>
		</thead>
	</table>
			
  <%		
	rs.close();
	st.close();
}catch(SQLException e){} 

%>  
    </div>
  </div>
</div>

<!-- Javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/jquery-1.11.0.min.js"><\/script>')</script>
    <script src="js/wow.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>

