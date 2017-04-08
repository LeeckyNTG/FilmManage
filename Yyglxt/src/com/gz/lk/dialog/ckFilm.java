package com.gz.lk.dialog;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.widgets.Button;

import com.gz.lk.tools.DB;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class ckFilm extends Dialog {

	protected Object result;
	protected Shell shell;
	
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private Text text_5;
	private Text text_6;
	private Text text_7;
	private Text text_8;
	private Text text_9;
	Label lblNewLabel;
	String target;
	String str;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ckFilm(Shell parent, int style) {
		super(parent, style);
		setText("查看影片信息");
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
		shell.setSize(814, 496);
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

		text = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text.setBounds(93, 19, 246, 23);

		text_1 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_1.setBounds(93, 60, 246, 23);

		text_2 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_2.setBounds(93, 100, 246, 23);

		text_3 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_3.setBounds(93, 140, 246, 23);

		text_4 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_4.setBounds(93, 180, 246, 23);

		text_5 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_5.setBounds(93, 220, 246, 23);

		text_6 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_6.setBounds(93, 260, 246, 23);

		text_7 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_7.setBounds(93, 300, 246, 23);

		text_8 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_8.setBounds(130, 340, 209, 23);

		text_9 = new Text(shell, SWT.BORDER | SWT.READ_ONLY);
		text_9.setBounds(130, 380, 209, 23);
		
		lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/227153b35ecaed9869bebafe6a745e4a.jpg"));
		lblNewLabel.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/227153b35ecaed9869bebafe6a745e4a.jpg"));
		lblNewLabel.setBounds(536, 37, 159, 219);
		
		
		
		DB db=new DB();
		ArrayList<String []> arr=db.arrQuery("select *from film where id="+str);
		System.out.println(str);
		text.setText(arr.get(0)[1]);
		text_1.setText(arr.get(0)[2]);
		text_2.setText(arr.get(0)[3]);
		text_3.setText(arr.get(0)[4]);
		text_4.setText(arr.get(0)[5]);
		text_5.setText(arr.get(0)[6]);
		text_6.setText(arr.get(0)[7]);
		text_7.setText(arr.get(0)[8]);
		text_8.setText(arr.get(0)[11]);
		text_9.setText(arr.get(0)[12]);
		String imgName=arr.get(0)[9];
		lblNewLabel.setImage(ResourceManager.getPluginImage("Yyglxt", "img/"+imgName+""));
		

		
		
		Button button = new Button(shell, SWT.BORDER | SWT.TOGGLE);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
			}
		});
		button.setBounds(615, 378, 80, 27);
		button.setText("\u786E\u5B9A");

	}
}
