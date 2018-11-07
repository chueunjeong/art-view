<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<h1>ART-VIEW TEST</h1>

<a href="user/list">user/list</a> <br />

<h1>
    S3 이미지 업로더
</h1>
<div class="col-md-12">
    <div class="col-md-2">
        <form name="form" action="api/upload" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <p>파일 업로드</p>
				<input type="file" class="btn btn-lg " value="파일첨부" style="margin-top:-15px;" name="file"/>
            </div>
            <button type="submit" class="btn btn-primary" id="btn-save">저장</button>
        </form>
    </div>
</div>

</body>
</html>
