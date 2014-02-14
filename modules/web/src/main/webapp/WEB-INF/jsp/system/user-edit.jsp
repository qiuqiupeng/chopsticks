<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>


<html>
<head>
<%@ include file="/WEB-INF/jsp/commons/csslibs.jsp"%>
</head>
<body>

	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li>用户</li>
			<li class="active">用户编辑</li>
		</ul>
		<!-- .breadcrumb -->
	</div>

	<s:form id="form" action="" theme="simple"
		cssClass="form-horizontal no-margin">
		<s:hidden name="rowid" />
		<s:hidden name="user.id" />

		<div class="page-content">
			<div class="row">
				<div class="col-xs-12 col-sm-12 widget-container-span">
					<div class="widget-box transparent">
						<div class="widget-header">
							<!-- 新增 -->
							<s:url id="action_edit_back" action="user-list"
								namespace="/system" />
							<sj:a targets="content" href="%{action_edit_back}">
								<span class="btn btn-info btn-xs tooltip-info"
									data-rel="tooltip" data-placement="bottom" title="返回列表"><i
									class="icon-backward"></i> 返回</span>
							</sj:a>

							<s:url id="action_edit_new" action="user-edit"
								namespace="/system" />
							<sj:a targets="content" href="%{action_edit_new}">
								<span class="btn btn-info btn-xs tooltip-info"
									data-rel="tooltip" data-placement="bottom" title="新增"><i
									class="icon-plus"></i> 新增</span>
							</sj:a>
							<!-- 批量删除 -->
							<s:url id="action_edit_del" action="/user-edit!delete"
								namespace="/system" />
							<sj:a id="a_edit_del" href="%{action_edit_del}" targets="content">
								<span class="btn btn-info btn-xs tooltip-info"
									data-rel="tooltip" data-placement="bottom" title="删除记录"><i
									class="icon-remove"></i> 删除</span>
							</sj:a>

							<s:url id="action_edit_save" action="user-edit!save"
								namespace="/system" />
							<sj:a targets="content" href="%{action_edit_save}" formIds="form">
								<span class="btn btn-info btn-xs tooltip-info"
									data-rel="tooltip" data-placement="bottom" title="保存记录"><i
									class="icon-save"></i> 保存</span>
							</sj:a>

							<div class="widget-toolbar">
								<a href="#" data-action="close"> <i class="icon-remove"></i>
								</a>
							</div>
						</div>
						<div class="widget-body">
							<h5>登录 信息</h5>
							<hr>
							<div class="col-xs-12 col-lg-4">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 用户名 </label>
									<div class="col-sm-9">
										<s:textfield name="user.number" cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> Email ID </label>
									<div class="col-sm-9">
										<s:textfield name="user.email" cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 密码 </label>
									<div class="col-sm-9">
										<s:password name="user.password"
											cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 姓名 </label>
									<div class="col-sm-9">
										<s:textfield name="user.name" cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>
							</div>
							<div class="col-xs-12 col-lg-4">
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 描述 </label>
									<div class="col-sm-9">
										
									</div>
								</div>

								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 代理用户 </label>
									<div class="col-sm-9">
										<s:textfield name="user.agentUser"
											cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 手机 </label>
									<div class="col-sm-9">
										<s:textfield name="user.cellPhone"
											cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label no-padding-right"
										for="form-field-1"> 家庭电话 </label>
									<div class="col-sm-9">
										<s:textfield name="user.homePhone"
											cssClass="col-xs-12 col-sm-12" />
									</div>
								</div>
							</div>
							<div class="col-xs-4 col-lg-2">
								<div class="thumbnail">
									<img class="nav-user-photo" alt="300x200" src="img/profile.png">

								</div>
							</div>

						</div>
					</div>
				</div>
			</div>
		</div>





	</s:form>

	<%@ include file="/WEB-INF/jsp/commons/basicscripts.jsp"%>
</body>
</html>