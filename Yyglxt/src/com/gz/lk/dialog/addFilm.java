package com.gz.lk.dialog;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.ui.PlatformUI;

import com.gz.lk.core.Activator;
import org.eclipse.swt.widgets.ExpandBar;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;

public class addFilm extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_7;
	Label lblNewLabel;
	String str1;
	String target;
	Combo combo,combo_1;
	
	DateTime dateTime,dateTime_1;

	/**
	 * Create the dialog.
	 * 
	 * @param parent
	 * @param style
	 */
	public addFilm(Shell parent, int style) {
		super(parent, style);
		setText("添加影片");
	}

	/**
	 * Open the dialog.
	 * 
	 * @return the result
	 */
	public Object open() {
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
		shell.setSize(814, 499);
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
		label_8.setBounds(26, 342, 80, 17);
		label_8.setText("\u4E0A\u6620\u65F6\u95F4\uFF1A");

		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_9.setBounds(26, 382, 80, 17);
		label_9.setText("\u4E0B\u7EBF\u65F6\u95F4\uFF1A");

		text = new Text(shell, SWT.BORDER);
		text.setBounds(93, 20, 246, 23);

		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(93, 100, 246, 23);

		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(93, 140, 246, 23);

		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(93, 180, 160, 23);

		text_5 = new Text(shell, SWT.BORDER);
		text_5.setBounds(93, 220, 246, 23);

		text_7 = new Text(shell, SWT.BORDER);
		text_7.setBounds(93, 300, 246, 23);

		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/227153b35ecaed9869bebafe6a745e4a.jpg"));
		lblNewLabel.setBounds(530, 23, 160, 220);

		Link link = new Link(shell, SWT.NONE);
		link.setFont(SWTResourceManager.getFont("楷体", 10, SWT.NORMAL));
		link.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) { // 上传图片

				FileDialog fd = new FileDialog(PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getShell(), SWT.NONE);
				String str = fd.open();// 获取文件路径

				lblNewLabel.setImage(SWTResourceManager.getImage(str));// ////

				URL url = Activator.getDefault().getBundle().getResource("img");
				try {
					String targetPath = FileLocator.toFileURL(url).toString();

					String hz = str.substring(str.lastIndexOf("."));

					long wjm = new Date().getTime();
					target = targetPath.substring(6) + wjm + hz;
					str1 = wjm + hz;
					FileInputStream fis = new FileInputStream(str);
					FileOutputStream fos = new FileOutputStream(targetPath
							.substring(6) + wjm + hz);

					String target = targetPath.substring(6) + wjm + hz;
					System.out.println(target);

					byte[] b = new byte[1024];

					int num = 0;
					while ((num = fis.read(b)) != -1) {
						fos.write(b, 0, num);
					}
					fis.close();
					fos.close();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		link.setBounds(637, 318, 71, 17);
		link.setText("<a>\u4E0A\u4F20\u56FE\u7247</a>");

		Button button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String name = text.getText();

				String country = combo.getText();

				String director = text_2.getText();

				String mianActor = text_3.getText();

				String time = text_4.getText()+"分钟";

				String kind = text_5.getText();

				String language = combo_1.getText();

				String intro = text_7.getText();
				
				
				int y=dateTime.getYear();
				int m=dateTime.getMonth()+1;
				int d=dateTime.getDay();
				String upDate = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
				y=dateTime_1.getYear();
				m=dateTime_1.getMonth()+1;
				d=dateTime_1.getDay();
				String downDate = y+"-"+(m > 9 ? m : "0"+m)+"-"+(d > 9 ? d : "0"+d);
				

				boolean bol = true;

				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con = DriverManager.getConnection(
							"jdbc:mysql://localhost:3306/yyglxt", "root",
							"mysql");
					PreparedStatement ps=con.prepareStatement("insert into film (NAME,film.country,film.director,film.mianActor,film.time,film.update,kind,LANGUAGE,intro,downDate,imgName,img)values ('"+name+"','"+country+"','"+director+"','"+mianActor+"','"+time+"','"+upDate+"','"+kind+"','"+language+"','"+intro+"','"+downDate+"','"+str1+"',?)");
					System.out.println("insert into film (NAME,film.country,film.director,film.mianActor,film.time,film.update,kind,LANGUAGE,intro,downDate,imgName,img)values ('"+name+"','"+country+"','"+director+"','"+mianActor+"','"+time+"','"+upDate+"','"+kind+"','"+language+"','"+intro+"','"+downDate+"','"+str1+"");
					FileInputStream fis = new FileInputStream(target);

					
				/*	ps.setString(1, name);

					ps.setString(2, country);

					ps.setString(3, director);

					ps.setString(4, mianActor);
					ps.setString(5, time);
					ps.setString(6, kind);
					ps.setString(7, language);
					ps.setString(8, intro);
					ps.setString(9, str1);
					ps.setString(11, downDate);
					ps.setString(10, upDate);*/
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
						mb.setMessage("保存成功");
						mb.open();
					} else {
						MessageBox mb = new MessageBox(PlatformUI
								.getWorkbench().getActiveWorkbenchWindow()
								.getShell(), SWT.NONE);
						mb.setText("消息提示");
						mb.setMessage("保存失败！请检查数据。");
						mb.open();
					}
				}

				shell.close();
			}
		});
		button.setBounds(610, 378, 80, 27);
		button.setText("\u786E\u5B9A\u6DFB\u52A0");
		
		Label label_10 = new Label(shell, SWT.NONE);
		label_10.setFont(SWTResourceManager.getFont("楷体", 12, SWT.NORMAL));
		label_10.setBounds(259, 182, 42, 23);
		label_10.setText("\u5206\u949F");
		
		combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"\u4E2D\u56FD", "\u7F8E\u56FD", "\u97E9\u56FD", "\u65E5\u672C", "\u82F1\u56FD", "\u4FC4\u56FD", "\u5370\u5EA6", "\u9A6C\u6765\u897F\u4E9A"});
		combo.setBounds(93, 60, 246, 25);
		combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setItems(new String[] {"\u4E2D\u6587", "\u7CA4\u8BED", "\u82F1\u8BED", "\u6C49\u8BED", "\u65E5\u8BED", "\u4FC4\u8BED", "\u97E9\u8BED"});
		combo_1.setBounds(93, 260, 246, 25);
		
		dateTime = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime.setBounds(112, 335, 109, 24);
		
		dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.DROP_DOWN);
		dateTime_1.setBounds(112, 375, 109, 24);
		

	}
}
