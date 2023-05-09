<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<c:if test="${addBookSuccess}">
    <div>Successfully added Book with ISBN: ${savedBook.isbn}</div>
</c:if>

<c:url var="add_projeto_url" value="/projeto/addProjeto"/>
<%--<form:form action="${add_projeto_url}" method="post" modelAttribute="projeto">--%>
<%--    <form:label path="isbn">ISBN: </form:label> <form:input type="text" path="isbn"/>--%>
<%--    <form:label path="name">Book Name: </form:label> <form:input type="text" path="name"/>--%>
<%--    <form:label path="author">Author Name: </form:label> <form:input path="author"/>--%>
<%--    <input type="submit" value="submit"/>--%>
<%--</form:form>--%>
<div class="container px-5 my-5">
    <form:form id="contactForm" data-sb-form-api-token="API_TOKEN" action="${add_projeto_url}" method="post" modelAttribute="projeto">
        <div class="form-floating mb-3">
            <form:input path="nome" class="form-control" id="nome" type="text" placeholder="Nome" data-sb-validations="required" />
            <form:label path="nome" for="nome">Nome</form:label>
            <div class="invalid-feedback" data-sb-feedback="nome:required">Nome is required.</div>
        </div>
        <div class="form-floating mb-3">
            <form:input path="dataInicio" class="form-control" id="dataInicio" type="text" placeholder="Data de Início" data-sb-validations="required" />
            <form:label path="dataInicio" for="dataDeInicio">Data de Início</form:label>
            <div class="invalid-feedback" data-sb-feedback="dataInicio:required">Data de Início is required.</div>
        </div>
        <div class="form-floating mb-3">
            <form:input path="gerenteResponsavel" class="form-control" id="gerenteResponsavel" type="text" placeholder="Gerente Responsável" data-sb-validations="required" />
            <form:label path="gerenteResponsavel" for="gerenteResponsavel">Gerente Responsável</form:label>
            <div class="invalid-feedback" data-sb-feedback="gerenteResponsavel:required">Gerente Responsável is required.</div>
        </div>
        <div class="form-floating mb-3">
            <form:input path="previsaoTermino" class="form-control" id="previsaoTermino" type="text" placeholder="Previsão de Término" />
            <form:label path="previsaoTermino" for="previsaoTermino">Previsão de Término</form:label>
        </div>
        <div class="form-floating mb-3">
            <form:input path="dataTermino" class="form-control" id="dataTermino" type="text" placeholder="Data de Término" data-sb-validations="" />
            <form:label path="dataTermino" for="dataTermino">Data de Término</form:label>
        </div>
        <div class="form-floating mb-3">
            <form:input path="orcamentoTotal" class="form-control" id="orcamentoTotal" type="text" placeholder="Orçamento Total" data-sb-validations="required" />
            <form:label path="orcamentoTotal" for="orcamentoTotal">Orçamento Total</form:label>
            <div class="invalid-feedback" data-sb-feedback="orcamentoTotal:required">Orçamento Total is required.</div>
        </div>
        <div class="form-floating mb-3">
            <form:textarea path="descricao" class="form-control" id="descricao" type="text" placeholder="Descrição" style="height: 10rem;"></form:textarea>
            <form:label path="descricao" for="descricao">Descrição</form:label>
        </div>
        <div class="form-floating mb-3">
            <form:select path="status" class="form-select" id="status" aria-label="Status">
                <option value="EM_ANALISE">Em Análise</option>
                <option value="ANALISE_REALIZADA">Análise Realizada</option>
                <option value="ANALISE_APROVADA">Análise Aprovada</option>
                <option value="INICIADO">Iniciado</option>
                <option value="PLANEJADO">Planejado</option>
                <option value="EM_ANDAMENTO">Em Andamento</option>
                <option value="ENCERRADO">Encerrado</option>
                <option value="CANCELADO">Cancelado</option>
            </form:select>
            <form:label path="status" for="status">Status</form:label>
        </div>
        <div class="d-none" id="submitSuccessMessage">
            <div class="text-center mb-3">
                <div class="fw-bolder">Form submission successful!</div>
                <p>To activate this form, sign up at</p>
                <a href="https://startbootstrap.com/solution/contact-forms">https://startbootstrap.com/solution/contact-forms</a>
            </div>
        </div>
        <div class="d-none" id="submitErrorMessage">
            <div class="text-center text-danger mb-3">Error sending message!</div>
        </div>
        <div class="d-grid">
            <button class="btn btn-primary btn-lg disabled" id="submitButton" type="submit">Submit</button>
        </div>
    </form:form>
</div>
<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
<script src="<c:url value="/js/common.js"/>"></script>
</body>
</html>