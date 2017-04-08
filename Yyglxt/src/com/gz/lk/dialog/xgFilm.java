package com.gz.lk.dialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;

import com.gz.lk.core.Activator;
import com.gz.lk.tools.DB;
import org.eclipse.swt.widgets.DateTime;

public class xgFilm extends Dialog {

	protected Object result;
	protected Shell shell;
	
	private Text text;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_7;
	Label lblNewLabel;
	String str;
	String target;
	String id;
	String imgname;
	Combo combo,combo_1;
	
	DateTime dateTime,dateTime_1;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public xgFilm(Shell parent, int style) {
		super(parent, style);
		setText("修改影片信息");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String str) {
		this.str=str;
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), getStyle());
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/666627.jpg"));
		shell.setSize(814, 495);
		shell.setText(getText());
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label.setBounds(26, 22, 61, 17);
		label.setText("\u7535\u5F71\u540D\uFF1A");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_1.setBounds(26, 62, 61, 17);
		label_1.setText("\u56FD\u5BB6\uFF1A");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_2.setBounds(26, 102, 61, 17);
		label_2.setText("\u5BFC\u6F14\uFF1A");

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_3.setBounds(26, 142, 61, 17);
		label_3.setText("\u4E3B\u6F14\uFF1A");

		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_4.setBounds(26, 182, 61, 17);
		label_4.setText("\u65F6\u957F\uFF1A");

		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_5.setBounds(26, 222, 61, 17);
		label_5.setText("\u79CD\u7C7B\uFF1A");

		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_6.setBounds(26, 262, 61, 17);
		label_6.setText("\u8BED\u8A00\uFF1A");

		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_7.setBounds(26, 302, 61, 17);
		label_7.setText("\u7B80\u4ECB\uFF1A");

		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_8.setBounds(26, 342, 76, 17);
		label_8.setText("\u4E0A\u6620\u65F6\u95F4\uFF1A");

		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_9.setBounds(26, 382, 76, 17);
		label_9.setText("\u4E0B\u7EBF\u65F6\u95F4\uFF1A");
		
		
		combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"\u4E2D\u56FD", "\u7F8E\u56FD", "\u97E9\u56FD", "\u65E5\u672C", "\u82F1\u56FD", "\u4FC4\u56FD", "\u5370\u5EA6", "\u9A6C\u6765\u897F\u4E9A"});
		combo.setBounds(93, 60, 246, 25);
		
		combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setItems(new String[] {"\u4E2D\u6587", "\u7CA4\u8BED", "\u82F1\u8BED", "\u6C49\u8BED", "\u65E5\u8BED", "\u4FC4\u8BED", "\u97E9\u8BED"});
		combo_1.setBounds(93, 260, 246, 25);

		text = new Text(shell, SWT.BORDER);
		text.setBounds(93, 19, 246, 23);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(93, 100, 246, 23);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(93, 140, 246, 23);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(93, 180, 126, 23);

		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(93, 220, 246, 23);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(93, 300, 246, 23);
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/227153b35ecaed9869bebafe6a745e4a.jpg"));
		lblNewLabel.setImage(ResourceManager.getPluginImage("Yyglxt",
				"icons/alt_about.gif"));
		lblNewLabel.setBounds(531, 35, 160, 220);
		
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select *from film where id="+str);
		System.out.println(str);
		text.setText(arr.get(0)[1]);
		combo.setText(arr.get(0)[2]);
		text_2.setText(arr.get(0)[3]);
		text_3.setText(arr.get(0)[4]);
		text_4.setText(arr.get(0)[5]);
		text_5.setText(arr.get(0)[6]);
		combo_1.setText(arr.get(0)[7]);
		
		text_7.setText(arr.get(0)[8]);
		String imgName=arr.get(0)[9];
		lblNewLabel.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+imgName+""));
		
		Link link = new Link(shell, SWT.NONE);
		link.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {//上传图片
				
				
				FileDialog fd = new FileDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
				String str = fd.open();//源路径

				lblNewLabel.setImage(SWTResourceManager.getImage(str));//让选中 的图片显示在label中
				try {
					
					URL url = Activator.getDefault().getBundle().getResource("img");//获取url对象   uniform  resource   locator  统一资源定位器
					String targetPath = FileLocator.toFileURL(url).toString();
					System.out.println(targetPath.substring(6));
					//给目标文件起名字
					String t = str.substring(str.lastIndexOf("."));//找到.最后一次出现的位置
					
					
					imgname = new Date().getTime()+t;//获取图片名称
					
					
					System.out.println("名字是："+targetPath.substring(6)+new Date().getTime()+t); //获取名字同时要获取上传文件的后缀名
					
					target =targetPath.substring(6)+new Date().getTime()+t;//
					
					
					FileInputStream fis = new FileInputStream(str);//输入流 指向源 从源中拉取数据
					FileOutputStream fos = new FileOutputStream(target);//输出流 指向目标  向目标写入数据
					
					
					byte[] b = new byte[1024];
					int num = 0;
					while((num = fis.read(b))!=-1){
						fos.write(b, 0, num);
					}
					
					
					fis.close();
					fos.close();
					
					
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			
			}
		});
		link.setBounds(630, 313, 61, 17);
		link.setText("<a>\u4E0A\u4F20\u56FE\u7247</a>");
		
		Button button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {   //修改信息
				
				String name=text.getText();
				String country = combo.getText();
				String director=text_2.getText();
				String mianActor=text_3.getText();
				String time = text_4.getText()+"分钟";
				String kind=text_5.getText();
				String language = combo_1.getText();
				String intro=text_7.getText();
				
				int y=dateTime.getYear();
				int m=dateTime.getMonth()+1;
				int d=dateTime.getDay();
				String upDate = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
				y=dateTime_1.getYear();
				m=dateTime_1.getMonth()+1;
				d=dateTime_1.getDay();
				String downDate = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);


				boolean bol=true;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/yyglxt","root","mysql");
					PreparedStatement ps=con.prepareStatement("update film set NAME='"+name+"',film.country='"+country+"',film.director='"+director+"',film.mianActor='"+mianActor+"',film.time='"+time+"',film.update='"+upDate+"',kind='"+kind+"',LANGUAGE='"+language+"',intro='"+intro+"',downDate='"+downDate+"',imgName='"+imgname+"',img=? where id="+str);
					FileInputStream fis =new FileInputStream(target);
			
					ps.setBinaryStream(1, fis,fis.available());	
					
					bol=ps.execute();
					
					System.out.println(bol);					
					con.close();
					fis.close();
				
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					if (!bol) {
						MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("保存成功");
						mb.open();
					}else {
						MessageBox mb=new MessageBox(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("保存失败！请检查数据。");
						mb.open();
					}
				}
	
			shell.close();	
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		button.setBounds(610, 378, 80, 27);
		button.setText("\u4FEE\u6539");
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_10.setBounds(236, 182, 61, 23);
		label_10.setText("\u5206\u949F");
		
		dateTime = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(113, 335, 116, 24);
		
		dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(113, 375, 116, 24);
	

	}
}
