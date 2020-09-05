<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<form action="affichage.do" method="get">
<table>
<tr><td>Id</td><td><input type="text" name="reference"  value="${produits.reference}"></td></tr>
<tr><td>Designation</td><td><input type="text" name="designation"  value="${produits.designation}"></td></tr>
<tr><td>Prix</td><td><input type="text" name="prix"  value="${produits.prix}"></td></tr>
<tr><td>Quantite</td><td><input type="text" name="quantite"   value="${produits.quantite}"></td></tr>
<tr><td></td><td>
<c:if test="${produits==null}">
<input type="submit" name="action" value="Save">
</c:if>
<c:if test="${produits!=null}">
<input type="submit" name="action" value="Update">
</c:if>
</td></tr>
</table>
</form>
<div><table><tr><th>RefProduit</th><th>Designation</th><th>Prix</th><th>Quantité</th></tr>
<c:forEach items="${produits}" var="p">
<tr>
<td>${p.reference}</td>
<td>${p.designation}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
<td>
<!-- <a   href="controleur.php?action=supp&id=${p.idProduit}">supprimer </a>  -->
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