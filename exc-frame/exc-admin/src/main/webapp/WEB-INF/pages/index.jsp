<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Bootstrap表格插件 - Bootstrap后台管理系统模版Ace下载</title>
<meta name="keywords"
	content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
<meta name="description"
	content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- basic styles -->

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

<body>
	<div class="navbar navbar-default" id="navbar">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> Ace Admin
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">

					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${ctx}/ace/assets/avatars/user.jpg" alt="Jason's Photo" />
							<span class="user-info"> <small>Welcome,</small> Jason
						</span> <i class="icon-caret-down"></i>
					</a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="icon-off"></i>退出
							</a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<div class="sidebar" id="sidebar">
				<!-- #sidebar-shortcuts -->
				<ul class="nav nav-list">
					<li class="active"><a href="index.html"> <i
							class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span>
					</a></li>

					<li><a href="typography.html"> <i class="icon-text-width"></i>
							<span class="menu-text"> 文字排版 </span>
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-desktop"></i> <span class="menu-text"> UI 组件 </span>

							<b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="elements.html"> <i
									class="icon-double-angle-right"></i> 组件
							</a></li>

							<li><a href="buttons.html"> <i
									class="icon-double-angle-right"></i> 按钮 &amp; 图表
							</a></li>

							<li><a href="treeview.html"> <i
									class="icon-double-angle-right"></i> 树菜单
							</a></li>

							<li><a href="jquery-ui.html"> <i
									class="icon-double-angle-right"></i> jQuery UI
							</a></li>

							<li><a href="nestable-list.html"> <i
									class="icon-double-angle-right"></i> 可拖拽列表
							</a></li>

							<li><a href="#" class="dropdown-toggle"> <i
									class="icon-double-angle-right"></i> 三级菜单 <b
									class="arrow icon-angle-down"></b>
							</a>

								<ul class="submenu">
									<li><a href="#"> <i class="icon-leaf"></i> 第一级
									</a></li>

									<li><a href="#" class="dropdown-toggle"> <i
											class="icon-pencil"></i> 第四级 <b class="arrow icon-angle-down"></b>
									</a>

										<ul class="submenu">
											<li><a href="#"> <i class="icon-plus"></i> 添加产品
											</a></li>

											<li><a href="#"> <i class="icon-eye-open"></i> 查看商品
											</a></li>
										</ul></li>
								</ul></li>
						</ul></li>

					<li class="active open"><a href="#" class="dropdown-toggle">
							<i class="icon-list"></i> <span class="menu-text"> 表格 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li class="active"><a href="tables.html"> <i
									class="icon-double-angle-right"></i> 简单 &amp; 动态
							</a></li>

							<li><a href="jqgrid.html"> <i
									class="icon-double-angle-right"></i> jqGrid plugin
							</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-edit"></i> <span class="menu-text"> 表单 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="form-elements.html"> <i
									class="icon-double-angle-right"></i> 表单组件
							</a></li>

							<li><a href="form-wizard.html"> <i
									class="icon-double-angle-right"></i> 向导提示 &amp; 验证
							</a></li>

							<li><a href="wysiwyg.html"> <i
									class="icon-double-angle-right"></i> 编辑器
							</a></li>

							<li><a href="dropzone.html"> <i
									class="icon-double-angle-right"></i> 文件上传
							</a></li>
						</ul></li>

					<li><a href="widgets.html"> <i class="icon-list-alt"></i>
							<span class="menu-text"> 插件 </span>
					</a></li>

					<li><a href="calendar.html"> <i class="icon-calendar"></i>

							<span class="menu-text"> 日历 <span
								class="badge badge-transparent tooltip-error"
								title="2&nbsp;Important&nbsp;Events"> <i
									class="icon-warning-sign red bigger-130"></i>
							</span>
						</span>
					</a></li>

					<li><a href="gallery.html"> <i class="icon-picture"></i> <span
							class="menu-text"> 相册 </span>
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-tag"></i> <span class="menu-text"> 更多页面 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="profile.html"> <i
									class="icon-double-angle-right"></i> 用户信息
							</a></li>

							<li><a href="inbox.html"> <i
									class="icon-double-angle-right"></i> 收件箱
							</a></li>

							<li><a href="pricing.html"> <i
									class="icon-double-angle-right"></i> 售价单
							</a></li>

							<li><a href="invoice.html"> <i
									class="icon-double-angle-right"></i> 购物车
							</a></li>

							<li><a href="timeline.html"> <i
									class="icon-double-angle-right"></i> 时间轴
							</a></li>

							<li><a href="login.html"> <i
									class="icon-double-angle-right"></i> 登录 &amp; 注册
							</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-file-alt"></i> <span class="menu-text"> 其他页面 <span
								class="badge badge-primary ">5</span>
						</span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="faq.html"> <i
									class="icon-double-angle-right"></i> 帮助
							</a></li>

							<li><a href="error-404.html"> <i
									class="icon-double-angle-right"></i> 404错误页面
							</a></li>

							<li><a href="error-500.html"> <i
									class="icon-double-angle-right"></i> 500错误页面
							</a></li>

							<li><a href="grid.html"> <i
									class="icon-double-angle-right"></i> 网格
							</a></li>

							<li><a href="blank.html"> <i
									class="icon-double-angle-right"></i> 空白页面
							</a></li>
						</ul></li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content" ng-app="tableApp" ng-controller="tableCtrl" >
				<div class="breadcrumbs" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="icon-home home-icon"></i> <a href="#">Home</a>
						</li>

						<li><a href="#">Tables</a></li>
						<li class="active">Simple &amp; Dynamic</li>
					</ul>
				</div>

				<jsp:include page="${page.contentPage}"></jsp:include>
			</div>
		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->


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

	<script type="text/javascript">
		jQuery(function($) {

			$('table th input:checkbox').on(
					'click',
					function() {
						var that = this;
						$(this).closest('table').find(
								'tr > td:first-child input:checkbox').each(
								function() {
									this.checked = that.checked;
									$(this).closest('tr').toggleClass(
											'selected');
								});

					});

		})
	</script>
	
</body>
</html>
