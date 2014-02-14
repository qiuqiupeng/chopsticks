<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>

<script type="text/javascript">
<!--
	$.subscribe('openURL', function(event, data) {
		var s;
		s = $(data).attr("id");
		$("#echo").val(s);
		$("#formSubmit").click();
	});
//-->
</script>

<s:form id="form_echo" action="echo" theme="simple" cssClass="yform">
	<s:url id="echoAction" action="echo" />
	<s:hidden id="echo" name="echo" />
	<sj:submit id="formSubmit" href="%{echoAction}" targets="content"
		cssStyle="display:none;" formIds="form_echo" />

</s:form>

	<div class="sidebar" id="sidebar">
		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'fixed');
			} catch (e) {
			}
		</script>

		<div class="sidebar-shortcuts" id="sidebar-shortcuts">
			<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
				<button class="btn btn-success">
					<i class="icon-signal"></i>
				</button>

				<button class="btn btn-info">
					<i class="icon-pencil"></i>
				</button>

				<button class="btn btn-warning">
					<i class="icon-group"></i>
				</button>

				<button class="btn btn-danger">
					<i class="icon-cogs"></i>
				</button>
			</div>

			<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
				<span class="btn btn-success"></span> <span class="btn btn-info"></span>

				<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
			</div>
		</div>

		<ul class="nav nav-list">
			<li class="active"><a href="index"> <i
					class="icon-dashboard"></i> <span class="menu-text"> 欢迎 </span>
			</a></li>

			<s:iterator value="items">
				<s:if test="isleaf">
					<!-- 菜单页节点 -->
					<li><sj:a onClickTopics="openURL" id="%{getText(id)}" href="#">
							<i class="<s:property value="icon" />"></i>
							<span class="menu-text"><s:property value="name" /></span>
						</sj:a></li>
				</s:if>
				<s:else>
					<!-- 非菜单页节点 -->
					<li><a href="#" Class="dropdown-toggle"> <i
							class="<s:property value="icon" />"> </i> <span class="menu-text"><s:property
									value="name" /></span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<s:iterator value="subMenu">
								<s:if test="isleaf">
									<li><sj:a onClickTopics="openURL" id="%{getText(id)}"
											href="#">
											<i class="icon-double-angle-right"></i>
											<s:property value="name" />
										</sj:a></li>
								</s:if>
								<s:else>
									<li><a href="#" class="dropdown-toggle"> <i
											class="icon-double-angle-right"></i> <s:property value="name" />
											<b class="arrow icon-angle-down"></b>
									</a>

										<ul class="submenu">
											<s:iterator value="subMenu">
												<li><sj:a onClickTopics="openURL" id="%{getText(subMenu.id)}"
														href="#">
														<i class="<s:property value="icon" />"></i>
														<s:property value="name" />
													</sj:a></li>
											</s:iterator>
										</ul></li>
								</s:else>

							</s:iterator>
						</ul></li>
				</s:else>
			</s:iterator>

		</ul>
		<!-- /.nav-list -->

		<div class="sidebar-collapse" id="sidebar-collapse">
			<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
				data-icon2="icon-double-angle-right"></i>
		</div>

		<script type="text/javascript">
			try {
				ace.settings.check('sidebar', 'collapsed');
			} catch (e) {
			}
		</script>
	</div>




<script src="js/ace-elements.min.js"></script>
<script src="js/ace.min.js"></script>