<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/commons/taglibs.jsp"%>


<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try {
			ace.settings.check('breadcrumbs', 'fixed');
		} catch (e) {
		}
	</script>

	<ul class="breadcrumb">
		<li><i class="icon-home home-icon"></i> <a href="#">Home</a></li>

		<li><a href="#">More Pages</a></li>
		<li class="active">User Profile</li>
	</ul>
	<!-- .breadcrumb -->

	<div class="nav-search" id="nav-search">
		<form class="form-search">
			<span class="input-icon"> <input type="text"
				placeholder="Search ..." class="nav-search-input"
				id="nav-search-input" autocomplete="off"> <i
				class="icon-search nav-search-icon"></i>
			</span>
		</form>
	</div>
	<!-- #nav-search -->
</div>

<div class="page-content">
	<div class="page-header">
		<h1>
			用户配置页面 <small> <i class="icon-double-angle-right"></i>
				查看和配置你的个人信息
			</small>
		</h1>
	</div>
	<!-- /.page-header -->

	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->
			<div>
				<div id="user-profile-1" class="user-profile row">
					<div class="col-xs-12 col-sm-3 center">
						<div>
							<span class="profile-picture"> <img id="avatar"
								class="editable img-responsive" alt="Alex's Avatar"
								src="ShowPic.slt">
							</span>

							<div class="space-4"></div>

							<div
								class="width-80 label label-info label-xlg arrowed-in arrowed-in-right">
								<div class="inline position-relative">
									<a href="#" class="user-title-label dropdown-toggle"
										data-toggle="dropdown"> <i
										class="icon-circle light-green middle"></i> &nbsp; <span
										class="white">Alex M. Doe</span>
									</a>

									<ul
										class="align-left dropdown-menu dropdown-caret dropdown-lighter">
										<li class="dropdown-header">Change Status</li>

										<li><a href="#"> <i class="icon-circle green"></i>
												&nbsp; <span class="green">Available</span>
										</a></li>

										<li><a href="#"> <i class="icon-circle red"></i>
												&nbsp; <span class="red">Busy</span>
										</a></li>

										<li><a href="#"> <i class="icon-circle grey"></i>
												&nbsp; <span class="grey">Invisible</span>
										</a></li>
									</ul>
								</div>
							</div>
						</div>

						<div class="space-6"></div>



						<div class="hr hr16 dotted"></div>
					</div>

					<div class="col-xs-12 col-sm-9">


						<div class="space-12"></div>

						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name">用户名</div>

								<div class="profile-info-value">
									<span class="editable" id="username">alexdoe</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name">Location</div>

								<div class="profile-info-value">
									<i class="icon-map-marker light-orange bigger-110"></i> <span
										class="editable" id="country">Netherlands</span> <span
										class="editable" id="city">Amsterdam</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name">Age</div>

								<div class="profile-info-value">
									<span class="editable" id="age">38</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name">Joined</div>

								<div class="profile-info-value">
									<span class="editable" id="signup">20/06/2010</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name">Last Online</div>

								<div class="profile-info-value">
									<span class="editable" id="login">3 hours ago</span>
								</div>
							</div>

							<div class="profile-info-row">
								<div class="profile-info-name">About Me</div>

								<div class="profile-info-value">
									<span class="editable" id="about">Editable as WYSIWYG</span>
								</div>
							</div>
						</div>

						<div class="space-20"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

