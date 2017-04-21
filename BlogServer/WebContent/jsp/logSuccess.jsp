<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>  
<%@ page language="java"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">  
<html>  
  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">  
<title>Insert title here</title>  
</head>  
  

<body>  
<% java.util.Date d = new java.util.Date(); %>  
<% String s = request.getParameter("username"); %>  
     <%=s %>  : welcome<br/>  
    Today's date is <%=d.toString() %>   
    <%=request.getAttribute("dsd")%>
    
        please enter task  
    <form action="TaskServer" >  
        task:<input type="text" name="task"><br/>  
        <input type="submit">  
    </form>  
</body>  
</html>  