package com.gz.lk.view;

import java.awt.AWTError;
import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import com.gz.lk.dialog.addEmployee;
import com.gz.lk.dialog.ckEmployee;
import com.gz.lk.dialog.xgEmployee;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.ResourceManager;

public class employeeManageView extends ViewPart {

	public static final String ID = "com.gz.lk.view.employeeManageView"; //$NON-NLS-1$
	private Table table;
	private Text text;

	public employeeManageView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("华文行楷", 24, SWT.NORMAL));
		lblNewLabel_1.setBounds(430, 35, 282, 44);
		lblNewLabel_1.setText("\u5458     \u5DE5     \u7BA1     \u7406");
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(61, 104, 984, 237);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(72);
		tableColumn_3.setText("\u5DE5\u53F7");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(92);
		tblclmnNewColumn.setText("\u767B\u9646\u540D");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(99);
		tblclmnNewColumn_1.setText("\u5BC6\u7801");
		
		TableColumn tblclmnName = new TableColumn(table, SWT.NONE);
		tblclmnName.setWidth(74);
		tblclmnName.setText("\u59D3\u540D");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(59);
		tblclmnNewColumn_2.setText("\u6027\u522B");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(139);
		tableColumn.setText("\u8054\u7CFB\u7535\u8BDD");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(183);
		tableColumn_1.setText("\u8EAB\u4EFD\u8BC1\u53F7");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(264);
		tableColumn_2.setText("\u5BB6\u5EAD\u4F4F\u5740");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addEmployee ae=new addEmployee(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				ae.open();
				table.removeAll();
				String name= text.getText();
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
			}
		});
		menuItem.setText("\u6DFB\u52A0\u5458\u5DE5");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.RADIO);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//删除员工
				
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String sql="DELETE FROM user WHERE id="+ti.getText(0);
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
				
				table.removeAll();
				String name= text.getText();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					
					System.out.println(arr.get(i)[0]);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
			
			}
		});
		menuItem_1.setText("\u5220\u9664\u5458\u5DE5");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//修改信息
				xgEmployee xe=new xgEmployee(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				int index=table.getSelectionIndex();//获取指向的数据位置
				TableItem ti=table.getItem(index);
				String str=ti.getText(0);
				
				System.out.println(str);
				xe.open(str);
				table.removeAll();
				String name= text.getText();
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
				
				
				
				
				
				
				
			}
		});
		menuItem_2.setText("\u4FEE\u6539\u4FE1\u606F");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { //查看员工信息
				ckEmployee ce=new ckEmployee(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String  arr=ti.getText(0);
				ce.open(arr);
				
			}
		});
		menuItem_3.setText("\u67E5\u770B\u4FE1\u606F");
		
		Button button_3 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_3.setEnabled(false);
		button_3.setBounds(430, 469, 89, 27);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {      //删除员工按钮
				if(text.getText().trim().equals("")){
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("提示信息");
					mb.setMessage("你输入的工号为空！");
					mb.open();
		
				}
				
				String sql="DELETE FROM user WHERE id="+text.getText();
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
				
				table.removeAll();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					
					System.out.println(arr.get(i)[0]);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
				
				
				
			}
		});
		button_3.setText("\u5220\u9664\u5458\u5DE5");
		
		Button btnNewButton = new Button(container, SWT.BORDER | SWT.TOGGLE);
		btnNewButton.setEnabled(false);
		btnNewButton.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		btnNewButton.setBounds(594, 469, 80, 27);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {    //查看员工信息按钮
				
				
				if(text.getText().trim().equals("")){
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("提示信息");
					mb.setMessage("你输入的工号为空！");
					mb.open();
		
				}
				ckEmployee ce=new ckEmployee(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);			
				String  arr=text.getText();
				ce.open(arr);
				
			}
		});
		btnNewButton.setText("\u67E5\u770B\u4FE1\u606F");
		
		Button button_4 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_4.setEnabled(false);
		button_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_4.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		button_4.setBounds(767, 469, 80, 27);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {  //修改员工信息按钮
				if(text.getText().trim().equals("")){
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("提示信息");
					mb.setMessage("你输入的工号为空！");
					mb.open();
		
				}
				
				
				xgEmployee xe=new xgEmployee(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				String str=text.getText();
				
				System.out.println(str);
				xe.open(str);
				table.removeAll();
				String name= text.getText();
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
				
			}
		});
		button_4.setText("\u4FEE\u6539\u4FE1\u606F");
		
		Button button_1 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_1.setEnabled(false);
		button_1.setBounds(925, 469, 80, 27);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
				String name= text.getText();
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
				
			}
		});
		button_1.setText("\u5237\u65B0");
		
		Button button_2 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		button_2.setEnabled(false);
		button_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button_2.setBounds(260, 469, 89, 27);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { //添加员工信息按钮
				
				addEmployee ae=new addEmployee(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				ae.open();
				table.removeAll();
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
				for (int i = 0; i < arr.size(); i++) {
					TableItem tableItem = new TableItem(table, SWT.NONE);
					tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button_2.setText("\u6DFB\u52A0\u5458\u5DE5");
		
		Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button.setEnabled(false);
		button.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		button.setFont(SWTResourceManager.getFont("楷体", 12, SWT.BOLD));
		button.setBounds(94, 469, 89, 27);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {                  //搜索员工
				table.removeAll();
				String num= text.getText();				
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2' and id="+num);
				if(arr.size()==0){
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mb.setText("提示信息");
					mb.setMessage("你查询的数据为空！");
					mb.open();
		
				}
					for (int i = 0; i < arr.size(); i++) {
						TableItem tableItem = new TableItem(table, SWT.NONE);
						tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
					}
				
				
				
				
			}
		});
		button.setText("\u641C   \u7D22");
		
		Label label = new Label(container, SWT.NONE);
		label.setBounds(302, 379, 100, 24);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		label.setFont(SWTResourceManager.getFont("楷体", 14, SWT.NORMAL));
		label.setText("\u5458\u5DE5\u5DE5\u53F7\uFF1A");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(490, 379, 213, 23);
		
		
		
		DB db=new DB();
		
		ArrayList<String []> arr=db.arrQuery("SELECT *FROM USER WHERE limits='2'");
		for (int i = 0; i < arr.size(); i++) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[4],arr.get(i)[5],arr.get(i)[6],arr.get(i)[7],arr.get(i)[8]});
		}
		

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
