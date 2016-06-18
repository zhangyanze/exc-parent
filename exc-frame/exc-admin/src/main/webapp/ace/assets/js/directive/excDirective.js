var excDirective = angular.module("excDirective", ['excService'])
	.directive('search', function() {
	  return {
	    restrict: 'EA',
	    templateUrl: ctx+'/ace/assets/js/directive/search.html',
	    replace: true,
	    scope: {
	    	searchConf: '='
        },
	    link: function(scope, element, attrs, ctrls) {
	    	scope.action = scope.searchConf.action;
	    	if(scope.searchConf.search){
            	scope.searchConf.search();
            }
	    }
	  };
	})
	.directive('pagination',[function(){
	    return {
	        restrict: 'EA',
	        template: '<div class="page-list">' +
	            '<ul class="pagination" ng-show="pageConf.totalItems > 0">' +
	            '<li ng-class="{disabled: pageConf.currentPage == 1}" ng-click="prevPage()"><span>&laquo;</span></li>' +
	            '<li ng-repeat="item in pageList track by $index" ng-class="{active: item == pageConf.currentPage, separate: item == \'...\'}" ' +
	            'ng-click="changeCurrentPage(item)">' +
	            '<span>{{ item }}</span>' +
	            '</li>' +
	            '<li ng-class="{disabled: pageConf.currentPage == pageConf.numberOfPages}" ng-click="nextPage()"><span>&raquo;</span></li>' +
	            '</ul>' +
	            '<div class="page-total" ng-show="pageConf.totalItems > 0">' +
	            '第<input type="text" ng-model="jumpPageNum"  ng-blur="jumpToPage($event)"/>页 ' +
	            '每页<select ng-model="pageConf.pageSize" ng-options="option for option in pageConf.perPageOptions " ng-change="changeCurrentPage(1)"></select>' +
	            '/共<strong>{{ pageConf.totalItems }}</strong>条' +
	            '</div>' +
	            '<div class="no-items" ng-show="pageConf.totalItems <= 0">暂无数据</div>' +
	            '</div>',
	        replace: true,
	        scope: {
	        	pageConf: '='
	        },
	        link: function(scope, element, attrs){
	            // 变更当前页
	            scope.changeCurrentPage = function(item) {
	                if(item == '...'){
	                    return;
	                }else{
	                    scope.pageConf.currentPage = item;
	                    if(scope.pageConf.onChange){
	                    	scope.pageConf.onChange();
    	                }
	                }
	            };

	            // 定义分页的长度必须为奇数 (default:9)
	            scope.pageConf.pagesLength = parseInt(scope.pageConf.pagesLength) ? parseInt(scope.pageConf.pagesLength) : 15 ;
	            if(scope.pageConf.pagesLength % 2 === 0){
	                // 如果不是奇数的时候处理一下
	                scope.pageConf.pagesLength = scope.pageConf.pagesLength -1;
	            }

	            // conf.erPageOptions
	            if(!scope.pageConf.perPageOptions){
	                scope.pageConf.perPageOptions = [10, 15, 20, 30, 50];
	            }

	            // pageList数组
	            function getPagination(newValue, oldValue) {
	                
	                // conf.currentPage
	                scope.pageConf.currentPage = parseInt(scope.pageConf.currentPage) ? parseInt(scope.pageConf.currentPage) : 1;
	                
	                // conf.totalItems
	                scope.pageConf.totalItems = parseInt(scope.pageConf.totalItems) ? parseInt(scope.pageConf.totalItems) : 0;

	                // conf.pageSize (default:15)
	                scope.pageConf.pageSize = parseInt(scope.pageConf.pageSize) ? parseInt(scope.pageConf.pageSize) : 15;

	                // numberOfPages
	                scope.pageConf.numberOfPages = Math.ceil(scope.pageConf.totalItems/scope.pageConf.pageSize);

	                // judge currentPage > scope.numberOfPages
	                if(scope.pageConf.currentPage < 1){
	                    scope.pageConf.currentPage = 1;
	                }

	                // 如果分页总数>0，并且当前页大于分页总数
	                if(scope.pageConf.numberOfPages > 0 && scope.pageConf.currentPage > scope.pageConf.numberOfPages){
	                    scope.pageConf.currentPage = scope.pageConf.numberOfPages;
	                }

	                // jumpPageNum
	                scope.jumpPageNum = scope.pageConf.currentPage;

	                // 如果pageSize在不在perPageOptions数组中，就把pageSize加入这个数组中
	                var perPageOptionsLength = scope.pageConf.perPageOptions.length;
	                // 定义状态
	                var perPageOptionsStatus;
	                for(var i = 0; i < perPageOptionsLength; i++){
	                    if(scope.pageConf.perPageOptions[i] == scope.pageConf.pageSize){
	                        perPageOptionsStatus = true;
	                    }
	                }
	                // 如果pageSize在不在perPageOptions数组中，就把pageSize加入这个数组中
	                if(!perPageOptionsStatus){
	                    scope.pageConf.perPageOptions.push(scope.pageConf.pageSize);
	                }

	                // 对选项进行sort
	                scope.pageConf.perPageOptions.sort(function(a, b){return a-b});

	                scope.pageList = [];
	                if(scope.pageConf.numberOfPages <= scope.pageConf.pagesLength){
	                    // 判断总页数如果小于等于分页的长度，若小于则直接显示
	                    for(i =1; i <= scope.pageConf.numberOfPages; i++){
	                        scope.pageList.push(i);
	                    }
	                }else{
	                    // 总页数大于分页长度（此时分为三种情况：1.左边没有...2.右边没有...3.左右都有...）
	                    // 计算中心偏移量
	                    var offset = (scope.pageConf.pagesLength - 1)/2;
	                    if(scope.pageConf.currentPage <= offset){
	                        // 左边没有...
	                        for(i =1; i <= offset +1; i++){
	                            scope.pageList.push(i);
	                        }
	                        scope.pageList.push('...');
	                        scope.pageList.push(scope.pageConf.numberOfPages);
	                    }else if(scope.pageConf.currentPage > scope.pageConf.numberOfPages - offset){
	                        scope.pageList.push(1);
	                        scope.pageList.push('...');
	                        for(i = offset + 1; i >= 1; i--){
	                            scope.pageList.push(scope.pageConf.numberOfPages - i);
	                        }
	                        scope.pageList.push(scope.pageConf.numberOfPages);
	                    }else{
	                        // 最后一种情况，两边都有...
	                        scope.pageList.push(1);
	                        scope.pageList.push('...');

	                        for(i = Math.ceil(offset/2) ; i >= 1; i--){
	                            scope.pageList.push(scope.pageConf.currentPage - i);
	                        }
	                        scope.pageList.push(scope.pageConf.currentPage);
	                        for(i = 1; i <= offset/2; i++){
	                            scope.pageList.push(scope.pageConf.currentPage + i);
	                        }

	                        scope.pageList.push('...');
	                        scope.pageList.push(scope.pageConf.numberOfPages);
	                    }
	                }

	                /*if(scope.pageConf.onChange){

	                    // 防止初始化两次请求问题
	                    if(!(oldValue != newValue && oldValue[0] == 0)) {
	                        scope.pageConf.onChange();
	                    }
	                    
	                }*/
	                scope.$parent.pageConf = scope.pageConf;
	            }

	            // prevPage
	            scope.prevPage = function(){
	                if(scope.pageConf.currentPage > 1){
	                    scope.pageConf.currentPage -= 1;
	                    if(scope.pageConf.onChange){
	                    	scope.pageConf.onChange();
    	                }
	                }
	            };
	            // nextPage
	            scope.nextPage = function(){
	                if(scope.pageConf.currentPage < scope.pageConf.numberOfPages){
	                    scope.pageConf.currentPage += 1;
	                    if(scope.pageConf.onChange){
	                    	scope.pageConf.onChange();
    	                }
	                }
	            };

	            // 跳转页
	            scope.jumpToPage = function(){
	                scope.jumpPageNum = scope.jumpPageNum.replace(/[^0-9]/g,'');
	                if(scope.jumpPageNum !== ''){
	                    scope.pageConf.currentPage = scope.jumpPageNum;
	                    if(scope.pageConf.onChange){
	                    	scope.pageConf.onChange();
    	                }
	                }
	            };

	            

	            scope.$watch(function() {

	                if(!scope.pageConf.totalItems) {
	                    scope.pageConf.totalItems = 0;
	                }
	                var newValue = scope.pageConf.totalItems + ' ' +  scope.pageConf.currentPage + ' ' + scope.pageConf.pageSize;
    	                return newValue;

    	            }, getPagination);

    	        }
    	    };
    	}])
    	.directive('excTable',[function(excHttp){
	    return {
	        restrict: 'EA',
	        templateUrl: ctx+'/ace/assets/js/directive/table.html',
	        replace: true,
	        scope: {
	            tableConf: '='
	        },
	        link: function(scope, element, attrs){
	        	scope.tableConf.key = scope.tableConf.key ? scope.tableConf.key : "id";
	        	scope.tableConf.selected = [];
	        	scope.tableConf.edits = [];
	        	scope.editDatas = [];
	        	scope.checkAll = function($event){
	        		scope.tableConf.selected = [];
	        		var that = $event.target;
	        		if(that.checked){
	        			angular.forEach(scope.tableConf.datas, function(data){
	        				scope.tableConf.selected.push(data.id);
		        		});
	        		}
	        	}
	        	
	        	scope.check = function(val, $event) {
	                $event.stopPropagation();
	                var valx = scope.tableConf.selected.indexOf(val);
	                if(valx>=0){
	                	scope.tableConf.selected.splice(valx,1);
	                }else{
	                	scope.tableConf.selected.push(val);	
	                }
	            };
	            
	        	scope.editRow = function(index, $event){
	        		  $event.stopPropagation();
	        		  scope.editDatas[index] = angular.copy(scope.tableConf.datas[index]);
	        		  scope.tableConf.edits[index] = true;
	        	}
	        	
	        	scope.delRow = function(index, $event){
	        		$event.stopPropagation();
	        		if(scope.tableConf.delFun){
	        			scope.tableConf.delFun(index, $event);
	        		}else if(true){
		        		var data = scope.tableConf.datas.splice(index,1);
		        		scope.tableConf.edits[index] = false;
		        		console.log(excHttp);
		        		excHttp.post("test",data).success(function(data) {
		 	        	   console.log(data);
		        		});
	        		}	
	        		  
	        	}
	        	
	        	scope.cancelRow = function(index, $event){
	        		  $event.stopPropagation();
	        		  scope.tableConf.datas[index] = scope.editDatas[index];
	        		  scope.tableConf.edits[index] = false;
	        	}
	        	
	        	scope.submitRow = function(index, $event){
	        		  $event.stopPropagation();
	        		  var data = scope.tableConf.datas[index];
	        		  
	        		  scope.tableConf.edits[index] = false;
	        	}
	        	
	            scope.isSelected = function(val){
	            	return scope.tableConf.selected.indexOf(val)>=0;
	            };
	            
	            scope.isSelectAll = function(){
	            	if(scope.tableConf.datas){
	            		return scope.tableConf.selected.length == scope.tableConf.datas.length;
	            	}
	            	return false;
	            };
	            
	        	scope.tableConf.getSelected = function(){
	        		return scope.tableConf.selected;
	        	}
	        	
	        	scope.tableConf.getSelectedData = function(){
	        		var datas = [];
	        		angular.forEach(scope.tableConf.selected, function(selKey){
	        			angular.forEach(scope.tableConf.datas, function(data){
	        				if(selKey == data[scope.tableConf.key]){
	        					datas.push(data);
	        					return;
	        				}
		        		});
	        		});
	        		return datas;
	        	}
	        }
	    };
	}])
	.directive('tools',[function(){
	    return {
	        restrict: 'EA',
	        templateUrl: ctx+'/ace/assets/js/directive/tools.html',
	        replace: true,
	       /* scope: {
	            toolConf: '='
	        },*/
	        link: function(scope, element, attrs){
	        	scope.exc=function(c){
	        		var _click = c.click+"('"+c.text+"','"+c.url+"','"+c.id+"','"+c.remark+"')";
	        		eval("scope."+_click);
	        	}
	        }
	    };
	}]);
