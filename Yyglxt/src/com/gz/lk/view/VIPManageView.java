package com.gz.lk.view;

import java.util.ArrayList;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.dialog.VIPAdd;
import com.gz.lk.dialog.ckVIP;
import com.gz.lk.dialog.xgVIP;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.ResourceManager;



public class VIPManageView extends ViewPart {

	public static final String ID = "com.gz.lk.view.VIPManageView"; //$NON-NLS-1$
	
	private Table table;
	String sql="select *from vip where 1=1";
	int currentPageNum=1;
	int pageCount=10;
	int max;
	Label label_2;
	Label label_1;

	public VIPManageView() {
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
		Label label = new Label(container, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		label.setFont(SWTResourceManager.getFont("����", 24, SWT.NORMAL));
		label.setBounds(377, 43, 396, 54);
		label.setText("\u4F1A     \u5458     \u4FE1     \u606F");
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(255, 131, 655, 266);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(68);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u59D3\u540D");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u6027\u522B");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u79EF\u5206");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("\u7B49\u7EA7");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(183);
		tableColumn_5.setText("\u8054\u7CFB\u7535\u8BDD");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {                 //��Աע��

				VIPAdd va=new VIPAdd(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);

				va.open();
				
				max=getMaxPage();   //�������ҳ��
				label_2.setText(String.valueOf(max));
				if (max<currentPageNum) {
					currentPageNum=max;
				}
				
				cxsj();
				
				
				
			}
		});
		menuItem.setText("\u6DFB\u52A0\u4F1A\u5458");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {           //�޸���Ϣ
				xgVIP xe=new xgVIP(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				int index=table.getSelectionIndex();//��ȡָ�������λ��
				TableItem ti=table.getItem(index);
				String str=ti.getText(0);
				
				System.out.println(str);
				xe.open(str);
				
				max=getMaxPage();   //�������ҳ��
				label_2.setText(String.valueOf(max));
				if (max<currentPageNum) {
					currentPageNum=max;
				}
				
				cxsj();
				
				
				
			}
		});
		menuItem_1.setText("\u4FEE\u6539\u4FE1\u606F");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {          //ɾ����Ա��Ϣ
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String sql="DELETE FROM vip WHERE id="+ti.getText(0);
				DB db=new DB();
				int num=db.update(sql);
				if (num>0) {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.None);
					mb.setText("��ʾ��Ϣ");
					mb.setMessage("ɾ���ɹ���");
				}else {
					MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.None);
					mb.setText("��ʾ��Ϣ");
					mb.setMessage("ɾ��ʧ�ܣ�");
				}
				
				
				max=getMaxPage();   //�������ҳ��
				label_2.setText(String.valueOf(max));
				if (max<currentPageNum) {
					currentPageNum=max;
				}
				
				cxsj();
				
				
			}
		});
		menuItem_2.setText("\u5220\u9664\u4F1A\u5458");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {       //�鿴��Ա��Ϣ
				
				ckVIP cf=new ckVIP(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
				
				int index=table.getSelectionIndex();
				TableItem ti=table.getItem(index);
				String  arr=ti.getText(0);
				cf.open(arr);
				
			}
		});
		menuItem_3.setText("\u8BE6\u7EC6\u4FE1\u606F");
		
		Button btnNewButton = new Button(container, SWT.BORDER | SWT.TOGGLE);
		btnNewButton.setFont(SWTResourceManager.getFont("����", 10, SWT.BOLD));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {           //��һҳ
				
				if(currentPageNum>1){
					currentPageNum--;
					cxsj();
					}
			}
		});
		btnNewButton.setBounds(581, 434, 80, 27);
		btnNewButton.setText("\u4E0A\u4E00\u9875");
		
		Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("����", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {      //��һҳ
				
				
				int max=getMaxPage();
				if(currentPageNum<max){
				currentPageNum++;
				cxsj();
				}else{
					MessageBox mb = new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					
					mb.setMessage("�Ѿ������һҳ ");//������ʾ��Ϣ
					mb.setText("��ʾ");//���ñ���
					mb.open();
				}
				
			}
		});
		button.setBounds(830, 434, 80, 27);
		button.setText("\u4E0B\u4E00\u9875");
		
		label_1 = new Label(container, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_1.setBounds(712, 439, 24, 17);
		label_1.setText("0");
		
		label_2 = new Label(container, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label_2.setBounds(766, 439, 24, 17);
		label_2.setText("0");
		max=getMaxPage();
		label_2.setText(String.valueOf(max));
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_3.setBounds(742, 439, 18, 17);
		label_3.setText("/");
		
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
			tableItem.setText(new String []{arr.get(i)[0],arr.get(i)[1],arr.get(i)[2],arr.get(i)[3],arr.get(i)[4],arr.get(i)[5]});
			if (arr.get(0)!=null) {
				label_1.setText(String.valueOf(currentPageNum));
			}
			else {
				label_2.setText(String.valueOf(0));
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
