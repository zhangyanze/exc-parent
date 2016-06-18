<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
	searchAction = "test";
	function sex(a){
		if(a==1){
			return "男";
		}else{
			return "女";
		}
	}
</script>
<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<div class="row">
				<div class="col-xs-12">
					<search search_conf="searchConf"/>
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<tools tool_conf="toolConf" />
				</div>
			</div>
			<div class="row">
				<div class="col-xs-12">
					<exc_table table_conf="tableConf"/>
				</div>
			</div>
			<pagination page_conf="pageConf"></pagination>
		</div>
	</div>
</div>