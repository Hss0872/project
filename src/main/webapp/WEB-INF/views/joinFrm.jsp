<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>joinFrm.jsp-회원가입</h1>
<form action="" name="joinFrm" method="post">
	<table >
		<tr>
			<td colspan="2" class="subject">회원가입</td>
		</tr>
		<tr>
			<td width="100">ID</td>
			<td> <input type="text" id="id" name="m_id">
			<input type="button" id="checkId" value="중복검사"/>
				 <div id="result"> </div>
			</td>
		</tr>
		<tr>
			<td width="100">PW</td>
			<td> <input type="text" id="pwd" name="m_pwd"></td>
		</tr>
		<tr>
			<td width="100">NAME</td>
			<td> <input type="text" id="name" name="m_name"></td>
		</tr>
		<tr>
			<td width="100">BIRTH</td>
			<td> <input type="text" id="birth" name="m_birth"></td>
		</tr>
		<tr>
			<td width="100">ADDR</td>
			<td> <input type="text" id="addr" name="m_addr"></td>
		</tr>
		<tr>
			<td width="100">email</td>
			<td> <input type="text" id="email" name="m_email"></td> <!-- 이미 사용중인 이메일입니다? -->
		</tr>
		<tr>
			<td colspan="2" class="subject"> <input type="submit" value="회원가입"> </td>
		</tr>
	</table>	
</form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

$('#checkId').on('click',function(){
	if($('#id').val()!=''){
		$.ajax({
			type:'get', //post가능
			url:'member/userid',
			data: 'm_id='+$('#id').val(), //{m_id:$('#id').val(),,,,}
		    dataType:'json',    //'html', //사용할수 있는 아이디 입니다.
			success: function(data){
				$('#result').html(data).css('color','blue');
			},
			error:function(err){
				console.log(err);
				$('#result').html(err.responseText).css('color','red');
				console.log("err.status:", err.status);
			}
		});//ajax End
	}
}); //on End

</script>
</body>
</html>