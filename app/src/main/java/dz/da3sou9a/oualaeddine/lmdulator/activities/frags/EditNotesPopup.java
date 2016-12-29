package dz.da3sou9a.oualaeddine.lmdulator.activities.frags;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableRow;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;

import dz.da3sou9a.oualaeddine.lmdulator.activities.mainUi.Launcher;
import dz.da3sou9a.oualaeddine.lmdulator.items.ModuleG;

public class EditNotesPopup extends Activity {

    boolean isClicked = true;
    PopupWindow popUpWindow;
    LayoutParams layoutParams;
    LinearLayout mainLayout;
    Button btnClickHere;
    LinearLayout containerLayout;
    TextView tvMsg;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        containerLayout = new LinearLayout(this);
        mainLayout = new LinearLayout(this);
        popUpWindow = new PopupWindow(this);


        btnClickHere = new Button(this);
        btnClickHere.setText("Click Here For Pop Up Window !!!");
        btnClickHere.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    popUpWindow.showAtLocation(mainLayout, Gravity.BOTTOM, 10, 10);
                    popUpWindow.update(50, 50, 320, 90);
                } else {
                        isClicked = true;
                    popUpWindow.dismiss();
                }
            }

        });

        tvMsg = new TextView(this);
        tvMsg.setText("Hi this is pop up window...");

        layoutParams = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
        containerLayout.setOrientation(LinearLayout.VERTICAL);
        containerLayout.addView(tvMsg, layoutParams);
        popUpWindow.setContentView(containerLayout);
        mainLayout.addView(btnClickHere, layoutParams);
        setContentView(mainLayout);

    }
}

