package com.gz.lk.editor;

import org.eclipse.core.runtime.IProgressMonitor;


import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.wb.swt.ResourceManager;

import com.gz.lk.dialog.TicketXxxx;
import com.gz.lk.editor.SeatEditor;
import com.gz.lk.tools.DB;
import com.gz.lk.view.welcom;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Group;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.DateTime;
public class BuyTicket extends EditorPart implements IEditorInput{

	public static final String ID = "com.gz.lk.editor.BuyTicket"; //$NON-NLS-1$
	
	
	int leftAdd=219-10;
	int topAdd=355-81;
	int size;
	
	Link link;
	boolean bol=true;
	public static String data,data1;
	
	
	ArrayList<String[]> arr;
	int j;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	String sql="select * from upfilm";
	DateTime dateTime,dateTime_1;

	public BuyTicket() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.WorkbenchPart#createPartControl(org.eclipse.swt.widgets.Composite)
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/\u672A\u547D\u540D1(1).jpeg"));
		container.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		
		

	/*	
		Button button = new Button(container, SWT.NONE);
		button.setImage(ResourceManager.getPluginImage("Yyglxt", "img/1438941027696.jpg"));
		button.setBounds(219, 81, 160, 220);
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.setImage(ResourceManager.getPluginImage("Yyglxt", "img/1438941027696.jpg"));
		button_2.setBounds(10, 355, 160, 220);*/
//		Button button = new Button(container, SWT.NONE);
//		button.addMouseTrackListener(new MouseTrackAdapter() {
//			@Override
//			public void mouseEnter(MouseEvent e) {
//			}
//		});
//		button.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseDoubleClick(MouseEvent e) {
//			}
//		});
//		button.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//			}
//		});
//		button.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+arr.get(j)[9]));//获取图片名称并显示
//		button.setBounds(10, 81, 160, 220);
//		
//		Menu menu = new Menu(button);
//		button.setMenu(menu);
//		
//		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
//		menuItem.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//			}
//		});
//		menuItem.setText("详细信息");
		DB db  = new DB();
		
		
		
		arr = db.arrQuery(welcom.sql);
		size=arr.size();
		
		
		System.err.println(size);
		
		
		System.out.println(welcom.num);
		
		for (j = welcom.num; j <size; j++) {
			
			System.out.println();
			System.out.println(j+"-------------------");
			
			String fyt=arr.get(j)[2];
			
			DB db1=new DB();
			ArrayList<String []> arr1=db1.arrQuery("select *from fyt where name='第"+fyt+"影厅'");
			
			String str=arr1.get(0)[3];
			
			String [] gg=str.split("-");
			
			String fid = gg[0];
			
			String rowcols = gg[1];
		
			
			final Link link = new Link(container, SWT.NONE);
			link.setData(j);
			link.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					
					
					data1 = String.valueOf(link.getData());
					
					
					TicketXxxx tx=new TicketXxxx(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), SWT.CLOSE|SWT.MAX|SWT.MIN|SWT.APPLICATION_MODAL);
					tx.open();

				}
			});
			if(((j)%10)> 4){//i=5
				link.setBounds(90+(j%10 -5)*leftAdd, 307+topAdd, 86, 17);
				
			}else{
				link.setBounds(90+(j%10 )*leftAdd, 307, 86, 17);
				
				
			}
			
//			link.setBounds(90, 307, 80, 17);
			link.setText("<a>查看详细信息</a>");
						
			final Button button = new Button(container, SWT.NONE);
			button.setData(arr.get(j)[0]+"-"+fid+"-"+rowcols);
			
			button.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+arr.get(j)[9]));//获取图片名称并显示
			
			
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					
					data = (String)button.getData();
					
					

					try {
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new SeatEditor(), SeatEditor.ID);//打开一个editor
						
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(BuyTicket.this, true);//关闭自己
						
						
						
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
	
				}
			});
			
			
			if(((j)%10)> 4){//i=5
				button.setBounds(10+(j%10 -5)*leftAdd, 81+topAdd, 160, 220);
				
			}else{
				button.setBounds(10+(j%10 )*leftAdd, 81, 160, 220);
				
				
			}
			
			button.getSelection();
			
			
			
		}
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			welcom.num+=10;
			
			if (welcom.num>size) {
				MessageBox mbBox=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
				mbBox.setMessage("没有更多的电影了！");
				mbBox.setText("消息提示！");
				mbBox.open();
				
			}else {
				try {
					
					
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new BuyTicket(), BuyTicket.ID);
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(BuyTicket.this, true);
				
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
							
			}
		});
		button_1.setBounds(1140, 585, 80, 27);
		button_1.setText("\u4E0B\u4E00\u9875");

		Button button = new Button(container, SWT.BORDER);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {       //上一页
				welcom.num-=10;
				
				if (welcom.num<0) {
					MessageBox mbBox=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
					mbBox.setMessage("已经是第一页了！");
					mbBox.setText("消息提示！");
					mbBox.open();
					
				}else {
					try {
						
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new BuyTicket(), BuyTicket.ID);
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(BuyTicket.this, true);
					
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
								
			}
		});
		button.setBounds(1026, 585, 80, 27);
		button.setText("\u4E0A\u4E00\u9875");
		
		Label lblNewLabel = new Label(container, SWT.NONE);
		lblNewLabel.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		lblNewLabel.setBounds(1026, 66, 61, 17);
		lblNewLabel.setText("\u7535\u5F71\u540D\uFF1A");
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(1093, 66, 127, 23);
		
		Label label = new Label(container, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_GREEN));
		label.setText("\u65F6\u95F4\u8303\u56F4\uFF1A");
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label.setBounds(1026, 121, 61, 17);
		
		dateTime = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(1093, 121, 127, 24);
		dateTime.setVisible(false);
		
		dateTime_1 = new DateTime(container, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(1093, 166, 127, 24);
		dateTime_1.setVisible(false);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_MAGENTA));
		label_1.setText("\u8BED\u8A00\uFF1A");
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label_1.setBounds(1026, 217, 61, 17);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(1093, 216, 127, 23);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setForeground(SWTResourceManager.getColor(SWT.COLOR_CYAN));
		label_2.setText("\u65F6\u957F\uFF1A");
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label_2.setBounds(1026, 280, 61, 17);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(1093, 280, 127, 23);
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(1093, 344, 127, 23);
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setForeground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		label_3.setText("\u7C7B\u578B\uFF1A");
		label_3.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 10, SWT.NORMAL));
		label_3.setBounds(1026, 344, 61, 17);
		
		Button button_2 = new Button(container, SWT.BORDER);
		button_2.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {           //多条件查询
				
				sql="select *from upfilm where 1=1";
				
				String filmName=text.getText();

				String language=text_1.getText();

				String time=text_2.getText();
				
				String kind=text_3.getText();
				
				
				
				if (!filmName.trim().equals("")) {
					sql=sql+" and filmName like '%"+filmName+"%'";
					System.out.println(sql);
				}
				if (!language.trim().equals("")) {
					sql=sql+" and language like '%"+language+"%'";
					System.out.println(sql);
				}
				if (!time.trim().equals("")) {
					sql=sql+" and time like '%"+time+"%'";
					System.out.println(sql);
				}
				if (!kind.trim().equals("")) {
					sql=sql+" and kind like '%"+kind+"%'";
					System.out.println(sql);
				}
				
				
				if (!bol) {
					int y=dateTime.getYear();
					int m=dateTime.getMonth()+1;
					int d=dateTime.getDay();
					String time1 = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
					
					y=dateTime_1.getYear();
					m=dateTime_1.getMonth()+1;
					d=dateTime_1.getDay();
					String time2 = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
					
					sql = sql + " AND startTime BETWEEN '"+time1+"' AND '"+time2+"'";
				}
					
					welcom.sql=sql;
					System.out.println(sql+"sql语句------------------------------------");
					
					try {
						
						
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().openEditor(new BuyTicket(), BuyTicket.ID);
						PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(BuyTicket.this, true);
					
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
		
			}
		});
		button_2.setBounds(1159, 403, 61, 27);
		button_2.setText("\u67E5\u8BE2");
		
		link = new Link(container, SWT.NONE);
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (bol) {
					dateTime.setVisible(true);
					dateTime_1.setVisible(true);
					link.setText("<a>关闭</a>");
					bol=false;
				}else {
					dateTime.setVisible(false);
					dateTime_1.setVisible(false);
					link.setText("<a>开启</a>");
					bol=true;
				}
			}
		});
		link.setBounds(1026, 166, 53, 17);
		link.setText("<a>\u5F00\u542F</a>");

	}
	
	
//	public boolean equals(Object obj) {
//		boolean bEquals = false;
//		try {
//			if (obj != null && obj instanceof BuyTicket) {
//				if (getName().equals(((BuyTicket) obj).getName())) {
//					bEquals = true;
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return bEquals;
//	}


	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// Initialize the editor part
		setSite(site);
		setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}

	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "name";
	}

	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return "text";
	}
}
