
import javafx.application.Application;
import javafx.geometry.Insets;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import java.util.concurrent.atomic.AtomicInteger;

public class ChatScreen extends Application{

    private final Stage stage;
    private final VBox box = new VBox();
    private VBox messageArea;
    private String messageFont = "Arial";
    private int messageFontSize = 14;

    private Label count1 = new Label(); 
    private static Label count2 = new Label();
    private Button start = new Button("Start");
    private Button stop = new Button("Stop");
    private Button refresh = new Button("Refresh");


    public ChatScreen() {

        box.getStyleClass().add("chatbox");

        stage = new Stage();
        stage.setTitle("Chat DACS 2023");
        TextField txt = new TextField();
        txt.setTranslateY(370);
        txt.setTranslateX(0);
        txt.setPrefWidth(610);

        messageArea = new VBox();
        // messageArea.setFillWidth(true);
        messageArea.setSpacing(10);
        ScrollPane scrollPane = new ScrollPane(messageArea);
        scrollPane.setPrefSize(610, 360);

        txt.setPromptText("Type a message...");

        Button send = new Button();
        send.setText("SEND");
        send.setTranslateX(614);
        send.setTranslateY(370);
        send.setPrefHeight(20);
        send.setPrefWidth(60);

        send.setOnAction(actionEvent -> {
            String messageText = txt.getText().trim();
            if (!messageText.isEmpty()) {
                Text message = new Text(messageText);
                message.setFont(Font.font(messageFont, messageFontSize));
                message.setTextAlignment(TextAlignment.CENTER);
                message.setWrappingWidth(250);
        
                HBox chatBubble = new HBox();
                chatBubble.getChildren().add(message);
                chatBubble.setPadding(new Insets(10));
                chatBubble.getStyleClass().add("chat_bubble");
                chatBubble.setAlignment(Pos.BASELINE_RIGHT); 
        
                StackPane messageContainer = new StackPane(chatBubble);
                messageContainer.setAlignment(Pos.BASELINE_RIGHT);
    
        
                HBox senderBox = new HBox();
                senderBox.setAlignment(Pos.BASELINE_RIGHT);
                senderBox.setPadding(new Insets(0, 10, 0, 0));
        
                VBox messageBox = new VBox(senderBox, messageContainer);
                messageBox.setPrefWidth(Region.USE_COMPUTED_SIZE);
                messageBox.setPadding(new Insets(5, 5, 5, 320));
        
                String responseText = "Thanks for your message!";
                Text responseMessage = new Text(responseText);
                responseMessage.setFont(Font.font(messageFont, messageFontSize));
                responseMessage.setTextAlignment(TextAlignment.CENTER);
                responseMessage.setWrappingWidth(250);
        
                HBox responseBubble = new HBox();
                responseBubble.getChildren().add(responseMessage);
                responseBubble.setPadding(new Insets(10));
                responseBubble.getStyleClass().add("chat_bubble2");
        
                StackPane responseContainer = new StackPane(responseBubble);
                responseContainer.setAlignment(Pos.BASELINE_LEFT);
        
                
        
                HBox receiverBox = new HBox();
                receiverBox.setPadding(new Insets(0, 0, 0, 10));
        
                VBox responseBox = new VBox(receiverBox, responseContainer);
                responseBox.setAlignment(Pos.BASELINE_LEFT);
                responseBox.setPrefWidth(Region.USE_COMPUTED_SIZE);
                responseBox.setPadding(new Insets(5, 50, 5, 5));
        
                messageArea.getChildren().addAll(messageBox, responseBox);
                messageArea.layout();
                txt.clear();
            }
        });
        HBox messageInputBox = new HBox(txt, send);
        messageInputBox.setSpacing(10);
        messageInputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(scrollPane, messageInputBox);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(send);


        // Time count

        HBox h = new HBox();
        h.setSpacing(5);
        h.setPadding(new Insets(10, 10, 10, 10));

        count1.setFont(new Font("Times New Roman",20));
        count2.setFont(new Font("Times New Roman",20));

        h.getChildren().addAll(count1,count2,start,stop,refresh);
        h.setAlignment(Pos.TOP_RIGHT);

        AtomicInteger time = new AtomicInteger(-1);
        //Scene scene = new Scene(h,500,400);
        Time t = new Time();

        start.setOnAction(event-> {

            String message = t.getMessage();

            if (message == null || message.length()< 1){
                count2.setText("second");
                if (time.get() == -1)time.set(0);
                t.setStartNumber(time.get());
            }else{
                count2.setText("second");
                t.setStartNumber(Integer.parseInt(message));
            }

            t.restart();
        });

        stop.setOnAction(event -> {
            if (time.get() == -1)count2.setText("task not started");
            else {
                String message = t.getMessage();
                t.cancel();
                time.set(Integer.parseInt(message));
            }
        });

        refresh.setOnAction(event -> {
            t.restart();
            t.setStartNumber(-1);
            t.cancel();
            time.set(-1);
            count2.setText("");
            messageArea = new VBox();
        });

        count1.textProperty().bind(t.messageProperty());
        //primaryStage.setTitle("Count time");
        //primaryStage.setScene(scene);
        //primaryStage.show();
        

        Group parent = new Group();

        parent.getChildren().add(messageArea);
        parent.getChildren().add(scrollPane);

        parent.getChildren().add(txt);
        parent.getChildren().add(send);

        parent.getChildren().add(h);

        Scene scene1 = new Scene(parent, 700, 400);
        scene1.getStylesheets().add("chat.css");
        stage.setScene(scene1);

        stage.show();
    }

    static class Time extends Service<Void>{

        private int startNumber = -1;

        public void setStartNumber(int startNumber) {
            this.startNumber = startNumber;
        }

        @Override
        protected Task<Void> createTask() {
            return new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    if (startNumber == -1)startNumber = 0;
                    if (startNumber == 600)startNumber = 600;
                    for (int i = startNumber; i <=600 ; i++) {
                        updateMessage(Integer.toString(i));
                        Thread.sleep(1000);
                    }
                    Platform.runLater(()-> count2.setText("Over"));
                    return null;
                }
            };
        }
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }
}
