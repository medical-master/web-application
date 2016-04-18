<%@page pageEncoding="UTF-8"%>
<form action="action" method="post">
	<div class="container">
		<div class="row clearfix">
			<div class="form-group">
				<label for="stationNameInput">工作站名称</label> <input type="text"
					class="form-control" id="stationNameInput" name="name"
					placeholder="工作站名称">
			</div>
			<div class="form-group">
				<label for="stationKeywordsInput">关键字词</label> <input type="text"
					class="form-control" id="stationKeywordsInput" name="keywords"
					placeholder="关键字词">
			</div>
			<div class="form-group">
				<label for="stationSummeryInput">工作站简介</label>
				<textarea class="form-control" rows="3" id="stationSummeryInput"
					name="summery" maxlength="200" placeholder="工作站简介"></textarea>
			</div>
			<div class="form-group">
				<label for="StationDescriptionInput">工作站描述</label>
				<textarea class="form-control" rows="5" id="StationDescriptionInput"
					name="description" maxlength="200" placeholder="方案描述"></textarea>
			</div>
			<div class="form-group">
				<input type="hidden" name="userId" value="1"> <input
					type="hidden" name="action" value="create"> <input
					type="hidden" name="module" value="workstation">
				<button type="submit" class="btn btn-default">提交</button>
			</div>
		</div>
	</div>
</form>