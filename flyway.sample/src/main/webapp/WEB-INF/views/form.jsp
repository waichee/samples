<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1> Add entities</h1>

 <h2>Add Project </h2>
 <FORM action="<c:url value="/form/project/add.html" />" method="post">
    <p> Project Name :  <input type="text" name="projectName"></p> <br>
    <P>
    <BUTTON name="submit" value="submit" type="submit">
    Add Project</BUTTON>
    </P>
 </FORM>


 <h2>Add Employee </h2>
  <FORM action="<c:url value="/form/employee/add.html" />" method="post">
     <p> Employee Name :  <input type="text" name="employeeName"></p> <br>
    <p> Employee Position :  <input type="text" name="position"></p> <br>

     <P>
     <BUTTON name="submit" value="submit" type="submit">
     Add Employee</BUTTON>
     </P>
  </FORM>