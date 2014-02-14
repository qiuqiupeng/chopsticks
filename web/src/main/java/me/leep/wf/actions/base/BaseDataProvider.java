package me.leep.wf.actions.base;

import java.util.List;
import java.util.Map;

import me.leep.wf.vo.BaseVO;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
//import me.leep.wf.services.IBaseService;

@ParentPackage("json-default")
@Result(name = "success", type = "json", params = { "ignoreHierarchy", "false" })
public class BaseDataProvider<T extends BaseVO> extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1576970319376091094L;

//	private IBaseService services;

	// get how many rows we want to have into the grid - rowNum attribute in the
	// grid
	private Integer rows = 0;

	// Get the requested page. By default grid sets this to 1.
	private Integer page = 0;

	// sorting order - asc or desc
	private String sord;

	// get index row - i.e. user click to sort.
	private String sidx;

	// Search Field
	private String searchField;

	// The Search String
	private String searchString;

	// Limit the result when using local data, value form attribute rowTotal
	private Integer totalrows;

	// he Search Operation
	// ['eq','ne','lt','le','gt','ge','bw','bn','in','ni','ew','en','cn','nc']
	private String searchOper;

	// Your Total Pages
	private Integer total = 0;

	// All Records
	private Integer records = 0;

	private boolean loadonce = false;
	private Map<String, Object> session;

	private int from;
	private int to;
	
	 private List<T> gridModel;

	/**
	 * @return how many rows we want to have into the grid
	 */
	public Integer getRows() {
		return rows;
	}

	/**
	 * @param rows
	 *            how many rows we want to have into the grid 我们想要的总行数
	 */
	public void setRows(Integer rows) {
		this.rows = rows;
	}

	/**
	 * @return current page of the query
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page
	 *            查询的当前页
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return 要查询的页数
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            查询的总页数
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return total number of records for the query. e.g. select count(*) from
	 *         table
	 */
	public Integer getRecords() {
		return records;
	}

	/**
	 * @param records
	 *            total number of records for the query. e.g. select count(*)
	 *            from table 查询的总记录数
	 */
	public void setRecords(Integer records) {

		this.records = records;

		if (this.records > 0 && this.rows > 0) {
			this.total = (int) Math.ceil((double) this.records
					/ (double) this.rows);
		} else {
			this.total = 0;
		}
	}

	/**
	 * @return sorting order
	 */
	public String getSord() {
		return sord;
	}

	/**
	 * @param sord
	 *            sorting order 设置排序（“asc”，“desc”）
	 */
	public void setSord(String sord) {
		this.sord = sord;
	}

	/**
	 * @return get index row - i.e. user click to sort.
	 */
	public String getSidx() {
		return sidx;
	}

	/**
	 * @param sidx
	 *            get index row - i.e. user click to sort.
	 */
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	public void setLoadonce(boolean loadonce) {
		this.loadonce = loadonce;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public void setTotalrows(Integer totalrows) {
		this.totalrows = totalrows;
	}

	/**
	 * @return the searchField
	 */
	public String getSearchField() {
		return searchField;
	}

	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @return the totalrows
	 */
	public Integer getTotalrows() {
		return totalrows;
	}

	/**
	 * @return the searchOper
	 */
	public String getSearchOper() {
		return searchOper;
	}

	/**
	 * @return the loadonce
	 */
	public boolean isLoadonce() {
		return loadonce;
	}

	/**
	 * @return the session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	@Action(results = { @Result(type = "json", name = "success") })
	public String execute() throws Exception {
		return SUCCESS;
	}

	public void initGridParam(Integer beans) {
//		records = services.coutAll(clazz);
		records = beans;

		if (totalrows != null) {
			records = totalrows;
		}

		// Calucalate until rows ware selected 计算被选择的最后行数
		to = (rows * page);

		// Calculate the first row to read
		from = to - rows;

		// Set to = max rows
		if (to > records)
			to = records;

		// 计算总页数
		total = (int) Math.ceil((double) records / (double) rows);
	}

//	/**
//	 * @param services
//	 *            要设置的 services
//	 */
//	public void setServices(IBaseService services) {
//		this.services = services;
//	}

	/**
	 * @return from
	 */
	public int getFrom() {
		return from;
	}

	/**
	 * @param from
	 *            要设置的 from
	 */
	public void setFrom(int from) {
		this.from = from;
	}

	/**
	 * @return to
	 */
	public int getTo() {
		return to;
	}

	/**
	 * @param to
	 *            要设置的 to
	 */
	public void setTo(int to) {
		this.to = to;
	}

	/**
	 * @return gridModel
	 */
	public List<T> getGridModel() {
		return gridModel;
	}

	/**
	 * @param gridModel 要设置的 gridModel
	 */
	public void setGridModel(List<T> gridModel) {
		this.gridModel = gridModel;
	}

}
