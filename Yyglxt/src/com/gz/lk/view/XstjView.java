package com.gz.lk.view;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.wb.swt.ResourceManager;

public class XstjView extends ViewPart {

	public static final String ID = "com.gz.lk.view.XstjView"; //$NON-NLS-1$
	private Table table;
	
	String sql="select *from filmticket where 1=1";
	int currentPageNum=1;
	int pageCount=10;
	int max;
	
	DateTime dateTime,dateTime_1;
	
	
	Label label,label_1;

	public XstjView() {
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
		{
			Label label = new Label(container, SWT.NONE);
			label.setForeground(SWTResourceManager.getColor(255, 255, 255));
			label.setFont(SWTResourceManager.getFont("华文行楷", 26, SWT.NORMAL));
			label.setBounds(411, 44, 282, 42);
			label.setText("\u9500     \u552E     \u7EDF     \u8BA1");
		}
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(241, 112, 653, 293);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(169);
		tblclmnNewColumn.setText("\u7535\u5F71\u540D");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u5F71\u5385");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(132);
		tableColumn_2.setText("\u552E\u4EF7");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(147);
		tableColumn_3.setText("\u9500\u552E\u65E5\u671F");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		
		Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 9, SWT.NORMAL));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {          //上一页
				
				if(currentPageNum>1){
					currentPageNum--;
					cxsj();
					}
		
			}
		});
		button.setBounds(471, 540, 80, 27);
		button.setText("\u4E0A\u4E00\u9875");
		
		Button button_1 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 9, SWT.NORMAL));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {        //下一页
				
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
		button_1.setBounds(788, 540, 80, 27);
		button_1.setText("\u4E0B\u4E00\u9875");
		
		label = new Label(container, SWT.NONE);
		label.setBounds(640, 545, 18, 17);
		label.setText("0");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setBounds(664, 545, 10, 17);
		lblNewLabel.setText("/");
		
		label_1 = new Label(container, SWT.NONE);
		label_1.setBounds(685, 545, 18, 17);
		label_1.setText("0");
		
		max=getMaxPage();
		label_1.setText(String.valueOf(max));
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(255, 255, 0));
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(308, 454, 98, 27);
		label_2.setText("\u6309\u65F6\u95F4\u6BB5\u67E5\u8BE2\uFF1A");
		
		dateTime = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(417, 450, 93, 24);
		
		dateTime_1 = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(562, 450, 93, 24);
		
		Button button_2 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_2.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {	
				
				sql="select *from filmticket where 1=1";
				int y=dateTime.getYear();
				int m=dateTime.getMonth()+1;
				int d=dateTime.getDay();
				String time = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
				y=dateTime_1.getYear();
				m=dateTime_1.getMonth()+1;
				d=dateTime_1.getDay()+1;
				String time1 = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
				sql = sql + " AND buyTime > '"+time+"' AND buyTime<'"+time1+"'";
				
				currentPageNum=1;
				
				max=getMaxPage();
				
				label_1.setText(String.valueOf(max));
				
				cxsj();	
			}
		});
		button_2.setBounds(814, 447, 80, 27);
		button_2.setText("\u67E5\u8BE2");
		
		Button button_3 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_3.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				sql="select *from filmticket where 1=1";
				
				cxsj();
			}
		});
		button_3.setBounds(698, 447, 80, 27);
		button_3.setText("\u5237\u65B0");
		
		
		
		
		
		
		
		
		cxsj();

		createActions();
		initializeToolBar();
		initializeMenu();
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
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[3],arr.get(i)[4],arr.get(i)[6],arr.get(i)[7]});

			if (arr.get(0)!=null) {
				label.setText(String.valueOf(currentPageNum));
			}
			else {
				label.setText(String.valueOf(0));
			}
			
		}
		
	}


	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
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
