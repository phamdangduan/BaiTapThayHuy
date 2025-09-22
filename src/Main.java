//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            java.awt.CardLayout cardLayout = new java.awt.CardLayout();
            javax.swing.JPanel root = new javax.swing.JPanel(cardLayout);

            final String WELCOME = "WELCOME";
            final String CREATE = "CREATE";

            WelcomeScreen welcome = new WelcomeScreen(() -> {
                cardLayout.show(root, CREATE);
            });

            CreateAccountScreen create = new CreateAccountScreen(() -> {
                cardLayout.show(root, WELCOME);
            });

            root.add(welcome, WELCOME);
            root.add(create, CREATE);

            javax.swing.JFrame frame = new javax.swing.JFrame("Flow: Welcome & Create Account");
            frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
            frame.setContentPane(root);
            frame.setSize(600, 300);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}