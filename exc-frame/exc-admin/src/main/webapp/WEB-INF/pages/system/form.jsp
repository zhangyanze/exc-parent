<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
	page = ${jsonForms};
</script>
<div class="row" ng-app="tableApp" ng-controller="formCtrl">
	<div class="space-4"></div>
	<div class="col-xs-12">
		<form class="form-horizontal" role="form">
			<div ng-repeat="form in page.forms" class="form-group" style="border-bottom: 1px dashed #d5e4f1;padding-bottom: 10px;margin-bottom:10px">
				<label class="col-sm-2 control-label no-padding-right" for="{{form.id}}" ng-bind="form.text">
				</label>
				<div class="col-sm-10">
					<input ng-if="form.type == 'text'" type="text" id="{{form.id}}" name="{{form.name}}" ng-model="data[form.name]" class="col-xs-10 col-sm-5" />
					<span class="help-inline col-xs-12 col-sm-7" ng-if="form.remark != null && form.remark !=''">
						<span class="middle help-button">?</span><span class="middle orange" ng-bind="form.remark"></span>
					</span>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">
				</label>
				<div class="col-sm-10">
					<input type="submit" class="dybtn dybtn-save" ng-click="submit()"  value="保存" />
	       			<input type="button" ng-click="cancel()" class="dybtn dybtn-cancel" value="取消" />
				</div>
			</div> 
			
		</form>
	</div>
</div>
