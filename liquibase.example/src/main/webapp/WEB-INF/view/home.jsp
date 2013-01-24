<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>


  <h1>Example Liquibase STUFF</h1>

<c:choose>
  <c:when test="${empty bikesMap}">
    <h2>No bikes!</h2>
  </c:when>
  <c:otherwise>
    <c:forEach items="${bikesMap}" var="te" varStatus="st">

      <c:set var="color" value="${te.color}" />
      <c:set var="price" value="${te.price}" />

    <h2> BIKES</h2>

        <p>Color : ${te.color}</p>
        <p>Price : ${te.price}</p>
        </c:forEach>
       </c:otherwise>
 </c:choose>

<c:choose>
  <c:when test="${empty carsMap}">
    <h2>No cars!</h2>
  </c:when>
  <c:otherwise>
    <c:forEach items="${carsMap}" var="c" varStatus="st">

      <c:set var="color" value="${c.color}" />
      <c:set var="price" value="${c.price}" />

    <h2> CARS</h2>

        <p>Color : ${c.color}</p>
        <p>Price : ${c.price}</p>
                 </c:forEach>

       </c:otherwise>
 </c:choose>
