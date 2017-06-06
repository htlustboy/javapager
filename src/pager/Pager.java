package pager;

import java.util.List;

/**
 * 公共分页
 * @author hutao
 *
 */
public class Pager {
	
	private static final int PAGE_SIZE=5;
	
	private int pageNo; //默认第1页
	private int totalItems; //总记录数
	private int totalPageSize; //总页数
	private List<?> pageContent; //具体分页内容
	
	/**
	 * 默认每页显示的记录数
	 * @return
	 */
	public int getPageSize(){
		return PAGE_SIZE;
	}
	
	
	/**
	 * 获取当前页
	 * @return
	 */
	public int getPageNo() {
		return pageNo==0?1:pageNo;
	}

	/**
	 * @param pageNo
	 */
	public void setPageNo(int pageNo) {
		if(pageNo<1 || pageNo>getTotalPageSize()){
			this.pageNo = 1;
		}else{
			this.pageNo = pageNo;
		}
	}

	/**
	 * 获取总的记录数
	 * @return
	 */
	public int getTotalItems() {
		return totalItems;
	}
	
	/**
	 * @param totalItems
	 */
	public void setTotalItems(int totalItems){
		if(totalItems<0||totalItems>Integer.MAX_VALUE){
			this.totalItems = 0;
		}
		this.totalItems = totalItems;
	}
	
	/**
	 * 获取总的页数
	 * @return
	 */
	public int getTotalPageSize() {
		if(getTotalItems()%PAGE_SIZE!=0){
			totalPageSize = totalItems/PAGE_SIZE+1;
		}else{
			totalPageSize = totalItems/PAGE_SIZE;
		}
		return totalPageSize;
	}
	
	/**
	 * 是否有下一页
	 * @param pageNo
	 * @return
	 */
	public boolean isHasNext(int pageNo) {
		return pageNo>=getTotalPageSize()?false:true;
	}
	
	/**
	 * 是否有上一页
	 * @param pageNo
	 * @return
	 */
	public boolean isHasPrev(int pageNo) {
		return pageNo<=1?false:true;
	}
	
	/**
	 * 下一页
	 * @param pageNo
	 * @return
	 */
	public int doNext(int pageNo){
		if(isHasNext(pageNo)){
			return pageNo+1;
		}
		return pageNo;
	}
	
	/**
	 * 上一页
	 * @param pageNo
	 * @return
	 */
	public int doPrev(int pageNo){
		if(isHasPrev(pageNo)){
			return pageNo-1;
		}
		return pageNo;
	}
	
	/**
	 * 获取具体分页内容
	 * @return
	 */
	public List<?> getPageContent() {
		return pageContent;
	}

	/**
	 * @param pageContent
	 */
	public void setPageContent(List<?> pageContent) {
		this.pageContent = pageContent;
	}
	
	/**
	 * 首页
	 * @return
	 */
	public int getFirstPage(){
		return 1;
	}
	
	/**
	 * 尾页
	 * @return
	 */
	public int getLastPage(){
		return getTotalPageSize();
	}
	
	
	//------------------------------------------------------------------------------------------------
	
	/**
	 * 默认无参构造器
	 */
	public Pager(){
		
	}
	
	/**
	 * @param totalItems 总记录数
	 */
	public Pager(int totalItems) {
		this.totalItems = totalItems;
	}
	
	/**
	 * @param totalItems 总记录数
	 * @param pageNo	当前页
	 */
	public Pager(int totalItems,int pageNo){
		this.totalItems = totalItems;
		this.pageNo = pageNo;
	}
	
	//------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Pager pager = new Pager();
		System.out.println("当前页："+pager.getPageNo());
		System.out.println("总页数："+pager.getTotalPageSize());
		System.out.println("总记录数："+pager.getTotalItems());
		System.out.println("上一页："+pager.doNext(pager.getPageNo()));
		System.out.println("下一页："+pager.doPrev(pager.getPageNo()));
		System.out.println("首页："+pager.getFirstPage());
		System.out.println("尾页："+pager.getLastPage());
		
		System.out.println("-----------------------------------------");
		
		pager = new Pager(101);
		System.out.println("当前页："+pager.getPageNo());
		System.out.println("总页数："+pager.getTotalPageSize());
		System.out.println("总记录数："+pager.getTotalItems());
		System.out.println("上一页："+pager.doNext(pager.getPageNo()));
		System.out.println("下一页："+pager.doPrev(pager.getPageNo()));
		System.out.println("首页："+pager.getFirstPage());
		System.out.println("尾页："+pager.getLastPage());
		
		System.out.println("-----------------------------------------");
		
		pager = new Pager(101, 5);
		System.out.println("当前页："+pager.getPageNo());
		System.out.println("总页数："+pager.getTotalPageSize());
		System.out.println("总记录数："+pager.getTotalItems());
		System.out.println("上一页："+pager.doNext(pager.getPageNo()));
		System.out.println("下一页："+pager.doPrev(pager.getPageNo()));
		System.out.println("首页："+pager.getFirstPage());
		System.out.println("尾页："+pager.getLastPage());
		
	}
}
