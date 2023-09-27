<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>user5::modify</title>
	</head>
	<body>
		<h3>user5 수정</h3>
		
		<a href="/Ch05/index">메인</a>
		<a href="/Ch05/user5/list">목록</a>
		
		<form action="/Ch05/user5/modify" method="post">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td><input type="text" name="uid" value="${user5DTO.uid}" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" value="${user5DTO.name}"/></td>
				</tr>
				<tr>
					<td>휴대폰</td>
					<td><input type="text" name="hp" value="${user5DTO.hp}"></td>
				</tr>
				<tr>
					<td>나이</td>
					<td><input type="number" name="age" value="${user5DTO.age}"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><input type="submit" value="수정하기"/></td>
				</tr>
			</table>
		</form>		
	</body>
</html>