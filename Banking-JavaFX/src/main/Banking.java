package src.main;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;




public class Banking extends Application {

    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    ArrayList<SavingsAccount> savingsAcc = new ArrayList<SavingsAccount>();
    ArrayList<ChequingAccount> checkingsAcc = new ArrayList<ChequingAccount>();
    

// Initializing the different scenes to be displayed throughout the application

        Stage window;

        Scene OpenAccountScene;

        Scene OpenAccountScene_S;

        Scene OpenAccountScene_C;

        Scene InterestScene;

        Scene DepositScene;
        
        Scene WithdrawScene;

        Scene TransactionsAccountSelect;

        Scene TransactionsTab;
    
        Scene AccountListScene;


    public static void main(String[] args) {
        launch(args);
    }

// Sets primary stage and renames to window for future use, sets 

        @Override
        public void start(Stage primaryStage) {
            window = primaryStage;
            window.setTitle("Banking");
            AppMenu();    
        }


// Main window AppMenu, displays all the functionality buttons

     public void AppMenu() {

                // Button and Event handler to switch to the Open Account Tab

                Button button1 = new Button("Open Account");
                button1.setOnAction(e -> AccountTypeSelect());



                // Button and Event handler to switch to Accont List Tab

                Button button2 = new Button("List Accounts");
                button2.setOnAction(e -> AccountListTab());

                // Button and Event handler to switch to the Deposit Tab

                Button button3 = new Button("Deposit ");
                button3.setOnAction(e -> DepositTab());

                // // Button and Event handler to switch to the Withdraw Tab

                 Button button4 = new Button("Withdraw ");
                 button4.setOnAction(e -> WithdrawTab());

                // // Button and Event handler to switch to the Interest Tab

                Button button5 = new Button("Pay Interest");
                button5.setOnAction(e -> InterestTab());

                // // Button and Event handler to switch to the Transaction Tab

                 Button button6 = new Button("Transactions");
                 button6.setOnAction(e -> GetTransactionList());

                // Tells the program to exit when button6 is pressed, this is the "Quit" button

                Button button7 = new Button("Quit");
                button7.setOnAction(e -> Platform.exit());
        
    

        // Creates a new Vbox called buttons for all of the buttons in the program
        // includes all the buttons, spacing and alignment for the children elements.

                VBox buttons = new VBox();
                buttons.setAlignment(Pos.CENTER);
                buttons.setSpacing(20);
                buttons.getChildren().addAll(button1, button2, button3, button4, button5, button6, button7);


        // Main BorderPane "App", includes the button vbox.

                BorderPane App = new BorderPane();
                App.setCenter(buttons);

                // Gets the file path of the CSS file used for styling the Banking Application.

                App.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());
                window.setScene(new Scene(App, 800, 600));
                window.show();
        }



        public void AccountTypeSelect() {


            Label AccountTypeLabel = new Label("Please choose what type of account");
            VBox AccountTypeCheck = new VBox(20);
            AccountTypeCheck.setAlignment(Pos.CENTER);

            Button SavingsBttn = new Button("Savings");
            SavingsBttn.setOnAction( e-> AccountTypeSavings());

            Button CheckingBttn = new Button("Checking");
            CheckingBttn.setOnAction( e-> AccountTypeCheckings());
                

            BorderPane OpenAccountTab = new BorderPane();
            OpenAccountTab.setCenter(AccountTypeCheck);
            OpenAccountScene = new Scene(OpenAccountTab, 800, 600);
            AccountTypeCheck.getChildren().addAll(AccountTypeLabel, SavingsBttn, CheckingBttn);
            OpenAccountScene.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());
            window.setScene(OpenAccountScene);
            window.show();
                
    }

 
        public void AccountTypeSavings() {

      
                    TextField SavingsAccName = new TextField();
                    Text SavingsAccNameLabel = new Text("Enter Account Name: ");
                    TextField SavingsAccNumber = new TextField();
                    Text SavingsAccNumLabel = new Text("Enter Account Number: ");
                    TextField SavingsBalance = new TextField();
                    Text SavingsBalLabel = new Text("Enter Account Balance:");
                    TextField SavingsInterest = new TextField();
                    Text SavingsIntrLabel = new Text("Enter Interest Rate:");



                        VBox SavingsTab = new VBox(20);

                            HBox SavingsAccNameBox = new HBox(10, SavingsAccNameLabel, SavingsAccName);
                            HBox SavingsAccNumBox = new HBox(10, SavingsAccNumLabel, SavingsAccNumber);
                            HBox SavingsBalBox = new HBox(10, SavingsBalLabel, SavingsBalance);
                            HBox SavingsIntBox = new HBox(10, SavingsIntrLabel, SavingsInterest);

                            Button SavingsSubmit = new Button("Submit");
                            Button ReturnButton = new Button("Return");

                            SavingsSubmit.setOnAction( e-> {
                                String AccName = SavingsAccName.getText();
                                String AccNum = SavingsAccNumber.getText();
                                double SavingsBal = Double.parseDouble(SavingsBalance.getText());
                                double SavingsIntAmount = Double.parseDouble(SavingsInterest.getText());
                                SavingsAccount a = new SavingsAccount(AccName, AccNum, SavingsBal, null, SavingsIntAmount, null);
                                savingsAcc.add(a);
                             
                            });

                            ReturnButton.setOnAction( e -> AppMenu());



                            SavingsTab.setAlignment(Pos.CENTER);
                            SavingsAccNameBox.setAlignment(Pos.CENTER);
                            SavingsAccNumBox.setAlignment(Pos.CENTER);
                            SavingsBalBox.setAlignment(Pos.CENTER);
                            SavingsIntBox.setAlignment(Pos.CENTER);
        

                 OpenAccountScene_S = new Scene(SavingsTab, 800, 600);
                 window.setScene(OpenAccountScene_S);
                 window.show();
                 SavingsTab.getChildren().addAll(SavingsAccNameBox,SavingsAccNumBox, SavingsBalBox, SavingsIntBox, SavingsSubmit, ReturnButton);
                 OpenAccountScene_S.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());
             
             }         
             
        // This is the checkings account method, for creating a new checkings account and saving it to an array.     
        public void AccountTypeCheckings() {
            
            // Creating new Textfields, and text labels just to display where the user needs to enter their data.
                    TextField CheckingsAccName = new TextField();
                    Text CheckingsAccNameLabel = new Text("Enter Account Name: ");
                    TextField CheckingsAccNumber = new TextField();
                    Text CheckingsAccNumLabel = new Text("Enter Account Number: ");
                    TextField CheckingsBalance = new TextField();
                    Text CheckingsBalLabel = new Text("Enter Account Balance:");
                    TextField CheckingsOverdraft = new TextField(); 
                    Text CheckingOvDraftLabel = new Text("Enter Overdraft Limit:");

 
                        VBox CheckingsTab = new VBox(20);
    
              
                            HBox CheckingsAccNameBox = new HBox(10, CheckingsAccNameLabel, CheckingsAccName);
                            HBox CheckingsAccNumBox = new HBox(10, CheckingsAccNumLabel, CheckingsAccNumber);
                            HBox CheckingsBalBox = new HBox(10, CheckingsBalLabel, CheckingsBalance);
                            HBox CheckingsIntBox = new HBox(10, CheckingOvDraftLabel, CheckingsOverdraft);

                            Button CheckingsSubmit = new Button("Submit");
                            Button ReturnButton = new Button("Return");

                              CheckingsSubmit.setOnAction( e-> {
                                String AccName = CheckingsAccName.getText();
                                String AccNum = CheckingsAccNumber.getText();
                                double CheckingsBal = Double.parseDouble(CheckingsBalance.getText());
                                double CheckingsOverD = Double.parseDouble(CheckingsOverdraft.getText());
                                ChequingAccount b = new ChequingAccount(AccName, AccNum, CheckingsBal, transactions, CheckingsOverD);
                                checkingsAcc.add(b);
                                
                            });


                            ReturnButton.setOnAction( e -> AppMenu());
                            
                            CheckingsTab.setAlignment(Pos.CENTER);
                            CheckingsAccNameBox.setAlignment(Pos.CENTER);
                            CheckingsAccNumBox.setAlignment(Pos.CENTER);
                            CheckingsBalBox.setAlignment(Pos.CENTER);
                            CheckingsIntBox.setAlignment(Pos.CENTER);
        

                 OpenAccountScene_C = new Scene(CheckingsTab, 800, 600);
                 window.setScene(OpenAccountScene_C);
                 window.show();
                 CheckingsTab.getChildren().addAll(CheckingsAccNameBox,CheckingsAccNumBox, CheckingsBalBox, CheckingsIntBox, CheckingsSubmit, ReturnButton);
                 OpenAccountScene_C.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());
             
        }

        public void InterestTab() {

            Label NewBalances = new Label("New Balances");
            Button ReturnButton = new Button("Return");
                    ReturnButton.setOnAction( e -> AppMenu());

                        TextArea SavingsAccountList = new TextArea();
                            SavingsAccountList.setWrapText(true);
                            SavingsAccountList.setPadding(new Insets(10));
                            SavingsAccountList.setPrefSize(350, 350);
                    

                            for (SavingsAccount savingsAccount : savingsAcc) {
                                savingsAccount.PayInterest();
                                double UpdatedAmount = savingsAccount.getAccountBalance();

                                SavingsAccountList.appendText("\n Account number " + savingsAccount.getAccountNumber()
                                + " Updated Balance: " + UpdatedAmount + "\n" );  
                            }
                            
                    BorderPane container = new BorderPane();
                    VBox Header = new VBox(20);
                
                    Header.setAlignment(Pos.TOP_CENTER);
                    Header.getChildren().addAll(NewBalances, SavingsAccountList, ReturnButton);
                    container.setCenter(Header);

        


                 InterestScene = new Scene(container, 800, 600);
                 window.show();
                 window.setScene(InterestScene);
                 InterestScene.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());
        }



        public void DepositTab() {

            VBox container = new VBox();


                Label DepositOption = new Label("Please Choose Account Number and Deposit Amount");

        
                    TextField AccountNum = new TextField();
                    Text AccountNumTxt = new Text("What is your account Number? :");
                    TextField DepositAmt = new TextField();
                    Text DepositAmtTxt = new Text("How much would you like to deposit? :");
                        
                      Button SubmitBttn = new Button("Submit");
                             SubmitBttn.setOnAction( e -> {
                                
                            String AccountNumber  = AccountNum.getText();
                            double DepositAmount = Double.parseDouble(DepositAmt.getText());
                        
                                for(ChequingAccount checksAccount : checkingsAcc) {
                                    if (checksAccount.getAccountNumber().equals(AccountNumber)) {
                                        checksAccount.Deposit(DepositAmount);

                                        Transaction depositTransaction = new Transaction(LocalDate.now(), 'D', 
                                        checksAccount.getAccountBalance(),DepositAmount,"Depositted into account");

                                        depositTransaction.setUpdatedBalance(checksAccount.getAccountBalance());
                                        depositTransaction.setTransactionAmount(DepositAmount);
                                        checksAccount.addTransaction(depositTransaction);
                                        break;
                                    }
                                }
                                
                                 for(SavingsAccount savesAccounts : savingsAcc) {
                                    if (savesAccounts.getAccountNumber().equals(AccountNumber)) {
                                        savesAccounts.Deposit(DepositAmount);
                                    
                                        Transaction depositTransaction = new Transaction(LocalDate.now(), 'D', 
                                        savesAccounts.getAccountBalance(),DepositAmount,"Depositted into account");
                                        
                                        depositTransaction.setUpdatedBalance(savesAccounts.getAccountBalance());
                                        depositTransaction.setTransactionAmount(DepositAmount);
                                        savesAccounts.addTransaction(depositTransaction);
                                        break;
                                    }
                                }
                            });

                        Button ReturnBttn = new Button("Return");
                        ReturnBttn.setOnAction(e -> AppMenu());
                    HBox Header = new HBox(DepositOption);           
                    HBox AccountNumBox = new HBox(20, AccountNumTxt, AccountNum);
                    HBox DepositAmtBox = new HBox(15, DepositAmtTxt, DepositAmt);
                    HBox ButtonBox = new HBox(20, ReturnBttn, SubmitBttn);
                
            

            DepositScene  = new Scene(container, 800,600);   
            container.getChildren().addAll(Header, AccountNumBox, DepositAmtBox, ButtonBox);     
            container.setSpacing(30);
            container.setAlignment(Pos.CENTER);
            Header.setAlignment(Pos.CENTER);
            AccountNumBox.setAlignment(Pos.BOTTOM_CENTER);
            DepositAmtBox.setAlignment(Pos.BOTTOM_CENTER);
            ButtonBox.setAlignment(Pos.BOTTOM_CENTER);
            window.show();
            window.setScene(DepositScene);
            DepositScene.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());

        }

        public void WithdrawTab() {

             VBox container = new VBox();


                Label WithdrawOption = new Label("Please Choose Account Number and Withdraw Amount");

        
                    TextField AccountNum = new TextField();
                    Text AccountNumTxt = new Text("What is your account Number? :");
                    TextField WithdrawAmt = new TextField();
                    Text WithdrawAmtTxt = new Text("How much would you like to withdraw? :");

                        Button SubmitBttn = new Button("Submit");
                            SubmitBttn.setOnAction( e -> {
                                
                            String AccountNumber  = AccountNum.getText();
                            double WithdrawAmount = Double.parseDouble(WithdrawAmt.getText());
                        
                            // Loops through the checkignsAcc checkings account until the entered account number is found, 
                            // then withdraws amount entered from that account ( which updates the account balance ) and then 
                            // creates a new transaction ArrayList for that account, updating the values and 
                            // adding it to the checksAccount ArrayList.

                                for(ChequingAccount checksAccount : checkingsAcc) {
                                    if (checksAccount.getAccountNumber().equals(AccountNumber)) {
                                        checksAccount.Withdraw(WithdrawAmount);

                                        Transaction withdrawTransaction = new Transaction(LocalDate.now(), 'W', 
                                        checksAccount.getAccountBalance(),WithdrawAmount,"Withdrawal from account");

                                        withdrawTransaction.setUpdatedBalance(checksAccount.getAccountBalance());
                                        withdrawTransaction.setTransactionAmount(WithdrawAmount);
                                        checksAccount.addTransaction(withdrawTransaction);
                                        break;
                                    }
                                }
                                
                                 for(SavingsAccount savesAccounts : savingsAcc) {
                                    if (savesAccounts.getAccountNumber().equals(AccountNumber)) {
                                        savesAccounts.Withdraw(WithdrawAmount);

                                           Transaction depositTransaction = new Transaction(LocalDate.now(), 'W', 
                                            savesAccounts.getAccountBalance(),WithdrawAmount,"Withdrawal from account");

                                            depositTransaction.setUpdatedBalance(savesAccounts.getAccountBalance());
                                            depositTransaction.setTransactionAmount(WithdrawAmount);
                                            savesAccounts.addTransaction(depositTransaction);
                                        break;
                                    }
                                }
                            });

                        Button ReturnBttn = new Button("Return");
                        ReturnBttn.setOnAction(e -> AppMenu());
                        

                    HBox Header = new HBox(WithdrawOption);           
                    HBox AccountNumBox = new HBox(20, AccountNumTxt, AccountNum);
                    HBox WithdrawAmtBox = new HBox(15, WithdrawAmtTxt, WithdrawAmt);
                    HBox ButtonBox = new HBox(20, ReturnBttn, SubmitBttn);
                
            

            WithdrawScene  = new Scene(container, 800,600);   
            container.getChildren().addAll(Header, AccountNumBox, WithdrawAmtBox, ButtonBox);   
            container.setSpacing(30);
            container.setAlignment(Pos.CENTER);
            Header.setAlignment(Pos.CENTER);
            AccountNumBox.setAlignment(Pos.BOTTOM_CENTER);
            WithdrawAmtBox.setAlignment(Pos.BOTTOM_CENTER);
            ButtonBox.setAlignment(Pos.BOTTOM_CENTER);
            window.show();
            window.setScene(WithdrawScene);
            WithdrawScene.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());
        }

   
        public void GetTransactionList() {

                    Label TransAccountLabel = new Label("Enter Account number to check transaction history. ");
                        BorderPane container = new BorderPane();

                            VBox Header = new VBox(20);   

                            TableColumn<Transaction, LocalDate> DateColumn = new TableColumn<>("Date");
                            DateColumn.setMinWidth(125);
                            TableColumn<Transaction, String> DescriptionColumn = new TableColumn<>("Description");
                            DescriptionColumn.setMinWidth(250);
                            TableColumn<Transaction, Double> TransAmtColumn = new TableColumn<>("Transaction Amount");
                            TransAmtColumn.setMinWidth(224);
                            TableColumn<Transaction, Double> AccBalance = new TableColumn<>("Account Balance");
                            AccBalance.setMinWidth(200);

                            DateColumn.setCellValueFactory(new PropertyValueFactory<>("TransactionDate"));
                            DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("TransactionDetails"));
                            TransAmtColumn.setCellValueFactory(new PropertyValueFactory<>("TransactionAmount"));
                            AccBalance.setCellValueFactory(new PropertyValueFactory<>("UpdatedBalance"));
                                                

                            TableView<Transaction> transactionTable = new TableView<>();

                            transactionTable.setPrefWidth(400); 
                            transactionTable.setPrefHeight(200); 

                            transactionTable.getColumns().addAll(DateColumn, DescriptionColumn, TransAmtColumn, AccBalance);

                            ObservableList<Transaction> allTransactions = FXCollections.observableArrayList();


                            Text EnterAccNum = new Text("Enter Account Number: ");
                            TextField EnterAccNumField = new TextField();



                            Button SubmitBttn = new Button("Submit");
                            SubmitBttn.setOnAction( e -> {

                                allTransactions.clear();
                                String AccountNumber = EnterAccNumField.getText();
                    

                                for (ChequingAccount checksAccount : checkingsAcc) {
                                    if (checksAccount.getAccountNumber().equals(AccountNumber)) {                        
                                            allTransactions.addAll(checksAccount.getTransactions());
                                            }
                                        }

                            
                                        for (SavingsAccount savesAccounts : savingsAcc) {
                                            if (savesAccounts.getAccountNumber().equals(AccountNumber)) {
                                                allTransactions.addAll(savesAccounts.getTransactions());
                                            }
                                        }
                                        

                            }); 

                            Button ReturnBttn = new Button("Return");
                            ReturnBttn.setOnAction(e -> AppMenu());

                            HBox AccountNumBox = new HBox(EnterAccNum,EnterAccNumField);
                            HBox ButtonBox = new HBox(15,SubmitBttn,ReturnBttn);

                
                        transactionTable.setItems(allTransactions);
                        Header.setAlignment(Pos.TOP_CENTER);
                        Header.getChildren().addAll(TransAccountLabel,AccountNumBox,ButtonBox );
                        ButtonBox.setAlignment(Pos.TOP_CENTER);
                        AccountNumBox.setAlignment(Pos.TOP_CENTER);
                        container.setTop(Header);
                        container.setCenter(transactionTable);

                        TransactionsAccountSelect = new Scene(container, 800, 600);
                    window.show();
                window.setScene(TransactionsAccountSelect);
        TransactionsAccountSelect.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());

        }


        public void AccountListTab() { 


                TextArea DisplayAccountList = new TextArea();
                Label AccountListLabel = new Label("Accounts List: ");
                Button ReturnButton = new Button("Return");
                
                            // Creating a Toggle group for the buttons so only one can be active at a time. 

                            ToggleGroup RBttns = new ToggleGroup();

                            RadioButton NameSort = new RadioButton("Sort By Name");
                            RadioButton AccNumSort  = new RadioButton("Sort by Account Number");
                            RadioButton BalSort = new RadioButton("Sort by Balance");

                         // Adding the radio buttons to the toggle group.
                            
                                NameSort.setToggleGroup(RBttns);
                                AccNumSort.setToggleGroup(RBttns);
                                BalSort.setToggleGroup(RBttns);

                                DisplayAccountList.setWrapText(true);
                                DisplayAccountList.setPadding(new Insets(10));
                                DisplayAccountList.setPrefSize(350, 350);

                                            for (ChequingAccount checksAccount : checkingsAcc) {
                                                DisplayAccountList.appendText(checksAccount.toString());
                                            }

                                
                                            for (SavingsAccount savesAccounts : savingsAcc) {
                                                DisplayAccountList.appendText(savesAccounts.toString());
                                            }

                                BorderPane container = new BorderPane();
                                HBox BttnBox = new HBox(20);
                                VBox Header = new VBox(20);
                        
                                Header.setAlignment(Pos.TOP_CENTER);
                                BttnBox.setAlignment(Pos.CENTER);

                                BttnBox.getChildren().addAll(NameSort , AccNumSort , BalSort);
                                Header.getChildren().addAll(AccountListLabel, DisplayAccountList, ReturnButton);

                                container.setBottom(Header);
                                container.setCenter(BttnBox);

                    ReturnButton.setOnAction( e -> {
                        DisplayAccountList.clear();
                        AppMenu();
                    });

                    
                    NameSort.setOnAction( e -> {
                        
                        // Creates a merged list with all accounts so they can be sorted without being separated
                        // into Checkings and Savings Accounts.

                            List<Account> mergedAccounts = new ArrayList<>();

                                mergedAccounts.addAll(savingsAcc);
                                mergedAccounts.addAll(checkingsAcc);

                                Collections.sort(mergedAccounts , new NameComparator());

                        // Clears the text appended to the text area previously, to append the new sorted text.

                                DisplayAccountList.clear();

                                for (Account account : mergedAccounts) {
                                                DisplayAccountList.appendText(account.toString());
                                            }

                    });


                    AccNumSort.setOnAction( e -> {

                            List<Account> mergedAccounts = new ArrayList<>();

                                mergedAccounts.addAll(savingsAcc);
                                mergedAccounts.addAll(checkingsAcc);

                                Collections.sort(mergedAccounts , new AccNumComparator());


                                DisplayAccountList.clear();

                                for (Account account : mergedAccounts) {
                                                DisplayAccountList.appendText(account.toString());
                                            }
                    });

                    BalSort.setOnAction( e -> {

                           
                            List<Account> mergedAccounts = new ArrayList<>();

                                mergedAccounts.addAll(savingsAcc);
                                mergedAccounts.addAll(checkingsAcc);

                                Collections.sort(mergedAccounts , new BalanceComparator());

                                DisplayAccountList.clear();

                                for (Account account : mergedAccounts) {
                                                DisplayAccountList.appendText(account.toString());
                                            }

                    });


                    AccountListScene = new Scene(container, 800, 600);
                    window.show();
                    window.setScene(AccountListScene);
                    AccountListScene.getStylesheets().add(Banking.class.getResource("_styles.css").toExternalForm());

        }
 }