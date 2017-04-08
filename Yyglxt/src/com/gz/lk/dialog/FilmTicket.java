package com.gz.lk.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.ResourceManager;

public class FilmTicket extends Dialog {

	protected Object result;
	protected Shell shell;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public FilmTicket(Shell parent, int style) {
		super(parent, style);
		setText("电影票打印");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(String []str) {
		createContents(str);
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
	private void createContents(String []str) {
		shell = new Shell(getParent(), getStyle());
		shell.setImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		shell.setBackgroundMode(SWT.INHERIT_DEFAULT);
		shell.setBackgroundImage(ResourceManager.getPluginImage("Yyglxt", "icons/8c68791c42fc01cf87a018f01cbe8da1.jpg"));
		shell.setSize(450, 306);
		shell.setText(getText());
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_BACKGROUND));
		label.setFont(SWTResourceManager.getFont("楷体", 14, SWT.NORMAL));
		label.setBounds(133, 24, 150, 24);
		label.setText("\u5929\u5929\u5F71\u9662\u7535\u5F71\u7968");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(34, 106, 61, 17);
		lblNewLabel.setText("电影名：");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(34, 141, 61, 17);
		lblNewLabel_1.setText("时间：");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(34, 183, 61, 17);
		lblNewLabel_2.setText("地点：");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(34, 221, 61, 17);
		lblNewLabel_3.setText("座位号：");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(104, 106, 245, 17);
		lblNewLabel_4.setText(str[0]);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText(str[1]);
		label_1.setBounds(101, 141, 245, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText(str[2]);
		label_2.setBounds(101, 183, 245, 17);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText(str[3]);
		label_3.setBounds(101, 221, 245, 17);
		
		Button button = new Button(shell, SWT.BORDER);
		button.setFont(SWTResourceManager.getFont("楷体", 10, SWT.BOLD));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				shell.close();
			}
		});
		button.setBounds(315, 244, 80, 27);
		button.setText("\u786E\u5B9A");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(34, 64, 61, 17);
		label_4.setText("\u7F16\u53F7\uFF1A");
		
		Label lblNewLabel_5 = new Label(shell, SWT.NONE);
		lblNewLabel_5.setBounds(104, 64, 188, 17);
		lblNewLabel_5.setText(str[4]);

	}

}
