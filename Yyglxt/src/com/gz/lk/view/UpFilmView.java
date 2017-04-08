package com.gz.lk.view;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.core.Activator;
import com.gz.lk.dialog.addFilm;
import com.gz.lk.dialog.ckFilm;
import com.gz.lk.dialog.xgFilm;
import com.gz.lk.tools.DB;
import org.eclipse.wb.swt.ResourceManager;

public class UpFilmView extends ViewPart {
	
	private Table table;
	String sql="select *from film where 1=1";
	int currentPageNum=1;
	int pageCount=10;
	int max;
	Label lblNewLabel_6;
	Label lblNewLabel_5 ;
	boolean bol=true;
	Link link;
	DateTime dateTime,dateTime_1;

	public static final String ID = "com.gz.lk.view.UpFilmView"; //$NON-NLS-1$
	private Text text;
	private Text text_1;
	private Text text_2;

	public UpFilmView() {
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

		max=getMaxPage();
		lblNewLabel_5 = new Label(container, SWT.NONE);
		lblNewLabel_5.setBounds(854, 377, 25, 27);
		lblNewLabel_5.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblNewLabel_5.setText(String.valueOf(max));
		
		
		Label lblNewLabel_4 = new Label(container, SWT.NONE);
		lblNewLabel_4.setBounds(829, 377, 19, 22);
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblNewLabel_4.setText("/");
		
		lblNewLabel_6 = new Label(container, SWT.NONE);
		lblNewLabel_6.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblNewLabel_6.setBounds(798, 377, 25, 27);
		lblNewLabel_6.setText("0");
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(61, 93, 1000, 259);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(69);
		tableColumn_8.setText("\u7F16\u53F7");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7535\u5F71\u540D");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u56FD\u5BB6");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5BFC\u6F14");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(66);
		tableColumn_3.setText("\u65F6\u957F");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(87);
		tableColumn_4.setText("\u79CD\u7C7B");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(75);
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

		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_HIGHLIGHT_SHADOW));
		lblNewLabel.setFont(SWTResourceManager.getFont("楷体", 28, SWT.BOLD));
		lblNewLabel.setBounds(297, 28, 526, 46);
		lblNewLabel.setText(" \u7535     \u5F71      \u4E0A      \u6620");
		
		

		
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
		button_2.setBounds(640, 379, 80, 27);
		button_2.setText("\u4E0A\u4E00\u9875");
		
		Group group = new Group(container, SWT.NONE);
		group.setText("\u7535\u5F71\u7BA1\u7406");
		group.setBounds(261, 428, 540, 177);
		
		Label label = new Label(group, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_YELLOW));
		label.setBounds(56, 13, 72, 17);
		label.setText("\u7535\u5F71\u7F16\u53F7\uFF1A");
		
		text = new Text(group, SWT.BORDER);
		text.setBounds(150, 10, 215, 23);
		
		Button button = new Button(group, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String num=text.getText();
				
				String fyt=text_1.getText();
				
				String price=text_2.getText();
				
				int year=dateTime.getYear();
				int month=dateTime.getMonth();
				int day=dateTime.getDay();
				
				int hour=dateTime_1.getHours();
				int min=dateTime_1.getMinutes();
				
				
			
				
				
				String upTime=year+"-"+month+"-"+day+" "+hour+":"+min;
				System.out.println(upTime);
				

				
				
				String sql="select *from film where id="+num;    
				
				
				
				
				DB db=new DB();
				
				
				ArrayList< String []> arr=db.arrQuery(sql);    //取出film中的数据
				
				String sql1="insert into upfilm (filmName,fyt,kind,language,startTime,time,price,upTime,imgName,img) values ('"+arr.get(0)[1]+"','"+fyt+"','"+arr.get(0)[6]+"','"+arr.get(0)[7]+"','"+upTime+"','"+arr.get(0)[5]+"','"+price+"','"+arr.get(0)[11]+"','"+arr.get(0)[9]+"',?)";
				
				String wjm=arr.get(0)[9];
				

				URL url = Activator.getDefault().getBundle().getResource("img");
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/yyglxt", "root",
							"mysql");
					PreparedStatement ps=con.prepareStatement(sql1);
					
					String targetPath = FileLocator.toFileURL(url).toString();
					
					String target = targetPath.substring(6)+wjm;
					
					FileInputStream fis = new FileInputStream(target);

					ps.setBinaryStream(1, fis, fis.available());

					bol = ps.execute();

					System.out.println(bol);
					con.close();
					fis.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					if (!bol) {
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("上映成功！");
						mb.open();
					} else {
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("上映失败！请检查数据。");
						mb.open();
					}
				}				
			}
		});
		button.setBounds(410, 142, 80, 27);
		button.setText("\u4E0A\u6620\u7535\u5F71");
		
		Label label_1 = new Label(group, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_1.setBounds(56, 54, 72, 17);
		label_1.setText("\u653E\u6620\u5927\u5385\uFF1A");
		
		text_1 = new Text(group, SWT.BORDER);
		text_1.setBounds(150, 51, 215, 23);
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLUE));
		label_2.setBounds(56, 147, 61, 17);
		label_2.setText("\u4EF7      \u683C\uFF1A");
		
		text_2 = new Text(group, SWT.BORDER);
		text_2.setBounds(150, 144, 215, 23);
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label_3.setBounds(56, 96, 61, 17);
		label_3.setText("\u5F00\u64AD\u65F6\u95F4\uFF1A");
		
		dateTime = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(150, 89, 88, 24);
		
		dateTime_1 = new DateTime(group, SWT.BORDER | SWT.TIME);
		dateTime_1.setBounds(271, 89, 93, 24);
		
		

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
