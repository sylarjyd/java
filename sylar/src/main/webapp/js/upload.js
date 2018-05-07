/**
 * http://usejsdoc.org/
 */

	
$(function(){
	UEDITOR_CONFIG.UEDITOR_HOME_URL = '/plugins/ueditor/'; //一定要用这句话，否则你需要去ueditor.config.js修改路径的配置信息
	var ue = UE.getEditor('editor',{
		//toolbars:[[]], 
	       autoHeightEnabled: true,
	       autoFloatEnabled: true,
	       // 字数统计
	       wordCount:false,
	       // 元素路径
		   elementPathEnabled : false,
		   imageActionName:'testUpload'//定义上传的action名称  
	});
	UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;  
	UE.Editor.prototype.getActionUrl = function(action) {  
	    if (action == 'uploadimage') {//跳转到后来的上传action  
	        return '/testUpload';  
	    } else {  
	        return this._bkGetActionUrl.call(this, action);  
	    }  
	}  
	
	function t(){  
        form.action="/testUpload";  
        form.submit();  
        }  
});
