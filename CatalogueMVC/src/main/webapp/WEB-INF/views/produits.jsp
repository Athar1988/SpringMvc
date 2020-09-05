<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
       <%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catalogue</title>
<link href="<%=request.getContextPath()%>/resources/css/style.css" type="text/css" rel="stylesheet">
<script type="text/javascript">
function confirmation(id){
	var conf=confirm("Vous- voulez vraiment supprimer cette article");
	if(conf==true){
		document.location="supprimer.do?ref="+id;
		
	}
}
</script>
</head>
<body>
<div id="ListeProduit">
<f:form modelAttribute="produit" action="saveProduit.do" method="post" items="${prod}" var="pd">
<table class="table1">
<tr><td>Id</td><td><f:input path="reference" /></td><td><f:errors path="reference" cssClass="errors"/></td></tr>
<tr><td>Designation</td><td><f:input path="designation" /></td><td><f:errors path="designation" cssClass="errors"/></td></tr>
<tr><td>Prix</td><td><f:input path="prix" /></td><td><f:errors path="prix" cssClass="errors"/></td></tr>
<tr><td>Quantite</td><td><f:input path="quantite" /></td><td><f:errors path="quantite" cssClass="errors"/></td></tr>
<tr><td></td><td>
<c:if test="${prod==null}">
<input type="submit" name="action" value="Save">
</c:if>
<c:if test="${prod!=null}">
<input type="submit" name="action" value="Update">
</c:if>
</td></tr>
</table>
</f:form>
<table><tr><th>RefProduit</th><th>Designation</th><th>Prix</th><th>Quantité</th></tr>
<c:forEach items="${produits}" var="p">
<tr>
<td>${p.reference}</td>
<td>${p.designation}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td>
<a   href="javascript:confirmation('${p.reference}')">supprimer </a> 

  </td>
  <td>
  <a   href="modifier.do?ref=${p.reference}">Modifier </a>
  </td>
</tr>
</c:forEach>
</table></div>
</body>
</html>