package com.gz.lk.view;

import org.eclipse.jface.action.IMenuManager;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Text;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.ResourceManager;

public class DeleteAllUpfilm extends ViewPart {

	public static final String ID = "com.gz.lk.view.DeleteAllUpfilm"; //$NON-NLS-1$
	
	
	private Table table;
	
	String sql="select *from upfilm where 1=1";
	int currentPageNum=1;
	int pageCount=10;
	int max;
	Label label;
	Label label1 ;

	public DeleteAllUpfilm() {
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
		container.setFont(SWTResourceManager.getFont("楷体", 24, SWT.NORMAL));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 26, SWT.BOLD));
		lblNewLabel.setBounds(277, 34, 440, 51);
		lblNewLabel.setText("\u7535     \u5F71     \u4E0B     \u7EBF");
		{
			table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(89, 127, 830, 304);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			
			
			max=getMaxPage();
		
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(56);
				tableColumn.setText("\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(113);
				tableColumn.setText("\u7535\u5F71\u540D");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(83);
				tableColumn.setText("\u653E\u6620\u5385");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(99);
				tableColumn.setText("\u7C7B\u578B");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(88);
				tableColumn.setText("\u8BED\u8A00");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u5F00\u64AD\u65F6\u95F4");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(86);
				tableColumn.setText("\u65F6\u957F");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u4EF7\u683C");
			}
			{
				TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn.setWidth(100);
				tblclmnNewColumn.setText("\u4E0A\u6620\u65F6\u95F4");
			}
			
			

		{
			Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
			button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {               //上一页
					
					if(currentPageNum>1){
						currentPageNum--;
						cxsj();
						}
			
					
					
					
					
				}
			});
			button.setBounds(609, 456, 80, 27);
			button.setText("\u4E0A\u4E00\u9875");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {     //下一页
					
					
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
			button.setBounds(839, 456, 80, 27);
			button.setText("\u4E0B\u4E00\u9875");
		}
		{
			label = new Label(container, SWT.NONE);
			label.setBounds(743, 461, 19, 17);
			label.setText("0");
		}
		{
			Label label = new Label(container, SWT.NONE);
			label.setBounds(768, 461, 12, 17);
			label.setText("/");
		}
		{
			label1 = new Label(container, SWT.NONE);
			label1.setBounds(786, 461, 19, 17);
			label1.setText(String.valueOf(max));
		}
		{
			Button btnNewButton = new Button(container, SWT.BORDER | SWT.TOGGLE);
			btnNewButton.setDragDetect(false);
			btnNewButton.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
			btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
			btnNewButton.setText("\u4E00\u952E\u6E05\u7A7A");
			btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					DB db=new DB();
					int i=db.update("delete from upfilm where id");
					if (i>0) {
					
						
						max=getMaxPage();   //更新最大页数
						label1.setText(String.valueOf(max));
						if (max<currentPageNum) {
							currentPageNum=max;
						}
						
						cxsj();
						
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("清空成功！");
						mb.open();
					}else {
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("清空失败！请检查数据。");
						mb.open();
					}
					
					
					
					
					
					
					
					
				}
			});
			btnNewButton.setBounds(707, 524, 123, 27);
		}
			
			cxsj();
			
			
			
			
			
			
			
			
			
		}

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
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[3],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});

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