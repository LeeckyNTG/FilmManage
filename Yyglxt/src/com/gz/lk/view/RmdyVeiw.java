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
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import com.gz.lk.dialog.SzlcxDialog1;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.ResourceManager;

public class RmdyVeiw extends ViewPart {

	public static final String ID = "com.gz.lk.view.RmdyVeiw"; //$NON-NLS-1$
	private Table table;
	
	String sql="SELECT id,filmName,address,TIME,COUNT(*) FROM filmticket GROUP BY filmName ORDER BY COUNT(*) DESC";
	int currentPageNum=1;
	int pageCount=5;
	int max;
	
	DateTime dateTime,dateTime1;

	public RmdyVeiw() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		container.setForeground(SWTResourceManager.getColor(255, 255, 255));
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		{
			Label lblNewLabel = new Label(container, SWT.NONE);
			lblNewLabel.setForeground(SWTResourceManager.getColor(255, 255, 255));
			lblNewLabel.setFont(SWTResourceManager.getFont("华文行楷", 26, SWT.NORMAL));
			lblNewLabel.setBounds(322, 28, 298, 48);
			lblNewLabel.setText("\u70ED     \u95E8     \u7535     \u5F71");
		}
		{
			table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
			table.setBounds(241, 91, 448, 301);
			table.setHeaderVisible(true);
			table.setLinesVisible(true);
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(100);
				tableColumn.setText("\u7F16\u53F7");
			}
			{
				TableColumn tableColumn = new TableColumn(table, SWT.NONE);
				tableColumn.setWidth(142);
				tableColumn.setText("\u7535\u5F71\u540D");
			}
			{
				TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn.setWidth(100);
				tblclmnNewColumn.setText("\u653E\u6620\u5385");
			}
			{
				TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
				tblclmnNewColumn_1.setWidth(100);
				tblclmnNewColumn_1.setText("\u5F00\u64AD\u65F6\u95F4");
			}
			{
				Menu menu = new Menu(table);
				table.setMenu(menu);
				{
					MenuItem mntmNewItem = new MenuItem(menu, SWT.NONE);
					mntmNewItem.addSelectionListener(new SelectionAdapter() {
						@Override
						public void widgetSelected(SelectionEvent e) {              //上座率

							
							int index=table.getSelectionIndex();//获取指向的数据位置
							TableItem ti=table.getItem(index);
							String str2=ti.getText(2);
			
							DB db=new DB();
							ArrayList<String []> arrayList=db.arrQuery("select *from fyt where name like '%"+str2.substring(1, 2)+"%'");  //对应电影的放映厅
							
							ArrayList<String []> arr3=db.arrQuery(sql);      //arr3得到的是电影的排行
							
							String [] str1={arrayList.get(0)[0],arr3.get(0)[1]};   //对应放映厅的id，名字
							System.out.println(str1);
						
							
				
							
						
							
							ArrayList<String []> arr1=db.arrQuery("select *from fyt where id="+str1[0]);
							
							String str=arr1.get(0)[1];        //str是影厅名
							
							System.out.println("第"+str.substring(1, 2)+"大厅");
							
							System.out.println("select *from filmticket where filmName='"+str1[1]+"' and address like '%"+"第"+str.substring(1, 2)+"大厅"+"%'");
							
							ArrayList<String []> arr=db.arrQuery("select *from filmticket where filmName='"+str1[1]+"'");
							
							
							
							
							ArrayList<String []> arr2=db.arrQuery("select *from upfilm where filmName='"+str1[1]+"'");
					//		System.out.println("select *from upfilm where startTime like '%"+y+"-"+m +"%' and fyt like '%"+str.substring(1, 2)+"%'");
							
							String str5=arr1.get(0)[3];
							
							String [] sz=str5.split("-");
							
							int max=Integer.parseInt(sz[0])*Integer.parseInt(sz[1])*arr2.size();
							
							double xsb=(double)(arr.size()*100)/(double)max;
							
							DefaultPieDataset dpd = new DefaultPieDataset();
							
							//设置数据集一参数为String课动态设置二参数为double为站饼图的比例为多少
							dpd.setValue("销售量",xsb);
							dpd.setValue("空位数",100-xsb);
							
							
							System.out.println(arr.size()+"----"+max);
							
							//基于char工厂显示有5个参数一为设置显示的标题二为现实的图形数据
							//三未知四为鼠标触碰图片是是否会产生提示	
							//五位URL最要的参数点击图标是否会产生连接
							JFreeChart jc = ChartFactory.createPieChart3D("天天影院销售统计图",dpd,true,true,true);
							//jc为一个看到的图表
							ChartFrame cf = new ChartFrame("天天影院销售统计图",jc);
							
							cf.pack();
							
							cf.setVisible(true);
							
							
						}
					});
					mntmNewItem.setText("\u4E0A\u5EA7\u7387");
				}
			}
			{
				Label lblNewLabel_1 = new Label(container, SWT.NONE);
				lblNewLabel_1.setFont(SWTResourceManager.getFont("楷体", 14, SWT.NORMAL));
				lblNewLabel_1.setBounds(261, 423, 47, 21);
				lblNewLabel_1.setText("\u65F6\u533A\uFF1A");
			}
			{
				dateTime = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN | SWT.SHORT);
				dateTime.setBounds(375, 420, 93, 24);
			}
			{
				dateTime1 = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN | SWT.SHORT);
				dateTime1.setBounds(567, 423, 93, 24);
			}
			{
				Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
				button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						
						sql="SELECT id,filmName,address,TIME,COUNT(*) FROM filmticket GROUP BY filmName ORDER BY COUNT(*) DESC";
						
						
						int y=dateTime.getYear();
						int m=dateTime.getMonth()+1;
						int d=dateTime.getDay();
						String time = y+"-"+m ;
						y=dateTime1.getYear();
						m=dateTime1.getMonth()+1;
						d=dateTime1.getDay();
						String time1 = y+"-"+m;
						sql="SELECT *FROM (SELECT id,filmName,address,TIME,COUNT(*) FROM filmticket GROUP BY filmName ORDER BY COUNT(*) DESC) a HAVING TIME > '"+time+"' and TIME<'"+time1+"'";
						  
						
						System.out.println(sql);
						cxsj();
						
						
						
					}
				});
				button.setBounds(609, 470, 80, 27);
				button.setText("\u67E5\u8BE2");
			}
			{
				Button button = new Button(container, SWT.BORDER | SWT.TOGGLE);
				button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
				button.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
						sql="SELECT id,filmName,address,TIME,COUNT(*) FROM filmticket GROUP BY filmName ORDER BY COUNT(*) DESC";
						cxsj();
					}
				});
				button.setBounds(241, 470, 80, 27);
				button.setText("\u5237\u65B0");
			}
			cxsj();
		}

		createActions();
		initializeToolBar();
		initializeMenu();
	}
	
	public void cxsj(){
		table.removeAll();
		DB db=new DB();
		ArrayList<String []> arr=db.pageQuery(sql, currentPageNum, pageCount);
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
