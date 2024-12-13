import java.awt.*;
import javax.swing.*;

public class BankAccountGUI extends JFrame {
    private JTextField accountNameField, depositField, withdrawField;
    private JTextArea accountInfoArea;
    private BankAccount account;

    public BankAccountGUI() {
        // Set up frame properties
        setTitle("Simple Bank Account System");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        // Define colors
        Color backgroundColor = Color.WHITE;      // Background
        Color textColor = Color.BLACK;           // Text
        Color accentColor = new Color(30, 144, 255); // Blue accent (Dodger Blue)

        // Set frame background color
        getContentPane().setBackground(backgroundColor);

        // Labels and Text Fields
        JLabel accountNameLabel = new JLabel("Account Name:");
        accountNameLabel.setBounds(20, 20, 120, 30);
        accountNameLabel.setForeground(textColor);
        add(accountNameLabel);

        accountNameField = new JTextField();
        accountNameField.setBounds(140, 20, 200, 30);
        accountNameField.setBackground(backgroundColor);
        accountNameField.setForeground(textColor);
        add(accountNameField);

        JLabel depositLabel = new JLabel("Deposit Amount:");
        depositLabel.setBounds(20, 60, 120, 30);
        depositLabel.setForeground(textColor);
        add(depositLabel);

        depositField = new JTextField();
        depositField.setBounds(140, 60, 200, 30);
        depositField.setBackground(backgroundColor);
        depositField.setForeground(textColor);
        add(depositField);

        JLabel withdrawLabel = new JLabel("Withdraw Amount:");
        withdrawLabel.setBounds(20, 100, 120, 30);
        withdrawLabel.setForeground(textColor);
        add(withdrawLabel);

        withdrawField = new JTextField();
        withdrawField.setBounds(140, 100, 200, 30);
        withdrawField.setBackground(backgroundColor);
        withdrawField.setForeground(textColor);
        add(withdrawField);

        // Buttons with accent color
        JButton createAccountButton = new JButton("Create Account");
        createAccountButton.setBounds(20, 140, 150, 30);
        createAccountButton.setBackground(accentColor);
        createAccountButton.setForeground(Color.WHITE);
        add(createAccountButton);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(180, 140, 100, 30);
        depositButton.setBackground(accentColor);
        depositButton.setForeground(Color.WHITE);
        add(depositButton);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(290, 140, 100, 30);
        withdrawButton.setBackground(accentColor);
        withdrawButton.setForeground(Color.WHITE);
        add(withdrawButton);

        JButton checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setBounds(20, 180, 150, 30);
        checkBalanceButton.setBackground(accentColor);
        checkBalanceButton.setForeground(Color.WHITE);
        add(checkBalanceButton);

        // Text Area for Account Info
        accountInfoArea = new JTextArea();
        accountInfoArea.setBounds(20, 220, 350, 120);
        accountInfoArea.setEditable(false);
        accountInfoArea.setBackground(backgroundColor);
        accountInfoArea.setForeground(textColor);
        accountInfoArea.setBorder(BorderFactory.createLineBorder(accentColor, 2));
        add(accountInfoArea);

        // Action Listeners
        createAccountButton.addActionListener(e -> {
            String accountName = accountNameField.getText();
            if (!accountName.isEmpty()) {
                account = new BankAccount(accountName);
                accountInfoArea.setText("Account created for: " + accountName);
            } else {
                accountInfoArea.setText("Account name cannot be empty!");
            }
        });

        depositButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(depositField.getText());
                account.deposit(amount);
                accountInfoArea.setText("Deposited: " + amount + "\nNew Balance: " + account.getBalance());
            } catch (Exception ex) {
                accountInfoArea.setText("Invalid deposit amount or no account exists.");
            }
        });

        withdrawButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(withdrawField.getText());
                account.withdraw(amount);
                accountInfoArea.setText("Withdrew: " + amount + "\nNew Balance: " + account.getBalance());
            } catch (Exception ex) {
                accountInfoArea.setText(ex.getMessage());
            }
        });

        checkBalanceButton.addActionListener(e -> {
            if (account != null) {
                accountInfoArea.setText("Account: " + account.getAccountName() + "\nBalance: " + account.getBalance());
            } else {
                accountInfoArea.setText("No account exists!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BankAccountGUI().setVisible(true);
        });
    }
}
