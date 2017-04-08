package com.gz.lk.view;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.dialog.Addyt;
import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;

public class fytManageView extends ViewPart {

	public static final String ID = "com.gz.lk.view.fytManageView"; //$NON-NLS-1$
	private Table table;
	
	public static String str;

	public fytManageView() {
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
		
		Composite composite = new Composite(container, SWT.BORDER);
		composite.setBounds(216, 27, 595, 371);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(112, 102, 406, 238);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u5F71\u5385\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u7C7B\u578B");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u89C4\u683C");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {            //放映信息
				
				
				int index=table.getSelectionIndex();//获取指向的数据位置
				TableItem ti=table.getItem(index);
				str=ti.getText(1);
				
				
				
				
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(FyxxView.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(fytManageView.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
			}
		});
		menuItem.setText("\u653E\u6620\u4FE1\u606F");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {            //添加影厅
				Addyt ay=new Addyt(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				int index=table.getSelectionIndex();//获取指向的数据位置
				TableItem ti=table.getItem(index);
				String str1=ti.getText(0);
				
				ay.open(str1);
				
				cxsj();
				
				
			}
		});
		menuItem_1.setText("\u6DFB\u52A0\u5F71\u5385");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {       //删除信息
				
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String sql="DELETE FROM fyt WHERE id="+ti.getText(0);
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
				
				cxsj();
			}
		});
		menuItem_2.setText("\u5220\u9664\u5F71\u5385");
		{
			Label label = new Label(composite, SWT.NONE);
			label.setBounds(137, 40, 355, 44);
			label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
			label.setFont(SWTResourceManager.getFont("华文行楷", 26, SWT.NORMAL));
			label.setText("\u653E     \u6620     \u5385     \u7BA1     \u7406");
		}
		
		cxsj();

		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	
	
	public void cxsj(){
		table.removeAll();
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select *from fyt");
		for (int i = 0; i < arr.size(); i++) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[3]});
	
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
