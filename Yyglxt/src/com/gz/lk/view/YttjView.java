package com.gz.lk.view;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import com.gz.lk.dialog.SzlcxDialog;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class YttjView extends ViewPart {

	public static final String ID = "com.gz.lk.view.YttjView"; //$NON-NLS-1$
	private Table table;
	String sql="select *from fyt where 1=1";
	int currentPageNum=1;
	int pageCount=10;
	int max;
	
	DateTime dateTime,dateTime_1;
	
	
	Label label,label_1;
	public YttjView() {
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
			table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(371, 175, 404, 195);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u5F71\u5385\u540D");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u79CD\u7C7B");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u89C4\u683C");
			}
			
			Menu menu = new Menu(table);
			table.setMenu(menu);
			
			MenuItem menuItem = new MenuItem(menu, SWT.NONE);
			menuItem.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {          //上座率查询
					
					
					
					
					SzlcxDialog sd=new SzlcxDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
					int index=table.getSelectionIndex();//获取指向的数据位置
					TableItem ti=table.getItem(index);
					String str=ti.getText(0);
					
					System.out.println(str);
					sd.open(str);
					
					
				}
			});
			menuItem.setText("\u4E0A\u5EA7\u7387\u67E5\u8BE2");
		}
		{
			Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
			button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					if(currentPageNum>1){
						currentPageNum--;
						cxsj();
						}
				}
			});
			button.setBounds(466, 393, 80, 27);
			button.setText("\u4E0A\u4E00\u9875");
		}
		{
			Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
			button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
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
			button.setBounds(695, 393, 80, 27);
			button.setText("\u4E0B\u4E00\u9875");
		}
		{
			label = new Label(container, SWT.NONE);
			label.setForeground(SWTResourceManager.getColor(255, 255, 0));
			label.setBounds(593, 398, 19, 17);
			label.setText("0");
		}
		{
			Label label_2 = new Label(container, SWT.NONE);
			label_2.setForeground(SWTResourceManager.getColor(255, 255, 0));
			label_2.setBounds(618, 398, 19, 17);
			label_2.setText("/");
		}
		{
			label_1 = new Label(container, SWT.NONE);
			label_1.setForeground(SWTResourceManager.getColor(255, 255, 0));
			label_1.setBounds(643, 398, 19, 17);
			label_1.setText("0");
			
		
			label_1.setText(String.valueOf(getMaxPage()));
		}
		{
			Label label_2 = new Label(container, SWT.NONE);
			label_2.setForeground(SWTResourceManager.getColor(255, 255, 255));
			label_2.setFont(SWTResourceManager.getFont("楷体", 24, SWT.NORMAL));
			label_2.setBounds(390, 82, 352, 50);
			label_2.setText("\u5F71     \u5385    \u7EDF     \u8BA1");
		}
		
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
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[3]});

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
