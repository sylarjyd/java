/**
 * http://usejsdoc.org/
 */
var vue;
$(function(){
	vue = new Vue({
		el:'#app',
		data:{
			userInfo:{
				username:'',
				password:''
			}
		},
		mounted:function(){
			
		},
		methods:{
			addUser:function(){
				var obj = this;
				$.post('/userInfo/add',{username:obj.userInfo.username,
					password:obj.userInfo.password
					},function(data){
						obj.$messagebox.alert(data.msg);
				},"json");
			} 
		}
		
	});
});