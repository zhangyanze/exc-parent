if (! ("exc" in window)) {
    window.exc = {}
}
jQuery(function(a) {
	window.exc.succMsg = function(msg){
    	layer.msg(msg, {icon: 6,time:1000});
    }
	
    window.exc.errorMsg = function(msg){
    	layer.msg(msg, {icon: 5,time:1000});
    }
    window.exc.confirm = function(msg,fun){
    	layer.confirm(msg, {icon: 3, title:'提示'}, function(index){
    	  fun;
      	  layer.close(index);
      	});
    }
    window.exc.open = function(title,url){
    	console.log(url);
    	layer.open({
            type: 2,
            title: title,
            shadeClose: true,
            maxmin: true,
            fix: false,
            area: ['900px', '500px'],
            content: url
        });
    }
    
});