var excService = angular.module("excService", [])
.factory("excHttp", function($http) {
	var d = {};
    return {
        post: function(url,param) {
        	return $http({
	               method: 'POST',
	               url: url,
	               data: $.param(param), 
	               headers: {
	                   'Content-Type': 'application/x-www-form-urlencoded'
	               },
	               cache: true
	           })
        },
        get:function(){
        	return $http({
	               method: 'GET',
	               url: url,
	               data: $.param(param), 
	               headers: {
	                   'Content-Type': 'application/x-www-form-urlencoded'
	               },
	               cache: true
	           })
        }
    };
})