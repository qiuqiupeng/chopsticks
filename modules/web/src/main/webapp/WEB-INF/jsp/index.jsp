<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>


<!DOCTYPE html>
<html lang="cn">
<head>
<title>OA 办公自动化系统</title>
<sj:head jqueryui="true" locale="cn" />
<%@ include file="/WEB-INF/jsp/commons/csslibs.jsp"%>

<script src="js/bootstrap.min.js"></script>

<!-- ace scripts -->

<script src="js/ace-elements.min.js"></script>
<script src="js/ace.min.js"></script>


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

</head>

<body>
	<div class="navbar navbar-default" id="navbar">
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="#" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> OA 办公自动化系统
				</small>
				</a>
				<!-- /.brand -->
			</div>
			<!-- /.navbar-header -->

			<div class="navbar-header pull-right">
				<ul class="nav ace-nav">
					<li class="grey"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i class="icon-tasks"></i> <span
							class="badge badge-grey">4</span>
					</a>

						<ul
							class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-ok"></i> 4 Tasks
								to complete</li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left">Software Update</span> <span
											class="pull-right">65%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 65%" class="progress-bar "></div>
									</div>
								</s:a></li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left">Hardware Upgrade</span> <span
											class="pull-right">35%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 35%"
											class="progress-bar progress-bar-danger"></div>
									</div>
								</s:a></li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left">Unit Testing</span> <span
											class="pull-right">15%</span>
									</div>

									<div class="progress progress-mini ">
										<div style="width: 15%"
											class="progress-bar progress-bar-warning"></div>
									</div>
								</s:a></li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left">Bug Fixes</span> <span
											class="pull-right">90%</span>
									</div>

									<div class="progress progress-mini progress-striped active">
										<div style="width: 90%"
											class="progress-bar progress-bar-success"></div>
									</div>
								</s:a></li>

							<li><s:a href="#"> See tasks with details <i
										class="icon-arrow-right"></i>
								</s:a></li>
						</ul></li>

					<li class="purple"><s:a data-toggle="dropdown"
							class="dropdown-toggle" href="#">
							<i class="icon-bell-alt icon-animated-bell"></i>
							<span class="badge badge-important">8</span>
						</s:a>

						<ul
							class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-warning-sign"></i>
								8 Notifications</li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-pink icon-comment"></i> New
											Comments
										</span> <span class="pull-right badge badge-info">+12</span>
									</div>
								</s:a></li>

							<li><s:a href="#">
									<i class="btn btn-xs btn-primary icon-user"></i> Bob just signed
									up as an editor ...
							</s:a></li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-success icon-shopping-cart"></i>
											New Orders
										</span> <span class="pull-right badge badge-success">+8</span>
									</div>
								</s:a></li>

							<li><s:a href="#">
									<div class="clearfix">
										<span class="pull-left"> <i
											class="btn btn-xs no-hover btn-info icon-twitter"></i>
											Followers
										</span> <span class="pull-right badge badge-info">+11</span>
									</div>
								</s:a></li>

							<li><s:a href="#"> See all notifications <i
										class="icon-arrow-right"></i>
								</s:a></li>
						</ul></li>

					<li class="green"><s:a data-toggle="dropdown"
							class="dropdown-toggle" href="#">
							<i class="icon-envelope icon-animated-vertical"></i>
							<span class="badge badge-success">5</span>
						</s:a>

						<ul
							class="pull-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="icon-envelope-alt"></i>
								5 Messages</li>

							<li><s:a href="#">
									<img src="avatars/avatar.png" class="msg-photo"
										alt="Alex's Avatar">
									<span class="msg-body"> <span class="msg-title">
											<span class="blue">Alex:</span> Ciao sociis natoque penatibus
											et auctor ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>a
												moment ago</span>
									</span>
									</span>
								</s:a></li>

							<li><s:a href="#">
									<img src="avatars/avatar3.png" class="msg-photo"
										alt="Susan's Avatar">
									<span class="msg-body"> <span class="msg-title">
											<span class="blue">Susan:</span> Vestibulum id ligula porta
											felis euismod ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>20
												minutes ago</span>
									</span>
									</span>
								</s:a></li>

							<li><s:a href="#">
									<img src="avatars/avatar4.png" class="msg-photo"
										alt="Bob's Avatar">
									<span class="msg-body"> <span class="msg-title">
											<span class="blue">Bob:</span> Nullam quis risus eget urna
											mollis ornare ...
									</span> <span class="msg-time"> <i class="icon-time"></i> <span>3:15
												pm</span>
									</span>
									</span>
								</s:a></li>

							<li><s:url id="inboxURL" action="inbox"></s:url> <sj:a
									href="%{inboxURL}" targets="content"> See all messages <i
										class="icon-arrow-right"></i>
								</sj:a></li>
						</ul></li>

					<li class="light-blue"><s:a data-toggle="dropdown" href="#"
							class="dropdown-toggle">
							<img class="nav-user-photo" src="ShowPic.slt" alt="Jason's Photo">
							<span class="user-info"> <small>欢迎,</small> <s:label
									name="username" />
							</span>
							<i class="icon-caret-down"></i>
						</s:a>

						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><s:a href="#">
									<i class="icon-cog"></i> 设定
							</s:a></li>

							<li><s:url id="profileURL" action="profile" /> <sj:a
									href="%{profileURL}" targets="content">
									<i class="icon-user"></i> 配置
							</sj:a></li>

							<li class="divider"></li>

							<li><s:a href="login">
									<i class="icon-off"></i> 注销
							</s:a></li>
						</ul></li>
				</ul>
				<!-- /.ace-nav -->
			</div>
			<!-- /.navbar-header -->
		</div>
		<!-- /.container -->
	</div>

	<div class="main-container" id="main-container">
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>

			<s:form id="form_echo" action="echo">
				<s:url id="echoAction" action="echo" />
				<s:hidden id="echo" name="echo" />
				<sj:submit id="formSubmit" href="%{echoAction}" targets="content"
					cssStyle="display:none;" formIds="form_echo" />
			</s:form>

			<div class="sidebar" id="sidebar">
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
					<li class="active"><s:a href="index">
							<i class="icon-dashboard"></i>
							<span class="menu-text"> 我的驾驶舱 </span>
						</s:a></li>

					<s:iterator value="items">
						<s:if test="isleaf">
							<!-- 菜单页节点 -->
							<li><sj:a onClickTopics="openURL" id="%{getText(id)}"
									href="#">
									<i class="<s:property value="icon" />"></i>
									<span class="menu-text"><s:property value="name" /></span>
								</sj:a></li>
						</s:if>
						<s:else>
							<!-- 非菜单页节点 -->
							<li><a href="#" Class="dropdown-toggle"> <i
									class="<s:property value="icon" />"> </i> <span
									class="menu-text"><s:property value="name" /></span> <b
									class="arrow icon-angle-down"></b>
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
													class="icon-double-angle-right"></i> <s:property
														value="name" /> <b class="arrow icon-angle-down"></b>
											</a>

												<ul class="submenu">
													<s:iterator value="subMenu">
														<li><sj:a onClickTopics="openURL" id="%{getText(id)}"
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
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>
			</div>


			<sj:div id="content" cssClass="main-content">
				<s:url var="welcomeURL" action="welcome" />
				<sj:div id="welcome" href="%{welcomeURL}" />
			</sj:div>
			<!-- /.main-content -->


		</div>
		<!-- /.main-container-inner -->

		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->





</body>
</html>
