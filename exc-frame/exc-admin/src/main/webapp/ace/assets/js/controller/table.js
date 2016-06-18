var app = angular.module('tableApp', ['excDirective','excService','excFilter']);
	app.controller('tableCtrl', function($scope,$http,excHttp) {
		//分页配置
		$scope.pageConf = {
            onChange : function(){
            	$scope.search();
            }
	    };
		//搜索配置
		$scope.searchConf = {
			form:page.searchs,
			action:page.url,
			searchData:{},
			search:function(){
				$scope.pageConf.currentPage=1;
				$scope.search();
			}
		};
		//按钮配置
		$scope.toolConf = {
			toolList:page.tools	
		};
		//表格配置
		$scope.tableConf = {
			check:"multi",
			index:true,
			editTable:true,
			headers:page.tables
		};
		
	   	$scope.search = function(){
	   		$scope.tableConf.edits = [];
	   		var param = $scope.searchConf.searchData;
	   		param.currentPage = $scope.pageConf.currentPage;
	   		param.pageSize = $scope.pageConf.pageSize;
	   		excHttp.post($scope.searchConf.action,param).success(function(data) {
	        	   $scope.tableConf.datas = data.data;
	        	   $scope.pageConf.totalItems = data.totalItems;
	          });
	   	}
	   	
	   	$scope.del = function(){
			$scope.tableConf.edit = true;
			exc.confirm("是否确认删除");
			console.log($scope.tableConf.getSelected());
			console.log($scope.tableConf.getSelectedData());
		}
		
		$scope.open = function(text,url,id,remark){
    		exc.open(text,ctx+url);
    	}
		
	});
	
	app.controller('formCtrl', function($scope,$http,excHttp) {
		$scope.page = page;
		$scope.data = {};
		$scope.cancel = function(){
			var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
			parent.layer.close(index); //再执行关闭       
		};
		$scope.submit = function(){
			excHttp.post($scope.page.submit_url,$scope.data).success(function(data) {
				var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
				parent.layer.close(index); //再执行关闭       
	         });
		};
	});
