package com.gz.lk.view;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.gz.lk.dialog.addFilm;
import com.gz.lk.dialog.ckFilm;
import com.gz.lk.dialog.xgFilm;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.ResourceManager;

public class FilmManageView extends ViewPart {

	public static final String ID = "com.gz.lk.view.FilmManageView"; //$NON-NLS-1$
	private Table table;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	String sql="select *from film where 1=1";
	int currentPageNum=1;
	int pageCount=10;
	int max;
	Label lblNewLabel_6;
	Label lblNewLabel_5 ;
	
	DateTime dateTime_2;
	boolean bol=true;
	Link link_1;

	public FilmManageView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		
		lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setBounds(875, 377, 25, 27);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		max=getMaxPage();
		lblNewLabel_5.setText(String.valueOf(max));
		
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setBounds(847, 377, 19, 22);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblNewLabel_4.setText("/");
		
		lblNewLabel_6 = new Label(container, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblNewLabel_6.setBounds(816, 377, 25, 27);
		lblNewLabel_6.setText("0");
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(93, 92, 965, 259);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(82);
		tableColumn_8.setText("\u7F16\u53F7");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7535\u5F71\u540D");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(72);
		tableColumn_1.setText("\u56FD\u5BB6");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5BFC\u6F14");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(68);
		tableColumn_3.setText("\u65F6\u957F");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(78);
		tableColumn_4.setText("\u79CD\u7C7B");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(64);
		tableColumn_5.setText("\u8BED\u8A00");
		
		TableColumn tableColumn_6 = new TableColumn(table, SWT.NONE);
		tableColumn_6.setWidth(197);
		tableColumn_6.setText("\u5185\u5BB9\u7B80\u4ECB");
		
		TableColumn tableColumn_7 = new TableColumn(table, SWT.NONE);
		tableColumn_7.setWidth(100);
		tableColumn_7.setText("\u4E0A\u6620\u65F6\u95F4");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("\u4E0B\u7EBF\u65F6\u95F4");	
		cxsj();
	
		TableItem tableItem = new TableItem(table, SWT.NONE);
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				addFilm ae=new addFilm(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				ae.open();

				DB db=new DB();
				
				max=getMaxPage();   //更新最大页数
				lblNewLabel_5.setText(String.valueOf(max));
				if (max<currentPageNum) {
					currentPageNum=max;
				}
				
				cxsj();
				
				
				
				
				
			}
		});
		menuItem.setText("\u6DFB\u52A0");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {   //删除信息
				
				
				
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String sql="DELETE FROM film WHERE id="+ti.getText(0);
				DB db=new DB();
				int num=db.update(sql);
				if (num>0) {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.None);
					mb.setText("提示信息");
					mb.setMessage("删除成功！");
				}else {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.None);
					mb.setText("提示信息");
					mb.setMessage("删除失败！");
				}
				
				
				max=getMaxPage();   //更新最大页数
				lblNewLabel_5.setText(String.valueOf(max));
				if (max<currentPageNum) {
					currentPageNum=max;
				}
				
				cxsj();
				
				
				
				
				
				
			}
		});
		menuItem_1.setText("\u5220\u9664");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {// 修改信息
				
				
				xgFilm xe=new xgFilm(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				int index=table.getSelectionIndex();//获取指向的数据位置
				TableItem ti=table.getItem(index);
				String str=ti.getText(0);
				
				System.out.println(str);
				xe.open(str);
				
				max=getMaxPage();   //更新最大页数
				lblNewLabel_5.setText(String.valueOf(max));
				if (max<currentPageNum) {
					currentPageNum=max;
				}
				
				cxsj();
				
				
				
				
				
				
				
			}
		});
		menuItem_2.setText("\u4FEE\u6539");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//查询电影信息
				ckFilm cf=new ckFilm(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				

				
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String  arr=ti.getText(0);
				cf.open(arr);
				
				
				
				
			}
		});
		menuItem_3.setText("\u67E5\u8BE2");

		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 24, SWT.NORMAL));
		lblNewLabel.setBounds(346, 29, 419, 46);
		lblNewLabel.setText("\u5F71     \u7247     \u7BA1      \u7406");
		
		Group group = new Group(container, SWT.NONE);
		group.setText("\u67E5\u8BE2");
		group.setBounds(66, 412, 905, 152);
		
		Label label = new Label(group, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label.setBounds(50, 36, 96, 17);
		label.setText("\u5BFC        \u6F14");
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(50, 94, 96, 23);
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel_1.setBounds(207, 36, 96, 17);
		lblNewLabel_1.setText("\u4E3B       \u6F14");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(207, 94, 96, 23);
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_1.setBounds(347, 36, 96, 17);
		label_1.setText("\u79CD       \u7C7B");
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(347, 94, 96, 23);
		
		Label lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel_2.setBounds(481, 36, 96, 17);
		lblNewLabel_2.setText("\u8BED       \u8A00");
		
		text_3 = new Text(group, SWT.BORDER);
		text_3.setBounds(481, 94, 96, 23);
		
		Label lblNewLabel_3 = new Label(group, SWT.NONE);
		lblNewLabel_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		lblNewLabel_3.setBounds(615, 36, 96, 17);
		lblNewLabel_3.setText("\u653E \u6620 \u65F6 \u957F");
		
		text_4 = new Text(group, SWT.BORDER);
		text_4.setBounds(615, 94, 96, 23);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(759, 36, 96, 17);
		label_2.setText("\u4E0A \u6620 \u65F6 \u95F4");
		
		dateTime_2 = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_2.setBounds(759, 94, 93, 24);
		dateTime_2.setVisible(false);
		
		link_1 = new Link(group, SWT.NONE);
		link_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
		link_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		link_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				if (bol) {
					dateTime_2.setVisible(true);

					link_1.setText("<a>关闭时间</a>");
					bol=false;
				}else {
					dateTime_2.setVisible(false);

					link_1.setText("<a>开启时间</a>");
					bol=true;
				}
			
			}
		});
		link_1.setBounds(822, 132, 73, 17);
		link_1.setText("<a>开启时间</a>");
		
		
		
		Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				sql="select *from film where 1=1";
				
				String director=text.getText();

				String mainActor=text_1.getText();

				String kind=text_2.getText();
				
				String language=text_3.getText();
				
				String time=text_4.getText();
				
				
				if (!director.trim().equals("")) {
					sql=sql+" and director like '%"+director+"%'";
					System.out.println(sql);
				}
				if (!mainActor.trim().equals("")) {
					sql=sql+" and college like '%"+mainActor+"%'";
					System.out.println(sql);
				}
				if (!kind.trim().equals("")) {
					sql=sql+" and kind like '%"+kind+"%'";
					System.out.println(sql);
				}
				if (!language.trim().equals("")) {
					sql=sql+" and language like '%"+language+"%'";
					System.out.println(sql);
				}
				if (!time.trim().equals("")) {
					sql=sql+" and time like '%"+time+"%'";
					System.out.println(sql);
				}
				
				if (!bol) {
					int y=dateTime_2.getYear();
					int m=dateTime_2.getMonth()+1;
					int d=dateTime_2.getDay();
					String time1 = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
					
					sql = sql + " AND upDate like '%"+time1+"%'";

				}
				currentPageNum=1;
				
				max=getMaxPage();
				
				lblNewLabel_5.setText(String.valueOf(max));
				
				cxsj();				
				
			
				
			}
		});
		button.setBounds(978, 481, 80, 27);
		button.setText("\u67E5\u8BE2");
		
		

		
		Button button_1 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {  //下一页
				int max=getMaxPage();
				if(currentPageNum<max){
				currentPageNum++;
				cxsj();
				}else{
					MessageBox mb = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					
					mb.setMessage("已经是最后一页 ");//增加提示信息
					mb.setText("提示");//设置标题
					mb.open();
				}
				
				
			}
		});
		button_1.setText("\u4E0B\u4E00\u9875");
		button_1.setBounds(937, 379, 80, 27);
		
		Button button_2 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_2.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { //上一页
				if(currentPageNum>1){
					currentPageNum--;
					cxsj();
					}
		
				
			}
		});
		button_2.setBounds(630, 379, 80, 27);
		button_2.setText("\u4E0A\u4E00\u9875");
		
		

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}
	
	public int getMaxPage() {
		DB db=new DB();
		ArrayList<String []> arrayList=db.arrQuery(sql);
		if(arrayList.size()%pageCount==0){
			return arrayList.size()/pageCount;
		}else{
			return arrayList.size()/pageCount+1;
		}
		
	}
	public void cxsj(){
		table.removeAll();
		DB db=new DB();
		ArrayList<String []> arr=db.pageQuery(sql, currentPageNum, pageCount);
		for (int i = 0; i < arr.size(); i++) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[3],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8],arr.get(i)[11],arr.get(i)[12]});

			if (arr.get(0)!=null) {
				lblNewLabel_6.setText(String.valueOf(currentPageNum));
			}
			else {
				lblNewLabel_6.setText(String.valueOf(0));
			}
			
		}
		
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars()
				.getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars()
				.getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
