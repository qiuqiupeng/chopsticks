<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>

<html>
<head>

<sj:head jqueryui="true" locale="cn" />

<style type="text/css">
input {
	width: 100px;
}

select {
	width: auto;
	height: auto;
	padding: 0px 0px;
}
</style>

<script type="text/javascript">
	$.subscribe('getselectedids', function(event, data) {
		var s;
		s = $("#gridtable").jqGrid('getGridParam', 'selarrrow');
		$("#rowid").val(s);
		$("#a_funcmenu_list_del").click();
	});

	$.subscribe('openrowselect', function(event, data) {
		$("#rowid").val(event.originalEvent.rowid);
		$("#a_funcmenu_list_show").click();
	});
</script>

</head>
<body>
	<s:form id="form" action="" theme="simple"
		cssClass="form-horizontal no-margin">
		<s:hidden id="rowid" name="rowid" />

		<div class="page-header">
			<div class="span2 pull-left">
				<h2>用户列表</h2>
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
						<!-- 双击行打开 -->
						<s:url id="action_funcmenu_list_show" action="/funcmenu-edit"
							namespace="/system" />
						<sj:a id="a_funcmenu_list_show" targets="content"
							href="%{action_funcmenu_list_show}" formIds="form" />
						<!-- 新增 -->
						<s:url id="action_funcmenu_list_new" action="funcmenu-edit"
							namespace="/system" />
						<sj:a targets="content" cssClass="btn btn-success"
							href="%{action_funcmenu_list_new}">
							<span class="fs1" data-icon="&#xe102;"></span> 新增</sj:a>
						<!-- 批量删除 -->
						<s:url id="action_funcmenu_list_del" action="/funcmenu-list!delete"
							namespace="/system" />
						<sj:a id="a_funcmenu_list_del" targets="content"
							href="%{action_funcmenu_list_del}" formIds="form" />
						<sj:a cssClass="btn btn-warning2 hidden-tablet"
							onClickTopics="getselectedids">
							<span class="fs1" data-icon="&#xe0fd;"></span> 删除</sj:a>

						<button class="btn btn-warning input-top-margin" type="button">
							<span class="fs1" data-icon="&#xe14a;"></span> 刷新
						</button>
						<button class="btn btn-danger input-top-margin" type="button">
							<span class="fs1" data-icon="&#xe087;"></span> 修改密码</button>
						<button class="btn btn-primary input-top-margin" type="button">
							<span class="fs1" data-icon="&#xe08a;"></span> 解锁</button>
						<div class="btn-group input-top-margin">
							<button class="btn btn-info">其他</button>
							<button data-toggle="dropdown"
								class="btn btn-info dropdown-toggle">
								<span class="caret"> </span>
							</button>
							<ul class="dropdown-menu pull-right">
								<li><a href="#" data-original-title=""> Action </a></li>
								<li><a href="#" data-original-title=""> Another action
								</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<!-- 操作框 结束-->
			<div class="clearfix"></div>
		</div>

		<s:url id="remoteurl" action="funcmenu-data-provider" namespace="/json" />
		<sjg:grid id="gridtable" caption="用户列表" dataType="json"
			href="%{remoteurl}" pager="true" gridModel="gridModel" width="1024"
			height="365" shrinkToFit="false" rowList="10,15,20" rowNum="15"
			viewrecords="true" rownumbers="true" resizable="true"
			multiselect="true" onDblClickRowTopics="openrowselect">
			<sjg:gridColumn name="id" index="id" title="ID" sortable="false"
				hidden="true" />
			<sjg:gridColumn name="name" index="name" title="Name" sortable="true" />
			<sjg:gridColumn name="number" index="number" title="number"
				sortable="false" />
			<sjg:gridColumn name="email" index="email" title="email"
				sortable="false" />
		</sjg:grid>
	</s:form>
</body>
</html>