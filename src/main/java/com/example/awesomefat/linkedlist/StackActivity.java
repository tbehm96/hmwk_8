package com.example.awesomefat.linkedlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class StackActivity extends AppCompatActivity
{
    private Button popButton;
    private Button pushButton;
    private Button peekButton;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        ListCore.StackActivity = this;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack);

        //give us programmatic access to the buttons.
        this.peekButton = (Button)this.findViewById(R.id.peekButton);
        this.popButton = (Button)this.findViewById(R.id.popButton);
        this.pushButton = (Button)this.findViewById(R.id.pushButton);
        ListCore.theText = (EditText)this.findViewById(R.id.theText);
        LinearLayout scrollViewLL = (LinearLayout)this.findViewById(R.id.theScrollViewLL);

        ListCore.theStack = new Stack(scrollViewLL);
        ListCore.theStack.push("18");

    }

    public void aButtonClicked(View sender)
    {
        if(sender == this.peekButton)
        {
            System.out.println("**** peek button pressed");
            System.out.println(ListCore.theStack.peek());
        }
        else if(sender == this.popButton)
        {
            System.out.println("**** pop button pressed");
            System.out.println("popping:" + ListCore.theStack.pop().getPayload());
            ListCore.theStack.pop();
        }
        else if(sender == this.pushButton)
        {
            System.out.println("**** push button pressed");
            System.out.println("pushing:" + ListCore.theText.getText().toString());
            ListCore.theStack.push(ListCore.theText.getText().toString());
        }
        ListCore.theStack.display();
    }

}