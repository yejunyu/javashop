<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/manage/product/upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>

<form action="/manage/product/rich_img_upload.do" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="富文本上传">
</form>
</body>
</html>
