<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<link href="${ctx}/ace/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctx}/ace/assets/css/font-awesome.min.css" />

<!--[if IE 7]>
		  <link rel="stylesheet" href="${ctx}/ace/assets/css/font-awesome-ie7.min.css" />
		<![endif]-->

<!-- page specific plugin styles -->

<!-- ace styles -->
<link rel="stylesheet" href="${ctx}/ace/assets/css/exc.css" />
<link rel="stylesheet" href="${ctx}/ace/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx}/ace/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx}/ace/assets/css/ace-skins.min.css" />

<!--[if lte IE 8]>
		  <link rel="stylesheet" href="${ctx}/ace/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->

<script src="${ctx}/ace/assets/js/ace-extra.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

<!--[if lt IE 9]>
		<script src="${ctx}/ace/assets/js/html5shiv.js"></script>
		<script src="${ctx}/ace/assets/js/respond.min.js"></script>
		<![endif]-->
		
	<script type="text/javascript">
		ctx = '${ctx}';
	</script>
</head>

<body style="background-color:#fff">
<div class="page-content" style="background-color:#fff;min-width: 800px">
	<jsp:include page="${page.contentPage}"></jsp:include>
</div>
	<!--[if !IE]> -->

	<script type="text/javascript">
		window.jQuery
				|| document
						.write("<script src='${ctx}/ace/assets/js/jquery-2.0.3.min.js'>"
								+ "<"+"/script>");
	</script>

	<!-- <![endif]-->

	<!--[if IE]>
		<script type="text/javascript">
		 window.jQuery || document.write("<script src='${ctx}/ace/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
		</script>
		<![endif]-->

	<script type="text/javascript">
		if ("ontouchend" in document)
			document
					.write("<script src='${ctx}/ace/assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>
	<script src="${ctx}/ace/assets/js/bootstrap.min.js"></script>
	<script src="${ctx}/ace/assets/js/typeahead-bs2.min.js"></script>

	<!-- page specific plugin scripts -->

	<script src="${ctx}/ace/assets/js/jquery.dataTables.min.js"></script>
	<script src="${ctx}/ace/assets/js/jquery.dataTables.bootstrap.js"></script>

	<!-- ace scripts -->

	<script src="${ctx}/ace/assets/js/ace-elements.min.js"></script>
	<script src="${ctx}/ace/assets/js/ace.min.js"></script>
	<script src="${ctx}/ace/assets/js/angular.min.js"></script>
	<script src="${ctx}/ace/assets/js/directive/excDirective.js"></script>
	<script src="${ctx}/ace/assets/js/service/excService.js"></script>
	<script src="${ctx}/ace/assets/js/controller/table.js"></script>
	<script src="${ctx}/ace/assets/js/filter/excFilter.js"></script>
	<script src="${ctx}/ace/assets/js/layer/layer.js"></script>
	<script src="${ctx}/ace/assets/js/layer/layer2.js"></script>
	<!-- inline scripts related to this page -->
</body>
</html>
