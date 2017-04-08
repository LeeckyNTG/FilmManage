package com.gz.lk.dialog;


import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Link;

import com.gz.lk.tools.DB;
public class ckVIP extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	String id;
	
	Label lblNewLabel_2;
	
	String str1;
	String target;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ckVIP(Shell parent, int style) {
		super(parent, style);
		setText("SWT Dialog");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String id) {
		this.id=id;
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
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/tb.png"));
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/666627.jpg"));
		shell.setSize(810, 499);
		shell.setText("\u4F1A\u5458\u4FE1\u606F\u67E5\u770B");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_BLUE));
		label_1.setFont(SWTResourceManager.getFont("楷体", 24, SWT.NORMAL));
		label_1.setBounds(187, 22, 403, 43);
		label_1.setText("信     息     查     看");
		
		Group group = new Group(shell, SWT.BORDER);
		group.setText("\u4FE1\u606F\u586B\u5199");
		group.setBounds(61, 105, 669, 296);
		
		text = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(154, 64, 188, 23);
		
		Label lblNewLabel = new Label(group, SWT.NONE);
		lblNewLabel.setBounds(44, 67, 45, 17);
		lblNewLabel.setText("\u59D3\u540D\uFF1A");
		
		Label label = new Label(group, SWT.NONE);
		label.setBounds(44, 107, 45, 17);
		label.setText("\u6027\u522B\uFF1A");
		
		text_1 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(154, 239, 188, 23);
		
		Label lblNewLabel_1 = new Label(group, SWT.NONE);
		lblNewLabel_1.setBounds(44, 242, 61, 17);
		lblNewLabel_1.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		lblNewLabel_2 = new Label(group, SWT.NONE);
		lblNewLabel_2.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/1cd11bae456f04dfad319d1c8851b86a.jpg"));
		lblNewLabel_2.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/alt_about.gif"));
		lblNewLabel_2.setBounds(468, 30, 136, 157);
		
		
		Label label_2 = new Label(group, SWT.NONE);
		label_2.setBounds(44, 30, 61, 17);
		label_2.setText("\u4F1A\u5458\u7F16\u53F7\uFF1A");
		
		text_2 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(154, 24, 188, 23);
		
		text_3 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(154, 104, 188, 23);
		
		
		
		Label label_3 = new Label(group, SWT.NONE);
		label_3.setBounds(44, 151, 61, 17);
		label_3.setText("\u79EF\u5206\uFF1A");
		
		text_4 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(154, 148, 188, 23);
		
		Label label_4 = new Label(group, SWT.NONE);
		label_4.setBounds(44, 194, 61, 17);
		label_4.setText("\u7B49\u7EA7\uFF1A");
		
		text_5 = new Text(group, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(154, 191, 188, 23);
		
		
		
		DB db=new DB();
		System.out.println(id);		
		String sql="select *from vip where id="+id;		
		ArrayList<String []> arr=db.arrQuery(sql);
		
		text_2.setText(id);
		
		
		text.setText(arr.get(0)[1]);
		
		text_3.setText(arr.get(0)[2]);
		
		
		text_4.setText(arr.get(0)[3]);
		text_5.setText(arr.get(0)[4]);
		
		text_1.setText(arr.get(0)[5]);
		
		
		
		String imgName=arr.get(0)[6];
		
		
		lblNewLabel_2.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+imgName));
		
		
		Button button_2 = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button_2.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {        //注册信息
				
				
				shell.close();	

			}
		});
		button_2.setBounds(650, 433, 80, 27);
		button_2.setText("\u786E\u5B9A");

	}
}
