<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>Productos</title></head>
<body>
<h1>Productos</h1>
<p><a href="${pageContext.request.contextPath}/product-form">Crear producto</a></p>

<table border="1" cellpadding="8">
  <tr><th>ID</th><th>Nombre</th><th>Descripción</th><th>Precio</th><th>Acciones</th></tr>
  <c:forEach var="p" items="${products}">
    <tr>
      <td>${p.id}</td>
      <td>${p.name}</td>
      <td>${p.description}</td>
      <td>${p.price}</td>
      <td>
        <a href="${pageContext.request.contextPath}/product-form?id=${p.id}">Editar</a> |
        <a href="${pageContext.request.contextPath}/product-action?delete=1&id=${p.id}"
           onclick="return confirm('Eliminar producto?')">Eliminar</a>
      </td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
