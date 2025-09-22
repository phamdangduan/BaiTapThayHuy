import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Arrays;

public class CreateAccountScreen extends JPanel {
	public interface Navigator {
		void goToWelcome();
	}

	public CreateAccountScreen(Navigator navigator) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(16, 16, 16, 16));

		JLabel stepLabel = new JLabel("Create Account");
		stepLabel.setFont(stepLabel.getFont().deriveFont(Font.BOLD, stepLabel.getFont().getSize() + 2f));
		add(stepLabel);
		add(Box.createRigidArea(new Dimension(0, 12)));

		JPanel firstRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		JLabel nameLabel = new JLabel("Full name:");
		JTextField nameField = new JTextField(22);
		firstRow.add(nameLabel);
		firstRow.add(nameField);

		JPanel emailRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(22);
		emailRow.add(emailLabel);
		emailRow.add(emailField);

		JPanel secondRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		JLabel passLabel = new JLabel("Password:");
		JPasswordField passField = new JPasswordField(22);
		JButton backBtn = new JButton("Quay lại");
		backBtn.addActionListener(e -> navigator.goToWelcome());
		JButton submitBtn = new JButton("Register");
		submitBtn.setEnabled(false);
		runnableEnableOnValid(nameField, emailField, passField, submitBtn);
		submitBtn.addActionListener(e -> {
			String name = nameField.getText().trim();
			String email = emailField.getText().trim();
			char[] pass = passField.getPassword();
			System.out.println("Register: " + name + " | " + email + " / " + new String(pass));
			Arrays.fill(pass, '\0');
		});
		secondRow.add(passLabel);
		secondRow.add(passField);
		secondRow.add(backBtn);
		secondRow.add(submitBtn);

		add(firstRow);
		add(Box.createRigidArea(new Dimension(0, 8)));
		add(emailRow);
		add(Box.createRigidArea(new Dimension(0, 10)));
		add(secondRow);
	}

	private void runnableEnableOnValid(JTextField nameField, JTextField emailField, JPasswordField passField, JButton submitBtn) {
		java.util.function.Consumer<Void> validate = v -> {
			String name = nameField.getText().trim();
			String email = emailField.getText().trim();
			char[] pass = passField.getPassword();
			boolean ok = !name.isEmpty() && !email.isEmpty() && pass.length >= 1;
			submitBtn.setEnabled(ok);
			return null;
		};
		nameField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
			public void removeUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
			public void changedUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
		});
		emailField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
			public void removeUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
			public void changedUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
		});
		passField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
			public void insertUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
			public void removeUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
			public void changedUpdate(javax.swing.event.DocumentEvent e) { validate.accept(null); }
		});
	}
}


