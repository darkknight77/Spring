
<%@ include file="common/header.jspf" %>
<%@ include file="common/navbar.jspf" %>
	<div class="container">
		<h1>Todos for ${name}</h1>

		<table class="table table-striped">
		<caption>Your Todos</caption>
				<thead>
					<tr>
						<th>Descripton</th>
						<th>Target Date</th>
						<th>Is it Done?</th>
						<th></th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<th>${todo.desc}</th>
							<th><fmt:formatDate   value="${todo.targetDate}" pattern="dd/MM/yyyy" /></th>
							<th>${todo.done}</th>
							<th><a type="button" class="btn btn-warning" href="/update-todo?id=${todo.id}">Update</a></th>
						    <th><a type="button" class="btn btn-danger" href="/delete-todo?id=${todo.id}">Delete</a></th>
						</tr>
					</c:forEach>

				</tbody>


</table>


	
<button type="button" class="btn btn-primary"><a href="/add-todo"><font color="white">Add a Todo</font></a></button>
	
		<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
		<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

	</div>
<%@ include file="common/footer.jspf" %>