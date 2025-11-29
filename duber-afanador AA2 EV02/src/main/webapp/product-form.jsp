<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><title>Formulario producto</title></head>
<body>
<h1><c:out value="${product != null ? 'Editar producto' : 'Crear producto'}"/></h1>
<form action="${pageContext.request.contextPath}/product-action" method="post">
  <input type="hidden" name="id" value="${product.id}" />
  <p>
    <label>Nombre:<br>
      <input type="text" name="name" value="${product.name}" required />
    </label>
  </p>
  <p>
    <label>Descripción:<br>
      <textarea name="description">${product.description}</textarea>
    </label>
  </p>
  <p>
    <label>Precio:<br>
      <input type="number" step="0.01" name="price" value="${product.price}" />
    </label>
  </p>
  <p>
    <button type="submit">Guardar</button>
    <a href="${pageContext.request.contextPath}/products">Cancelar</a>
  </p>
</form>
</body>
</html>
