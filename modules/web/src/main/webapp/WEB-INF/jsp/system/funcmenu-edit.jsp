<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>


<s:form id="form" action="echo" theme="simple"
	cssClass="form-horizontal no-margin">
	<s:hidden name="rowid" />
	<div class="page-header">
		<div class="span2 pull-left">
			<h2>用户配置</h2>
		</div>
		<s:if test="hasActionErrors()">
			<div class="span4 pull-left">
				<div class="widget no-margin">
					<div class="widget-body">
						<s:actionerror />
					</div>
				</div>
			</div>
		</s:if>
		<s:if test="hasActionMessages()">
			<div class="span4 pull-left">
				<div class="widget no-margin">
					<div class="widget-body">
						<s:actionmessage />
					</div>
				</div>
			</div>
		</s:if>

		<!-- 操作框 开始 -->
		<div class="span6 pull-right">
			<div class="widget no-margin">
				<div class="widget-body">
					<!-- 新增 -->
					<s:url id="action_edit_back" action="user-list" namespace="/system" />
					<sj:a targets="content" cssClass="btn btn-primary input-top-margin"
						href="%{action_edit_back}">
						<span class="fs1" data-icon="&#xe136;"></span> 返回 </sj:a>

					<s:url id="action_edit_new" action="user-edit" namespace="/system" />
					<sj:a targets="content" cssClass="btn btn-success"
						href="%{action_edit_new}">
						<span class="fs1" data-icon="&#xe102;"></span> 新增 </sj:a>
					<!-- 批量删除 -->
					<s:url id="action_edit_del" action="/user-edit!delete"
						namespace="/system" />
					<sj:a id="a_edit_del" cssClass="btn btn-warning2 hidden-tablet"
						href="%{action_edit_del}" targets="content">
						<span class="fs1" data-icon="&#xe0fd;"></span> 删除 </sj:a>

					<s:url id="action_edit_save" action="user-edit!save"
						namespace="/system" />
					<sj:a targets="content" cssClass="btn btn-success"
						href="%{action_edit_save}">
						<span class="fs1" data-icon="&#xe0fe;"></span> 保存 </sj:a>

					<button class="btn btn-danger input-top-margin" type="button">
						修改密码</button>
					<div class="btn-group input-top-margin">
						<button class="btn btn-info">其他</button>
						<button data-toggle="dropdown"
							class="btn btn-info dropdown-toggle">
							<span class="caret"> </span>
						</button>
						<ul class="dropdown-menu pull-right">
							<li><a href="#" data-original-title=""> Action </a></li>
							<li><a href="#" data-original-title=""> Another action </a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!-- 操作框 结束-->
		<div class="clearfix"></div>
	</div>

	<div class="row-fluid">
		<div class="span12">
			<div class="widget no-margin">
				<s:if test="hasActionMessages()">
					<div class="alert alert-block alert-success fade in">
						<button data-dismiss="alert" class="close" type="button">
							×</button>
						<h4 class="alert-heading">成功!</h4>
						<p>
							<s:label name="messages" />
						</p>
					</div>
				</s:if>

				<div class="widget-header">
					<div class="title">
						<span class="fs1" data-icon="&#xe075;"></span> 编辑配置
					</div>
				</div>
				<div class="widget-body">
					<div class="row-fluid">
						<h5>登录 信息</h5>
						<hr>
						<div class="span6">
							<div class="control-group">
								<label class="control-label"> 用户名 </label>
								<div class="controls controls-row">
									<s:textfield name="user.number" cssClass="span12" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> Email ID </label>
								<div class="controls controls-row">
									<s:textfield name="user.email" cssClass="span12" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> 密码 </label>
								<div class="controls controls-row">
									<s:password name="user.password" cssClass="span12" />
								</div>
							</div>
							<div class="control-group">
								<label class="control-label"> 姓名 </label>
								<div class="controls controls-row">
									<s:textfield name="user.name" cssClass="span12" />
								</div>
							</div>
						</div>
						<div class="span2 offset3">
							<div class="thumbnail">
								<img alt="300x200" src="img/profile.png">

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</s:form>