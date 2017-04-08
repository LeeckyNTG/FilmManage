package com.gz.lk.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;

public class FyxxView extends ViewPart {

	public static final String ID = "com.gz.lk.view.FyxxView"; //$NON-NLS-1$
	private Table table;

	public FyxxView() {
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
			label.setBounds(303, 28, 266, 49);
			label.setText("\u653E    \u6620     \u4FE1    \u606F");
		}
		{
			table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(159, 95, 572, 360);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			{
				TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn.setWidth(100);
				tblclmnNewColumn.setText("\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(164);
				tableColumn.setText("\u7535\u5F71\u540D");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(130);
				tableColumn.setText("\u5F71\u5385");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(174);
				tableColumn.setText("\u8D2D\u4E70\u65F6\u95F4");
			}
		}
		Date date=new Date();
		date.setDate(date.getDate()-3);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式"yyyy/MM/dd HH:mm:ss"
		String time1 = df.format(date);
		
		Date date1=new Date();
		date1.setDate(date.getDate()+3);
		DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");//设置显示格式"yyyy/MM/dd HH:mm:ss"
		String time2 = df1.format(date1);

		String yt=fytManageView.str.substring(1, 2);
		
		System.out.println(yt);
		
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select *from filmticket where address like '%"+yt+"%' and buyTime>'"+time1+"' and buyTime<'"+time2+"'");
		
		System.out.println("select *from filmticket where address like '%"+yt+"%' and buyTime>'"+time1+"' and buyTime<'"+time2+"'");
		
		
		for (int i = 0; i < arr.size(); i++) {
			
			
			
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[3],arr.get(i)[4],arr.get(i)[7]});
	
		}
		
	
		
		

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
