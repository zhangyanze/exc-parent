 var excFilter = angular.module('excFilter', []);  
 excFilter.filter('test', function() {  
   return function(input, param,param1) { 
	   console.log("input"+input);
	   console.log("param:"+param);
	   console.log("param1:"+param1);
	   var exc = param+"("+input+")";
      return eval(exc);  
   };  
 });