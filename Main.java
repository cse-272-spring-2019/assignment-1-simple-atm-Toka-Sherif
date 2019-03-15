package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {


    Stage window;
    Scene page,intro;



    logicwindow windowLogic = new logicwindow();
   // validation users = new validation();



    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;


        //First panel
        Label username  = new Label("USERNAME");
        Label cardNumber = new Label("CARD NUMBER");
        TextField userNameField = new TextField();
        TextField cardNumberField = new TextField();
        Button submit = new Button("submit");
        Label note2 = new Label();

        GridPane grid = new GridPane();
        grid.add(username,0,0);
        grid.add(userNameField,1,0);
        grid.add(cardNumber,0,1);
        grid.add(cardNumberField,1,1);
        grid.add(submit,0,2);
        grid.add(note2, 0,7);

       /* submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String input = cardNumberField.getText();
                String inpiutCheck = "1234";
                if(input.equals(inpiutCheck))
                {
                    window.setScene(page);
                }
                else
                {
                    System.out.println("failed");
                }

            }
        });

*/

        //Second Panel
        Button withdraw = new Button("withdraw");
        Button deposit = new Button ("Deposit");
        Button NextTransaction = new Button ("Next Transaction");
        Button PrevTransaction = new Button ("Prev Transaction");
        Button getCurrent = new Button ("getCurrent");
        TextField balanceField = new TextField();
        Label amountLabel = new Label();
        Label note = new Label("NOTE: you can:t enter more than 5 inquires");


        GridPane grid2 = new GridPane();

        //...................................................
        GridPane.setConstraints(withdraw,0,1);
        GridPane.setConstraints(deposit,1,1);
        GridPane.setConstraints(amountLabel,0,5);
        GridPane.setConstraints(NextTransaction,0,2);
        GridPane.setConstraints(PrevTransaction,1,2);
        GridPane.setConstraints(getCurrent,0,3);
        GridPane.setConstraints(balanceField,1,3);
        GridPane.setConstraints(note,0,7);
        grid2.getChildren().addAll(withdraw,deposit,NextTransaction,PrevTransaction,getCurrent,balanceField,amountLabel,note);
        //...................................................

        Scene intro = new Scene(grid,400,200);
        Scene page = new Scene(grid2,500,300);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String input ;
                do {
                    input = cardNumberField.getText();
                    int input2 = Integer.parseInt(input);
                    boolean result2 = windowLogic.validate(input2);
                    if (result2 == true)
                        window.setScene(page);
                    else {
                        note2.setText("Wrong CARD NUMBER"+"\n"+" PLease re-enter card number");
                         }
                }while(input == null);


            }
        });


        //submit.setOnAction(event ->  window.setScene(page));

        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String input =balanceField.getText();
                int input2 = Integer.parseInt(input);
                int result = windowLogic.withdraw(input2);
                if(result != 0)
                amountLabel.setText(String.valueOf("The balance is:"+result));
                else
                    amountLabel.setText(String.valueOf("Error....The amount to be withdrawn isn't found"));

            }


        });

        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String input =balanceField.getText();
                int input2 = Integer.parseInt(input);
                int result = windowLogic.deposit(input2);
                amountLabel.setText(String.valueOf("The balance is :"+result));

            }
        });

        getCurrent.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int result = windowLogic.getCurrentBalance();
                amountLabel.setText(String.valueOf("The balance is :"+result));

            }
        });

        NextTransaction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int result = windowLogic.nextTransaction();
                amountLabel.setText(String.valueOf("The balance is :"+result));
                GlobaleVariables.i--;
            }
        });

        PrevTransaction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int result = windowLogic.prevTransaction();
                amountLabel.setText(String.valueOf("The balance is :"+result));
                GlobaleVariables.i++;

            }
        });






        window.setTitle("ATM APPLICATION");
        window.setScene(intro);
        window.show();



    }


    public static void main(String[] args) {
        launch(args);
    }
}
