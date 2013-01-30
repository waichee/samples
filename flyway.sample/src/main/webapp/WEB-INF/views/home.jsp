<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>Example Flyway Cayenne</h1>

<c:choose>
  <c:when test="${empty employeeMap}">
    <h2>No Employee!</h2>
  </c:when>
  <c:otherwise>
      <h2> Employee</h2>

  <table border="1">
  <tr><th>Name </th> <th>Position</th></tr>
    <c:forEach items="${employeeMap}" var="emp" varStatus="st">
      <c:set var="name" value="${emp.name}" />
      <c:set var="position" value="${emp.position}" />
    <tr>
    <td> <p> ${name}</p>  </td>
     <td>   <p>${position}</p>  </td>
     </tr>
        </c:forEach>
        </table>
       </c:otherwise>
 </c:choose>


<c:choose>
  <c:when test="${empty projectMap}">
    <h2>No Project!</h2>
  </c:when>
  <c:otherwise>

  <h2> Projects in the Database:</h2>
  <table border="1">
  <tr><th>Project Name</th></tr>
    <c:forEach items="${projectMap}" var="pro" varStatus="st">
      <c:set var="pname" value="${pro.name}" />
      <tr> <td>
        <p> ${pname}</p> </td>   </tr>
        </c:forEach>
                </table>

       </c:otherwise>
 </c:choose>

<a href="<c:url value="/form.html" />" title="forms">Add Entity</a>
