import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

public class WelcomeScreen extends JPanel {
	public interface Navigator { void goToCreateAccount(); }

	public WelcomeScreen(Navigator navigator) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new EmptyBorder(16, 16, 16, 16));

		JLabel stepLabel = new JLabel("Welcome", SwingConstants.LEFT);
		stepLabel.setFont(stepLabel.getFont().deriveFont(Font.BOLD, stepLabel.getFont().getSize() + 2f));
		stepLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(stepLabel);
		add(Box.createRigidArea(new Dimension(0, 12)));

		// Email field
		JPanel emailRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		emailRow.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(22);
		emailRow.add(emailLabel);
		emailRow.add(emailField);

		// Password field
		JPanel passRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		passRow.setAlignmentX(Component.LEFT_ALIGNMENT);
		JLabel passLabel = new JLabel("Password:");
		JPasswordField passField = new JPasswordField(22);
		passRow.add(passLabel);
		passRow.add(passField);

		// Actions
		JPanel actionsRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 12, 0));
		actionsRow.setAlignmentX(Component.LEFT_ALIGNMENT);
		JButton loginBtn = new JButton("Login");
		loginBtn.addActionListener(e -> {
			String email = emailField.getText().trim();
			char[] pw = passField.getPassword();
			System.out.println("Login: " + email + " / " + new String(pw));
		});
		JButton forgotBtn = new JButton("Forgot password?");
		forgotBtn.addActionListener(e -> System.out.println("Forgot password clicked"));
		JButton createBtn = new JButton("Create account");
		createBtn.addActionListener(e -> navigator.goToCreateAccount());
		actionsRow.add(loginBtn);
		actionsRow.add(forgotBtn);
		actionsRow.add(createBtn);

		add(emailRow);
		add(Box.createRigidArea(new Dimension(0, 8)));
		add(passRow);
		add(Box.createRigidArea(new Dimension(0, 12)));
		add(actionsRow);
		setAlignmentX(Component.LEFT_ALIGNMENT);
	}
}


