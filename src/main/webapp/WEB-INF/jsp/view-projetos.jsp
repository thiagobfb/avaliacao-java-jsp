<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>View Books</title>
    <link href="<c:url value="/css/common.css"/>" rel="stylesheet" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <button type="button" class="btn btn-primary" href="/projeto/addProjeto">Criar Projeto</button>
            </div>
        </div>
        <div class="row">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Nome</th>
                    <th>Data de Início</th>
                    <th>Data Previsão de Fim</th>
                    <th>Data Fim</th>
                    <th>Status</th>
                    <th>Orçamento</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projetos}" var="projeto">
                    <tr>
                        <td>${projeto.nome}</td>
                        <td>${projeto.dataInicio}</td>
                        <td>${projeto.dataPrevisaoFim}</td>
                        <td>${projeto.dataFim}</td>
                        <td>${projeto.status}</td>
                        <td>${projeto.orcamento}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>