function login() {
	$.model.loading($("#btnSubmit").data("loading"));
	var username = $("input[name='username']").val();
	var password = $("input[name='password']").val();
	$.ajax({
		type: "post",
		url: "http://127.0.0.1:8081/user/login",
		async: true,
		data:{
			"username":username,
			"password":password
		},
		success:function(r){
			if(r.code == 500){
				location.href = "http://localhost:8081/index.html"
			}else{
				location.href = "http://localhost:8081/list.html:"
			}
		}
	})
}