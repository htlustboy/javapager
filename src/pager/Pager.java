package pager;

import java.util.List;

/**
 * ������ҳ
 * @author hutao
 *
 */
public class Pager {
	
	private static final int PAGE_SIZE=5;
	
	private int pageNo; //Ĭ�ϵ�1ҳ
	private int totalItems; //�ܼ�¼��
	private int totalPageSize; //��ҳ��
	private List<?> pageContent; //�����ҳ����
	
	/**
	 * Ĭ��ÿҳ��ʾ�ļ�¼��
	 * @return
	 */
	public int getPageSize(){
		return PAGE_SIZE;
	}
	
	
	/**
	 * ��ȡ��ǰҳ
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
	 * ��ȡ�ܵļ�¼��
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
	 * ��ȡ�ܵ�ҳ��
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
	 * �Ƿ�����һҳ
	 * @param pageNo
	 * @return
	 */
	public boolean isHasNext(int pageNo) {
		return pageNo>=getTotalPageSize()?false:true;
	}
	
	/**
	 * �Ƿ�����һҳ
	 * @param pageNo
	 * @return
	 */
	public boolean isHasPrev(int pageNo) {
		return pageNo<=1?false:true;
	}
	
	/**
	 * ��һҳ
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
	 * ��һҳ
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
	 * ��ȡ�����ҳ����
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
	 * ��ҳ
	 * @return
	 */
	public int getFirstPage(){
		return 1;
	}
	
	/**
	 * βҳ
	 * @return
	 */
	public int getLastPage(){
		return getTotalPageSize();
	}
	
	
	//------------------------------------------------------------------------------------------------
	
	/**
	 * Ĭ���޲ι�����
	 */
	public Pager(){
		
	}
	
	/**
	 * @param totalItems �ܼ�¼��
	 */
	public Pager(int totalItems) {
		this.totalItems = totalItems;
	}
	
	/**
	 * @param totalItems �ܼ�¼��
	 * @param pageNo	��ǰҳ
	 */
	public Pager(int totalItems,int pageNo){
		this.totalItems = totalItems;
		this.pageNo = pageNo;
	}
	
	//------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Pager pager = new Pager();
		System.out.println("��ǰҳ��"+pager.getPageNo());
		System.out.println("��ҳ����"+pager.getTotalPageSize());
		System.out.println("�ܼ�¼����"+pager.getTotalItems());
		System.out.println("��һҳ��"+pager.doNext(pager.getPageNo()));
		System.out.println("��һҳ��"+pager.doPrev(pager.getPageNo()));
		System.out.println("��ҳ��"+pager.getFirstPage());
		System.out.println("βҳ��"+pager.getLastPage());
		
		System.out.println("-----------------------------------------");
		
		pager = new Pager(101);
		System.out.println("��ǰҳ��"+pager.getPageNo());
		System.out.println("��ҳ����"+pager.getTotalPageSize());
		System.out.println("�ܼ�¼����"+pager.getTotalItems());
		System.out.println("��һҳ��"+pager.doNext(pager.getPageNo()));
		System.out.println("��һҳ��"+pager.doPrev(pager.getPageNo()));
		System.out.println("��ҳ��"+pager.getFirstPage());
		System.out.println("βҳ��"+pager.getLastPage());
		
		System.out.println("-----------------------------------------");
		
		pager = new Pager(101, 5);
		System.out.println("��ǰҳ��"+pager.getPageNo());
		System.out.println("��ҳ����"+pager.getTotalPageSize());
		System.out.println("�ܼ�¼����"+pager.getTotalItems());
		System.out.println("��һҳ��"+pager.doNext(pager.getPageNo()));
		System.out.println("��һҳ��"+pager.doPrev(pager.getPageNo()));
		System.out.println("��ҳ��"+pager.getFirstPage());
		System.out.println("βҳ��"+pager.getLastPage());
		
	}
}
