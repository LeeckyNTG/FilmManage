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
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

public class XsetjView extends ViewPart {

	public static final String ID = "com.gz.lk.view.XsetjView"; //$NON-NLS-1$
	private Text text;
	
	DateTime dateTime ;
	

	public XsetjView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setForeground(SWTResourceManager.getColor(0, 255, 0));
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 14, SWT.NORMAL));
		lblNewLabel.setBounds(346, 243, 137, 17);
		lblNewLabel.setText("\u9009\u62E9\u7EDF\u8BA1\u65F6\u95F4\uFF1A");
		
		dateTime = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN | SWT.SHORT);
		dateTime.setBounds(487, 236, 124, 24);
		
		Label label = new Label(container, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 14, SWT.NORMAL));
		label.setForeground(SWTResourceManager.getColor(0, 255, 0));
		label.setBounds(346, 309, 92, 17);
		label.setText("\u9500\u552E\u989D\uFF1A");
		
		text = new Text(container, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(489, 309, 221, 23);
		
		Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				
				
				int y=dateTime.getYear();
				int m=dateTime.getMonth()+1;
				int m2=dateTime.getMonth()+2;

				String time = y+"-"+(m > 9 ? m : "0"+m);
				
				String time1 = y+"-"+(m2 > 9 ? m2 : "0"+m2);
				
				String sql="select *from filmticket where buyTime >'" +time+"' and buyTime<'"+time1+"'";
				
				double zh=0,zh1=0;
				
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery(sql);
				
				for (int i = 0; i < arr.size(); i++) {
					zh=zh+Double.parseDouble(arr.get(i)[6]);
				}
				

				ArrayList<String []> arr1=db.arrQuery("select *from filmticket where buyTime like '%"+y+"%'");
				
				for (int i = 0; i < arr1.size(); i++) {
					zh1=zh1+Double.parseDouble(arr1.get(i)[6]);
				}
				
				double xsb=(zh*100)/zh1;
				
				DefaultPieDataset dpd = new DefaultPieDataset();
				
				//设置数据集一参数为String课动态设置二参数为double为站饼图的比例为多少
				dpd.setValue("当月销售额",xsb);
				dpd.setValue("当年销售额",100-xsb);
				
	
				
				//基于char工厂显示有5个参数一为设置显示的标题二为现实的图形数据
				//三未知四为鼠标触碰图片是是否会产生提示	
				//五位URL最要的参数点击图标是否会产生连接
				JFreeChart jc = ChartFactory.createPieChart3D("销售额统计图",dpd,true,true,true);
				//jc为一个看到的图表
				ChartFrame cf = new ChartFrame("销售额统计图",jc);
				
				cf.pack();
				
				cf.setVisible(true);
				
				
				
				
				
				
				
			}
		});
		button.setBounds(346, 374, 80, 27);
		button.setText("\u67E5\u770B\u7EDF\u8BA1\u56FE");
		
		Button button_1 = new Button(container, SWT.BORDER | SWT.TOGGLE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(Tjview.ID);
			
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().hideView(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().findView(XsetjView.ID));
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}		
			}
		});
		button_1.setBounds(663, 374, 80, 27);
		button_1.setText("\u8FD4\u56DE\u4E0A\u4E00\u5C42");
		
		Button button_2 = new Button(container, SWT.BORDER);
		button_2.setFont(SWTResourceManager.getFont("楷体", 9, SWT.NORMAL));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int y=dateTime.getYear();
				int m=dateTime.getMonth()+1;
				int m2=dateTime.getMonth()+2;

				String time = y+"-"+(m > 9 ? m : "0"+m);
				
				String time1 = y+"-"+(m2 > 9 ? m2 : "0"+m2);
				
				String sql="select *from filmticket where buyTime >'" +time+"' and buyTime<'"+time1+"'";
				
				double zh=0,zh1=0;
				
				DB db=new DB();
				ArrayList<String []> arr=db.arrQuery(sql);
				
				for (int i = 0; i < arr.size(); i++) {
					zh=zh+Double.parseDouble(arr.get(i)[6]);
				}
				
				text.setText(zh+"");
				ArrayList<String []> arr1=db.arrQuery("select *from filmticket where buyTime like '%"+y+"%'");
				
				for (int i = 0; i < arr1.size(); i++) {
					zh1=zh1+Double.parseDouble(arr1.get(i)[6]);
				}
				
				double xsb=(zh*100)/zh1;
				
				
				
				
				
				
				
			}
		});
		button_2.setBounds(642, 245, 61, 21);
		button_2.setText("\u67E5\u8BE2");
		
		Label lblNewLabel_1 = new Label(container, SWT.NONE);
		lblNewLabel_1.setForeground(SWTResourceManager.getColor(0, 255, 0));
		lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 22, SWT.NORMAL));
		lblNewLabel_1.setBounds(204, 109, 671, 49);
		lblNewLabel_1.setText("\u9500        \u552E        \u989D        \u7EDF        \u8BA1");

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
