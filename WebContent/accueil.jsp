<%@page import="model.GroupeModule"%>
<%@page import="dao.PlanEtudesImp"%>
<%@page import="java.util.List"%>
<%@page import="model.Matiere"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>accueil </title>
</head>
<body>
<h1>Gestion desEtudiants</h1>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%! String role1="admin" ;%>
<%! String role2="etudiant" ;%>
<c:choose>
	<c:when test="${cmpt.role.equals('admin')}">admin</c:when>
	<c:otherwise>
	${cmpt.login }
	</c:otherwise>
	
</c:choose>
<%
PlanEtudesImp pei=new PlanEtudesImp();
List<Matiere> lis=pei.getAllMatieres();
request.setAttribute("lis", lis);
for(Matiere m:lis){
	System.out.println(m);
}
%>

 <form method="post" action="Deconnecter">
 	<input type="submit" value="logout">
 	
 </form><!--a href="./login.jsp">logout</a></h5-->
 <h1>recherche matiere </h1>
 <form method="post" action="RechercheMc">
 	<label for="no">mot clé</label><input type="text" name="no" id="no" value="${no}">
 	<input type="submit" value="valider">
 </form>
 <table>
 <c:if test="${li!=null}">
 <tr>
 <th>Id Matiere</th><th>nom</th><th>nbre h cours</th><th>nbre h tp</th><th>coef</th><th>GM</th></tr>
 	<c:forEach var="mat" items="${li}">
 	<tr>
				<td>${mat.id}<br/></td>
				<td>${mat.nom}<br/></td>
				<td>${mat.nbr_heures}<br/></td>
				<td>${mat.nb_h_tp}<br/></td>
				<td>${mat.coef}<br/></td>
				<td>${mat.gp.nom}<br/></td>
			</tr>
 		
 	</c:forEach>
 </c:if>
 <%
 List<GroupeModule> lo=pei.getAllGroupesModules();
 request.setAttribute("listgm",lo);
 %>
 </table>
 <c:if test="${cmpt.role.equals('admin')}">
 <h1>Ajouter une matiere </h1>
 <form action="AjoutMatiere" method="post">
 <table>
 <tr><td><label for="nom">nom matiere</label></td><td><input type="text" name="nom" id="nom"></td></tr>
 <tr><td><label for="nbr_h_cours">nbr_h_cours</label></td><td><input type="number" name="nbr_h_cours" id="nbr_h_cours"></td></tr>
 <tr><td><label for="nbr_h_tp">nbr_h_tp</label></td><td><input type="number" name="nbr_h_tp" id="nbr_h_tp"></td></tr>
 <tr><td><label for="coef">coef</label></td><td><input type="text" name="coef" id="coef"></td></tr>
 <tr><td><label for="gm">groupe de module </label></td>
 <td><select name="gpm">
 <c:if test="${listgm!=null}">
 	<c:forEach var="gpr" items="${listgm}">
 	<option value="${gpr.id}">
 		${gpr.nom}
 		</option >
 	</c:forEach>
 </c:if>
 </select></td></tr>
 <tr><td><input type="submit" value="ajouter"></td></tr>
 </table>
 
 </form>
 </c:if>
 <table>
 <tr>
		<th>Id Matiere</th><th>nom</th><th>nbre h cours</th><th>nbre h tp</th><th>coef</th><th>GM</th></tr>
		<c:forEach var="mat" items="${lis }">
			<tr>
				<td>${mat.id}<br/></td>
				<td>${mat.nom}<br/></td>
				<td>${mat.nbr_heures}<br/></td>
				<td>${mat.nb_h_tp}<br/></td>
				<td>${mat.coef}<br/></td>
				<td>${mat.gp.nom}<br/></td>
			</tr>
		</c:forEach>	
 </table>
 
</body>
</html>